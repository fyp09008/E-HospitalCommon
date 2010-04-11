package remote.obj;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The interface for performing client callback function
 * @author Gilbert
 *
 */
public interface ClientCallback extends Remote {
	/**
	 * The session will call timeout whenever the session expire.
	 * @throws RemoteException
	 */
	public void timeout() throws RemoteException;
}
