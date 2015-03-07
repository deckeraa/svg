(ns svg.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [net.cgrand.enlive-html :as html]))

;;; SVG Generation code

(def hex-digit-seq ["0" "1" "2" "3" "4" "5" "6" "7" "8" "9" "a" "b" "c" "d" "e" "f"])

(defn rand-color []
  (apply str "#" (repeatedly 6 #(rand-nth hex-digit-seq))))

(defn gen-rect []
  [:rect {:x (rand 100)
          :y (rand 100)
          :height (rand 100)
          :width  (rand 100)
          :style (apply str "stroke:" (rand-color) "; fill: " (rand-color))}])

(defn gen-rects [num-rects]
  (take num-rects (repeatedly gen-rect)))

(defn gen-rects-svg [num-rects]
  (html/html (vec (concat 
                   [:svg {:width  "100%" 
                          :height "100%"
                          :version "1.1"
                          :xmlns "http://www.w3.org/2000/svg"}]
                   (gen-rects num-rects)))))

(html/deftemplate svg-template "svg/svg.html"
  []
  [:title] (html/content "SVG playground")
  [:body]  (html/content "You should see an svg below.")
  [:body]  (html/append (gen-rects-svg 6)))


;;; Compojure code

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/picture" [] (svg-template))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
