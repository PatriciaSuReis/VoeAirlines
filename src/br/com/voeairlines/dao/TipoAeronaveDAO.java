package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.voeairlines.modelo.TipoAeronave;



public class TipoAeronaveDAO {
	
	private final Connection connection;
	
	public TipoAeronaveDAO(Connection connection) {
		this.connection = connection;
	}
		
	public void insert (TipoAeronave tipo) throws SQLException {
		//salvar(inserir) dados do tipo da aeronave no banco de dados
		String sql = "insert into tipo_aeronave (tipo,descricao) values (?, ?);";	
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//segurança no cadastro -- em vez de concatenar na string sql
		statement.setString(1, tipo.getTipoAeronave());
		statement.setString(2, tipo.getDescricao());
		
		statement.execute();
		
	}

	public boolean existeNoBancoPorTipooEDescrição(TipoAeronave tipo) throws SQLException {
		//consultar no banco de dados
		String sql = "select * from tipo_aeronave where tipo = ? and descricao = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//segurança na cosultar-- em vez de concatenar na string sql
		statement.setString(1, tipo.getTipoAeronave());
		statement.setString(2, tipo.getDescricao());
		
		statement.execute();
		
		ResultSet resultSet = statement.getResultSet();
		
		//verificar se tem resultado ou não e retorna o resultado
		return resultSet.next();
	}
}
