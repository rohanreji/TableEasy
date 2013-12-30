/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableeasy.graphicaluserinterface.widgets.maintabbedpane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.*;
import tableeasy.graphicaluserinterface.widgets.MainTabbedPane;

public class TableDetails extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 350;
//	MainTabbedPane p=new MainTabbedPane();
	private JTextField sqlQuery;
        
	
	QueryTableModel qtm;
	
	public void display()
	{

	setSize(WIDTH,HEIGHT);
	
	setResizable(false);
	setLayout(new FlowLayout());
	
	JPanel inputPanel = new JPanel();
	inputPanel.setLayout(new GridLayout(0,2));
	
	inputPanel.add(new JLabel(""));
	inputPanel.add(new JLabel(""));
	
	sqlQuery = new JTextField(MainTabbedPane.q);
	sqlQuery.setBackground(Color.WHITE);
	inputPanel.add(sqlQuery);
	
	
	
	JButton Execute = new JButton("Execute");
	inputPanel.add(Execute);
            
                Execute.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                try {
                                        qtm.setQuery(sqlQuery.getText().trim());
                                } catch (SQLException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                }
                        }
                });
                
	
	
	
	

	qtm = new QueryTableModel();
	JTable table = new JTable(qtm);

JScrollPane scrollpane = new JScrollPane(table);
	JPanel tablePanel = new JPanel(new FlowLayout());
         tablePanel.add(scrollpane);
	 scrollpane.setPreferredSize( new Dimension( 640, 200 ) );
 scrollpane.setVisible(true);
    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	add(inputPanel);
	add(tablePanel);
       
	
	
	
	
	}
	
	
}
