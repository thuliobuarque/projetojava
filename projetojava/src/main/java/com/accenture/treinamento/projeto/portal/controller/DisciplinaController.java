package com.accenture.treinamento.projeto.portal.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;



import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.DisciplinaBean;
import com.accenture.treinamento.projeto.portal.dao.AlunoDAO;
import com.accenture.treinamento.projeto.portal.dao.DisciplinaDAO;

/**
*
* @author Thulio, thayse, Thales, Caio, Priscila, Veridiana
* @since 21/05/2017
*/

@ManagedBean(name = "MBDisciplinas")
@SessionScoped
public class DisciplinaController {

	private DisciplinaBean disciplina;
	
	public DisciplinaController() {
		disciplina = new DisciplinaBean();

	}

	public void cadastrarDisciplina() {

		DisciplinaDAO Ddao = new DisciplinaDAO();
		
		boolean cadastrou = Ddao.cadastrarDisciplina(disciplina);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina cadastrada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgCadSistema.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro da disciplina!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgCadSistema.hide();");
		}
	}
	
	
	// METODO DE ALTERAR DISCIPLINA
	public void alterarDisciplina() throws ProjetoException {

		DisciplinaDAO Ddao = new DisciplinaDAO();
		boolean alterou = Ddao.alterarDisciplina(disciplina);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina alterada com sucesso!", "Sucesso");
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
	public void excluirDisciplina() throws ProjetoException {
		DisciplinaDAO Ddao = new DisciplinaDAO();
		boolean excluir = Ddao.excluirDisciplina(disciplina);

		if (excluir == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina excluída com sucesso!", "Sucesso");
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
		disciplina = null;
	}

	public DisciplinaBean getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplina = disciplina;
	}

}
