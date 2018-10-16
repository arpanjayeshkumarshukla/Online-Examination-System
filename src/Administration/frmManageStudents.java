package Administration;

import Common.SendEmail;
import Common.ServerConfig;
import Common.frmDashboard;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class frmManageStudents extends javax.swing.JFrame {
    private Connection conn;
    private PreparedStatement s;
    private String sEmail;
    String var;
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmManageStudents(String param) {
        initComponents();
        if (param.equals("Administrator")){
            var="A";
        }
        else{
            var="P";
        }
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
        btnCreateAccount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblLastRecord = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblSearchStudentID = new javax.swing.JLabel();
        txtSearchStudentID = new javax.swing.JTextField();
        BtnSearchStudentByID = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Students Accounts");
        setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleBackground"));
        setResizable(false);
        setSize(new java.awt.Dimension(540, 330));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        lblStudentID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblStudentID.setText("Student ID:");
        getContentPane().add(lblStudentID);
        lblStudentID.setBounds(10, 30, 80, 17);

        lblStudentName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblStudentName.setText("Student Name:");
        getContentPane().add(lblStudentName);
        lblStudentName.setBounds(10, 70, 93, 17);

        lblEmailID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEmailID.setText("Email ID:");
        getContentPane().add(lblEmailID);
        lblEmailID.setBounds(10, 110, 55, 17);

        txtStudentName.setEditable(false);
        getContentPane().add(txtStudentName);
        txtStudentName.setBounds(130, 60, 220, 30);

        txtStudentId.setEditable(false);
        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentId);
        txtStudentId.setBounds(130, 20, 220, 30);

        txtEmailId.setEditable(false);
        getContentPane().add(txtEmailId);
        txtEmailId.setBounds(130, 100, 220, 30);

        btnCreateAccount.setText("Create Account");
        btnCreateAccount.setEnabled(false);
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateAccount);
        btnCreateAccount.setBounds(130, 150, 110, 23);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Last Record Updated:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 200, 150, 14);

        lblLastRecord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLastRecord.setText("null");
        lblLastRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblLastRecord);
        lblLastRecord.setBounds(10, 220, 140, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search by ID"));

        lblSearchStudentID.setText("Student  ID:");

        txtSearchStudentID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchStudentIDInputMethodTextChanged(evt);
            }
        });
        txtSearchStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchStudentIDActionPerformed(evt);
            }
        });
        txtSearchStudentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchStudentIDKeyTyped(evt);
            }
        });

        BtnSearchStudentByID.setText("Search");
        BtnSearchStudentByID.setEnabled(false);
        BtnSearchStudentByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchStudentByIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblSearchStudentID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchStudentID, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnSearchStudentByID)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchStudentID)
                    .addComponent(txtSearchStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnSearchStudentByID)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(360, 10, 240, 110);
        jPanel1.getAccessibleContext().setAccessibleName("Search Student by ID");

        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        getContentPane().add(BtnEdit);
        BtnEdit.setBounds(250, 150, 60, 23);

        BtnUpdate.setText("Update");
        BtnUpdate.setEnabled(false);
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(BtnUpdate);
        BtnUpdate.setBounds(320, 150, 70, 23);

        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(BtnDelete);
        BtnDelete.setBounds(400, 150, 70, 23);

        BtnCancel.setText("Cancel");
        BtnCancel.setEnabled(false);
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCancel);
        BtnCancel.setBounds(480, 150, 80, 23);

        btnAdd.setText("Add Account");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(20, 150, 100, 23);

        setSize(new java.awt.Dimension(618, 290));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        // TODO add your handling code here:
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
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ResetForm();
    }//GEN-LAST:event_formWindowOpened

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        try{
            setConnection();
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
             FileInputStream fin=new FileInputStream(f);
             int len=(int)f.length();
             s.setBinaryStream(6, fin, len);
    
            s.executeUpdate();
            String msg;
            if(var.equals("A")){
                msg=txtStudentName.getText()+",\n\nYou are now registered as a Student"+" on the Online Assessment Platform.\n"+
"Your log-in credentials are as follows:\n\n"+"\nUsername: "+txtStudentId.getText()+"\nPassword: "+pwd+"\nAccount created on "+frmDashboard.getServerDateTime()+"\nAccount created by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";           
            SendEmail.send(txtEmailId.getText(),"OAP Account Credentials",msg);
            }
            lblLastRecord.setText(txtStudentId.getText());
            ResetForm();
            switchAdd(false);
           }
           catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Unable to insert records into the database.\n"+e,"Unable to  insert records.", JOptionPane.ERROR_MESSAGE);
           }
           catch(Exception ex){
               JOptionPane.showMessageDialog(this,"This record, does not meet data integrity rules.\n"+ex,"Invalid Data.",JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void txtSearchStudentIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchStudentIDInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchStudentIDInputMethodTextChanged

    private void txtSearchStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchStudentIDActionPerformed
        
    }//GEN-LAST:event_txtSearchStudentIDActionPerformed

    private void txtSearchStudentIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStudentIDKeyTyped
        // TODO add your handling code here:
        if (txtSearchStudentID.getText().equals("")==false){
            BtnSearchStudentByID.setEnabled(true);
        }
        else
        {
            BtnSearchStudentByID.setEnabled(false);
        }
    }//GEN-LAST:event_txtSearchStudentIDKeyTyped

    private void BtnSearchStudentByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchStudentByIDActionPerformed
        // TODO add your handling code here:
        try{
            boolean found = ShowStudentbyID(txtSearchStudentID.getText());
            txtSearchStudentID.setText("");
            if (!found){
                JOptionPane.showMessageDialog(this,"Relevant record does not exist in the database.");
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e, "Search Error",JOptionPane.ERROR_MESSAGE);
        }
        BtnSearchStudentByID.setEnabled(false);
    }//GEN-LAST:event_BtnSearchStudentByIDActionPerformed
