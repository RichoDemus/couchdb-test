FROM develar/java:8u45

COPY build/libs/couchdb-test-all.jar /couchdb-test-all.jar

ENTRYPOINT ["java","-jar","/couchdb-test-all.jar"]
