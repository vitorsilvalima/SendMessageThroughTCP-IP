package communicationTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommunicateTCP
{
	private final String IP;
	private final int PORT;
	private int timeout;
	private String endingCharacters;
	private Socket serverSocket;
	private DataOutputStream outToServer;
	private BufferedReader inFromServer;
	public CommunicateTCP(String IP, int PORT)
	{
		this.IP=IP;
		this.PORT=PORT;
		initializeTCP();
	}
	public CommunicateTCP(String IP, int PORT, int timeout,String endCharacters)
	{
		this.IP=IP;
		this.PORT=PORT;
		this.endingCharacters=endCharacters;
		this.timeout=timeout;
		initializeTCP();
	}
	public void initializeTCP()
	{
		try 
		{
			serverSocket=new Socket(IP,PORT);
	        outToServer = new DataOutputStream(serverSocket.getOutputStream());
	        inFromServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public String receive()
	{
		try
		{
			if(inFromServer.ready())
			{
				return inFromServer.readLine();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return "";
	}
	public void send(String message)
	{
		try
		{
			if(message!=null)
			{
				message+=endingCharacters;
				outToServer.write(message.getBytes());
			}
		}
		catch(IOException ex)
		{
			
		}
	     //clientSocket.setSoTimeout(timeout);
	    //modifiedSentence = inFromServer.readLine();
	}
	public void closeCommunication()
	{
		try 
		{
			outToServer.close();
			inFromServer.close();
			serverSocket.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
