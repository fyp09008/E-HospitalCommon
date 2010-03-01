package remoteInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DataHandler extends Remote {

	public byte[] query(String sessionID, byte[] queryStmt) throws RemoteException;

	public byte[] insert(String sessionID, byte[] insertStmt) throws RemoteException;
	
	public byte[] update(String sessionID, byte[] updateStmt) throws RemoteException;
	
}
