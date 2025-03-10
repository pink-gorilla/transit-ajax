(ns demo1
  (:require
   [tick.core :as t]
   [clojure.java.io :as io]
   [transit.io :refer [encode decode]]
   [transit.core :refer [write-transit read-transit]]
   [transit.type.tick :refer [add-tick-handlers!]])
  (:import
   javax.imageio.ImageIO))


(write-transit {:a 1 :b "b"})

(add-tick-handlers!)

(def data
  {:a 1 :b "b"
   :i (t/instant)
   :d (t/date)
   :dt (t/date-time)})

(type (t/instant))
(class (t/instant))

data

(-> data
    (write-transit)
    (read-transit))


(-> data
    (encode)
    (decode))


;; test the logging of unserializable data:

(def img (ImageIO/read (io/file "moon.jpg")))
img

(-> img (encode))

  


