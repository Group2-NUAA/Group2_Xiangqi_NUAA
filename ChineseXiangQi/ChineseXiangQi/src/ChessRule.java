import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JLabel;

public class ChessRule {
	private final int MoveAble=1;
	private final int MoveLess=0;
	public void armsRule(int respose, JLabel play, MouseEvent me,Vector Var) {
		  if (respose < 21)
		  {
		   if ((me.getY()-play.getY()) > 27 && (me.getY()-play.getY()) < 86 && (me.getX()-play.getX()) < 55 && (me.getX()-play.getX()) > 0)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(play.getX(),play.getY()+57,55,55);
		   }
		   else if (play.getY() > 284 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112)
		   { play.setBounds(play.getX()+57,play.getY(),55,55); }
		   else if (play.getY() > 284 && (play.getX() - me.getX()) >= 2 && (play.getX() - me.getX()) <=58)
		   {play.setBounds(play.getX()-57,play.getY(),55,55);}  
		  }
		  else
		 {
		   Var.add(String.valueOf(play.isVisible()));
		   Var.add(String.valueOf(play.getX()));
		   Var.add(String.valueOf(play.getY()));
		   Var.add(String.valueOf(respose));
		  
		   if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >27 && play.getY()-me.getY() < 86) 
		   {play.setBounds(play.getX(),play.getY()-57,55,55);}
		   
