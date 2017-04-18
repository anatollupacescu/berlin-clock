# README #

Implement the Berlin Clock: https://en.wikipedia.org/wiki/Mengenlehreuhr

### Feedback ###

* The code was 'not what they expected', no further feedback received.

### Instructions ###

To quickly test the app just run:

mvn clean test exec:java -Dexec.mainClass="com.test.App" -Dexec.args="16 38 11"

To make it interactive run:

mvn clean package

watch -n 1 java -cp target/berlinClock-1.0-SNAPSHOT.jar com.test.App
