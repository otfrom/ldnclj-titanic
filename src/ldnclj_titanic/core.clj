(ns ldnclj-titanic.core
  (:require [cascalog.workflow :as w]
            [clojure.string :as string]
            [cascalog.ops :as ops]
            [cascalog.tap :as tap]
            [cascalog.math.stats :as cstats]
            [clojure.math.numeric-tower :as math]
            [cheshire.core :as json])
  (:use cascalog.api
        [cascalog.more-taps :only (hfs-delimited)]
        [clojure.tools.logging]))


