package br.com.pc2.trabalho.model;

public class Chale {
	private String codChale;
	private String localizacao;
	private Integer capacidade; 
	private Double valorAltaEstacao;
	private Double valorBaixaEstacao;
	public Chale() {		
	}
	public String getCodChale() {
		return codChale;
	}
	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Double getValorAltaEstacao() {
		return valorAltaEstacao;
	}
	public void setValorAltaEstacao(Double valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}
	public Double getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}
	public void setValorBaixaEstacao(Double valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}
}
