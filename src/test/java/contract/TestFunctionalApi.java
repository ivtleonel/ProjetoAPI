package contract;


import jdk.jfr.Description;
import objectApi.ObjectApi;
import objectApi.StatusApi;
import org.junit.Test;


public class TestFunctionalApi {
    ObjectApi obj = new ObjectApi();
    StatusApi testApi = new StatusApi();

    @Test
    @Description("Verifica arequisição")
    public void testDadoQueEnvioARequisicaoParaAPIEObtenhoResposta200() {
        testApi.verificaStatusApi();
    }

    @Test
    @Description("register successful")
    public void testDadoQueMeRegistroNoSitemaQuandoInformoEmailESenhaEntaoTenhoSucesso() {
        obj.registerSuccessful();

    }

    @Test
    @Description("register unsuccessful")
    public void testDadoQueMeRegistroNoSitemaQuandoInformoSoEmailEntaoTenhoUmErro() {
        obj.registerUnsuccessful();

    }

    @Test
    @Description("login successful")
    public void testDadoQueQueroLogarNoSistemaQuandoEnvioUsuerPasswoedEntaoAcessoComSucesso() {
        obj.loginSuccessful();

    }

    @Test
    @Description("login unsuccessful")
    public void testDadoQueQueloLogarSoComEmailQuandoNaoInformoASenhaEntaoTenhoUmErro() {
        obj.loginUnsuccessful();

    }
}
