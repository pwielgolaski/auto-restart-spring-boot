#!/usr/bin/env bash

start() {
    echo "info.date : $(date)" > application.yml
    nohup java -jar auto-restart-spring-boot-1.0-SNAPSHOT.jar > auto-restart-spring-boot.console.$(date "+%Y.%m.%d-%H.%M.%S") &
}

stop() {
    PID=$(cat application.pid)
    kill $PID
}

restart() {
    stop
    start
}

case $1 in
start)
  start
   ;;
stop)
  stop
   ;;
restart)
  restart
   ;;
esac
