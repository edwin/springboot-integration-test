# A Simple Spring Boot Integration Test 

This project is for testing how integration test is being automated on Jenkins, with a real mysql database and not in memory db such as H2.

## Test the project using Maven

```shell script
mvn failsafe:integration-test  -DMYSQL_URL=127.0.0.1
```

or

```
mvn verify -DMYSQL_URL=127.0.0.1
```