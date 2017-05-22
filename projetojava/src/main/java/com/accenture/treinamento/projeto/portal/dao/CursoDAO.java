package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.CursoBean;

public class CursoDAO implements ICursoDAO {

	private Connection conexao = null;

	conexao = ConnectionFactory.getConnection();

		
	public boolean cadastrarCurso(CursoBean curso) throws ProjetoException {

		String sql = "insert into acl.curso (id, codigoCurso, nomeCurso, disciplina) values (?, ?, ? ?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, curso.getId());
			stmt.setString(2, curso.getCodigoCurso());
			stmt.setString(3, curso.getNomeCurso());
			stmt.setString(4, curso.getDisciplina());
			
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

	public boolean alterarCurso(CursoBean curso)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update acl.curso set id = ?, codigoCurso = ?, nomeCurso = ?, disciplina = ? where id = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, curso.getId());
			stmt.setString(2, curso.getCodigoCurso());
			stmt.setString(3, curso.getNomeCurso());
			stmt.setString(4, curso.getDisciplina());
			
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
	
	public boolean excluirCurso(CursoBean curso)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from acl.cursos where id = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, curso.getId());
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

	
	public ArrayList<CursoBean> listaCurso() {

		String sql = "select ac1.id, ac1.codigoCurso, ac1.nomeCurso, ac2.disciplina from acl.curso, ac2.disciplina order by nomeCurso";

		ArrayList<CursoBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				CursoBean a = new CursoBean();

				a.setId(rs.getInt("id"));
				a.setCodigoCurso(rs.getString("codigoCurso"));
				a.setNomeCurso(rs.getString("nomeCurso"));
				a.setDisciplina(rs.getString("disciplina"));


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
