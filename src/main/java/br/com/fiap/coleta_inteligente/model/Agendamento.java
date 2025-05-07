package br.com.fiap.coleta_inteligente.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "T_COL_AGENDAMENTO_COLETA")
public class Agendamento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COLETA_SEQ"
    )
    @SequenceGenerator(
            name = "COLETA_SEQ",
            sequenceName = "COLETA_SEQ",
            allocationSize = 1
    )
    @Column (name = "ID_AGENDAMENTO")
    private int idAgendamento;
    @Column (name = "DT_AGENDAMENTO")
    private LocalDate dataAgendamento;
    @Column (name = "STATUS")
    private boolean statusAgendamento;

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public boolean isStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(boolean statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return idAgendamento == that.idAgendamento && statusAgendamento == that.statusAgendamento && Objects.equals(dataAgendamento, that.dataAgendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgendamento, dataAgendamento, statusAgendamento);
    }
}