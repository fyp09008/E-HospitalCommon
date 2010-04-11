package message;

import java.io.Serializable;

/**
 * obsolete class, developed in 09/10 semester 1 using socket programming.
 * @author Gilbert
 *
 */
public class ServerAuthResponseMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8589529801648916501L;
	byte[] encryptedFingerprint;

	/**
	 * @param encryptedFingerprint
	 */
	public ServerAuthResponseMessage(byte[] encryptedFingerprint) {
		this.encryptedFingerprint = encryptedFingerprint;
	}

	public byte[] getEncryptedFingerprint() {
		return encryptedFingerprint;
	}

	public void setEncryptedFingerprint(byte[] encryptedFingerprint) {
		this.encryptedFingerprint = encryptedFingerprint;
	}
}
