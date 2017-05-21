package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.bean.AlunoBean;

public class AlunoDAO implements IAlunoDAO {

	private Connection conexao = null;

	public AlunoBean autenticarAluno(AlunoBean usuario)
			throws ProjetoException {

		System.out.println(usuario.getLogin() + usuario.getSenha());

		conexao = ConnectionFactory.getConnection();

		String sql = "select usuarios.login, usuarios.senha, usuarios.nome from acl.usuarios where usuarios.login = ? and usuarios.senha = ?";

		AlunoBean ub = null;

		try {

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, usuario.getLogin().toUpperCase());
			pstmt.setString(2, usuario.getSenha().toUpperCase());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ub = new AlunoBean();
				ub.setLogin(rs.getString("login"));
				ub.setSenha(rs.getString("senha"));
				ub.setNome(rs.getString("nome"));
			}

			return ub;
		} catch (SQLException ex) {
			throw new ProjetoException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

	public boolean cadastrarAluno(AlunoBean usuario) {

		String sql = "insert into acl.usuarios (login, senha) values (?, ?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
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
