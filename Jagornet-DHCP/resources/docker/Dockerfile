FROM java:8
VOLUME /tmp
ADD jdhcp-1.0.war app.war
RUN sh -c 'touch /app.war'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]