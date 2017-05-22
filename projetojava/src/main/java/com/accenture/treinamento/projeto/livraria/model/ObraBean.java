package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;

public class ObraBean {
	private int id;
	private String titulo;
	private AutorBean nome;
	private int anoPublicacao;
	private String editora;
	private String resumo;
	private String classificacao;
	private int quantidade;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PessoaBean getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public ObraBean getObra() {
		return obra;
	}
	public void setObra(ObraBean obra) {
		this.obra = obra;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	public AutorBean getAutor() {
			return nome;
	}
	public void setAutor(AutoraBean nome) {
			this.nome = nome;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getClassificao() {
		return classificao;
	}
	public void setClassificao(String classificao) {
		this.classificao = classificao;
	}
	public int getQuantidate() {
		return quantidate;
	}
	public void setQuantidate(int quantidate) {
		this.quantidate = quantidate;
	}	
	
}