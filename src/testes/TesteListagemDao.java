package testes;

import java.sql.SQLException;

import dao.ClienteDAO;
import modelo.Cliente;

public class TesteListagemDao {
	public static void main(String[] args) throws SQLException {
		ClienteDAO dao = new ClienteDAO();
		
	
		try {
			
			for ( Cliente cliente : dao.lista()) {
				System.out.println("Cliente Id : " + cliente.getId().toString());
				System.out.println("Nome : " + cliente.getNome());
				System.out.println("Email : " + cliente.getEmail());
				System.out.println("Endereço : " + cliente.getEndereco());
				System.out.println("============================================");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.close();
		}
	}
}
