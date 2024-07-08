package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Cliente;
import br.com.danielsilva.domain.ConnectionFactory;
import br.com.danielsilva.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProdutoDao implements IProdutoDao {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO produto (ID , NOME , CODIGO , PRECO) VALUES (nextval( ' sq_test2') ,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1,produto.getNomeP());
            stm.setString(2,produto.getCodigoP());
            stm.setDouble(3,produto.getPrecoP());
          return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigoP) throws Exception {
         Connection connection = null;
         PreparedStatement stm = null;
         ResultSet rs = null;
         Produto produto = null;
         try {
             connection = ConnectionFactory.getConnection();
             String sql = "select * from produto where codigo = ?";
             stm = connection.prepareStatement(sql);
             stm.setString(1, codigoP);
             rs = stm.executeQuery();
             if (rs.next()) {
                 produto = new Produto();
                 produto.setId(rs.getLong("id"));
                 produto.setNomeP(rs.getString("nome"));
                 produto.setCodigoP(rs.getString("codigo"));
                 produto.setPrecoP(rs.getDouble("preco"));

             }
             return produto;

         }catch (Exception e){
             throw e;
         }finally {
             if (stm != null && !stm.isClosed()) {
                 stm.close();
             }
             if (connection != null && !connection.isClosed()) {
                 connection.close();
             }
         }

    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        return 0;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        return List.of();
    }
}
