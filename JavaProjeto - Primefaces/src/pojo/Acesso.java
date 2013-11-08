package pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Acesso")
public class Acesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String senha;

	public Acesso() {
	}

	
	@Override
	public String toString() {
		return "Acesso [email=" + email + ", senha=" + senha + "]";
	}



	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	
	

}