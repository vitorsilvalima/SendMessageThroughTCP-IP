package communicationTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class CommunicateTCP
{
	private final String IP;
	private final int PORT;
	private int timeout;
	public CommunicateTCP(String IP, int PORT)
	{
		this.IP=IP;
		this.PORT=PORT;
	}
	public CommunicateTCP(String IP, int PORT, int timeout)
	{
		this(IP,PORT);
		this.timeout=timeout;
	}
	public void receive()
	{
		
	}
	public void send(String ip, int port, int timeout, String content)
	{
	     String ipaddress = ip;
	     int portnumber = port;
	     String sentence;
	     String modifiedSentence;
	     Socket clientSocket;
	     try
	     {
	    	 content+="\r\n";
	         clientSocket = new Socket(ipaddress, portnumber);
	         DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	         BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	         byte[] bufferOut = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	         //outToServer.writeBytes(content +'\r'+'\n');
	         outToServer.write(content.getBytes());
	         //clientSocket.setSoTimeout(timeout);
	         //modifiedSentence = inFromServer.readLine();
	         outToServer.close();
	         clientSocket.close();
	         inFromServer.close();
	     }
	     catch (Exception exc)
	     {
	          modifiedSentence = "";
	     }
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public String getIP() {
		return IP;
	}
	public int getPORT() {
		return PORT;
	}
}
