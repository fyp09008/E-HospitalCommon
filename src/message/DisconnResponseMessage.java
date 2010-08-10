/**
 * 
 */
package message;

import java.io.Serializable;

/**
 * obsolete class, developed in 09/10 semester 1 using socket programming.
 * @author      mc
 */
public class DisconnResponseMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8071925500966803931L;
	/**
	 * @uml.property  name="status"
	 */
	private boolean status;

	/**
	 * @param status
	 */
	public DisconnResponseMessage(boolean status) {
		this.status = status;
	}

	/**
	 * @return
	 * @uml.property  name="status"
	 */
	public boolean getStatus() {
		return status;
	}

}
