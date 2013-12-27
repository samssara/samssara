 import javax.swing.*;

 import java.awt.*;
 import java.awt.event.WindowAdapter;
 import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddLedgerError
		extends 	JFrame
		implements  ActionListener
 {
	
	
   public void actionPerformed( ActionEvent event )
	{
		try {
			
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
			
	}        
	          
	public static String[] ComboValues(String c1) throws IOException
	{
		BufferedReader input = new BufferedReader(new FileReader(c1));
		ArrayList<String> strings = new ArrayList<String>();
		String line= null;
		    try
		    {
		    while (( line = input.readLine()) != null){
		        strings.add(line);
		    }
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    String[] Result = strings.toArray(new String[]{});
		    strings.clear();
		    input.close();
			return Result;
	}

	public static void main( String args[] ) throws IOException, InterruptedException
	{
		
		final JLabel l1,l2,l3,l4,l5,l6,Title; 
		final JComboBox j1,j2,j3;
		final TextField t1,t2,t3;
		
		String ClientNames ="E:\\Working\\ConnectDataBase\\Path\\ClientNames.txt";
		String Exchanges ="E:\\Working\\ConnectDataBase\\Path\\Exchanges.txt";
		String Codes ="E:\\Working\\ConnectDataBase\\Path\\Codes.txt";
		
		// Create an instance of the test application
		Frame f=new Frame("Add Ledger Error");
		f.setSize(300,300);
		f.setLocation(100, 100);
		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
		Title = new JLabel("---------------- ADD LEDGER ERROR ----------------");
		Title.setSize(Title.getPreferredSize());
		p1.add(Title);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 2));
		l1 = new JLabel("<html><div style=\"width: 70px;\">CLIENT</div></html>");
		String[] ClientList=ComboValues(ClientNames);
		j1 = new JComboBox(ClientList);//FOR ClientList;
		j1.setSelectedIndex(0);
		p2.add(l1);
		p2.add(j1);
		
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 2));
		l2 = new JLabel("<html><div style=\"width: 70px;\">EXCHANGE</div></html>");
		String[] ExchangeList=ComboValues(Exchanges);
		j2 = new JComboBox(ExchangeList);//FOR CLIENT(ClientList); 
		j2.setSelectedIndex(0);
		p3.add(l2);
		p3.add(j2);
		
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 2));
		l3 = new JLabel("<html><div style=\"width: 70px;\">DATE</div></html>");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    //get current date time with Date()
	    Date date = new Date();
	    t1 = new TextField(14);
	    t1.setText(dateFormat.format(date));
	    t1.setEditable(false);
	    p4.add(l3);
		p4.add(t1);
		
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 2));
		l4 = new JLabel("<html><div style=\"width: 70px;\">CODE</div></html>");
		String[] CodeList=ComboValues(Codes);
		j3 = new JComboBox(CodeList);//FOR CLIENT(ClientList); 
		j3.setSelectedIndex(0);
		p5.add(l4);
		p5.add(j3);
		
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 2));
		l5 = new JLabel("<html><div style=\"width: 70px;\">EXPIRY</div></html>");
		t2 = new TextField(14);
	    p6.add(l5);
		p6.add(t2);
		
		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 2));
		l6 = new JLabel("<html><div style=\"width: 70px;\">LEDGER</div></html>");
		t3 = new TextField(14);
	    p7.add(l6);
		p7.add(t3);
		
		JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		Button Submit=new Button("Submit");
		p8.add(Submit);
		
		JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
	    mainPanel.add(p1);
	    mainPanel.add(p2);
	    mainPanel.add(p3);
	    mainPanel.add(p5);
	    mainPanel.add(p4);
	    mainPanel.add(p6);
	    mainPanel.add(p7);
	    mainPanel.add(p8);
		
		f.add(mainPanel);
		f.setVisible(true);
		Submit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	try {
		    		//for Connectivity
		    		 String url = "jdbc:mysql://50.97.161.228:3306/samssara_ClientUpdates";
		    	     String dbName = "samssara_ClientUpdates";
		    	     String driver = "com.mysql.jdbc.Driver";
		    	     String userName = "samssara_sam";
		    	     String userName2 = "samssara_sam2";
		    	     String password = "sam123";
		    	     java.sql.Statement UpdateResult;
		    	     String UpdateString=null;
		             ResultSet UpdateSet=null;
		                    
		            
		        	 Class.forName(driver).newInstance();
		             DriverManager.getConnection(url,userName,password);
		             Connection conn = DriverManager.getConnection(url,userName,password);
		             String s1 = "SELECT * from Errors WHERE (CLIENT='"+j1.getSelectedItem()+"' AND EXCHANGE='"+j2.getSelectedItem()+"' AND CODE='"+j3.getSelectedItem()+"'AND DATE='"+t1.getText()+"'  AND EXPIRY='"+t2.getText()+"')";
		             PreparedStatement FindLedger = conn.prepareStatement(s1);
		             UpdateResult=conn.createStatement();
		             UpdateSet = FindLedger.executeQuery();
		                  	  
		                                
		                 if(!UpdateSet.next())
		                  {
		                    UpdateString = "INSERT INTO Errors (CLIENT, EXCHANGE, DATE, CODE, EXPIRY, LEDGER)";
		                    UpdateString = UpdateString + "VALUES ('"+j1.getSelectedItem()+"','"+j2.getSelectedItem()+"','"+j3.getSelectedItem()+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
		               		UpdateResult = conn.createStatement();
		               		int UpdateStatus = UpdateResult.executeUpdate(UpdateString);
		              
		               		JOptionPane.showMessageDialog(null,"Inserted Successfully!");
		                  }
		                 else
		                  {   
		                	 String s2 = "UPDATE Errors SET LEDGER='"+t3.getText()+"' WHERE (CLIENT='"+j1.getSelectedItem()+"' AND EXCHANGE='"+j2.getSelectedItem()+"' AND CODE='"+j3.getSelectedItem()+"'AND DATE='"+t1.getText()+"'  AND EXPIRY='"+t2.getText()+"')";
		                	 UpdateResult = conn.createStatement();
		                	 int UpdateStatus = UpdateResult.executeUpdate(s2);
		                	 JOptionPane.showMessageDialog(null,"Updated Successfully!");
		                	
		                	  j1.setSelectedIndex(0);
		                	  j2.setSelectedIndex(0);
		                	  j3.setSelectedIndex(0);
		                	  t2.setText("");
		                	  t3.setText("");
		                 }
		             	}	
		              catch(Exception e1)
		               	{
		            	   	 e1.printStackTrace();
		               	}
		    	
		    	   }
		});
	}
}