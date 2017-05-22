package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.ReservaBean;

public class ReservaDAO implements IReservaDAO {

	private Connection conexao = null;

	@Override
	public boolean saveReserva(ReservaBean Reserva) throws ProjetoException {
		String query = "INSERT INTO acl.Reserva ( d_retirada) values (?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, Reserva.getDataRetirada());
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
	public boolean updateReserva(ReservaBean Reserva) throws ProjetoException {
		String query = "UPDATE acl.Reserva set d_retirada = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, Reserva.getDataReserva());
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
	public boolean removeReserva(ReservaBean Reserva) throws ProjetoException {
		String query = "DELETE acl.Reserva WHERE  d_retirada = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, Reserva.getDataRetirada());
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
	public ArrayList<ReservaBean> listreservas() throws ProjetoException {
		ArrayList<ReservaBean> reservas = new ArrayList<>();

		String query = "SELECT * FROM acl.Reserva";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReservaBean Reserva = new ReservaBean();

				Reserva.setId(rs.getInt("id_Reserva"));
				Reserva.setDataReserva(rs.getDate("d_Retirada"));
				reserva.add(Reserva);
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
		return reservas;
	}

}