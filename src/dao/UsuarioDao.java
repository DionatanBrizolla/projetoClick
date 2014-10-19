package dao;

import java.awt.List;
import java.beans.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Usuario;

import db.Conexao;
import db.PoolDeConexoes;


public class UsuarioDao{
	
	private Connection con;
	
	public UsuarioDao(){
		PoolDeConexoes pool = PoolDeConexoes.getInstance();
		Conexao cnx = pool.getConexao();
		cnx.reserva();
		con = cnx.getConnection();
	}

	public Integer add(Usuario obj) throws SQLException {
		
		PoolDeConexoes pool = PoolDeConexoes.getInstance();
		Conexao cnx = pool.getConexao();
		cnx.reserva();
		con = cnx.getConnection();
		
		StringBuilder sql= new StringBuilder();
		sql.append("INSERT INTO usuarios(nome,sobrenome,sexo,email,dataNascimento,senha) values(?,?,?,?,?,?)");
		try {
			
			PreparedStatement stm = con.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1,obj.getNome());
			stm.setString(2,obj.getSobrenome());
			stm.setString(3,obj.getSexo());
			stm.setString(4,obj.getEmail());
			stm.setDate(5,obj.getDataNascimento());
			stm.setString(6, MD5(obj.getSenha()));
			stm.execute();
			ResultSet keys = stm.getGeneratedKeys();
			keys.next();
			int key = keys.getInt(1);
			cnx.libera();
			return key;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro ao tentar adicionar usuario");
			cnx.libera();
		}finally{
			cnx.libera();
		}
		return -1;
	}

	
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
	private boolean validLogin(Usuario obj){
		
		
		return false;
	}

}
