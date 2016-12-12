

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Vector;

public class ChessUser 
{
	private Socket UserSocket;
	private final String IP="121.42.207.96";
	private UserThread ChessUserThread;
	private final int Port=25565;
	private String UserInformation;
	public ChessUser()
	{
		init();
	}
	private void init()
	{		
		try
		{
			UserSocket=new Socket(IP,Port);
		}
		catch (Exception Event)
		{
			
		}
		ChessUserThread=new UserThread(UserSocket);
		
	}		
/*	public static void main(String args[])
		{
			new ChessUser();
		}
*/		
	public void outputInformation(String Command,String InputInformation)
	{
		ChessUserThread.outputInformation(Command,InputInformation);
	}
	public String returnChatInformation()
	{
		return ChessUserThread.returnChatInformation();
	}
	public String returnCommand()
	{
		return ChessUserThread.returnCommand();
	}
	public String returnMovement()
	{
		return ChessUserThread.returnMovement();
	}
}
