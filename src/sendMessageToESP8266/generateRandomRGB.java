package sendMessageToESP8266;

import java.util.Random;

public class generateRandomRGB 
{
	private static char[] hex= {'0',
		'1','2','3','4','5','6','7','8','9','A',
		'B','C','D','F'
	};
	public static String generateRGBCODE()
	{
		Random r= new Random();
		String rgb="";
		for(int i = 0; i<6;i++)
		{
			rgb+=hex[r.nextInt(15)];
		}
		return rgb;
	}
}
