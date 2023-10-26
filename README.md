# Crops-service
docker compose up --команда для поднятия проекта(бд: 5433, back: 8000).
Запускать в той же папке, что и сам файл docker-compose.yml

./src/main/resources/application.properties -- путь до файла конфига,
его не удалять

@Configuration
public class Config {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8001/api/v1/fields").build();
        //192.168.0.5
    }
}

Это файл configuration.config из src, вместо localhost нужно указать ip адресс вашей машины, 
чтобы сервис Crops мог корректно отправлять запросы сервису Fields, порт 8001 тоже может
отличаться, поэтому меняйте в случае необходимости.
Swagger: http://localhost:8002/swagger-ui/index.html
