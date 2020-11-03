package br.com.pc2.trabalho.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.pc2.trabalho.model.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO{

	@Override
	public String inserir(Hospedagem hos) {
		String sql = "insert into Hospedagem(codChale, CodHospedagem, estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) values (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con =  ConnectionFactory.getConnection();
		try{
			PreparedStatement pstH = con.prepareStatement(sql);
			pstH.setString(1, hos.getCodChale());
			pstH.setString(2, hos.getCodHospedagem());
			pstH.setString(3, hos.getEstado());
			pstH.setObject(4, hos.getDataInicio());
			pstH.setObject(5, hos.getDataFim());
			pstH.setInt(6, hos.getQtdPessoas());
			pstH.setDouble(7, hos.getDesconto());
			pstH.setDouble(8, hos.getValorFinal());
			int res = pstH.executeUpdate();
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
	public String alterar(Hospedagem hos) {
		String sql = "update Hospedagem set codChale=?, CodHospedagem=?, estado=?, dataInicio=?, dataFim=?, qtdPessoas=?, desconto=?, valorFinal=?";
		Connection con =  ConnectionFactory.getConnection();
		try{
			PreparedStatement pstH = con.prepareStatement(sql);
			pstH.setString(1, hos.getCodChale());
			pstH.setString(2, hos.getCodHospedagem());
			pstH.setString(3, hos.getEstado());
			pstH.setObject(4, hos.getDataInicio());
			pstH.setObject(5, hos.getDataFim());
			pstH.setInt(6, hos.getQtdPessoas());
			pstH.setDouble(7, hos.getDesconto());
			pstH.setDouble(8, hos.getValorFinal());
			int res = pstH.executeUpdate();
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
	public String excluir(Hospedagem hos) {
		String sql = "delete from Hospedagem where codHospedagem=?";
		Connection con =  ConnectionFactory.getConnection();
		try{
			PreparedStatement pstH = con.prepareStatement(sql);
			pstH.setString(1, hos.getCodHospedagem());
			int res = pstH.executeUpdate();
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
	public List<Hospedagem> listarTodosHosp() {
		String sql = "select * from Hospedagem";
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> listaHospedagem = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rsH = pst.executeQuery();
			if (rsH != null) {
			while (rsH.next()) {
				Hospedagem ep = new Hospedagem();
				ep.setCodChale(rsH.getString(1));
				ep.setCodHospedagem(rsH.getString(2));
				ep.setEstado(rsH.getString(3));
				ep.setDataInicio(rsH.getObject(4, LocalDate.class));
				ep.setDataFim(rsH.getObject(5, LocalDate.class));
				ep.setQtdPessoas(rsH.getInt(6));
				ep.setDesconto(rsH.getDouble(7));
				ep.setValorFinal(rsH.getDouble(8));
			listaHospedagem.add(ep);
		}
			return listaHospedagem;
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
	public Hospedagem pesquisarPorCodHosp(String codH) {
		// TODO Auto-generated method stub
		return null;
	}

}
