package sendMessageToESP8266;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

import communicationTCP.*;

public class SendMessageToESP8266
{
	
	public static void main(String[] args) 
	{
		long count=0;
		CommunicateTCP senderReceiverTCP = new CommunicateTCP("192.168.0.50", 80, 1000, "\n");
		Scanner scan = new Scanner(System.in);
		try
		{
			boolean stop=false;
			String msgcont = "";
		     while (!stop)
		     {
		    	 count++;
		        msgcont=generateRandomRGB.generateRGBCODE();
		        System.out.println(msgcont + " "+ count);
		        senderReceiverTCP.send(msgcont);
		        String read= senderReceiverTCP.receive();
		        if(read!="")
		        {
		        	System.out.println(read);
		        }
		        Thread.sleep(15);
		     }
		}
		catch(InterruptedException ex)
		{
			
		}
		finally
		{
			if(scan!=null)
			{
					scan.close();
			}
			if(senderReceiverTCP!=null)
			{
				senderReceiverTCP.closeCommunication();
			}
		}
	}

}
