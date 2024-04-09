package br.com.cdb.bancodigital.entity.contas;

public interface ContaBancaria {
    public void depositar(double valor);

    public boolean sacar(double valor);

    public void transferir(double valor, ContaBancaria conta);

    void transferir(double valor, Pix conta);

    public double getSaldo();
}