		   else if (play.getY() <= 341 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112)
		   {play.setBounds(play.getX()+57,play.getY(),55,55);} 
		   
		  
		   else if (play.getY() <= 341 && (play.getX() - me.getX()) >= 3 && (play.getX() - me.getX()) <=58)
		   {play.setBounds(play.getX()-57,play.getY(),55,55);}
		  }
	}
	
	public void cannonRule(JLabel play, JLabel  playQ[], MouseEvent me,Vector Var,int respose) {
		  int Count = 0; 
		  if (play.getX() - me.getX() <= 0 && play.getX() - me.getX() >= -55)
		  {
			  for (int i=56;i<=571;i+=57)
			  {
				  if (i - me.getY() >= -27 && i - me.getY() <= 27)
				  {
					  for (int j=0;j<32;j++)
					  {
						  if (playQ[j].getX() - play.getX() >= -27 && playQ[j].getX() - play.getX() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible())
						  {
							  for (int k=play.getY()+57;k<i;k+=57)
							  {
								  if (playQ[j].getY() < i && playQ[j].getY() > play.getY())
								  {Count++;break;}
							  }
							  for (int k=i+57;k<play.getY();k+=57)
							  {
								  if (playQ[j].getY() < play.getY() && playQ[j].getY() > i)
								  {Count++;break;}
							  }
						   }
					  }
					  if (Count == 0)
					  {
						  Var.add(String.valueOf(play.isVisible()));
						  Var.add(String.valueOf(play.getX()));
						  Var.add(String.valueOf(play.getY()));
						  Var.add(String.valueOf(respose));
						  play.setBounds(play.getX(),i,55,55);
						  break;
					  }
				} 
			}
		}
		  else if (play.getY() - me.getY() >=-27 && play.getY() - me.getY() <= 27)
		  {
			  for (int i=24;i<=480;i+=57)
			  {
				  if (i - me.getX() >= -55 && i-me.getX() <= 0)
				  {
					  for (int j=0;j<32;j++)
					  {
						  if (playQ[j].getY() - play.getY() >= -27 && playQ[j].getY() - play.getY() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible())
						  {
							  for (int k=play.getX()+57;k<i;k+=57)
							  {
								  if (playQ[j].getX() < i && playQ[j].getX() > play.getX())
								  {Count++;break;}
							  }
							  for (int k=i+57;k<play.getX();k+=57)
							  {
								  if (playQ[j].getX() < play.getX() && playQ[j].getX() > i)
								  {Count++;break;}
							  }
						  }
					  }
				  }
				  if (Count == 0)
				  {
					  Var.add(String.valueOf(play.isVisible()));
					  Var.add(String.valueOf(play.getX()));
					  Var.add(String.valueOf(play.getY()));
					  Var.add(String.valueOf(respose));
					  play.setBounds(i,play.getY(),55,55);
					  break;
				  }
			  }
		   }
	}
		 
	public void horseRule(JLabel play, JLabel playQ[], MouseEvent me,Vector Var,int respose) {
	    	int Ex=0,Ey=0,Move=0; 
	    	if (play.getX() - me.getX() >= 2 && play.getX() - me.getX() <= 57 && play.getY() - me.getY() >= 87 && play.getY() - me.getY() <= 141)//上左
	    		{
	    		for (int i=56;i<=571;i+=57)
	    		    {
	    			if (i - me.getY() >= -27 && i - me.getY() <= 27)
	    				{Ey = i;break;}
	    			}
	    		for (int i=24;i<=480;i+=57)
	    			{
	    			if (i - me.getX() >= -55 && i-me.getX() <= 0)
	    				{Ex = i;break;}
	    			}
	    		for (int i=0;i<32;i++) 
	    			{
	    			if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0  && play.getY() - playQ[i].getY() == 57 )
	    			{Move = MoveAble;break;}
	    			}
	    		if (Move == MoveLess) 
	    		    {
	    			Var.add(String.valueOf(play.isVisible()));
	    			Var.add(String.valueOf(play.getX()));
	    			Var.add(String.valueOf(play.getY()));
	    			Var.add(String.valueOf(respose));
	    			play.setBounds(Ex,Ey,55,55);
	    			}
	    		}
	    	
	  else if (play.getY()-me.getY()>=27 && play.getY()-me.getY()<=86 && play.getX()-me.getX()>=70 &&play.getX()-me.getX()<=130)//左上
	{
	   for (int i=56;i<=571;i+=57)
		   {
		   if (i - me.getY() >= -27 && i - me.getY() <= 27)
		   {Ey = i;}
		   }
	   
	   for (int i=24;i<=480;i+=57)
		   {
		   if (i - me.getX() >= -55 && i-me.getX() <= 0)
		   {Ex = i;}
		   }
	   for (int i=0;i<32;i++)
	   {
		   if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57 )
		   {Move = MoveAble;break;}
	   }
	   if (Move == MoveLess)
	   {
	    Var.add(String.valueOf(play.isVisible()));
	    Var.add(String.valueOf(play.getX()));
	    Var.add(String.valueOf(play.getY()));
	    Var.add(String.valueOf(respose));
	    play.setBounds(Ex,Ey,55,55);
	   }
	}
	  
	  else if (me.getY()-play.getY()>=87 && me.getY()-play.getY()<=141 && me.getX()-play.getX()<=87 && me.getX()-play.getX()>=2)//下右
	{ 
	   for (int i=56;i<=571;i+=57)
		   {
		   if (i - me.getY() >= -27 && i - me.getY() <= 27)
		   {Ey = i;}
		   } 
	   for (int i=24;i<=480;i+=57)
		   {
		   if (i - me.getX() >= -55 && i-me.getX() <= 0)
		   {Ex = i;}
		   } 
	   for (int i=0;i<32;i++)
		   {
		   if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0  && playQ[i].getY() - play.getY() == 57 )
		   {Move = MoveAble;break;}
		   }
	   if (Move == MoveLess){
	    Var.add(String.valueOf(play.isVisible()));
	    Var.add(String.valueOf(play.getX()));
	    Var.add(String.valueOf(play.getY()));
	    Var.add(String.valueOf(respose));
	    play.setBounds(Ex,Ey,55,55);
	   }
}
	  
	  else if (play.getY()-me.getY()>=87&&play.getY()-me.getY()<=141&&me.getX()-play.getX()<=87&&me.getX()-play.getX()>=30 )//上右
		  {
		  for (int i=56;i<=571;i+=57)
			  {
			  if (i - me.getY() >= -27 && i - me.getY() <= 27)
			  {Ey = i;break;}
			  }
	   for (int i=24;i<=480;i+=57)
		   {
		   if (i - me.getX() >= -55 && i-me.getX() <= 0)
		   {Ex = i;break;}
		   }		   
	   for (int i=0;i<32;i++)
	       {
		   System.out.println(i+"playQ[i].getX()="+playQ[i].getX());
		   System.out.println("play.getX()="+play.getX());
		   if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57 )
		   {Move = MoveAble;System.out.println("play.getY()="+play.getY());System.out.println("playQ[i].getY()="+playQ[i].getY());break;}
		   }
	   if (Move == MoveLess)
		   {
		   Var.add(String.valueOf(play.isVisible()));
		   Var.add(String.valueOf(play.getX())); 
		   Var.add(String.valueOf(play.getY()));
		   Var.add(String.valueOf(respose));
		   play.setBounds(Ex,Ey,55,55);
		   }
	   }
	  
	  
	  else if (me.getY()-play.getY()>=87 && me.getY()-play.getY()<=141 && play.getX()-me.getX()<=87 && play.getX()-me.getX()>=10 )//下左
		  {
		  for (int i=56;i<=571;i+=57)
			  {
			  if (i - me.getY() >= -27 && i - me.getY() <= 27)
			  {Ey = i; break;}
			  }
		  
	   for (int i=24;i<=480;i+=57)
		   {
		   if (i - me.getX() >= -55 && i-me.getX() <= 0)
		   {Ex = i;break;}
		   }
	   for (int i=0;i<32;i++)
		   {
		   if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57 )
		   {Move = MoveAble;break;}
		   }
	   if (Move == MoveLess)
		   {
		   Var.add(String.valueOf(play.isVisible()));
		   Var.add(String.valueOf(play.getX()));
		   Var.add(String.valueOf(play.getY()));
		   Var.add(String.valueOf(respose));
		   play.setBounds(Ex,Ey,55,55);
		   }
	   }
	  else if (play.getY()-me.getY()>=30 && play.getY()-me.getY()<=87 && me.getX()-play.getX()<=141 && me.getX()-play.getX()>=87)//右上
		  {
		  for (int i=56;i<=571;i+=57)
			  {
			  if (i - me.getY() >= -27 && i - me.getY() <= 27)
			  {Ey = i;}
			  for (int j=24;i<=480;i+=57)
				  {
				  if (i - me.getX() >= -55 && i-me.getX() <= 0){}
				  Ex = i;
				  }
			  }
		  for (int i=0;i<32;i++) 
			  {
			  if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57 )
			  {Move = MoveAble;break;}
			  }
	   if (Move == MoveLess)
	   {
	    Var.add(String.valueOf(play.isVisible()));
	    Var.add(String.valueOf(play.getX()));
	    Var.add(String.valueOf(play.getY()));
	    Var.add(String.valueOf(respose));
	    play.setBounds(Ex,Ey,55,55);
	   }
	   }
	 
	  else if (me.getY()-play.getY()>=30 && me.getY()-play.getY()<=87 && me.getX()-play.getX()<=141 && me.getX()-play.getX()>=87) //右下
		  {
		  for (int i=56;i<=571;i+=57)
			  {
			  if (i - me.getY() >= -27 && i - me.getY() <= 27)
			  {Ey = i;}
			  }
		  for (int i=24;i<=480;i+=57)
			  {
			  if (i - me.getX() >= -55 && i-me.getX() <= 0)
			  {Ex = i;}
			  }
		  for(int i=0;i<32;i++)
			  {
			  if(playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57 )
			  {Move = MoveAble;break;}
			  }
	   if (Move == MoveLess)
	   {
	    Var.add(String.valueOf(play.isVisible()));
	    Var.add(String.valueOf(play.getX()));
	    Var.add(String.valueOf(play.getY()));
	    Var.add(String.valueOf(respose));
	    play.setBounds(Ex,Ey,55,55);
	   }
	   }
	  
	  else if (me.getY() - play.getY() >= 30 && me.getY() - play.getY() <= 87 && play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 )//左下
		  {
		  for (int i=56;i<=571;i+=57)
			  {
			  if (i - me.getY() >= -27 && i - me.getY() <= 27)
			  {Ey = i;}
			  }
		  for (int i=24;i<=480;i+=57)
			  {
			  if (i - me.getX() >= -55 && i-me.getX() <= 0)
			  {Ex = i;}
			  }
	   for (int i=0;i<32;i++)
		   {
		   if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57 )
		   {Move = MoveAble;break;}
		   }
	   if (Move == MoveLess){
	    Var.add(String.valueOf(play.isVisible()));
	    Var.add(String.valueOf(play.getX()));
	    Var.add(String.valueOf(play.getY()));
	    Var.add(String.valueOf(respose));
	    play.setBounds(Ex,Ey,55,55);
	   }
	  }
	 }
	
	public void elephantRule(int respose,JLabel play,JLabel playQ[],MouseEvent me,Vector Var) {
		  int Ex=0,Ey=0,Move=0;
		 
		  if (play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 && play.getY() - me.getY() <= 141 && play.getY() - me.getY() >= 87) //上左
			  {
			  for (int i=56;i<=571;i+=57)
				  {
				  if (i - me.getY() >= -27 && i - me.getY() <= 27)
				  {Ey = i;break;} 
				  }
			  for (int i=24;i<=480;i+=57)
				  {
				  if (i - me.getX() >= -27 && i-me.getX() <= 27)
				  {Ex = i;break;}
				  }
		   for (int i=0;i<32;i++)
			   {
			   if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == 57)
			   {Move++;break;}
			   }   
		   if (Move == MoveLess&& Ey >= 341 && respose > 9)
		   {
			Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    System.out.println("Ex="+Ex);
		    System.out.println("Ey="+Ey);
		    play.setBounds(Ex,Ey,55,55);
		   }
		   else if (Move == MoveLess&& Ey <= 284 && respose < 10)
		   {
			   
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));    
		    play.setBounds(Ex,Ey,55,55); 
		   }
		  }
		  
		  else if (play.getY() - me.getY() <= 141 && play.getY() - me.getY() >= 87 &&  me.getX() - play.getX() >= 87 && me.getX() - play.getX() <= 141)
		{
			  for (int i=56;i<=571;i+=57)
			  {
				  if (i - me.getY() >= -27 && i - me.getY() <= 27)
				  {Ey = i;break;}
			  }
			  for (int i=24;i<=480;i+=57)
			  {
				  if (i - me.getX() >= -27 && i-me.getX() <= 27)
				  {Ex = i;break;}
			  }
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() &&  playQ[i].getX() - play.getX() == 57 && play.getY() - playQ[i].getY() == 57)
				  {Move++;break;}
			  }
			  
		   if (Move == MoveLess&& Ey >= 341 && respose > 9) 
			{
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(Ex,Ey,55,55);
		   }
		   else if (Move == MoveLess&& Ey <= 284 && respose < 10)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(Ex,Ey,55,55);
		   }
		} 
		    
		  else if (play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 && me.getY() - play.getY() <= 141 && me.getY() - play.getY() >= 87)//下左
		{
		   for (int i=56;i<=571;i+=57)
		   {
			   if (i - me.getY() >= -27 && i - me.getY() <= 27)
			   {Ey = i;break;}
		   }
		   for (int i=24;i<=480;i+=57)
		   {
		    if (i - me.getX() >= -27 && i-me.getX() <= 27)
		    {Ex = i;break;}
		   }
		   for (int i=0;i<32;i++)
		   {
		    if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == -57)
		    {Move++;break;}
		   }   
		   
		   if (Move == MoveLess&& Ey >= 341 && respose > 9)
		{
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));  
		    play.setBounds(Ex,Ey,55,55);
		}
		   
		   else if (Move == MoveLess&& Ey <= 284 && respose < 10)
		{
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(Ex,Ey,55,55);
		}
	}
		  else if (me.getX() - play.getX() >= 87 &&  me.getX() - play.getX() <= 141 && me.getY() - play.getY() >= 87 && me.getY() - play.getY() <= 141)
		{
		   for (int i=56;i<=571;i+=57)
		   {
			   if (i - me.getY() >= -27 && i - me.getY() <= 27)
			   {Ey = i;}
		   }
		   for (int i=24;i<=480;i+=57)
		   {
			   if (i - me.getX() >= -27 && i-me.getX() <= 27)
			   {Ex = i;}
		   }
		   for (int i=0;i<32;i++)
		   {
			   if (playQ[i].isVisible() && playQ[i].getX() - play.getX() == 57 && playQ[i].getY() - play.getY() == 57)
			   {Move = 1;break;}
		   }
		   if (Move == MoveLess&& Ey >= 341 && respose > 9)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(Ex,Ey,55,55);
		   }
		   
		   else if (Move == MoveLess&& Ey <= 284 && respose < 10)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));         
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(Ex,Ey,55,55);
		   }
		}
		  
   }

	public void chapRule(int respose,JLabel play,JLabel playQ[],MouseEvent me,Vector Var){
	  if (me.getX() - play.getX() >= 29 && me.getX() - play.getX() <= 114 && play.getY() - me.getY() >= 25 && play.getY() - me.getY() <= 90)
		  {
		  if (respose < 14 && (play.getX()+57) >= 195 && (play.getX()+57) <= 309 && (play.getY()-57) <= 170)
		  {
			  Var.add(String.valueOf(play.isVisible()));
			  Var.add(String.valueOf(play.getX()));
			  Var.add(String.valueOf(play.getY()));
			  Var.add(String.valueOf(respose));
			  play.setBounds(play.getX()+57,play.getY()-57,55,55);
		  }  
		  else if (respose > 13 && (play.getY()-57) >= 455 && (play.getX()+57)  >= 195 && (play.getX()+57) <= 309)
		  {
			  Var.add(String.valueOf(play.isVisible()));
			  Var.add(String.valueOf(play.getX()));
			  Var.add(String.valueOf(play.getY()));
			  Var.add(String.valueOf(respose));
			  play.setBounds(play.getX()+57,play.getY()-57,55,55);
		  } 
		  } 
	  
	  else if (play.getX() - me.getX() <= 114 && play.getX() - me.getX() >= 20 && me.getY() - play.getY() >= 2 && me.getY() - play.getY() <= 87)
		  {
		  if (respose < 14 && (play.getX()-57) >= 195 && (play.getX()-57) <= 309 && (play.getY()+57) <= 170 )
		  {
			  Var.add(String.valueOf(play.isVisible()));
			  Var.add(String.valueOf(play.getX()));
			  Var.add(String.valueOf(play.getY()));
			  Var.add(String.valueOf(respose));
			  play.setBounds(play.getX()-57,play.getY()+57,55,55);
			  }
		  else if (respose > 13 && (play.getY()+57) >= 455 && (play.getX()-57)  >= 195 && (play.getX()-57) <= 309)
		  {
			  Var.add(String.valueOf(play.isVisible()));
			  Var.add(String.valueOf(play.getX()));
			  Var.add(String.valueOf(play.getY()));
			  Var.add(String.valueOf(respose));
			  play.setBounds(play.getX()-57,play.getY()+57,55,55);
		  }
		  }
	  
	  else if (me.getX() - play.getX() >= 27 && me.getX() - play.getX() <= 114 && me.getY() - play.getY() >= 2 && me.getY() - play.getY() <= 87)
		  {
		  if (respose < 14 && (play.getX()+57) >= 195 && (play.getX()+57) <= 309 && (play.getY()+57) <= 170)
		  {
			  Var.add(String.valueOf(play.isVisible()));
			  Var.add(String.valueOf(play.getX()));
			  Var.add(String.valueOf(play.getY()));
			  Var.add(String.valueOf(respose));
			  play.setBounds(play.getX()+57,play.getY()+57,55,55);
		  }
		  else if (respose > 13 &&(play.getY()+57) >= 455 && (play.getX()+57)  >= 195 && (play.getX()+57) <= 309)
		  {
			  Var.add(String.valueOf(play.isVisible()));
			  Var.add(String.valueOf(play.getX()));
			  Var.add(String.valueOf(play.getY()));
			  Var.add(String.valueOf(respose));
			  play.setBounds(play.getX()+57,play.getY()+57,55,55);
		  }
		  } 
	  }
	
    public void willRule(int respose,JLabel play,JLabel playQ[],MouseEvent me,Vector Var){
		  
		  if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >=2 && play.getY()-me.getY() <= 87)
		{
			  if (respose == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170)
			  {
				  Var.add(String.valueOf(play.isVisible()));
				  Var.add(String.valueOf(play.getX()));
				  Var.add(String.valueOf(play.getY()));
				  Var.add(String.valueOf(respose));
				  play.setBounds(play.getX(),play.getY()-57,55,55); 
			  } 
			  else if (respose == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359)
			  {
				  Var.add(String.valueOf(play.isVisible()));
				  Var.add(String.valueOf(play.getX()));
				  Var.add(String.valueOf(play.getY()));
				  Var.add(String.valueOf(respose));
				  play.setBounds(play.getX(),play.getY()-57,55,55);
			  }
		}
		  else if (play.getX() - me.getX() >= 2 && play.getX() - me.getX() <= 57 && me.getY() - play.getY() <= 27 && me.getY() - play.getY() >= -27)
		{
		   if (respose == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(play.getX()-57,play.getY(),55,55);
		   }
		   else if (respose == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(play.getX()-57,play.getY(),55,55);
		   }
		} 
		  else if (me.getX() - play.getX() >= 57 && me.getX() - play.getX() <= 112 && me.getY() - play.getY() <= 27 && me.getY() - play.getY() >= -27)
		{
			  if (respose == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170)
			  {
				  Var.add(String.valueOf(play.isVisible()));
				  Var.add(String.valueOf(play.getX()));
				  Var.add(String.valueOf(play.getY()));
				  Var.add(String.valueOf(respose));
				  play.setBounds(play.getX()+57,play.getY(),55,55); 
			  } 
			  else if (respose == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359)
			  {
				  Var.add(String.valueOf(play.isVisible()));
				  Var.add(String.valueOf(play.getX())); 
				  Var.add(String.valueOf(play.getY()));
				  Var.add(String.valueOf(respose));
				  play.setBounds(play.getX()+57,play.getY(),55,55);
			  }
	    } 
		  else if (me.getX() - play.getX() >= 0 && me.getX() - play.getX() <= 55 && me.getY() - play.getY() <= 87 && me.getY() - play.getY() >= 27) 
		{
		   if (respose == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(play.getX(),play.getY()+57,55,55);
		   }
		   else if (respose == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359)
		   {
		    Var.add(String.valueOf(play.isVisible()));
		    Var.add(String.valueOf(play.getX()));
		    Var.add(String.valueOf(play.getY()));
		    Var.add(String.valueOf(respose));
		    play.setBounds(play.getX(),play.getY()+57,55,55);
		   }
	   }
		  
	}
	
		 public void armsRule(JLabel play1,JLabel play2,Vector Var,int respose, int i) {
		  if ((play2.getX()-play1.getX())<=112 && (play2.getX()-play1.getX())>=57 && (play1.getY()-play2.getY())<22 && (play1.getY()-play2.getY())>-22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1))
		  {
		   if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1))
		   {
			play2.setVisible(false);		   
		    play1.setBounds(play2.getX(),play2.getY(),55,55); 
		   }

		   else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1))
		   {
		    play2.setVisible(false);
		    play1.setBounds(play2.getX(),play2.getY(),55,55);    
		   }
		  }

		  else if ((play1.getX() - play2.getX()) <= 112 && (play1.getX() - play2.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1))
		  {
			  if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)) 
			  {play2.setVisible(false);play1.setBounds(play2.getX(),play2.getY(),55,55); }

		          else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1))
		          {play2.setVisible(false);play1.setBounds(play2.getX(),play2.getY(),55,55);    }
		  }
		  else if (play1.getX() - play2.getX() >= -22 && play1.getX() - play2.getX() <= 22 && play1.getY() - play2.getY() >= -112 && play1.getY() - play2.getY() <= 112)
		  {
		       if (play1.getName().charAt(1) == '1' && play1.getY() < play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1))
		       {play2.setVisible(false);play1.setBounds(play2.getX(),play2.getY(),55,55);}
	
		         else if (play1.getName().charAt(1) == '2' && play1.getY() > play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1))
		         {play2.setVisible(false);play1.setBounds(play2.getX(),play2.getY(),55,55);}   
		  }

		  Var.add(String.valueOf(play1.isVisible()));
		  Var.add(String.valueOf(play1.getX()));
		  Var.add(String.valueOf(play1.getY()));
		  Var.add(String.valueOf(respose));
		  Var.add(String.valueOf(play2.isVisible()));
		  Var.add(String.valueOf(play2.getX()));
		  Var.add(String.valueOf(play2.getY()));
		  Var.add(String.valueOf(i));
		  
		}

		 public void cannonRule(int Chess,int i, JLabel  play, JLabel playTake, JLabel playQ[],Vector Var,int respose,MouseEvent me) 
		 {
			  int Count = 0;
			  for (int j=0;j<32;j++){
			   if (playQ[j].getX() - play.getX() >= -27 && playQ[j].getX() - play.getX() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()) 
				{
				   for (int k=play.getY()+57;k<playTake.getY();k+=57)
				   {  
			           if (playQ[j].getY() < playTake.getY() && playQ[j].getY() > play.getY())
			           {Count++;break;}
			       }
				   for (int k=playTake.getY();k<play.getY();k+=57)
				   { 
					   if (playQ[j].getY() < play.getY() && playQ[j].getY() > playTake.getY())
						   {Count++;break;}
				   }
				 } 
			   else if (playQ[j].getY() - play.getY() >= -10 && playQ[j].getY() - play.getY() <= 10 && playQ[j].getName()!=play.getName() && playQ[j].isVisible())
				{
				   for (int k=play.getX()+50;k<playTake.getX();k+=57)
				   {
					   if (playQ[j].getX() < playTake.getX() && playQ[j].getX() > play.getX())    
						   {Count++;break;}
				   }
			    
			    for (int k=playTake.getX();k<play.getX();k+=57)
			    	{
			    	   if (playQ[j].getX() < play.getX() && playQ[j].getX() > playTake.getX())
			    		{Count++; break;}
			    	}
			    }
			  }
			  if (Count == 1 && Chess == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)) 
		      {
			   Var.add(String.valueOf(play.isVisible()));
			   Var.add(String.valueOf(play.getX()));
			   Var.add(String.valueOf(play.getY()));
			   Var.add(String.valueOf(respose));
			   
			   Var.add(String.valueOf(playTake.isVisible()));
			   Var.add(String.valueOf(playTake.getX()));         
			   Var.add(String.valueOf(playTake.getY()));
			   Var.add(String.valueOf(i));
			   playTake.setVisible(false);
			   play.setBounds(playTake.getX(),playTake.getY(),55,55);
			  }
			  else if (Count ==0  && Chess == 1 && playTake.getName().charAt(1) != play.getName().charAt(1))
			  {			  
			   Var.add(String.valueOf(play.isVisible()));
			   Var.add(String.valueOf(play.getX()));         
			   Var.add(String.valueOf(play.getY()));
			   Var.add(String.valueOf(respose));
			   
			   Var.add(String.valueOf(playTake.isVisible()));
			   Var.add(String.valueOf(playTake.getX()));         
			   Var.add(String.valueOf(playTake.getY()));
			   Var.add(String.valueOf(i));
			   playTake.setVisible(false);
			   play.setBounds(playTake.getX(),playTake.getY(),55,55);
			  }
			 }
		 
		 public void horseRule(JLabel play,JLabel playTake ,JLabel playQ[],MouseEvent me,Vector Var,int respose,int s){
		  int Move=0;
		  boolean Chess=false;
		  if (play.getName().charAt(1)!=playTake.getName().charAt(1) && play.getX() - playTake.getX() == 57 && play.getY() - playTake.getY() == 114 )
			  {
			  for (int i=0;i<32;i++)
				  {
				  if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57)
				  {Move = MoveAble;break;}
				  }
			  Chess = true;
		  }
		  
		  else if (play.getY() - playTake.getY() == 114 && playTake.getX() - play.getX() == 57 )
			  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57)
				  {Move = MoveAble;break;}
			  }  
			  Chess = true;
			  }
		  
		  else if (play.getY() - playTake.getY() == 57 && play.getX() - playTake.getX() == 114 )
			  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57)
				  {Move = MoveAble;break;}
			  }
			  Chess = true;
			  }
		  
		  else if (playTake.getY() - play.getY() == 57 && play.getX() - playTake.getX() == 114 )
			  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57)
				  {Move = MoveAble;break;}
			  }
			  Chess = true;
			  }
		  
		  
		  else if (play.getY() - playTake.getY() == 57 && playTake.getX() - play.getX() == 114 )
			  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57)
				  {Move = MoveAble;break;}
			  } 
		   Chess = true;
		      }
		  
		  else if (playTake.getY() - play.getY() == 57  && playTake.getX() - play.getX() == 114 )
			  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57)
				  {Move = MoveAble;break;}
			  }
			  Chess = true;
			  }
		  
		  else if (playTake.getY() - play.getY() == 114 && play.getX() - playTake.getX() == 57 )
			  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == -57 )
				  {Move = MoveAble;break;}
			  }
		      Chess = true; 
		      }
		  
		  else if (playTake.getY() - play.getY() == 114 && playTake.getX() - play.getX() == 57)
			  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == -57 )
				  {Move = MoveAble;break;}
			  }
			  Chess = true;
			  }  
		  if (Chess && Move == MoveLess && playTake.getName().charAt(1) != play.getName().charAt(1)){
		   Var.add(String.valueOf(play.isVisible()));
		   Var.add(String.valueOf(play.getX()));
		   Var.add(String.valueOf(play.getY()));
		   Var.add(String.valueOf(respose));
		   
		   Var.add(String.valueOf(playTake.isVisible()));
		   Var.add(String.valueOf(playTake.getX()));
		   Var.add(String.valueOf(playTake.getY()));
		   Var.add(String.valueOf(s));   
		   
		   playTake.setVisible(false);
		   play.setBounds(playTake.getX(),playTake.getY(),55,55);
		  }
}
	 
		 public void elephantRule(JLabel play,JLabel playTake,JLabel playQ[],Vector Var,int respose,int s){
		  int Move=0;
		  boolean Chess=false;
		  
		  if (play.getX() - playTake.getX() >= 87 && play.getX() - playTake.getX() <= 141 && play.getY() - playTake.getY() >= 87 && play.getY() - playTake.getY() <= 141)
		   {
			  for (int i=0;i<32;i++)
				  {
				  if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == 57)
				  {Move++;break;}
				  }
		   Chess=true;
		   }
		  else if (play.getX() - playTake.getX() >= 87 && play.getX() - playTake.getX() <= 141 && playTake.getY() - play.getY() >= 87 && playTake.getY() - play.getY() <= 141)
		   {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == -57 )
				  {Move++;break;}
			  }
			  Chess=true;
		   }
		  
		  else if (playTake.getX() - play.getX() >= 87 && playTake.getX() - play.getX() <= 141 && playTake.getY() - play.getY() >= 87 && playTake.getY() - play.getY() <= 141)
		  {
			  for (int i=0;i<32;i++)
			  {
				  if (playQ[i].isVisible() && playQ[i].getX() - play.getX() == 57 && playQ[i].getY() - play.getY() == 57 )
				  {Move = 1; break;}
			  }  
			  Chess=true;
		  }
		  if (Chess && Move == MoveLess&& playTake.getName().charAt(1) != play.getName().charAt(1))
		  {
		   Var.add(String.valueOf(play.isVisible()));
		   Var.add(String.valueOf(play.getX()));
		   Var.add(String.valueOf(play.getY()));
		   Var.add(String.valueOf(respose));
		   
		   Var.add(String.valueOf(playTake.isVisible()));
		   Var.add(String.valueOf(playTake.getX()));
		   Var.add(String.valueOf(playTake.getY()));
		   Var.add(String.valueOf(s));
		   playTake.setVisible(false);
		   play.setBounds(playTake.getX(),playTake.getY(),55,55);
		  }
	}
		   
		 public void chapRule(int respose ,JLabel play,JLabel playTake,JLabel playQ[],Vector Var,int s)
		 {
		  boolean Chap = false;
		  
		  if (playTake.getX() - play.getX() >= 20 && playTake.getX() - play.getX() <= 114 && play.getY() - playTake.getY() >= 2 && play.getY() - playTake.getY() <= 87)
			  {
			  if (respose < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible())
			  {Chap = true;}
			  else if (respose > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible())
			  {Chap = true;}
			  }
		  
		  else if (play.getX() - playTake.getX() <= 114 && play.getX() - playTake.getX() >= 25 && play.getY() - playTake.getY() >= 2 && play.getY() - playTake.getY() <= 87)
			  {
			  if (respose < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible())
			  {Chap = true;}
			  else if (respose > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible())
			  {Chap = true;}
			  }

		  else if (play.getX() - playTake.getX() <= 114 && play.getX() - playTake.getX() >= 25 && playTake.getY() - play.getY() >= 2 && playTake.getY() - play.getY() <= 87) 
			  {
			  if (respose < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible())
			  {Chap = true;}
			  else if (respose > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible())
			  {Chap = true;}
			  }

		  else if (playTake.getX() - play.getX() >= 25 && playTake.getX() - play.getX() <= 114 && playTake.getY() - play.getY() >= 2 && playTake.getY() - play.getY() <= 87)
			  {
			  if (respose < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible())
			  {Chap = true;}
			  else if (respose > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible())
			  {Chap = true;}
			  }

		  if (Chap && playTake.getName().charAt(1) != play.getName().charAt(1))
		  {
		   Var.add(String.valueOf(play.isVisible()));
		   Var.add(String.valueOf(play.getX()));
		   Var.add(String.valueOf(play.getY()));
		   Var.add(String.valueOf(respose));
		   
		   Var.add(String.valueOf(playTake.isVisible()));
		   Var.add(String.valueOf(playTake.getX()));
		   Var.add(String.valueOf(playTake.getY()));
		   Var.add(String.valueOf(s));
		   
		   playTake.setVisible(false);
		   play.setBounds(playTake.getX(),playTake.getY(),55,55);
		  }
		  
		 }
		 	 
		 public void willRule(int respose ,JLabel play,JLabel playTake ,JLabel playQ[],Vector Var,int s){
			 boolean will = false;
		  if (play.getX() - playTake.getX() >= 0 && play.getX() - playTake.getX() <= 55 && play.getY() - playTake.getY() >= 27 && play.getY() - playTake.getY() <= 87 && playTake.isVisible()) 
		{
			  if (respose == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170)
			  {will = true;}
			  else if (respose == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309)
			  {will = true;}
		}
		  else if (play.getX() - playTake.getX() >= 2 && play.getX() - playTake.getX() <= 57 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= -27 && playTake.isVisible())
		{
			  if (respose == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170)
			  {will = true;}
			  else if (respose == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309)
			  {will = true;}
		}
		  else if (playTake.getX() - play.getX() >= 2 && playTake.getX() - play.getX() <= 57 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= -27 && playTake.isVisible())
		{
			  if (respose == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170)
			  {will = true;}
			  else if (respose == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309)
			  {will = true;}
		}
		  else if (playTake.getX() - play.getX() >= 0 && playTake.getX() - play.getX() <= 87 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= 40 && playTake.isVisible())
		{
		   if (respose == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170)
		   {will = true;}
		   else if (respose == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309)
		   {will = true;}
		}
		  if (playTake.getName().charAt(1) != play.getName().charAt(1) && will)
		  {
		   Var.add(String.valueOf(play.isVisible()));
		   Var.add(String.valueOf(play.getX()));
		   Var.add(String.valueOf(play.getY()));
		   Var.add(String.valueOf(respose));

		   Var.add(String.valueOf(playTake.isVisible()));
		   Var.add(String.valueOf(playTake.getX()));
		   Var.add(String.valueOf(playTake.getY()));
		   Var.add(String.valueOf(s));
		   playTake.setVisible(false);
		   play.setBounds(playTake.getX(),playTake.getY(),55,55);
		  }   
	}
	 
}
//规则类