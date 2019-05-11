package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadb.jdbc.ConnectionFactory;
import modelo.Cliente;

public class ClienteDAO {

	private Connection con;
	private PreparedStatement stmt;
	
	public ClienteDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void close() throws SQLException {
		con.close();
	}	
	
	public void inserir(Cliente cliente) throws SQLException {
		String sql = "insert into clientes(nome,email,endereco) values(?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
		
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e); 
		}
		
	}
	
	public List<Cliente> lista(){
		
		String sql = "select * from clientes";
		try {
			List<Cliente> clientes = new ArrayList();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("Id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e); 
		}
		
		
	}
	
	public Cliente obter(Long id){
		Cliente cliente = null;
		String sql = "select * from clientes where Id=?";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("Id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e); 
		}
	}
	
	public void edita(Cliente cliente) {
		String sql = "update clientes set nome=?, email=?, endereco=? where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setLong(4, cliente.getId());
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}
	
	
	
}
