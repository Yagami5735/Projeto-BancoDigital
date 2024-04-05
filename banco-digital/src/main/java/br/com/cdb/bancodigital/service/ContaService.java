package br.com.cdb.bancodigital.service;

import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.entity.contas.ContaBancaria;
import br.com.cdb.bancodigital.entity.contas.ContaCorrente;
import br.com.cdb.bancodigital.entity.contas.ContaPoupanca;
import br.com.cdb.bancodigital.repository.ClienteRepository;
import br.com.cdb.bancodigital.repository.ContaCorrenteRepository;
import br.com.cdb.bancodigital.repository.ContaPoupancaRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;
    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

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

        Optional<Cliente> clienteExistente = Optional.ofNullable(clienteRepository.findByCpf(cliente.getCpf()));

        if (clienteExistente.isPresent()) cliente = clienteExistente.get();
        else cliente = clienteRepository.save(cliente);

        if (!cliente.isContaCorrente()) {
            ContaCorrente conta = new ContaCorrente(cliente);
            conta.depositar(saldoInicial);
            cliente.setContaCorrente(true);
            return contaCorrenteRepository.save(conta);
        }

        return null;
    }

    public ContaPoupanca criarContaPoupanca(Cliente cliente, double saldoInicial) {

        Optional<Cliente> clienteExistente = Optional.ofNullable(clienteRepository.findByCpf(cliente.getCpf()));

        if (clienteExistente.isPresent()) cliente = clienteExistente.get();
        else cliente = clienteRepository.save(cliente);

        if (!cliente.isContaPoupanca()) {
            ContaPoupanca conta = new ContaPoupanca(cliente);
            conta.depositar(saldoInicial);
            cliente.setContaPoupanca(true);
            return contaPoupancaRepository.save(conta);
        }

        return null;
    }

    public boolean deleteContaCorrente(ContaCorrente conta){
        if(contaCorrenteRepository.existsById(conta.getIdContaCorrente())){
            contaCorrenteRepository.getReferenceById(conta.getIdContaCorrente()).getCliente().setContaCorrente(false);
            contaCorrenteRepository.deleteById(conta.getIdContaCorrente());
            return true;
        }
        return false;
    }

    public boolean deleteContaPoupanca(ContaPoupanca conta){
        if(contaPoupancaRepository.existsById(conta.getIdContaPoupanca())){
            contaPoupancaRepository.getReferenceById(conta.getIdContaPoupanca()).getCliente().setContaPoupanca(false);
            contaPoupancaRepository.deleteById(conta.getIdContaPoupanca());
            return true;
        }
        return false;
    }

    public boolean deleContaCorrenteByID(long id){
        if(contaCorrenteRepository.existsById(id)){
            contaCorrenteRepository.getReferenceById(id).getCliente().setContaCorrente(false);
            contaCorrenteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteContaPoupancaByID(long id){
        if(contaPoupancaRepository.existsById(id)){
            contaPoupancaRepository.getReferenceById(id).getCliente().setContaPoupanca(false);
            contaPoupancaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Object mostrarSaldoContaCorrente(long id){
        if(contaCorrenteRepository.existsById(id)) return contaCorrenteRepository.getReferenceById(id).getSaldo();
        return null;
    }

    public Object mostrarSaldoContaPoupanca(long id){
        if(contaPoupancaRepository.existsById(id)) return contaPoupancaRepository.getReferenceById(id).getSaldo();
        return null;
    }

    public List<ContaPoupanca> getAllContaPoupanca(){
        return contaPoupancaRepository.findAll();
    }

    public List<ContaCorrente> getAllContaCorrente(){
        return contaCorrenteRepository.findAll();
    }

    public void depositarContaCorrente(ContaCorrente conta, long id){
        Optional<ContaCorrente> contaCorrente = contaCorrenteRepository.findById(id);
        if()
    }

}
