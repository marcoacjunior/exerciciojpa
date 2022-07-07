package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Produto;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Produto cadastrar(Produto produto) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
		
		return produto;
	}
	
	
		
	}


