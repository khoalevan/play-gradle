rm RUNNING_PID > /dev/null
JAVA_OPTS="-Dhttp.port=9011 -Dconfig.resource=application.production.conf" ./build/stage/main/bin/main