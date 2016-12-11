import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class chooseframe extends JFrame implements ActionListener
{
	JButton pve;
	JButton pvp;
	JPanel choosepanel;
	
	chooseframe()
	{
		super("choose");
		pve=new JButton("pve");
		pvp=new JButton("pvp");
		pve.addActionListener(this);
		pvp.addActionListener(this);
		choosepanel=new JPanel();
		choosepanel.setLayout(new GridLayout(1,2));
		choosepanel.add(pve);
		choosepanel.add(pvp);
		add(choosepanel);
		this.setSize(300, 300);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(pve))
		{
			
		}
		if(e.getSource().equals(pvp))
		{
			new Login();
			this.setVisible(false);
		}
	}
	
	public static void main(String args[])
	{
	    new chooseframe();
	}
}
