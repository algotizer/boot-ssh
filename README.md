# boot-sftp

Boot tasks use clj-ssh to provide some common ssh task like `scp` `sftp` `ssh`.

## Usage

Run the `scp-to` task:

    $ boot scp-to

To use this in your project, add `[boot-ssh "0.1.0-SNAPSHOT"]` to your `:dependencies`
and then require the task:

    (require '[boot-ssh.core :refer [scp-to]])

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
