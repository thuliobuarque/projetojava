package com.accenture.treinamento.projeto.portal.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.resource.cci.ConnectionFactory;

import com.accenture.treinamento.projeto.portal.bean.AutorBean;
import com.mysql.jdbc.Connection;

public class autorDAO implements IautorDAO {

	private Connection conexao = null;
	
	public boolean cadastrarAutor(AutorBean autor) {
		
		String sql = "insert into acl.autor (nome) values (?)";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, autor.getNome());
			stmt.execute();
			
			conexao.commit();
			return true;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		}
		
	}
}
