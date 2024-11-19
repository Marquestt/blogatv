<<<<<<< HEAD
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src

RUN chmod 777 mvnw

RUN ./mvnw package

RUN ls -l ./target

CMD ["java","-jar","target/blogatv-0.0.1-SNAPSHOT.war"]
=======
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src

RUN chmod 777 mvnw

RUN ./mvnw package

RUN ls -l ./target

CMD ["java", "-jar", "target/blogatv-0.0.1-SNAPSHOT.war"]
>>>>>>> 535d9ebea6059fcf3778d8a47e91d052330501e7
