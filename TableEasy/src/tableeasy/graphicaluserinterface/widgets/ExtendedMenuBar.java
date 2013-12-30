
package tableeasy.graphicaluserinterface.widgets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import tableeasy.MainActivity;
import tableeasy.OracleDatabaseConnection;
import static tableeasy.graphicaluserinterface.widgets.MainTabbedPane._startpage_panel;
 public class ExtendedMenuBar extends JMenuBar 
{   /*menu components including menubar,menus and menuitems*/
    public JMenuBar _menubar;/*menubar component*/
    /*menus*/
    private JMenu _file_menu;
 //   private JMenu _edit_menu;
    private JMenu _new_menu;
    private JMenu _view_menu;
    private JMenu _help_menu;
    private JMenu _about_menu;
    private JMenu _recent_menu;
    /*menuitems*/
    private JMenuItem _connect_menuitem;
    private JMenuItem _table_menuitem;
    private JMenuItem _commit_menuitem;
    private JMenuItem _exit_menuitem;
    private JMenuItem _copy_menuitem;
    private JMenuItem _paste_menuitem;
    private JMenuItem _databases_menuitem;
    private JMenuItem _recenttable_menuitem;
    private JMenuItem _database_menuitem;
    private JMenuItem _helpcontents_menuitem;
    private JMenuItem _table_add_menuitem;
    private JMenuItem _aboutus_menuitem;
    private JMenuItem _reportbug_menuitem;
    private JMenuItem _easytable_menuitem;  
    private JMenuItem _feedback_menuitem;
    /*buttons*/
    private JButton _search_button;
     
