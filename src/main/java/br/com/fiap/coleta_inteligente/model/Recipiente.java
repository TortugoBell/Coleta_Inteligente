package br.com.fiap.coleta_inteligente.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "T_COL_RECIPIENTE")
public class Recipiente {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "RECIPIENTE_SEQ"
    )
    @SequenceGenerator(
            name = "RECIPIENTE_SEQ",
            sequenceName = "RECIPIENTE_SEQ",
            allocationSize = 50
    )
    @Column (name = "ID_RECIPIENTE")
    private int idRecipiente;
    @Column (name = "LOCALIZACAO_RECIPIENTE")
    private String localizacaoRecipiente;
    @Column (name = "CAPACIDADE_RECIPIENTE")
    private int capacidadeRecipiente;
    @Column (name = "CAPACIDADE_ATUAL_RECIPIENTE")
    private int capacidadeAtualRecipiente;
    @Column (name = "TIPO_RECIPIENTE")
    private String tipoRecipiente;

    public int getIdRecipiente() {
        return idRecipiente;
    }

    public void setIdRecipiente(int idRecipiente) {
        this.idRecipiente = idRecipiente;
    }

    public String getLocalizacaoRecipiente() {
        return localizacaoRecipiente;
    }

    public void setLocalizacaoRecipiente(String localizacaoRecipiente) {
        this.localizacaoRecipiente = localizacaoRecipiente;
    }

    public int getCapacidadeRecipiente() {
        return capacidadeRecipiente;
    }

    public void setCapacidadeRecipiente(int capacidadeRecipiente) {
        this.capacidadeRecipiente = capacidadeRecipiente;
    }

    public int getCapacidadeAtualRecipiente() {
        return capacidadeAtualRecipiente;
    }

    public void setCapacidadeAtualRecipiente(int capacidadeAtualRecipiente) {
        this.capacidadeAtualRecipiente = capacidadeAtualRecipiente;
    }

    public String getTipoRecipiente() {
        return tipoRecipiente;
    }

    public void setTipoRecipiente(String tipoRecipiente) {
        this.tipoRecipiente = tipoRecipiente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipiente that = (Recipiente) o;
        return idRecipiente == that.idRecipiente && capacidadeRecipiente == that.capacidadeRecipiente && capacidadeAtualRecipiente == that.capacidadeAtualRecipiente && Objects.equals(localizacaoRecipiente, that.localizacaoRecipiente) && Objects.equals(tipoRecipiente, that.tipoRecipiente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipiente, localizacaoRecipiente, capacidadeRecipiente, capacidadeAtualRecipiente, tipoRecipiente);
    }
}
