package br.com.cdb.bancodigital.service;

public enum ChavesPix {
    CHAVE_EMAIL(0, "Chave E-mail"),
    CHAVE_NUMERO(1, "Chave Numero de Telefone"),
    CHAVE_ALEATORIA(2, "Chave Aleatoria");
    private final int codigo;
    private final String descricao;
    ChavesPix(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
