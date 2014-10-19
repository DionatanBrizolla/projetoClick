package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private Connection cnx;
	private boolean ocupado;

	public Conexao() throws FevasDBException {
		
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
			
			Connection con = DriverManager.getConnection(
					url, 
					nomeUsuario, 
					senha );
			
			System.out.println( "Conexão estabelecida" );
			cnx = con;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnection(){
		return this.cnx;
	}

	public void reserva() {
		this.ocupado = true;
	}

	public void libera() {
		this.ocupado = false;
	}

	public boolean isReservado() {
		return ocupado;
	}

	public void close() {

		try {
			this.cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void executaSql( String comando ) throws FevasDBException {

		try {
			Statement st = cnx.createStatement();
			st.execute(comando);
		} catch (SQLException e) {
			throw new FevasDBException(e);
		}
	}

	public PreparedStatement prepareStatement( String comando ) throws FevasDBException {

		PreparedStatement ps = null;
		try {
			ps = this.cnx.prepareStatement(comando);
		} catch (SQLException e) {
			throw new FevasDBException(e);
		}
		return ps;

	}

	public ResultSet executeQuery( String query ) throws FevasDBException {

		try {
			ResultSet rs = prepareStatement(query).executeQuery();
			return rs;
		} catch ( Exception e ) {
			throw new FevasDBException(e);
		}
	}

}
