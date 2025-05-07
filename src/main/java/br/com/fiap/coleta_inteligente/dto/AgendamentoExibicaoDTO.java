package br.com.fiap.coleta_inteligente.dto;

import br.com.fiap.coleta_inteligente.model.Agendamento;

import java.time.LocalDate;

public record AgendamentoExibicaoDTO (
    int idAgendamento,
    LocalDate dataAgendamento,
    boolean statusAgendamento
){
    public AgendamentoExibicaoDTO(Agendamento agendamento){
        this(
                agendamento.getIdAgendamento(),
                agendamento.getDataAgendamento(),
                agendamento.isStatusAgendamento());
    }
}