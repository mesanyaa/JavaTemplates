# Используем базовый образ с Java
FROM openjdk:17-slim-buster

# Указываем рабочую директорию
WORKDIR /app

# Копируем jar-файл в контейнер
COPY app.jar app.jar

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
