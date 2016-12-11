package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChessServer 
{
	private ServerSocket ChessServerSocket;
	private Vector ChessUserVector;

	public ChessServer()
	{
		init();
		while(true)
		{
			try
			{
				Socket UserSocket=ChessServerSocket.accept();
				check(UserSocket,ChessUserVector);				
			}
			catch (Exception Event)
			{
				System.out.println(Event.getMessage());
			}
		}
	}
	private void init()
	{
		try
		{
			ChessUserVector=new Vector();
			ChessServerSocket=new ServerSocket(25565);
		}
		catch(Exception Event)
		{
			System.out.println(Event.getMessage());
		}
	}
	private void check(Socket InputUserSocket,Vector InputChessUserSocket)
	{
		Socket UserSocket=InputUserSocket;
		ChessLogin UserLogin=new ChessLogin(UserSocket,InputChessUserSocket);
		new Thread(UserLogin).start();
	}
	public static void main(String args[])
	{
		new ChessServer();
	}
}
