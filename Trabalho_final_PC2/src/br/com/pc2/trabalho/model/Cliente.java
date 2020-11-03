package br.com.pc2.trabalho.model;

import java.sql.Date;
import java.time.LocalDate;

public class Cliente {
	private String codCliente;
	private String nomeCliente;
	private String rgCliente ;
	private String enderecoCliente;
	private String bairro;
	private String cidadeCliente;
	private String estadoCliente;
	private String CEPCliente;
	private LocalDate nascimentoCliente;
	public Cliente() {
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	public String getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	public String getCEPCliente() {
		return CEPCliente;
	}
	public void setCEPCliente(String cEPCliente) {
		CEPCliente = cEPCliente;
	}
	public LocalDate getNascimentoCliente() {
		return nascimentoCliente;
	}
	public void setNascimentoCliente(LocalDate nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}
}
