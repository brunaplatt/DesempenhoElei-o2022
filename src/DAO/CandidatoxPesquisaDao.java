package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Tabelas.CandidatoxPesquisa;
import util.ConnectionUtil;

public class CandidatoxPesquisaDao {

    private static CandidatoxPesquisaDao instance;
    private List<CandidatoxPesquisa> listaCandidatoPesquisa = new ArrayList<>();
    private Connection con = ConnectionUtil.getConnection();
    
    public static CandidatoxPesquisaDao getInstance() {
        if(instance == null) {
            instance = new CandidatoxPesquisaDao();
        }
        return instance;
    }

    public void registrarVotos(CandidatoxPesquisa candidatoPesquisa) throws SQLException {
                	
        	String sql = "insert into candidatoxpesquisa (votos) values (?)";
        	
        	PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	pstmt.setInt(1, candidatoPesquisa.getVotos());
        	
        	int key = pstmt.executeUpdate();
        	
        	if (key > 0) {
        		
        		ResultSet rs = pstmt.getGeneratedKeys();
        		rs.next();
        		@SuppressWarnings("unused")
				int idCandidatoxPesquisa = rs.getInt(1);
        	}	
    }            	
}        
   
