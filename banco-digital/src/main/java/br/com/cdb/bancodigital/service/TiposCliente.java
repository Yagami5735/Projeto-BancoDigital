package br.com.cdb.bancodigital.service;

public enum TiposCliente {
    COMUM(0, "ClienteComum"),
    SUPER(1, "ClienteSuper"),
    PREMIUM(2, "ClientePremium");
    private final int codigo;
    private final String descricao;

    TiposCliente(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
