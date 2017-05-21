package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;

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

	public boolean cadastrarAluno(AlunoBean aluno) throws ProjetoException {

		String sql = "insert into acl.alunos (login, senha) values (?, ?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getLogin());
			stmt.setString(2, aluno.getSenha());
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

	public boolean alterarAluno(AlunoBean aluno)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update acl.alunos set nome = ?, senha = ? where idalunos = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getSenha());
			stmt.setInt(3, aluno.getId_aluno());
			stmt.executeUpdate();
			conexao.commit();

			alterou = true;

			return alterou;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public boolean excluirAluno(AlunoBean aluno)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from acl.alunos where idalunos = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, aluno.getId_aluno());
			stmt.executeUpdate();

			conexao.commit();

			excluir = true;

			return excluir;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
	public ArrayList<AlunoBean> listaAluno() {

		String sql = "select idalunos, login, senha, nome from acl.alunos order by nome";

		ArrayList<AlunoBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				AlunoBean a = new AlunoBean();

				a.setId_aluno(rs.getInt("idalunos"));
				a.setLogin(rs.getString("login"));
				a.setSenha(rs.getString("senha"));
				a.setNome(rs.getString("nome"));


				lista.add(a);
			}
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
		return lista;
	}

}
