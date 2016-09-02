(set-env! :source-paths #{"src"}
          :dependencies   '[[adzerk/bootlaces "0.1.13" :scope "test"]
                            [clj-ssh "0.5.14"]])

(require '[adzerk.bootlaces :refer :all])

(def project 'algotizer/boot-ssh)
(def +version+ "0.1.1-SNAPSHOT")
(bootlaces! +version+)

(task-options!
 pom {:project     project
      :version     +version+
      :description "transfer local directory via sftp/scp"
      :url         "https://github.com/algotizer/boot-ssh"
      :scm         {:url "https://github.com/algotizer/boot-ssh"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask release-snapshot
  "Release snapshot"
  []
  (comp (build-jar) (push-snapshot)))

(deftask release-release
  "Release release"
  []
  (comp (build-jar) (push-release)))

(deftask dev
  "Dev process"
  []
  (comp
    (watch)
    (pom)
    (jar)
    (install)))
