package com.accenture.treinamento.projeto.livraria.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.livraria.dao.AutorDAO;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;

@ManagedBean
@SessionScoped
public class AutorController {

	private AutorBean autor;

	public AutorController() {
		autor = new AutorBean();
	}

	public void cadastrarAutor() {

		AutorDAO adao = new AutorDAO();
		boolean cadastrou = adao.cadastrarAutor(autor);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Autor cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgCadAutor.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgCadAutor.hide();");
		}

	}

	public void limparObjeto() {
		autor = null;
	}

	public AutorBean getAutor() {
		return autor;
	}

	public void setAutor(AutorBean autor) {
		this.autor = autor;
	}

}
