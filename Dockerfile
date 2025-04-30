# 빌드 스테이지
FROM maven:3.9.9-amazoncorretto-21 AS builder

WORKDIR /workspace/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .
RUN mvn package -DskipTests

# 실행 스테이지
FROM amazoncorretto:21

WORKDIR /app
COPY --from=builder /workspace/app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
