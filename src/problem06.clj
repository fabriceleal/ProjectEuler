(ns problem06)

(refer 'problem03)

(let [naturals (lazy-stream 100 1)]
  (reduce -
          (list
            (reduce + (map (fn[n] (* n n)) naturals))
            (let [v (reduce + naturals)]
              (* v v)))))