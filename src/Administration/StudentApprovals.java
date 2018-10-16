package Administration;

import Common.SendEmail;
import Common.ServerConfig;
import Common.frmDashboard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class StudentApprovals extends javax.swing.JFrame {
    private Connection conn;
    private PreparedStatement s;
    String pwd;
    DefaultListModel dlm = new DefaultListModel();
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public StudentApprovals() {
        initComponents();
        try{
            setConnection();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(this,"An error occurred while trying to establish connection with the server.","Cannot connect to the database server.", JOptionPane.ERROR_MESSAGE);
               this.dispose();
           }
        try{
           Statement sl = conn.createStatement();
           String strl = "SELECT StudentID,StudentName,Password,EmailAddress from oapstudents WHERE Status='P'";
           ResultSet rsl = sl.executeQuery(strl);
           String sd1,sd2,sd3;
                   sd1 = sd2 = sd3  = "";
           while(rsl.next()){
             sd1=rsl.getString(1);
             sd2=rsl.getString(2);
             pwd=rsl.getString(3);
             sd3=rsl.getString(4);
             dlm.addElement(sd1);
           }
             jList1.setModel(dlm);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"An error occurred while trying to fetch account requests from the server.\n"+e,"Error! Could not fetch data from server.", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStudentID = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        lblStudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        lblEmailID = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnDeleteAccount = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Students Registration Approvals");
        setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        setResizable(false);

        lblStudentID.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblStudentID.setText("Student ID:");

        txtStudentId.setEditable(false);
        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });

        lblStudentName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblStudentName.setText("Student Name:");

        txtStudentName.setEditable(false);

        txtEmailId.setEditable(false);
        txtEmailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailIdActionPerformed(evt);
            }
        });

        lblEmailID.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblEmailID.setText("Email ID:");

        btnCreateAccount.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        btnCreateAccount.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCreateAccount.setText("Approve Account Request");
        btnCreateAccount.setEnabled(false);
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        btnDeleteAccount.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        btnDeleteAccount.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnDeleteAccount.setText("Deny Account Request");
        btnDeleteAccount.setEnabled(false);
        btnDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccountActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Select a Student ID from the list to update its status.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmailID)
                                    .addComponent(lblStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStudentName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStudentName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStudentId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDeleteAccount)
                                .addGap(18, 18, 18)
                                .addComponent(btnCreateAccount))))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStudentID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStudentName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmailID)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteAccount)
                            .addComponent(btnCreateAccount))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIdActionPerformed

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
try{    
       if(jList1.getSelectedValue().equals("")){
         JOptionPane.showMessageDialog(this,"Invalid selection of Student ID.");
       }
       else{
           Statement sl = conn.createStatement();
           String var="A";
           String strl = "UPDATE oapstudents SET Status=\""+var+"\""+"WHERE StudentID=\""+txtStudentId.getText() + "\"";
           sl.executeUpdate(strl);
           String msg=txtStudentName.getText()+",\n\nYour account request has been approved by the Administrator. You are now registered as a Student"+" on the Online Assessment Platform.\n"+
            "Your log-in credentials are as follows:\n\n"+"Username: "+txtStudentId.getText()+"\nPassword: "+pwd+"\nStatus updated on "+frmDashboard.getServerDateTime()+"\nStatus updated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(txtEmailId.getText(),"OAP Account Status Update",msg);
            dlm.removeElement(txtStudentId.getText());
           jList1.setModel(dlm);
       }
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(this,"Error! Cannot execute update.\n"+e,"Error while updating records.",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnCreateAccountActionPerformed
    private void txtEmailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailIdActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        String str = jList1.getSelectedValue();
       try{
            Statement sl = conn.createStatement();
            String var="P";
            String strl = "SELECT StudentID,StudentName,EmailAddress from oapstudents WHERE Status=\""+var+"\""+"AND StudentID=\""+str+"\"";
            ResultSet rsl = sl.executeQuery(strl);
            String sd1,sd2,sd3,sd4,sd5,sd6;
                   sd1 = sd2 = sd3  = "";
           while(rsl.next()){
              sd1=rsl.getString(1);
              sd2=rsl.getString(2);
              sd3=rsl.getString(3);
           }
           txtStudentId.setText(sd1);
           txtStudentName.setText(sd2);
           txtEmailId.setText(sd3);
           btnDeleteAccount.setEnabled(true);
           btnCreateAccount.setEnabled(true);
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,"An error occurred while trying to fetch account details of this student.\n"+e,"Cannot fetch data from server.",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jList1ValueChanged

    private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccountActionPerformed
        // TODO add your handling code here:
        try{    
       if(jList1.getSelectedValue().equals("")){
         JOptionPane.showMessageDialog(this,"Invalid selection of Student ID.");
       }
       else{
           String reason=JOptionPane.showInputDialog("Reason: ");
           Statement sl = conn.createStatement();
           String msg=txtStudentName.getText()+",\n\nAdministrator denied account request for the Student ID: "+txtStudentId.getText()+".\nReason: "+reason+"\nStatus updated on "+frmDashboard.getServerDateTime()+"\nStatus updated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
           SendEmail.send(txtEmailId.getText(),"OAP Account Status Update",msg);
           String strl = "DELETE FROM oapstudents WHERE StudentID=\""+txtStudentId.getText() + "\"";
           sl.executeUpdate(strl);
           dlm.removeElement(txtStudentId.getText());
           jList1.setModel(dlm);
       }
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(this,"An error occurred while trying to update account status.\n"+e,"Unable to delete records.",JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_btnDeleteAccountActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentApprovals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentApprovals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentApprovals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentApprovals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentApprovals().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmailID;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
