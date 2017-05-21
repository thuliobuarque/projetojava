package com.accenture.treinamento.projeto.portal.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.fileupload.RequestContext;

import com.accenture.treinamento.projeto.portal.bean.AutorBean;

@ManagedBean
@SessionScoped
public class autorController {

	
	private AutorBean autor;
	
	public autorController() {
		autor = new AutorBean();
	}
	
	public void cadastrarAutor() {
	
		autorDAO adao = new autorDAO();
		boolean cadastrou = adao.cadastrarAutor(autor);
		
		if (cadastrou == true) {
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Autor cadastrado com sucesso!", "Sucesso");
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
