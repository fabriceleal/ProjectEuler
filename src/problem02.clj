(ns problem02)

(def *mem* )

(defn fib-dispatcher [n]
  ; If find in mem, return it
  ; Else, compute it
  )

(defn fib [n]
  (+ (fib-dispatcher (- n 1)) (fib-dispatcher (- n 2))))