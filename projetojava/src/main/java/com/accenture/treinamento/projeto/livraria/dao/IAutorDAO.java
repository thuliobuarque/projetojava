package com.accenture.treinamento.projeto.livraria.dao;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;

public interface IAutorDAO {

	public abstract boolean cadastrarAutor(AutorBean autor) throws ProjetoException;
}
