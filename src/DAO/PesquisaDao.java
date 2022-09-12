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
    private List<Pesquisa> listaPesquisa = new ArrayList<>();
    private Connection con = ConnectionUtil.getConnection();

    public static PesquisaDao getInstance(){
        if (instance == null){
            instance = new PesquisaDao();
        }
        return instance;
    }

    public void salvar(Pesquisa pesquisa){
    	try {
    		String sql = "insert into pesquisa (institutoPesquisa, datapesquisa, mediaidade, uf, formatopesquisa, tipopesquisa) values (?, ?, ?, ?, ?, ?)";
    		
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		
    		pstmt.setString(1, pesquisa.getInstitutopesquisa());
    		pstmt.setDate(2, pesquisa.getDatapesquisa());
    		pstmt.setInt(3, pesquisa.getMedialidade());
    		pstmt.setString(4, pesquisa.getUf());
    		pstmt.setString(5, pesquisa.getFormatopesquisa());
    		pstmt.setString(6, pesquisa.getTipopesquisa());
    		pstmt.execute();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public void atualizar(Pesquisa pesquisa){
    	try {
    		String sql = "update pesquisa set institutoPesquisa = ?, datapesquisa = ?, mediaidade = ?, uf = ?, formatopesquisa = ?, tipopesquisa = ? where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, pesquisa.getInstitutopesquisa());
    		pstmt.setDate(2, pesquisa.getDatapesquisa());
    		pstmt.setInt(3, pesquisa.getMedialidade());
    		pstmt.setString(4, pesquisa.getUf());
    		pstmt.setString(5, pesquisa.getFormatopesquisa());
    		pstmt.setString(6, pesquisa.getTipopesquisa());
    		pstmt.setInt(7, pesquisa.getIdPesquisa());
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
    			p.setDatapesquisa(rs.getDate("datapesquisa"));
    			p.setMedialidade(rs.getInt("mediaidade"));
    			p.setUf(rs.getString("uf"));
    			p.setFormatopesquisa(rs.getString("formatopesquisa"));
    			p.setTipopesquisa("tipopesquisa");
    			listaPesquisa.add(p);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
        return listaPesquisa;
    }
}