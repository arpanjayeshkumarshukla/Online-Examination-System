package Students;

import Administration.frmManageStaff;
import Common.SendEmail;
import Common.ServerConfig;
import Common.frmDashboard;
import Common.frmLogin;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class frmApplyRegistration extends javax.swing.JFrame {
    private Connection conn;
    private PreparedStatement s;
    String var="P";
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmApplyRegistration() {
        initComponents();
        try{
            setConnection();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(this,"An error occurred while trying to establish connection with the server.","Cannot connect to the database server.", JOptionPane.ERROR_MESSAGE);
               this.dispose();
           }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblStudentName = new javax.swing.JLabel();
        lblEmailID = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnCreateAccount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblLastRecord = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students Registration Form");
        setResizable(false);
        setSize(new java.awt.Dimension(540, 330));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        lblStudentID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblStudentID.setForeground(new java.awt.Color(255, 0, 0));
        lblStudentID.setText("Student ID:");
        getContentPane().add(lblStudentID);
        lblStudentID.setBounds(10, 30, 80, 17);

        lblStudentName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblStudentName.setForeground(new java.awt.Color(255, 0, 0));
        lblStudentName.setText("Student Name:");
        getContentPane().add(lblStudentName);
        lblStudentName.setBounds(10, 70, 102, 17);

        lblEmailID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEmailID.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailID.setText("Email ID:");
        getContentPane().add(lblEmailID);
        lblEmailID.setBounds(20, 110, 59, 17);
        getContentPane().add(txtStudentName);
        txtStudentName.setBounds(130, 60, 220, 30);

        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentId);
        txtStudentId.setBounds(130, 20, 220, 30);
        getContentPane().add(txtEmailId);
        txtEmailId.setBounds(130, 100, 220, 30);

        btnReset.setBackground(java.awt.Color.blue);
        btnReset.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 0, 0));
        btnReset.setText("Reset Form");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset);
        btnReset.setBounds(390, 100, 113, 25);

        btnCreateAccount.setBackground(new java.awt.Color(51, 51, 255));
        btnCreateAccount.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCreateAccount.setForeground(new java.awt.Color(255, 0, 0));
        btnCreateAccount.setText("Create Account");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateAccount);
        btnCreateAccount.setBounds(370, 70, 141, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.red);
        jLabel3.setText("Last Record Entered:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 20, 160, 14);

        lblLastRecord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLastRecord.setForeground(java.awt.Color.red);
        lblLastRecord.setText("null");
        lblLastRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblLastRecord);
        lblLastRecord.setBounds(400, 40, 110, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Administration/The-World-in-a-Book-540x304 - Copy.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -80, 540, 470);

        setSize(new java.awt.Dimension(533, 185));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void CloseForm(){
        
    }
    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        
    }//GEN-LAST:event_txtStudentIdActionPerformed
    String randomString(){
        StringBuilder sb = new StringBuilder(8);
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        for( int i = 0; i < 8; i++ ) 
            sb.append( AB.charAt( rnd.nextInt(AB.length())));
        return sb.toString();
    }
    private void ResetForm(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtEmailId.setText("");
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        ResetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ResetForm();
    }//GEN-LAST:event_formWindowOpened

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        try{
            s=conn.prepareStatement("INSERT INTO oapstudents VALUES(?,?,?,?,?,?)");
            s.setString(1,txtStudentId.getText());
            String pwd=randomString();
            s.setString(2,pwd);
            s.setString(3, txtStudentName.getText());
            s.setString(4, txtEmailId.getText());
            s.setString(5, var);
            
            File f=new File("default2.jpg"); 
            f.createNewFile();
            String path=f.getAbsolutePath(); 
            System.out.println("File path: "+path);
             FileInputStream fin=new FileInputStream(f);
             int len=(int)f.length();
             s.setBinaryStream(6, fin, len);
            
            
            s.executeUpdate();
            String msg;
            msg=txtStudentName.getText()+",\n\nWe have received your request for creating an account on the Online Assessment Platform as per the below mentioned details and it has been sent for approval. You will be notified of the status of your account and will receive your credentials once approval is granted.\n"+
            "Your details are as follows:\n\n"+"Student ID: "+txtStudentId.getText()+"\nStudent Name: "+txtStudentName.getText()+"\nEmail ID: "+txtEmailId.getText()+"\nApplied on "+frmDashboard.getServerDateTime()+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(txtEmailId.getText(),"OAP Account Creation Request Received",msg);        
            lblLastRecord.setText(txtStudentId.getText());
            ResetForm();
        }
           catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Unable to insert records.",JOptionPane.ERROR_MESSAGE);
           }
           catch(Exception ex){
               JOptionPane.showMessageDialog(this,"This record may not meet data integrity rules.\n"+ex,"Invalid data.",JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new frmLogin().setVisible(true);
    }//GEN-LAST:event_formWindowClosing
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
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmApplyRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblEmailID;
    private javax.swing.JLabel lblLastRecord;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
