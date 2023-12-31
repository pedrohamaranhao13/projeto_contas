package br.com.smarttec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.smarttec.entities.Usuario;
import br.com.smarttec.factories.ConnectionFactory;

public class UsuarioRepository {
	
	public void create(Usuario usuario) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		String query = "insert into usuario(nome, email, senha) values(?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();
		
		connection.close();
		
	}
	
	public void update(Usuario usuario) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update usuario set nome=?, email=?, senha=md5(?) where idusuario=?"); 
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.setInt(4, usuario.getIdUsuario());
		statement.execute();
		
		connection.close();
		
	}
	
	public Usuario find(String email) throws Exception{
		
		Connection connection = ConnectionFactory.getConnection();
		
		String query = "select * from usuario where email = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
		
		Usuario usuario = null;
		
		if (resultSet.next()) {
			usuario =new Usuario();
			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario .setEmail(resultSet.getString("email"));
		}
		
		connection.close();
		
		return usuario;
	
	}
	
	public Usuario find(String email, String senha) throws Exception{
		
		Connection connection = ConnectionFactory.getConnection();
		
		String query ="select * from usuario where email = ? and senha = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, senha);
		
		ResultSet resultSet = statement.executeQuery();
		
		Usuario usuario = null;
		
		if (resultSet.next()) {
			usuario =new Usuario();
			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario .setEmail(resultSet.getString("email"));
		}
		
		connection.close();
		
		return usuario;
		
	}

}
