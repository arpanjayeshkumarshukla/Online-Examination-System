//  Import the necessary classes from other packages.
package Common;
import Students.frmApplyRegistration;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class frmLogin extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pstmt=null;
    InputStream in;

//  A method to establish connection with the database.
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
//  Constructor that calls a method which is used to place GUI objects on the form.    
    public frmLogin() {
        initComponents();
        ResetForm();
        SwingUtilities.getRootPane(btnLogIn).setDefaultButton(btnLogIn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        BtnForgotPassword = new javax.swing.JButton();
        cbDesignation = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        lblHeader.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblHeader.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Welcome to the Online Assessment Platform");

        lblUsername.setText("Username :");

        lblPassword.setText("Password :");
        lblPassword.setMaximumSize(new java.awt.Dimension(55, 14));
        lblPassword.setMinimumSize(new java.awt.Dimension(55, 14));

        txtPassword.setToolTipText("Enter your password:");
        txtPassword.setNextFocusableComponent(cbDesignation);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnLogIn.setText("Login");
        btnLogIn.setToolTipText("Button to login to the system.");
        btnLogIn.setNextFocusableComponent(btnReset);
        btnLogIn.setSelected(true);
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        lblStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("System Status: Locked");
        lblStatus.setToolTipText("Displays System Status");
        lblStatus.setBorder(new javax.swing.border.MatteBorder(null));
        lblStatus.setOpaque(true);

        btnRegister.setBackground(new java.awt.Color(204, 204, 255));
        btnRegister.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        btnRegister.setText("New Student? Register here.");
        btnRegister.setToolTipText("Click here, to register as a student.");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        txtUsername.setToolTipText("Enter your unique username");
        txtUsername.setFocusCycleRoot(true);
        txtUsername.setNextFocusableComponent(txtPassword);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel1.setText("Please provide your credentials");

        btnReset.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        btnReset.setText("Reset");
        btnReset.setNextFocusableComponent(BtnForgotPassword);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        BtnForgotPassword.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        BtnForgotPassword.setText("Forgot Password");
        BtnForgotPassword.setNextFocusableComponent(btnRegister);
        BtnForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnForgotPasswordActionPerformed(evt);
            }
        });

        cbDesignation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Student" }));
        cbDesignation.setNextFocusableComponent(btnLogIn);

        jLabel2.setText("Category:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbDesignation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnForgotPassword)
                            .addComponent(btnRegister)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblHeader)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUsername))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnForgotPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnLogIn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
//  The MouseClick event of the Log-In button performs the entire validation and verification process.    
    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        try{
            setConnection();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"The connection to the server could not be established due to an error. \nCheck the connection settings and try again. If this error persists, contact the Administrator.\nError Details: \n"+e,"Unable to connect to the Server.",JOptionPane.ERROR_MESSAGE);
        }
        if(txtUsername.getText().equals("") || txtPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Username and Password must be non-empty.","Empty fields.",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        String ename = null,erole = null;
        String eEmail=null;
        try{ 
            if(cbDesignation.getSelectedItem().equals("Staff"))
            pstmt=conn.prepareStatement("SELECT StaffName,Designation,EmailAddress,photo FROM staffaccounts WHERE UserID=? AND Password=?");
        else{
            pstmt=conn.prepareStatement("SELECT StudentName,EmailAddress,photo FROM oapstudents WHERE StudentID=? AND Password=? AND Status=?");
            pstmt.setString(3,"A");
            erole="Student";
        }
        pstmt.setString(1, txtUsername.getText());
        pstmt.setString(2,txtPassword.getText());
        ResultSet rs= pstmt.executeQuery();
        lblStatus.setText("System Check: Failed");    
        while(rs.next()){
                lblStatus.setText("System Check: Success");
                ename=rs.getString(1);
                if(cbDesignation.getSelectedItem().equals("Staff")){
                    erole=rs.getString(2);
                    eEmail=rs.getString(3);
                    //String photo=rs.getString(4);
                        in=rs.getBinaryStream(4);
                }
                else{
                    eEmail=rs.getString(2);
                    in= rs.getBinaryStream(3);
                }
        }
        pstmt.close();
        if("System Check: Success".equals(lblStatus.getText())){
                conn.close();
                JOptionPane.showMessageDialog(this,"Welcome "+ename+". You are now logged in as a "+erole+".","Login successful.",JOptionPane.INFORMATION_MESSAGE);             
                new frmDashboard(ename,erole,eEmail,txtUsername.getText(),in).setVisible(true);
                ResetForm();
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(this, "Authentication failed as the username or password is invalid.","Authentication Failed.",JOptionPane.ERROR_MESSAGE);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Failed to retrieve data from server.\nCheck the value of data fields and try again.\nIf this error persists, contact the Administrator.\nError Details: \n"+e,"Unable to fetch data from server.",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,"Failed to retrieve data from server, check your input and try again. The error details are as follows: \n"+ex,"IO Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLogInActionPerformed
    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        new frmApplyRegistration().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed
    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed
    private void ResetForm(){
        txtUsername.setText("");
        txtPassword.setText("");
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        ResetForm();
    }//GEN-LAST:event_btnResetActionPerformed
    private void BtnForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnForgotPasswordActionPerformed
            if(txtUsername.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Username field must be non-empty.","Empty field.",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        String pwd=randomString();
        try {
            setConnection();
            if(cbDesignation.getSelectedItem().equals("Staff"))
                pstmt=conn.prepareStatement("UPDATE staffaccounts SET Password=? WHERE UserID=?");
            else
                pstmt=conn.prepareStatement("UPDATE oapstudents SET Password=? WHERE StudentID=? AND Status='A'");
            
            pstmt.setString(1, pwd);
            pstmt.setString(2,txtUsername.getText());
            pstmt.executeUpdate();
            
            if(cbDesignation.getSelectedItem().equals("Staff"))
                pstmt=conn.prepareStatement("SELECT StaffName,EmailAddress from staffaccounts WHERE UserID=?");
            else
                pstmt=conn.prepareStatement("SELECT StudentName,EmailAddress from oapstudents WHERE StudentID=? AND Status='A'");
            
            pstmt.setString(1,txtUsername.getText());
            ResultSet rs=pstmt.executeQuery();
            String sName=null,sEmail=null;
            while(rs.next()){
                sName=rs.getString(1);
                sEmail=rs.getString(2);
            }
            String msg=sName+",\nYou recently requested for a password reset to your account on the Online Assessment Platform.\n"+
            "Your password has been reset by the system and your new log-in credentials are as follows:\n\n"+"\nUsername: "+txtUsername.getText()+"\nPassword: "+pwd+"\nAccount reset on "+frmDashboard.getServerDateTime()+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(sEmail,"OAP Account Password Reset",msg);
            conn.close();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"An error occurred while trying to reset your password. "+ex,"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnForgotPasswordActionPerformed
String randomString(){
        StringBuilder sb = new StringBuilder(8);
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        for( int i = 0; i < 8; i++ ) 
            sb.append( AB.charAt( rnd.nextInt(AB.length())));
        return sb.toString();
    }    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnForgotPassword;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbDesignation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}