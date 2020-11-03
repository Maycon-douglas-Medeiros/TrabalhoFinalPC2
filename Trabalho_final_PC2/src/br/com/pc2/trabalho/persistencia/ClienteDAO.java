package br.com.pc2.trabalho.persistencia;

import java.util.List;

import br.com.pc2.trabalho.model.Cliente;

public interface ClienteDAO {
	public String inserir(Cliente cli);
	public String alterar(Cliente cli);
	public String excluir(Cliente cli);
	public List<Cliente> listarTodosCli();
	public List<Cliente>  pesquisarPorCodCli(String cod);
}
