(ns demo1
  (:require
   [tick.core :as t]
   [transit.io :refer [encode decode]]
   [transit.core :refer [write-transit read-transit]]
   [transit.type.tick :refer [add-tick-handlers!]]))


(write-transit {:a 1 :b "b"})

(add-tick-handlers!)

(def data
  {:a 1 :b "b"
   :i (t/instant)
   :d (t/date)
   :dt (t/date-time)})

data

(-> data
    (write-transit)
    (read-transit))


(-> data
    (encode)
    (decode))

