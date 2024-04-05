package br.com.cdb.bancodigital.service;

import java.text.Normalizer;

public enum FormasDePagamento {
    TRANSFERENCIA(0, "Transferencia"),
    DINHEIRO(1, "Dinheiro"),
    CARTAO_CREDITO(2, "Cartao de Credito"),
    CARTAO_DEBITO(3, "Cartao de Debito"),
    PIX(4, "Pix");

    private final int cod;
    private final String descricao;

    FormasDePagamento(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }
}
