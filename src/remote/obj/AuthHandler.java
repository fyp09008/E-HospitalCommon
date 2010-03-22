package remote.obj;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;


public interface AuthHandler extends Remote {

	public byte[] authenticate(String username, byte[]HEPwd) throws RemoteException;
	public byte[] getEncryptedSessionKey(String username) throws RemoteException;
	public ResultSet getPrivilege(String username) throws RemoteException;
	
}
