package com.accenture.treinamento.projeto.portal.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.AlunoDAO;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 26/03/2015
 */

@ManagedBean(name = "MBAlunos")
@SessionScoped
public class AlunoController {

	private AlunoBean aluno;

	public AlunoController() {
		aluno = new AlunoBean();

	}

	public String login() throws ProjetoException {

		AlunoDAO ud = new AlunoDAO();
		aluno = ud.autenticarAluno(aluno);

		if (aluno == null) {
			FacesContext fct = FacesContext.getCurrentInstance();
			fct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuário ou senha inválidos!", "Erro"));

			return "";
		} else {

			return "/pages/comum/principal.faces?faces-redirect=true";
		}
	}

	public void cadastrarAluno() {

		AlunoDAO sdao = new AlunoDAO();
		boolean cadastrou = sdao.cadastrarAluno(aluno);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno cadastrado com sucesso!", "Sucesso");
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
		aluno = null;
	}

	public AlunoBean getAluno() {
		return aluno;
	}

	public void setAluno(AlunoBean aluno) {
		this.aluno = aluno;
	}

}