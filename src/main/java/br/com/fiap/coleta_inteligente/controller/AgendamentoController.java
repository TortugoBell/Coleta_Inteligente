package br.com.fiap.coleta_inteligente.controller;

import br.com.fiap.coleta_inteligente.dto.AgendamentoExibicaoDTO;
import br.com.fiap.coleta_inteligente.model.Agendamento;
import br.com.fiap.coleta_inteligente.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping("/agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento agendar(@RequestBody Agendamento agendamento){
        return service.agendar(agendamento);
    }

    @DeleteMapping("/agendamentos/{idAgendamento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAgendamento(@PathVariable int idAgendamento){
        service.excluirAgendamento(idAgendamento);
    }

    @PutMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento atualizar(@RequestBody Agendamento agendamento){
        return service.atualizar(agendamento);
    }

    @GetMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public List<Agendamento> listarTodosOsAgendamentos(){
        return service.listarTodosOsAgendamentos();
    }

    @GetMapping("/agendamentos/{idAgendamento}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoExibicaoDTO buscarPorId(@PathVariable int idAgendamento){
        return service.buscaPorId(idAgendamento);
    }

    @GetMapping("/agendamentos/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<Agendamento> buscarPorData(@PathVariable LocalDate dataInicial, @PathVariable LocalDate dataFinal){
        return service.buscarPorData(dataInicial,dataFinal);
    }
}