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
public class UpdateRequestMessage extends QueryRequestMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8391279910640599579L;
	
	/**
	 * Encrypted Type, type can be INSERT, DELETE or UPDATE
	 */
	public byte[] type;
	
	
}
