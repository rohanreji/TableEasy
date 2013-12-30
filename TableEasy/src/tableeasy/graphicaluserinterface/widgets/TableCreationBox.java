
package tableeasy.graphicaluserinterface.widgets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import tableeasy.graphicaluserinterface.widgets.maintabbedpane.TableDetails;
import tableeasy.OracleDatabaseConnection;
import static tableeasy.graphicaluserinterface.widgets.MainTabbedPane.rwcnt;

public class TableCreationBox extends JDialog
{
    JFrame frame;
    JPanel p;
     public static String _table_name;
      public static int _col_no;
    private JLabel _tablename_label;
    private JLabel _no_of_columns_label;
    private JTextField _tablename_textfield;
    private JTextField _no_of_columns_textfield;
    private JButton _create_button;
    private JButton _cancel_button;
    private JPanel bp;
   private JButton jb;

    JTextField [] textfields = new JTextField[100];
   JTextField [] type= new JTextField[100];
     JTextField[] size= new JTextField[100];
     JRadioButton[] ckdb=new JRadioButton[100];
  JTextField[] def=new JTextField[100];
     private GridBagLayout mainLayout ;
         private GridBagConstraints mainCons;
private HashMap componentMap;
   JCheckBox[] pkey=new JCheckBox[100] ;
   JCheckBox [] notnull =new JCheckBox[100];
   JCheckBox [] uniq =new JCheckBox[100];
   JTextField check=new JTextField(10);
  
    public TableCreationBox(Frame parent)
    {
        super(parent,"Table Details",true);
         jb=new JButton();
         JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
         check.setText("Check");
        _tablename_label = new JLabel("Table Name: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;        
        panel.add(_tablename_label, cs);
        
        _tablename_textfield = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(_tablename_textfield, cs);
        
        _no_of_columns_label = new JLabel("      Columns: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(_no_of_columns_label, cs);
        
        _no_of_columns_textfield = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(_no_of_columns_textfield, cs);
         _create_button = new JButton("Create");
 
        _create_button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
              mainLayout= new GridBagLayout();
              mainCons = new GridBagConstraints();

              //System.out.println(getUsername()+getPassword()+getPort()+getHostname()+getDatabase());
       _table_name=_tablename_textfield.getText();
       
      
       _col_no=Integer.parseInt(_no_of_columns_textfield.getText());
       dispose();
        
      
        jb.setText("CREATE");
      frame=new JFrame("CREATE TABLE");
  
        frame.setSize(700,400);
          frame.setVisible( true );
     JLabel jl=new JLabel(_table_name.toUpperCase());
      JLabel label1=new JLabel("COLOUMN NAME");
      JLabel label2=new JLabel("TYPE");
      JLabel label3=new JLabel("SIZE");
     // JLabel labeld=new JLabel("");
       p=new JPanel();
       p.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       frame.setLocationRelativeTo(null);
       
       c.gridx = 1;
c.gridy = 0;
     p.add(jl,c);
     
     
     c.gridx = 0;
c.gridy = 2;
p.add(label1,c);
 c.gridx = 1;
c.gridy = 2;
p.add(label2,c);
 c.gridx = 2;
c.gridy = 2;
p.add(label3,c);
     
      for(int i=1;i<=_col_no;i++)
      {
          
         // textfields=new JTextField();
 textfields[i] = new JTextField(10);
          type[i]=new JTextField(10);
          size[i]=new JTextField(10);
          notnull[i]=new JCheckBox();
          pkey[i]=new JCheckBox();
          uniq[i]=new JCheckBox();
         def[i]=new JTextField(10);
         def[i].setText("Default");
          pkey[i].setText("primarykey");
              uniq[i].setText("unique");
              notnull[i].setText("not null");
    // textfields.setName(name+i);
  //  JTextField textfields.getname();
    //=new JTextField();
         
          c.gridx = 0;
c.gridy = i+2;
          p.add(textfields[i],c);
          c.gridx = 1;
c.gridy = i+2;
          p.add(type[i],c);
          c.gridx = 2;
c.gridy = i+2;
          
          p.add(size[i],c);
          c.gridx = 3;
c.gridy = i+2;
          p.add(pkey[i],c);
          c.gridx = 4;
c.gridy = i+2;
          p.add(uniq[i],c);
            c.gridx = 5;
c.gridy = i+2;
          p.add(notnull[i],c);
             c.gridx = 6;
c.gridy = i+2;
          p.add(def[i],c);
          textfields[i].setVisible(true);
           type[i].setVisible(true);
            size[i].setVisible(true);
           pkey[i].setVisible(true);
            uniq[i].setVisible(true);
            def[i].setVisible(true);
            def[i].setSize(500,30);
           textfields[i].setSize(500,30);
           type[i].setSize(200,30);
           size[i].setSize(100,30);
          
      }
      check.setVisible(true);
      c.gridx = 4;
c.gridy = _col_no+4;
       p.add(check,c);      
         c.gridx = 4;
c.gridy = _col_no+7;
       p.add(jb,c);
       // For JDK 1.7 or above.
                //frame.getContentPane().revalidate(); // For JDK 1.6 or below.
                  JScrollPane pane = new JScrollPane(p); 
                       frame.add(pane);    
                       pane.setVisible(true);
            pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

             
            }
        });
        
        _cancel_button = new JButton("Cancel");
        _cancel_button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
               
