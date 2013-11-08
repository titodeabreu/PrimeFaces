package pojo;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class MensagemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timestampMensagem;

	
	public MensagemPK() {
	}

	public java.util.Date getTimestampMensagem() {
		return this.timestampMensagem;
	}

	public void setTimestampMensagem(java.util.Date timestampMensagem) {
		this.timestampMensagem = timestampMensagem;
	}


}