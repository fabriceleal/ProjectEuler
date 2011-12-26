(ns problem05)

(refer 'problem03)
(refer 'problem16)

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

; Brute force by dividing, incrementing. Forget this.
;(defn get-first-with-divisors [start incr divs]
;  (loop [s start]
;    (let [real (divisors s)]
;      (if (list-contains-items real divs)
;        s
;        (recur (+ incr s))
;        ))))

; Brute force by multiplying :)
; Test periodicity of the divisory properties of the other tests (11 for instance). 
; Use increments of it to generate new numbers.

; If 20 is divisor, so it is 2 4 5 10. Although the numbers generated are all multiples of 20, test just to skip 2, 4, 5 and 10
; 19 is prime
; If 18 is divisor, so it is 2 3 6 9
; 17 is prime
; If 16 is divisor, so it is 2 4 8
; if 15 is divisor, so it is 3 5 
; If 14 is divisor so it is 2 7
; 13 is prime
; If 12 is divisor so it is 2 3 4 6
; 11 is prime

;(get-first-with-divisors 20 20 (list 20 19 18 17 15 16 14 13 12 11))

(defn serial-factorization [nbrs]
  (loop [to-parse nbrs acc '()]
    (let [head (first to-parse)]
      (if (nil? head)
        acc
        (recur (rest to-parse) (concat acc (list (get-factors head))))))))

(serial-factorization '(11 12 13 14 15 16 17 18 19 20))

(defn remove-first [list-items to-chop]
  (let [i 0]
    (filter 
      #(and (= i 0) (= % to-chop)) 
      list-items)))

; Unfinished, might be usefull
;(defn put-in-evidence [list-items]
;  (loop [to-parse list-items evidence '()]
;    ; Use 1st list as base. It should be the shortest.
;    ; As soon as it is empty, there are no more common items
;    (let [find-me (first (first to-parse))]
;      (if (nil? find-me)
;        (list (list evidence) (list to-parse)) 
;        ; Try to find if find-me occur in all lists. 
;        ; If it does, remove one instance of all lists and resume processing ...
;        
;        ))))

(defn decompose-list 
  ([list-items] 
    (decompose-list list-items {}))
  ([list-items default-acc]
    (loop [to-parse list-items acc default-acc]
      (let [head (first to-parse)]
        (if (nil? head)
          acc
          (recur 
            (filter #(not= % head) to-parse) 
            (assoc 
              acc 
              head 
              (max 
                (count (filter #(=% head) to-parse)) 
                (get acc head 0)))))
        ))))

; Make hash, prime => count, with the max ocorrences of a number in a list
(defn decompose [list-list-items]
  (loop [ret-hash {} to-parse list-list-items]
    (let [head (first to-parse)]
      (if (nil? head)
        ret-hash
        (recur (decompose-list head ret-hash) (rest to-parse))))))


; http://en.wikipedia.org/wiki/Least_common_multiple
(reduce 
  (fn[acc v] (* acc (power (first v) (second v)))) ; 
  1
  (map 
    (fn[n] n) 
    (decompose (serial-factorization (range 2 21)))))

; This is not an implementation of the lcm algorithm.
; Reduce the result by multipliying all the items on the list

;(reduce * (mapcat (fn[n] n) (serial-factorization (list 10 9 8 7 6))))
;(reduce * (mapcat (fn[n] n) (serial-factorization (range 2 20))))
;(reduce * (mapcat (fn[n] n) (serial-factorization '(11 12 13 14 15 16 17 18 19 20))))