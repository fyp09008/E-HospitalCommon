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
 * The class that can authenticate the program
 * @author mhchung
 *
 */
public class ProKeyGen {

	private byte[] no;
	private String path2jar;
	private SecretKeySpec ProgramKey;
	
	/**
	 * The constructor that hashed the selected num of bytes and create a program key.
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
			byte[] hashedKey = MessageDigest.getInstance("md5").digest(buf);
			System.out.println("ser: "+new String(hashedKey));
			this.ProgramKey = new SecretKeySpec(hashedKey, "AES");
		} catch (IOException e) {
			e.printStackTrace();
			this.ProgramKey = null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Hashed a random number of bytes in random number of line.
	 * By default the position of byte hashed is randomly generated
	 * @param path2jar The path to jar
	 * @throws FileNotFoundException 
	 */
	public ProKeyGen(String path2jar) throws FileNotFoundException {
		this.path2jar = path2jar;
		File f = new File(this.path2jar);
		DataInputStream bytein = new DataInputStream(new FileInputStream(f));
		byte[] buf = new byte[(int) f.length()];
		int size = buf.length;
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
			byte[] hashedKey = MessageDigest.getInstance("md5").digest(buf);
			System.out.println("client: "+new String(hashedKey));
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
	 * get generated Key
	 * @return Program Key
	 */
	public SecretKeySpec getProgramKey() {
		return ProgramKey;
	}

	/**
	 * get the number of bytes hashed.
	 * @return
	 */
	public byte[] getNo() {
		return no;
	}

	/**
	 * set the number bytes hashed.
	 * @param no
	 */
	public void setNo(byte[] no) {
		this.no = no;
	}

	/**
	 * Main Class for unit testing.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			byte[] no = {1, 2};
			ProKeyGen keygen = new ProKeyGen("common.jar");
			ProKeyGen keygen2 = new ProKeyGen(no, "common.jar");
			SecretKeySpec sks = keygen.getProgramKey();
			Cipher cipher = Cipher.getInstance("aes");
			cipher.init(Cipher.ENCRYPT_MODE, sks);
			byte [] ciphertext = cipher.doFinal(new String("This is test String").getBytes());
			System.out.println(new String(ciphertext));
			Cipher cipher2 = Cipher.getInstance("aes");
			cipher2.init(Cipher.DECRYPT_MODE, keygen2.getProgramKey());
			System.out.println(new String(cipher2.doFinal(ciphertext)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
	}

}
