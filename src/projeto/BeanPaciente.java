package projeto;

public class BeanPaciente {
	
	private long cpf, telefone;
	private String NomeP, endereco, sexo; 
	private int idade;
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public long getTelefone() {
		return telefone;
	}
	
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	public String getNomeP() {
		return NomeP;
	}
	
	public void setNomeP(String nomeP) {
		NomeP = nomeP;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}


}
