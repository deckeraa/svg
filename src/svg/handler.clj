(ns svg.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [net.cgrand.enlive-html :as html]))
(use 'clojure.data.xml)

(html/deftemplate svg-template "svg/svg.html"
  [])

(defn make-svg []
  (emit-str (sexps-as-fragment 
             [:svg {:width  "100%" 
                    :height "100%"
                    :version "1.1"
                    :xmlns "http://www.w3.org/2000/svg"}
              [:rect {:x "10"
                      :y "10"
                      :height "100"
                      :width  "100"
                      :style "stroke:#ff0000; fill: #0000ff"}]])))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/picture" [] (make-svg))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
