(defproject svg "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [org.clojure/data.xml "0.0.8"]
                 [enlive "1.1.5"]
                 ;fhaes dependencies
                 [junit "4.8.1"]
                 [org.codehaus.plexus/plexus-utils "1.1"]
                 [uk.org.lidalia/sysout-over-slf4j "1.0.2"]
                 [org.slf4j/slf4j-api "1.6.1"]
                 [org.slf4j/slf4j-log4j12 "1.6.1"]
                 [org.apache.commons/commons-io "1.3.2"]
                 [com.miglayout/miglayout-swing "4.2"]
                 [org.swinglabs/swingx "1.6.1"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler svg.handler/app}
  :java-source-paths ["src/org"]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
