package br.com.cdb.bancodigital.entity;

import br.com.cdb.bancodigital.service.TiposCliente;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String cpf;
    private  String nome;

    private TiposCliente classe;

    private String endereco;
    private  LocalDate dataNascimento;

    private boolean contaPoupanca = false;
    private boolean contaCorrente = false;

    public Cliente(){

    }
    public Cliente(String nome, String cpf, LocalDate dataNascimento, String endereco, TiposCliente classe)
    {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.classe = classe;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public TiposCliente getClasse() {
        return classe;
    }

    public boolean isContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(boolean contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public boolean isContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(boolean contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
