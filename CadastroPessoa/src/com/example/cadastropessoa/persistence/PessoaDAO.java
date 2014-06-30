package com.example.cadastropessoa.persistence;

import android.content.ContentValues;
import android.content.Context;

import com.example.cadastropessoa.model.Pessoa;

public class PessoaDAO  extends DAOBasico<Pessoa> {

	private static final String NOME_TABELA = "PESSOA";
	public static final String SCRIPT_CRIACAO_TABELA = "CREATE TABLE  PESSOA ( id INTEGER PRIMARY KEY autoincrement, nome TEXT,idade INTEGER)";
	public static final String SCRIPT_DELECAO_TABELA =  "DROP TABLE IF EXISTS " + NOME_TABELA;

	private static final String COLUNA_ID = "id";
	private static final String COLUMA_NOME = "nome";
	private static final String COLUNA_IDADE = "idade";

	public PessoaDAO(Context context) {
		super(context); 
	}

	@Override
	public String getNomeColunaPrimaryKey() {
		return COLUNA_ID;
	}

	@Override
	public String getNomeTabela() {
		return NOME_TABELA;
	}

	public ContentValues entidadeParacontentValues(Pessoa pessoa) {
		ContentValues contentValues = new ContentValues();
		if(pessoa.getId() > 0) {
			contentValues.put(COLUNA_ID, pessoa.getId());
		}
		contentValues.put(COLUNA_IDADE, pessoa.getIdade());
		contentValues.put(COLUMA_NOME, pessoa.getNome());
		return contentValues;
	}

	@Override
	public Pessoa contentValuesParaEntidade(ContentValues contentValues) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(contentValues.getAsInteger(COLUNA_ID));
		pessoa.setIdade(contentValues.getAsInteger(COLUNA_IDADE));
		pessoa.setNome(contentValues.getAsString(COLUMA_NOME));
		return pessoa;
	}

}