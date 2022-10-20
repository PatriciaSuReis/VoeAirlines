package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.voeairlines.modelo.Aeronave;

public class AeronaveDAO {

	private final Connection connection;
	
	public AeronaveDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert (Aeronave aeronave) throws SQLException {
		//salvar(inserir) dados da aeronave no banco de dados
		String sql = "insert into aeronave (tipo, fabricante, modelo, codigo) values (?, ?, ?, ?);";	
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//segurança no cadastro -- em vez de concatenar na string sql
		statement.setString(1, aeronave.getTipoAeronave());
		statement.setString(2, aeronave.getFabricante());
		statement.setString(3, aeronave.getModelo());
		statement.setString(4, aeronave.getCodigo());
		
		statement.execute();
		
	}

	/*public boolean existeNoBancoPorTipooEDescrição(Aeronave aeronave) throws SQLException {
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
	}*/

}
