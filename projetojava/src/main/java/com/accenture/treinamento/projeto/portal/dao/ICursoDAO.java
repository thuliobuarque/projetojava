package com.accenture.treinamento.projeto.portal.dao;

public interface ICursoDAO {
	
	public abstract boolean cadastrarCurso(CursoBean curso) throws ProjetoException;
	public abstract boolean alterarCurso(CursoBean curso) throws ProjetoException;
	public abstract boolean excluirCurso(CursoBean curso) throws ProjetoException;
	public abstract List listaCurso() throws ProjetoException;


}
