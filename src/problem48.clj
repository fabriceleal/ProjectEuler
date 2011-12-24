(ns problem48)

(refer 'problem16)

(let [sum-as-str 
      (str (reduce
						  +
						  (map
						    (fn[x] (power x x))
						    (range 1 1001))))
      len (.length sum-as-str)]
  (.substring sum-as-str (- len 10) len)
  )
