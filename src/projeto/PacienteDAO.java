package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
	
	private Connection conexao; 

	public PacienteDAO() throws SQLException, ClassNotFoundException {
		
		conexao = Projeto.criarConexao(); 

	} 
	
	public void addPaciente(BeanPaciente paciente) {

		String sql = "INSERT INTO Paciente (cpf, nomepac, endereco, telefone, sexo, idade) VALUES(?,?,?,?,?,?)"; 

		try { 

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setLong(1, paciente.getCpf());
			
			preparador.setString(2, paciente.getNomeP());
			
			preparador.setString(3, paciente.getEndereco());
			
			preparador.setLong(4, paciente.getTelefone());
	
			preparador.setString(5, paciente.getSexo());
			
			preparador.setInt(6, paciente.getIdade());
	
			preparador.execute(); 
	
			preparador.close();
	
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}

	}
	
	public void alteraPaciente(BeanPaciente med) {

		String sql = "UPDATE Paciente SET nomePac = ? WHERE cpf = cpf";

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setString(1, med.getNomeP());
		
			preparador.execute();
	
			preparador.close();
	
			System.out.println("Alteração realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - "+ e.getMessage());

		} 
	}
	
	public void deletePaciente(BeanPaciente paciente) {

		String sql = "DELETE FROM Paciente WHERE cpf = cpf";

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			preparador.setLong(1, paciente.getCpf());
	
			preparador.execute();
	
			preparador.close();
	
			System.out.println("Deleção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - "+ e.getMessage());

		}
	}
	
	public List<BeanPaciente> selectTodos(){

		String sql = "SELECT * FROM Paciente";

		List<BeanPaciente> lista = new ArrayList<BeanPaciente>();

		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
	
			ResultSet resultados = preparador.executeQuery();
	
			while (resultados.next()) {
				
				BeanPaciente paciente = new BeanPaciente();
				
				paciente.setCpf(resultados.getLong("cpf"));
				
				paciente.setNomeP(resultados.getString("nomePac"));
				
				paciente.setEndereco(resultados.getString("endereco"));
				
				paciente.setTelefone(resultados.getLong("telefone"));
				
				paciente.setSexo(resultados.getString("sexo"));
				
				paciente.setIdade(resultados.getInt("idade"));
				
				lista.add(paciente);
				
			} 

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}

			return lista; 

		}

}
