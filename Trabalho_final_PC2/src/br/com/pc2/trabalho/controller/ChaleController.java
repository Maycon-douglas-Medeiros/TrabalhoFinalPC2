package br.com.pc2.trabalho.controller;

import java.util.List;

import br.com.pc2.trabalho.model.Chale;
import br.com.pc2.trabalho.persistencia.ChaleDAOImp;

public class ChaleController {
	public String inserir(Chale ch){
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.inserir(ch);
	}
	public String alterar(Chale ch) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.alterar(ch);
	}
	public String excluir(Chale ch){
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.excluir(ch);
	}
	public List<Chale> listarTodos(){
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.listarTodos();
	}
	public Chale pesquisarPorCod(String cod){
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.pesquisarPorCod(cod);
	}
}
