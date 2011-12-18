(ns problem16
  (:require clojure.contrib.math))

(defn power [base exp]
  (cond
    (= exp 0) 1
    (= exp 1) base
    (= 1 1) (if (= 0 (mod exp 2))
	    (let [parcial (power base (/ exp 2))]
	      (* parcial parcial))
	    (let [parcial (power base (/ (- exp 1) 2))]
	      (* parcial parcial base)))))

(reduce + (map (fn[n] (- (int n) 48)) (str (power 2 1000))))