package com.accenture.treinamento.projeto.livraria.dao;

import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;

public interface IreservaDAO {
	
	public boolean saveLocacao(ReservaBean reserva) throws ProjetoException;
	public boolean updateLocacao(ReservaBean reserva) throws ProjetoException;
	public boolean removeLocacao(ReservaBean reserva) throws ProjetoException;
	public ArrayList<LocacaoBean> listLocacoes() throws ProjetoException;

}
