package br.com.fiap.coleta_inteligente.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "T_COL_NOTIFICACAO")
public class Notificacao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "NOTIFICACAO_SEQ"
    )
    @SequenceGenerator(
            name = "NOTIFICACAO_SEQ",
            sequenceName = "NOTIFICACAO_SEQ",
            allocationSize = 50
    )
    @Column (name = "ID_NOTIFICACAO")
    private int idNotificacao;
    @Column (name = "TIPO_NOTIFICACAO")
    private String tipoNotificacao;
    @Column (name = "DATA_NOTIFICACAO")
    private LocalDate dataNotificacao;

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public String getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(String tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public LocalDate getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(LocalDate dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notificacao that = (Notificacao) o;
        return idNotificacao == that.idNotificacao && Objects.equals(tipoNotificacao, that.tipoNotificacao) && Objects.equals(dataNotificacao, that.dataNotificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotificacao, tipoNotificacao, dataNotificacao);
    }
}
