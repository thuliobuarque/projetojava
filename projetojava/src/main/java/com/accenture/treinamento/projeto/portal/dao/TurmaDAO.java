package com.accenture.treinamento.projeto.portal.dao;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
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

	}

