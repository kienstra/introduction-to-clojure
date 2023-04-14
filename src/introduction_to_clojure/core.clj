(ns introduction-to-clojure.core
  (:require [bakery.core :refer :all]))

(defn add-egg []
  (grab :egg)
  (squeeze)
  (add-to-bowl))

(defn add-eggs [n]
  (dotimes [_ n]
    (add-egg))
  :ok)

(defn add-flour []
  (grab :cup)
  (scoop :flour)
  (add-to-bowl)
  (release))

(defn add-milk []
  (grab :cup)
  (scoop :milk)
  (add-to-bowl)
  (release))

(defn add-sugar []
  (grab :cup)
  (scoop :sugar)
  (add-to-bowl)
  (release))

(defn add-flour-cups [n]
  (dotimes [_ n]
    (add-flour))
  :ok)

(defn add-milk-cups [n]
  (dotimes [_ n]
    (add-milk))
  :ok)

(defn add-sugar-cups [n]
  (dotimes [_ n]
    (add-sugar))
  :ok)

(defn add-butter []
  (grab :butter)
  (add-to-bowl)
  :ok)

(defn add-butters [n]
  (dotimes [_ n]
    (add-butter))
  :ok)

(defn scooped? [ingredient]
  (cond
    (= ingredient :milk)
    true
    (= ingredient :flour)
    true
    (= ingredient :sugar)
    true
    :else
    false))

(defn squeezed? [ingredient]
  (= ingredient :egg))

(defn simple? [ingredient]
  (= ingredient :butter))

(defn add-scooped [ingredient n]
  (if (scooped? ingredient)
    (dotimes [_ n]
      (grab :cup)
      (scoop ingredient)
      (add-to-bowl)
      (release))
    (do
      (println "This function only works on scooped ingredients. You asked me to scoop" ingredient)
      :error)))

(defn add-squeezed [ingredient n]
  (if (squeezed? ingredient)
    (dotimes [_ n]
      (grab ingredient)
      (squeeze)
      (add-to-bowl))
    (do
      (println "This function only works on squeezed ingredients. You asked me to squeeze" ingredient)
      :error)))

(defn add-simple [ingredient n]
  (if (simple? ingredient)
    (dotimes [_ n]
      (grab ingredient)
      (add-to-bowl))
    (do
      (println "This function only works on simple ingredients. You asked me to add" ingredient)
      :error)))

(defn add [ingredient n]
  (cond
    (squeezed? ingredient)
    (add-squeezed ingredient n)
    (scooped? ingredient)
    (add-scooped ingredient n)
    (simple? ingredient)
    (add-simple ingredient n)
    :else
    (do
      (println "I do not know the ingredient" ingredient)
      :error)))

(defn bake-cake []
  (add :egg 2)
  (add :flour 2)
  (add :milk 1)
  (add :sugar 1)
  (mix)
  (pour-into-pan)
  (bake-pan 25)
  (cool-pan))
