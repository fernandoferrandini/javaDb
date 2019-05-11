package testes;

import java.sql.SQLException;

import dao.ClienteDAO;
import modelo.Cliente;

public class TesteInsertDadosDao {
	
	public static void main(String[] args) throws SQLException {
		Cliente cliente = new Cliente();
		
		cliente.setNome("João");
		cliente.setEmail("maria@gmail.com");
		cliente.setEndereco("Rua 2 bloco 4 apt 5");

		ClienteDAO dao = new ClienteDAO();
		
		try {
			dao.inserir(cliente);
		System.out.println("Dados inseridos com sucesso!");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.close();
		}
		
	}
	
	
}
