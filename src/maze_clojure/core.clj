(ns maze-clojure.core
  (:gen-class))

(def size 10)

(defn create-rooms []
  (vec (for [row (range 0 size)]
         (vec (for [col (range 0 size)]
                {:row row, :col col, :visited? false,
                 :bottom? true, :right? true})))))

(defn possible-neighbors [rooms row col]
  [(get-in rooms [(- row 1) col])
   (get-in rooms [(+ row 1) col])
   (get-in rooms [row (- col 1)])
   (get-in rooms [row (+ col 1)])])

(defn -main [& args]
  (let [rooms (create-rooms)]
    ; print top walls
    (doseq [row rooms]
      (print " _"))
    (println)
    ; print grid
    (doseq [row rooms]
      ;print left walls
      (print "|")
      (doseq [room row]
        (print (str (if (:bottom? room) "_" " ")
                    (if (:right? room) "|" " "))))
      (println))))
