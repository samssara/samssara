
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import java.sql.*;

public class UpdateLedger extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1;
	JTextField t1,t2,t3,t4,t5,t6;
	
	UpdateLedger()
	 {
	  l1=new JLabel("Client");
	  l2=new JLabel("Exchange");
	  l3=new JLabel("Date");
	  l4=new JLabel("Code");
	  l5=new JLabel("Expiry");
	  l6=new JLabel("Ledger");
	  b1=new JButton("Submit");
	  
	  t1=new JTextField(8);
	  t2=new JTextField(8);
	  t3=new JTextField(8);
	  t4=new JTextField(8);
	  t5=new JTextField(8);
	  t6=new JTextField(8);
	  
	  add(l1);
	  add(t1);
	  add(l2);
	  add(t2);
	  add(l3);
	  add(t3);
	  add(l4);
	  add(t4);
	  add(l5);
	  add(t5);
	  add(l6);
	  add(t6);
	  add(b1);
	  
	  	  
	  b1.addActionListener(this);
	  
	  setSize(300,200);
	  setResizable(false);
	  setLayout(new FlowLayout());
	  setTitle("Add a Ledger");
	 
	 }
	public void actionPerformed(ActionEvent ae)
	{
		
		   
			//for Connectivity
		 String url = "jdbc:mysql://50.97.161.228:3306/samssara_ClientUpdates";
	     String dbName = "samssara_ClientUpdates";
	     String driver = "com.mysql.jdbc.Driver";
	     String userName = "samssara_sam";
	     String userName2 = "samssara_sam2";
	     String password = "sam123";
	     Statement UpdateResult;
	     String UpdateString=null;
         ResultSet UpdateSet=null;
                
         try {
    	      	     	   
    	   Class.forName(driver).newInstance();
           DriverManager.getConnection(url,userName,password);
           Connection conn = DriverManager.getConnection(url,userName,password);
           String s1 = "SELECT * from Errors WHERE (CLIENT='"+t1.getText()+"' AND EXCHANGE='"+t2.getText()+"' AND DATE='"+t3.getText()+"' AND CODE='"+t4.getText()+"' AND EXPIRY='"+t5.getText()+"')";
           PreparedStatement FindLedger = conn.prepareStatement(s1);
           UpdateResult=conn.createStatement();
           UpdateSet = FindLedger.executeQuery();
              	  
                            
             if(!UpdateSet.next())
              {
                UpdateString = "INSERT INTO Errors (CLIENT, EXCHANGE, DATE, CODE, EXPIRY, LEDGER)";
                UpdateString = UpdateString + "VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";
           		UpdateResult = conn.createStatement();
           		int UpdateStatus = UpdateResult.executeUpdate(UpdateString);
          
           		JOptionPane.showMessageDialog(null,"Inserted Successfully!");
              }
             else
              {   
            	 String s2 = "UPDATE Errors SET LEDGER='"+t6.getText()+"' WHERE (CLIENT='"+t1.getText()+"' AND EXCHANGE='"+t2.getText()+"' AND DATE='"+t3.getText()+"' AND CODE='"+t4.getText()+"' AND EXPIRY='"+t5.getText()+"')";
            	 UpdateResult = conn.createStatement();
            	 int UpdateStatus = UpdateResult.executeUpdate(s2);
            	 JOptionPane.showMessageDialog(null,"Updated Successfully!");
            	
            	  t1.setText("");
            	  t2.setText("");
            	  t3.setText("");
            	  t4.setText("");
                  t5.setText("");
                  t6.setText("");
                  
              }
         	}	
          catch(Exception e)
           	{
        	   	 e.printStackTrace();
           	}
	}
      public static void main(String args[])
	   		{
     	  		 UpdateLedger a=new UpdateLedger();
    	  		 a.setVisible(true);
    	  		 a.setLocation(400,500);
	   		}
} 
