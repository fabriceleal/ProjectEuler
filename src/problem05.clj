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

(defn get-first-with-divisors [start divs]
  (loop [start 1]
    (let [real (divisors start)]
      (if (list-contains-items real divs)
        start
        (recur (inc start))
        ))))

;(get-first-with-divisors 2 (range 2 11))
(get-first-with-divisors 20 (reverse (range 2 20)))
