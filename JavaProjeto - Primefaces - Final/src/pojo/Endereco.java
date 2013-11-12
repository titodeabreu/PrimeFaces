package pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@IndexColumn(name = "idEndereco_UNIQUE")
	@Id
	private int idEndereco;

	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cep", nullable = false)
	private String cep;

	@Column(name = "complemento", nullable = true)
	private String complemento;
	
	@Column(name = "logradouro", nullable = false)
	private String logradouro;

	@ManyToOne
	private Municipio municipio;
	
	@OneToMany(orphanRemoval = true, mappedBy = "endereco")
	@Fetch(FetchMode.SELECT)
	private List<Pessoa> pessoas;

	public Endereco() {
	}
	

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", bairro=" + bairro
				+ ", cep=" + cep + ", complemento=" + complemento
				+ ", logradouro=" + logradouro + ", municipio=" + municipio
				+ "]";
	}



	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setEndereco(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setEndereco(null);

		return pessoa;
	}

}