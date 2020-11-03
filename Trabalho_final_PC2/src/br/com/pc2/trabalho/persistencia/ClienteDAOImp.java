package br.com.pc2.trabalho.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.pc2.trabalho.model.Cliente;

public class ClienteDAOImp implements ClienteDAO{

	@Override
	public String inserir(Cliente cli) {
		String sql = "insert into Cliente(codCliente, nomeCliente, rgCliente, enderecoCliente, bairro, cidadeCliente, estadoCliente, CEPCliente, nascimentoCliente) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con =  ConnectionFactory.getConnection();
		try{
			PreparedStatement pstcli = con.prepareStatement(sql);
			pstcli.setString(1, cli.getCodCliente());
			pstcli.setString(2, cli.getNomeCliente());
			pstcli.setString(3, cli.getRgCliente());
			pstcli.setString(4, cli.getEnderecoCliente());
			pstcli.setString(5, cli.getBairro());
			pstcli.setString(6, cli.getCidadeCliente());
			pstcli.setString(7, cli.getEstadoCliente());
			pstcli.setString(8, cli.getCEPCliente());
			pstcli.setObject(9, cli.getNascimentoCliente());
			int res = pstcli.executeUpdate();
			if(res > 0){
			return "Inserido com sucesso.";
		}else{
			return "Erro ao inserir.";
		}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String alterar(Cliente cli) {
		String sql = "update Cliente set nomeCliente=?, rgCliente=?, enderecoCliente=?, bairro=?, cidadeCliente=?, estadoCliente=?, CEPCliente=?, nascimentoCliente=? where codCliente=?";
		Connection con =  ConnectionFactory.getConnection();
		try{
			PreparedStatement pstcli = con.prepareStatement(sql);
			pstcli.setString(1, cli.getNomeCliente());
			pstcli.setString(2, cli.getRgCliente());
			pstcli.setString(3, cli.getEnderecoCliente());
			pstcli.setString(4, cli.getBairro());
			pstcli.setString(5, cli.getCidadeCliente());
			pstcli.setString(6, cli.getEstadoCliente());
			pstcli.setString(7, cli.getCEPCliente());
			pstcli.setObject(8, cli.getNascimentoCliente());
			pstcli.setString(9, cli.getCodCliente());
			int res = pstcli.executeUpdate();
			if(res > 0){
			return "Alterado com sucesso.";
		}else{
			return "Erro ao Alterar.";
		}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Cliente cli) {
		String sql = "delete from Cliente where codCliente=?";
		Connection con =  ConnectionFactory.getConnection();
		try{
			PreparedStatement pstcli = con.prepareStatement(sql);
			pstcli.setString(1, cli.getCodCliente());
			int res = pstcli.executeUpdate();
			if(res > 0){
			return "Excluir com sucesso.";
		}else{
			return "Erro ao Excluir.";
		}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Cliente> listarTodosCli() {
		String sql = "select * from Cliente";
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> listaCliente = new ArrayList<>();
		try {
			PreparedStatement pstcli = con.prepareStatement(sql);
			ResultSet rscli = pstcli.executeQuery();
			if (rscli != null) {
			while (rscli.next()) {
			    Cliente linha = new Cliente();
				linha.setCodCliente(rscli.getString(1));
				linha.setNomeCliente(rscli.getString(2));
				linha.setRgCliente(rscli.getString(3));
				linha.setEnderecoCliente(rscli.getString(4));
				linha.setBairro(rscli.getString(5));
				linha.setCidadeCliente(rscli.getString(6));
				linha.setEstadoCliente(rscli.getString(7));
				linha.setCEPCliente(rscli.getString(8));
				linha.setNascimentoCliente(rscli.getObject(9, LocalDate.class));
			listaCliente.add(linha);
		}
			return listaCliente;
		} else {
			return null;
		}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public  List<Cliente> pesquisarPorCodCli(String cod) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from Cliente where codCliente=? order by nomeCliente");
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pstcli = con.prepareStatement(sql.toString());
			pstcli.setString(1, cod);
			ResultSet rscli = pstcli.executeQuery();
		if (rscli != null) {
			while(rscli.next()) {
				Cliente linha = new Cliente();
				linha.setCodCliente(rscli.getString(1));
				linha.setNomeCliente(rscli.getString(2));
				linha.setRgCliente(rscli.getString(3));
				linha.setEnderecoCliente(rscli.getString(4));
				linha.setBairro(rscli.getString(5));
				linha.setCidadeCliente(rscli.getString(6));
				linha.setEstadoCliente(rscli.getString(7));
				linha.setCEPCliente(rscli.getString(8));
				linha.setNascimentoCliente(rscli.getObject(9, LocalDate.class));
				lista.add(linha);
			}
			return lista;
		} else {
			return null;
		}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}
