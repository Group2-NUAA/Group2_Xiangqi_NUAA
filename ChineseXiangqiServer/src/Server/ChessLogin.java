package Server;

import java.util.*;
import java.sql.*;
import java.net.*;
import java.io.*;
import java.applet.*;

public class ChessLogin  implements Runnable
{
	private DataInputStream InputInformation;
	private DataOutputStream OutputInformation;
	private Socket UserSocket;	
	private Connection UserLogin;
	private Statement SqlStatement;
	private String SqlCommand;
	private ResultSet SqlResult;
	private boolean LoginSuccess;
	private boolean RegSuccess;
	private Vector ChessUserVector;
	private int PlayerNumber;
	public ChessLogin(Socket InputUserSocket,Vector InputChessUserVector)
	{
		init(InputUserSocket,InputChessUserVector);
	}
	private void init(Socket InputUserSocket,Vector InputChessUserVector)
	{
		UserSocket=InputUserSocket;	
		ChessUserVector=InputChessUserVector;
		PlayerNumber=0;
		try
		{
			InputInformation=new DataInputStream(UserSocket.getInputStream());
			OutputInformation=new DataOutputStream(UserSocket.getOutputStream());
		}
		catch (Exception Event)
		{
			System.out.println(Event.getMessage());
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			String Url = "jdbc:mysql://localhost/User";
			String User="root";
			String Password="rfnoah";
			UserLogin=DriverManager.getConnection(Url, User, Password);
			
		}
		catch (Exception Event)
		{
			System.out.println(Event.getMessage());
		}

	}
	public void run()
	{
		while(true)
		{
			try	
			{				
				String LoginInformation=InputInformation.readUTF();
				if(LoginInformation.equals("")==false)
				{String UserInformation[]=LoginInformation.split(" ");
				String UserName=UserInformation[1];
				String Password=UserInformation[2];
				String Command=UserInformation[0];
				if(Command.equals("login"))
				{
					SqlStatement=UserLogin.createStatement();				
					SqlCommand="select * from ChessUser";
					SqlResult=SqlStatement.executeQuery(SqlCommand);

					LoginSuccess=false;
					while(SqlResult.next())
					{
						String CompareUserName=SqlResult.getString("UserName");
						if(CompareUserName.equals(UserName))
						{
							String ComparePassword=SqlResult.getString("UserPassword");
							if(ComparePassword.equals(Password))
							{
								LoginSuccess=true;								
							}
							else
							{
								LoginSuccess=false;
							}
							break;
						}
						else
						{
					
						}
					}
					if(LoginSuccess==true)
					{
						OutputInformation.writeUTF("login"+" "+"success");
						OutputInformation.flush();
				try
						{			
							if(SqlResult!=null)
							{
								SqlResult.close();
							}
							else
							{				
							}
							if(SqlStatement!=null)
							{
								SqlStatement.close();
							}
							else
							{	
							}
							if(UserLogin!=null)
							{
								UserLogin.close();
							}
							break;
						}
						catch (Exception Event)
						{
							System.out.println(Event.getMessage());
						}
					}
					else
					{
						OutputInformation.writeUTF("login"+" "+"failed");
						OutputInformation.flush();
					}
								
				}
				else
				{
					SqlStatement=UserLogin.createStatement();				
					SqlCommand="select * from ChessUser";
					SqlResult=SqlStatement.executeQuery(SqlCommand);

					RegSuccess=true;
					while(SqlResult.next())
					{
						String CompareUserName=SqlResult.getString("UserName");
						if(CompareUserName.equals(UserName))
						{
							RegSuccess=false;
							break;
						}
						else
						{
					
						}
					}
					if(RegSuccess==true)
					{
						SqlCommand="insert into ChessUser values('"+UserName+"','"+Password+"');";
						boolean IsInsert=SqlStatement.execute(SqlCommand);
						OutputInformation.writeUTF("reg"+" "+"success");
						OutputInformation.flush();
						try
						{			
							if(SqlResult!=null)
							{
								SqlResult.close();
							}
							else
							{				
							}
							if(SqlStatement!=null)
							{
								SqlStatement.close();
							}
							else
							{	
							}
							if(UserLogin!=null)
							{
								UserLogin.close();
							}
							break;
						}
						catch (Exception Event)
						{
							System.out.println(Event.getMessage());
						}
					}
					else
					{
						OutputInformation.writeUTF("reg"+" "+"failed");
						OutputInformation.flush();
					}
				}
			}}			
			catch (Exception Event)
			{
				System.out.println(Event.getMessage());
			}
			
		
			
			ChessUserVector.add(UserSocket);
			PlayerNumber=ChessUserVector.size();
			if(PlayerNumber%2==0)
			{
				int FirstMember=PlayerNumber-1;
				int SecondMember=PlayerNumber-2;
				ServerThread User=new ServerThread((Socket)ChessUserVector.elementAt(FirstMember),(Socket)ChessUserVector.elementAt(SecondMember),ChessUserVector);
				User.outputInformation();

			}
					
		}

	}
}
