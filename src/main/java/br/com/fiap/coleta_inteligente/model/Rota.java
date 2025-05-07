package br.com.fiap.coleta_inteligente.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "T_COL_ROTA")
public class Rota {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ROTA_SEQ"
    )
    @SequenceGenerator(
            name = "ROTA_SEQ",
            sequenceName = "ROTA_SEQ",
            allocationSize = 50
    )
    @Column (name = "ID_ROTA")
    private int idRota;
    @Column (name = "DESCRICAO_ROTA")
    private String descricaoRota;
    @Column (name = "DURACAO_ROTA")
    private int duracaoRota;

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public String getDescricaoRota() {
        return descricaoRota;
    }

    public void setDescricaoRota(String descricaoRota) {
        this.descricaoRota = descricaoRota;
    }

    public int getDuracaoRota() {
        return duracaoRota;
    }

    public void setDuracaoRota(int duracaoRota) {
        this.duracaoRota = duracaoRota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rota rota = (Rota) o;
        return idRota == rota.idRota && duracaoRota == rota.duracaoRota && Objects.equals(descricaoRota, rota.descricaoRota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRota, descricaoRota, duracaoRota);
    }
}
