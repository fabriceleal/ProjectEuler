(ns problem05)

(refer 'problem03)

(defn list-contains-items [listone listitems]
  "All in listitems should be in listone"
  (let [minor-head (first listitems)]
    (if (nil? minor-head)
      true
      (let 
        [contains (empty? (filter #(= % minor-head) listone))]
        (if contains          
          false     
          (recur listone (rest listitems))
          )))))

; find first nbr that has at least the numbers 1..20 as divisors
(defn infinite-stream
  ([] (infinite-stream 1))
  ([start] (lazy-seq (cons 1 (infinite-stream (inc start))))))

; Brute force by dividing, incrementing.
(defn get-first-with-divisors [start incr divs]
  (loop [s start]
    (let [real (divisors s)]
      (if (list-contains-items real divs)
        s
        (recur (+ incr s))
        ))))

; Brute force by multiplying :)
; If 20 is divisor, so it is 2 4 5 10
; 19 is prime
; If 18 is divisor, so it is 2 3 6 9
; 17 is prime
; If 16 is divisor, so it is 2 4 8
; if 15 is divisor, so it is 3 5
; If 14 is divisor so it is 2 7
; 13 is prime
; If 12 is divisor so it is 2 3 4 6
; 11 is prime

;(get-first-with-divisors 20 20 (reverse (range 10 21)))