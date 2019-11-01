package br.com.laa.cadastrojsfjpa.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id") //informa como deve ser chamado o campo na tabela
    private Long id; //ID DA PESSOA
    
    
    private String numeroPatrimonio;
    private String dadosComplementares;
    private String observacao;
    private Boolean ativo;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.numeroPatrimonio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipamento other = (Equipamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataFimGarantia", nullable = false)
    private Date dataFimGarantia;

     @ManyToOne(fetch = FetchType.EAGER)
    private Local localInstalacao;

     @ManyToOne(fetch = FetchType.EAGER)
    private Fabricante fabricante;

    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo;

     @ManyToOne(fetch = FetchType.EAGER)
    private TipoEquipamento tipoEquipamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getDadosComplementares() {
        return dadosComplementares;
    }

    public void setDadosComplementares(String dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataFimGarantia() {
        return dataFimGarantia;
    }

    public void setDataFimGarantia(Date dataFimGarantia) {
        this.dataFimGarantia = dataFimGarantia;
    }

    public Local getLocalInstalacao() {
        return localInstalacao;
    }

    public void setLocalInstalacao(Local localInstalacao) {
        this.localInstalacao = localInstalacao;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    
}
