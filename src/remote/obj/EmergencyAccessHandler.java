package remote.obj;

import java.rmi.Remote;

public interface EmergencyAccessHandler extends Remote {
	public int emergencyAccess(byte[] username, byte[] emergencyUser, byte[] emergencyPwd, int tmpCardNum);
}
