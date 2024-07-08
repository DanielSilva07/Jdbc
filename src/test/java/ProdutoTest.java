import br.com.danielsilva.dao.ClienteDao;
import br.com.danielsilva.dao.IClienteDao;
import br.com.danielsilva.dao.IProdutoDao;
import br.com.danielsilva.dao.ProdutoDao;
import br.com.danielsilva.domain.Cliente;
import br.com.danielsilva.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void cadastrar() throws Exception{
        IProdutoDao dao = new ProdutoDao();
        Produto produto = new Produto();
        produto.setNomeP("rtx-4060");
        produto.setCodigoP("02");
        produto.setPrecoP(4.000D);

        Integer qtd = dao.cadastrar(produto);
        Assert.assertTrue(qtd == 1);

    }
    @Test
    public void consultar() throws Exception {
        IProdutoDao dao = new ProdutoDao();
        Produto produto = new Produto();
        produto.setCodigoP("02");

        Produto produtoDb = dao.consultar(produto.getCodigoP());
        Assert.assertNotNull(produtoDb);
        Assert.assertNotNull(produtoDb.getId());
        Assert.assertEquals(produto.getCodigoP(), produtoDb.getCodigoP());
        System.out.println(produtoDb.getNomeP());

    }

}