FROM java:openjdk-8-jdk
ADD auth.jar /opt/auth/
EXPOSE 8081
WORKDIR /opt/auth/
CMD ["java", "-Xms256m", "-Xmx512m", "-jar", "auth.jar"]