package remoteInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Authenticator extends Remote {

	public boolean authenticate(String username, byte[]HEPwd) throws RemoteException;

	public boolean serverAuthenticate(byte[] serverID) throws RemoteException;
	
}
