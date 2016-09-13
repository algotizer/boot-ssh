# boot-ssh

Boot tasks use clj-ssh to provide some common ssh tasks like `scp` `sftp` `ssh`.

[![Dependencies Status](https://jarkeeper.com/algotizer/boot-ssh/status.svg)](https://jarkeeper.com/algotizer/boot-ssh)
[![Downloads](https://jarkeeper.com/algotizer/boot-ssh/downloads.svg)](https://jarkeeper.com/algotizer/boot-ssh)

[![Clojars Project](https://img.shields.io/clojars/v/algotizer/boot-ssh.svg)](https://clojars.org/algotizer/boot-ssh)

## Usage

Run the `scp-to` task:

    $ boot scp-to

To use this in your project, add `[boot-ssh "0.1.1-SNAPSHOT"]` to your `:dependencies`
and then require the task:

    (require '[boot-ssh :refer [scp-to]])

and then setup

    (task-options!
      scp-to {:ip "12.12.12.12"
              :sess-opts {:username "user"
                          :password "password"
                          :strict-host-key-checking :no}
              :sources ["target/"]
              :destination "/somewhere/on/remote/server/"})

## License

Copyright © 2016 Algotizer

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
