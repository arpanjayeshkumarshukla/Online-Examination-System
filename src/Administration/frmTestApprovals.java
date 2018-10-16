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
public class frmTestApprovals extends javax.swing.JFrame {
    private Connection conn;
    private PreparedStatement s;
    String sEmail;
    
    DefaultListModel dlm = new DefaultListModel();
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmTestApprovals() {
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
           String strl = "SELECT TestID,TestName,TestCoordinator,TestDate,StartTime,Duration from tests WHERE Status='P'";
           ResultSet rsl = sl.executeQuery(strl);
           String sd1,sd2,sd3,sd4,sd5,sd6;
                   sd1 = sd2 = sd3  = sd4 = sd5 = sd6 = "";
           while(rsl.next()){
             sd1=rsl.getString(1);
             sd2=rsl.getString(2);
             sd3=rsl.getString(3);
             sd4=rsl.getString(4);
             sd5=rsl.getString(5);
             sd6=rsl.getString(6);
             dlm.addElement(sd1);
           }
             jList1.setModel(dlm);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e,"Error! Unable to fetch data  from server.",JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStudentID = new javax.swing.JLabel();
        txtTestID = new javax.swing.JTextField();
        lblStudentName = new javax.swing.JLabel();
        txtTestName = new javax.swing.JTextField();
        txtTestCoordinator = new javax.swing.JTextField();
        lblEmailID = new javax.swing.JLabel();
        btnApproveAccount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnDenyApproval = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTestDate = new javax.swing.JTextField();
        txtTestTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Tests Approvals");
        setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        setResizable(false);

        lblStudentID.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblStudentID.setText("Test ID:");

        txtTestID.setEditable(false);
        txtTestID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTestIDActionPerformed(evt);
            }
        });

        lblStudentName.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblStudentName.setText("Test Name:");

        txtTestName.setEditable(false);

        txtTestCoordinator.setEditable(false);
        txtTestCoordinator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTestCoordinatorActionPerformed(evt);
            }
        });

        lblEmailID.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblEmailID.setText("Test Coordinator:");

        btnApproveAccount.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        btnApproveAccount.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnApproveAccount.setText("Approve Test");
        btnApproveAccount.setEnabled(false);
        btnApproveAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveAccountActionPerformed(evt);
            }
        });

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        btnDenyApproval.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        btnDenyApproval.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnDenyApproval.setText("Deny Test");
        btnDenyApproval.setEnabled(false);
        btnDenyApproval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenyApprovalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Test Date:");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Test Time:");

        txtTestDate.setEditable(false);

        txtTestTime.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Duration:");

        txtDuration.setEditable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Select a Test ID from the  list to update its status.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEmailID, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(54, 54, 54))
                                            .addComponent(lblStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblStudentName)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTestID, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtDuration)
                                                    .addComponent(txtTestTime)
                                                    .addComponent(txtTestDate)
                                                    .addComponent(txtTestCoordinator, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDenyApproval)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnApproveAccount)
                                .addGap(51, 51, 51))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStudentID)
                            .addComponent(txtTestID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStudentName)
                            .addComponent(txtTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmailID)
                            .addComponent(txtTestCoordinator, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtTestTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDenyApproval)
                    .addComponent(btnApproveAccount))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTestIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTestIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTestIDActionPerformed

    private void btnApproveAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveAccountActionPerformed
        // TODO add your handling code here:
