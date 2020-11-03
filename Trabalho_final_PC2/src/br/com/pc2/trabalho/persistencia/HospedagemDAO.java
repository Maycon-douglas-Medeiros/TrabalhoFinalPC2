package br.com.pc2.trabalho.persistencia;

import java.util.List;

import br.com.pc2.trabalho.model.Hospedagem;

public interface HospedagemDAO {
	public String inserir(Hospedagem hos);
	public String alterar(Hospedagem hos);
	public String excluir(Hospedagem hos);
	public List<Hospedagem> listarTodosHosp();
	public Hospedagem pesquisarPorCodHosp(String codH);
}
