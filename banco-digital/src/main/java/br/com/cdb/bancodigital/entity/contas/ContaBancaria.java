package br.com.cdb.bancodigital.entity.contas;

import br.com.cdb.bancodigital.entity.Cliente;
import jakarta.persistence.*;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContaBancaria;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Pix pix;

    private String chavePixEmail;


    private String chavePixNumeroTelefone;


    private String chavePixAleatoria;

    private double saldo;
    public ContaBancaria(Cliente cliente){
        this.cliente = cliente;
        pix = new Pix(this);
    }

    public ContaBancaria(){

    }

    public abstract void depositar(double valor);

    public abstract boolean sacar(double valor);

    public abstract void transferir(double valor, ContaBancaria conta);

    public abstract void transferir(double valor, Pix conta);
    public abstract double getSaldo();

    public Pix getPix(){
        return pix;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getChavePixEmail() {
        return chavePixEmail;
    }


    public String getChavePixNumeroTelefone() {
        return chavePixNumeroTelefone;
    }

    public String getChavePixAleatoria() {
        return chavePixAleatoria;
    }

    public void setChavePixEmail(String chavePixEmail) {
        this.chavePixEmail = chavePixEmail;
    }

    public void setChavePixNumeroTelefone(String chavePixNumeroTelefone) {
        this.chavePixNumeroTelefone = chavePixNumeroTelefone;
    }

    public void setChavePixAleatoria(String chavePixAleatoria) {
        this.chavePixAleatoria = chavePixAleatoria;
    }


}