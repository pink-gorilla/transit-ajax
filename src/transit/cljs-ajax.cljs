(ns transit.cljs-ajax
  (:require
   [taoensso.timbre :refer-macros [debug info infof error]]
   [promesa.core :as p]
   [ajax.core] ; https://github.com/JulianBirch/cljs-ajax
   [transit.core :refer [decode]]
   ))

(defn GET
  [url params]
  (p/create
   (fn [resolve reject]
     (ajax.core/GET url
       (merge params
              {;:timeout         10000 
               :response-format (ajax.core/transit-response-format :json decode) ;; IMPORTANT!: You must provide this.
               :handler (fn [response]
                          (resolve response))
               :error-handler (fn [error]
                                (reject error))})))))

(ns ajax.promise
  (:require
   [promesa.core :as p]
   [ajax.core :as ajax]))

(defn wrap-promise
  [AJAX-TYPE url params]
  (p/create
   (fn [resolve reject]
     (AJAX-TYPE url
                (merge params
                       {:handler (fn [response]
                                   (resolve response))
                        :error-handler (fn [error]
                                         (reject error))})))))

(defn GET
  ([url] (GET url {}))
  ([url params] (wrap-promise ajax/GET url params)))

(defn POST
  ([url] (POST url {}))
  ([url params] (wrap-promise ajax/POST url params)))

(defn PUT
  ([url] (PUT url {}))
  ([url params] (wrap-promise ajax/PUT url params)))

(defn DELETE
  ([url] (DELETE url {}))
  ([url params] (wrap-promise ajax/DELETE url params)))
