package com.accenture.treinamento.projeto.livraria.controller;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.LocacaoDAO;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;

@ManagedBean
@SessionScoped
public class LocacaoController {

	private LocacaoBean locacao;

	private ArrayList<LocacaoBean> locacoes;

	public LocacaoController() {
		locacao = new LocacaoBean();
		locacoes = new ArrayList<>();
	}

	// SALVA NO BANDO DE DADOS A LOCACAO
	public void salvarLocacao() throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();

		if (ldao.saveLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Locacao adicionada com sucesso!",
					"Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o cadastro!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// EDITAR NO BANCO DE DADOS A LOCACAO EXISTENTE
	public void editarLocacao() throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();

		if (ldao.updateLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Locacao editada com sucesso!",
					"Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante a edicao!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	// REMOVE A LOCACAO DO BANCO DE DADOS
	public void deletarLocacao() throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();

		if (ldao.removeLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Locacao deletada com sucesso!",
					"Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o procedimento!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	// PESQUISA NO BANCO DE DADOS TODAS AS LOCACOES E RETORNA A ARRAYLIST DE LOCACOES
	public ArrayList<LocacaoBean> listarLocacoes(LocacaoBean locacao) throws ProjetoException{
		LocacaoDAO ldao = new LocacaoDAO();
		locacoes = ldao.listLocacoes();
		return locacoes;
	}

}
