package com.example.cadastropessoa.test;

import java.util.List;

import android.test.AndroidTestCase;

import com.example.cadastropessoa.model.Pessoa;
import com.example.cadastropessoa.model.Veiculo;
import com.example.cadastropessoa.persistence.PessoaDAO;
import com.example.cadastropessoa.persistence.VeiculoDAO;

public class VeiculoDAOTest extends AndroidTestCase {
	
	public void testSalvar() {
		VeiculoDAO veiculoDAO = new VeiculoDAO(getContext());
		
		int primeiroSize = veiculoDAO.recuperarTodos().size();
		
		Veiculo veiculo = criarVeiculoExemplo(0);
		veiculoDAO.salvar(veiculo);
		
		assertTrue(veiculoDAO.recuperarTodos().size() > primeiroSize);
		veiculoDAO.fecharConexao();
	}
	
	
	public void testDeletar() {
		testSalvar();
		
		VeiculoDAO veiculoDAO = new VeiculoDAO(getContext());
		
		List<Veiculo> todasVeiculos = veiculoDAO.recuperarTodos();
		assertNotNull(todasVeiculos);
		assertFalse(todasVeiculos.isEmpty());
		
		Veiculo veiculoRecuperada  = todasVeiculos.get(0);
		assertNotNull(veiculoRecuperada);
		
		int primeiroSize = veiculoDAO.recuperarTodos().size();
		
		veiculoDAO.deletar(veiculoRecuperada);
		
		assertTrue(veiculoDAO.recuperarTodos().size() < primeiroSize);
		veiculoDAO.fecharConexao();
	}
	
	public void testRecuperar() {
		PessoaDAO pessoaDAO = new PessoaDAO(getContext());
		pessoaDAO.salvar(criarPessoaExemplo());
		Pessoa pessoa = pessoaDAO.recuperarTodos().get(0);
		
		VeiculoDAO veiculoDAO = new VeiculoDAO(getContext());
		veiculoDAO.deletarTodos();
		
		Veiculo veiculo = criarVeiculoExemplo(pessoa.getId());
		veiculoDAO.salvar(veiculo);
		
		List<Veiculo> todasVeiculosRecuperadas = veiculoDAO.recuperarTodos();
		assertTrue(todasVeiculosRecuperadas.size()  == 1);
		
		Veiculo veiculoRecuperada = todasVeiculosRecuperadas.get(0);
		
		Pessoa pessoaRecuperada = pessoaDAO.recuperarPorID(veiculoRecuperada.getIdPessoa());
	    Pessoa pessoaCriada = criarPessoaExemplo();
		
		assertEquals(pessoaCriada.getNome(), pessoaRecuperada.getNome());
		assertEquals(pessoaCriada.getIdade(), pessoaRecuperada.getIdade());
		
		Veiculo veiculoCriada = criarVeiculoExemplo(pessoa.getId());
		
		assertEquals(veiculoCriada.getModelo(), veiculoRecuperada.getModelo());
		assertEquals(veiculoCriada.getMarca(), veiculoRecuperada.getMarca());
		assertEquals(veiculoCriada.getIdPessoa(), veiculoRecuperada.getIdPessoa());
		veiculoDAO.fecharConexao();
	}
	
	public Veiculo criarVeiculoExemplo(int idPessoa) {
		Veiculo veiculo = new Veiculo(0, idPessoa, "Fiat", "Palio", "MNR4167");
		return veiculo;
	}
	
	public Pessoa criarPessoaExemplo() {
		Pessoa pessoa = new Pessoa(0,"Leonardo",24);
		return pessoa;
	}

}