try{    
       if(jList1.getSelectedValue().equals("")){
         JOptionPane.showMessageDialog(this,"Invalid selection of Student ID.");
       }
       else{
           Statement sl = conn.createStatement();
           String var="A";
           String strl = "UPDATE tests SET Status=\""+var+"\""+"WHERE TestID=\""+txtTestID.getText() + "\"";
           sl.executeUpdate(strl);
           String msg=txtTestCoordinator.getText()+",\n\nYour request to conduct the test ( "+txtTestID.getText()+" ) "+txtTestName.getText()+" has been approved by the Administrator. You can now start enrolment of students for this test.\nHere are the important details of this test for your reference."+
           "\nTest Date: "+txtTestDate.getText()+"\nTest Time: "+txtTestTime.getText()+"\nDuration: "+txtDuration.getText()+"\nStatus updated on "+frmDashboard.getServerDateTime()+"\nStatus updated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
           Statement s3 = conn.createStatement();
           String str3 = "SELECT EmailAddress from staffaccounts WHERE UserID=\""+txtTestCoordinator.getText()+"\"";
           ResultSet rs3 = s3.executeQuery(str3);
           while(rs3.next()){
             sEmail=rs3.getString(1);
             
           }
           
           SendEmail.send(sEmail,"OAP Test Status Update",msg);
            dlm.removeElement(txtTestID.getText());
           jList1.setModel(dlm);
       }
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(this,"Error!\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnApproveAccountActionPerformed

    private void txtTestCoordinatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTestCoordinatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTestCoordinatorActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        String str = jList1.getSelectedValue();
       try{
            Statement sl = conn.createStatement();
            String var="P";
            String strl = "SELECT TestID,TestName,TestCoordinator,TestDate,StartTime,Duration from tests WHERE Status=\""+var+"\""+"AND TestID=\""+str+"\"";
            ResultSet rsl = sl.executeQuery(strl);
            String sd1,sd2,sd3,sd4,sd5,sd6;
                   sd1 = sd2 = sd3  = sd4 = sd5 = sd6= "";
           while(rsl.next()){
              sd1=rsl.getString(1);
              sd2=rsl.getString(2);
              sd3=rsl.getString(3);
              sd4=rsl.getString(4);
              sd5=rsl.getString(5);
              sd6=rsl.getString(6);
           }
           txtTestID.setText(sd1);
           txtTestName.setText(sd2);
           txtTestCoordinator.setText(sd3);
           txtTestDate.setText(sd4);
           txtTestTime.setText(sd5);
           txtDuration.setText(sd6);
           btnApproveAccount.setEnabled(true);
           btnDenyApproval.setEnabled(true);
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e,"Error!",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jList1ValueChanged

    private void btnDenyApprovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenyApprovalActionPerformed
        // TODO add your handling code here:
        try{    
       if(jList1.getSelectedValue().equals("")){
         JOptionPane.showMessageDialog(this,"Invalid selection of Student ID.");
       }
       else{
           String reason=JOptionPane.showInputDialog("Reason: ");
           String msg=txtTestCoordinator.getText()+",\n\nYour request to conduct the test ( "+txtTestID.getText()+" ) "+txtTestName.getText()+" has been denied by the Administrator."+
           "\nReason: "+reason+"\nStatus updated on "+frmDashboard.getServerDateTime()+"Status updated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
           Statement s2 = conn.createStatement();
           String str2 = "SELECT EmailAddress from staffaccounts WHERE UserID=\""+txtTestCoordinator.getText()+"\"";
           ResultSet rs2 = s2.executeQuery(str2);
           while(rs2.next()){
             sEmail=rs2.getString(1); 
           }
           SendEmail.send(sEmail,"Test Status Update",msg);
           Statement sl = conn.createStatement();
           String strl = "DELETE FROM tests WHERE TestID=\""+txtTestID.getText() + "\"";
           sl.executeUpdate(strl);
           dlm.removeElement(txtTestID.getText());
           jList1.setModel(dlm);
       }
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(this,"Error!\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_btnDenyApprovalActionPerformed

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
                new frmTestApprovals().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveAccount;
    private javax.swing.JButton btnDenyApproval;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmailID;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtTestCoordinator;
    private javax.swing.JTextField txtTestDate;
    private javax.swing.JTextField txtTestID;
    private javax.swing.JTextField txtTestName;
    private javax.swing.JTextField txtTestTime;
    // End of variables declaration//GEN-END:variables
}
