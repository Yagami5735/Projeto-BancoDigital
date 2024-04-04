package br.com.cdb.bancodigital.entity.contas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContaPoupanca implements ContaBancaria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double saldo;
    private double taxaVigente = 0.4;
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

}