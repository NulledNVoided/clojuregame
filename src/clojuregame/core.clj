(ns clojuregame.core
  (:gen-class))

(def ^:dynamic *game* (atom {}))

(defmacro defcmd [name args body]
  `(def ~name (fn ~args
                (comparre-and-set! *game* @*game*
                                   ~body)
                (str (:response @*game*)))))


;world-map
(def world-top    "Reinfield.....TTTTTT........#######.")
(def world-one    "#########\\...TTTTTTTT_...._Reignhold")
(def world-two    "..........\\.TTTTTTTTT.\\../..........")
(def world-three  "...#######.\\T<Mystic>T.\\/.....TTTTT.")
(def world-four   "..#Filsweld-|T<forest>T|......TTTT..")
(def world-five   "..#########..\\TTTTTTTT/......TTT....")
(def world-six    "..#########...--------...######T....")
(def world-bottom "......................\\__Agan##.....")
(def legend       "<# - citylimits> </, \\, |, _ , -, - roads> <T - Tress> < . - openness>")
;postions
(def local-position "outside")
(def current-position "Filsweld")

;defining buildings
(defn Bar []())

;all maps
(defn Reinfield-map[]
  (do
    (println "#_________############<><><><><>>###########___________#")
    (println "|/////////|###########</Market//>##########|///////////|")
    (println "|///Bar///>###########</////////>5#########|///Bank////|")
    (println "|_________|###########<><><><><>>##########|///////////|")
    (println "#*****###1#############2##3###4############|__<>_______|")
    (println "############################################6###########")
    (println "########################################################")
    ))
(def Reinfield {:bar "Bar" :market "Market" :bank "Bank"})

(defn Filsweld-map[]
  (do(println "##################################____########2#########")
     (println "##______###______###______#######|Shed|#################")
     (println "#|//////|#|//////|#|//////|*#####|_>__|######__________#")
     (println "#|House1|#|House2|#|House3|*1###############|//////////|")
     (println "#|____>_|#|____>_|#|____>_|*################|//Hotel///|")
     (println "############################################<//////////|")
     (println "###########################################3|__________|")
     (println "###_____>_##______############4#########################")
     (println "##|///////||Armory|#####<><><><><>>#####################")
     (println "##|//Bank/||//////|#####</////////>5####################")
     (println "##|///////||______|#####<//Market/>#####################")
     (println "##|_______|#############<><><><><>>######7#________#####")
     (println "##############################6###########<////////|####")
     (println "###|quest|###89###______________##########</Stable/|####")
     (println "###|board|#######|/////Jail/////|#########<________|####")
     (println "#################|______________|#######################")
     ))

(defn Reignhold-map []
  (do(println "####################__________################")
     (println "###################|//////////|#####********##")
     (println "####________#######|Coal//Mine|#####**Over**##")
     (println "###|Abandon/|######|<><><><><>|#####*Growth*##")
     (println "###|/////ed/|#######################********##")
     (println "###|/House//|#################################")
     (println "###|________|#################################")
     (println "##############################################")
     ))

(defn Mystic_forest-map[]
  (do(println ".........TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT........")
     (println ".......TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT.......")
     (println "......TTTTTTTTTTT<>TTTTTTTTTTTTTTTTTTTTTTTTTT```````````TTTTTTTTT......")
     (println ".....TTTTTTTT<<><><><>TTTTTTTTTTTTTTTTTTTTTT```field`````TTTTTTTTTT....")
     (println "...TTTTTTTTTT<><hole><>######################T``````````TTTTTTTTTTT....")
     (println "...TTTTTTTTTTT<<><><>>TTTTTTTTTTTTTTTTTTTTTT#TTTTTTTTTTTTTTTTTTTTTT....")
     (println "..TTTTTTTTTTTTT<><><>TTTTTTTTTTTTTTTTTTTTTTT#TTTTTTTTTTTTTTTTTTTTTT....")
     (println "#.TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT###########################")
     (println "#...TTTTTTTTTTTTTTTTTTTTTTTTTTTT#############TTTTT#TTTTTTTTTTTTTTTTTT..")
     (println "#....TTTTTTTTTTTTTTTTTTTTTTTTTTT#TTTTTTTTTTTTTTTTT########TTTTTTTTTTT..")
     (println "#...TTTTTTTTTTTTTTTTTTTTTTTTTTTT#TTTTTTTTTTTTTTTTTTTTT|<><><>>|TTTTTTTT")
     (println "#...TTTTTTTTTT~~~~~~~~~~TTTTTTTT#TTTTTTTTTTTTTTTTTTTTT|//Cave/|TTTTTTT.")
     (println "#...TTTTTTTTT~~~~pond~~~~TTTTTTT#TTTTTTTTTTTTTTTTTTTTT|_______|TTTT....")
     (println "#....TTTTTTTTTT~~~~~~~~~TTTTTTTT#TTTTT_________TTTTTTTTTTTTTTTTTTTT...#")
     (println "#....TTTTTTTTTTTTTTTTT###########TTTT|//cabin//|TTTTTTTTTTTTTTTTTT...#.")
     (println "#......TTTTTTTTTTTTTTTTTTTTTTTTT#####</////////|TTTTTTTTTTTTTTTT....#..")
     (println "#......TTTTTTTTTTTTTTTTTTTTTTTTTTTTTT|_________|TTTTTTTTTTTTTTT....#...")
     (println "#......TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT...#....")
     ))

