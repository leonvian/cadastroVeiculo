package com.example.cadastropessoa.test;

import java.util.List;

import com.example.cadastropessoa.model.Pessoa;
import com.example.cadastropessoa.persistence.PessoaDAO;

import android.test.AndroidTestCase;

public class PessoaDAOTest extends AndroidTestCase {

	public void testSalvar() {
		PessoaDAO pessoaDAO = new PessoaDAO(getContext());
		
		int primeiroSize = pessoaDAO.recuperarTodos().size();
		
		Pessoa pessoa = criarPessoaExemplo();
		pessoaDAO.salvar(pessoa);
		
		assertTrue(pessoaDAO.recuperarTodos().size() > primeiroSize);
		pessoaDAO.fecharConexao();
	}
	
	
	public void testDeletar() {
		testSalvar();
		
		PessoaDAO pessoaDAO = new PessoaDAO(getContext());
		
		List<Pessoa> todasPessoas = pessoaDAO.recuperarTodos();
		assertNotNull(todasPessoas);
		assertFalse(todasPessoas.isEmpty());
		
		Pessoa pessoaRecuperada  = todasPessoas.get(0);
		assertNotNull(pessoaRecuperada);
		
		int primeiroSize = pessoaDAO.recuperarTodos().size();
		
		pessoaDAO.deletar(pessoaRecuperada);
		
		assertTrue(pessoaDAO.recuperarTodos().size() < primeiroSize);
		pessoaDAO.fecharConexao();
	}
	
	public void testRecuperar() {
		PessoaDAO pessoaDAO = new PessoaDAO(getContext());
		pessoaDAO.deletarTodos();
		
		Pessoa pessoa = criarPessoaExemplo();
		pessoaDAO.salvar(pessoa);
		
		List<Pessoa> todasPessoasRecuperadas = pessoaDAO.recuperarTodos();
		assertTrue(todasPessoasRecuperadas.size()  == 1);
		
		Pessoa pessoaRecuperada = todasPessoasRecuperadas.get(0);
		Pessoa pessoaCriada = criarPessoaExemplo();
		
		assertEquals(pessoaCriada.getNome(), pessoaRecuperada.getNome());
		assertEquals(pessoaCriada.getIdade(), pessoaRecuperada.getIdade());
		pessoaDAO.fecharConexao();
	}
	
	public Pessoa criarPessoaExemplo() {
		Pessoa pessoa = new Pessoa(0,"Leonardo",24);
		return pessoa;
	}

}
