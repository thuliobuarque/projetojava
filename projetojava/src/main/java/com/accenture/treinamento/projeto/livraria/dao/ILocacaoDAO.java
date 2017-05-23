package com.accenture.treinamento.projeto.livraria.dao;

import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;

public interface ILocacaoDAO {
	
	public abstract boolean saveLocacao(LocacaoBean locacao) throws ProjetoException;
	public abstract boolean updateLocacao(LocacaoBean locacao) throws ProjetoException;
	public abstract boolean removeLocacao(LocacaoBean locacao) throws ProjetoException;
	public abstract ArrayList<LocacaoBean> listLocacoes() throws ProjetoException;

}
