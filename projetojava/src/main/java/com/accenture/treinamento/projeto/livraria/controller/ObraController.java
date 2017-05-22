package com.accenture.treinamento.projeto.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.ObraDAO;
import com.accenture.treinamento.projeto.livraria.model.ObraBean;

@ManagedBean
@SessionScoped
public class ObraController {

	private ObraBean obra;

	private List<ObraBean> listaObra;

	public ObraController() {
		obra = new ObraBean();

		listaObra = new ArrayList<>();
		listaObra = null;
	}

	public void cadastrarObra() {

		ObraDAO adao = new ObraDAO();
		boolean cadastrou = adao.cadastrarObra(obra);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Obra cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadObra.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadObra.hide();");
		}

	}

	public void alterarObra() throws ProjetoException {

		ObraDAO adao = new ObraDAO();
		boolean alterou = adao.alterarObra(obra);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Obra alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltObra.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltObra.hide();");
		}
	}

	public void excluirObra() throws ProjetoException {
		ObraDAO adao = new ObraDAO();
		boolean excluiu = adao.excluirObra(obra);

		if (excluiu == true) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Obra excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public void limparObjeto() {
		obra = null;
	}

	public ObraBean getObra() {
		return obra;
	}

	public void setObra(ObraBean obra) {
		this.obra = obra;
	}

	public List<ObraBean> getListaObra() {
		if (listaObra == null) {
			ObraDAO adao = new ObraDAO();
			listaObra = adao.listaObra();

		}
		return listaObra;
	}

	public void setListaObra(List<ObraBean> listaObra) {
		this.listaObra = listaObra;
	}

}
