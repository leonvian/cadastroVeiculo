package com.example.cadastropessoa.model;

public class Veiculo implements EntidadePersistivel {
 
    private int id;
    private int idPessoa;
    private String marca;
    private String modelo;
    private String placa;
 
    public Veiculo() {
    }
     
    public Veiculo(int id, int idPessoa, String marca, String modelo, String placa) {
        super();
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.idPessoa = idPessoa;
    }
 
 
    public int getIdPessoa() {
		return idPessoa;
	}
    
    public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
 
    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
 
    public String getModelo() {
        return modelo;
    }
 
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
 
    public String getPlaca() {
        return placa;
    }
 
    public void setPlaca(String placa) {
        this.placa = placa;
    }
     
    public int getId() {
        return id;
    }
     
    public void setId(int id) {
        this.id = id;
    }
     
    @Override
    public String toString() {
        return placa + " " +  modelo + " " + marca;
    }
} 