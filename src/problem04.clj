(ns problem04)

(refer 'problem03)

; Predicate is-palindrome
(defn is-palindrome? [n]
  (let [v (str n)
        once (reverse v)]
    (= once (reverse once))))

; Create lazy list of distinct pairs,
; from (999, 999) all the way down to (100, 100)

(reduce 
  max
  (mapcat 
  (fn[n]
    (let [res (* (first n) (second n))]
      (if (is-palindrome? res)
      (list res)
      '())))
  (let 
  [full (lazy-stream 999 100)]
	(distinct 
   (mapcat
	  (fn[n] 
	    (map
	        (fn[y] (sort (list n y))) 
	         full))
	  full)))))


