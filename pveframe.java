import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MainFrame extends JFrame implements ActionListener,MouseListener,Runnable
{
	pveRule rule;//class pveRule
	Vector vec;
	JLabel chessPieces[]=new JLabel [32];//32 chess pieces
	JLabel chessBoard;//chessboard
	JLabel text;//display current information to remind player
	JLabel me;//chat
	JButton anew;//start a new game
	JButton regret;//regret and back 
	JButton exit;//get out of the game
	JButton enter;//send the chat information
	Container con;
    JPanel buttonpanel;//put three button here
    JPanel mepanel;
    JPanel chatpanel;
    JTextField metext;
    JTextArea chattext;
    boolean blink;//if true,chess piece will blink;if false,it will eat another and stop blink
    Thread thread;//to control blink
    int flag=2;//flag=1,red;flag=2,black;flag=3,both static
    static int respose;
    
    
    MainFrame()
    {
    	super("Chinese XiangQi");
    	
    	enter=new JButton("enter");
    	enter.addActionListener(this);
    	me=new JLabel("me:");
    	metext=new JTextField("",30);
    	chattext=new JTextArea(100,100);
    	chattext.setWrapStyleWord (true);
    	chattext.setLineWrap (true);
    	//himtext.setText(user.returnChatInformation());
    	mepanel=new JPanel();
    	chatpanel=new JPanel();
    	mepanel.add(me);
    	mepanel.add(metext);
    	mepanel.add(enter);
    	chatpanel.add(chattext);
    	chatpanel.setBounds(90, 650, 400, 150);
    	mepanel.setBounds(0, 820, 560, 30);
    	
    	rule =new PveChessRule();
    	vec=new Vector();
    	buttonpanel=new JPanel();
    	text=new JLabel("Welcome",JLabel.CENTER);
    	
    	anew=new JButton("new game");
    	regret=new JButton("regret");
    	exit=new JButton("exit");
    	buttonpanel.setLayout(new GridLayout(1,3));
    	buttonpanel.add(anew);
    	buttonpanel.add(regret);
    	buttonpanel.add(exit);
    	buttonpanel.setBounds(0,0,560,30);
    	con = this.getContentPane();
    	con.setLayout(null);
    	con.add(buttonpanel); 
    	con.add(mepanel);
    	con.add(chatpanel);
    	text.setBounds(0, 30, 560, 30);
    	con.add(text);
    	anew.addActionListener(this);
    	regret.addActionListener(this);
    	exit.addActionListener(this);
    	
		Icon icon;
		icon=new ImageIcon("黑车.png");
		chessPieces[0]=new JLabel(icon);
		chessPieces[0].setBounds(24, 56, 55, 55);
		chessPieces[0].setName("车1");
		chessPieces[1]=new JLabel(icon);
		chessPieces[1].setBounds(480, 56, 55, 55);
		chessPieces[1].setName("车1");
		
		icon=new ImageIcon("红车.png");
		chessPieces[2]=new JLabel(icon);
		chessPieces[2].setBounds(24, 569, 55, 55);
		chessPieces[2].setName("车2");
		chessPieces[3]=new JLabel(icon);
		chessPieces[3].setBounds(480, 569, 55, 55);
		chessPieces[3].setName("车2");
		
		icon=new ImageIcon("黑马.png");
		chessPieces[4]=new JLabel(icon);
		chessPieces[4].setBounds(81, 56, 55, 55);
		chessPieces[4].setName("马1");
		chessPieces[5]=new JLabel(icon);
		chessPieces[5].setBounds(423, 56, 55, 55);
		chessPieces[5].setName("马1");
		
		icon=new ImageIcon("红马.png");
		chessPieces[6]=new JLabel(icon);
		chessPieces[6].setBounds(81, 569, 55, 55);
		chessPieces[6].setName("马2");
		chessPieces[7]=new JLabel(icon);
		chessPieces[7].setBounds(423, 569, 55, 55);
		chessPieces[7].setName("马2");
		
		icon=new ImageIcon("黑相.png");
		chessPieces[8]=new JLabel(icon);
		chessPieces[8].setBounds(138, 56, 55, 55);
		chessPieces[8].setName("相1");
		chessPieces[9]=new JLabel(icon);
		chessPieces[9].setBounds(366, 56, 55, 55);
		chessPieces[9].setName("相1");
		
		icon=new ImageIcon("红相.png");
		chessPieces[10]=new JLabel(icon);
		chessPieces[10].setBounds(138, 569, 55, 55);
		chessPieces[10].setName("相2");
		chessPieces[11]=new JLabel(icon);
		chessPieces[11].setBounds(366, 569, 55, 55);
		chessPieces[11].setName("相2");
		
		icon=new ImageIcon("黑仕.png");
		chessPieces[12]=new JLabel(icon);
		chessPieces[12].setBounds(195, 56, 55, 55);
		chessPieces[12].setName("仕1");
		chessPieces[13]=new JLabel(icon);
		chessPieces[13].setBounds(309, 56, 55, 55);
		chessPieces[13].setName("仕1");
		
		icon=new ImageIcon("红仕.png");
		chessPieces[14]=new JLabel(icon);
		chessPieces[14].setBounds(195, 569, 55, 55);
		chessPieces[14].setName("仕2");
		chessPieces[15]=new JLabel(icon);
		chessPieces[15].setBounds(309, 569, 55, 55);
		chessPieces[15].setName("仕2");
		
		icon=new ImageIcon("黑兵.png");
		chessPieces[16]=new JLabel(icon);
		chessPieces[16].setBounds(24, 227, 55, 55);
		chessPieces[16].setName("兵1"+16);
		chessPieces[17]=new JLabel(icon);
		chessPieces[17].setBounds(138, 227, 55, 55);
		chessPieces[17].setName("兵1"+17);
		chessPieces[18]=new JLabel(icon);
		chessPieces[18].setBounds(252, 227, 55, 55);
		chessPieces[18].setName("兵1"+18);
		chessPieces[19]=new JLabel(icon);
		chessPieces[19].setBounds(366, 227, 55, 55);
		chessPieces[19].setName("兵1"+19);
		chessPieces[20]=new JLabel(icon);
		chessPieces[20].setBounds(480, 227, 55, 55);
		chessPieces[20].setName("兵1"+20);
		
		icon=new ImageIcon("红兵.png");
		chessPieces[21]=new JLabel(icon);
		chessPieces[21].setBounds(24, 398, 55, 55);
		chessPieces[21].setName("兵2"+21);
		chessPieces[22]=new JLabel(icon);
		chessPieces[22].setBounds(138, 398, 55, 55);
		chessPieces[22].setName("兵2"+22);
		chessPieces[23]=new JLabel(icon);
		chessPieces[23].setBounds(252, 398, 55, 55);
		chessPieces[23].setName("兵2"+23);
		chessPieces[24]=new JLabel(icon);
		chessPieces[24].setBounds(366, 398, 55, 55);
		chessPieces[24].setName("兵2"+24);
		chessPieces[25]=new JLabel(icon);
		chessPieces[25].setBounds(480, 398, 55, 55);
		chessPieces[25].setName("兵2"+25);
		
		icon=new ImageIcon("黑炮.png");
		chessPieces[26]=new JLabel(icon);
		chessPieces[26].setBounds(81, 170, 55, 55);
		chessPieces[26].setName("炮1");
		chessPieces[27]=new JLabel(icon);
		chessPieces[27].setBounds(423, 170, 55, 55);
		chessPieces[27].setName("炮1");
		
		icon=new ImageIcon("红炮.png");
		chessPieces[28]=new JLabel(icon);
		chessPieces[28].setBounds(81, 455, 55, 55);
		chessPieces[28].setName("炮2");
		chessPieces[29]=new JLabel(icon);
		chessPieces[29].setBounds(423, 455, 55, 55);
		chessPieces[29].setName("炮2");
		
		icon=new ImageIcon("黑帅.png");
		chessPieces[30]=new JLabel(icon);
		chessPieces[30].setBounds(252, 56, 55, 55);
		chessPieces[30].setName("帅1");
		
		icon=new ImageIcon("红帅.png");
		chessPieces[31]=new JLabel(icon);
		chessPieces[31].setBounds(252, 569, 55, 55);
		chessPieces[31].setName("帅2");
		
    	for(int i=0;i<32;i++)
    	{
    		con.add(chessPieces[i]);
    		chessPieces[i].addMouseListener(this);
    	}
    	con.add(chessBoard=new JLabel(new ImageIcon("棋盘.png")));
    	chessBoard.setBounds(0, 30, 560, 620);
    	chessBoard.addMouseListener(this);
    	this.setResizable(false);
    	this.setSize(560,900);
    	this.show(); 
    }

	public void run()
	{
		while(true)
		{
			if(blink)
			{
				chessPieces[respose].setVisible(false);
				try
				{
					thread.sleep(200);
				}
				catch(Exception e){}
				chessPieces[respose].setVisible(true);
			}
			else
			{
				text.setVisible(false);
				try
				{
					thread.sleep(250);
				}
				catch(Exception e){}
				text.setVisible(true);
			}
			try
			{
				thread.sleep(350);
			}
			catch(Exception e){}
		}
	}
	

	public void mouseClicked(MouseEvent e)
	{
		int x=0,y=0,i;
		if(thread==null)
		{
			thread=new Thread(this);
			thread.start();
		}
		if(e.getSource().equals(chessBoard))
		{
			if(flag==2&&chessPieces[respose].getName().charAt(1)=='2')
			{
				x=chessPieces[respose].getX();
				y=chessPieces[respose].getY();
				if(respose>15&&respose<26)
				{
					rule.armsRule(respose,chessPieces[respose],e,vec,chessPieces);
				}
				else if(respose>25&&respose<30)
				{
					rule.cannonRule(chessPieces[respose],chessPieces,e,vec,respose,chessPieces);
				}
				else if(respose>=0&&respose<4)
				{
					rule.cannonRule(chessPieces[respose],chessPieces,e,vec,respose,chessPieces);
				}
				else if(respose>3&&respose<8)
				{
					rule.horseRule(chessPieces[respose],chessPieces,e,vec,respose,chessPieces);
				}
				else if(respose>7&&respose<12)
				{
					rule.elephantRule(respose,chessPieces[respose],chessPieces,e,vec,chessPieces);
				}
				else if(respose>11&&respose<16)
				{
					rule.chapRule(respose,chessPieces[respose],chessPieces,e,vec,chessPieces);
				}
				else if(respose==30||respose==31)
				{
					rule.willRule(respose,chessPieces[respose],chessPieces,e,vec,chessPieces);
				}
				if(x==chessPieces[respose].getX()&&y==chessPieces[respose].getY())
				{
					text.setText("red,can't static");
					flag=2;
				}	
			}
			blink=false;
		}
		else
		{
			if(!blink)
			{
				for(i=0;i<32;i++)
				{
					if(e.getSource().equals(chessPieces[i]))
					{
						respose=i;
						blink=true;
						break;
					}
				}
			}
			else if(blink)
			{
				blink=false;
				for(i=0;i<32;i++)
				{
					if(e.getSource().equals(chessPieces[i]))
					{
						if(flag==2&&chessPieces[respose].getName().charAt(1)=='2')
						{
							x=chessPieces[respose].getX();
							y=chessPieces[respose].getY();
							
							
							if(respose>15&&respose<26)
							{
								rule.armsRule(chessPieces[respose],chessPieces[i],vec,respose,i,chessPieces);
							}
							else if(respose>25&&respose<30)
							{
								rule.cannonRule(0,i,chessPieces[respose],chessPieces[i],chessPieces,vec,respose,e,chessPieces);
							}
							else if(respose>=0&&respose<4)
							{
								rule.cannonRule(1,i,chessPieces[respose],chessPieces[i],chessPieces,vec,respose,e,chessPieces);
							}
							else if(respose>3&&respose<8)
							{
								rule.horseRule(chessPieces[respose],chessPieces[i],chessPieces,e,vec,respose,i,chessPieces);
							}
							else if(respose>7&&respose<12)
							{
								rule.elephantRule(chessPieces[respose],chessPieces[i],chessPieces,vec,respose,i,chessPieces);
							}
							else if(respose>11&&respose<16)
							{
								rule.chapRule(respose,chessPieces[respose],chessPieces[i],chessPieces,vec,i,chessPieces);
							}
							else if(respose==30||respose==31)
							{
								rule.willRule(respose,chessPieces[respose],chessPieces[i],chessPieces,vec,i,chessPieces);
								chessPieces[respose].setVisible(true);
							}
							if(x==chessPieces[respose].getX()&&y==chessPieces[respose].getY())
							{
								text.setText("red,can't static");
								flag=2;
								break;
							}
						}
				    }
			   }
			   if(!chessPieces[31].isVisible())
			   {
				   flag=3;
				   text.setText("black win");
			   }
			   else if(!chessPieces[30].isVisible())
			   {
				   flag=3;
				   text.setText("red win");
			   }
		    }
	    }
	}
	

	
	public void actionPerformed(ActionEvent event)
	{		
		int i;
		if(event.getSource().equals(anew))
		{
			chessPieces[0].setBounds(24, 56, 55, 55);
			chessPieces[1].setBounds(480, 56, 55, 55);
			chessPieces[2].setBounds(24, 569, 55, 55);
			chessPieces[3].setBounds(480, 569, 55, 55);
			chessPieces[4].setBounds(81, 56, 55, 55);
			chessPieces[5].setBounds(423, 56, 55, 55);
			chessPieces[6].setBounds(81, 569, 55, 55);
			chessPieces[7].setBounds(423, 569, 55, 55);
			chessPieces[8].setBounds(138, 56, 55, 55);
			chessPieces[9].setBounds(366, 56, 55, 55);
			chessPieces[10].setBounds(138, 569, 55, 55);
			chessPieces[11].setBounds(366, 569, 55, 55);
			chessPieces[12].setBounds(195, 56, 55, 55);
			chessPieces[13].setBounds(309, 56, 55, 55);
			chessPieces[14].setBounds(195, 569, 55, 55);
			chessPieces[15].setBounds(309, 569, 55, 55);
			chessPieces[16].setBounds(24, 227, 55, 55);
			chessPieces[17].setBounds(138, 227, 55, 55);
			chessPieces[18].setBounds(252, 227, 55, 55);
			chessPieces[19].setBounds(366, 227, 55, 55);
			chessPieces[20].setBounds(480, 227, 55, 55);
			chessPieces[21].setBounds(24, 398, 55, 55);
			chessPieces[22].setBounds(138, 398, 55, 55);
			chessPieces[23].setBounds(252, 398, 55, 55);
			chessPieces[24].setBounds(366, 398, 55, 55);
			chessPieces[25].setBounds(480, 398, 55, 55);
			chessPieces[26].setBounds(81, 170, 55, 55);
			chessPieces[27].setBounds(423, 170, 55, 55);
			chessPieces[28].setBounds(81, 455, 55, 55);
			chessPieces[29].setBounds(423, 455, 55, 55);
			chessPieces[30].setBounds(252, 56, 55, 55);
			chessPieces[31].setBounds(252, 569, 55, 55);
			
			flag=2;
			text.setText("red");
			for(i=0;i<32;i++)
			{
				chessPieces[i].setVisible(true);
			}
			vec.clear();
		}
		else if(event.getSource().equals(regret))
		{
			try
			{
				String str=(String)vec.get(vec.size()-4);
				int x=Integer.parseInt((String)vec.get(vec.size()-3));
				int y=Integer.parseInt((String)vec.get(vec.size()-2));
				int index=Integer.parseInt((String)vec.get(vec.size()-1));
				chessPieces[index].setVisible(true);
				chessPieces[index].setBounds(x,y,55,55);
				if(chessPieces[index].getName().charAt(1)=='2')
				{
					text.setText("red");
					flag=2;
				}
				else
				{
					text.setText("black");
					flag=1;
				}
				vec.remove(vec.size()-4);
			    vec.remove(vec.size()-3);
				vec.remove(vec.size()-2);
				vec.remove(vec.size()-1);
				blink=false;
			}
			catch(Exception e){}
		}
		else if(event.getSource().equals(exit))
		{
			
			System.exit(0);
		}
		else if(event.getSource().equals(enter))
		{
			String str=null;
			str=metext.getText();
			metext.setText("");
			chattext.setText("me:"+str);
		}
	}
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}


