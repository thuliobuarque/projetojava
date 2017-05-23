package com.accenture.treinamento.projeto.portal.controller;

import java.util.ArrayList;
import java.util.List;

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
 * @since 17/05/2017
 */

@ManagedBean(name = "MBDisciplinas")
@SessionScoped
public class DisciplinaController {

	private DisciplinaBean disciplina;

	// LISTAS
	private List<DisciplinaBean> listaDisciplina;

	public DisciplinaController() {
		// INSTANCIAS
		disciplina = new DisciplinaBean();

		// LISTAS
		listaDisciplina = new ArrayList<>();
		listaDisciplina = null;

	}

	public void cadastrarDisciplina() throws ProjetoException {

		DisciplinaDAO Ddao = new DisciplinaDAO();

		boolean cadastrou = Ddao.cadastrarDisciplina(disciplina);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina cadastrada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgCadDisciplina.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro da disciplina!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgCadDisciplina.hide();");
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

			RequestContext.getCurrentInstance().execute(
					"dlgAltDisciplina.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgAltDisciplina.hide();");
		}
	}

	// METODO DE EXCLUIR ALUNO
	public void excluirDisciplina() throws ProjetoException {
		DisciplinaDAO Ddao = new DisciplinaDAO();
		boolean excluir = Ddao.excluirDisciplina(disciplina);

		if (excluir == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina exclu�da com sucesso!", "Sucesso");
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

	public List<DisciplinaBean> getListaDisciplina() {
		if (listaDisciplina == null) {
			DisciplinaDAO ddao = new DisciplinaDAO();
			listaDisciplina = ddao.listaDisciplina();
		}
		return listaDisciplina;
	}

	public void setListaDisciplina(List<DisciplinaBean> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

}
