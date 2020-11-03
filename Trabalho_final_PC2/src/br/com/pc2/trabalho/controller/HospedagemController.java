package br.com.pc2.trabalho.controller;

import java.util.List;

import br.com.pc2.trabalho.model.Hospedagem;
import br.com.pc2.trabalho.persistencia.HospedagemDAOImp;

public class HospedagemController {
	public String inserir(Hospedagem ch){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.inserir(ch);
	}
	public String alterar(Hospedagem ch) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(ch);
	}
	public String excluir(Hospedagem ch){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.excluir(ch);
	}
	public List<Hospedagem> listarTodosHosp(){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.listarTodosHosp();
	}
	public Hospedagem pesquisarPorCodHosp(String cod){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodHosp(cod);
	}
}
