package br.com.cdb.bancodigital.service;

import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.entity.contas.ContaBancaria;
import br.com.cdb.bancodigital.entity.contas.ContaCorrente;
import br.com.cdb.bancodigital.entity.contas.ContaPoupanca;
import br.com.cdb.bancodigital.repository.ContaCorrenteRepository;
import br.com.cdb.bancodigital.repository.ContaPoupancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PixService {
    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;


    public boolean criarChavePixEmail(long conta, String email){
        Optional<ContaCorrente> ccOptional = contaCorrenteRepository.findById(conta);
        Optional<ContaPoupanca> cpOptional = contaPoupancaRepository.findById(conta);
        if(ccOptional.isPresent()){
            ContaCorrente contaCorrente = ccOptional.get();
            contaCorrente.getPix().criarChavePixEmail(email);
            contaCorrenteRepository.save(contaCorrente);
            return true;
        }
        if(cpOptional.isPresent()){
            ContaPoupanca contaPoupanca = cpOptional.get();
            contaPoupanca.getPix().criarChavePixEmail(email);
            contaPoupancaRepository.save(contaPoupanca);
            return true;
        }
        return false;
    }

    public boolean criarChavePixNumeroTelefone(long conta, String telefone){
        Optional<ContaCorrente> ccOptional = contaCorrenteRepository.findById(conta);
        Optional<ContaPoupanca> cpOptional = contaPoupancaRepository.findById(conta);
        if(ccOptional.isPresent()){
            ContaCorrente contaCorrente = ccOptional.get();
            contaCorrente.getPix().criarChavePixNumeroTelefone(telefone);
            contaCorrenteRepository.save(contaCorrente);
            return true;
        }
        if(cpOptional.isPresent()){
            ContaPoupanca contaPoupanca = cpOptional.get();
            contaPoupanca.getPix().criarChavePixNumeroTelefone(telefone);
            contaPoupancaRepository.save(contaPoupanca);
            return true;
        }
        return false;
    }

    public boolean criarChavePixAleatoria(long conta){
        Optional<ContaCorrente> ccOptional = contaCorrenteRepository.findById(conta);
        Optional<ContaPoupanca> cpOptional = contaPoupancaRepository.findById(conta);
        if(ccOptional.isPresent()){
            ContaCorrente contaCorrente = ccOptional.get();
            contaCorrente.getPix().criarChavePixAleatoria();
            contaCorrenteRepository.save(contaCorrente);
            return true;
        }
        else if(cpOptional.isPresent()){
            ContaPoupanca contaPoupanca = cpOptional.get();
            contaPoupanca.getPix().criarChavePixAleatoria();
            contaPoupancaRepository.save(contaPoupanca);
            return true;
        }
        return false;
    }

    public boolean removerChavePixEmail(long conta){
        Optional<ContaCorrente> ccOptional = contaCorrenteRepository.findById(conta);
        Optional<ContaPoupanca> cpOptional = contaPoupancaRepository.findById(conta);
        if(ccOptional.isPresent()){
            ContaCorrente contaCorrente = ccOptional.get();
            contaCorrente.getPix().removerChavePixEmail();
            contaCorrenteRepository.save(contaCorrente);
            return true;
        } else if (cpOptional.isPresent()) {
            ContaPoupanca contaPoupanca = cpOptional.get();
            contaPoupanca.getPix().removerChavePixEmail();
            contaPoupancaRepository.save(contaPoupanca);
            return true;

        }
        return false;
    }

    public boolean removerChavePixNumeroTelefone(long conta){
        Optional<ContaCorrente> ccOptional = contaCorrenteRepository.findById(conta);
        Optional<ContaPoupanca> cpOptional = contaPoupancaRepository.findById(conta);
        if(ccOptional.isPresent()){
            ContaCorrente contaCorrente = ccOptional.get();
            contaCorrente.getPix().removerChavePixNumeroTelefone();
            contaCorrenteRepository.save(contaCorrente);
            return true;
        } else if (cpOptional.isPresent()) {
            ContaPoupanca contaPoupanca = cpOptional.get();
            contaPoupanca.getPix().removerChavePixNumeroTelefone();
            contaPoupancaRepository.save(contaPoupanca);
            return true;

        }
        return false;
    }

    public boolean removerChavePixAleatoria(long conta){
        Optional<ContaCorrente> ccOptional = contaCorrenteRepository.findById(conta);
        Optional<ContaPoupanca> cpOptional = contaPoupancaRepository.findById(conta);
        if(ccOptional.isPresent()){
            ContaCorrente contaCorrente = ccOptional.get();
            contaCorrente.getPix().removerChavePixAleatoria();
            contaCorrenteRepository.save(contaCorrente);
            return true;
        } else if (cpOptional.isPresent()) {
            ContaPoupanca contaPoupanca = cpOptional.get();
            contaPoupanca.getPix().removerChavePixAleatoria();
            contaPoupancaRepository.save(contaPoupanca);
            return true;

        }
        return false;
    }

}
