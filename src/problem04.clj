(ns problem04)

(refer 'problem03)

; Predicate is-palindrome
(defn is-palindrome? [n]
  (let [v (str n)
        once (reverse v)]
    (= once (reverse once))))

; Create lazy list of distinct pairs,
; from (999, 999) all the way down to (100, 100)

