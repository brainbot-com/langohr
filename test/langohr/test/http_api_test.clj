(ns langohr.test.http-api-test
  (:require [langohr.http :as hc])
  (:use clojure.test))

(hc/connect! "http://127.0.0.1:55672" "guest" "guest")

;;
;; These tests are pretty basic and make sure we don't
;; have any obvious issues. The results are returns as
;; JSON responses parsed into Clojure maps.
;;

(deftest ^{:http-api true} test-get-overview
  (let [r (hc/get-overview)]
    (is (get-in r [:queue_totals :messages]))
    (is (get-in r [:queue_totals :messages_ready]))
    (is (get-in r [:queue_totals :messages_unacknowledged]))
    (is (get-in r [:queue_totals :messages_details :rate]))))

(deftest ^{:http-api true} test-list-nodes
  (let [r (hc/list-nodes)
        n (first r)]
    (is (coll? r))
    (doseq [keys [[:proc_total]
                  [:disk_free]
                  [:sockets_total]
                  [:sockets_used]]]
      (is (get-in n keys)))))

(deftest ^{:http-api true} test-list-extensions
  (let [r (hc/list-extensions)
        e (first r)]
    (is (get e :javascript))))

(deftest ^{:http-api true} test-list-definitoins
  (let [r           (hc/list-definitions)
        vhosts      (:vhosts r)
        exchanges   (:exchanges r)
        queues      (:queues r)
        bindings    (:bindings r)
        parameters  (:parameters r)
        policies    (:policies r)
        permissions (:permissions r)]
    (is (:rabbit_version r))
    (is (:name (first vhosts)))
    (is (:name (first queues)))
    (is (:name (first exchanges)))
    (is (:source (first bindings)))
    (is (:user (first permissions)))))

(deftest ^{:http-api true} test-list-connections
  (let [r (hc/list-connections)]
    (is (coll? r))))

(deftest ^{:http-api true} test-list-channels
  (let [r (hc/list-channels)]
    (is (coll? r))))

(deftest ^{:http-api true} test-list-exchanges
  (let [r (hc/list-exchanges)]
    (is (coll? r)))
  (let [r (hc/list-exchanges "/")]
    (is (coll? r))))

(deftest ^{:http-api true} test-get-exchange
  (let [r (hc/get-exchange "/" "amq.fanout")]
    (is (= r {:name "amq.fanout" :vhost "/" :type "fanout" :durable true :auto_delete false :internal false :arguments {}}))))

(deftest ^{:http-api true} test-declare-and-delete-exchange
  (let [s  "langohr.http.fanout"
        r1 (hc/declare-exchange "/" s :durable false :auto_delete true :internal false :arguments {})
        r2 (hc/delete-exchange "/" s)]
    (is (= true r1))
    (is (= true r2))))