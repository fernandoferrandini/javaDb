package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javadb.jdbc.ConnectionFactory;
import modelo.Cliente;

public class TesteInsertDados {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into clientes(nome,email,endereco) values(?,?,?)";
		
		try {
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(sql);

			Cliente cliente = new Cliente();
			
			cliente.setNome("Fernando");
			cliente.setEmail("fferrandini@gmail.com");
			cliente.setEndereco("Rua 1 bloco 2 apt 3");

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
		
			stmt.execute();
			stmt.close();
			System.out.println("Dados inseridos com sucesso!");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.close();
		}
		
	}
}
