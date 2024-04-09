package br.com.cdb.bancodigital.entity.contas;

import br.com.cdb.bancodigital.entity.Cliente;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
public class ContaPoupanca implements ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContaPoupanca;

    @ManyToOne
    private Cliente cliente;

    private double saldo;
    private double taxaVigente = 0.004; // Taxa mensal de 0.4%

    public ContaPoupanca(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContaPoupanca() {
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
        if (sacar(valor))
            conta.depositar(valor);
    }

    @Override
    public void transferir(double valor, Pix conta) {
        
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public void creditarTaxa() {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.getDayOfMonth() == 1) {
            saldo *= (1 + taxaVigente); // Correção do cálculo da taxa de rendimento
        }
    }

    public Long getIdContaPoupanca() {
        return idContaPoupanca;
    }

    public Cliente getCliente() {
        return cliente;
    }
}