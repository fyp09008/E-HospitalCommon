package message;

import java.io.Serializable;
/**
 * obsolete class, developed in 09/10 semester 1 using socket programming.
 * @author      Gilbert
 */
public class AuthRequestMessage implements Serializable{

	/**
	 * generated serialVersionUID
	 * serialVersionUID = -1033966351913762673L;
	 */
	private static final long serialVersionUID = -1033966351913762673L;
	/**
	 */
	private String username;
	/**
	 */
	private byte[] password;
	/**
	 * @param username      the user name to set
	 * @uml.property  name="username"
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return      the user name
	 * @uml.property  name="username"
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param password      the password to set
	 * @uml.property  name="password"
	 */
	public void setPassword(byte[] password) {
		this.password = password;
	}
	/**
	 * @return      the password
	 * @uml.property  name="password"
	 */
	public byte[] getPassword() {
		return password;
	}
}
