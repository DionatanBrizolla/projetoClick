package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Conexao instancia;
	private Connection con;
	
	private Conexao(){
		
		String driverJDBC = "com.mysql.jdbc.Driver";
		String nomeUsuario = "root";
		String senha = "matrix2805cadu";
		String endBanco = "localhost";
		String nroPorta = "3306";
		String nomeDatabase = "click";
		
		try {
			Class.forName(driverJDBC);
			System.out.println("Driver JDBC carregado");
			String url = "jdbc:mysql://" + endBanco + ":" + nroPorta + "/" + nomeDatabase;
			
			Connection cnx = DriverManager.getConnection(
					url, 
					nomeUsuario, 
					senha );
			
			System.out.println( "Conexão estabelecida" );
			this.con = cnx;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
			
	}
	
	public static Conexao getInstance(){
		if(instancia==null){
		  instancia = new Conexao();
		}
		return instancia;
	}
	
	public Connection getCon(){
		return this.con;
	}
	
	public void closeCon(){
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println("erro ao fechar a conexão");
			e.printStackTrace();
		}
	}
	
}
	
