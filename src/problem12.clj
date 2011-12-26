(ns problem12)

(refer 'problem03)
(refer 'problem05)

; Lazy list of triangular nbrs ...
(defn triang  
  ([]
    (triang 1 0))
  ([n]    
    (triang n (/ (* n (+ n 1)) 2))) 
  ([n acc]
    (let [newval (+ acc n)]
      (lazy-seq
        (cons newval
        (triang (inc n) newval))))))


; Counts the number of divisors that a number has.
; http://www.ehow.com/how_5169234_calculate-number-divisors.html
(defn count-divisors [x]
  (reduce
    *
    (map 
      (fn[x] (inc x)) 
      (vals (decompose-list (get-factors x))))))

; Lazy list of 
(defn find-first-over-x [v]
  (loop [ttt (triang 100000000000)]
    (let [head (first ttt)]
      (if (< v (count-divisors head))
        head
        (recur (rest ttt))))))

;(find-first-over-x 498) ; divisors don't include neither 1 nor the nbr itself 

