package com.accenture.treinamento.projeto.livraria.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.ObraBean;

public interface IObraDAO {
	
	public abstract boolean cadastrarObra(ObraBean usuario) throws ProjetoException;
	public abstract boolean alterarObra(ObraBean usuario) throws ProjetoException;
	public abstract boolean excluirObra(ObraBean usuario) throws ProjetoException;
	public abstract List listaObra() throws ProjetoException;
	
}
