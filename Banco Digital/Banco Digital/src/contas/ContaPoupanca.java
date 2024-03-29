package contas;

public class ContaPoupanca implements ContaBancaria{
    private double saldo;

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
