package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String caminho = "jdbc:mysql://localhost/servervoeairlines?useTimezone=true&serverTimezone=UTC";
	private static final String usuario = "root";
	private static final String senha = "123407";

	public Connection getConnection() throws SQLException {
		
		
		/* Tratar os erros na hora da conexao
		* Try: intruções para conexao
		* Catch: se tiver erro */
		 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			return DriverManager.getConnection(caminho, usuario, senha);
			
			
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
			
		}
		
	}
	
}

/*public Connection getConnection() throws SQLException {
	
	Connection conexao = DriverManager.getConnection(caminho, usuario, senha);
	
	return conexao;
}*/
