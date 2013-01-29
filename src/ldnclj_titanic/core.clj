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
  (<- [?survived ?pclass ?name ?sex ?age ?sibsp ?parch ?ticket ?fare ?cabin ?embarked]
      (input :> ?line)
      (split-line ?line :> ?survived ?pclass ?name ?sex ?age ?sibsp ?parch ?ticket ?fare ?cabin ?embarked)))

(defn survivor-names [rows]
  (<- [?name]
      (rows :> "1" _ ?name _ _ _ _ _ _ _ _)))

(comment
  (use 'cascalog.playground) (bootstrap-emacs)
  (?- (stdout)
      (survivor-names (titanic (hfs-textline "/Users/bld/src/ldnclj-titanic/resource/train.csv" :skip-header? true)))))