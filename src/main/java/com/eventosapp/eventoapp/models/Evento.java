package com.eventosapp.eventoapp.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

//no pacote modelos fica a classe entidade em si com seus atributos
@Entity
public class Evento implements Serializable { // implement so serializable para conseguir gerar id automaticamente

    private  static  final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    private String nome;
    private String local;
    private String data;
    private String horario;


    //relação um evento para muitos convidados

    @OneToMany
    private List<Convidado> convidado; // aqui nesse caso é uma lista de convidados

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
