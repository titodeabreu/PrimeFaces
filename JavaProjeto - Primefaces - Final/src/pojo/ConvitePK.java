package pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the convite database table.
 * 
 */
@Embeddable
public class ConvitePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timestampConvite;


	public ConvitePK() {
	}
	public java.util.Date getTimestampConvite() {
		return this.timestampConvite;
	}
	public void setTimestampConvite(java.util.Date timestampConvite) {
		this.timestampConvite = timestampConvite;
	}
	

}