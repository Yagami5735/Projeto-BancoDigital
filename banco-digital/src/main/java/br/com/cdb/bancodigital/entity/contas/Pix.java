package br.com.cdb.bancodigital.entity.contas;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.UUID;


public class Pix extends ContaBancaria{
    private double saldo;

    @ManyToOne
    private final ContaBancaria contaBancaria;

    private boolean hasChavePixEmail;
    private boolean hasChavePixNumeroTelefone;
    private boolean hasChavePixAleatoria;

    public Pix(ContaBancaria contaBancaria){
        this.contaBancaria = contaBancaria;
    }

    public boolean criarChavePixEmail(String email){
        if(!hasChavePixEmail){
            contaBancaria.setChavePixEmail(email);
            hasChavePixEmail = true;
            return true;
        }
        return false;

    }
    public boolean removerChavePixEmail(){
        if(hasChavePixEmail){
            contaBancaria.setChavePixEmail(null);
            hasChavePixEmail = false;
            return true;
        }
        return false;
    }


    public boolean criarChavePixNumeroTelefone(String numeroTelefone){
        if(!hasChavePixNumeroTelefone){
            contaBancaria.setChavePixNumeroTelefone(numeroTelefone);
            hasChavePixNumeroTelefone = true;
            return true;
        }
        return false;

    }

    public boolean removerChavePixNumeroTelefone(){
        if(hasChavePixNumeroTelefone){
            contaBancaria.setChavePixNumeroTelefone(null);
            hasChavePixNumeroTelefone = false;
            return true;
        }
        return false;
    }

    public boolean criarChavePixAleatoria(){
        if(!hasChavePixAleatoria){
            contaBancaria.setChavePixAleatoria(UUID.randomUUID().toString());
            hasChavePixAleatoria = true;
            return true;
        }
        return false;

    }

    public boolean removerChavePixAleatoria(){
        if(!hasChavePixAleatoria){
            contaBancaria.setChavePixAleatoria(null);
            hasChavePixAleatoria = false;
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
        return contaBancaria.getChavePixEmail();
    }


    public String getChavePixNumeroTelefone() {
        return contaBancaria.getChavePixNumeroTelefone();
    }

    public String getChavePixAleatoria() {
        return contaBancaria.getChavePixAleatoria();
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
