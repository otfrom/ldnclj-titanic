(ns ldnclj-titanic.core
  (:require [cascalog.ops :as ops]
            [cascalog.tap :as tap]
            [clojure-csv.core :as csv]
            [cascalog.math.stats :as cstats])
  (:use cascalog.api
        [cascalog.more-taps :only (hfs-delimited)]
        [clojure.tools.logging]))

(defn split-line [line]
  (first (csv/parse-csv line)))

(defn titanic [input]
  (<- [?pclass ?name ?sex ?age ?sibsp ?parch ?ticket ?fare ?cabin ?embarked]
      ((hfs-textline "/Users/bld/src/ldnclj-titanic/resource/test.csv" :skip-header? true) :> ?line)
      (split-line ?line :> ?pclass ?name ?sex ?age ?sibsp ?parch ?ticket ?fare ?cabin ?embarked)))


(comment
  (use 'cascalog.playground) (bootstrap-emacs)
  (?- (stdout)
      (titanic (hfs-textline "/Users/bld/src/ldnclj-titanic/resource/test.csv" :skip-header? true)))
  )