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
import javax.persistence.ManyToMany;





    @Entity
public class Chamado implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id") //informa como deve ser chamado o campo na tabela
    private Long id; //ID DA PESSOA
    
String descricao;

@Enumerated(EnumType.STRING)
    private Status status;

@ManyToMany(fetch = FetchType.EAGER)
    private Equipamento equipamento;
  


}