    /*iconpack instance */
    private  tableeasy.graphicaluserinterface.images.IconPack _iconpack;
    /*font objects*/
    private Font _menu_font;
    private Font _menuitem_font;
    /*textfields*/
    public static JTextField _search_textfield=new JTextField();
   public ExtendedMenuBar()
   {
       initGui();
   }
    private void initGui()
    {
        _menu_font = new Font("ArialBlack", Font.PLAIN, 15);
        _menuitem_font = new Font("Arial", Font.PLAIN, 14);
        _iconpack = new tableeasy.graphicaluserinterface.images.IconPack();
        /*menus allocation*/
        _menubar = new JMenuBar();
        _file_menu = new JMenu("File");
    //    _edit_menu = new JMenu("Edit");
        _view_menu = new JMenu("View");
        _new_menu = new JMenu("New");
        _help_menu = new JMenu("Help");
        _about_menu = new JMenu("About");
        _recent_menu = new JMenu("Recent");
        _recent_menu.setFont(_menuitem_font);
        /*menuitem allocation*/
        _commit_menuitem = new JMenuItem("Commit",_iconpack._commit_icon);
        _commit_menuitem.setFont(_menuitem_font);
        _exit_menuitem = new JMenuItem("Exit",_iconpack._exit_icon);
        _exit_menuitem.setFont(_menuitem_font);
        /*event listener for exit menuitem*/
        _exit_menuitem.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            System.exit(0);  
            }
        });
        _commit_menuitem.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    OracleDatabaseConnection.connect.commit();
                     JOptionPane.showMessageDialog(null,"Commit completed");
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"Some error Cannot commit");
                    Logger.getLogger(ExtendedMenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        _table_menuitem = new JMenuItem("Table(s)",_iconpack._table_icon);
        _table_menuitem.setFont(_menuitem_font);
        _connect_menuitem = new JMenuItem("Connection",_iconpack._connect_icon);
        _connect_menuitem.setFont(_menuitem_font);
        _database_menuitem = new JMenuItem("Database(s)",_iconpack._database_icon);
        _database_menuitem.setFont(_menuitem_font);
        _databases_menuitem = new JMenuItem("Databases",_iconpack._databases_icon);
        _databases_menuitem.setFont(_menuitem_font);
        _copy_menuitem = new JMenuItem("Copy",_iconpack._copy_icon);
        _copy_menuitem.setFont(_menuitem_font);
        _paste_menuitem = new JMenuItem("Paste",_iconpack._paste_icon);
        _paste_menuitem.setFont(_menuitem_font);
        _table_add_menuitem = new JMenuItem("Table",_iconpack._table_add_icon);
        _table_add_menuitem.setFont(_menuitem_font);
        _aboutus_menuitem = new JMenuItem("About Us",_iconpack._about_icon);
        _aboutus_menuitem.setFont(_menuitem_font);
        _easytable_menuitem = new JMenuItem("TableEasy",_iconpack._easytable_icon);
        _easytable_menuitem.setFont(_menuitem_font);
        _reportbug_menuitem = new JMenuItem("Report Bug",_iconpack._reportbug_icon);
        _reportbug_menuitem.setFont(_menuitem_font);
        _helpcontents_menuitem = new JMenuItem("Help Contents",_iconpack._help_icon);
        _helpcontents_menuitem.setFont(_menuitem_font);
        _feedback_menuitem = new JMenuItem("Message Admin",_iconpack._feedback_icon);
        _feedback_menuitem.setFont(_menuitem_font);
        /*search input */
      //  _search_textfield = new JTextField();
        _search_textfield.setPreferredSize(new Dimension(100,20));
        _search_button = new JButton("Search");
        //_search_textfield.setPreferredSize(new Dimension(100,20));
        //_search_button.setMargin(new Insets(0,0,0,0));
        
      
        /*menu forming*/
        //_menubar.setLayout();
        _menubar.add(_file_menu);
//        _menubar.add(_edit_menu);
        _menubar.add(_new_menu);
        _menubar.add(_view_menu);
        _menubar.add(_help_menu);
        _menubar.add(_about_menu);
        _menubar.add(_search_textfield,BorderLayout.LINE_END);
//        _search_textfield.setPreferredSize(new Dimension(50,50));
       // _search_textfield.setVisible(false);
        _menubar.add(_search_button);
      //  _search_button.setVisible(false);
      /*  _search_button.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                OracleDatabaseConnection conn=new OracleDatabaseConnection();
                  Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
               if(connector==null)
               {
                   JOptionPane.showMessageDialog(null,"NOT YET CONNECTED");
               }
            }}
                );*/
   /*  _search_textfield.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
            	
           
                  OracleDatabaseConnection conn=new OracleDatabaseConnection();
                  Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
                        String search_text=new String();
                        String search_query;
                        try
                        {
                        Statement st=connector.createStatement();
                        search_text = _search_textfield.getText().trim();
                      //  System.out.print("dfsfhlshldfsd");
                        
                        search_query = "select * from keywordsr where keywordname like '%"+search_text+"%'";
                        try{
                        ResultSet rs = st.executeQuery(search_query);                        
                        System.out.println("commands\n--------\n");
                        System.out.println("name---description\n");
                        
                        while(rs.next()) 
                        {
				System.out.print(rs.getString("keywordname")+"\t");
				//System.out.print(rs.getString("example")+"\t");
                                System.out.print(rs.getString("descriptions")+"\n");
                             //  h1.setValue(rs.getString("keywordname"),rs.getString("descriptions"),rs.getString("example"));
                             
                           //      Helper1 h1=new Helper1(rs.getString("keywordname"),rs.getString("descriptions"),rs.getString("example"));
 // Dimension sizer=h1.getPreferredSize();
 // h1.setBounds(40, 300, sizer.width, sizer.height);
 
 // _startpage_panel.add(h1);
                        }
                        }
                        catch(SQLException er)
                        {System.out.println("po");
                            er.printStackTrace();
                        }
            }
            catch(SQLException sqle)
            {
                sqle.getMessage();
                        //"jdbc:oracle:thin:@Prinz:1521:",
            }
          
            }  
        });   */
        _feedback_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(MainActivity.usernames==0)
                {
                     JOptionPane.showMessageDialog(null,"Login First,to send feedback");
                }
                else
                {
                final JFrame jf=new JFrame();
                jf.setVisible(true);
                jf.setSize(900,500);
                jf.setLocationRelativeTo(null);
                final JTextArea jt=new JTextArea();
        
                jt.setSize(800,300);
                JButton jb=new JButton("Send");
                JPanel jp=new JPanel();
                jp.setLayout(null);
                jt.setBounds(10,10,870,300);
                jp.add(jt);
                jb.setBounds(500,340,100,30);
                jp.add(jb);
                jf.add(jp);
                jt.setText("Message in 120 words.");
                jt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                jt.setText("");
            }
        });
           jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String myname=new String();
                    Statement st=OracleDatabaseConnection.connect.createStatement();
                    String snew="select * from usersr where userid="+MainActivity.usernames;
                    ResultSet rs=st.executeQuery(snew);
                    while(rs.next())
                    {
                    myname=rs.getString("username");
                        
                    }
                    String sqlq="insert into messagesforadminr values('"+jt.getText()+"','"+myname+", ')";
                    st.executeUpdate(sqlq);
                    jf.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(ExtendedMenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
           });
    }}
            
        });
