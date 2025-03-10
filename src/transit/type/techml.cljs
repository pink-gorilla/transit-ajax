(ns transit.type.techml
  (:require
   [tech.v3.dataset :as ds]
   ;[tech.v3.datatype.datetime :as dtype-dt]
   #_[java.time :refer [LocalDate Instant]]
   [transit.handler :refer [add-transit-io-handlers!]]))


(defn add-techml-dataset-handlers! []
  (add-transit-io-handlers!
   (ds/transit-read-handler-map)
   (ds/transit-write-handler-map)
   ))

#_(defn add-java-time-handlers!
  "Add handlers for java.time.LocalDate and java.time.Instant"
  []
  (add-transit-io-handlers! LocalDate "java.time.LocalDate"
                            dtype-dt/epoch-days->local-date
                            dtype-dt/local-date->epoch-days)
  (add-transit-io-handlers! Instant "java.time.Instant"
                            dtype-dt/epoch-milliseconds->instant
                            dtype-dt/instant->epoch-milliseconds))

