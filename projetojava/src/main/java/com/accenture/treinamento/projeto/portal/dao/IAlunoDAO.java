package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;

public interface IAlunoDAO {

	public abstract AlunoBean autenticarAluno(AlunoBean usuario) throws ProjetoException;
	public abstract boolean cadastrarAluno(AlunoBean usuario) throws ProjetoException;


}
