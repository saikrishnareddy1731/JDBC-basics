package google.in;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Entry {

	public static void main(String[] args)
	{
//	basic_connector_method_with_finally_example1();     
//	statement_without_finally_example2();
	//insert_using_statement();
	//prepared_statement_insertion();
	//new_ways_to_store_url();
		
		
		
		
		
		
//		try
//		{
//		Properties props=new Properties();
//		props.load(new FileInputStream("Data.properties"));
//		String driver=props.getProperty("Data.properties");
//		String url=props.getProperty("database.url");
//		String user=props.getProperty("database.userName");
//		String pwd=props.getProperty("database.password");
//		try(Connection connection=DriverManager.getConnection(
//	    		
//	    		      url,user,pwd);
//				// with prepared statement we can take a time once and easy way of input
//	    		  )
//	    		  {
//	    	      
//	    		    DatabaseMetaData metaData=connection.getMetaData();
//	    		    
//			         
//			          
//			        
//	    		  } 
//		}
//		catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		  catch (SQLException e) 
//	      {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		
		
		

	}













	private static void new_ways_to_store_url() {
		try
		{
		Properties props=new Properties();
		props.load(new FileInputStream("Data.properties"));
		String driver=props.getProperty("Data.properties");
		String url=props.getProperty("database.url");
		String user=props.getProperty("database.userName");
		String pwd=props.getProperty("database.password");
		try(Connection connection=DriverManager.getConnection(
	    		
	    		      url,user,pwd);
				// with prepared statement we can take a time once and easy way of input
	    		  PreparedStatement psInsert=connection.prepareStatement("insert into basictable values(?,?,?,?)");
				 PreparedStatement psUpdate=connection.prepareStatement("update basictable set userName=? ,password=? where userName=?");
	    		  Scanner scanner=new Scanner(System.in))
	    		  {
	    	      
	    		      System.out.println("Enter old userName");
	    		      String userName=scanner.next();
			          System.out.println("Enter the new userName");
			          String newUserName=scanner.next();
			          System.out.println("Enter the password");
			          String password=scanner.next();
			         
			          
			         
			         // psInsert.clearParameters();        
			          // because it will all input data at a time if any parameter is missed it will with previous data 
			          //in case while inputing first data if u missed it will show error
			          
			          psUpdate.setString(1, newUserName);
			          psUpdate.setString(2, password);
			          psUpdate.setString(3, userName);//this 1,2,3  are question marks in psUdate (preparedStatement).
			          
	    	          psUpdate.executeUpdate();
			          
			          
	    		  } 
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  catch (SQLException e) 
	      {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}













	private static void prepared_statement_insertion() {
		try(Connection connection=DriverManager.getConnection(
	    		  //connection_url
	    		  "jdbc:mysql://localhost:3306/ibm",
	    		  //root
	    		  "root",
	    		  //password
	    		  "Sai@1234"
	    		  );
				// with prepared statement we can take a time once and easy way of input
	    		  PreparedStatement psInsert=connection.prepareStatement("insert into basictable values(?,?,?,?)");
	    		  Scanner scanner=new Scanner(System.in))
	    		  {
	    	      
	    		      System.out.println("Enter the userName");
	    		      String userName=scanner.next();
			          System.out.println("Enter the Password");
			          String password=scanner.next();
			          System.out.println("Enter the Name");
			          String name=scanner.next();
			          System.out.println("Enter Your Email");
			          String email=scanner.next();
			         
			          psInsert.clearParameters();        
			          // because it will all input data at a time if any parameter is missed it will with previous data 
			          //in case while inputing first data if u missed it will show error
			          
			          psInsert.setString(1, userName);
			          psInsert.setString(2, password);
			          psInsert.setString(3, name);
			          psInsert.setString(4, email);
	    	          psInsert.executeUpdate();
			          
			          
	    		  } 
		
		  catch (SQLException e) 
	      {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void insert_using_statement() {
		try(Connection connection=DriverManager.getConnection(
	    		  //connection_url
	    		  "jdbc:mysql://localhost:3306/ibm",
	    		  //root
	    		  "root",
	    		  //password
	    		  "Sai@1234"
	    		  );
	    		  Statement stSelect=connection.createStatement();
	    		  Scanner scanner=new Scanner(System.in))
	    		  {
	    	      
	    		      System.out.println("Enter the userName");
	    		      String userName=scanner.next();
			          System.out.println("Enter the Password");
			          String password=scanner.next();
			          System.out.println("Enter the Name");
			          String name=scanner.next();
			          System.out.println("Enter Your Email");
			          String email=scanner.next();
			          String sql="insert into basictable values('"+ userName +"','"+ password +"','"+ name +"','"+ email +"')";
			          System.out.println(sql);
			          stSelect.executeUpdate(sql);
	    	     
	    			 
	    		  } 
		
		  catch (SQLException e) 
	      {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	private static void statement_without_finally_example2() {
		try(Connection connection=DriverManager.getConnection(
	    		  //connection_url
	    		  "jdbc:mysql://localhost:3306/ibm",
	    		  //root
	    		  "root",
	    		  //password
	    		  "Sai@1234"
	    		  );
	    		  Statement stSelect=connection.createStatement();
	    		  ResultSet result=stSelect.executeQuery("select * from basictable"))
	    		  {
	    	       while(result.next())
	    	        {
	    		  System.out.println(result.getString(1));
  			  System.out.println(result.getString("password"));
  			  System.out.println(result.getString("name"));
  			  System.out.println(result.getString(4));
	    	       }
	    			 
	    		  } 
		
		  catch (SQLException e) 
	      {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
//basic  connector method  with finally
	private static void basic_connector_method_with_finally_example1() {
		Connection connection=null;
		Statement stSelect=null;
		ResultSet result=null;
		
	      try
	    		  {
	    	   connection=DriverManager.getConnection(
		    		  //connection_url
		    		  "jdbc:mysql://localhost:3306/ibm",
		    		  //root
		    		  "root",
		    		  //password
		    		  "Sai@1234"
		    		  );
		    		stSelect=connection.createStatement();
		    		  result=stSelect.executeQuery("select * from basictable");
	    	  
	    	        
	    	       while(result.next())
	    	        {
	    		  System.out.println(result.getString(1));
    			  System.out.println(result.getString("password"));
    			  System.out.println(result.getString("name"));
    			  System.out.println(result.getString(4));
	    	       }
	    			 
	    		  } 
	      catch (SQLException e) 
	      {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      
	      finally {
	    	  try
	    	  {
	    		  if(result!=null)
	    			  result.close();
	    		  if(stSelect!=null)
	    			  stSelect.close();
	    		  if(connection!=null)
	    			  connection.close();
	    	  }
	    	  catch (SQLException e) 
		      {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	  
	      }
	}

}
