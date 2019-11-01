package br.com.laa.cadastrojsfjpa.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

    @Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id") //informa como deve ser chamado o campo na tabela
    private Long id; //ID DA PESSOA
    
    private String nome;
    @Column(name = "cpf", unique = true, //manda criar uma chave exclusiva
                          nullable=false) //informa que não deve aceitar nulo no campo
    private String cpf;
 
    private String Senha;
    
    private String telefone;
    
    @Enumerated(EnumType.STRING)
    private Perfil Perfil;
    
    @ManyToOne(fetch = FetchType.EAGER)//informa como deve ser recuperado a entidade (atributo)
    private Local setortrabalho;
    
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Perfil getPerfil() {
        return Perfil;
    }

    public Local getSetortrabalho() {
        return setortrabalho;
    }

    public void setSetortrabalho(Local setortrabalho) {
        this.setortrabalho = setortrabalho;
    }
   
}