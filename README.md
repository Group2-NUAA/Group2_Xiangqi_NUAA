# Group2_Xiangqi_NUAA
py小轩

Group 2

YY
I am responsible for the graphical interfaces ,including  MainFrame interface,pvpchess interface,pvechess interface,login register interface and choose interface .

I have five class,including MainFrame,pvpframe,pveframe,Login and chooseframe.

The class MainFrame is pvpchess interface, one people can play chess on it(the first is red chess),like I play one red chess,then I can play one black chess,then red,black…,it has function “new game”, “regret”, “exit”.

The class pvpframe is pvpchess interface,it connect the server,so two people can play chess with each other,I add chat function in it,but it does’t work,maybe something wrong in the connection with servers.
it has function “new game”, “regret”, “exit”.

The class pveframe is pvechess interface,people play red chess,robot play black chess. it has function “new game”, “regret”, “exit”.When people play one chess,robot will play one chess immediately.

The class Login has two function,login and register .I have a connector ,it can send account and password to servers. If login success,this frame will close and the frame for chessboard will appear.However,maybe there is something wrong with this part,so it’s just a interfaces.

The class chooseframe has two button:pve and pvp.If you click pve,this frame will close and pveframe for chessboard will appear.If you click pvp,this frame will close and the frame L0gin will appear.




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
I am responsible for the multiplayer mode . I have five classes ,including ChessServer,ChessLogin,ServerThread,ChessUser and UserThread.
1.ChessServer class
This class aims to start the server,including functions like “private void init()”,which initializes the class ,construction of the class which listen to the socket from client ,”private void check” which when a client connect to this server ,declare and define a ChessLogin object.
2.ChessLogin class
This class aims to check whether the login or the register is valid ,including functions like “private void init()”, which initializes the class and connects to the mysql,construction of the class which use the init() function, thread function named”public void run()” which listen to the client and check whether the login or register is successful or failed and if success and there are two players,declare and define a ServerThread object.
3.ServerThread
This class is a listening thread including functions like “private void init()”,which initializes the class,construction of the class which user the init() function ,thread function named “public void run()” which listen to the client and return the information about chess to the other user ,”public void outputInformation()” which if the game started ,send the signal to the players.
4.ChessUser
This class aims to start the client,including functions like “private void init()”,which initializes the class and declare and define a UserThread object  ,construction of the class which use the init() function , .
5.UserThread
This class is a listening thread,including functions like “private void init()”,which initializes the class ,the construction of the class use the init() function ,the thread function”public void run()” which listen to the server and receive the information from server ,the function “outputInformation” which send information to the server.

ANX
1.Subsystem: AI
2.Class 
class AI{
     public void Eval();   //visit current interface
     public void Move();   //call the function in rule
}

