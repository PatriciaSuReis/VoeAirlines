package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.voeairlines.modelo.Usuario;

public class UsuarioDAO {
	
	private final Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
		
	public void insert (Usuario usuario) throws SQLException {
		//salvar(inserir) dados do usuario no banco de dados
		String sql = "insert into user (nome,senha) values (?, ?);";	
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//segurança no cadastro -- em vez de concatenar na string sql
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getSenha());
		
		statement.execute();	
	}

	public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
		//consultar no banco de dados
		String sql = "select * from user where nome = ? and senha = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//segurança na cosultar-- em vez de concatenar na string sql
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getSenha());
		
		statement.execute();
		
		ResultSet resultSet = statement.getResultSet();
		
		//verificar se tem resultado ou não
		return resultSet.next();
	}

}
