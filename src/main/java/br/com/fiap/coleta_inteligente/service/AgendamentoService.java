package br.com.fiap.coleta_inteligente.service;

import br.com.fiap.coleta_inteligente.dto.AgendamentoExibicaoDTO;
import br.com.fiap.coleta_inteligente.model.Agendamento;
import br.com.fiap.coleta_inteligente.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento agendar(Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }

    public AgendamentoExibicaoDTO buscaPorId (int idAgendamento){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findByIdAgendamento(idAgendamento);
        if (agendamentoOptional.isPresent()){
            return new AgendamentoExibicaoDTO(agendamentoOptional.get());
        } else {
            throw new RuntimeException("Agendamento não encontrado.");
        }
    }

    public List<Agendamento> buscarPorData (LocalDate dataInicial, LocalDate dataFinal){
        return agendamentoRepository.findByDataAgendamentoBetween(dataInicial,dataFinal);
    }

    public List<Agendamento> listarTodosOsAgendamentos(){
        return agendamentoRepository.findAll();
    }

    public void excluirAgendamento (int idAgendamento){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findByIdAgendamento(idAgendamento);
        if (agendamentoOptional.isPresent()){
            agendamentoRepository.delete(agendamentoOptional.get());
        } else {
            throw new RuntimeException("Agendamento não encontrado.");
        }
    }

    public Agendamento atualizar(Agendamento agendamento){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findByIdAgendamento(agendamento.getIdAgendamento());
        if (agendamentoOptional.isPresent()){
            return agendamentoRepository.save(agendamento);
        } else {
            throw new RuntimeException("Agendamento não encontrado.");
        }
    }
}