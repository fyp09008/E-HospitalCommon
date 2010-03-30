package remote.obj;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DataHandler extends Remote {

	public byte[] query(String sessionID, byte[] queryStmt) throws RemoteException;

	public byte[] query(String sessionID, byte[] queryStmt, byte[] param) throws RemoteException;

	public int insert(String sessionID, byte[] insertStmt) throws RemoteException;
	
	public int update(String sessionID, byte[] updateStmt) throws RemoteException;
	
	public int update(String sessionID, byte[] updateStmt, byte[] param) throws RemoteException;
	
}
