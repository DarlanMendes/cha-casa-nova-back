# #  # Use a imagem base do OpenJDK
# FROM eclipse-temurin:17.0.8.1_1-jdk-jammy

# COPY . .

# # Dê permissão de execução ao script
# RUN chmod +x wait-for-it.sh
# RUN ./mvnw clean install -DskipTests
# # ENTRYPOINT ["java", "-jar", "target/chacasanova-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT ["./wait-for-it.sh", "postgres:5432", "--", "java", "-jar", "target/chacasanova-0.0.1-SNAPSHOT.jar"]

# #CMD ["mvn", "spring-boot:run"]
# Use a imagem base do OpenJDK
FROM eclipse-temurin:17.0.8.1_1-jdk-jammy

# Copia todos os arquivos do diretório atual para o diretório de trabalho do container
COPY . .

# Dê permissão de execução ao script
RUN chmod +x wait-for-it.sh

# Executa o Maven para construir o projeto e pular os testes
RUN ./mvnw clean install -DskipTests

# Define o ponto de entrada da aplicação
ENTRYPOINT ["./wait-for-it.sh", "postgres:5432", "--", "java", "-jar", "target/chacasanova-0.0.1-SNAPSHOT.jar"]
