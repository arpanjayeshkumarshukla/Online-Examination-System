package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ChangePassword extends javax.swing.JFrame {

    private Connection conn;
    private PreparedStatement s;
    private ResultSet rs;
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public ChangePassword() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtOldPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtReenterPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Old Password: ");

        jLabel2.setText("New Password:");

        jLabel3.setText("Re-enter Password:");

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtOldPassword.setNextFocusableComponent(txtNewPassword);

        txtNewPassword.setNextFocusableComponent(txtReenterPassword);

        txtReenterPassword.setNextFocusableComponent(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReenterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txtNewPassword)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtReenterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            setConnection();
            int flag=0;
            String msg = null;
            if(frmDashboard.StaffDesignation.equals("Student")){
                s=conn.prepareStatement("SELECT Password FROM oapstudents WHERE StudentID=?");
            }
            else{
                s=conn.prepareStatement("SELECT Password FROM staffaccounts WHERE UserID=?");
            }
            s.setString(1,frmDashboard.StaffUserID);
            rs=s.executeQuery();
                if(rs.next()){
                    if(txtOldPassword.getText().equals(rs.getString(1))){
                        flag=1;
                    }          
                }
                if(flag==0){
                    JOptionPane.showMessageDialog(this,"Authentication failed: Incorrect password.","Authentication Error.",JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                else if(!txtNewPassword.getText().equals(txtReenterPassword.getText())){
                    JOptionPane.showMessageDialog(this,"New passwords do not match. Enter the same password in both new and re-enter fields.","Error.",JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                if(frmDashboard.StaffDesignation.equals("Student")){
                s=conn.prepareStatement("UPDATE oapstudents SET Password=? WHERE StudentID=?");
            }
            else{
                s=conn.prepareStatement("UPDATE staffaccounts SET Password=? WHERE UserID=?");
            }
                s.setString(1,txtNewPassword.getText());
                s.setString(2,frmDashboard.StaffUserID);
                s.executeUpdate();
                msg=frmDashboard.StaffName+",\n\nYou new log-in credentials are as follows: \n"+"\nUsername: "+frmDashboard.StaffUserID+"\nPasssword: "+txtNewPassword.getText()+"\nAccount updated on: "+frmDashboard.getServerDateTime()+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";                                       
                SendEmail.send(frmDashboard.StaffEmailID,"OAP Account Password Changed",msg);
                JOptionPane.showMessageDialog(this,"Password has been changed successfully.","Password changed.",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
        }  
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"An error occurred while trying to change the password to your account.\n The details of the error are as given below: \n"+e,"Error! Unable to change password.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChangePassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    private javax.swing.JPasswordField txtReenterPassword;
    // End of variables declaration//GEN-END:variables
}
