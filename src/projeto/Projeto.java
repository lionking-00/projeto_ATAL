package projeto;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Projeto {
	
	static final String URL = "jdbc:postgresql://localhost:5432/clinica";
	
	static final String USER = "postgres"; 

	static final String PASS = "noemi123"; 
	
	
	
	
	
	
	
	
	
	
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {

		Class.forName("org.postgresql.Driver"); 

		Connection projeto = DriverManager.getConnection (URL, USER, PASS); 


		if (projeto != null){ 
	
		System.out.print ("Conexão efetuada com sucesso...");
	
		return projeto; 
	
		}

		return null; 
		
		}

}


