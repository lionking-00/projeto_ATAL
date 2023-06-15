package ProjetoTeste;

import java.sql.SQLException;
import java.util.List;

import projeto.BeanPaciente;
import projeto.PacienteDAO;

public class TestePaciente {
	
	public static void main(String[] args) {
		
		testaInsert();
	}

	
	public static void testaInsert() {

		BeanPaciente paciente = new BeanPaciente();
		
		paciente.setCpf(782657445);
		paciente.setNomeP("Beltrano");
		paciente.setEndereco("rua lala");
		paciente.setTelefone(78957421);
		paciente.setSexo("M");
		paciente.setIdade(20);
		

		PacienteDAO pacDAO = null;

	
		try {

			pacDAO = new PacienteDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

	}

		pacDAO.addPaciente(paciente);

	} 
	
	
	public static void testaUpdate() {

		BeanPaciente paciente = new BeanPaciente();

		paciente.setNomeP("Josefa");

		PacienteDAO pacDAO = null;

		try {

			pacDAO = new PacienteDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace(); 
		} 

			pacDAO.alteraPaciente(paciente);

		}
	
	public static void testaDelete() {

		BeanPaciente paciente = new BeanPaciente();

		paciente.setCpf(782659845);

		PacienteDAO pacDAO = null;

		try {

			pacDAO = new PacienteDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

		}

			pacDAO.deletePaciente(paciente);

		}
	
	public static void testaSelectTodos() {

		PacienteDAO pacDAO = null;

		try {

			pacDAO = new PacienteDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

		}


		List<BeanPaciente> listaResultado = pacDAO.selectTodos();
		
		for(BeanPaciente pac:listaResultado) {

			System.out.println("\n" + "CPF: "+ pac.getCpf() + "\n" + "Nome Paciente: "+ pac.getNomeP()+ "\n" + "Endereço: " + pac.getEndereco() + "\n" +
					"Telefone: " + pac.getTelefone() + "\n" + "Sexo: "+ pac.getSexo() + "\n" + "idade:" + pac.getIdade());
		}
		
		}

}