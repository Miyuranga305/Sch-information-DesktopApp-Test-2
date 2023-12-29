
package inf;


import code.DBconect;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public final class mainframe extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;   
    Resultset rs = null;
    
    public mainframe() {
        initComponents();
        conn = DBconect.connect();
        tableload();
    }
    
    public void tableload(){
    
        try {
            
            String sql = "SELECT id AS ID,sname AS NAME,sage AS AGE,sgrade AS GRADE FROM student";
           
            pst = conn.prepareStatement(sql); 
            rs = (Resultset) pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public void tabledata(){
    
    int r = table1.getSelectedRow();
    
    String id = table1.getValueAt(r,0).toString();
    String name = table1.getValueAt(r, 1).toString();
    String age = table1.getValueAt(r, 2).toString();
    String grade = table1.getValueAt(r, 3).toString();
    
    idbox.setText(id);
    namebox.setText(name);
    agebox.setText(age);
    gradebox.setSelectedItem(grade);
    }
    
    public void search(){
    
        String srch = searchbox.getText();
        
        try {
            String sql = "SELECT * FROM student WHERE sname LIKE'%"+srch+"%'OR id LIKE '%"+srch+"%'";
           
            pst = conn.prepareStatement(sql);
            rs = (Resultset) pst.executeQuery(); 
            table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

  public void update(){
  
    String id = idbox.getText();
    String name = namebox.getText();
    String age = agebox.getText();
    String grade = gradebox.getSelectedItem().toString();
    
  
      try {
          String sql= "UPDATE student SET sname='"+name+"',sage='"+age+"',sgrade='"+grade+"' WHERE id='"+id+"'";
          
          pst = conn.prepareStatement(sql);
          pst.execute();
          
          JOptionPane.showMessageDialog(null, "Updated");
            
          
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Update Unsuccesfully");         
          
      }
  
  }

  public void clear(){
  
    searchbox.setText("");
    idbox.setText("ID");
    namebox.setText("");
    agebox.setText("");
    gradebox.setSelectedIndex(0);
    
    
}
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        gradebox = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        exitbtn1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 153, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel5.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 70));

        jPanel6.setBackground(new java.awt.Color(102, 255, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Name");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Age");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Grade");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        namebox.setToolTipText("enter your name");
        jPanel6.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, -1));

        agebox.setToolTipText("enter your age");
        jPanel6.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 120, -1));

        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        gradebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeboxActionPerformed(evt);
            }
        });
        jPanel6.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 80, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 200, 160));

        jPanel7.setBackground(new java.awt.Color(0, 102, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel7.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        clearbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel7.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel7.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        deletebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel7.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 200, 100));

        exitbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exitbtn1.setText("Exit");
        exitbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtn1ActionPerformed(evt);
            }
        });
        jPanel3.add(exitbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel4.setText("ID");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        idbox.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        idbox.setText("id");
        jPanel3.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Adhikari\\Desktop\\youtube\\183511.jpg")); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 120, 970, 720));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 260, 470));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setBackground(new java.awt.Color(255, 102, 102));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table1.setShowGrid(true);
        table1.setSurrendersFocusOnKeystroke(true);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 480));

        jLabel5.setText("jLabel5");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 390, 470));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 630, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 450));

        setSize(new java.awt.Dimension(625, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void gradeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeboxActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
   
       String name;
       int age;
       int grade;
        
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText());
        
        grade = Integer.parseInt(gradebox.getSelectedItem().toString());
        //grade = (int)gradebox.getSelectedItem();
        try {
            
            String sql = "INSERT INTO student(sname,sage,sgrade) VALUES ('"+name+"','"+age+"','"+grade+"')";
          
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Inserted");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "enter correctly");
        }
        
        tableload();
        clear();
    }//GEN-LAST:event_insertbtnActionPerformed
  
    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        // TODO add your handling code here:
        search();
        
    }//GEN-LAST:event_searchboxKeyReleased

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        
        int check = JOptionPane.showConfirmDialog(null, "do you want to delete!");
        
        if(check==0){
            String id = idbox.getText();
            
            try {
                String sql = "DELETE FROM student WHERE id='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted!");
                
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            }
              
        }
        tableload();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void exitbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtn1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbtn1ActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        clear();
        search();
        tableload();
    }//GEN-LAST:event_clearbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn1;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
