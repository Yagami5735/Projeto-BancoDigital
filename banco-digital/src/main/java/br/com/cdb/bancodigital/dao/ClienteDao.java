package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.entity.Cliente;

import java.util.ArrayList;
import java.util.Objects;

public class ClienteDao {
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void save(Cliente cliente){
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> listAll() {
        return listaClientes;
    }

    public void remove(String nome, String cpf){
        for(Cliente x : listaClientes)
        {
            if(x.getNome().equals(nome) && x.getCpf().equals(cpf)) {
                listaClientes.remove(x);
                break;
            }
        }
    }
    public boolean getCliente(String nome, String cpf){
        return true;
    }


}
