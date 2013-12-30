package tableeasy.graphicaluserinterface.widgets;
 
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.*;
import tableeasy.OracleDatabaseConnection;
import tableeasy.TheStaticClass;
public class LoginBox extends JDialog {
 
    private JTextField input_username;
    private JPasswordField input_password;
    private JLabel label_username;
    private JLabel label_password;
    private JButton _login_button;
    private JButton _cancel_button;
    private boolean succeeded;
    private JTextField input_hostname;
    private JTextField input_port;
    private JLabel label_port;
    private JTextField input_database;
    private JLabel label_database;
    private JLabel label_hostname;
    public LoginBox()
    {
        
    }
    public LoginBox(Frame parent) 
    {
        super(parent, "Login", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        
          label_hostname = new JLabel("Hostname: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(label_hostname, cs);
        
        input_hostname = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(input_hostname, cs);
        
        label_username = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(label_username, cs);
 
        input_username = new JTextField(20);
        input_username.setText("SYSTEM");
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(input_username, cs);
 
        label_password = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panel.add(label_password, cs);
 
        input_password = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        panel.add(input_password, cs);
        
       label_port = new JLabel("           Port:");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(label_port, cs);
 
        input_port = new JTextField(4);
        input_port.setText("1521");
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(input_port, cs);
       
        label_database = new JLabel(" Database: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(label_database, cs);
 
        input_database = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(input_database, cs);              
        panel.setBorder(new LineBorder(Color.GRAY));
        
        
        _login_button = new JButton("Login");
        _login_button.setToolTipText("Click to Login.");
        _login_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              //System.out.println(getUsername()+getPassword()+getPort()+getHostname()+getDatabase());
         OracleDatabaseConnection connection = new OracleDatabaseConnection();
         TheStaticClass._static_jdbcodbc = connection;         
          TheStaticClass.printDetailsOfStaticObjects();
        if(connection.checkLogin(getHostname(),getPort(),getDatabase(),getUsername(),getPassword())!=null)
            System.out.print("\n\nConnection was Successfull");
        dispose();
            }
        });
        _cancel_button = new JButton("Cancel");
        _cancel_button.setToolTipText("Click to Cancel");
        _cancel_button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(_login_button);
        bp.add(_cancel_button);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
     String getUsername() {
        return input_username.getText().trim();
    }
 
     String getPassword() {
        return new String(input_password.getPassword());
    }
     String getHostname() {
        return input_hostname.getText().trim();
    }
     String getPort()
    {
        return input_port.getText().trim();
    }
     String getDatabase()
    {
        return input_database.getText().trim();
    }
    public boolean isSucceeded() {
        return succeeded;
    }
}