(defn Agan-map []
  (do (println "##############################################")
      (println "#<Wizard-trainer>###########<Tank-trainer>####")
      (println "##############################################")
      (println "#<Archer-trainer>###########<Paladin-trainer>#")
      (println "##############################################")
      (println "#<Fighter-trainer>##########<><><><><><>######")
      (println "############################<//Market//>######")
      (println "#<Rouge-Trainer>############<><><><><><>######")
      (println "##############################################")
      ))

(defn construction-msg []
  (do(println "Sorry this room's map is underconstruction. Please visit later")))
;user controlled functions
(defn controls []
  (do(println " Type (world) to see the world map")
     (println " Type (travel \"place name\")")
     (println " Type (current) to see where you are")
     (println " Type (controls) if you forgot what to type)")))

(defn world-map [x]
  (if (= x 1)
    (do(println world-top)(println world-one)(println world-two)(println world-three)(println world-four)(println world-five)(println world-six)(println world-bottom)(println "")(println legend))
    (println "You are in the map")))

(defn travel [x]
  (if (contains? #{ "Reinfield" "Reignhold" "Filsweld" "Mystic Forest" "Agan"} x)
    (do(alter-var-root #'current-position (constantly x)) (println (str "You are in " current-position))
       (if (= current-position "Reinfield")
         (Reinfield-map)
         (if (= current-position "Reignhold")
          (Reignhold-map)
          (if (= current-position "Filsweld")
            (Filsweld-map)
            (if (= current-position "Mystic Forest")
              (Mystic_forest-map)
              (if (= current-position "Agan")
                (Agan-map)
                (println "Please choose a city name")))))))))

(defn enter [x]
  (if (and (= current-position "Reinfield")(= local-postion "Outside"))
    (if (= x "Bar")
      (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
      (if (= x "Market")
        (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construstion-msg))
        (if (= x "Bank")
          (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg)
          ((println (str "Sorry, not a place in " current-position ".") "Please pick from the places on the map.")(Reinfield-map))))))
    (if (and (= current-position "Reignhold")(= local-position "Outside"))
      (if (= x "Abandoned House")
        (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
        (if (= x "Coal Mine")
          (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construstion-msg))
          (if (= x "Over Growth")
            (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
            ((println (str "Sorry, not a place in " current-position ".") "Please pick from the places on the map.")(Reignhold-map)))))
      (if (and (= current-postion "Filsweld")(= local-position "Outside"))
        (if (= x "House1")
          (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
          (if (= x "House2")
            (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
            (if (= x "House3")
              (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
              (if (= x "Bank")
                (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                (if (= x "Jail")
                  (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                  (if (= x "Armory")
                    (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                    (if (= x "Market")
                      (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                      (if (= x "Quest Board")
                        (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                        (if (= x "Shed")
                          (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                          (if (= x "Hotel")
                            (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                            (if (= x "Stable")
                              (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                              ((println (str "Sorry, not a place in " current-position ".") "Please pick from the places on the map.")(Filsweld-map)))))))))))))
        (if (and (= current-postion "Mystic Forest")(= local-position "Outside"))
          (if (= x "Hole")
            (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
            (if (= x "Pond")
              (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
              (if (= x "Cabin")
                (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                (if (= x "Field")
                  (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                  (if (= "Cave")
                    (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                    ((println (str "Sorry, not a place in " current-position ".") "Please pick from the places on the map.")(Filsweld-map)))))))
          (if (and (= current-position "Agan")(= local-position "Outside"))
            (if (= x "Archer-Trainer")
              (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
              (if (= x "Wizard-Trainer")
                (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                (if (= x "Fighter-Trainer")
                  (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                  (if (= x "Rogue-Trainer")
                    (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                    (if (= x "Tank-Trainer")
                      (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                      (if (= x "Paladin-Trainer")
                        (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                        (if (= x "Market")
                          (do(alter-var-root #'local-position (constantly x))(println (str "You are in the " local-position))(construction-msg))
                          ((println (str "Sorry, not a place in " current-position ".") "Please pick from the places on the map.")(Agan-map)))))))))
            (if-not (= local-position "Outside")
              (println "Please exit the place you are currently in."))))))))

(defn exit []
  (do(alter-var-root #'local-position (constantly "Outside"))(println (str "You are " local-position))))
          
          

(defn world []
  (do(world-map 1)(println " ")(println(str "Currently in " current-position))))

(defn current[]
  (travel current-position))

(defn -main
  [& args](do
  (println "Welcome to Jon's Quester:")
  (controls)))

(-main)

