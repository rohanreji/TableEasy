
package tableeasy.graphicaluserinterface.widgets;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import tableeasy.MainActivity;
import tableeasy.OracleDatabaseConnection;
import static tableeasy.OracleDatabaseConnection.connect;
import tableeasy.TheStaticClass;
import tableeasy.graphicaluserinterface.widgets.maintabbedpane.QueryTableModel;
import tableeasy.graphicaluserinterface.widgets.maintabbedpane.TableDetails;
public class MainTabbedPane extends JTabbedPane
{   public JTabbedPane _maintabbed_pane;
    public static JPanel _startpage_panel;
    private JPanel _sqledit_panel;
    private JTextField _sqledit_textarea;
    private javax.swing.JCheckBox[] jCheckboxArray;
   // private JTextField _select_tablename;
   private JButton _execute_button=new JButton("Execute");
    private JButton _other_button;
   // private JButton _show_colomn;
    public static JButton _create_database;
    //private JButton _select_button;
    private JButton _select_databases=new JButton("Select Database");
   public static JButton admin=new JButton("Admin Console");
    public static String q;
    public static int rwcnt=0;
    QueryTableModel qtm;
    JLabel jd[]=new JLabel[100];
    JLabel jl1=new JLabel("Available Databases");
   public static JButton databasecreate=new JButton("Create Database");
   //public static javax.swing.JComboBox databasesviewer = new javax.swing.JComboBox();
    JTextField databaseviewers=new JTextField();
    public static String smine[]=new String[10];
 
