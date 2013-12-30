package tableeasy.graphicaluserinterface.widgets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tableeasy.OracleDatabaseConnection;
 public class ExtendedToolBar extends JToolBar
{
    public JToolBar _toolbar;
    private JButton _connect_button;
    private JButton _table_add_button;
    private JButton _commit_button;
    private JButton _copy_button;
    private JButton _paste_button;
    private JButton _create_user;
    public LoginBox _loginbox;
    /**
     *
     */
    public ExtendedToolBar()
    {
        initGui();
      
    }
    private void initGui()
    {
        tableeasy.graphicaluserinterface.images.IconPack _iconpack= new tableeasy.graphicaluserinterface.images.IconPack();
        _connect_button = new JButton(_iconpack._connect_icon);        
        _connect_button.setToolTipText("New Connection");
         _table_add_button = new JButton(_iconpack._table_add_icon);        
        _table_add_button.setToolTipText("New Table");
         _table_add_button.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                  if(tableeasy.MainActivity.usernames==0)
                {
                     UserCreation  _loginbox   = new UserCreation(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
                }
                  else
                  {
          TableCreationBox _loginbox   = new TableCreationBox(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
                  }
            }
        });
         _create_user =new JButton(_iconpack._about_icon);
         _create_user.setToolTipText("create new user");
          _create_user.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
          UserCreation  _loginbox   = new UserCreation(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
            }
        });
   //     _copy_button = new JButton(_iconpack._copy_icon);
   //     _copy_button.setToolTipText("Copy");
    //    _paste_button = new JButton(_iconpack._paste_icon);
     //   _paste_button.setToolTipText("Paste");
        _commit_button = new JButton(_iconpack._commit_icon);
        _commit_button.setToolTipText("Commit");
    
        _toolbar =new JToolBar();
        _toolbar.setPreferredSize(new Dimension(100,50));
         _toolbar.add(_commit_button);
         _toolbar.add(_table_add_button);
        _toolbar.add(_connect_button);
        _toolbar.add(_create_user);
         _connect_button.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
          LoginBox _loginbox   = new LoginBox(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
            }
        });
         
             _commit_button.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    OracleDatabaseConnection.connect.commit();
                       JOptionPane.showMessageDialog(null,"Commit succesfull");
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"Commit not succesfull");
                    Logger.getLogger(ExtendedToolBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
    //    _toolbar.add(_copy_button);          
    //    _toolbar.add(_paste_button);
       
    }

   
     
     
}
