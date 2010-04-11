package remote.obj;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The interface for client to invoke the server to perform emergency access to the service. 
 * @author Gilbert
 *
 */
public interface EmergencyAccessHandler extends Remote {
	/**
	 * Allow authenticated user to authorized other user to use a particular temp card.
	 * @param username
	 * @param emergencyUser
	 * @param emergencyPwd
	 * @param tmpCardNum
	 * @return 0 if success, other if failed
	 * @throws RemoteException
	 */
	public int emergencyAccess(byte[] username, byte[] emergencyUser, byte[] emergencyPwd, int tmpCardNum) throws RemoteException;
}
