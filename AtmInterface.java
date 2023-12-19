import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

class Atm implements ActionListener{
Container s;
double accbal;
JFrame f;
JButton b1,b2,b3,b4,login;
JPanel p,w;
JLabel l,hd,hd1,hd2,bgl;
JTextArea ta;
JPasswordField pf;

Atm(double a){
accbal=a;
f=new JFrame();
f.setTitle("WELCOME TO CSOFT ATM");
f.setSize(1000,1000);
f.setLocation(100,100);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
s=new Container();
s=f.getContentPane();
//bgl=new JLabel(bg);
//bgl.setLayout(new BorderLayout());
//bgl.setBounds(0,0,1000,1000);

openWindow();
}

public void openAtm(){

//int width=1000;
//int height=1000;

ImageIcon bg=new ImageIcon("D:/codsoft/tq.jpg");
JLabel bgl=new JLabel(bg);
bgl.setLocation(910,281);
bgl.setSize(bg.getIconWidth(),bg.getIconHeight());
bgl.setVisible(true);

 p=new JPanel();
 Color lightyellow=new Color(255,255,204);
 p.setBackground(lightyellow);
 p.setLayout(null);
 
 ta=new JTextArea();
 ta.setBounds(906,5,621,273);
 ta.setText("\n \n \n \n         Welcome to Csoft ATM \n  \n         We are here to provide you, \n        uninterrupted and efficient services. \n      ________________________________");
 Font font1=new Font("Arial", Font.ITALIC, 20);
 ta.setFont(font1);
 ta.setForeground(Color.black);
 ta.setBackground(new Color(203,195,227));
 ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 
 
 Font font=new Font("Arial", Font.PLAIN, 20);
 hd1=new JLabel();
 hd1.setText("CHOOSE YOUR TRANSACTION");
 hd1.setFont(font);
 hd1.setBounds(120,30,315,100);
 
 b1=new JButton("Withdraw");
 b1.setBounds(150,115,150,80);
 b1.addActionListener(this);
 
 b2=new JButton("Deposit");
 b2.setBounds(150,265,150,80);
 b2.addActionListener(this);
 
 b3=new JButton("Balance Enquiry");
 b3.setBounds(150,415,150,80);
 b3.addActionListener(this);
 
 b4=new JButton("Exit");
 b4.setBounds(150,565,150,80);
 b4.addActionListener(this);
 
 
 p.setBounds(0,0,900,1000);
 p.add(b1);
 p.add(b2);
 p.add(b3);
 p.add(b4);
 p.add(hd1);
 s.add(ta);
 s.add(bgl);
 s.add(p);
 p.setVisible(true);
 s.setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
	
	if(e.getSource()==b1)
	{
		String swa=JOptionPane.showInputDialog("Enter amount to withdraw:");
		double wa=Double.parseDouble(swa);
		if(wa<=accbal){
			accbal-=wa;
			JOptionPane.showMessageDialog(p,"Withdraw Successful!! Cash will be dispensed");
		}
		else{
			JOptionPane.showMessageDialog(p,"No sufficient amount.Cannot withdraw!!");
		}
	}
	
	if(e.getSource()==b2)
	{
		String sda=JOptionPane.showInputDialog("Enter amount to be deposited:");
		double da=Double.parseDouble(sda);
		JOptionPane.showMessageDialog(p,"Insert your cash in provided slot");
		accbal+=da;
		JOptionPane.showMessageDialog(p,"Rs."+da+" is successfully deposited into your account.");		
	}
	
	if(e.getSource()==b3){
		JOptionPane.showMessageDialog(p,"Current Balance in your account "+accbal);
	}
	
	if(e.getSource()==b4){
		int result=JOptionPane.showConfirmDialog(p,"Do you want to exit the program?","Exit Confirmation",JOptionPane.YES_NO_OPTION);
		
		if(result==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}		
	}
	
}
int pwd=5555;
int inp;
int attempts=0;

public void openWindow(){
	
w=new JPanel();
w.setSize(900,900);
w.setLayout(null);
s.add(w);

Font font=new Font("Arial", Font.BOLD, 30);
hd2=new JLabel();
hd2.setBounds(250,50,430,35);
hd2.setText("WELCOME, Mr.RAJ GUPTA");
hd2.setFont(font);
hd2.setForeground(Color.blue);
w.add(hd2);
 
Font font2=new Font("Arial", Font.PLAIN, 20);
hd=new JLabel();
hd.setText("USER AUTHENTICATION");
hd.setFont(font2);
hd.setBounds(300,110,300,30);
hd.setOpaque(true);
w.add(hd);

Font font1=new Font("Arial", Font.PLAIN, 21);
l=new JLabel("Enter PIN");
l.setBounds(80,184,120,25);
l.setFont(font1);
w.add(l);

pf=new JPasswordField();
pf.setBounds(180,170,90,60);
w.add(pf);

login=new JButton("Login");
login.setBounds(180,270,80,50);
w.add(login);

w.setVisible(true);
f.setVisible(true);
s.setVisible(true);

login.addActionListener(new ActionListener(){
	
	public void actionPerformed(ActionEvent e){
	   String spwd=new String(pf.getPassword());
	   int inp=Integer.parseInt(spwd);
	   if(inp==pwd)
	    {
		w.setVisible(false);
		openAtm();
	    }
		else if(spwd.equals("") || inp!=pwd){
		attempts+=1;
		if(attempts<3)
		{
		pf.setText("");
		JOptionPane.showMessageDialog(w,"Invalid Pin!! Try Again.","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(w,"Maximum attempts reached..\n Aborting the transaction.","Warning",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	  }	      
	}
	
});

}

}

public class AtmInterface{

public static void main(String args[])
{
new Atm(2600);
}

}

