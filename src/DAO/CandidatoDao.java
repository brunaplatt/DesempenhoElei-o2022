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
    private List<Candidato> listaCandidatos = new ArrayList<>();
    private Connection con = ConnectionUtil.getConnection();
    
    
    public static CandidatoDao getInstance() {
        if(instance == null){
            instance = new CandidatoDao();

        }
        return instance;
    }

    public void salvar(Candidato candidatos) {
    	try {
    		String sql = "insert into candidato (nome, fichalimpa, partido) values (?, ?)";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, candidatos.getNome());
    		pstmt.setString(2, candidatos.getFichaLimpa());
    		pstmt.setString(3, candidatos.getPartido());
    		pstmt.execute();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public void atualizar(Candidato candidatos) {
    	try {
    		String sql = "update candidato set nome = ?, partido = ?, fichalimpa = ? where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, candidatos.getNome());
    		pstmt.setString(2, candidatos.getFichaLimpa());
    		pstmt.setString(3, candidatos.getPartido());
    		pstmt.setInt(4, candidatos.getIdcandidatos());
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
    			c.setIdcandidatos(rs.getInt("ïdcandidato"));
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