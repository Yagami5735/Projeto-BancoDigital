package br.com.cdb.bancodigital.controllers;


import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.entity.contas.ContaCorrente;
import br.com.cdb.bancodigital.entity.contas.ContaPoupanca;
import br.com.cdb.bancodigital.repository.ClienteRepository;
import br.com.cdb.bancodigital.service.ClienteService;
import br.com.cdb.bancodigital.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping("/addContaCorrente")
    public ResponseEntity<String> addContaCorrente(@RequestBody Cliente cliente){
        ContaCorrente conta = contaService.criarContaCorrente(cliente, 0.0);
        if(conta != null) return new ResponseEntity<>("Conta corrente adicionada com sucesso!", HttpStatus.CREATED);
        else return new ResponseEntity<>("Cliente já possui uma conta corrente", HttpStatus.CONFLICT);

    }

    @PostMapping("/addContaPoupanca")
    public ResponseEntity<String> addContaPoupanca(@RequestBody Cliente cliente){
        ContaPoupanca conta = contaService.criarContaPoupanca(cliente, 0.0);
        if(conta != null) return new ResponseEntity<>("Conta adicionada com sucesso!", HttpStatus.CREATED);
        else return new ResponseEntity<>("Cliente já possui uma conta poupanca", HttpStatus.CONFLICT );
    }

    @GetMapping("/searchAllContaPoupanca")
    public  ResponseEntity<?> getAllContaPoupanca(){
        return new ResponseEntity<>(contaService.getAllContaPoupanca(), HttpStatus.OK);
    }

    @GetMapping("/searchAllContaCorrente")
    public  ResponseEntity<?> getAllContaCorrente(){
        return new ResponseEntity<>(contaService.getAllContaCorrente(), HttpStatus.OK);
    }
}
