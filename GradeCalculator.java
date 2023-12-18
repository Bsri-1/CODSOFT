import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

class Student extends JFrame implements ActionListener {
Container c;
JButton jb1,jb2,jb3,jb4,clr;
JLabel l1,l2,l3,l4,resultl,sub;
JTextField t1,t2,t3,t4;
int m1,m2,m3,m4,m;
float avg;
JPanel pm,pavg,pg,pp;
String g;
Student()
{
    c=this.getContentPane();
    jb1=new JButton("Total");
	jb1.setBounds(100,550,120,40);
    jb2=new JButton("Avg Percentage");
	jb2.setBounds(270,550,120,40);
     jb3=new JButton("Grade");
	jb3.setBounds(420,550,120,40);
    jb4=new JButton("Results");
	jb4.setBounds(570,550,120,40);
    clr=new JButton("Clear");
	clr.setBounds(720,550,120,40);
	clr.setVisible(true);
	jb1.addActionListener(this);
    jb2.addActionListener(this);
    jb3.addActionListener(this);
    jb4.addActionListener(this);
    clr.addActionListener(this);
	
	
	l1=new JLabel();
	l1.setText("JAVA");
	l1.setBounds(100,200,75,30);
	l1.setForeground(Color.red);
	
	l2=new JLabel();
	l2.setText("PYTHON");
	l2.setForeground(Color.red);
	l2.setBounds(100,275,75,30);
	
	l3=new JLabel();
	l3.setText("PHP");
	l3.setBounds(100,350,75,30);
	l3.setForeground(Color.red);
	
	l4=new JLabel();
	l4.setText(".NET");
	l4.setBounds(100,425,75,30);
	l4.setForeground(Color.red);
	
   t1=new JTextField();
   t1.setBounds(250,200,100,50);
   t2=new JTextField();
   t2.setBounds(250,275,100,50);
   t3=new JTextField();
   t3.setBounds(250,350,100,50);
   t4=new JTextField();
   t4.setBounds(250,425,100,50);

 c.add(l1);
 c.add(l2);
 c.add(l3);
 c.add(l4);
 c.add(t1);
 c.add(t2);
 c.add(t3);
 c.add(t4);
 c.add(jb1);
 c.add(jb2);
 c.add(jb3);
 c.add(jb4);
 c.add(clr);

resultl=new JLabel();
resultl.setBounds(300,50,434,30);
resultl.setForeground(Color.BLUE);
resultl.setOpaque(true);
Font font=new Font("Arial", Font.ITALIC, 25);
resultl.setFont(font);
resultl.setText("  STUDENT GRADE CALCULATOR");
resultl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
sub=new JLabel();
sub.setBounds(100,140,300,30);
sub.setForeground(Color.BLACK);
sub.setText("Give marks of the student(out of 100):");
sub.setFont(new Font("Calibri", Font.BOLD, 18));
c.add(resultl);
c.add(sub);
}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==jb1)
	{      
		updateResultLabel("Total");
	}
	
    else if(e.getSource()==jb2)
	{
         updateResultLabel("Average percentage");
	}
	
	else if(e.getSource()==jb3)
	{   
         updateResultLabel("Grade");
	}
	
	else if(e.getSource()==jb4)
	{
          updateResultLabel("Results");
	}
	
	else if(e.getSource()==clr)
	{
		 t1.setText("");
		 t2.setText("");
		 t3.setText("");
		 t4.setText("");
	}
	
}

private void updateResultLabel(String text)
{
	
	try{
    m1=Integer.parseInt(t1.getText());
    m2=Integer.parseInt(t2.getText());
    m3=Integer.parseInt(t3.getText());
    m4=Integer.parseInt(t4.getText());
   }

    catch(NumberFormatException ex)
    {
     JOptionPane.showMessageDialog(this,"Enter valid numbers.");
    }
         m=m1+m2+m3+m4;
         avg=m/4;
         if(avg>90 && avg<=100)
			 g="A";
	     else if(avg>80 && avg<=90)
			 g="B";
         else if(avg>70 && avg<=80)
			 g="C";
	     else if(avg>60 && avg<=70)
			 g="D";		 
         else
			 g="F";
	switch (text){
		case "Total":
	          JOptionPane.showMessageDialog(this,"Total of the marks is: "+ m);
		     break;
		
		case "Average percentage":
		     JOptionPane.showMessageDialog(this,"Average Percentage is: "+ avg);
			 break;
			 
		case "Grade":
		      JOptionPane.showMessageDialog(this,"Grade of the student is: "+ g);
			  break;
			  
		case "Results":
		      String msg="Total:" +m+ "\nAverage Percent:" +avg+ "\nGrade:" +g;
			  JOptionPane.showMessageDialog(this,msg);
			  break;
			
	}
}

}

class GradeCalculator{
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(() -> {
		 Student s=new Student();
		 s.setTitle("Student Grade Calculator");
		 s.setSize(1000,1000);
         s.setLocation(100,100);
		 s.setLayout(null);
         s.setVisible(true);
         s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		});
	}
}