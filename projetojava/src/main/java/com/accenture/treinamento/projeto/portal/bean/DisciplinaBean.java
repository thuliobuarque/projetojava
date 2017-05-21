package com.accenture.treinamento.projeto.portal.bean;

public class DisciplinaBean {
	
	private int codigo;
	private String nome;
	private int cargaHoraria;
	private ProfessorBean professor;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public ProfessorBean getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorBean professor) {
		this.professor = professor;
	}
	
	
	
	
	
	

}
