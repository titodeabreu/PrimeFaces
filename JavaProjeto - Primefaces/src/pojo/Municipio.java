package pojo;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.IndexColumn;

import java.util.List;


@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;
	@IndexColumn(name = "idMunicipio_UNIQUE")
	@Id
	@Column(name = "idMunicipio", nullable = false)
	private int idMunicipio;
	@Column(name = "nomeMunicipio", nullable = false)

	private String nomeMunicipio;
	@Column(name = "ufMunicipio", nullable = false)

	private String ufMunicipio;

	@Override
	public String toString() {
		return "Municipio [idMunicipio=" + idMunicipio + ", nomeMunicipio="
				+ nomeMunicipio + ", ufMunicipio=" + ufMunicipio + "]";
	}
	
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy="municipio", cascade = CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Endereco> enderecos;

	public Municipio() {
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNomeMunicipio() {
		return this.nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public String getUfMunicipio() {
		return this.ufMunicipio;
	}

	public void setUfMunicipio(String ufMunicipio) {
		this.ufMunicipio = ufMunicipio;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setMunicipio(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setMunicipio(null);

		return endereco;
	}

}