package br.com.cdb.bancodigital.entity.contas;

import br.com.cdb.bancodigital.entity.Cliente;
import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ContaCorrente implements ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContaCorrente;
    private double saldo;

    @ManyToOne
    private Cliente cliente;
    private final double taxaMensal = 12.0;

    public ContaCorrente(Cliente cliente){
        this.cliente = cliente;
    }

    public ContaCorrente(){

    }
    @Override
    public void depositar(double valor) {

        saldo += valor;
    }

    @Override
    public boolean sacar(double valor) {
        if (saldo < valor)
            return false;
        saldo -= valor;
        return true;
    }

    @Override
    public void transferir(double valor, ContaBancaria conta) {
        if(sacar(valor))conta.depositar(valor);
    }

    @Override
    public double getSaldo() {

        return saldo;
    }

    public void descontarTaxa(){
        LocalDate dataAtual = LocalDate.now();
        if(dataAtual.getDayOfMonth() == 1){
            saldo-=taxaMensal;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Long getIdContaCorrente() {
        return idContaCorrente;
    }
}
