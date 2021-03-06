import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
	JPanel accountPanel;
	JPanel passwordPanel;
	JPanel informationPanel;
	JPanel buttonPanel;
	JLabel accountLabel;
	JLabel passwordLabel;
	JLabel informationLabel;
	JTextField  account;
	JPasswordField password;
	
	JButton loginButton;
	JButton registerButton;
	
	JFrame choose;
	JButton pve;
	JButton pvp;
    JPanel choosepanel;
	
	 ChessUser user;
    
	Login()
	{
		super("Chinese XiangQi");
		accountLabel=new JLabel("Account:");
		passwordLabel=new JLabel("Password:");
		informationLabel=new JLabel("Please input your account and password");
		loginButton=new JButton("Login");
		loginButton.addActionListener(this);
		registerButton=new JButton("register");
		registerButton.addActionListener(this);
		account=new JTextField("",15);
		password=new JPasswordField("",15);
		password.setEchoChar('*');
		accountPanel=new JPanel();
		passwordPanel=new JPanel();
		informationPanel=new JPanel();
		buttonPanel=new JPanel();
		accountPanel.add(accountLabel);
		accountPanel.add(account);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);
		informationPanel.add(informationLabel);
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);
		add(accountPanel);
		add(passwordPanel);
		add(informationPanel);
		add(buttonPanel);
		setLayout(new GridLayout(4,1));
		this.setResizable(false);
    	this.setSize(300,300);
    	setVisible(true); 
    	
    	
	}
	
	public String returninformation(String account,String password)
	{
		String str=null;
		str=account+" "+password;
		return str;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(loginButton));
		{
			
			if(account.getText().equals("")||password.getText().equals(""))
			{
				informationLabel.setText("account and password can't be null");
			}
			else
				user.outputinformation("login",account.getText()+password.getText());
			if(returnCommand=="login success")
			{
				new MainFrame();
				this.setVisible(false);
			}
			if(user.returnCommand=="login failed")
			{
				informationLabel.setText("login wrong");
			}
		}
		if(e.getSource().equals(registerButton))
		{
			if(account.getText().equals("")||password.getText().equals(""))
			{
				informationLabel.setText("account and password can't be null");
			}
			else
				user.outputinformation("reg",account.getText()+password.getText());
			if(user.returnCommand=="reg success")
			{
				informationLabel.setText("register success");
				new MainFrame();
				this.setVisible(false);
			}
			if(user.returnCommand=="reg failed")
			{
				informationLabel.setText("register failed");
			}
		}
	}
}
