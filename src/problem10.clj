(ns problem10)

; Generate list of prime number up to 2M
(refer 'problem03)

(defn primes-iteration [ls transformed]
  ; Get first element at ls (it is prime)
  ; put in transformed
  ; Remove all multiples of elem in ls (including elem)
  ; Next iteration
  ; Return transformed
  (let [head (first ls)]
    (if (nil? head)
      transformed
      (primes-iteration
        (filter #(not (is-divisor-of head %)) ls)
        (concat transformed (list head))
        ))))

(defn primes [top]
  ; Generate full list
  (let [full (lazy-stream-inc 2 top)]
    ; Use 
    (primes-iteration full '())))

(reduce + (primes 2000000))