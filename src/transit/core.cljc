(ns transit.core
  (:require
   [cognitect.transit :as transit]
   [transit.io :refer [encode decode read-opts write-opts]])
  #?(:clj (:import [java.io ByteArrayInputStream ByteArrayOutputStream])))

#?(:clj
   (defn write-transit [data]
     (let [out (ByteArrayOutputStream. 4096)
           writer (transit/writer out :json (write-opts))]
       (transit/write writer data)
       (.toString out))))

#?(:cljs
   (defn write-transit [data]
     (let [writer (transit/writer :json (write-opts))]
       (transit/write writer data))))


#?(:clj
   (defn string->stream
     ([s] (string->stream s "UTF-8"))
     ([s encoding]
      (-> s
          (.getBytes encoding)
          (ByteArrayInputStream.)))))

#?(:clj
   (defn read-transit [json]
     (let [in (string->stream json)
           reader (transit/reader in :json (read-opts))]
       (transit/read reader))))

#?(:cljs
   (defn read-transit [data]
     (let [reader (transit/reader :json (read-opts))]
       (transit/read reader data))))

#?(:clj
   (defn spit-transit [filename data]
     (->> (write-transit data)
          (spit filename))))

#?(:clj
   (defn slurp-transit [filename]
     (let [json (slurp filename)]
       (read-transit json))))
