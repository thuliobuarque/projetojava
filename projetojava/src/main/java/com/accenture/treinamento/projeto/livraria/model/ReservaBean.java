package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;

public class ReservaoBean {
	
	private Integer id;
	private PessoaBean pessoa;
	private Date dataRetirada;
	private ObraBean obra;
	
	
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
	public Date getRetirada() {
		return dataRetirada;
	}
	public void setRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public ObraBean getObra() {
		return obra;
	}
	public void setObra(ObraBean obra) {
		this.obra = obra;
	}
	
}