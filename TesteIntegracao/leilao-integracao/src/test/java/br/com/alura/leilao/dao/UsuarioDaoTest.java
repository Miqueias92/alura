package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;
	
	@Test
	void testeBuscaUsuarioPeloUserName() {
		this.dao = new UsuarioDao(em);
		Usuario usuario = dao.buscarPorUsername("fulano");
		assertNotNull(usuario);
	}

}
