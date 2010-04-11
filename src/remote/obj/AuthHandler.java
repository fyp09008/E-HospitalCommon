package remote.obj;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Gilbert, mc, chun
 *
 */
public interface AuthHandler extends Remote {

	/**
	 * The method take the program key encrypted username and 
	 * program key encrypted, signed and hashed password and authenticate. 
	 * @param usernameIn
	 * @param HEPwdIn
	 * @return an encrypted boolean
	 * @throws RemoteException
	 */
	public byte[] authenticate(byte[] usernameIn, byte[]HEPwdIn) throws RemoteException;
	
	/**
	 * get the session key in encrypted 
	 * @param usernameIn
	 * @return byte array of encrypted session key and session key.
	 * @throws RemoteException
	 */
	public byte[] getEncryptedSessionKey(byte[] usernameIn) throws RemoteException;
	
	/**
	 * get privilege in encrypted fashion. 
	 * @param usernameIn
	 * @return the privilege encrypted in program key and session key.
	 * @throws RemoteException
	 */
	public byte[] getPrivilege(byte[] usernameIn) throws RemoteException;
	
	/**
	 * get encrypted logout message.
	 * @param usernameIn
	 * @return logout message encrypted in program key and session key.
	 * @throws RemoteException
	 */
	public byte[] getLoMsg(byte[] usernameIn) throws RemoteException;
	
	/**
	 * logout the user
	 * @param usernameIn
	 * @param lomsg
	 * @return true or false encrypted in program key
	 * @throws RemoteException
	 */
	public byte[] logout(byte[] usernameIn, byte[] lomsg) throws RemoteException;
	
	/**
	 * inform the server that card is unplugged.
	 * @param uernameIn
	 * @throws RemoteException
	 */
	public void unplugCard(byte[] uernameIn) throws RemoteException;
	
	/**
	 * change the password of the usernameIn
	 * @param usernameIn
	 * @param hashedOld
	 * @param hashedNew
	 * @return a true or false with encryption.
	 * @throws RemoteException
	 */
	public byte[] changePassword(byte[] usernameIn, byte[]hashedOld, byte[]hashedNew) throws RemoteException;
	
}
