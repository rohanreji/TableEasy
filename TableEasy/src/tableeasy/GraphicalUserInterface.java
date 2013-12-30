
package tableeasy;
//import tableeasy.graphicaluserinterface.widgets;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import tableeasy.graphicaluserinterface.widgets.MainTabbedPane;
import tableeasy.graphicaluserinterface.widgets.ExtendedToolBar;
import tableeasy.graphicaluserinterface.widgets.ExtendedMenuBar;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GraphicalUserInterface extends JFrame       
{
    public static JFrame _mainframe;
    public JPanel _container_panel;
    private JPanel _sqledit_panel;
    private JPanel _start_panel;
    private JPanel _gui_panel;
    private JTabbedPane _main_pane;
    private JButton _run_button;
    private JButton _execute_button;
    public JTextArea _sqledit_textarea;
    private MainTabbedPane _tabbed_pane;
    ExtendedMenuBar _menustructure ;
    ExtendedToolBar _toolbarstructure ;
    public GraphicalUserInterface()
    {
        runMe();/*packing all gui components*/       
    }
    private void  runMe()
    {
          _mainframe= new JFrame();
        _mainframe.setTitle("EasyTable");
        _tabbed_pane = new MainTabbedPane();
        _menustructure = new  ExtendedMenuBar();
        _toolbarstructure = new ExtendedToolBar();
        _mainframe.setJMenuBar(_menustructure._menubar);       
        _mainframe.add(_toolbarstructure._toolbar,BorderLayout.NORTH);
        _mainframe.add(_tabbed_pane._maintabbed_pane);   
      
      _mainframe.pack();
        _mainframe.setLocationRelativeTo(null); 
        _mainframe.setVisible(true);        
        _mainframe.getContentPane().revalidate();
        _mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);     
    }
    public MainTabbedPane returnMaintabbedPane()
    {
        
      return this._tabbed_pane;  
    }
}

