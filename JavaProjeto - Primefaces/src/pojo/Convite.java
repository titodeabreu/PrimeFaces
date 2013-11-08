package pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the convite database table.
 * 
 */
@Entity
@NamedQuery(name="Convite.findAll", query="SELECT c FROM Convite c")
public class Convite implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConvitePK timestampConvite;

	private String aceiteConvite;

	private Timestamp timestampRecebimento;

	@ManyToOne
	@JoinColumn(name="PessoaFisica_idPessoa")
	private Pessoa pessoa1;

	@ManyToOne
	@JoinColumn(name="PessoaFisica_idPessoa1")
	private Pessoa pessoa2;

	public Convite() {
	}


	public ConvitePK getTimestampConvite() {
		return timestampConvite;
	}


	public void setTimestampConvite(ConvitePK timestampConvite) {
		this.timestampConvite = timestampConvite;
	}


	public String getAceiteConvite() {
		return this.aceiteConvite;
	}

	public void setAceiteConvite(String aceiteConvite) {
		this.aceiteConvite = aceiteConvite;
	}

	public Timestamp getTimestampRecebimento() {
		return this.timestampRecebimento;
	}

	public void setTimestampRecebimento(Timestamp timestampRecebimento) {
		this.timestampRecebimento = timestampRecebimento;
	}

	public Pessoa getPessoa1() {
		return this.pessoa1;
	}

	public void setPessoa1(Pessoa pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public Pessoa getPessoa2() {
		return this.pessoa2;
	}

	public void setPessoa2(Pessoa pessoa2) {
		this.pessoa2 = pessoa2;
	}

}