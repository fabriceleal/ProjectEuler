(ns problem20)

(defn fact [n]
  
  (loop [nbr n acc 1]
    (if (<= nbr 1)
      acc
      (recur (- nbr 1) (* acc nbr)))))



(reduce + (map #(- (int %) 48) (str (fact 100))))