package ProjetoTeste;

import java.sql.Connection;
import java.sql.SQLException;
import projeto.Projeto;


public class TesteProjeto {
	
	public static void main(String[] args) {
			
		try {
			Connection con = Projeto.criarConexao();
		} catch (ClassNotFoundException exc) {
				exc.printStackTrace();			
		} catch (SQLException exc) {
				exc.printStackTrace();
		}
			
	}

}
