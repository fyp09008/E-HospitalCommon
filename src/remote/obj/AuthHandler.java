package remote.obj;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AuthHandler extends Remote {

	public boolean authenticate(String username, byte[]HEPwd) throws RemoteException;
}
