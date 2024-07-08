import br.com.danielsilva.domain.Cliente;
import br.com.danielsilva.dao.ClienteDao;
import br.com.danielsilva.dao.IClienteDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ClienteTest {

    @Test
    public void cadastrar() throws Exception {
        IClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setNome("Vaso");
        cliente.setCodigo("10");
        cliente.setAltura(1.90);
        cliente.setPeso(101D);
        Double imc = cliente.getPeso() / (cliente.getAltura() * cliente.getAltura());
        cliente.setImc(imc);

        Integer qtd = dao.cadastrar(cliente);
        Assert.assertTrue(qtd == 1);
    }

    @Test
    public void consultar() throws Exception {
        IClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");

        Cliente clienteDb = dao.consultar(cliente.getCodigo());
        Assert.assertNotNull(clienteDb);
        Assert.assertNotNull(clienteDb.getId());
        Assert.assertEquals(cliente.getCodigo(), clienteDb.getCodigo());
        System.out.println(clienteDb.getNome());

    }
    @Test
    public void buscarTodos() throws Exception{
        IClienteDao dao =  new ClienteDao();
        List<Cliente> list = dao.buscarTodos();

        Assert.assertNotNull(list);
        System.out.println(list.size());

    }

    @Test
    public void excluir() throws Exception {
        IClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("");

        Cliente clienteDb = dao.consultar(cliente.getCodigo());
        Integer qtdDel = dao.excluir(clienteDb);
        Assert.assertNotNull(qtdDel);

    }

}