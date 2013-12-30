
package tableeasy.graphicaluserinterface.widgets;
import tableeasy.OracleDatabaseConnection.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import tableeasy.MainActivity;
import tableeasy.OracleDatabaseConnection;
import static tableeasy.OracleDatabaseConnection.connect;
import static tableeasy.graphicaluserinterface.widgets.MainTabbedPane.smine;

public class UserCreation extends JDialog
{
    private JLabel _username_label;
    private JLabel _password_label;
    private JTextField _username_textfield;
    private JPasswordField _password_textfield;
    private JButton _create_button;
     private JButton _login_button;
    private JButton _cancel_button;
    private JPanel bp;
    //  public int usernames;
     OracleDatabaseConnection conn=new OracleDatabaseConnection();
         Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
               
    public UserCreation(Frame parent)
    {
      
        
        super(parent,"USER DETAILS",true);
        
         JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        _username_label = new JLabel("User Name: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;        
        panel.add(_username_label, cs);
        
        _username_textfield = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(_username_textfield, cs);
        
        _password_label = new JLabel("      password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(_password_label, cs);
        
        _password_textfield = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(_password_textfield, cs);
         _create_button = new JButton("Create");
 
        _create_button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
              //System.out.println(getUsername()+getPassword()+getPort()+getHostname()+getDatabase());
               if(connector!=null)
               {
                   try {
                       Statement stmt1;              
                                                
                             stmt1 = connector.createStatement();
                                       
                       
                             ResultSet rs90 = stmt1.executeQuery("select * from usersr");
                      int d=1;
                             while(rs90.next())
                      {
                          d++;
                      }
                            if((_username_textfield.getText().equals(""))||(_password_textfield.getText().equals("")))
                            {
                                 JOptionPane.showMessageDialog(null,"Invalid username and password");
                            }
                            else
                            {
                       System.out.println(d);
                       
            String sins="insert into usersr values('"+_username_textfield.getText()+"'"+","+d+","+"'"+_password_textfield.getText()+"')";
            
            PreparedStatement statement= connect.prepareStatement(sins);
   statement.execute();
  
     dispose();
                   } }catch (SQLException ex) {
                       
                       JOptionPane.showMessageDialog(null,"Invalid username and password");
                       Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
      
            }
        });
        _cancel_button = new JButton("Cancel");
        _cancel_button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        _login_button=new JButton("Login");
         _login_button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                
                if(connect==null)
                {
                    JOptionPane.showMessageDialog(null,"NOT YET CONNECTED");
                }
                else
                {
                    try {
                        Statement st45=OracleDatabaseConnection.connect.createStatement();
                        String query="select * from passwordsr where username='"+_username_textfield.getText()+"'";
                       ResultSet rs12=st45.executeQuery(query);
                       while(rs12.next())
                       {
                           _password_textfield.setText(rs12.getString(2));
                       }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                     
                    try {
                        Statement stmt2;              
                                                   
                               
                              
                                String queryCheck = "SELECT * from usersr WHERE username ='"+_username_textfield.getText()+"' and password='"+_password_textfield.getText()+"'";
                                stmt2 = connector.createStatement();
            ResultSet rs91 = stmt2.executeQuery(queryCheck);
            int variables=0;
            final ResultSetMetaData metaData = rs91.getMetaData();
            if(rs91.next()) {
                tableeasy.MainActivity.usernames=Integer.parseInt(rs91.getString(metaData.getColumnName(2)));
   variables++;
}
            System.out.println(tableeasy.MainActivity.usernames);
                       if(variables!=0) { 
                           System.out.println("LOGIN");
                                        dispose();
                           JOptionPane.showMessageDialog(null,"Logged in as "+_username_textfield.getText());
                       }         
                       else
                       {
                           JOptionPane.showMessageDialog(null,"Incorrect username and password");
                       }
                        System.out.println("here:  "+tableeasy.MainActivity.usernames);
                  
   
    
                 
                       Statement stmt=connector.createStatement();
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
                        
                         ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                 
                       tableeasy.MainActivity.noofdata=i;
                      
                 /*   DatabaseSelector db=new DatabaseSelector();
           db.setLocationRelativeTo(null);
          
           db.setVisible(true);*/
             
                  
                    } catch (SQLException ex) {
                        Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
         
            }
        });
           bp = new JPanel();
        bp.add(_create_button);
        bp.add(_cancel_button);
          bp.add(_login_button);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        panel.add(_password_textfield, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
         getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
         
    }
        String getuser() {
        return _username_textfield.getText();
    }
 
     String getpassword() {
        return new String(_password_textfield.getPassword());
    }     
}
