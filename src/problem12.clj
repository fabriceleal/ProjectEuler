(ns problem12)


; Lazy list of triangular nbrs ...
(defn triang  
  ([]
    (concat 1 (triang 2 1)))
  ([n sum] 
    (let [curr (+ n sum)]
      (lazy-seq (cons curr (triang (+ n 1) curr)))
  )))

; Lazy list of 
(first (filter #() (triang))) 