(ns problem02)

;(def *mem* {
;            1 1
;            2 2
;            })

;(defn fibo [n]
;  (let [m (get *mem* n)]
;    (if (nil? m)
;      ; Calculate, store and return
;      (let [calc (+ (fibo (- n 1)) (fibo (- n 2)))]
;        calc
;        )
;      m
;      )))

; fibo (from http://stackoverflow.com/questions/3906831/how-do-i-generate-memoized-recursive-functions-in-clojure) 
(defn make-fibo []
  (with-local-vars
      [fib (memoize
            (fn [x]
              (if (<= x 3) 
                x
                (+ (fib (- x 1)) (fib (- x 2)))
                )))]
    (.bindRoot fib @fib)
    @fib))

; Lazy fibo (from http://www.ibm.com/developerworks/opensource/library/os-eclipse-clojure/)
(defn lazy-seq-fibo 
    ([] 
        (concat [1 2] (lazy-seq-fibo 1 2))) 
    ([a b] 
        (let [n (+ a b)] 
            (lazy-seq 
                (cons n (lazy-seq-fibo b n))))))

(reduce + (filter even? (take-while (fn[n](< n 4000000)) (lazy-seq-fibo))))


