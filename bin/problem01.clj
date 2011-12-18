(ns problem01)

; Aux function for multiples 
(defn aux-multiples [n i top soFar]
  (let [value (* n i)]
    (if (>= value top)
      soFar
      (aux-multiples n (+ 1 i) top (concat soFar (list value)))
    )))

; Generate multiples until 1000
(defn multiples [n]
  (aux-multiples n 1 1000 '()))

; Sum the items in the list of multiples of 3 and 5, remove duplicates
(apply + (distinct (concat (multiples 3) (multiples 5))))