                dispose();
            }
            
        });
      jb.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                OracleDatabaseConnection conn=new OracleDatabaseConnection();
                  Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
                 
                  if(connector==null)
                  {
                    JOptionPane.showMessageDialog(null,"NOT CONNECTED");
                  }
                  else
                  {
                  Statement stmt=null;
                
      
                   
      
                
                String s="create table "+_table_name+"(";        
                String s2=" ";
           for(int i=1;i<=_col_no;i++)
           {
               s=s.concat(textfields[i].getText());
               s=s+" ";
               s=s.concat(type[i].getText());
               
               if(!(size[i].getText().isEmpty()))
                       {
                           s=s+"( ";
                           s=s.concat(size[i].getText());
                            s=s+" )";
                       }
               s=s+"";
               if(uniq[i].isSelected())
               {
                  
                  s=s+" ";
                  s=s.concat("unique");
               }
                   if(notnull[i].isSelected())
                 {
                      s=s+" ";
                  s=s.concat("not null ");
                     
                 }
              if((def[i].getText().equals(""))&&!(def[i].getText().equals("Default")))
              {
                  s=s+" ";
                  s=s+"default ";
                  if(!isInteger(def[i].getText()))
                      s=s+"'"+def[i].getText()+"'";
                  else
                     s=s+def[i].getText();
                  
              }
               if(pkey[i].isSelected())
               {
                    
                   s2=s2.concat(textfields[i].getText());
                   s2=s2+",";
               }
             s=s+",";
                       }
            s=s.substring(0,s.length()-1);
           s2=s2.substring(0,s2.length()-1);
           System.out.println(s2);
           if(s2.length()>=1)
                    {
                        
           s=s+",primary key";
           s=s+"(";
           s=s.concat(s2);
           s=s+")";
                    }  
            else
           {
               JOptionPane.showMessageDialog(null,"No primary Key set");
           }
           if(!(check.getText().equals("Check"))&&!(check.getText().equals("")))
           {
               s=s+",check ("+check.getText()+")";
           }
          
                    s=s+")";
                try {
                    try {
                    stmt = connector.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(TableCreationBox.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println(s);
                    stmt.executeUpdate(s);
                    
                    /////DEMO CODE BEGINS
                      frame.dispose();
                      final JFrame select_databases = new JFrame("Select Database");
                       select_databases.setSize(700,400);
          select_databases.setVisible( true );
         JPanel p1=new JPanel();
       p1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
       select_databases.setLocationRelativeTo(null);
     
               String demoq="select * from databaser where userid="+tableeasy.MainActivity.usernames;
                                      ResultSet rs90 = stmt.executeQuery(demoq);
                        ResultSetMetaData metaData = rs90.getMetaData();
            
                int d=1;
                 ButtonGroup bG = new ButtonGroup();

//select_databases.add(bG);
                             while(rs90.next())
                      {
                           ckdb[d]=new JRadioButton();
                         
                         ckdb[d].setText(rs90.getString(metaData.getColumnName(1)));
                         ckdb[d].setVisible(true);
                         bG.add(ckdb[d]);
                     
                         d++;
                      }
                             final int klo=d;
                             for(int i=1;i<klo;i++)
                             {
                                 
                                    c.gridx=0;
                        c.gridy=i;
                         p1.add(ckdb[i],c);
                             }
                             JButton create=new JButton("CREATE TABLE");
                              c.gridx=0;
                        c.gridy=d;
                         p1.add(create,c);
                                 JScrollPane pane = new JScrollPane(p1); 
                       select_databases.add(pane);    
                       pane.setVisible(true);
            pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
create.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                try {
                   select_databases.dispose();
                    OracleDatabaseConnection conn=new OracleDatabaseConnection();
                      Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
                     Statement stmt2=connector.createStatement();
                        System.out.println("nmnmnmnm:"+klo);
                                 ResultSet rs90 = stmt2.executeQuery("select * from tablesr");
                          int dk=1;
                                 while(rs90.next())
                          {
                              dk++;
                          }
                        
                                 String[] s1 = new String[100];
                    
                        for(int i=1;i<klo;i++)
                      {
                          
                          if( ckdb[i].isSelected() )
                          {
                              s1[i]=ckdb[i].getText();
                          
                          
                                
                   
                        System.out.println(s1[i]);
                String _insert_table="insert into tablesr values('"+_table_name+"',"+_col_no+","+dk+",'"+s1[i]+"',"+0+")";
                        try {
                            stmt2.executeQuery(_insert_table);
                        } catch (SQLException ex) {
                            Logger.getLogger(TableCreationBox.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                      }
                              //////DEMO CODE ENDS
                } catch (SQLException ex) {
                    Logger.getLogger(TableCreationBox.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
});
                        
                            
                          
                    JOptionPane.showMessageDialog(null,"TABLE "+_table_name+" CREATED");
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"INVALID TABLE");
                    Logger.getLogger(TableCreationBox.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        });
           bp = new JPanel();
        bp.add(_create_button);
        bp.add(_cancel_button);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        panel.add(_no_of_columns_textfield, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
         getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
            private void createComponentMap() {
        componentMap = new HashMap<String,Component>();
        Component[] components = frame.getContentPane().getComponents();
        for (int i=0; i < components.length; i++) {
                componentMap.put(components[i].getName(), components[i]);
        }
        
}
            public Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
}
            public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    }
    // only got here if we didn't return false
    return true;
}
}
