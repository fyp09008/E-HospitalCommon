package remote.obj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClient extends Remote{

	public void timeout() throws RemoteException;
	
}
