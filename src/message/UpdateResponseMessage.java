/**
 * 
 */
package message;

import java.io.Serializable;

/**
 * obsolete class, developed in 09/10 semester 1 using socket programming.
 * @author mc
 *
 */
public class UpdateResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3951827684626883464L;

	private boolean status;
	/**
	 * Currently not applicable
	 */
	private int ErrorCode;
	/**
	 * @param status
	 */
	public UpdateResponseMessage(boolean status) {
		this.status = status;
	}
	public boolean getStatus() {
		return status;
	}
	
}
