#!/usr/bin/env zsh

SRCFILE="plu.txt"

createXML () {
    echo '<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>'

    echo '<plulist>'

    gsed -n 's/^• \([^()]\+\) (\([[:digit:]]\+\))$/\t<plu name=\"\1\" value=\"\2\" \/>/p' "$SRCFILE"

    echo '</plulist>'

}


createCSV () {
    gsed -n 's/^• \([^()]\+\) (\([[:digit:]]\+\))$/\1\t\2/p' "$SRCFILE"


}

createCSV;