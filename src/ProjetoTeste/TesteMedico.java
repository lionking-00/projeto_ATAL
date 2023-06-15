package ProjetoTeste;
import java.sql.SQLException;
import java.util.List;

import projeto.BeanMedico;
import projeto.MedicoDAO;

public class TesteMedico {
	
	public static void main(String[] args) {

		
		testaSelectTodos();

	}

	
	public static void testaInsert() {

		BeanMedico med = new BeanMedico();
		
		med.setMatricula(2);
		med.setNomeMed("Fulaninho");
		med.setEndereco("Rua jaja");
		med.setSalario(2000);
		med.setCRM(984562);

		MedicoDAO medDAO = null;

	
		try {

			medDAO = new MedicoDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {
			exp.printStackTrace();

	}

		medDAO.addMedico(med);

	} 
	
	public static void testaUpdate() {

		BeanMedico med = new BeanMedico();

		med.setSalario(2000);

		MedicoDAO medDAO = null;

		try {

			medDAO = new MedicoDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace(); 
		} 

			medDAO.alteraMedico(med);

		} 
	
	public static void testaDelete() {

		BeanMedico med = new BeanMedico();

		med.setMatricula(1);

		MedicoDAO medDAO = null;

		try {

			medDAO = new MedicoDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

		}

			medDAO.deleteMedico(med);

		}
	
	public static void testaSelectTodos() {

		MedicoDAO medDAO = null;

		try {

			medDAO = new MedicoDAO();

		} catch (SQLException exp) {

			exp.printStackTrace();

		} catch (ClassNotFoundException exp) {

			exp.printStackTrace();

		}


		List<BeanMedico> listaResultado = medDAO.selectTodos();

		for(BeanMedico med:listaResultado) {

			System.out.println("\n" + "Matrícula: "+ med.getMatricula() + "\n" + "Nome Medico: "+ med.getNomeMed()+ "\n" + "Endereço: " + med.getEndereco() + "\n" +
					"Salário: " + med.getSalario() + "\n" + "CRM: "+ med.getCRM());
		}

		}

}
