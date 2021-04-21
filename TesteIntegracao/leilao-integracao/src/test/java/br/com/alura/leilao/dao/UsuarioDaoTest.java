package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;

class UsuarioDaoTest {

	private UsuarioDao dao;
	
	@Test
	void testeBuscaUsuarioPeloUserName() {
		this.dao = new UsuarioDao();
		Usuario usuario = dao.buscarPorUsername("fulano");
		assertNotNull(usuario);
	}

}
