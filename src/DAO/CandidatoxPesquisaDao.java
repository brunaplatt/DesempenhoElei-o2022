package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Tabelas.Candidato;
import Tabelas.CandidatoxPesquisa;
import Tabelas.Pesquisa;
import util.ConnectionUtil;

public class CandidatoxPesquisaDao {
	
    private static CandidatoxPesquisaDao instance;
    private Connection con = ConnectionUtil.getConnection();
    
    public static CandidatoxPesquisaDao getInstance() {
        if(instance == null) {
            instance = new CandidatoxPesquisaDao();
        }
        return instance;
    }

    public void salvar(Pesquisa pesquisa, Candidato candidato, CandidatoxPesquisa candidatoxpesquisa) {
        	try {
        		String sqlCandidato = "insert into candidato (idcandidados, nome, partido, fichaLimpa) values (?, ?, ?, ?)";
            	PreparedStatement pstmtCandidato = con.prepareStatement(sqlCandidato);
            	pstmtCandidato.setInt(1, candidato.getIdcandidatos());
            	pstmtCandidato.setString(2, candidato.getNome());
            	pstmtCandidato.setString(3, candidato.getPartido());
            	pstmtCandidato.setString(4, candidato.getFichaLimpa());
                        	
            	String sqlPesquisa = "insert into pesquisa (institutoPesquisa, dataPesquisa, mediaIdade, uf, formato, tipoPesquisa, tipo) values (?, ?, ?, ?, ?, ?, ?)";
            	PreparedStatement pstmtPesquisa = con.prepareStatement(sqlPesquisa, Statement.RETURN_GENERATED_KEYS);
            	pstmtPesquisa.setString(1, pesquisa.getInstitutopesquisa());
            	pstmtPesquisa.setString(2, pesquisa.getDatapesquisa());
            	pstmtPesquisa.setInt(3, pesquisa.getMediaidade());
            	pstmtPesquisa.setString(4, pesquisa.getUf());
            	pstmtPesquisa.setString(5, pesquisa.getFormato());
            	pstmtPesquisa.setString(6, pesquisa.getTipopesquisa());
            	pstmtPesquisa.setString(7, pesquisa.getTipo());
            	
            	int keyP = pstmtPesquisa.executeUpdate();
            	
            	if (keyP > 0) {
            		ResultSet rsC = pstmtCandidato.getGeneratedKeys();
            		rsC.next();
            		int idCandidatos = rsC.getInt(1);
            		
            		ResultSet rsP = pstmtPesquisa.getGeneratedKeys();
            		rsP.next();
            		int idPesquisa = rsP.getInt(1);
            		
            		String sql = "insert into CandidatoxPesquisa (votos, idCandidatos, IdPesquisa) values (?, ?, ?)";
            		PreparedStatement pstmt = con.prepareStatement(sql);
            		pstmt.setInt(1,  candidatoxpesquisa.getVotos());
            		pstmt.setInt(2, idCandidatos);
            		pstmt.setInt(3, idPesquisa);
            		pstmt.execute();
            	}
            	
        	} catch (SQLException e) {
				e.printStackTrace();
			}
    }

    public void atualizar(CandidatoxPesquisa candidatoxpesquisa) {
    	try {
    		String sql = "update candidatoxpesquisa set idcandidatoxpesquisa = ?, votos = ?, idCandidatos = ?, idPesquisa = ? where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, candidatoxpesquisa.getIdcandidatoxpesquisa());
    		pstmt.setInt(2, candidatoxpesquisa.getVotos());
    		pstmt.setObject(3, candidatoxpesquisa.getCandidato());
    		pstmt.setObject(4, candidatoxpesquisa.getPesquisa());
    		    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }      
    
    public void excluir(int idCandidatoxPesquisa) {
    	try {
    		String sql = "delete from candidatoxpesquisa where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		pstmt.setInt(1, idCandidatoxPesquisa);
    		pstmt.executeUpdate();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public List<CandidatoxPesquisa> listar(){
    	List<CandidatoxPesquisa> listaCandidatoxPesquisa = new ArrayList<>();
    	
    	try {
    		String sql = "select * from candidatoxpesquisa";
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			CandidatoxPesquisa candidatoxpesquisa = new CandidatoxPesquisa();
    			candidatoxpesquisa.setIdcandidatoxpesquisa(rs.getInt("IdCandidatoxPesquisa"));
    			candidatoxpesquisa.setVotos(rs.getInt("Votos"));
    			
    			String sqlCandidato = "select * from candidato where id = ?";
    			PreparedStatement stmtCandidato = con.prepareStatement(sqlCandidato);
    			stmtCandidato.setInt(1, rs.getInt("idCandidatos"));
    			ResultSet rsCandidato = stmtCandidato.executeQuery();
    			rsCandidato.next();
    			
    			Candidato c = new Candidato();
    			c.setIdcandidatos(rsCandidato.getInt("idCandidatos"));
    			c.setNome(rsCandidato.getString("Nome"));
    			c.setPartido(rsCandidato.getString("Partido"));
    			c.setFichaLimpa(rsCandidato.getString("FichaLimpa"));
    					
    			String sqlPesquisa = "select * from pesquisa where id = ?";
    			PreparedStatement stmtPesquisa = con.prepareStatement(sqlPesquisa);
    			stmtPesquisa.setInt(1, rs.getInt("idPesquisa"));
    			ResultSet rsPesquisa = stmtPesquisa.executeQuery();
    			rsPesquisa.next();
    			
    			Pesquisa p = new Pesquisa();
    			p.setIdPesquisa(rsPesquisa.getInt("idPesquisa"));
    			p.setInstitutopesquisa(rsPesquisa.getString("InstitutoPesquisa"));
    			p.setDatapesquisa(rsPesquisa.getString("DataPesquisa"));
    			p.setMediaidade(rsPesquisa.getInt("MediaIdade"));
    			p.setUf(rsPesquisa.getString("Uf"));
    			p.setTipopesquisa(rsPesquisa.getString("TipoPesquisa"));
    			p.setFormato(rsPesquisa.getString("Formato"));
    			p.setFormato(rsPesquisa.getString("Tipo"));
    			
    			candidatoxpesquisa.setCandidato(c);
    			candidatoxpesquisa.setPesquisa(p);
    			
    			listaCandidatoxPesquisa.add(candidatoxpesquisa);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return listaCandidatoxPesquisa;
    	
    }
}   
