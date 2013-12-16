import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;
import java.sql.*;

public class AddClientDetails extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JButton b1;
 JTextField t1,t2,t3,t4;
 /* xyz changes*/
 //hwsqjk
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
  /* fdf */
  add(l1);
  add(t1);
  add(l2);
  add(t2);
  add(l3);
  add(t3);
  add(l4);
  add(t4);
  add(b1);
  
  b1.addActionListener(this);
  
  setSize(200,200);
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
	
 }
 public static void main(String args[])
 {
  AddClientDetails a=new AddClientDetails();
  a.setVisible(true);
  a.setLocation(200,200);
  
 }

}
