package br.com.voeairlines.modelo;

public class TipoAeronave {
	
	private int id;
	private String tipoAeronave;
	private String descricao;
	
	public TipoAeronave(int id, String tipoAeronave, String descricao) {
		this.id = id;
		this.tipoAeronave = tipoAeronave;
		this.descricao = descricao;
	}
	
	public TipoAeronave(String tipoAeronave, String descricao) {
		this.tipoAeronave = tipoAeronave;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoAeronave() {
		return tipoAeronave;
	}

	public void setTipoAeronave(String tipoAeronave) {
		this.tipoAeronave = tipoAeronave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
