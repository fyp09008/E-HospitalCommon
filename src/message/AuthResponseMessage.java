package message;

import java.io.Serializable;

public class AuthResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -113470047285401156L;
	public boolean isAuth;
	public byte[] sessionKey;
	public byte[] resultSet;
	public byte[] logoutmsg;
}
