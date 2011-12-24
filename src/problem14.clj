(ns problem14)

(defn function [arg]
  (loop [i arg acc '()]
    (let [concated (concat acc (list i))]
      (if (= i 1)
      concated
      (if (= 0 (mod i 2)) 
        (recur (/ i 2) concated)
        (recur (inc (* 3 i)) concated)
        )))))

(defn function-count [arg]
  (loop [i arg acc 1]
    (if (= i 1)
      acc
      (if (= 0 (mod i 2))
        (recur (/ i 2) (inc acc))
        (recur (inc (* 3 i)) (inc acc))
        ))))

(reduce   
  (fn[acc v] 
    (if (> (second v) (second acc))
      v
      acc))
  
  '(-1 -1)
  
  (map
    (fn[n] (list n (function-count n)))
    (range 2 1000000)))