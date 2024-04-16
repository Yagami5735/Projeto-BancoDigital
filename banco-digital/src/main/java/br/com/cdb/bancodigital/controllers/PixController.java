package br.com.cdb.bancodigital.controllers;

import br.com.cdb.bancodigital.entity.contas.ContaBancaria;
import br.com.cdb.bancodigital.entity.contas.ContaCorrente;
import br.com.cdb.bancodigital.entity.contas.ContaPoupanca;
import br.com.cdb.bancodigital.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pix")
public class PixController {
    @Autowired
    private PixService pixService;

    @PostMapping("/criarChavePixEmailCC")
    public ResponseEntity<?> criarChavePixEmail(@RequestBody ContaCorrente conta, @RequestParam String chavePix){
        if(pixService.criarChavePixEmail(conta.getIdContaCorrente(), chavePix)){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }

    @PostMapping("/criarChavePixEmailCP")
    public ResponseEntity<?> criarChavePixEmail(@RequestBody ContaPoupanca conta, @RequestParam String chavePix){
        if(pixService.criarChavePixEmail(conta.getIdContaPoupanca(), chavePix)){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }

    @PostMapping("/criarChavePixTelefoneCC")
    public ResponseEntity<?> criarChavePixNumeroTelefone(@RequestBody ContaCorrente conta, @RequestParam String chavePix){
        if(pixService.criarChavePixNumeroTelefone(conta.getIdContaCorrente(), chavePix)){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }
    @PostMapping("/criarChavePixTelefoneCP")
    public ResponseEntity<?> criarChavePixNumeroTelefone(@RequestBody ContaPoupanca conta, @RequestParam String chavePix){
        if(pixService.criarChavePixNumeroTelefone(conta.getIdContaPoupanca(), chavePix)){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }

    @PostMapping("/criarChavePixAleatoriaCC")
    public ResponseEntity<?> criarChavePixAleatoria(@RequestBody ContaCorrente conta, @RequestParam String chavePix){
        if(pixService.criarChavePixAleatoria(conta.getIdContaCorrente())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }
    @PostMapping("/criarChavePixAleatoriaCP")
    public ResponseEntity<?> criarChavePixAleatoria(@RequestBody ContaPoupanca conta, @RequestParam String chavePix){
        if(pixService.criarChavePixAleatoria(conta.getIdContaPoupanca())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }

    @DeleteMapping("/removerChavePixEmailCC")
    public ResponseEntity<?> removerChavePixEmail(@RequestBody ContaCorrente conta, @RequestParam String chavePix){
        if(pixService.removerChavePixEmail(conta.getIdContaCorrente())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }
    @DeleteMapping("/removerChavePixEmailCP")
    public ResponseEntity<?> removerChavePixEmail(@RequestBody ContaPoupanca conta, @RequestParam String chavePix){
        if(pixService.removerChavePixEmail(conta.getIdContaPoupanca())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }

    @DeleteMapping("/removerChavePixTelefoneCC")
    public ResponseEntity<?> removerChavePixTelefone(@RequestBody ContaCorrente conta, @RequestParam String chavePix){
        if(pixService.removerChavePixNumeroTelefone(conta.getIdContaCorrente())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }
    @DeleteMapping("/removerChavePixTelefoneCP")
    public ResponseEntity<?> removerChavePixTelefone(@RequestBody ContaPoupanca conta, @RequestParam String chavePix){
        if(pixService.removerChavePixNumeroTelefone(conta.getIdContaPoupanca())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }

    @DeleteMapping("/removerChavePixAleatoriaCC")
    public ResponseEntity<?> removerChavePixAleatoria(@RequestBody ContaCorrente conta, @RequestParam String chavePix){
        if(pixService.removerChavePixAleatoria(conta.getIdContaCorrente())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }
    @DeleteMapping("/removerChavePixAleatoriaCP")
    public ResponseEntity<?> removerChavePixAleatoria(@RequestBody ContaPoupanca conta, @RequestParam String chavePix){
        if(pixService.removerChavePixAleatoria(conta.getIdContaPoupanca())){
            return new ResponseEntity<>("Chave PIX criada com sucesso!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("conta inválida ou chave já existente", HttpStatus.CONFLICT);
    }
}
