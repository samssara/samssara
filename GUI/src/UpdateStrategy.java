import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.applet.*;
import javax.swing.*;
import java.sql.*;

public class UpdateStrategy extends JFrame implements ActionListener
{
 JLabel l1,l2;
 JButton b1;
 JTextField t1,t2;
 /* xyz changes*/
 //hwsqjk
 UpdateStrategy()
 {
  l1=new JLabel("STRATEGY");
  l2=new JLabel("VER");
  
  b1=new JButton("Submit");
  
  t1=new JTextField(8);
  t2=new JTextField(8);
  
 
  add(l1);
  add(t1);
  add(l2);
  add(t2);
  add(b1);
  
  l1.setBounds(10, 10, 20, 22);
  l2.setBounds(10, 30, 20, 22);
  t1.setBounds(50, 10, 20, 22);
  t2.setBounds(50, 30, 20, 22);
  b1.setBounds(25, 50, 20, 22);
  
  b1.addActionListener(this);
 
 
  setSize(300,200);
  setResizable(false);
  setLayout(new FlowLayout());
  setTitle("Update Strategy");
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
       String UpdateString = "INSERT INTO Versions (STRATEGY,VER)";
       UpdateResult=conn.createStatement();
      UpdateString = UpdateString + "VALUES ('"+t1.getText()+"','"+t2.getText()+"')";
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
  UpdateStrategy a=new UpdateStrategy();
  a.setVisible(true);
  //a.setBounds(0, 0, 300, 150);
 a.setLocation(600,300);
  
 }

}

