package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.voeairlines.dao.Conexao;
import br.com.voeairlines.dao.TipoAeronaveDAO;
import br.com.voeairlines.modelo.TipoAeronave;
import br.com.voeairlines.tela.ViewCadastroTipoAeronava;
import br.com.voeairlines.tela.ViewCadastroUser;

public class CadastroTipoAeronaveController {
	
	private ViewCadastroTipoAeronava view;

	public CadastroTipoAeronaveController(ViewCadastroTipoAeronava view) {
		this.view = view;
	}
		
		public void salvarTipoAeronave() {
			//pegar dados digitados no view
			String tipo = view.getTextFieldTipo().getText();
			String descricao = view.getTextFieldDescricao().getText();
			//criar o tipo
			TipoAeronave tipoBD = new TipoAeronave(tipo,descricao);
							
			try {
				Connection conexao = new Conexao().getConnection();
				TipoAeronaveDAO tipoDAO = new TipoAeronaveDAO(conexao);
				tipoDAO.insert(tipoBD);
				
				JOptionPane.showMessageDialog(null, "Tipo de aeronave salva");
				
			} catch (SQLException ex) {
				Logger.getLogger(ViewCadastroUser.class.getName()).log(Level.SEVERE, null, ex);
				}
	}
	
}
