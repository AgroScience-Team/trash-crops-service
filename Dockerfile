
# Используем базовый образ OpenJDK для выполнения Java приложения
FROM openjdk:17

# Устанавливаем директорию приложения внутри контейнера
WORKDIR /app

# Копируем JAR-файл в контейнер
COPY target/crops-0.0.1-SNAPSHOT.jar crops-0.0.1-SNAPSHOT.jar

# Определяем команду для запуска приложения при запуске контейнера
CMD ["java", "-jar", "crops-3.1.4.jar"]




