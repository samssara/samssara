
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableModel;

import java.sql.*;

public  class DisplayData extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1;
	JTextField t1,t2,t3,t4,t5,t6;
	DisplayData()
	 {
	  l1=new JLabel("Client");
	  l2=new JLabel("Exchange");
	  l3=new JLabel("Date");
	  l4=new JLabel("Code");
	  l5=new JLabel("Expiry");
	  l6=new JLabel("Position");
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
	  
	  setSize(200,200);
	  setLayout(new FlowLayout());
	  setTitle("DisplayData");
	 }
	
	public void actionPerformed(ActionEvent ae)
	{
		//TableModel t1;
		JTable table = new JTable();
		
		String url = "jdbc:mysql://50.97.161.228:3306/samssara_ClientUpdates";
		  String dbName = "samssara_ClientUpdates";
		   String driver = "com.mysql.jdbc.Driver";
		   String userName = "samssara_sam";
		   String userName2 = "samssara_sam2";
		   String password = "sam123";
		   Statement UpdateResult=null;
	       ResultSet UpdateSet;
	       Connection conn=null;
		try
		{
			
			Class.forName(driver).newInstance();
	           DriverManager.getConnection(url,userName,password);
	           Connection conn1 = DriverManager.getConnection(url,userName,password);
	           String s1 = "SELECT * from Errors WHERE (EXCHANGE='"+t2.getText()+"')";
	           PreparedStatement FindLedger = conn1.prepareStatement(s1);
	           UpdateResult=conn1.createStatement();
	           UpdateSet = FindLedger.executeQuery();
		    
	           while(UpdateSet.next())
	           {
	               System.out.println(UpdateSet.getString("CLIENT"));
	               System.out.println(UpdateSet.getString("EXCHANGE"));
	               System.out.println(UpdateSet.getString("DATE"));
	               System.out.println(UpdateSet.getString("CODE"));
	               System.out.println(UpdateSet.getString("EXPIRY"));
	               System.out.println(UpdateSet.getString("POSITION"));
	           
	               
	           }
		     
		       String s2 = "SELECT * from Errors WHERE (CLIENT='"+t1.getText()+"')";
	           PreparedStatement FindLedger1 = conn1.prepareStatement(s2);
	           UpdateResult=conn1.createStatement();
	           UpdateSet = FindLedger1.executeQuery();   
		    
		    	 while(UpdateSet.next())
		           {
		               System.out.println(UpdateSet.getString("CLIENT"));
		               System.out.println(UpdateSet.getString("EXCHANGE"));
		               System.out.println(UpdateSet.getString("DATE"));
		               System.out.println(UpdateSet.getString("CODE"));
		               System.out.println(UpdateSet.getString("EXPIRY"));
		               System.out.println(UpdateSet.getString("POSITION"));
		           
		               
		           }
		     
		    	 String s3 = "SELECT * from Errors WHERE (CODE='"+t4.getText()+"')";
		           PreparedStatement FindLedger2 = conn1.prepareStatement(s3);
		           UpdateResult=conn1.createStatement();
		           UpdateSet = FindLedger2.executeQuery();   
			    
			    	 while(UpdateSet.next())
			           {
			               System.out.println(UpdateSet.getString("CLIENT"));
			               System.out.println(UpdateSet.getString("EXCHANGE"));
			               System.out.println(UpdateSet.getString("DATE"));
			               System.out.println(UpdateSet.getString("CODE"));
			               System.out.println(UpdateSet.getString("EXPIRY"));
			               System.out.println(UpdateSet.getString("POSITION"));		           			               
			           }
		       
			    	 String s4 = "SELECT * from Errors WHERE (CLIENT='"+t1.getText()+"'AND EXCHANGE='"+t2.getText()+"')";
			           PreparedStatement FindLedger3 = conn1.prepareStatement(s4);
			           UpdateResult=conn1.createStatement();
			           UpdateSet = FindLedger3.executeQuery();   
				    
				    	 while(UpdateSet.next())
				           {
				               System.out.println(UpdateSet.getString("CLIENT"));
				               System.out.println(UpdateSet.getString("EXCHANGE"));
				               System.out.println(UpdateSet.getString("DATE"));
				               System.out.println(UpdateSet.getString("CODE"));
				               System.out.println(UpdateSet.getString("EXPIRY"));
				               System.out.println(UpdateSet.getString("POSITION"));		           			               
				           }
		       
		       
		       
		       
	   		   
		}
		catch(Exception e)
		{
   	   	 e.printStackTrace();
      	}
		
		 
	}
	
	
	
	
	
	public static void main(String args[])
	   {
		 try{
			 
	    DisplayData a=new DisplayData();
	    a.setVisible(true);
	    a.setLocation(200,200);
		 }
		 catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }
}