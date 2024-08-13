package com.eventosapp.eventoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import  org.hibernate.validator.constraints.NotEmpty;




//colocamos essa anotação para que o JPA saiba
// que essa classe sera uma tabela no banço de dados
@Entity
public class Convidado {

    @Id
    @NotEmpty(message = "O nome do convidado nçao pode estar vazio")
    private String rg;
    @NotEmpty (message = "O rg não pode estar vazio.")
    private String nomeConvidado;

    //muitos convidados para um evento
    @ManyToOne
    private Evento evento; // criando a relação com a tabela evento

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
/*
* aqui vamos montar a relação entre a entidade convidados e evento
*
* */