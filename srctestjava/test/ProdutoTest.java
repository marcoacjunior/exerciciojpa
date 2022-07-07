package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import domain.Produto;

public class ProdutoTest {
	
	private IProdutoDAO produtoDAO;
	
	public ProdutoTest() {
		produtoDAO = new ProdutoDAO();
	}

	@Test
	public void cadastrar() {
		
		Produto produto = new Produto();
		produto.setCodigo("P1");
		produto.setNome("Produto1");
		produto.setDescricao("XXXXXXXXXXXXXX");
		produto = produtoDAO.cadastrar(produto);
		
		assertNotNull(produto);
		assertNotNull(produto.getId());
		
	}
}
