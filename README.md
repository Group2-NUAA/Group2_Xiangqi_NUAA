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

