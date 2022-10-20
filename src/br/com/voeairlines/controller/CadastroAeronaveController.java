package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.voeairlines.dao.AeronaveDAO;
import br.com.voeairlines.dao.Conexao;
import br.com.voeairlines.modelo.Aeronave;
import br.com.voeairlines.tela.ViewCadastroAeronave;


public class CadastroAeronaveController {
	
	private ViewCadastroAeronave view;

	//construtor
	public CadastroAeronaveController(ViewCadastroAeronave view) {
		this.view = view;
	}
	
	//metodo
	public void salvarAeronave() {

		//pegar dados digitados no view
		String tipoaeronave = view.getTextFieldTipo().getText();
		String fabricante = view.getTextFieldFabricante().getText();
		String modelo = view.getTextFieldModelo().getText();
		String codigo = view.getTextFieldCodigo().getText();
		
		//criar o tipo
		Aeronave aeronaveBD = new Aeronave(tipoaeronave,fabricante,modelo,codigo);
						
		try {
			Connection conexao = new Conexao().getConnection();
			AeronaveDAO aeronaveDAO = new AeronaveDAO(conexao);
			aeronaveDAO.insert(aeronaveBD);
			
			JOptionPane.showMessageDialog(null, "Dados da Aeronave salvos!");
			
		} catch (SQLException ex) {
			Logger.getLogger(ViewCadastroAeronave.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
