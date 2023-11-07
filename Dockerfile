FROM eclipse-temurin:11
RUN mkdir /opt/app
COPY target/clients-3.1.5.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]