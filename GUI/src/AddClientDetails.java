import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import java.sql.*;

public class AddClientDetails extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JButton b1;
 JTextField t1,t2,t3,t4;


 AddClientDetails()
 {
  l1=new JLabel("Client");
  l2=new JLabel("Exchange");
  l3=new JLabel("Login");
  l4=new JLabel("Password");
  b1=new JButton("Submit");
  
  t1=new JTextField(8);
  t2=new JTextField(8);
  t3=new JTextField(8);
  t4=new JTextField(8);

  add(l1);
  add(t1);
  add(l2);
  add(t2);
  add(l3);
  add(t3);
  add(l4);
  add(t4);
  add(b1);
  
  JButton button = new JButton();
  b1.registerKeyboardAction(button.getActionForKeyStroke(
          KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
          KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
          JComponent.WHEN_FOCUSED);

 b1.registerKeyboardAction(button.getActionForKeyStroke(
          KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
          KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
          JComponent.WHEN_FOCUSED);
  b1.addActionListener(this);
  
  setSize(300,200);
  setResizable(false);
  setLayout(new FlowLayout());
  setTitle("Add a user");
 }

 public void actionPerformed(ActionEvent ae)
 {
	 //for Connectivity
	 String url = "jdbc:mysql://50.97.161.228:3306/samssara_ClientUpdates";
//   String dbName = "samssara_ClientUpdates";
   String driver = "com.mysql.jdbc.Driver";
   String userName = "samssara_sam";
   String userName2 = "samssara_sam2";
   String password = "sam123";
   Statement UpdateResult;
   String UpdateString;
   ResultSet UpdateSet=null;
   
   
   try {
       Class.forName(driver).newInstance();
      DriverManager.getConnection(url,userName,password);
      // UpdateTime = System.currentTimeMillis();
       Connection conn = DriverManager.getConnection(url,userName,password);
       String s1 = "SELECT * from UserLogin WHERE (CLIENT='"+t1.getText()+"' AND EXCHANGE='"+t2.getText()+"')";
       PreparedStatement FindLedger = conn.prepareStatement(s1);
       UpdateResult=conn.createStatement();
       UpdateSet = FindLedger.executeQuery();
       
       if(!UpdateSet.next())
       {
    	   UpdateString = "INSERT INTO UserLogin (CLIENT, EXCHANGE, LOGIN, PASS)";
           UpdateResult=conn.createStatement();
          UpdateString = UpdateString + "VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
          UpdateResult = conn.createStatement();
     	  int UpdateStatus = UpdateResult.executeUpdate(UpdateString);
          JOptionPane.showMessageDialog(null,"Inserted Successfully!");
       }
       else
       {
    	   String s2 = "UPDATE UserLogin SET LOGIN='"+t3.getText()+"', PASS='"+t4.getText()+"' WHERE (CLIENT='"+t1.getText()+"' AND EXCHANGE='"+t2.getText()+"')";
      	 UpdateResult = conn.createStatement();
      	 int UpdateStatus = UpdateResult.executeUpdate(s2);
      	 JOptionPane.showMessageDialog(null,"Updated Successfully!");
       }
       
       
       
       
       
       
       
       
       
      
      t1.setText("");
      t3.setText("");
      t4.setText("");
      conn.close();
   
   }
   catch(Exception e)
   {
	   e.printStackTrace();
   }
	
 }
 public static void main(String args[])
 {
  AddClientDetails a=new AddClientDetails();
  a.setVisible(true);
  a.setLocation(400,100);
  
 }

}
