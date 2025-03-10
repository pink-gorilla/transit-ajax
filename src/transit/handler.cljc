(ns transit.handler
  (:require
   [cognitect.transit :as t]))

(defonce write-handlers-a (atom {} ))
(defonce read-handlers-a (atom {}))

(defn add-transit-io-handlers!
  ([read-handler-map write-handler-map]
   (swap! write-handlers-a merge write-handler-map)
   (swap! read-handlers-a merge read-handler-map))
  ([datatype tag read-fn write-fn]
   (swap! write-handlers-a assoc datatype (t/write-handler (constantly tag) write-fn))
   (swap! read-handlers-a assoc tag read-fn)))

