package remote.obj;

import java.rmi.Remote;

public interface EmergencyAccessHandler extends Remote {
	public static String msg = "E-Hospital must A.";
	public int emergencyAccess(String username, String emergencyUser, int tmpCardNum);
}
