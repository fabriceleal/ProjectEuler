(ns problem03)

; Infinite decreasing stream, stop at 1
(defn lazy-stream [start]
  (if 
    (< start 2) 
    '()
    (lazy-seq (cons start (lazy-stream (- start 1))))))

; Test if two nbrs are divisible
(defn is-divisor-of [toTest nbr]
  (= 0 (mod nbr toTest)))

; Get lazy list of divisors of nbr
(defn divisors [nbr]
  (let [stream (lazy-stream (- nbr 1))]
    (lazy-seq (filter (fn[n](is-divisor-of n nbr)) stream))))

; Check if number is prime
(defn is-prime? [n]
  (nil? (first (divisors n))))
(def is-prime-main (memoize is-prime?))

; Find first greatest prime factor of number ...
(defn get-first-prime-factor [n]
  (first (filter is-prime? (divisors n))))

(get-first-prime-factor 600851475143) ; 600851475143