(ns svg.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [net.cgrand.enlive-html :as html]))
;(use 'clojure.data.xml)

(def svg-data [:svg {:width  "100%" 
                    :height "100%"
                    :version "1.1"
                    :xmlns "http://www.w3.org/2000/svg"}
              [:rect {:x "10"
                      :y "10"
                      :height "100"
                      :width  "100"
                      :style "stroke:#ff0000; fill: #0000ff"}]])

(defn gen-rect []
  [:rect {:x (rand 100)
          :y (rand 100)
          :height (rand 100)
          :width  (rand 100)
          :style "stroke:#ff0000; fill: #0000ff"}])

(defn gen-rects [num-rects]
  (take num-rects (repeatedly gen-rect)))

(defn gen-rects-svg [num-rects]
  (html/html (vec (concat 
                   [:svg {:width  "100%" 
                          :height "100%"
                          :version "1.1"
                          :xmlns "http://www.w3.org/2000/svg"}]
                   (gen-rects num-rects)))))

;; (defn make-svg []
;;   (emit-str (sexps-as-fragment svg-data)))

(defn make-svg []
  (html/html svg-data))

(html/deftemplate svg-template "svg/svg.html"
  []
  [:title] (html/content "SVG playground")
  [:body]  (html/content "You should see an svg below.")
  [:body]  (html/append (gen-rects-svg 6)))


(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/picture" [] (svg-template))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
