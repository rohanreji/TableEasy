/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableeasy.graphicaluserinterface.widgets;

import java.awt.Frame;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static tableeasy.graphicaluserinterface.widgets.TableCreationBox._table_name;

/**
 *
 * @author Rohan
 */
public class CreateTable extends JDialog {
    TableCreationBox p;
    int no=p._col_no;
    String name=p._table_name ;
    JTextField[] textFields;
    JCheckBox[] pkey ;
    JCheckBox[] uniq ;
   public CreateTable(Frame parent)
   {
         super(parent, "CREATE", true);
       JPanel panel = new JPanel();
       textFields = new JTextField[no+1];
       pkey = new JCheckBox[no+1];
       uniq = new JCheckBox[no+1];
       for(int i=1;i<=no;i++)
       {
            panel.add(textFields[i]);
           textFields[i].setVisible(true);
          
       }
        getContentPane().add(panel);
     pack();
     
        setLocationRelativeTo(parent);
   }
    
}
