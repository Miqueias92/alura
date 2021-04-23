package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;
	
	@Test
	void testeBuscaUsuarioPeloUserName() {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		Usuario usuario = new Usuario("fulano", "fulano@gmail.com", "123456");
		em.persist(usuario);
		em.getTransaction().commit();
		
		this.dao = new UsuarioDao(em);
		Usuario encontrado = dao.buscarPorUsername(usuario.getNome());
		assertNotNull(encontrado);
	}

}
