package remote.obj;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;


public interface AuthHandler extends Remote {

	public byte[] authenticate(byte[] usernameIn, byte[]HEPwdIn) throws RemoteException;
	public byte[] getEncryptedSessionKey(byte[] usernameIn) throws RemoteException;
	public byte[] getPrivilege(byte[] usernameIn) throws RemoteException;
	public byte[] getLoMsg(byte[] usernameIn) throws RemoteException;
	public byte[] logout(byte[] usernameIn, byte[] lomsg) throws RemoteException;
	
}
