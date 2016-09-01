# boot-sftp

A Boot task to do many wonderful things.

## Usage

FIXME: explanation

Run the `scp-to` task:

    $ boot scp-to -s README.md -d /usr/share/nginx/html

To use this in your project, add `[boot-ssh "0.1.0-SNAPSHOT"]` to your `:dependencies`
and then require the task:

    (require '[boot-ssh.core :refer [scp-to]])

## License

Copyright © 2016 Algotizer

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
