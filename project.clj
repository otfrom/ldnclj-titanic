(defproject ldnclj-titanic "0.1.0-SNAPSHOT"
  :description "London Clojurian attempt at the Kaggle Titanic Intro."
  :url "http://github.com/otfrom/ldnclj-titanic"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clojure-csv/clojure-csv "2.0.0-alpha1"]
                 [cascalog "1.10.0"]
                 [org.apache.hadoop/hadoop-core "1.1.1"]
                 [com.twitter/maple "0.2.5"]
                 [cascalog-more-taps "0.3.0"]
                 [cascalog-checkpoint "0.2.0"]
                 [cascalog-math "0.1.0"]
                 [org.clojure/math.numeric-tower "0.0.2"]
                 [com.ifesdjeen/cascading-cassandra "0.0.5"]
                 [org.apache.cassandra/cassandra-all "1.1.8"]
                 [org.clojure/tools.logging "0.2.3"]
                 [cheshire "5.0.0"]
                 [clj-time "0.4.4"]]
  :main ldnclj-titanic.core
  :uberjar-name "titanic.jar"
  :jvm-opts ["-Xmx8192m" "-Xss180k"]
  :repositories {"stuart" "http://stuartsierra.com/maven2"
                 "conjars" "http://conjars.org/repo"}
  :exclusions [org.apache.hadoop/hadoop-core
               org.apache.cassandra/cassandra-all]
  :profiles {:dev
             {:dependencies [[midje "1.4.0"]
                             [midje-cascalog "0.4.0"]
                             [com.stuartsierra/lazytest "1.2.3"]]}})
