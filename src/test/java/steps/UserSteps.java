package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import data.DataYaml;
import org.junit.Assert;
import pages.*;

import java.util.HashMap;


public class UserSteps {

    private Home home = new Home ();
    private MenuHome menu = new MenuHome();
    private UsersGrid usersGrid = new UsersGrid();
    private UsersCreate usersCreate = new UsersCreate();
    private UsersShow usersShow = new UsersShow();
    private UsersEdit usersEdit = new UsersEdit();

    @Dado("que o usuário está no sistema Agapito Server")
    public void queOUsuarioEstaNoSistemaAgapitoServer() {

        home.openPage();
    }

    @E("o usuário escolhe o menu Usuários")
    public void oUsuarioEscolheOMenuUsuarios() {

        menu.clickUsers();
    }

    @E("o usuário clica no botão novo usuário")
    public void oUsuarioClicaEmNovoUsuario() {
        usersGrid.clickNewUsers();
    }

    @E("o usuário preenche o campo {string} com {string}")
    public void oUsuarioPreencheOCampoCom(String field, String value) throws InterruptedException  {
        usersCreate.fillField(field, value);

    }

    @Quando("o usuário clicar em salvar")
    public void oUsuarioClicarEmSalvar() {
        usersCreate.clickSave();
        usersCreate.setLastUser(usersShow.getCode());
    }

    @Então("o usuário deveria ver a mensagem \"(.*)\"")
    public void oUsuarioDeveriaVerAMensagem(String message) {

        Assert.assertEquals(message, usersShow.getNotice());
    }

    @E("o usuário clicar em voltar")
    public void oUsuarioClicarEmVoltar() {

        usersShow.clickBack();
    }

    @Quando("o usuário consultar o último usuário cadastrado")
    public void oUsuarioConsultarOUltimoUsuarioCadastrado() {
        usersGrid.clickShowUser(usersCreate.getLastUser());

    }

    @Então("o usuário deveria ver {string} com {string}")
    public void oUsuarioDeveriaVerCom(String field, String value) {
       String act = usersShow.fillField(field);
       Assert.assertEquals(value, act);
    }

    @Quando("o usuário editar o último usuário cadastrado")
    public void oUsuárioEditarOUltimoUsuarioCadastrado() {
        usersGrid.clickEditUser(usersCreate.getLastUser());

    }

    @E("o usuário preenche o campo {string} com {string} na Edição")
    public void oUsuarioPreencheOCampoComNaEdicao(String field, String value) {
        usersEdit.fillField(field, value);
    }

    @E("o usuário clicar em salvar na Edição")
    public void oUsuarioClicarEmSalvarNaEdicao() {
        usersEdit.clickSave();
}

    @Quando("o usuário deleta o último usuário cadastrado")
    public void oUsuarioDeletaOUltimoUsuarioCadastrado() {
        usersGrid.clickDeleteUser(usersCreate.getLastUser());
    }

    @E("o usuário confirma a deleção")
    public void oUsuarioConfirmaADelecao() {
        usersGrid.clickConfirmDelete();
    }

    @Então("o usuário não deveria ver o registro deletado")
    public void oUsuarioNaoDeveriaVerORegistroDeletado() {
        Assert.assertFalse(usersGrid.getShowButton(usersCreate.getLastUser()));
    }

    @Dado("que o usuário acabou de cadastrar o código {string}")
    public void queOUsuarioAcabouDeCadastrarOCodigo(String id) {
        usersCreate.setLastUser(id);

    }

    @Quando("o usuário criar um novo registro")
    public void oUsuarioCriarUmNovoRegistro() {
        HashMap map = new HashMap();
        map = DataYaml.getMapYamlValues("Academy", "Usuario");
        usersGrid.clickNewUsers();
        usersCreate.fillField("login", map.get("login").toString());
        usersCreate.fillField("nome completo", map.get("full_name").toString());
        usersCreate.fillField("email", map.get("email").toString());
        usersCreate.fillField("idade", map.get("age").toString());
        usersCreate.clickSave();
    }
}
