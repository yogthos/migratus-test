(ns migratus-test.core
  (:require [migratus.core :as migratus]
            [clojure.java.jdbc :as sql]
            [clojure.java.io :as io]
            [clojure.java.classpath :as cp])
  (:import java.sql.Connection))

(def config
  {:store :database
   :db {:connection-uri
        "jdbc:postgresql://localhost/myapp_dev?user=db_user_name_here&password=db_user_password_here"}})

(defn parse-ids [args]
  (map #(Long/parseLong %) (rest args)))

(defn -main [ & args]
  (case (first args)
    "migrate"
    (if (> (count args) 1)
      (apply migratus/up config (parse-ids args))
      (migratus/migrate config))
    "rollback"
    (if (> (count args) 1)
      (apply migratus/down config (parse-ids args))
      (migratus/rollback config))))
