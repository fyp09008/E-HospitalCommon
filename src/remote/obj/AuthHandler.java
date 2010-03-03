package remote.obj;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AuthHandler extends Remote {

	public byte[] authenticate(String username, byte[]HEPwd) throws RemoteException;
}
