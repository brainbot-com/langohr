# Langohr, a feature-rich Clojure RabbitMQ client

Langohr is a [Clojure RabbitMQ client](http://clojurerabbitmq.info) that embraces [AMQP 0.9.1 Model](http://www.rabbitmq.com/tutorials/amqp-concepts.html).


## Project Goals

 * Embrace [AMQP 0.9.1 Model](http://www.rabbitmq.com/tutorials/amqp-concepts.html). Follow Java client's API conventions instead of inventing new overly opinionated ones
 * Be well documented. Use [Ruby amqp gem guides](http://rubyamqp.info) as a foundation.
 * Be well tested.
 * Error handling and recovery should be well covered
 * Support all of the RabbitMQ features, include [extensions to AMQP 0.9.1](http://www.rabbitmq.com/extensions.html).

We've learned a lot from ~ 4 years history of the [Ruby amqp
gem](http://rubyamqp.info) and [Bunny](http://rubybunny.info)
development and try to apply this experience to Langohr design.

## Project Anti-Goals

Here is what Langohr *does not* try to be:

 * A replacement for the RabbitMQ Java client
 * Sugar-coated API for task queues that hides all the AMQP machinery from the developer
 * A port of Ruby amqp gem to Clojure


## Artifacts

Langohr artifacts are [released to Clojars](https://clojars.org/com.novemberain/langohr). If you are using Maven, add the following repository
definition to your `pom.xml`:

``` xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With [Leiningen](http://leiningen.org):

``` clojure
[com.novemberain/langohr "1.0.0"]
```

With Maven:

``` xml
<dependency>
  <groupId>com.novemberain</groupId>
  <artifactId>langohr</artifactId>
  <version>1.0.0</version>
</dependency>
```


## Documentation & Examples

If you are only starting out, please see our [Getting Started guide](http://clojurerabbitmq.info/articles/getting_started.html).

[Documentation guides](http://clojurerabbitmq.info) are incomplete but most of the content is there:

 * [AMQP 0.9.1 Concepts](http://www.rabbitmq.com/tutorials/amqp-concepts.html)
 * [Conneciting To The Broker](http://clojurerabbitmq.info/articles/connecting.html)
 * [Queues and Consumers](http://clojurerabbitmq.info/articles/queues.html)
 * [Exchanges and Publishing](http://clojurerabbitmq.info/articles/exchanges.html)
 * [Bindings](http://clojurerabbitmq.info/articles/bindings.html)

The rest of the guides will be written eventually.

### API Reference

For existing users, there is [API reference](http://reference.clojurerabbitmq.info).


### Code Examples

Several code examples used in the guides are kept in [a separate Git repository](https://github.com/clojurewerkz/langohr.examples).

Our [test suite](https://github.com/michaelklishin/langohr/tree/master/test/langohr/test) also can be used for code examples.


## Supported Clojure Versions

Langohr is built from the ground up for Clojure 1.3+. The most recent
stable release is highly recommended.


## Supported RabbitMQ Versions

Langohr depends on RabbitMQ Java client 3.0.x and thus should work
with RabbitMQ versions 2.0 and later.


## Project Maturity

Langohr has been around since 2011 and is now a 1.0 project.

There are some improvements planned in 1.1 but overall, Langohr
is a battle tested library.



## Community

[Langohr has a mailing list](https://groups.google.com/forum/#!forum/clojure-rabbitmq). Feel free to join it and ask any questions you may have.

To subscribe for announcements of releases, important changes and so on, please follow [@ClojureWerkz](https://twitter.com/#!/clojurewerkz) on Twitter.


## Langohr Is a ClojureWerkz Project

Langohr is part of the group of libraries known as [ClojureWerkz](http://clojurewerkz.org), together with
[Monger](https://github.com/michaelklishin/monger), [Neocons](https://github.com/michaelklishin/neocons), [Elastisch](https://github.com/clojurewerkz/elastisch), [Quartzite](https://github.com/michaelklishin/quartzite) and several others.



## Continuous Integration

[![Continuous Integration status](https://secure.travis-ci.org/michaelklishin/langohr.png)](http://travis-ci.org/michaelklishin/langohr)


CI is hosted by [travis-ci.org](http://travis-ci.org)


## Development

Langohr uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against all supported Clojure versions using

    lein2 all test

Then create a branch and make your changes on it. Once you are done with your changes and all
tests pass, submit a pull request on Github.


## License

Copyright (C) 2011-2013 Michael S. Klishin

Double licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure) or
the [Apache Public License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
