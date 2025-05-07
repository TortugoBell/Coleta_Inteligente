package br.com.fiap.coleta_inteligente.repository;

import br.com.fiap.coleta_inteligente.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository <Agendamento, Integer> {

    public Optional<Agendamento> findByIdAgendamento (int idAgendamento);

    public List<Agendamento> findByDataAgendamentoBetween (LocalDate dataInicial, LocalDate dataFinal);
}