package br.com.cdb.bancodigital.service;

import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.entity.contas.ContaCorrente;
import br.com.cdb.bancodigital.entity.contas.ContaPoupanca;
import br.com.cdb.bancodigital.repository.ContaCorrenteRepository;
import br.com.cdb.bancodigital.repository.ContaPoupancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;
    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;

    @Scheduled(cron = "0 0 0 1 * ?")
    public void descontarTaxaManutencao() {
        List<ContaCorrente> contas = contaCorrenteRepository.findAll();
        for (ContaCorrente conta : contas) {
            conta.descontarTaxa();
        }
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void creditarRendimento() {
        List<ContaPoupanca> contas = contaPoupancaRepository.findAll();
        for (ContaPoupanca conta : contas) {
            conta.creditarTaxa();
        }
    }

    public ContaCorrente criarContaCorrente(Cliente cliente, double saldoInicial) {
        if(!cliente.isContaCorrente()){
            ContaCorrente conta = new ContaCorrente(cliente);
            conta.depositar(saldoInicial);
            contaCorrenteRepository.save(conta);
            cliente.setContaCorrente(true);
            return conta;
        }
        return null;
    }

    public ContaPoupanca criarContaPoupanca(Cliente cliente, double saldoInicial) {
        if(!cliente.isContaPoupanca()){
            ContaPoupanca conta = new ContaPoupanca(cliente);
            conta.depositar(saldoInicial);
            contaPoupancaRepository.save(conta);
            cliente.setContaPoupanca(true);
            return conta;
        }
        return null;
    }
}
