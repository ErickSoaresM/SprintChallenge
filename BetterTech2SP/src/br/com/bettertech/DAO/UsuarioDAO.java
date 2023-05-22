package br.com.bettertech.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.bettertech.factory.ConectionFactory;
import br.com.bettertech.TO.UsuarioTO;

public class UsuarioDAO {
	
	private Connection con = null;
	
	public UsuarioDAO() {
		this.con = new ConectionFactory().getConnection(); 
	}
	
	public UsuarioTO loginDAO(UsuarioTO u) {
		
		PreparedStatement ps = null;
		
		try {
			
			String sqlQuery = "SELECT * FROM T_USUARIO WHERE LOGIN = ? AND SENHA = ?";
			
			ps = con.prepareStatement(sqlQuery);
			
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getSenha());
			
			ResultSet rs = ps.executeQuery();
			
			UsuarioTO ut = null;
			
			while (rs.next()) {
				ut = new UsuarioTO();
				ut.setLogin(rs.getNString(2));
				ut.setSenha(rs.getNString(3));
				System.out.println("USUÁRIO : " + ut.getLogin() + " LOGOU!");
			}
			
			rs.close();
			ps.close();
			con.close();
			
			
			return ut;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("USUÁRIO : " + u.getLogin() + " NÃO VALIDADO!");
		return null;
		
	}
	
	
}