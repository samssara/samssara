import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.sql.*;

public class MainApplet extends JFrame implements ActionListener
{  
	
	JButton b1,b2,b3;
	MainApplet()

	{
		b1=new JButton("Add Ledger");
		b2=new JButton("Update Strategy");  
		b3=new JButton("Add Client Details");
        add(b1);
        add(b2);
        add(b3);
       
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

 
        JButton button = new JButton();

 //changes by dipyant
 
  b1.registerKeyboardAction(button.getActionForKeyStroke(
         KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
         KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
         JComponent.WHEN_FOCUSED);

  b1.registerKeyboardAction(button.getActionForKeyStroke(
         KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
         KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
         JComponent.WHEN_FOCUSED);


  b2.registerKeyboardAction(button.getActionForKeyStroke(
        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
        JComponent.WHEN_FOCUSED);
 
  b2.registerKeyboardAction(button.getActionForKeyStroke(
        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
        JComponent.WHEN_FOCUSED);


  b3.registerKeyboardAction(button.getActionForKeyStroke(
        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
        JComponent.WHEN_FOCUSED);
 
  b3.registerKeyboardAction(button.getActionForKeyStroke(
        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
        JComponent.WHEN_FOCUSED);




//b1.setBackground(Color.RED.brighter());

 /* b1.setBackground(Color.decode("#52d6eb"));
  b2.setBackground(Color.decode("#52d6eb"));
  b3.setBackground(Color.decode("#52d6eb"));*/
  
  
   
 setSize(240,240);
 setResizable(false);
 setLayout(new FlowLayout());
 setTitle("Main Applet");
}
	public void actionPerformed(ActionEvent ae)
	 {
		if(ae.getSource()==b1)
		{AddLedgerError a= new AddLedgerError();
			try {
				a.main(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ae.getSource()==b3)
		{
			AddClientDetails b= new AddClientDetails();
			b.main(null);
		}
		
		if(ae.getSource()==b2)
		{
			UpdateStrategy c= new UpdateStrategy();
			c.main(null);
		}
		
		
	}


public static void main(String args[])
{
	 
 MainApplet a=new MainApplet();
 a.setVisible(true);
 a.setLocation(400,250);
 
}

}