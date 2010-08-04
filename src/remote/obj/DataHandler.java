package remote.obj;
import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * remote interface class for data manipulation and query.
 * @author Gilbert
 *
 */

public interface DataHandler extends Remote {

	/**
	 * @param sessionID
	 * @param queryStmt
	 * @return
	 * @throws RemoteException
	 */
	public byte[] query(String sessionID, byte[] queryStmt) throws RemoteException;

	/**
	 * @param sessionID
	 * @param queryStmt
	 * @param param
	 * @return
	 * @throws RemoteException
	 */
	public byte[] query(String sessionID, byte[] queryStmt, byte[] param) throws RemoteException;

	
	/**
	 * @param sessionID
	 * @param updateStmt
	 * @return
	 * @throws RemoteException
	 */
	public int update(String sessionID, byte[] updateStmt) throws RemoteException;
	
	/**
	 * @param sessionID
	 * @param updateStmt
	 * @param param
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(String sessionID, byte[] updateStmt, byte[] param) throws RemoteException;
	
}
