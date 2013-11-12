package pojo;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ConversaPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(insertable=false, updatable=false)
	private int timestampConversa;


	public ConversaPK() {
	}
	public int getTimestampConversa() {
		return this.timestampConversa;
	}
	public void setTimestampConversa(int timestampConversa) {
		this.timestampConversa = timestampConversa;
	}
	

}