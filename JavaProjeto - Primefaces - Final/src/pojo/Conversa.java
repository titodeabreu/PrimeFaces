package pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Conversa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConversaPK timestampConversa;

	private Timestamp timestampAceite;

	@ManyToOne
	@JoinColumn(name="Pessoa_idPessoa")
	private Pessoa pessoa1;

	@ManyToOne
	@JoinColumn(name="Pessoa_idPessoa1")
	private Pessoa pessoa2;

	@OneToMany(mappedBy="timestampConversa")
	private List<Mensagem> mensagems;

	public Conversa() {
	}

	

	public ConversaPK getTimestampConversa() {
		return timestampConversa;
	}



	public void setTimestampConversa(ConversaPK timestampConversa) {
		this.timestampConversa = timestampConversa;
	}



	public Timestamp getTimestampAceite() {
		return this.timestampAceite;
	}

	public void setTimestampAceite(Timestamp timestampAceite) {
		this.timestampAceite = timestampAceite;
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

	public List<Mensagem> getMensagems() {
		return this.mensagems;
	}

	public void setMensagems(List<Mensagem> mensagems) {
		this.mensagems = mensagems;
	}

	public Mensagem addMensagem(Mensagem mensagem) {
		getMensagems().add(mensagem);
		mensagem.setTimestampConversa(this);

		return mensagem;
	}

	public Mensagem removeMensagem(Mensagem mensagem) {
		getMensagems().remove(mensagem);
		mensagem.setTimestampConversa(null);

		return mensagem;
	}

}