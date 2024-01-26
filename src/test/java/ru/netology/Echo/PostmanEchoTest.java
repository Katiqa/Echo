package ru.netology.Echo;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class PostmanEchoTest {
    @Test
    void ShouldTestDataPostman() {
        // Given - When - Then
        // Предусловия
        var data = "Hello";
        given()
            .baseUri("https://postman-echo.com")
            .body(data) // отправляемые данные (заголовки и query можно выставлять аналогично)
        // Выполняемые действия
        .when()
            .post("/post")
        // Проверки
        .then()
            .statusCode(200)
            .body("data", equalTo("Hello"));
    }
}