package br.com.pc2.trabalho.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pc2.trabalho.model.Chale;


public class ChaleDAOImp implements ChaleDAO{
	
	@Override
	public String inserir(Chale ch) {
		String sql = "insert into Chale(codChale, localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) values (?, ?, ?, ?, ?)";
		Connection con =  ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ch.getCodChale());
			pst.setString(2, ch.getLocalizacao());
			pst.setInt(3, ch.getCapacidade());
			pst.setDouble(4, ch.getValorAltaEstacao());
			pst.setDouble(5, ch.getValorBaixaEstacao());
			int res = pst.executeUpdate();
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
	public String alterar(Chale ch) {
		String sql = "update Chale set  localizacao=?, capacidade=?, valorAltaEstacao=?,  valorBaixaEstacao=? where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ch.getLocalizacao());
			pst.setInt(2, ch.getCapacidade());
			pst.setDouble(3, ch.getValorAltaEstacao());
			pst.setDouble(4, ch.getValorBaixaEstacao());
			pst.setString(5, ch.getCodChale());
			int res = pst.executeUpdate();
			if(res > 0){
			return "Alterado com sucesso.";
		}else{
			return "Erro ao alterar.";
		}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Chale ch) {
		String sql = "delete from Chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ch.getCodChale());
			int res = pst.executeUpdate();
			if(res > 0){
			return "Excluído com sucesso.";
		}else{
			return "Erro ao excluir.";
		}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Chale> listarTodos() {
		String sql = "select * from Chale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rsch = pst.executeQuery();
			if (rsch != null) {
			while (rsch.next()) {
				Chale ep = new Chale();
				ep.setCodChale(rsch.getString(1));
				ep.setLocalizacao(rsch.getString(2));
				ep.setCapacidade(rsch.getInt(3));
				ep.setValorAltaEstacao(rsch.getDouble(4));
				ep.setValorBaixaEstacao(rsch.getDouble(5));
			lista.add(ep);
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

	@Override
	public Chale pesquisarPorCod(String cod) {
		String sql = "select * from Chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cod);
			ResultSet rsch = pst.executeQuery();
		if (rsch.next()) {
			Chale ep = new Chale();
			ep.setCodChale(rsch.getString(1));
			ep.setLocalizacao(rsch.getString(2));
			ep.setCapacidade(rsch.getInt(3));
			ep.setValorAltaEstacao(rsch.getDouble(4));
			ep.setValorBaixaEstacao(rsch.getDouble(5));
		return ep;
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
