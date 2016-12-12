# Group2_Xiangqi_NUAA
py小轩

Group 2

YY
1.Subsystem:  graphical  interface
2.Class:  
class ChessMainFrame 
In this class, we will define some variables like these
player(JLabel)
chessboard(JLabel)
toolbar(JToolBar)
con(Contantainer)
exit(JButton, to get out)
regret(JButton, to regret a chess)
restart(JButton)
text(JLabel, to display current condition)
Var(Vector, to save current operate)
rule(ChessRule, to call the function in the ChessRule)
chessManClick(Boolean, to judege whether the chess is blink ,in oather word, whether the is clicked)
chessPlayClick(int, to judge who should run the chess or boss stop)
blinkThread(Thread,to control the thread of the blink chess)

3.Function:
①	ChessMainFrame()
The constructor of the class ChessMainFrame.
We will initialize the graphical interface of xiangqi in this constructor.Include instantiate rule, create toolbar, add exit; regret restart;  text to toolbar.Besides,we will have the function drawChessMan() to add chess label.We will addactionlistener of these chess ;the move of the chess(this is in con)and the chessboard.We will set the size of screen and frame.We will also use function run
() to use thread to control the blink of the chess,.
②	mouseClick(MouseEvent m) 
Its to click chess,first click the chess will blink, then if you click an blank ,it will use the function in rule to move chess,if you click an enemy chess,it will judge whether you can eat it,if you click another chess of yours,the chess will stop blink,the other will blink. 
③	ActionPerformed(ActionEvent event)
Its to define the event of the buttons respose.



Ezio
Subsystem: rule and save
Public Class Chess{
    Private  String  name;
    Private Boolean side;//Define BLACK_Side=true,RED_Side=false;
    Private Chess_Move move;//refer to a class which defines different chesses’ way of move;
Public  Int  Row, Column;//The place where the chess is in; 
//The chess’s own design;       
}//save the All Chess’s content by xml;Call it when open XiangQI;

Public void ResetChessBoard() //Which function is to clear the chessboard and start a new game or load another game;
Public void LoadGame();
Public void SaveGame();//save all chesses’ data into xml;
Public void QuitGame();
Public void MovablePlace(Chess ChosenChess);//Show all the movable place of the chess which is chosen.(which based on the chess’s move way and place and ETC.);
Public void EatChess(Chess Eatchess,Chess Eatenchess)//Call this function when one side’s chess eats another side’s chess;

Noah
1.	Subsystem:Multiplayer
2.Class(include function)
(1)
public class ChessLogin implements Runnable
{		//decide what to do when Client log in 

public ChessLogin();					//log in
public void run();	
//when Client log in ,allocate the room and start the game
public void notifyLoginListener();			//add and notify listener
public String checkLogin();			//check information about user
public static int byteToInt();				//convert byte type to int type
}
(2).
public class LoginUser{					//the class for user
public LoginUser() 						//construction
}
(3).
public interface LoginListener
{	//a interface  about listening to the log
public void onLoginEvent( );//when a user log in ,the server prepare for the user
}									
(4).
public class ChessServer implements LoginListener
{	//the class about the whole chess server
public int addTableUser();					//allocate a table for user 
public void removeTableUser( );			//when user leaves ,delete the table
public boolean addUser();			//when a new user join in the server,add 											his information
public void removeUser( );					//when the user leaves,shut down the connect		
public void sendToTable( );	//send the user information to the table
public byte[] getUserListData();	//send the user information to the    server
public void onUserPackageArrived( );//deal with the quests such as 													talking admitting defeat
public void onLoginEvent( );	//when a new user log in , initialize the event	
}										
(5).
public class ChessUser implements TcpDataListener
{		//a class about user informaiton about quests while playing chess in the server
public ChessUser( )			//construction	
public boolean init()						//initialize
public void setState(int)						//set the state of the game
public void start()							//start the game
public void onTcpDataArrived()		//send the data to the server
}
(6)
public class TcpDataReceiver extends Thread
{	//the receiver of tcp data
public TcpDataReceiver( );	//construction
public void run();			//receive the stream while playing
public void addTcpDataListener();			//add tcp data listener
}
(7).
public interface TcpDataListener{					//the listener for the tcp data
public void onTcpDataArrived( );
}
(8).
public class TcpDataEvent
{	//the class of package of tcp data 
public TcpDataEvent()		//construction
public byte[] getHeader();						//return the private data head
public byte[] getData();					//return the private data datas
public int getDataLen();						//return the private data length Sapphire
(9).
public class TcpDataSender
{
public TcpDataSender( );						//construction
public void sendData();						//send the tcp data to the server
}
(10).
public class HttpInputStream extends InputStream
{		//a class ensure that the length of tcp 												data is safe
public HttpInputStream();					//construction

public static void readBytes( ); 	//check whether the length of the stream is correct
}										

ANX
1.Subsystem: AI
2.Class 
AI
give a value to each chess piece,and then use greedy strategy to find a best move which have highest score.use a stack to store every move so that the AI can process player's regret.
main routine is
	NextMove(int label, int x, int y):String,
this routine get the player's current move, and return AI's solution.It enumerate all the chess pieces that are friendly and alive, call
		Search(int label):move//{score, label, x, y}
to search all position they can arrive, and calculate the score for each piece at each position,and finally return the solution which get highest score.
By using a stack called Situations, the AI class can store every move from the beginning to the current time. When the player regret his last move, call 
	Regret():void
to keep sync with the interface,it pop two moves from Situations to restore the move before last move.