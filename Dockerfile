FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY target/clients-3.1.5.jar /opt/app/japp.jar
EXPOSE 8080:8080
CMD ["java", "-jar", "/opt/app/japp.jar"]