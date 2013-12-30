/*--inside package tableeasy--*/
package tableeasy;
/*--*/
/*--imports--*/
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import tableeasy.graphicaluserinterface.widgets.LoginBox;
import tableeasy.graphicaluserinterface.widgets.MainTabbedPane;
/**/
/*class for connecting to sql server*/
public class OracleDatabaseConnection 
{
    public  static Connection connect=null;
     public Statement stmt = null;
 
    public  OracleDatabaseConnection()
    {
         System.out.println("-------- Oracle JDBC Connection Testing ------");
         try 
         {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             System.out.println("Oracle JDBC Driver Registered!");
         } 
         catch (ClassNotFoundException e) 
         {
             System.out.println("Where is your Oracle JDBC Driver?");
             e.printStackTrace();
             return;
         }		
          connect = null; 
         
    }
    public static String hostn,portn,databasen,usern,passn;
    /*login function to connect to server*/
     public Connection checkLogin(String hostname,String port,String database,String username,String password)
    {
    try 
         {
             hostn=hostname;
              portn=port;
              databasen=database;
              usern=username;
              passn=password;
               if(connect == null || connect.isClosed())
               {
             connect = DriverManager.getConnection(
					"jdbc:oracle:thin:@"+hostname+":"+port+":"+database,username,
					password);
                        System.out.println("Entered detals was correct.");
                        
      
           
     
                        Statement st=connect.createStatement();
                        DatabaseMetaData meta = connect.getMetaData();
                        ResultSet rs1=meta.getTables(null, null, "TABLESR", null); 
                         System.out.println("Entered detals was correct.");
       
                             ResultSet rs2=meta.getTables(null, null, "DATABASER", null); 
                              ResultSet rs3=meta.getTables(null, null, "RECENTTABLESR", null); 
                               ResultSet rs4=meta.getTables(null, null, "USERSR", null); 
                                ResultSet rs5=meta.getTables(null, null, "PASSWORDSR", null); 
                                 ResultSet rs6=meta.getTables(null, null, "RECENTCOMMANDSR", null); 
                                  ResultSet rs7=meta.getTables(null, null, "KEYWORDSR", null); 
                                  ResultSet rs8=meta.getTables(null,null, "MESSAGESFORADMINR",null);
                        stmt = connect.createStatement();
                        if(!rs1.next()){ 
                            System.out.println("NO\n--------\n");
                       
      
      String sql1 = "CREATE TABLE TABLESR " +
                   "(Tablename VARCHAR(200) NOT NULL, " +
                   " NoOfColomns int, " + 
                   " TableId INT, " +"Dbname varchar(200),recentlyused int default 0," +
                    " PRIMARY KEY ( TableId ))"; 

      stmt.executeUpdate(sql1);
      
                        }
      
                     
                        else{
                               System.out.println("yes\n--------\n");
                                }
                        
       
                        if(!rs2.next()){ 
                            System.out.println("NO\n--------\n");
                          
                               
      String sql2 = "CREATE TABLE DATABASER " +
                   "(DBname VARCHAR(200) NOT NULL," +
                   "sizer int," + 
                   " DBId INT," +"userid int," +
                    " PRIMARY KEY (userid,DBId))"; 
   stmt.executeUpdate(sql2);
        
                         } 
                          if(!rs3.next()){ 
                            System.out.println("NO\n--------\n");
                          
                               
      String sql3 = "CREATE TABLE RECENTTABLESR " +
                   "(TABLEname VARCHAR(200) NOT NULL," +
                   "TABLEID int," + 
                   "username varchar(200)," +
                    " PRIMARY KEY (TABLEID))"; 
   stmt.executeUpdate(sql3);
        
                         } 
                           if(!rs4.next()){ 
                            System.out.println("NO\n--------\n");
                          
                               
      String sql4 = "CREATE TABLE USERSR " +
                   "(USERname VARCHAR(200) NOT NULL UNIQUE," +
                   "USERID int," + 
                   "PASSWORD varchar(200)," +
                    " PRIMARY KEY (USERID))"; 
   stmt.executeUpdate(sql4);
         Statement stmt1;              
                                             
                          stmt1 = connect.createStatement();
                                    
                                          ResultSet rs90 = stmt1.executeQuery("select * from usersr");
                    int d=rs90.getRow();
         String sins="insert into usersr values('"+username+"'"+","+d+1+","+"'"+password+"')";
         
         PreparedStatement statement= connect.prepareStatement(sins);
statement.execute();
         
                         } 
                            if(!rs5.next()){ 
                            System.out.println("NO\n--------\n");
                          
                               
      String sql5 = "CREATE TABLE PASSWORDSR " +
                   "(PASSWORD VARCHAR(200) NOT NULL," +
                     "username varchar(200)," +
                    " PRIMARY KEY (USERNAME))"; 
   stmt.executeUpdate(sql5);
        
                         } 
        if(!rs6.next()){ 
                            System.out.println("NO\n--------\n");
                          
                               
      String sql6 = "CREATE TABLE RECENTCOMMANDSR " +
                   "(COMMANDNAME VARCHAR(200) NOT NULL," +
                     "username varchar(200)," +
                    " PRIMARY KEY (USERNAME))"; 
   stmt.executeUpdate(sql6);
        
                         } 
        
         if(!rs7.next()){ 
                            System.out.println("NO\n--------\n");
                          
                               
      String sql7 = "CREATE TABLE KEYWORDSR " +
                   "(KEYWORDNAME VARCHAR(200) NOT NULL," +
                   "KEYWORDID int," + 
                   "DESCRIPTIONS varchar(200)," +"EXAMPLE VARCHAR(200),"+
                    " PRIMARY KEY (KEYWORDID))"; 
   stmt.executeUpdate(sql7);
   String squery="insert into keywordsr values('update',2,'update table contents we can modify a cell value using this command','update table tablename set coloumnname=newvalue;')";
   stmt.executeUpdate(squery);
  squery="insert into keywordsr values('select',1,'select command is used to select rows according to certain conditions','select * from tablename where conditions;')";
   stmt.executeUpdate(squery);
   squery="insert into keywordsr values('create',3,'create table can be used to create a table with coloumn names given as attributes','create table tablename(coloumnname1 coloumntype1 constraint1,...);')";
      stmt.executeUpdate(squery);
      squery="insert into keywordsr values('drop',4,'drop table can be used to drop a table completely from the database','drop table tablename;')";
      stmt.executeUpdate(squery);
      squery="insert into keywordsr values('delete',5,'delete table can be used to select rows from table given as a parameter','delete tablename where condition;') ";
      stmt.executeUpdate(squery);


        
                         } 
        if(!rs8.next())
        {
            String sql8="CREATE TABLE MESSAGESFORADMINR "+"(MESSAGE VARCHAR(200),USERNAME VARCHAR(20))";
             stmt.executeUpdate(sql8);
            
        }
                        ResultSet rs = st.executeQuery("select * from professor");
                        System.out.println("mytable\n--------\n");
                        while(rs.next()) 
                        {
				System.out.print(rs.getString("name")+"\n");
				
			}
                      
               }
                            //"jdbc:oracle:thin:@Prinz:1521:",
            }
            catch (SQLException e)
            {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
            }
 
            if (connect != null)           
			System.out.println("You made it, take control your database now!");
            else 
			System.out.println("Failed to make connection!");		      
            return connect;
	}
     public void createUser(String Username,String Password) throws SQLException
     {
       System.out.println(passn);
       connect=DriverManager.getConnection(
					"jdbc:oracle:thin:@"+hostn+":"+portn+":"+databasen,usern,
					passn);
       
          Statement put=connect.createStatement();
          put.execute("CREATE USER "+Username+" identified by "+Password);
        
     }
     public void closeConnection()
     {
         try
         {
         connect.close();
         }
         catch(SQLException e)
         {
             
         }
     }
    }        
/*----*/