_aboutus_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Aboutus aboutus = new Aboutus();
                aboutus.setVisible(true);
               aboutus.pack();
                aboutus.setLocationRelativeTo(null);
            //    aboutus.setSize(1350, 300);
         
            }
       });
 _helpcontents_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Helpcontents aboutus = new Helpcontents();
                aboutus.setVisible(true);
               aboutus.pack();
                aboutus.setLocationRelativeTo(null);
            //    aboutus.setSize(1350, 300);
         
            }
       });
            
         _search_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                OracleDatabaseConnection conn=new OracleDatabaseConnection();
                  Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
               if(connector==null)
               {
                   JOptionPane.showMessageDialog(null,"NOT YET CONNECTED");
               }
               else
               {
                   
                                try
                        {
                        Statement st=connector.createStatement();
                        String search_text = _search_textfield.getText().trim();
                      //  System.out.print("dfsfhlshldfsd");
                        
                      String search_query = "select * from keywordsr where keywordname like '%"+search_text+"%'";
                        try{
                        ResultSet rs = st.executeQuery(search_query);                        
                        System.out.println("commands\n--------\n");
                        System.out.println("name---description\n");
                        
                        while(rs.next()) 
                        {
				System.out.print(rs.getString("keywordname")+"\t");
				//System.out.print(rs.getString("example")+"\t");
                                System.out.print(rs.getString("descriptions")+"\n");
                            
                                   Helper h1=new Helper(rs.getString("keywordname"),rs.getString("descriptions"),rs.getString("example"));
h1.setVisible(true);
h1.setLocationRelativeTo(null);
                        }
                        }
                        catch(SQLException er)
                        {System.out.println("po");
                            er.printStackTrace();
                        }
            }
            catch(SQLException sqle)
            {
                sqle.getMessage();
                        //"jdbc:oracle:thin:@Prinz:1521:",
            }
                  
               }
            }}
                );
        //_search_textfield.BorderLayout();
        //_search_textfield.setPreferredSize(new Dimension(100,30));
       // _search_button.setPreferredSize(new Dimension(100,30));
        /*file menuitems forming*/
        _file_menu.add(_commit_menuitem);
        _file_menu.add(_exit_menuitem);
        _file_menu.setFont(_menu_font);
        
        /*edit menu items forming*/
//        _edit_menu.add(_copy_menuitem);
     //   _edit_menu.add(_paste_menuitem);
      //  _edit_menu.setFont(_menu_font);
        /*new menu items forming*/
        _new_menu.add(_connect_menuitem);
        _new_menu.add(_table_add_menuitem);
        _new_menu.setFont(_menu_font);
        _table_add_menuitem.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
          TableCreationBox _loginbox   = new TableCreationBox(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
            }
        });
         _connect_menuitem.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
          LoginBox _loginbox   = new LoginBox(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
            }
        });
        /*view menu items forming*/
  //     _view_menu.add(_databases_menuitem);
        _view_menu.add(_recent_menu);
        _view_menu.setFont(_menu_font);
        _recent_menu.add(_table_menuitem);
    //    _recent_menu.add(_database_menuitem);
        /*help menu forming*/
        _help_menu.add(_helpcontents_menuitem);
        _help_menu.setFont(_menu_font);
        /*about menu forming*/
        _about_menu.add(_aboutus_menuitem);
      //  _about_menu.add(_easytable_menuitem);
       // _about_menu.add(_reportbug_menuitem);
         _about_menu.add(_feedback_menuitem);
        _about_menu.setFont(_menu_font);
              // this.add(_menubar);
        _menubar.setPreferredSize(new Dimension(1300,30));
      _table_menuitem.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                RecentTables ne=new RecentTables();
                ne.setVisible(true);
                ne.setLocationRelativeTo(null);
            }
       });
    }
}
