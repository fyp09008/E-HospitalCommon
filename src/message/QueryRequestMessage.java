package message;

import java.io.Serializable;

/**
 * obsolete class, developed in 09/10 semester 1 using socket programming.
 * @author Gilbert
 *
 */
public class QueryRequestMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4067528266309901746L;
	public byte[] query;
	public String username;
}
