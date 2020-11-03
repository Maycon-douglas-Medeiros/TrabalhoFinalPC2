package br.com.pc2.trabalho.controller;

import java.util.List;

import br.com.pc2.trabalho.model.Cliente;
import br.com.pc2.trabalho.persistencia.ClienteDAOImp;

public class ClienteController {
	public String inserir(Cliente cli){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.inserir(cli);
	}
	public String alterar(Cliente cli) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.alterar(cli);
	}
	public String excluir(Cliente cli){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.excluir(cli);
	}
	public List<Cliente> listarTodosCli(){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.listarTodosCli();
	}
	public List<Cliente> pesquisarPorCodCli(String cod){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.pesquisarPorCodCli(cod);
	}
}
