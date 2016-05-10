FROM java:8
VOLUME /tmp
ADD botcanics-web-1.0.0-BUILD-SNAPSHOT.war botcanics-web-1.0.0-BUILD-SNAPSHOT.war
RUN sh -c 'touch /botcanics-web-1.0.0-BUILD-SNAPSHOT.war'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/botcanics-web-1.0.0-BUILD-SNAPSHOT.war"]