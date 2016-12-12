

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Vector;

public class UserThread implements Runnable
{
	private DataInputStream InputInformation;
	private DataOutputStream OutputInformation;
	private Socket UserSocket;
	private String Command;
	private String ChatInformation;
	private String Statement;
	private String InputStatement;
	private String ChessMovement;
	public UserThread(Socket InputUserSocket)
	{
		init(InputUserSocket);
	}
	private void init(Socket InputUserSocket)
	{
		UserSocket=InputUserSocket;
		try
		{
			InputInformation=new DataInputStream(UserSocket.getInputStream());
			OutputInformation=new DataOutputStream(UserSocket.getOutputStream());

		}
		catch (Exception Event)
		{
			System.out.println(Event.getMessage());
		}
		new Thread(this).start();
	}
	public void run()
	{
		boolean IsSuccess=false;
		try
		{
			while(true)
			{
				Command=InputInformation.readUTF();
				InputStatement=Command;
				String CommandArray[]=Command.split(" ");
				Statement=CommandArray[0];
				switch(Statement)
				{
					case "receive":
						ChatInformation=CommandArray[1];
						//
						break;
					case "move":
						ChessMovement=CommandArray[1]+" "+CommandArray[2]+" "+CommandArray[3];
						//
						break;
					case "seccess":
						IsSuccess=true;
						break;
/*					case "regret":
						//
						break;
				case "start":
						String IsFirst=CommandArray[1];
						if(IsFirst.equals("1"))
						{
						}							}
						else
						{
								
						}
						//
						break;
					case "login":
						String LoginSuccess=CommandArray[1];
						if(LoginSuccess.equals("success"))
						{
							//
						}
						else
						{
							//
						}
						break;
					case "reg":
						String RegSuccess=CommandArray[1];
						if(RegSuccess.equals("success"))
						{
							//
						}
						else
						{
							//
						}
						break;
					default:
						break;*/
					
				}
				if(IsSuccess==true)
				{
					//
					break;
				}
			}
			

		}
		catch(Exception Event)
		{
			System.out.println(Event.getMessage());
		}
	}
	public void outputInformation(String Command)
	{
		
		try
		{
			switch(Command)
			{	
				case "leave":
					OutputInformation.writeUTF("seccess");
					OutputInformation.flush();
					break;
				case "regret":
					OutputInformation.writeUTF("regret");
					OutputInformation.flush();
					break;
				case "defeat":
					OutputInformation.writeUTF("success");
					OutputInformation.flush();
					break;
				default:
					break;
			}
		}
		catch(Exception Event)
		{
			System.out.println(Event.getMessage());
		}
	}
	public void outputInformation(String Command,String InputInformation)
	{
		String ChessInformation=InputInformation;
		try
		{
			switch(Command)
			{
				case "send":
					OutputInformation.writeUTF("receive"+" "+ChessInformation);
					OutputInformation.flush();
					break;
				case "move":
					OutputInformation.writeUTF("move"+" "+ChessInformation);
					OutputInformation.flush();
					break;				

				case "reg":
					OutputInformation.writeUTF("reg"+" "+ChessInformation);
					OutputInformation.flush();
					break;
				case "login":
					OutputInformation.writeUTF("login"+" "+ChessInformation);
					OutputInformation.flush();
				default:
					break;
			}

		}
		catch (Exception Event)
		{
			System.out.println(Event.getMessage());
		}
	}
	public void login(String UserName,String PassWord)
	{
		try
		{
			OutputInformation.writeUTF(UserName+" "+PassWord);
			OutputInformation.flush();
		}
		catch (Exception Event)
		{
			System.out.println(Event.getMessage());
		}
	}
	public String returnChatInformation()
	{
		return ChatInformation;
	}
	public String returnCommand()
	{
		return InputStatement;
	}
	public String returnMovement()
	{
		return ChessMovement;
	}
}
