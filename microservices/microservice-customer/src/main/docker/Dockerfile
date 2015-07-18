FROM java:openjdk-8-jdk
ADD customer.jar /opt/customer/
EXPOSE 8080
WORKDIR /opt/customer/
CMD ["java", "-Xms512m", "-Xmx1g", "-jar", "customer.jar"]