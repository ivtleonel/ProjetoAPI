package objectApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static enums.EnumsAPI.*;
import static enums.EnumsAPI.LOGINUNSUCCESSFUL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isEmptyString;

public class ObjectApi {
    public void registerSuccessful() {

        RestAssured.baseURI = "https://reqres.in";
        String token =
                given()
                        .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}")
                        .contentType(ContentType.JSON)
                        .when()
                        .post(REGISTERSUCCESSFUL.getUrl())
                        .then().statusCode(200).assertThat().body("token", notNullValue()).body("token", not(isEmptyString()))
                        .log().all()
                        .extract().path("data.token");
    }

    public void registerUnsuccessful() {

        RestAssured.baseURI = "https://reqres.in";
        String token =
                given()
                        .body("{\"email\": \"eve.holt@reqres.in\"}")
                        .contentType(ContentType.JSON)
                        .when()
                        .post(REGISTERUNSUCCESSFUL.getUrl())
                        .then().statusCode(400)
                        .log().all()
                        .extract().path("data.token");
    }

    public void loginSuccessful() {

        RestAssured.baseURI = "https://reqres.in";
        String token =
                given()
                        .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
                        .contentType(ContentType.JSON)
                        .when()
                        .post(LOGINSUCCESSFUL.getUrl())
                        .then().statusCode(200).assertThat().body("token", notNullValue()).body("token", not(isEmptyString()))
                        .log().all()
                        .extract().path("data.token");
    }

    public void loginUnsuccessful() {
        RestAssured.baseURI = "https://reqres.in";
        String token =
                given()
                        .body("{\"email\": \"peter@klaven\"}")
                        .contentType(ContentType.JSON)
                        .when()
                        .post(LOGINUNSUCCESSFUL.getUrl())
                        .then().statusCode(400)
                        .log().all()
                        .extract().path("data.token");
    }
}
