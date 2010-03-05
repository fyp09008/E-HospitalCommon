package remote.obj;

import java.rmi.*;

public interface DisconnHandler extends Remote {
	public boolean logout(String username, byte[] msgCipher) throws RemoteException;
}
