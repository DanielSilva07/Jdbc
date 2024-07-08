package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Cliente;

import java.util.List;

public interface IClienteDao {

    public Integer cadastrar(Cliente cliente) throws Exception;

    Cliente consultar(String codigo) throws Exception;

    Integer excluir(Cliente cliente) throws Exception;

    List<Cliente> buscarTodos() throws Exception;


}
