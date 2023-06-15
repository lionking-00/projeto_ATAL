package ProjetoTeste;

import java.sql.SQLException;
import java.util.List;

import projeto.BeanConsulta;
import projeto.ConsultaDAO;


public class TesteConsulta {
	
	public static void main(String[] args) {

		testaInsert();
	}

	
	public static void testaInsert() {
		BeanConsulta consulta1 = new BeanConsulta();
		
		consulta1.setMedMat(1);
		consulta1.setCpfP(782657445);
		consulta1.setPreco(60);
		consulta1.setDate("22/12/2020");
		consulta1.setHora("14h");
		consulta1.setEspecialidade("Oftamologista");
		

		ConsultaDAO consDAO = null;

	
		try {

			consDAO = new ConsultaDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

	}

		consDAO.newConsulta(consulta1);

	} 
	
	public static void testaUpdate() {

		BeanConsulta consulta1 = new BeanConsulta();
		
		consulta1.setDate("28/12/2020");

		ConsultaDAO consDAO = null;
		

		try {

			consDAO = new ConsultaDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace(); 
		} 

			consDAO.alteraConsulta(consulta1);

		}
	
	public static void testaDelete() {

		BeanConsulta consulta = new BeanConsulta();

		consulta.setCpfP(782659845);

		ConsultaDAO consDAO = null;

		try {

			consDAO = new ConsultaDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

		}

			consDAO.deleteConsulta(consulta);

		}
	
	public static void testaSelectTodos() {

		ConsultaDAO consDAO = null;

		try {

			consDAO = new ConsultaDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

		}


		List<BeanConsulta> listaResultado = consDAO.selectTodos();
		
		for(BeanConsulta cons:listaResultado) {

			System.out.println("\n" + "Matricula Med: " + cons.getMedMat() + "\n" + "Cpf Paciente: " + cons.getCpfP() +"\n" +
			"Preço: " + cons.getPreco() + "\n" + "Especialidade: " + cons.getEspecialidade() + "\n" + "Data Consulta: " + cons.getHora() +
			"\n" + "Hora: " + cons.getHora());
		}
	}

}
