package com.accenture.treinamento.projeto.portal.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;
import com.accenture.treinamento.projeto.portal.dao.AlunoDAO;
/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 21/05/2017
*/

@ManagedBean(name = "MBTurma")
@SessionScoped
public class TurmaController {

		private TurmaBean turma;
		
		private Connection conexao = null;

		public TurmaController() {
			turma = new TurmaBean();

		}

		
		public void cadastrarTurma() {

			TurmaDAO Tdao = new TurmaDAO();
			boolean cadastrou = Tdao.cadastrarTurma(turma);

			if (cadastrou == true) {

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Turma cadastrada com sucesso!", "Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				RequestContext.getCurrentInstance()
						.execute("dlgCadSistema.hide();");
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ocorreu um erro durante o cadastro!", "Erro");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				RequestContext.getCurrentInstance()
						.execute("dlgCadSistema.hide();");
			}
		}

		public void LimparObjeto() {
			turma = null;
		}

		public TurmaBean getTurma() {
			return turma;
		}

		public void setTurma(TurmaBean turma) {
			this.turma = turma;
		}
		
		public boolean alterarTurma(TurmaBean turma)
				throws ProjetoException {
			boolean alterou = false;
			String sql = "update acl.turma set id = ?, codigoTurma = ?, Aluno = ? where id = ?";
			try {
				conexao = ConnectionFactory.getConnection();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, turma.getId());
				stmt.setString(2, turma.getCodigoTurma());
				stmt.setInt(3, turma.getAluno());
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
		
		
		
		
		public boolean excluirTurma(TurmaBean turma)
				throws ProjetoException {
			boolean excluir = false;
			String sql = "delete from acl.turma where id = ?";
			try {
				conexao = ConnectionFactory.getConnection();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, turma.getId());
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
		
		
		public ArrayList<TurmaBean> listaTurma() {

			String sql = "select id, codigoTurma, alunos from acl.turma order by codigoTurma";

			ArrayList<TurmaBean> lista = new ArrayList();
			try {
				conexao = ConnectionFactory.getConnection();
				PreparedStatement stm = conexao.prepareStatement(sql);
				ResultSet rs = stm.executeQuery();

				while (rs.next()) {
					TurmaBean a = new TurmaBean();

					a.setId(rs.getInt("id"));
					a.setcodigoTurma(rs.getString("codigoTurma"));
					a.setAlunos(rs.getString("alunos"));
					
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





