(ns problem17)

(def *unities* {
                1 3 ;one
                2 3 ;two
                3 5 ;three
                4 4 ;four
                5 4 ;five
                6 3 ;six
                7 5 ;seven
                8 5 ;eight
                9 4 ;nine
                })

(def *tenths* 
  (conj {
			 10 3 ;ten
			 11 0 ;eleven
			 12 0 ;twelve
			 13 0 ;thirteen
			 14 0 ;fourteen
			 15 0 ;fifteen
			 16 0 ;sixteen
			 17 0 ;seventeen
			 18 0 ;eighteen
			 19 0 ;nineteen
			 }
       (vector )))

(def *hundreds* 
  { ;hundred (7)
	     100 (+ (get *unities* 1) 7)
	     200 (+ (get *unities* 2) 7)
	     300 (+ (get *unities* 3) 7)
	     400 (+ (get *unities* 4) 7)
	     500 (+ (get *unities* 5) 7)
	     600 (+ (get *unities* 6) 7)
	     700 (+ (get *unities* 7) 7)
	     800 (+ (get *unities* 8) 7)
	     900 (+ (get *unities* 9) 7)
  })

; thousand (8)