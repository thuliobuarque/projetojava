package com.accenture.treinamento.projeto.portal.controller;

import java.util.ArrayList;
import java.util.List;

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

	// OBJETOS E CLASSES
	private AlunoBean aluno;

	// LISTAS
	private List<AlunoBean> listaAluno;

	public AlunoController() {
		// INSTANCIAS
		aluno = new AlunoBean();

		// LISTAS
		listaAluno = new ArrayList<>();
		listaAluno = null;

	}

	// METODO DE AUTENTICAR ALUNO
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

	// METODO DE ADCIONAR ALUNO
	public void cadastrarAluno() throws ProjetoException {

		AlunoDAO adao = new AlunoDAO();
		boolean cadastrou = adao.cadastrarAluno(aluno);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
		}
	}

	// METODO DE ALTERAR ALUNO
	public void alterarAluno() throws ProjetoException {

		AlunoDAO adao = new AlunoDAO();
		boolean alterou = adao.alterarAluno(aluno);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno alterado com sucesso!", "Sucesso");
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
	public void excluirProduto() throws ProjetoException {
		AlunoDAO adao = new AlunoDAO();
		boolean excluio = adao.excluirAluno(aluno);

		if (excluio == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno excluido com sucesso!", "Sucesso");
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
		aluno = null;
	}

	public AlunoBean getAluno() {
		return aluno;
	}

	public void setAluno(AlunoBean aluno) {
		this.aluno = aluno;
	}

	public List<AlunoBean> getListaAluno() {
		if (listaAluno == null) {
			AlunoDAO adao = new AlunoDAO();
			listaAluno = adao.listaAluno();
		}
		return listaAluno;
	}

	public void setListaAluno(List<AlunoBean> listaAluno) {
		this.listaAluno = listaAluno;
	}

}