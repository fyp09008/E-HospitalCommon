package remote.obj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProgramAuthHandler extends Remote{
	public int authProgram(byte[] num, byte[] hashValue) throws RemoteException;
}
