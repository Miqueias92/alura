package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;
	
	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
	
	@Test
	void deveriaEncontrarUsuarioCadastrado() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@gmail.com")
				.comSenha("123456")
				.criar();
		
		em.persist(usuario);
		
		Usuario encontrado = dao.buscarPorUsername(usuario.getNome());
		assertNotNull(encontrado);
	}
	
	@Test
	void naoDeveriaEncontrarUsuarioNaoCadastrado() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@gmail.com")
				.comSenha("123456")
				.criar();
		
		em.persist(usuario);
		
		assertThrows(NoResultException.class, 
				() -> dao.buscarPorUsername("beltrano"));
	}
	
	@Test
	void deveriaRemoverUmUsuario() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@gmail.com")
				.comSenha("123456")
				.criar();
		
		em.persist(usuario);
		
		dao.deletar(usuario);
		
		assertThrows(NoResultException.class, 
				() -> dao.buscarPorUsername(usuario.getNome()));
	}
}
