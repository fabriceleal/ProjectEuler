(ns problem03)

; Check if number is prime
(defn is-prime? [n]
  true)

(defn lazy-stream [start]
  (lazy-seq (cons start (lazy-stream (- start 1)))))

; Find first greatest prime factor of number ...
(defn get-first-prime-factor [n]
  n)


(get-first-prime-factor 600851475143)