package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.DisciplinaBean;

public class DisciplinaDAO implements IDisciplinaDAO {

	private Connection conexao = null;

	
	public boolean cadastrarDisciplina(DisciplinaBean disciplina) throws ProjetoException {

		String sql = "insert into acl.disciplina (nome, cargaHoraria, professor, id, turma) values (?, ?,?, ? ,?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, disciplina.getNome());
			stmt.setString(2, disciplina.getCargaHoraria());
			stmt.setString(3, disciplina.getProfessor());
			stmt.setString(4, disciplina.getId());
			stmt.setString(5, disciplina.getTurma());
			
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

	public boolean alterarDisciplina(DisciplinaBean disciplina)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update acl.disciplina set nome = ?, cargaHoraria = ?, professor = ?, id = ?, turma = ? where id = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, disciplina.getNome());
			stmt.setString(2, disciplina.getCargaHoraria());
			stmt.setString(3, disciplina.getProfessor());
			stmt.setString(4, disciplina.getId());
			stmt.setString(5, disciplina.getTurma());
			
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
	
	public boolean excluirDisciplina(DisciplinaBean disciplina)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from acl.disciplina where id = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, disciplina.getId());
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
	
	
	public ArrayList<DisciplinaBean> listaDisciplina() {

		String sql = "select nome, cargaHoraria, professor, id, turma from acl.turma order by nome";

		ArrayList<DisciplinaBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				DisciplinaBean a = new DisciplinaBean();

				a.setNome(rs.getString("nome"));
				a.setCargaHoraria(rs.getInt("cargaHoraria"));
				a.setProfessor(rs.getString("professor"));
				a.setId(rs.getInt("id"));
				a.setTurma(rs.getTurma("turma"));
				


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
