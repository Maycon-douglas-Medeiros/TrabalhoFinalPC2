package br.com.pc2.trabalho.view;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import br.com.pc2.trabalho.controller.ChaleController;
import br.com.pc2.trabalho.controller.ClienteController;
import br.com.pc2.trabalho.model.Chale;
import br.com.pc2.trabalho.model.Cliente;
import br.com.pc2.trabalho.persistencia.ConnectionFactory;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if(con != null){
			System.out.println("OK");
			ConnectionFactory.close(con);
		}
		Chale ch = new Chale();
		ChaleController controller = new ChaleController();
		Cliente cli = new Cliente();
		ClienteController Ccli = new ClienteController();
		
		//Inserir Chale
		//ch.setCodChale("1");
		//ch.setLocalizacao("Local 01");
		//ch.setCapacidade(1);
		//ch.setValorAltaEstacao(1111.1);
		//ch.setValorBaixaEstacao(1000.0);
		//System.out.println(controller.inserir(ch));
		
		//Inserir Cliente
		//cli.setCodCliente("00");
		//cli.setNomeCliente("11111");
		//cli.setRgCliente("11111");
		//cli.setEnderecoCliente("11111");
		//cli.setBairro("11111");
		//cli.setCidadeCliente("11111");
		//cli.setEstadoCliente("11111");
		//cli.setCEPCliente("11111");
		//cli.setNascimentoCliente("2000-03-31");
		//System.out.println(Ccli.inserir(cli));
		
		//Alterar
		//ch.setCodChale("1");
		//ch.setLocalizacao("Local 11");
		//ch.setCapacidade(11);
		//ch.setValorAltaEstacao(1111.1);
		//ch.setValorBaixaEstacao(1000.0);
		//System.out.println(controller.alterar(ch));
		
		//Alterar Cliente
		//cli.setCodCliente("4");
		//cli.setNomeCliente("11111");
		//cli.setRgCliente("11111");
		//cli.setEnderecoCliente("11111");
		//cli.setBairro("11111");
		//cli.setCidadeCliente("11111");
		//cli.setEstadoCliente("11111");
		//cli.setCEPCliente("11111");
		//cli.setNascimentoCliente(Date.valueOf("2016-03-31"));
		//System.out.println(Ccli.alterar(cli));
		
		//Excluir
		//emp.setCpf("11111");
		//System.out.println(controller.excluir(emp));
		
		//Exluir Cliente
		//cli.setCodCliente("1");
		//System.out.println(Ccli.excluir(cli));
		
		//Listar
		//List<Chale> lista = controller.listarTodos();
		//if(lista != null){
		//for(Chale e : lista){
			//System.out.println("CodChale: "+e.getCodChale());
			//System.out.println("Localização: "+e.getLocalizacao());
			//System.out.println("Capacidade: "+e.getCapacidade());
			//System.out.println("Alta Estação: "+e.getValorAltaEstacao());
			//System.out.println("Baixa Estação: "+e.getValorAltaEstacao());
		//}
		
		//Listar Cliente
		//List<Cliente> listaCliente = Ccli.listarTodosCli();
				//if(listaCliente != null){
			//	for(Cliente e : listaCliente){
					//System.out.println("CodCliente: "+e.getCodCliente());
					//System.out.println("Nome Cliente: "+e.getNomeCliente());
					//System.out.println("RG Cliente(: "+e.getRgCliente());
					//System.out.println("Endereco Cliente: "+e.getEnderecoCliente());
					//System.out.println("Bairro: "+e.getBairro());
					//System.out.println("Cidade Cliente: "+e.getCidadeCliente());
					//System.out.println("Estado Cliente: "+e.getEstadoCliente());
					//System.out.println("CEP Cliente: "+e.getCEPCliente());
					//System.out.println("Nascimento Cliente: "+e.getNascimentoCliente());
				//}
			//}
		
		//Pesquisar por CodChale
		//ch = controller.pesquisarPorCod("1");
		//if (ch != null) {
			//System.out.println("CodChale: "+ch.getCodChale());
			//System.out.println("Localização: "+ch.getLocalizacao());
			//System.out.println("Capacidade: "+ch.getCapacidade());
			//System.out.println("Alta Estação: "+ch.getValorAltaEstacao());
			//System.out.println("Baixa Estação: "+ch.getValorAltaEstacao());
		//}
		
		//Pesquisar por CodCliente
				//cli = Ccli.pesquisarPorCodCli("4");
				//if (cli != null) {
					//System.out.println("CodCliente: "+cli.getCodCliente());
					//System.out.println("Nome Cliente: "+cli.getNomeCliente());
					//System.out.println("RG Cliente(: "+cli.getRgCliente());
					//System.out.println("Endereco Cliente: "+cli.getEnderecoCliente());
					//System.out.println("Bairro: "+cli.getBairro());
					//System.out.println("Cidade Cliente: "+cli.getCidadeCliente());
					//System.out.println("Estado Cliente: "+cli.getEstadoCliente());
					//System.out.println("CEP Cliente: "+cli.getCEPCliente());
					//System.out.println("Nascimento Cliente: "+cli.getNascimentoCliente());
				//}
	}
}