 ImageIcon icon;
 ImageIcon icon2;
    public  MainTabbedPane()
    {
        setUpComponents();
          
    }
    public void setUpComponents()
   {
        tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database=new JButton("Database Manager");
        _maintabbed_pane = new JTabbedPane();
        _startpage_panel = new JPanel()
                {			
			protected void paintComponent(Graphics g)
			{
				//  Dispaly image at full size
				g.drawImage(icon.getImage(), 0, 0, null); 	
				super.paintComponent(g);
			}
		};
   
   
    _startpage_panel.setOpaque(false);
        _startpage_panel.setLayout(null);
        Dimension jsize=jl1.getPreferredSize();
   jl1.setBounds(1100,20, jsize.width,jsize.height);
   _startpage_panel.add(jl1);
       icon = new ImageIcon("F:/back.jpg");
  
		for(int k=0;k<10;k++)
                {
                    jd[k]=new JLabel();
                    jd[k].setText("rewfsefdsfsdsfsdvsv");
                    Dimension sizej=jd[k].getPreferredSize();
                    jd[k].setBounds(1100, 40+k*20,sizej.width, sizej.height);
                    _startpage_panel.add(jd[k]);
                 jd[k].setVisible(false);
                }
  
      
        _sqledit_panel = new JPanel();
   _sqledit_panel.setLayout(null);
        _sqledit_textarea = new JTextField("Enter Query");
       
        _other_button = new JButton("Queries");
   
      _other_button.setBackground(new Color(59, 89, 182));
        _other_button.setForeground(Color.WHITE);
       _other_button.setFocusPainted(false);
        _other_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        
    _other_button.setBounds(10, 285, 300, 30);
         _startpage_panel.add(_other_button);
         Dimension sized=databaseviewers.getPreferredSize();
         databaseviewers.setBounds(500, 100, 300, 30);
         databaseviewers.setText("Enter Database name here");
         _startpage_panel.add(databaseviewers);
          databaseviewers.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                databaseviewers.setText("");
            }
        });
          databasecreate.setBackground(new Color(59, 89, 182));
        databasecreate.setForeground(Color.WHITE);
        databasecreate.setFocusPainted(false);
         databasecreate.setFont(new Font("Tahoma", Font.BOLD, 12));
          databasecreate.setBounds(310,285,300,30);
          _startpage_panel.add(databasecreate);
          _create_database.setBackground(new Color(59, 89, 182));
        _create_database.setForeground(Color.WHITE);
      //  _create_database.setFocusPainted(false);
         _create_database.setFont(new Font("Tahoma", Font.BOLD, 12));
         
      
         tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.setBounds(610,285,300,30);
         tableeasy.graphicaluserinterface.widgets.MainTabbedPane._startpage_panel.add(tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database);
     //    tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.setVisible(true);
       admin.setBackground(new Color(59, 89, 182));
         admin.setForeground(Color.WHITE);
         admin.setFocusPainted(false);
          admin.setFont(new Font("Tahoma", Font.BOLD, 12));
          admin.setBounds(910,285,300,30);
          _startpage_panel.add(admin);
       //   admin.setVisible(true);
         _sqledit_textarea.setBounds(15, 10, 900, 50);
         _sqledit_panel.add(_sqledit_textarea);
         _sqledit_panel.setPreferredSize(new Dimension(1000,500));
         _sqledit_textarea.setPreferredSize(new Dimension(1000,40));
     
         final Helper1 h1=new Helper1();
         Dimension sizer=h1.getPreferredSize();
         h1.setBounds(40, 317, sizer.width, sizer.height);
         h1.setVisible(false);
         _startpage_panel.add(h1);
         _select_databases.setBounds(500,140,300,30);
         _startpage_panel.add(_select_databases);
       
        // _select_button.setVisible(false);
         icon2=new ImageIcon("F:/userdet.jpg");
             Table _table=new Table(MainActivity.usernames)
                {			

                        @Override
			protected void paintComponent(Graphics g)
			{
				//  Dispaly image at full size
				g.drawImage(icon2.getImage(), 0, 0, null); 	
				super.paintComponent(g);
			}
		};
        tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                    if(tableeasy.MainActivity.usernames==1)
                    {
                System.out.println(tableeasy.MainActivity.usernames);
                if(connect==null)
                {JOptionPane.showMessageDialog(null,"NOT YET CONNECTED");
                   
                   
                }
                else
                {
                     Databases d=new Databases();
                    d.setLocationRelativeTo(null);
          
           d.setVisible(true);
                }
                
            }
                      else
            {
                JOptionPane.showMessageDialog(null,"No Privillage");
                
            }
            }
          
         
           
        });
          
     databasecreate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(MainActivity.usernames==0)
                {
                      JOptionPane.showMessageDialog(null,"Login first.");
                    
                }
                else
                {
                    final JFrame f=new JFrame();
        f.setVisible(true);
        f.setTitle("Create Database");
        f.setLocationRelativeTo(null);
        f.setSize(500, 200);
        JPanel jp=new JPanel();
        final JTextField jt=new JTextField(20);
        JButton jb=new JButton("create");
        jp.add(jt);
        jp.add(jb);
        f.add(jp);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                  String s=jt.getText();
     
         OracleDatabaseConnection conn=new OracleDatabaseConnection();
         final Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
            Statement stmt1;              
        int fl=0;
            try {
            stmt1 = connector.createStatement();
                ResultSet rs90 = stmt1.executeQuery("select * from databaser");
                     ResultSetMetaData metaData = rs90.getMetaData();
            
                int d=1;
                             while(rs90.next())
                      {
                          d++;
                          if(jt.getText().equals(rs90.getString(metaData.getColumnName(1))))
                          {
                           fl=1;   
                          }
                      }
        } catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(fl==0)
            {
                      try {
                          Statement stmt;
                                         stmt = connector.createStatement();
                                                   f.dispose();  
                                   
                                         ResultSet rs90 = stmt.executeQuery("select distinct dbname from databaser");
                                  int d=1;
                                         while(rs90.next())
                                        {
                                      d++;
                                      }
                                         System.out.println("sdfsdfs here goes the databaseid::  "+d);
                                         int ids=0;
                                         String sqee="insert into databaser values('"+jt.getText()+"',"+0+","+d+","+MainActivity.usernames+")";
                     
                      stmt.executeUpdate(sqee);
                      MainActivity.noofdata+=1;
                      MainActivity.databases[MainActivity.noofdata]=jt.getText();
                      } catch (SQLException ex) {
                          Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                      }
            }
            
            }
        });
                
                }     }
     });
        
  
  
      
     _execute_button.setBounds(15,80,300,30);
             _sqledit_panel.add(_execute_button);
     
     ///DEMO CODE
          
      ExtendedMenuBar._search_textfield.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
            	
           Connection connector=OracleDatabaseConnection.connect;
           
           
               
                        String search_text=new String();
                        String search_query;
                        try
                        {
                              if(OracleDatabaseConnection.connect!=null)
            {
                        Statement st=connector.createStatement();
                        search_text = ExtendedMenuBar._search_textfield.getText().trim();
                      //  System.out.print("dfsfhlshldfsd");
                        
                        search_query = "select * from keywordsr where keywordname like '%"+search_text+"%'";
                         if(!(ExtendedMenuBar._search_textfield.getText().equals("")))
   
       
   {
                        try{
                        ResultSet rs = st.executeQuery(search_query);                        
                        System.out.println("commands\n--------\n");
                        System.out.println("name---description\n");
                       
                        while(rs.next()) 
                        {
				System.out.print(rs.getString("keywordname")+"\t");
				//System.out.print(rs.getString("example")+"\t");
                                System.out.print(rs.getString("descriptions")+"\n");
                               h1.setValue(rs.getString("keywordname"),rs.getString("descriptions"),rs.getString("example"));
                               h1.setVisible(true);
                              
                        }
                                 
                        }
                        catch(SQLException er)
                        {System.out.println("po");
                            er.printStackTrace();
                        }
   }
                          else
   {
       h1.setVisible(false);
   }
            }
   }
            catch(SQLException sqle)
            {
                sqle.getMessage();
                        //"jdbc:oracle:thin:@Prinz:1521:",
            }
          
            }  
        });  
      admin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(MainActivity.usernames==1)
                {
                try {
                    final JFrame jf=new JFrame();
                   jf.setVisible(true);
                   jf.setSize(900,200);
                   jf.setLocationRelativeTo(null);
                  
                    jf.setTitle("Admin Console");
                    
                   final JLabel[] jl=new JLabel[100];
                   final JLabel[] jl1=new JLabel[100];
                   final JButton[] jb=new JButton[100];
                   JPanel jp=new JPanel();
                 //  jp.setLayout(null);
                   String sq="select * from messagesforadminr";
                   final Statement st=OracleDatabaseConnection.connect.createStatement();
                   ResultSet rs=st.executeQuery(sq);
                   int i=1;
                   while(rs.next())
                   {
                       jl[i]=new JLabel();
                       jl1[i]=new JLabel();
                       jb[i]=new JButton("close");
                       jl[i].setText(rs.getString("username"));
                       jl[i].setVisible(true);
                       jl1[i].setVisible(true);
                       jb[i].setVisible(true);
                       Dimension size=jl[i].getPreferredSize();
                    //   jl[i].setBounds(10,10+40*i ,size.width,size.height);
                       jp.add(jl[i]);
                       jl1[i].setText(rs.getString("message"));
                        Dimension size1=jl1[i].getPreferredSize();
                      //   jl1[i].setBounds(10,10+50*i ,size1.width,size1.height);
                         jp.add(jl1[i]);
                        //   jb[i].setBounds(900,10+40*i,100,20);
                           jp.add(jb[i]);
                           final int k=i;
                           jb[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jl[k].setVisible(false);
                jl1[k].setVisible(false);
                jb[k].setVisible(false);
                String squery="delete messagesforadminr where message='"+jl1[k].getText()+"'";
                try {
                    st.executeUpdate(squery);
                } catch (SQLException ex) {
                    Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
                           });
                           i++;
                   }
                   JScrollPane js=new JScrollPane(jp);
                   jf.add(js);
                } catch (SQLException ex) {
                    Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else
                {
                     JOptionPane.showMessageDialog(null,"No Privillage");
                }
            }
      });
             
     databaseviewers.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {    
                try {
                    Statement stmt=OracleDatabaseConnection.connect.createStatement();
                  String squery="select * from databaser where userid="+tableeasy.MainActivity.usernames;
                  ResultSet rs = stmt.executeQuery(squery);
                          ResultSetMetaData metaData123 = rs.getMetaData();
                         
                          int i=0;
                          while(rs.next())
                          {
                              
                             MainTabbedPane.smine[i]=rs.getString(metaData123.getColumnName(1));
                             
                                tableeasy.MainActivity.databases[i+1]=rs.getString(1);
                                 System.out.println("dfsdfsdfsd::"+tableeasy.MainActivity.databases[i+1]);
                              i++;
                             
                          }
                       
            i=0;
            while(i<10){
                jd[i].setVisible(false);
                i++;
            }
                i=0;
            while(i<tableeasy.MainActivity.noofdata)
              {
              
            
                       jd[i].setText(smine[i]);   
                       jd[i].setVisible(true);
                       i++;
              
          }     } catch (SQLException ex) {
                    Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        });
       _execute_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 
                Statement stn=null;
                try {
                    stn = OracleDatabaseConnection.connect.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                }
                 if(tableeasy.MainActivity.usernames==0)
                {
                     UserCreation  _loginbox   = new UserCreation(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
                }
                 else
                 {
                 if(MainActivity.selecteddata==0)
                 {
                      JOptionPane.showMessageDialog(null,"No database has been selected");
                 }
                 else
                 {
              //System.out.println(getUsername()+getPassword()+getPort()+getHostname()+getDatabase());
                              OracleDatabaseConnection conn=new OracleDatabaseConnection();
              Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
           
                              q= _sqledit_textarea.getText().trim();
                              q=q.substring(0,q.length()-1);
                             String s[]=q.split(" ");
                             qtm = new QueryTableModel();
                             Statement st = null;
                      try {
                         st = OracleDatabaseConnection.connect.createStatement();
                     } catch (SQLException ex) {
                         Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                     }
                          if( s[0].equals("select"))
                          {
                              int  i=0;
                              while(!s[i].equals("from"))
                              {
                                  i++;
                              }
                              int k=i+1;
                              String sq="select * from tablesr where dbname='"+MainActivity.databases[MainActivity.selecteddata]+"'";
                               int fl=0;   
                                        try {
                                      
                                      ResultSet rs=stn.executeQuery(sq);
                                      
                                      while(rs.next())
                                      {
                                       if(rs.getString("tablename").equals(s[k]))
                                       {
                                           fl=1;
                                       }
                                       
                                      }
                                       } catch (SQLException ex) {
                                      Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                      if(fl==0)
                                           JOptionPane.showMessageDialog(null,"No such table");
                                      else
                                      {
                                          
                                      
                                 
                              
                              System.out.println("fdfsd");
                         
                                  try {
                                      qtm.setQuery(q);
                                  } catch (SQLException ex) {
                                      JOptionPane.showMessageDialog(null,"Command cannot be executed");
                                      Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                 // _execute_button.setVisible(false);
                                 // _sqledit_textarea.setVisible(false);
                                
                             JTable table = new JTable(qtm);
                             
                       
                           JScrollPane js=new JScrollPane(table);
                               
                          Dimension d=js.getPreferredSize();
                              js.setBounds(350,100,d.width,200);
                                   _sqledit_panel.add(js);
                                   
                                  
                          }
                          }
                         
                          else 
                          {
                                  try {
                                    int k = 0;
                                      st.executeUpdate(q);
                                       JOptionPane.showMessageDialog(null,"Command Executed");
                                       if(!s[0].equals("drop"))
                                       {
                                      int i=0;
                                      while(!s[i].equals("table"))
                                      {
                                          i++;
                                      }
                                     
                                      System.out.println("csdcs   "+i);
                                      k=i+1;
                                      String slat="select distinct tablename from tablesr";
                                      ResultSet rs=stn.executeQuery(slat);
                                      i=1;
                                      while(rs.next())
                                      {
                                          i++;
                                      }
                                      slat="insert into tablesr values ('"+s[k]+"',"+5+","+i+",'"+MainActivity.databases[MainActivity.selecteddata]+"',"+0+")";
                                      stn.executeUpdate(slat);
                                              }
                                       else
                                       {
                                           int i=0;
                                            while(!s[i].equals("table"))
                                                {
                                                       i++;
                                                 }
                                            k=i+1;
                                           String my="delete from tablesr where tablename='"+s[k]+"'";
                                           stn.executeUpdate(my);
                                       }
                                             
                                  
                                  
                                  } catch (SQLException ex) {
                                       JOptionPane.showMessageDialog(null,"Command cannot be executed");
                                      Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                          }
                                  
                 }
                 }
          /*        TableDetails screen = new TableDetails();
		
		screen.display();
		
		screen.setVisible(true);
              
                
                
               
         
               if(connector==null)
                    System.out.print("null");
               
               else
               {
                    try {
                        System.out.print("not null");
                          String query = _sqledit_textarea.getText().trim();
                          query=query.substring(0,query.length()-1);
                           System.out.print(query);
               Statement stmt;              
                                
             stmt = connector.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             while (rs.next()) {
                 
                 System.out.println(rs.getString("EMPID") + "\t" );
             }      } catch (SQLException ex) {
                        Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                    }
    
    }
                }*/
            
            }
               
        });
           
           
   _select_databases.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement st=OracleDatabaseConnection.connect.createStatement();
                    String queries="select * from databaser where dbname='"+databaseviewers.getText()+"'";
                      for(int i=1;i<=MainActivity.noofdata;i++)
                    {
                        if(databaseviewers.getText().equalsIgnoreCase(MainActivity.databases[i]))
                        {
                            MainActivity.selecteddata=i;
                        }
                    }
                   
                } catch (SQLException ex) {
                    Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //tableeasy.MainActivity.selecteddata=Integer.parseInt(databases.getSelectedItem().toString());
            }
   });
             ///DEMOCODES
    
       
     
         
       
            
                  JScrollPane pane = new JScrollPane(_startpage_panel); 
                   _maintabbed_pane.add(pane,"Start Page");    
                   pane.setVisible(true);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                _maintabbed_pane.add(_sqledit_panel,"Sql Edit");
      _maintabbed_pane.add(_table,"User Details");
               _other_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(tableeasy.MainActivity.usernames==0)
                 {                  UserCreation  _loginbox   = new UserCreation(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
               
                }
                else
                {
                    if(MainActivity.selecteddata==0)
                    {
                         JOptionPane.showMessageDialog(null,"Select a database");
                    }
                    else{
                System.out.println(tableeasy.MainActivity.usernames);
           OtherQueries oq=new OtherQueries();
           oq.setLocationRelativeTo(null);
          
           oq.setVisible(true);
          //  oq.setTitle("MORE QUERIES");
            }}}
        });
               
             
   }
       
   public String returnSqlEditText()
   {
       return _sqledit_textarea.getText();
   }
 
 }
