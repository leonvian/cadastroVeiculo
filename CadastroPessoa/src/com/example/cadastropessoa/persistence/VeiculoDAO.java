package com.example.cadastropessoa.persistence;

import android.content.ContentValues;
import android.content.Context;

import com.example.cadastropessoa.model.Veiculo;

public class VeiculoDAO extends DAOBasico<Veiculo> {


	public static final String NOME_TABELA = "Veiculo";
	public static final String COLUNA_ID = "id";
	public static final String COLUNA_ID_PESSOA = "id_pessoa";
	public static final String COLUNA_MARCA = "marca";
	public static final String COLUNA_MODELO = "modelo";
	public static final String COLUNA_PLACA = "placa";


	public static final String SCRIPT_CRIACAO_TABELA_VEICULOS = "CREATE TABLE " + NOME_TABELA + "("
			+ COLUNA_ID + " INTEGER PRIMARY KEY autoincrement,"
			+ COLUNA_ID_PESSOA + " INTEGER,"
			+ COLUNA_MARCA + " TEXT," 
			+ COLUNA_PLACA + " TEXT,"
			+ COLUNA_MODELO + " TEXT" 
			+ ")";

	public static final String SCRIPT_DELECAO_TABELA =  "DROP TABLE IF EXISTS " + NOME_TABELA;

	private static VeiculoDAO instance;

	public static VeiculoDAO getInstance(Context context) {
		if(instance == null)
			instance = new VeiculoDAO(context);
		return instance;
	}

	public VeiculoDAO(Context context) {
		super(context);
	}

	@Override
	public String getNomeTabela() {  
		return NOME_TABELA;
	}

	@Override
	public String getNomeColunaPrimaryKey() {
		return COLUNA_ID;
	}

	public ContentValues entidadeParacontentValues(Veiculo veiculo) {
		ContentValues values = new ContentValues();
		if(veiculo.getId() > 0) {
			values.put(COLUNA_ID, veiculo.getId());
		}
		values.put(COLUNA_ID_PESSOA, veiculo.getIdPessoa());
		values.put(COLUNA_MARCA, veiculo.getMarca());
		values.put(COLUNA_MODELO, veiculo.getModelo());
		values.put(COLUNA_PLACA, veiculo.getPlaca());

		return values;
	}

	@Override
	public Veiculo contentValuesParaEntidade(ContentValues contentValues) {
		Veiculo veiculo = new Veiculo();
		veiculo.setId(contentValues.getAsInteger(COLUNA_ID));
		veiculo.setIdPessoa(contentValues.getAsInteger(COLUNA_ID_PESSOA));
		veiculo.setMarca(contentValues.getAsString(COLUNA_MARCA));
		veiculo.setModelo(contentValues.getAsString(COLUNA_MODELO));
		veiculo.setPlaca(contentValues.getAsString(COLUNA_PLACA));
		return veiculo;
	}
}