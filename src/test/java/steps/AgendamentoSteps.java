package steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AgendamentoSteps {

    private Response response;
    private int id;

    @Dado("o ID do agendamento é {int}")
    public void o_id_do_agendamento_e(int id) {
        this.id = id;
    }

    @Quando("eu faço uma requisição GET para \\/api\\/agendamentos\\/{int}")
    public void eu_faco_get_para_agendamentos(int id) {
        response = given().get("http://localhost:8080/api/agendamentos/" + id);
    }

    @Quando("eu faço uma requisição POST para \\/api\\/agendamentos com os dados válidos")
    public void eu_faco_post_para_agendamentos() {
        String json = """
        {
          "dataAgendamento": "2025-06-01",
          "statusAgendamento": true
        }
        """;
        response = given()
                .header("Content-Type", "application/json")
                .body(json)
                .post("http://localhost:8080/api/agendamentos");
    }

    @Então("o status da resposta deve ser {int}")
    public void o_status_da_resposta_deve_ser(int status) {
        response.then().statusCode(status);
    }

    @E("o corpo deve conter o campo {string}")
    public void o_corpo_deve_conter_campo(String campo) {
        response.then().body(campo, notNullValue());
    }

    @E("o JSON deve seguir o contrato definido")
    public void o_json_deve_seguir_contrato() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/agendamento.schema.json"));
    }
}