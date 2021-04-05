#!/usr/bin/env bash

set -e

PLUGIN=mcplayground
SCRIPT_DIR=$(cd "$(dirname "$0")" ; pwd -P)

checkmark="\xe2\x98\x91"
cross="\xe2\x98\x92"

startred='\033[0;31m'
endcolor='\033[0m'
startgreen='\033[0;32m'

function echob {
    echo -e "\033[1m$1\033[0m"
}

build-server() {
    pushd "${SCRIPT_DIR}/../spigot" > /dev/null
    echob "building server.."
    MAVEN_OPTS="-Xmx2G" java -Xmx2G -jar BuildTools.jar
    popd > /dev/null
}

start() {
    pushd "${SCRIPT_DIR}/../spigot" > /dev/null
    echob "starting server.."
    java -Xms1G -Xmx2G -XX:+UseG1GC -jar spigot-1.16.5.jar nogui
    popd > /dev/null
}

build() {
    pushd "${SCRIPT_DIR}" > /dev/null
    echob "building .."
    mvn package && cp target/${PLUGIN}*.jar ../spigot/plugins/${PLUGIN}.jar &&
    popd > /dev/null
}

if type -t $1 &>/dev/null; then
    $1 ${@:2}
else
    echo "usage: $0 <goal> <optional-parameters>"
fi
