package remote.obj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote {
	public void timeout() throws RemoteException;
}
