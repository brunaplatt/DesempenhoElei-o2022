package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import Tabelas.Candidato;
import util.ConnectionUtil;

public class CandidatoDao {

    private static CandidatoDao instance;
 	private Connection con = ConnectionUtil.getConnection();
        
    public static CandidatoDao getInstance() {
        if(instance == null){
            instance = new CandidatoDao();
        }
        return instance;
    }

    public void salvar(Candidato candidato) {
    	try {
    		String sql = "insert into candidato (idcandidatos, nome, fichalimpa, partido) values (?, ?, ?, ?)";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, candidato.getIdcandidatos());
    		pstmt.setString(2, candidato.getNome());
    		pstmt.setString(3, candidato.getFichaLimpa());
    		pstmt.setString(4, candidato.getPartido());
    		pstmt.execute();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public void atualizar(Candidato candidato) {
    	try {
    		String sql = "update candidato set idcandidatos = ?, nome = ?, partido = ?, fichalimpa = ? where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, candidato.getIdcandidatos());
    		pstmt.setString(2, candidato.getNome());
    		pstmt.setString(3, candidato.getFichaLimpa());
    		pstmt.setString(4, candidato.getPartido());
    		pstmt.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public  void excluir(int idcandidatos){
    	try {
    		String sql = "delete from candidato where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, idcandidatos);
    		pstmt.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public List<Candidato> listar(){
    	List<Candidato> listaCandidatos = new ArrayList<>();
    	try {
    		String sql = "select * from candidato";
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		while (rs.next()) {
    			Candidato c = new Candidato();
    			c.setIdcandidatos(rs.getInt("ïdcandidatos"));
    			c.setNome(rs.getString("nome"));
    			c.setFichaLimpa(rs.getNString("fichalimpa"));
    			c.setPartido(rs.getString("partido"));
    			listaCandidatos.add(c);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
        return listaCandidatos;
    }

}
