package br.com.fiap.coleta_inteligente.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "T_COL_CAMINHAO")
public class Caminhao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CAMINHAO_SEQ"
    )
    @SequenceGenerator(
            name = "CAMINHAO_SEQ",
            sequenceName = "CAMINHAO_SEQ",
            allocationSize = 50
    )
    @Column (name = "ID_CAMINHAO")
    private int idCaminhao;
    @Column (name = "PLACA_CAMINHAO")
    private String placa;
    @Column (name = "CAPACIDADE_CAMINHAO")
    private int capacidadeCaminhao;
    @Column (name = "LOCALIZACAO_CAMINHAO")
    private String localizacaoCaminhao;
    @Column (name = "STATUS_CAMINHAO")
    private boolean statusCaminhao;

    public int getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(int idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidadeCaminhao() {
        return capacidadeCaminhao;
    }

    public void setCapacidadeCaminhao(int capacidadeCaminhao) {
        this.capacidadeCaminhao = capacidadeCaminhao;
    }

    public String getLocalizacaoCaminhao() {
        return localizacaoCaminhao;
    }

    public void setLocalizacaoCaminhao(String localizacaoCaminhao) {
        this.localizacaoCaminhao = localizacaoCaminhao;
    }

    public boolean isStatusCaminhao() {
        return statusCaminhao;
    }

    public void setStatusCaminhao(boolean statusCaminhao) {
        this.statusCaminhao = statusCaminhao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caminhao caminhao = (Caminhao) o;
        return idCaminhao == caminhao.idCaminhao && capacidadeCaminhao == caminhao.capacidadeCaminhao && statusCaminhao == caminhao.statusCaminhao && Objects.equals(placa, caminhao.placa) && Objects.equals(localizacaoCaminhao, caminhao.localizacaoCaminhao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCaminhao, placa, capacidadeCaminhao, localizacaoCaminhao, statusCaminhao);
    }
}
