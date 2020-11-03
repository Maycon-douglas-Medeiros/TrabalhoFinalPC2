package br.com.pc2.trabalho.persistencia;

import java.util.List;

import br.com.pc2.trabalho.model.Chale;

public interface ChaleDAO {
	public String inserir(Chale ch);
	public String alterar(Chale ch);
	public String excluir(Chale ch);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCod(String cod);
}
