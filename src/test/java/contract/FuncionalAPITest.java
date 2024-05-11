package contract;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static enums.EnumsAPI.*;
import static io.restassured.RestAssured.given;

public class FuncionalAPITest {

@Test
@Description("Verifica arequisição")
    public void testDadoQueEnvioARequisicaoParaAPIEObtenhoResposta200() {
    TestApi testApi = new TestApi();
    testApi.verificaStatusApi();
}

@Test
@Description("register successful")
    public void testDadoQueMeRegistroNoSitemaQuandoInformoEmailESenhaEntaoTenhoSucesso() {
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
@Test
@Description("register unsuccessful")
    public void testDadoQueMeRegistroNoSitemaQuandoInformoSoEmailEntaoTenhoUmErro() {
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

@Test
@Description("login successful")
    public void testDadoQueQueroLogarNoSistemaQuandoEnvioUsuerPasswoedEntaoAcessoComSucesso() {
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

    @Test
    @Description("login unsuccessful")
    public void testDadoQueQueloLogarSoComEmailQuandoNaoInformoASenhaEntaoTenhoUmErro() {
        RestAssured.baseURI = "https://reqres.in";
        String token =
                given()
                        .body("{\"email\": \"peter@klaven\"}")
                        .contentType(ContentType.JSON)
                        .when()
                        .post( LOGINUNSUCCESSFUL .getUrl())
                        .then().statusCode(400)
                        .log().all()
                        .extract().path("data.token");

    }
}