private void switchEdit(boolean b){
        txtStudentName.setEditable(b);
        txtEmailId.setEditable(b);
        btnCreateAccount.setEnabled(false);
        BtnDelete.setEnabled(!b);
        BtnUpdate.setEnabled(b);
        BtnCancel.setEnabled(b);
        txtSearchStudentID.setEnabled(!b);
        btnAdd.setEnabled(!b);
        BtnEdit.setEnabled(!b);
    }
    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        switchEdit(true);
        sEmail=txtEmailId.getText();
    }//GEN-LAST:event_BtnEditActionPerformed
private void switchAdd(boolean a){
        txtStudentId.setEditable(a);
        txtStudentName.setEditable(a);
        txtEmailId.setEditable(a);
        btnAdd.setEnabled(!a);
        btnCreateAccount.setEnabled(a);
        BtnCancel.setEnabled(a);
        BtnEdit.setEnabled(!a);
        BtnDelete.setEnabled(!a);
        BtnUpdate.setEnabled(false);
        txtSearchStudentID.setEnabled(!a);
    }
    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        // TODO add your handling code here:
        try{
            String msg,pwd;
            if(txtEmailId.getText().equals(sEmail)){
            s=conn.prepareStatement("UPDATE oapstudents SET StudentName=?, EmailAddress=? WHERE StudentID=? AND Status=?");
            s.setString(1,txtStudentName.getText());
            s.setString(2, txtEmailId.getText());
            s.setString(3,txtStudentId.getText());
            s.setString(4,"A");
            s.executeUpdate();                                  
            msg=txtStudentName.getText()+",\n\nYour account details were modified by the Administrator."+
"\nYour updated account details are as follows:\n\n"+"\nUsername: "+txtStudentId.getText()+"\nStudent Name: "+txtStudentName.getText()+"\nEmail Address: "+txtEmailId.getText()+"\nAccount updated on "+frmDashboard.getServerDateTime()+"\nAccount created by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";                       
            }
            else{
            s=conn.prepareStatement("UPDATE oapstudents SET StudentName=?, EmailAddress=?,Password=? WHERE StudentID=? AND Status=?");
            s.setString(1,txtStudentName.getText());
            s.setString(2, txtEmailId.getText());
            pwd=randomString();
            s.setString(3, pwd);
            s.setString(4,txtStudentId.getText());
            s.setString(5,"A");
            s.executeUpdate();                                  
            msg=txtStudentName.getText()+",\n\nYour account details were modified by the Administrator."+
            "\nYour updated account details are as follows:\n\n"+"\nUsername: "+txtStudentId.getText()+"\nPasssword: "+pwd+"\nStudent Name: "+txtStudentName.getText()+"\nEmail Address: "+txtEmailId.getText()+"\nAccount updated on "+frmDashboard.getServerDateTime()+"\nAccount created by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";                                       
            }
SendEmail.send(txtEmailId.getText(),"OAP Account Details Updated",msg);

            lblLastRecord.setText(txtStudentId.getText());
            ResetForm();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Database Error.", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,ex,"Error while updating record. New data may not meet data integrity rules.", JOptionPane.ERROR_MESSAGE);
        }
        switchEdit(false);
    }//GEN-LAST:event_BtnUpdateActionPerformed
    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        try{
            int n=JOptionPane.showConfirmDialog(this,"Deleting a student account will also delete all of its associated data such as gradebook, enrolment requests and test sessions. Do you wish to proceed?","Confirm account deletion?",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.NO_OPTION){
                return ;
            }
            s=conn.prepareStatement("DELETE FROM studentstestsreports WHERE StudentID=?");
            s.setString(1,txtStudentId.getText());
            s.executeUpdate();
            s=conn.prepareStatement("DELETE FROM testsenrolreq WHERE StudentID=?");
            s.setString(1,txtStudentId.getText());
            s.executeUpdate();
            s=conn.prepareStatement("DELETE FROM sessions WHERE StudentID=?");
            s.setString(1,txtStudentId.getText());
            s.executeUpdate();
            s=conn.prepareStatement("DELETE FROM oapstudents WHERE StudentID=?");
            s.setString(1,txtStudentId.getText());
            s.executeUpdate();
            String msg=txtStudentName.getText()+",\n\nYour student account with StudentID (Username) "+txtStudentId.getText()+
" has been deleted by the Administrator.\nAccount deleted on "+frmDashboard.getServerDateTime()+"\nAccount updated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(txtEmailId.getText(),"OAP Account Credentials",msg);
            lblLastRecord.setText(txtStudentId.getText());
            ResetForm();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e,"Error! Unable to delete records.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        // TODO add your handling code here:
        ResetForm();
        if (btnCreateAccount.isEnabled()==true)
        {
            switchAdd(false);
        }
        else if(BtnUpdate.isEnabled()==true)
        switchEdit(false);
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        ResetForm();
        switchAdd(true);
        //add,save,edit,delete,update,next,btnsearchbusbyid
    }//GEN-LAST:event_btnAddActionPerformed
public boolean ShowStudentbyID(String a) throws SQLException{
            ResetForm();
            setConnection();
            s=conn.prepareStatement("Select StudentID,StudentName,EmailAddress from oapstudents WHERE StudentID=? AND Status=\""+"A"+"\"");
            s.setString(1,a);
            ResultSet rs= s.executeQuery();
            boolean empty=true;
            while (rs.next()) {
                txtStudentId.setText(rs.getString(1));
                txtStudentName.setText(rs.getString(2));
                txtEmailId.setText(rs.getString(3));
                empty=false;
                break;
            }
            return (!empty);
    }
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
                new frmManageStudents("Administrator").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnSearchStudentByID;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblEmailID;
    private javax.swing.JLabel lblLastRecord;
    private javax.swing.JLabel lblSearchStudentID;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtSearchStudentID;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
