package com.accenture.treinamento.projeto.livraria.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;

public interface IObraDAO {
	
	public abstract boolean cadastrarObra(LivroBean usuario) throws ProjetoException;
	public abstract boolean alterarObra(LivroBean usuario) throws ProjetoException;
	public abstract boolean excluirObra(LivroBean usuario) throws ProjetoException;
	public abstract List listaObra() throws ProjetoException;
	
}
