package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import dao.ProdutoDAO;
import dao.IProdutoDAO;
import domain.Produto;


public class ProdutoTest {

	IProdutoDAO produtoDAO;

	public ProdutoTest() {
		produtoDAO = new ProdutoDAO();
	}

	@After
	public void end() {
		List<Produto> list = produtoDAO.buscarTodos();
		list.forEach(pro -> produtoDAO.excluir(pro));
	}

	@Test
	public void cadastrar() {
		Produto produto = criarProduto();
		assertNotNull(produto);

		Produto produtoDB = produtoDAO.buscarPorID(produto.getId());
		assertNotNull(produtoDB);
		assertEquals(produto.getId(), produtoDB.getId());
		assertEquals(produto.getNome(), produtoDB.getNome());

	}

	@Test
	public void alterar() {
		Produto produto = criarProduto();
		assertNotNull(produto);

		Produto produtoDB = produtoDAO.buscarPorID(produto.getId());
		assertNotNull(produtoDB);
		assertEquals(produto.getId(), produtoDB.getId());
		assertEquals(produto.getNome(), produtoDB.getNome());

		produtoDB.setNome("Produto2");
		Produto produtoUp = produtoDAO.alterar(produtoDB);
		assertEquals("Produto2", produtoUp.getNome());

	}

	private Produto criarProduto() {
		Produto produto = new Produto();
		produto.setCodigo("P1");
		produto.setNome("Produto1");
		produto.setDescricao("XXXXXXXXXX");
		produto = produtoDAO.cadastrar(produto);	
		return produto;
	}
}
