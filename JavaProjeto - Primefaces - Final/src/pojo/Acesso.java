package pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name = "Acesso")
public class Acesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String senha;
	
	/*@OneToOne
	private Pessoa pessoa_idPessoa;*/
	
	@OneToOne(mappedBy="acesso", fetch=FetchType.EAGER)
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


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


	/*public Pessoa getPessoa_idPessoa() {
		return pessoa_idPessoa;
	}


	public void setPessoa_idPessoa(Pessoa pessoa_idPessoa) {
		this.pessoa_idPessoa = pessoa_idPessoa;
	}*/



	
	

}