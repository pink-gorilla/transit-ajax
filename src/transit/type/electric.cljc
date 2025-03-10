(ns transit.type.electric
  (:require 
    [missionary.core :as m]
   )
  (:import 
        (missionary Cancelled)
        (hyperfiddle.electric Failure Pending Remote FailureInfo)
   ))



#_(def failure-writer (t/write-handler
                       (fn [_] "failure")
                       (fn [x]
                         (let [err (.-error ^Failure x)]
                           (cond (instance? Cancelled err) [:cancelled]
                                ;(instance? Pending err)   [:pending]
                                ;(instance? Remote err)    [:remote (ex-data err)]
                                 :else                     [:exception (ex-message err) (ex-data err)
                                                            (save-original-ex! err)])))))

#_(def failure-reader (t/read-handler
                       (fn [[tag & args]]
                         (case tag
                           :exception (let [[message data id] args]
                                        (Failure. (dbg/ex-info* message data id nil)))
                           :remote    (let [[data] args]
                                        (Failure. (dbg/ex-info* "Remote error" (or data {}))))
                           :pending   (Failure. (Pending.))
                           :cancelled (Failure. (Cancelled.))))))
