import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;


public class NumberGuessGame1 extends JFrame {
     int generatedNumber,min,max,attempts=0,marks=0;
    JTextField guessField,range1,range2;
    JLabel range,promptLabel,ll,ul,sclabel,scl,head;
    JButton submitButton,genButton,scButton,ex,okButton;
	JPanel scpanel;
	JTextArea scarea;

    public NumberGuessGame1() {        

        JPanel panel1 = new JPanel();
        panel1.setBounds(550,125,300,310);
       
        range=new JLabel("ENTER RANGE:");
		range.setFont(new Font("Helvetica",Font.BOLD,15));
		range.setForeground(new Color(0,0,128));
        range.setBounds(36,20,130,30);

        ll=new JLabel("Lower Limit-");
		ll.setFont(new Font("Arial",Font.BOLD,15));
		ll.setBounds(36,70,110,20);
		
		ul=new JLabel("Upper Limit-");
		ul.setFont(new Font("Arial",Font.BOLD,15));
		ul.setBounds(36,140,110,20);

        range1=new JTextField(7);
        range1.setBounds(36,100,70,26);
       
        range2=new JTextField(7);
        range2.setBounds(36,170,70,26);

        genButton = new JButton("Generate");
		genButton.setBounds(77,235,110,42);
		
		Font custom=new Font("Calibri",Font.BOLD,15);
		Color cc=new Color(203,195,227);
		genButton.setFont(custom);
		
        genButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				attempts=0;
            try{
               min=Integer.parseInt(range1.getText());
               max=Integer.parseInt(range2.getText());
               SwingUtilities.invokeLater(() -> {
               generatedNumber = generateRandomNumber(min, max) ;
			   System.out.println(generatedNumber);
              });
            }
			
            catch(NumberFormatException ex) {
              SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(NumberGuessGame1.this, "Please enter a valid number.");
              });
            }
            }
        });
        panel1.setBackground(cc);
        panel1.add(range);
		panel1.add(ll);
		panel1.add(ul);		
        panel1.add(range1);
        panel1.add(range2); 
        panel1.add(genButton);	
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));		
        panel1.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setBounds(550,450,300,200);

        promptLabel = new JLabel();
        promptLabel.setText("ENTER YOUR GUESS:");
        promptLabel.setFont(new Font("Helvetica",Font.BOLD,15));
		promptLabel.setForeground(new Color(0,0,128));
        promptLabel.setBounds(40,20,190,30);

        guessField = new JTextField(7);
        guessField.setBounds(40,62,100,32);

        submitButton = new JButton("Check");
        submitButton.setBounds(75,125,78,45);
		submitButton.setFont(custom);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				attempts+=1;
				if(attempts<3){
                checkGuess();
				}
				else{
					JOptionPane.showMessageDialog(NumberGuessGame1.this, "Exceeded maximum attempts.");
				}
            }
        });    

        panel2.add(promptLabel);    
        panel2.add(guessField);
        panel2.add(submitButton);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));	
        panel2.setLayout(null);
        panel2.setBackground(cc);

        scButton = new JButton("Score");
		scButton.setBounds(550,680,80,35);
		scButton.setFont(custom);
		scButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			      scoreCard();
            }
        });

        ex=new JButton("Exit");
		ex.setBounds(762,680,80,35);
		ex.setFont(custom);
		ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			      System.exit(0);
            }
        });

         head=new JLabel("-NUMBER GAME-");
		 head.setFont(new Font("Serif",Font.BOLD,45));
		 head.setForeground(new Color(204,0,0));
		 head.setBounds(527,8,400,55);

        scarea=new JTextArea();
		scarea.setText("NOTE: Only 2 attempts are available for each round.\n              2marks for correct guess and -1 for wrong guess");
		scarea.setBounds(552,65,313,35);
        scarea.setEditable(false);
		
        setLayout(null);
        add(panel1);
        add(panel2);
		add(scButton);
		add(ex);
		add(scarea);
        add(head);

        setTitle("Number Guess Game");
        setBounds(0,0,1500, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
	
	
	 void scoreCard(){
		 
		 
		 sclabel=new JLabel("YOUR SCORE:");
		 sclabel.setBounds(880,500,90,35);
		 sclabel.setFont(new Font("Calibri",Font.BOLD,15));
		 
		 scl=new JLabel();
		 scl.setText(String.valueOf(marks));
		 scl.setFont(new Font("Calibri",Font.BOLD,18));
		 scl.setForeground(Color.red);
		 scl.setBounds(880,542,60,35);
		 		 
		 okButton=new JButton("Ok");
		 okButton.setBounds(890,595,50,45);
		
		 okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			      sclabel.setVisible(false);
                  scl.setVisible(false);
                  okButton.setVisible(false);	
				  
            }
        });
		
		
		NumberGuessGame1.this.add(sclabel);
		NumberGuessGame1.this.add(scl);
		NumberGuessGame1.this.add(okButton);
		 
sclabel.setVisible(true);
scl.setVisible(true);
okButton.setVisible(true);		 
		 
		 NumberGuessGame1.this.revalidate();
		 NumberGuessGame1.this.repaint();
	 }
     
     void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
       
            if (userGuess == generatedNumber) {
				marks+=2;
                JOptionPane.showMessageDialog(NumberGuessGame1.this, "Congratulations! Your guess is correct.");
            } else if (userGuess < generatedNumber/2) {
				marks-=1;
                JOptionPane.showMessageDialog(NumberGuessGame1.this, "Too low! Try again.");
            } else if(userGuess > generatedNumber*2) {
				marks-=1;
                JOptionPane.showMessageDialog(NumberGuessGame1.this, "Too high! Try again.");
            }
              else if(userGuess > generatedNumber) {
				  marks-=1;
                JOptionPane.showMessageDialog(NumberGuessGame1.this, "It's high! Try again.");
            }
              else{
				 marks-=1;
                JOptionPane.showMessageDialog(NumberGuessGame1.this, "It's low! Try again.");
            }
        } 
            catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(NumberGuessGame1.this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NumberGuessGame1();
        });
    }
}


