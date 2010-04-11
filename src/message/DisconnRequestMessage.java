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
public class DisconnRequestMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1424517739759548888L;
	private byte[] signature;
	public byte[] getSignature() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

}
