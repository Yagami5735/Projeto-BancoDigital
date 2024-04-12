package br.com.cdb.bancodigital.entity.contas;

import br.com.cdb.bancodigital.entity.Cliente;
import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContaBancaria;

    @ManyToOne
    private Cliente cliente;

    @OneToOne(mappedBy = "contaBancaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Pix pix;

    private double saldo;
    public ContaBancaria(Cliente cliente){
        this.cliente = cliente;
        this.pix = new Pix(this);
    }

    public ContaBancaria(){

    }

    public abstract void depositar(double valor);

    public abstract boolean sacar(double valor);

    public abstract void transferir(double valor, ContaBancaria conta);

    public abstract void transferir(double valor, Pix conta);
    public abstract double getSaldo();

    public void setPix(Pix pix){
        this.pix = pix;
    }

    public Pix getPix(){
        return pix;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}