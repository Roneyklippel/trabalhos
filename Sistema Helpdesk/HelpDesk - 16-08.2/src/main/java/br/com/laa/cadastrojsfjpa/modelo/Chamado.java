package br.com.laa.cadastrojsfjpa.modelo;

import java.io.Serializable;
import java.util.Date;
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
public class Chamado implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id") //informa como deve ser chamado o campo na tabela
    private Long id; //ID DA PESSOA
    
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Equipamento equipamento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoChamado tipoChamado;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataAbertura", nullable = false)
    private Date dataAbertura;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date limiteAtendimento;
     
    @ManyToOne(fetch = FetchType.EAGER)   
    private Usuario tecnicoResponsavel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuarioAbertura;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getLimiteAtendimento() {
        return limiteAtendimento;
    }

    public void setLimiteAtendimento(Date limiteAtendimento) {
        this.limiteAtendimento = limiteAtendimento;
    }

    public Usuario getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(Usuario tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public Usuario getUsuarioAbertura() {
        return usuarioAbertura;
    }

    public void setUsuarioAbertura(Usuario usuarioAbertura) {
        this.usuarioAbertura = usuarioAbertura;
    }

    
    
  
    }
  



  


  
  
   