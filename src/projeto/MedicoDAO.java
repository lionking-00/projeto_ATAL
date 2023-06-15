package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MedicoDAO {
	
	private Connection conexao; 

	public MedicoDAO() throws SQLException, ClassNotFoundException {

	conexao = Projeto.criarConexao(); 

	} 
	
	public void addMedico(BeanMedico med) {

		String sql = "INSERT INTO Medico( matricula, nomeMed, endereco, salario, crm) VALUES(?,?,?,?,?)"; 

		try { 

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setInt(1, med.getMatricula());
			
			preparador.setString(2, med.getNomeMed());
			
			preparador.setString(3, med.getEndereco());
			
			preparador.setFloat(4, med.getSalario());
			
			preparador.setInt(5, med.getCRM());
	
			preparador.execute(); 
	
			preparador.close();
	
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}

	} 
	
	public void alteraMedico(BeanMedico med) {

		String sql = "UPDATE Medico SET salario = ? WHERE matricula = matricula";

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setFloat(1, med.getSalario());
		
			preparador.execute();
	
			preparador.close();
	
			System.out.println("Alteração realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - "+ e.getMessage());

		} 
	}
	
	public void deleteMedico(BeanMedico med) {

		String sql = "DELETE FROM Medico WHERE matricula = matricula";

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setInt(1, med.getMatricula());
	
			preparador.execute();
	
			preparador.close();
	
			System.out.println("Deleção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - "+ e.getMessage());

		}
	}
	
	public List<BeanMedico> selectTodos(){

		String sql = "SELECT * FROM Medico";

		List<BeanMedico> lista = new ArrayList<BeanMedico>();

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			ResultSet resultados = preparador.executeQuery();
	
			while (resultados.next()) {
				
				BeanMedico med = new BeanMedico();
				
				med.setMatricula(resultados.getInt("matricula"));
				med.setNomeMed(resultados.getString("nomemed"));
				med.setEndereco(resultados.getString("endereco"));
				med.setSalario(resultados.getFloat("salario"));
				med.setCRM(resultados.getInt("crm"));
				
				lista.add(med);
			    
			} 

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}

			return lista; 

		}

}
