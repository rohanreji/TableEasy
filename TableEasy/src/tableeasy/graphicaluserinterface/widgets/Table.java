/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableeasy.graphicaluserinterface.widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import tableeasy.MainActivity;
import tableeasy.OracleDatabaseConnection;
import static tableeasy.graphicaluserinterface.widgets.TableCreationBox._table_name;

/**
 *
 * @author Rohan
 */
public class Table extends javax.swing.JPanel {

    /**
     * Creates new form Table
     */
    public Table() {
        initComponents();
        
           
      
    }
public Table(final int uid)
{
    initComponents();
    jButton1.setBackground(new Color(247,148,29));
         jButton1.setForeground(Color.WHITE);
        jButton1.setFocusPainted(false);
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 12));
    // jButton3= new JButton("Save Password");  
     setOpaque(false);
       jButton3.setVisible(false);
       jButton4.setVisible(false);
              jButton2.setVisible(false);
  jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "", "", "" }));

    jLabel2.setVisible(false);
    jComboBox1.setVisible(false);
       jLabel3.setVisible(false);
     jLabel4.setVisible(false); jLabel5.setVisible(false);
      jLabel7.setVisible(false);
       jLabel8.setVisible(false); jLabel6.setVisible(false);
        jLabel9.setVisible(false);
         jLabel10.setVisible(false);
          jLabel11.setVisible(false);
           jLabel12.setVisible(false);
         
        jLabel13.setVisible(false);
         jLabel14.setVisible(false);
          jLabel15.setVisible(false);
           jLabel16.setVisible(false);
            jLabel17.setVisible(false); jLabel19.setVisible(false);
             jLabel18.setVisible(false);  
              jLabel20.setVisible(false);
  jLabel21.setVisible(false); 
   jLabel22.setVisible(false);
   
   jLabel23.setVisible(false);
    jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(MainActivity.usernames!=0)
                       {
                            jButton2.setVisible(true);
                 jLabel2.setVisible(true);
    jComboBox1.setVisible(true);
             jButton3.setVisible(true);jButton4.setVisible(true);
                    valueSetter(uid);
                       }
                 else
                 {
                      JOptionPane.showMessageDialog(null,"NO USERS");
                 }
               
            }
    });
   jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String sq="select * from usersr where userid="+MainActivity.usernames;
                try {
                    Statement st=OracleDatabaseConnection.connect.createStatement();
                    ResultSet rs123=st.executeQuery(sq);
                    String sname=new String();
                    String spass=new String();
                    while(rs123.next())
                    {
                        sname=rs123.getString("username");
                        spass=rs123.getString("password");
                      
                        
                    }
                      String sq1="insert into passwordsr values('"+sname+"','"+spass+"')";
                      int r=st.executeUpdate(sq1);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
    
   });
   jButton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              MainActivity.usernames=0; 
              jLabel3.setVisible(false);
     jLabel4.setVisible(false); jLabel5.setVisible(false);
      jLabel7.setVisible(false);
       jLabel8.setVisible(false); jLabel6.setVisible(false);
        jLabel9.setVisible(false);
         jLabel10.setVisible(false);
          jLabel11.setVisible(false);
           jLabel12.setVisible(false);
         
        jLabel13.setVisible(false);
         jLabel14.setVisible(false);
          jLabel15.setVisible(false);
           jLabel16.setVisible(false);
            jLabel17.setVisible(false); jLabel19.setVisible(false);
             jLabel18.setVisible(false);  
              jLabel20.setVisible(false);
  jLabel21.setVisible(false); 
   jLabel22.setVisible(false);
   
   jLabel23.setVisible(false);
             jLabel2.setVisible(false);
                   jButton3.setVisible(false);
       jButton4.setVisible(false);
              jButton2.setVisible(false);
              jComboBox1.setVisible(false);
            }
   });
}
public void valueSetter(int uid)
{
      OracleDatabaseConnection conn=new OracleDatabaseConnection();
                  Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
                   if(connector==null)
                  {
                    JOptionPane.showMessageDialog(null,"NOT CONNECTED");
                  }
                   else
                   {
                      
          try {
               Statement stmt=connector.createStatement();
             
                  String s2="select * from usersr where userid="+MainActivity.usernames;
                  
    ResultSet rs12=stmt.executeQuery(s2);
        while(rs12.next())
      {
          jLabel2.setText(rs12.getString("username"));
          
      }
      String s="select * from databaser where userid="+MainActivity.usernames;
    
    System.out.println(s);
      int i=1;
      String[] dbnames=new String[100];
        ResultSet rs13=stmt.executeQuery(s);
        ResultSetMetaData metaData = rs13.getMetaData();
       
      while(rs13.next())
      {
            System.out.println(rs13.getString("dbname"));
            
          dbnames[i]=rs13.getString("dbname");
          i++;
      }
       jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { dbnames[1] }));
      for(int k=2;k<i;k++)
      {
          
            jComboBox1.addItem(dbnames[k]);
      }  
   
          } catch (SQLException ex) {
              Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
          }
                   }
                       
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Show user details");

        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jLabel22.setText("jLabel22");

        jLabel23.setText("jLabel23");

        jButton3.setText("Save Password");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sign out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15))
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17))
                                    .addComponent(jButton3))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          jLabel3.setVisible(false);
     jLabel4.setVisible(false); jLabel5.setVisible(false);
      jLabel7.setVisible(false);
       jLabel8.setVisible(false); jLabel6.setVisible(false);
        jLabel9.setVisible(false);
         jLabel10.setVisible(false);
          jLabel11.setVisible(false);
           jLabel12.setVisible(false);
         
        jLabel13.setVisible(false);
         jLabel14.setVisible(false);
          jLabel15.setVisible(false);
           jLabel16.setVisible(false);
            jLabel17.setVisible(false); jLabel19.setVisible(false);
             jLabel18.setVisible(false);  
              jLabel20.setVisible(false);
  jLabel21.setVisible(false); 
   jLabel22.setVisible(false);
   
   jLabel23.setVisible(false);
   if(jComboBox1.getItemCount()!=0)
   {
         String s=jComboBox1.getSelectedItem().toString();
         String sq="select * from tablesr where dbname='"+s+"'";
        try {
            Statement st=OracleDatabaseConnection.connect.createStatement();
              ResultSet rs = st.executeQuery(sq);
              int i=1;
              String t[]=new String[100];
              while(rs.next())
              {
             t[i]=rs.getString("tablename");
             
                   if(i==1)
             {
                 jLabel3.setVisible(true);
                 jLabel3.setText(t[i]);
             }
                   if(i==2)
                   {
                        jLabel4.setVisible(true);
                 jLabel4.setText(t[i]);
                   }
                    if(i==3)
                   {
                        jLabel5.setVisible(true);
                 jLabel5.setText(t[i]);
                   }
                     if(i==4)
                   {
                        jLabel6.setVisible(true);
                 jLabel6.setText(t[i]);
                   }
                      if(i==5)
                   {
                        jLabel7.setVisible(true);
                 jLabel7.setText(t[i]);
                   }
                       if(i==6)
                   {
                        jLabel8.setVisible(true);
                 jLabel8.setText(t[i]);
                   }
                        if(i==7)
                   {
                        jLabel9.setVisible(true);
                 jLabel9.setText(t[i]);
                   }
                         if(i==8)
                   {
                        jLabel10.setVisible(true);
                 jLabel10.setText(t[i]);
                   }
                          if(i==9)
                   {
                        jLabel11.setVisible(true);
                 jLabel11.setText(t[i]);
                   }
                           if(i==10)
                   {
                        jLabel12.setVisible(true);
                 jLabel12.setText(t[i]);
                   }
                            if(i==11)
                   {
                        jLabel13.setVisible(true);
                 jLabel13.setText(t[i]);
                   }
                             if(i==12)
                   {
                        jLabel14.setVisible(true);
                 jLabel14.setText(t[i]);
                   }
                              if(i==13)
                   {
                        jLabel15.setVisible(true);
                 jLabel15.setText(t[i]);
                   }
                               if(i==14)
                   {
                        jLabel16.setVisible(true);
                 jLabel16.setText(t[i]);
                   }
                                if(i==15)
                   {
                        jLabel17.setVisible(true);
                 jLabel17.setText(t[i]);
                   }
                                 if(i==16)
                   {
                        jLabel18.setVisible(true);
                 jLabel18.setText(t[i]);
                   } if(i==17)
                   {
                        jLabel19.setVisible(true);
                 jLabel19.setText(t[i]);
                   }
                    if(i==18)
                   {
                        jLabel20.setVisible(true);
                 jLabel20.setText(t[i]);
                   }
                     if(i==19)
                   {
                        jLabel21.setVisible(true);
                 jLabel21.setText(t[i]);
                   }
                      if(i==20)
                   {
                        jLabel22.setVisible(true);
                 jLabel22.setText(t[i]);
                   }
                       if(i==21)
                   {
                        jLabel23.setVisible(true);
                 jLabel23.setText(t[i]);
                   }
                     
                        
                                 
                   
                       
                       i++;
              }
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"NO CONNECTION");
             
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
