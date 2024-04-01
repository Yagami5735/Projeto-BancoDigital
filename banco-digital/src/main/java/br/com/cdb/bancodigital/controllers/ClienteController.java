package br.com.cdb.bancodigital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @PostMapping("/add/{nome}/{cpf}")
    public void addCliente(@PathVariable String nome, @PathVariable String cpf, @PathVariable String dataNascimento, @PathVariable String endereco){
        clienteService.addCliente(nome, cpf, dataNascimento, endereco);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCliente(@RequestBody Cliente cliente){
        Cliente clienteAdicionado = clienteService.addCliente(cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento(), cliente.getEndereco());
        if(clienteAdicionado != null){
            return new ResponseEntity<>("Cliente adicionado com Sucesso!", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Nome, cpf ou data de nascimento invalido(s)", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeCliente(@RequestBody Cliente cliente){
        clienteService.removeCliente(cliente);
        return new ResponseEntity<>("Cliente removido com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/removeByID")
    public ResponseEntity<String> removeClienteByID(@RequestBody Cliente cliente){
        clienteService.removeCLienteByID(cliente.getId());
        return new ResponseEntity<>("Cliente removido com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes = clienteService.getClientes();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @GetMapping("/searchByID")
    public ResponseEntity<?> getClienteByID(@RequestBody Cliente cliente){

        return new ResponseEntity<>(clienteService.getClienteByID(cliente.getId()), HttpStatus.OK);
    }
}
