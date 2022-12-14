package br.com.voeairlines.modelo;

public class Aeronave {
	
	private String tipoAeronave; //vai vim de outra classe 
	private String fabricante;
	private String modelo;
	private String codigo;
	
	public Aeronave(String tipoAeronave, String fabricante, String modelo, String codigo) {
		this.tipoAeronave = tipoAeronave;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigo = codigo;
	}

	public String getTipoAeronave() {
		return tipoAeronave;
	}

	public void setTipoAeronave(String tipoAeronave) {
		this.tipoAeronave = tipoAeronave;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
