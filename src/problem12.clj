(ns problem12)

(refer 'problem03)

; Lazy list of triangular nbrs ...
(defn triang  
  ([]
    (triang 1))
  ([n]
    (lazy-seq (cons (reduce + (range 1 (inc n))) (triang (inc n))))))

; Lazy list of 
(defn find-first-over-x [v]
  (loop [ttt (triang 50000)]
    (let [head (first ttt)]
      (if (< v (count (divisors head)))
        head
        (recur (rest ttt))))))

(find-first-over-x 498) ; divisors don't include neither 1 nor the nbr itself 