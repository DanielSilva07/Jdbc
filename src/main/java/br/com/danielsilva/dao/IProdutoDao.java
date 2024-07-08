package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Cliente;
import br.com.danielsilva.domain.Produto;

import java.util.List;

public interface IProdutoDao {

    public Integer cadastrar(Produto produto) throws Exception;

    Produto consultar(String codigo) throws Exception;

    Integer excluir(Produto produto) throws Exception;

    List<Produto> buscarTodos() throws Exception;




}
