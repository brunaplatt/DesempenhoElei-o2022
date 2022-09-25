package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Tabelas.Pesquisa;
import util.ConnectionUtil;

public class PesquisaDao {

    private static PesquisaDao instance;
    private Connection con = ConnectionUtil.getConnection();

    public static PesquisaDao getInstance(){
        if (instance == null){
            instance = new PesquisaDao();
        }
        return instance;
    }

    public void salvar(Pesquisa pesquisa){
    	try {
    		String sql = "insert into pesquisa (idpesquisa, institutoPesquisa, datapesquisa, mediaidade, uf, formato, tipopesquisa, tipo) values (?, ?, ?, ?, ?, ?, ?, ?)";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, pesquisa.getIdPesquisa());
    		pstmt.setString(2, pesquisa.getInstitutopesquisa());
    		pstmt.setDate(3, java.sql.Date.valueOf(pesquisa.getDatapesquisa()));
    		pstmt.setInt(4, pesquisa.getMediaidade());
    		pstmt.setString(5, pesquisa.getUf());
    		pstmt.setString(6, pesquisa.getFormato());
    		pstmt.setString(7, pesquisa.getTipopesquisa());
    		pstmt.setString(8, pesquisa.getTipo());
    		pstmt.execute();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public void atualizar(Pesquisa pesquisa){
    	try {
    		String sql = "update pesquisa set idPesquisa = ?, institutoPesquisa = ?, datapesquisa = ?, mediaidade = ?, uf = ?, formato = ?, tipopesquisa = ?, tipo = ? where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, pesquisa.getIdPesquisa());
    		pstmt.setString(2, pesquisa.getInstitutopesquisa());
    		pstmt.setDate(3, java.sql.Date.valueOf(pesquisa.getDatapesquisa()));
    		pstmt.setInt(4, pesquisa.getMediaidade());
    		pstmt.setString(5, pesquisa.getUf());
    		pstmt.setString(6, pesquisa.getFormato());
    		pstmt.setString(7, pesquisa.getTipopesquisa());
    		pstmt.setString(8, pesquisa.getTipo());
    		pstmt.execute();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public void excluir(int idPesquisa){
    	try {
    		String sql = "delete from pesquisa where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, idPesquisa);
    		pstmt.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public List<Pesquisa> listar(){
    	List<Pesquisa> listaPesquisa = new ArrayList<>();
    	try {
    		String sql = "select * from pesquisa";
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		while (rs.next()) {
    			Pesquisa p = new Pesquisa();
    			p.setIdPesquisa(rs.getInt("ïdpesquisa"));
    			p.setInstitutopesquisa(rs.getString("institutopesquisa"));
    			p.setDatapesquisa(rs.getString("datapesquisa"));
    			p.setMediaidade(rs.getInt("mediaidade"));
    			p.setUf(rs.getString("uf"));
    			p.setFormato(rs.getString("formato"));
    			p.setTipopesquisa(rs.getString("tipopesquisa"));
    			p.setTipo(rs.getString("tipo"));
    			listaPesquisa.add(p);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
        return listaPesquisa;
   	}
}
