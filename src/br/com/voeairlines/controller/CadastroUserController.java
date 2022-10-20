package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.voeairlines.dao.Conexao;
import br.com.voeairlines.dao.UsuarioDAO;
import br.com.voeairlines.modelo.Usuario;
import br.com.voeairlines.tela.ViewCadastroUser;

public class CadastroUserController {
	
	private ViewCadastroUser view;

	public CadastroUserController(ViewCadastroUser view) {
		this.view = view;
	}
	
	public void salvarUsuario() {
		//pegar dados digitados no view
		String usuario = view.getTextFieldNome().getText();
		String senha = view.getPasswordFieldSenha().getText();
		//criar o usuario
		Usuario usuarioBD = new Usuario(usuario,senha);
			
		//passar para o banco com o pacote DAO
		try {
			Connection conexao = new Conexao().getConnection();
			UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
			usuarioDao.insert(usuarioBD);
			
			JOptionPane.showMessageDialog(null, "Usuário salvo!");
			
		} catch (SQLException ex) {
			Logger.getLogger(ViewCadastroUser.class.getName()).log(Level.SEVERE, null, ex);
			}
	}

}
