package remote.obj;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The interface for the client program to authenticate itself.
 * The interface is considered a "bridge" to connect client and server.
 * @author Gilbert
 *
 */
public interface ProgramAuthHandler extends Remote{
	/**
	 * The abstract method that can authenticate the client program.
	 * @param num
	 * @param hashValue
	 * @return 0 for success, 1 for fail, 2 for the client program is not found
	 * @throws RemoteException
	 */
	public int authProgram(byte[] num, byte[] hashValue) throws RemoteException;
}
