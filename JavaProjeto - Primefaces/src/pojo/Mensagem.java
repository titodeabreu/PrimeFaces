package pojo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MensagemPK timestampMensagem;

	private String textoMensagem;

	@ManyToOne
	@JoinColumn(name="Conversa_Pessoa_idPessoa")
	private Pessoa pessoa1;

	@ManyToOne
	@JoinColumn(name="Conversa_Pessoa_idPessoa1")
	private Pessoa pessoa2;
	
	@ManyToOne
	@JoinColumn(name="Conversa_timestampConversa")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Conversa timestampConversa;
	

	public Mensagem() {
	}

	
	
	
	@Override
	public String toString() {
		return "Mensagem [timestampMensagem=" + timestampMensagem
				+ ", textoMensagem=" + textoMensagem + ", pessoa1=" + pessoa1
				+ ", pessoa2=" + pessoa2 + ", timestampConversa=" + timestampConversa + "]";
	}




	public MensagemPK getTimestampMensagem() {
		return timestampMensagem;
	}


	public void setTimestampMensagem(MensagemPK timestampMensagem) {
		this.timestampMensagem = timestampMensagem;
	}


	public String getTextoMensagem() {
		return this.textoMensagem;
	}

	public void setTextoMensagem(String textoMensagem) {
		this.textoMensagem = textoMensagem;
	}


	public Pessoa getPessoa1() {
		return pessoa1;
	}


	public void setPessoa1(Pessoa pessoa1) {
		this.pessoa1 = pessoa1;
	}


	public Pessoa getPessoa2() {
		return pessoa2;
	}


	public void setPessoa2(Pessoa pessoa2) {
		this.pessoa2 = pessoa2;
	}




	public Conversa getTimestampConversa() {
		return timestampConversa;
	}




	public void setTimestampConversa(Conversa timestampConversa) {
		this.timestampConversa = timestampConversa;
	}


	

	
	

}