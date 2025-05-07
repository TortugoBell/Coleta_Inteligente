package features;

public class agendamento {
    Feature: API de Agendamentos

    Scenario: Buscar um agendamento existente com sucesso
    Given o ID do agendamento é 1
    When eu faço uma requisição GET para /api/agendamentos/1
    Then o status da resposta deve ser 200
    And o corpo deve conter o campo "idAgendamento"
    And o JSON deve seguir o contrato definido

    Scenario: Criar um novo agendamento com sucesso
    When eu faço uma requisição POST para /api/agendamentos com os dados válidos
    Then o status da resposta deve ser 201
    And o corpo deve conter o campo "dataAgendamento"

    Scenario: Buscar um agendamento inexistente
    Given o ID do agendamento é 9999
    When eu faço uma requisição GET para /api/agendamentos/9999
    Then o status da resposta deve ser 500

}
