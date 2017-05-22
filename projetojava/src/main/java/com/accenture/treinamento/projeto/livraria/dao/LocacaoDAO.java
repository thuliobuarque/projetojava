package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;

public class LocacaoDAO implements ILocacaoDAO {

	private Connection conexao = null;

	@Override
	public boolean saveLocacao(LocacaoBean locacao) throws ProjetoException {
		String query = "INSERT INTO acl.locacao (d_locacao, d_entrega) values (?, ?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, locacao.getDataLocacao());
			ps.setDate(1, locacao.getDataEntrega());
			ps.execute();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateLocacao(LocacaoBean locacao) throws ProjetoException {
		String query = "UPDATE acl.locacao set d_locacao = ?, d_entrega = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, locacao.getDataLocacao());
			ps.setDate(1, locacao.getDataEntrega());
			ps.executeUpdate();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean removeLocacao(LocacaoBean locacao) throws ProjetoException {
		// NECESSÁRIO A OBRA IMPLEMENTADA
		// LOCALIZA AS OBRAS DA LOCACAO NO BANCO E ADICIONA A QUANTIDADE
		// RETIRADA PARA A LOCACAO
		// DELETA A LOCACAO DO BANCO
		String query = "DELETE acl.locacao WHERE d_locacao = ?, d_entrega = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, locacao.getDataLocacao());
			ps.setDate(1, locacao.getDataEntrega());
			ps.executeUpdate();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<LocacaoBean> listLocacoes() throws ProjetoException {
		ArrayList<LocacaoBean> locacoes = new ArrayList<>();

		String query = "SELECT * FROM acl.locacao";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LocacaoBean locacao = new LocacaoBean();

				locacao.setId(rs.getInt("id_locacao"));
				locacao.setDataLocacao(rs.getDate("d_locacao"));
				locacao.setDataEntrega(rs.getDate("d_entrega"));
				locacoes.add(locacao);
			}
		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return locacoes;
	}

}
