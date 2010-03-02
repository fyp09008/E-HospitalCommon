package remote.obj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote{
	public void timeout() throws RemoteException;
}
