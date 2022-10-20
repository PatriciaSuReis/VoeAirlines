package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.dao.Conexao;
import br.com.voeairlines.dao.UsuarioDAO;
import br.com.voeairlines.modelo.Usuario;
import br.com.voeairlines.tela.ViewLogin;
import br.com.voeairlines.tela.ViewMenu;

public class LoginController {

	private ViewLogin view;

	public LoginController(ViewLogin view) {
		this.view = view;
	}

	public void autenticar() throws SQLException{
		
		//buscar usuario da view
		String usuario = view.getTextUsuario().getText();
		String senha = view.getPfSenha().getText();
		
		Usuario usuarioAutentidicar = new Usuario(usuario,senha);
		
		//verificar se existe no banco de dados	
		Connection conexao = new Conexao().getConnection();
		UsuarioDAO usuarioDao = new UsuarioDAO(conexao);

		//pergunta se existe usuario no usuarioDAO
		boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutentidicar);
		
		//se existe exibir menu
		if (existe) {
			ViewMenu telaMenu = new ViewMenu();
			telaMenu.TelaMenu();
		} else {
			JOptionPane.showMessageDialog(null, "Usuário ou Senha inválida!");
		}
	}
	
	
}
