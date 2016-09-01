(ns boot-ssh.core
  {:boot/export-tasks true}
  (:require [boot.core :as boot :refer [deftask]]
            [boot.util :as util]
            [clj-ssh.ssh :as ssh]))

(def ^:private
  +defaults+
  {:agent-opts {:use-system-ssh-agent false}
   :ip "localhost"
   :sources ["public"]
   :private-key-path nil
   :destination "~/"
   :options {:recursive true}
   :sess-opts {:strict-host-key-checking :no}})

(deftask scp-to
  "transfer local directories via scp"
  [i ip               IP              str       "hostname"
   s sources          SOURCES         [str]     "source paths"
   d destination      DESTINATION     str       "destination path"
   k private-key-path PRIV_KEY_PATH   str       "a path to the private key"
   e sess-opts        SESS_OPTS       {kw str}  "options which will pass to a Jsch's Session"
   o options          OPTIONS         {kw str}  "options which will pass to scp"
   a agent-opts       AGENT_OPTS      {kw str}  "options which will pass to a Jsch's Agent"]
  (fn middleware [next-task]
    (fn handler [fileset]
      (util/info "Start upload via scp.\n")
      (let [options (merge +defaults+ *opts*)]
        (next-task fileset)
        (let [agent   (ssh/ssh-agent (:agent-opts options))]
          (when (:private-key-path options)
            (util/info (str "using private key: " (:private-key-path options) ".\n"))
            (ssh/add-identity agent {:private-key-path (:private-key-path options)}))
          (let [session (ssh/session agent (:ip options) (:sess-opts options))]
            (ssh/with-connection session
              (apply ssh/scp-to session (:sources options) (:destination options) (flatten (into [] (:options options))))))))
      (util/info "Uploaded via scp.\n"))))
