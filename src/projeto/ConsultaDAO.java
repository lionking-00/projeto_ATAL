package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
	
	private Connection conexao; 

	public ConsultaDAO() throws SQLException, ClassNotFoundException {
		
		conexao = Projeto.criarConexao(); 

	} 
	
	public void newConsulta(BeanConsulta consulta) {

		String sql = "INSERT INTO Consulta (medmat, cpfp, preco, datac, hora, especialidade) VALUES(?,?,?,?,?,?)"; 

		try { 

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setInt(1, consulta.getMedMat());
	
			preparador.setLong(2, consulta.getCpfP());
					
			preparador.setFloat(3, consulta.getPreco());
			
			preparador.setString(4, consulta.getDate());
	
			preparador.setString(5, consulta.getHora());
			
			preparador.setString(6, consulta.getEspecialidade());
	
			preparador.execute(); 
	
			preparador.close();
	
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}

	}
	
	
	public void alteraConsulta(BeanConsulta consulta) {

		String sql = "UPDATE Consulta SET datac = ? WHERE cpfp = cpfp";

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setString(1, consulta.getDate());
		
			preparador.execute();
	
			preparador.close();
	
			System.out.println("Alteração realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - "+ e.getMessage());

		} 
	}
	
	public void deleteConsulta(BeanConsulta consulta) {

		String sql = "DELETE FROM Consulta WHERE cpfp = cpfp";

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setLong(1, consulta.getCpfP());
	
			preparador.execute();
	
			preparador.close();
	
			System.out.println("Deleção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - "+ e.getMessage());

		}
	}
	
	public List<BeanConsulta> selectTodos(){

		String sql = "SELECT * FROM Consulta";

		List<BeanConsulta> lista = new ArrayList<BeanConsulta>();

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			ResultSet resultados = preparador.executeQuery();
	
			while (resultados.next()) {
				
				BeanConsulta consulta = new BeanConsulta();
				
				consulta.setMedMat(resultados.getInt("medmat"));
				consulta.setCpfP(resultados.getInt("cpfp"));
				consulta.setPreco(resultados.getFloat("preco"));
				consulta.setEspecialidade(resultados.getString("especialidade"));
				consulta.setDate(resultados.getString("datac"));
				consulta.setHora(resultados.getString("hora"));
			
			    lista.add(consulta);
			    
			    
			} 

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}

			return lista; 

		}

}