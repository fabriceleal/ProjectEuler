(ns problem10)

; Generate list of prime number up to 2M
(refer 'problem03)

(defn sieve-eristh [under]
  (let [my-primes (range 2 under)]
    (loop [left-to-parse my-primes 
           parsed-list '()]
      (let [car (first left-to-parse)]
        (if (nil? car)
          parsed-list
          (let 
            [filtered (filter #(not= (mod % car) 0) left-to-parse)] 
            (recur filtered (concat parsed-list (list car)))))))))


(defn sieve-eristh-2 [under]
  (let [my-primes {}]
    (loop [i 2
           acc my-primes]
      ; Get next nbr. If is not marked, is prime, set to true ... set multiples to false
      (let [is-prime (get my-primes i true)
            multiples (take-while #(<= % under) (apply (fn this[x] (lazy-seq (cons x (this (+ x i))))) (list i)))] ; lazy list

          ; Mark as prime, mark multiples as not-primes, go to next
          ;else
          ; Mark as not-prime, go to next
          
        
        )
      
      )))

;(reduce + 
;        (filter is-prime? 
;                (lazy-stream-inc 2 2000000)))

;(ns tokenize
;  (:import (java.io BufferedReader FileReader)))

;(defn process-file [file-name line-func line-acc]
;  (with-open [rdr (BufferedReader. (FileReader. file-name))]
;    (reduce line-func line-acc (line-seq rdr))))

;(defn process-line [acc line]
;  (+ acc 1))

;(prn (process-file "primes.txt" process-line 0))