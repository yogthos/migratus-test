(defproject migratus-test "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [migratus "1.0.1"]
                 [proto-repl "0.3.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]]
  :plugins [[migratus-lein "0.5.3"]]
  ;:dev-dependencies [[proto-repl "0.3.1"]]
    :migratus
  {:store :database
   :migration-dir "migrations/"
   :db "jdbc:postgresql://localhost/myapp_dev?user=db_user_name_here&password=db_user_password_here"}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
