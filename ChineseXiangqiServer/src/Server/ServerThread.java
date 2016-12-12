package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerThread implements Runnable
{
	private Socket ChessUserSocket;
	private Socket OtherChessUserSocket;
	private DataInputStream InputInformation;
	private DataOutputStream OutputInformation;
	private DataInputStream OtherInputInformation;
	private DataOutputStream OtherOutputInformation;

	private Vector ChessUserVector;
	public ServerThread(Socket InputUserSocket,Socket InputOtherUserSocket,Vector InputChessUserVector)
	{
		init(InputUserSocket,InputOtherUserSocket,InputChessUserVector);
		
	}
	private void init(Socket InputUserSocket,Socket InputOtherUserSocket,Vector InputChessUserVector)
	{
		ChessUserSocket=InputUserSocket;
		OtherChessUserSocket=InputOtherUserSocket;
		ChessUserVector=InputChessUserVector;
		try
		{
			InputInformation=new DataInputStream(InputUserSocket.getInputStream());
			OutputInformation=new DataOutputStream(InputUserSocket.getOutputStream());
			OtherOutputInformation=new DataOutputStream(InputOtherUserSocket.getOutputStream());
			OtherInputInformation=new DataInputStream(InputOtherUserSocket.getInputStream());
		}
		catch(Exception Event)
		{
			System.out.println(Event.getMessage());
		}
		new Thread(this).start();
	}
	public void run()
	{
		try
		{
			while(true)
			{
				String Command=InputInformation.readUTF();	
				if(Command.equals("")==false)
				{try
				{

					OtherOutputInformation.writeUTF(Command);					
					if(Command.equals("leave"))
					{
						ChessUserSocket.close();
						ChessUserVector.removeElement(ChessUserSocket);
						ChessUserVector.removeElement(OtherChessUserSocket);
						ChessUserVector.add(OtherChessUserSocket);
						OtherOutputInformation.writeUTF("seccess");
						break;
					}
				}			
				catch(Exception Event)
				{
					System.out.println(Event.getMessage());
				}				
				String OtherCommand=OtherInputInformation.readUTF();
				try
				{
					OtherOutputInformation.writeUTF(OtherCommand);					
					if(OtherCommand.equals("leave"))
					{
						OtherChessUserSocket.close();
						ChessUserVector.removeElement(ChessUserSocket);
						ChessUserVector.removeElement(OtherChessUserSocket);
						ChessUserVector.add(ChessUserSocket);
						OutputInformation.writeUTF("seccess");
						break;
					}
				}
				catch (Exception Event)
				{

					System.out.println(Event.getMessage());
				}
			}}
		}
		catch(Exception Event)
		{
			System.out.println(Event.getMessage());
		}
	}
	public void outputInformation()
	{
		try
		{
			OutputInformation.writeUTF("start"+" "+"first");
			OtherOutputInformation.writeUTF("start"+" "+"second");
			
		}
		catch (Exception Event)
		{
			System.out.println(Event.getMessage());
		}
		
	}
}
