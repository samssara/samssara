import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;
import java.sql.*;

public class MainApplet extends JFrame implements ActionListener
{
 
	public void init() {
		button1 = new Button("Button 1");
		add(button1);
		button1.addActionListener(this);

		button2 = new Button("Button 2");
		add(button2);
		button2.addActionListener(this);
	}

	public void actionPerformed1(ActionEvent e) {
		if (e.getSource() == button1) 
			
		{
			Ass140 A= new Ass140();
			A.main(args);
			
				System.out.println("Add a User");
		}
		else
			System.out.println("Add a Ladger Error");
	}

	Button button1, button2;

 JButton b1,b2;
 
 /* xyz changes*/
 //hwsqjk
 MainApplet()
 {
  
  
  

  b1=new JButton("Add a User");
  b2=new JButton("Add a Ladger Error");
  
  /* fdf */
  
  add(b1);
  add(b2);
  b1.addActionListener(this);
  b2.addActionListener(this);
  setSize(200,200);
  setLayout(new FlowLayout());
  setTitle("Main Applet");
  
  setSize(200,200);
  setLayout(new FlowLayout());
  setTitle("Main Applet");
 }

 /*public void actionPerformed(ActionEvent ae)
 {
	 //for Connectivity
	 String url = "jdbc:mysql://50.97.161.228:3306/samssara_ClientUpdates";
//   String dbName = "samssara_ClientUpdates";
   String driver = "com.mysql.jdbc.Driver";
   String userName = "samssara_sam";
   String userName2 = "samssara_sam2";
   String password = "sam123";
   Statement UpdateResult;
   try {
       Class.forName(driver).newInstance();
      DriverManager.getConnection(url,userName,password);
      // UpdateTime = System.currentTimeMillis();
       Connection conn = DriverManager.getConnection(url,userName,password);
       String UpdateString = "INSERT INTO UserLogin (CLIENT, EXCHANGE, LOGIN, PASS)";
       UpdateResult=conn.createStatement();
      UpdateString = UpdateString + "VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
      UpdateResult.executeUpdate(UpdateString);
      JOptionPane.showMessageDialog(null,"Inserted Successfully!");
      conn.close();
   
   }
   catch(Exception e)
   {
	   e.printStackTrace();
   }
	
 }*/
 public static void main(String args[])
 {
  MainApplet a=new MainApplet();
  a.setVisible(true);
  a.setLocation(200,200);
  
 }

}
