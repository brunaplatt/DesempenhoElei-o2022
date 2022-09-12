import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.ConnectionUtil;

public class Principal {
	
	public static void main(String[] args) {
		
		consulta();
		System.out.println("------------------");
		insere();
		System.out.println("------------------");
		consulta();
	}
		
		public static void insere() {
			try {
				Connection conexao = ConnectionUtil.getConnection();
				String sql = "insert into candidato (nome, fichalimpa) values (?, ?)";
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				pstmt.setString(1, "LULA");
				pstmt.setString(2, "SIM");
				pstmt.execute();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		public static void consulta() {
		try {		
		Connection conexao = ConnectionUtil.getConnection();
		Statement stmt = conexao.createStatement();
		String sql = "select * from Candidato";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Nome: " + rs.getString("Nome"));
			System.out.println("Ficha Limpa: " + rs.getString("Ficha Limpa"));
		}
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}
}