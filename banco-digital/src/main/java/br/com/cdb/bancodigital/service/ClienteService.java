package br.com.cdb.bancodigital.service;

import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    private boolean validCPF = false, validNome = false;

    public Cliente addCliente(String nome, String cpf, LocalDate dataNascimento, String endereco){
        if(cpf.length() == 11)validCPF = true;
        if(!nome.isBlank())validNome = true;
        if(validNome && validCPF)
        {
            Cliente cliente;
            cliente = new Cliente(nome, cpf, dataNascimento, endereco);
            validCPF = false;
            validNome = false;
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void removeCliente(Cliente cliente){
        if(clienteRepository.existsById(cliente.getId())) {
            clienteRepository.delete(cliente);
        }
    }

    public void removeCLienteByID(long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }
    }


    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteByID(long id)
    {
        return clienteRepository.findById(id);
    }
}
