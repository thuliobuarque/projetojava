package com.accenture.treinamento.projeto.livraria.dao;

import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;

public interface ILocacaoDAO {
	
	public boolean saveLocacao(LocacaoBean locacao) throws ProjetoException;
	public boolean updateLocacao(LocacaoBean locacao) throws ProjetoException;
	public boolean removeLocacao(LocacaoBean locacao) throws ProjetoException;
	public ArrayList<LocacaoBean> listLocacoes() throws ProjetoException;

}
