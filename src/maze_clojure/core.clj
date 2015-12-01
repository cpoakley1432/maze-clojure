(ns maze-clojure.core
  (:gen-class))

(def size 10)

(defn create-rooms []
  (vec (for [row (range 0 size)]
         (vec (for [col (range 0 size)]
                {:row row, :col col, :visited? false,
                 :bottom? true, :right? true})))))

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
        (print "_|"))
      (println))))
