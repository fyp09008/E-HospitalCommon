package remote.obj;

import java.rmi.Remote;

public interface EmergencyAccessHandler extends Remote {
	public int emergencyAccess(String username, String emergencyUser, byte[] matchMsg);
}
