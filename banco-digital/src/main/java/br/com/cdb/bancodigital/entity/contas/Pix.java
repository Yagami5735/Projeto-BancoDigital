package br.com.cdb.bancodigital.entity.contas;

import java.util.UUID;

public class Pix implements ContaBancaria{
    private double saldo;
    private String chavePixEmail;
    private String chavePixNumeroTelefone;
    private String chavePixAleatoria;

    private boolean hasChavePixEmail;
    private boolean hasChavePixNumeroTelefone;
    private boolean hasChavePixAleatoria;

    public boolean criarChavePixEmail(String email){
        if(!hasChavePixEmail){
            this.chavePixEmail = email;
            hasChavePixEmail = true;
            return true;
        }
        return false;

    }

    public boolean criarChavePixNumeroTelefone(String numeroTelefone){
        if(!hasChavePixNumeroTelefone){
            this.chavePixNumeroTelefone = numeroTelefone;
            hasChavePixNumeroTelefone = true;
            return true;
        }
        return false;

    }

    public boolean criarChavePixAleatoria(){
        if(!hasChavePixAleatoria){
            this.chavePixAleatoria = UUID.randomUUID().toString();
            hasChavePixAleatoria = true;
            return true;
        }
        return false;

    }

    @Override
    public void depositar(double valor) {
        saldo+=valor;
    }

    @Override
    public boolean sacar(double valor) {
        if(saldo >= valor){
            saldo-=valor;
            return true;
        }
        return false;
    }

    @Override
    public void transferir(double valor, ContaBancaria conta) {
        if(saldo>=valor){
            saldo-=valor;
            conta.depositar(valor);
        }
    }

    @Override
    public void transferir(double valor, Pix conta) {
        if(conta.hasChavePixAleatoria || conta.hasChavePixEmail || conta.hasChavePixNumeroTelefone){
            if(saldo>=valor){
                saldo-=valor;
                conta.depositar(valor);
            }
        }

    }

    @Override
    public double getSaldo() {
        return saldo;
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

    public boolean isHasChavePixEmail(){
        return hasChavePixEmail;
    }
    public void setChavePixEmail(boolean chavePixEmail){
        hasChavePixEmail = chavePixEmail;
    }
    public void setChavePixNumeroTelefone(boolean chavePixNumeroTelefone){
        hasChavePixNumeroTelefone = chavePixNumeroTelefone;
    }
    public void setChavePixNumeroAleatoria(boolean chavePixAleatoria){
        hasChavePixAleatoria = chavePixAleatoria;
    }

    public boolean isHasChavePixNumeroTelefone() {
        return hasChavePixNumeroTelefone;
    }

    public boolean isHasChavePixAleatoria() {
        return hasChavePixAleatoria;
    }
}
