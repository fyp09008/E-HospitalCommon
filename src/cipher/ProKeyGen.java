/**
 * 
 */
package cipher;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author mhchung
 *
 */
public class ProKeyGen {

	private byte[] no;
	private String path2jar;
	private SecretKeySpec ProgramKey;
	
	/**
	 * @param no The byte array storing the position of the byte hashed
	 * @param path2jar The path to jar
	 * @throws FileNotFoundException 
	 */
	public ProKeyGen(byte[] no, String path2jar) throws FileNotFoundException {
		this.no = no;
		this.path2jar = path2jar;
		File f = new File(this.path2jar);
		DataInputStream bytein = new DataInputStream(new FileInputStream(f));
		byte[] buf = new byte[(int) f.length()];
		try {
			bytein.readFully(buf);
			byte[] selectedVal = new byte[no.length];
			for (int i = 0; i < no.length; i++)
			{
				selectedVal[i] = buf[no[i]];
			}
			byte[] hashedKey = MessageDigest.getInstance("md5").digest(selectedVal);
			this.ProgramKey = new SecretKeySpec(hashedKey, "AES");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.ProgramKey = null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * By default the position of byte hashed is randomly generated
	 * @param path2jar The path to jar
	 * @throws FileNotFoundException 
	 */
	public ProKeyGen(String path2jar) throws FileNotFoundException {
		this.path2jar = path2jar;
		File f = new File(this.path2jar);
		DataInputStream bytein = new DataInputStream(new FileInputStream(f));
		byte[] buf = new byte[(int) f.length()];
		int size = (int) Math.random()*buf.length;
		this.no = new byte[size];
		for (int i = 0; i < size; i++)
		{
			this.no[i] = buf[(int) (Math.random()*buf.length - 1)];
		}
		try {
			bytein.readFully(buf);
			byte[] selectedVal = new byte[no.length];
			for (int i = 0; i < no.length; i++)
			{
				selectedVal[i] = buf[no[i]];
			}
			byte[] hashedKey = MessageDigest.getInstance("md5").digest(selectedVal);
			this.ProgramKey = new SecretKeySpec(hashedKey, "AES");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.ProgramKey = null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SecretKeySpec getProgramKey() {
		return ProgramKey;
	}

	public byte[] getNo() {
		return no;
	}

	public void setNo(byte[] no) {
		this.no = no;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ProKeyGen keygen = new ProKeyGen("common.jar");
			SecretKeySpec sks = keygen.getProgramKey();
			Cipher cipher = Cipher.getInstance("aes");
			cipher.init(Cipher.ENCRYPT_MODE, sks);
			byte [] ciphertext = cipher.doFinal(new String("This is test String").getBytes());
			System.out.println(new String(ciphertext));
			ProKeyGen keygen2 = new ProKeyGen(keygen.getNo(), "common.jar");
			Cipher cipher2 = Cipher.getInstance("aes");
			cipher2.init(Cipher.DECRYPT_MODE, keygen2.getProgramKey());
			System.out.println(new String(cipher2.doFinal(ciphertext)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}