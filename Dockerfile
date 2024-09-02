#  # Use a imagem base do OpenJDK
 FROM eclipse-temurin:17.0.8.1_1-jdk-jammy

# # Configurar o diretório de trabalho
#  WORKDIR /app

#  # Copiar o arquivo JAR da aplicação para o contêiner
#  COPY target/chacasanova-0.0.1-SNAPSHOT.jar app.jar

#  # Expõe a porta da aplicação
#  EXPOSE 8080

#  # Comando para executar a aplicação
#  CMD ["java", "-jar", "app.jar"]
 #ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=prod -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
# FROM eclipse-temurin:17-jdk-focal

# WORKDIR /app

# COPY .mvn/ mvn
# COPY mvnw pom.xml ./
# RUN ./mvnw dependency:go-offline

# COPY src ./src

# CMD ["./mvn", "spring-boot:run"]
#FROM maven:3.8.5-openjdk-17

#WORKDIR /app
COPY . .
#RUN mvn clean install
RUN ./mvnw clean install -DskipTests
ENTRYPOINT ["java", "-jar", "target/chacasanova-0.0.1-SNAPSHOT.jar"]
#CMD ["mvn", "spring-boot:run"]