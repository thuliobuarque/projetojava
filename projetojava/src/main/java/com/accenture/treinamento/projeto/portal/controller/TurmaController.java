package com.accenture.treinamento.projeto.portal.controller;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.controller.TurmaController;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;
import com.accenture.treinamento.projeto.portal.dao.TurmaDAO;	

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 21/05/2017
*/

@ManagedBean(name = "MBTurma")
@SessionScoped
public class TurmaController {

		private TurmaBean turma;

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

		// METODO DE ALTERAR TURMA
		public void alterarTurma() throws ProjetoException {

			TurmaDAO Tdao = new TurmaDAO();
			boolean alterou = Tdao.alterarDisciplina(turma);

			if (alterou == true) {

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Turma alterada com sucesso!", "Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ocorreu um erro durante o cadastro!", "Erro");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
			}
		}

		// METODO DE EXCLUIR ALUNO
		public void excluirTurma() throws ProjetoException {
			TurmaDAO Tdao = new TurmaDAO();
			boolean excluir = Tdao.excluirTurma(turma);

			if (excluir == true) {

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Turma excluída com sucesso!", "Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				// listaLaudo = null;
				RequestContext.getCurrentInstance().execute(
						"PF('dialogAtencao').hide();");
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ocorreu um erro durante a exclusao!", "Erro");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				RequestContext.getCurrentInstance().execute(
						"PF('dialogAtencao').hide();");
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

	}

