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
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class frmManageStaff extends javax.swing.JFrame {

    private Connection conn;
    private PreparedStatement s;
    private String sEmail;
  private boolean ShowStaffbyID(String a) throws SQLException{
            ResetForm();
            setConnection();
            s=conn.prepareStatement("Select UserID,StaffName,Designation,EmailAddress from staffaccounts WHERE UserID=?");
            s.setString(1,a);
            ResultSet rs= s.executeQuery();
            boolean empty=true;
            while (rs.next()) {
                txtUserId.setText(rs.getString(1));
                txtStaffName.setText(rs.getString(2));
                cbDesignation.setSelectedItem(rs.getString(3));
                txtEmailId.setText(rs.getString(4));
                empty=false;
                break;
            }
            return (!empty);
    }
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    String randomString(){
        StringBuilder sb = new StringBuilder(8);
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        for( int i = 0; i < 8; i++ ) 
            sb.append( AB.charAt( rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public frmManageStaff() {
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
        lblUserID = new javax.swing.JLabel();
        lblStaffName = new javax.swing.JLabel();
        lblDesignation = new javax.swing.JLabel();
        lblEmailID = new javax.swing.JLabel();
        txtStaffName = new javax.swing.JTextField();
        txtUserId = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        btnCreateAccount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblLastRecord = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblSearchUserID = new javax.swing.JLabel();
        txtSearchStaffID = new javax.swing.JTextField();
        BtnSearchStaffByID = new javax.swing.JButton();
        cbDesignation = new javax.swing.JComboBox<>();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Staff Accounts");
        setResizable(false);
        setSize(new java.awt.Dimension(540, 330));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblUserID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUserID.setText("User ID:");

        lblStaffName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblStaffName.setText("Staff Name:");

        lblDesignation.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDesignation.setText("Designation:");

        lblEmailID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEmailID.setText("Email ID:");

        txtStaffName.setEditable(false);

        txtUserId.setEditable(false);
        txtUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIdActionPerformed(evt);
            }
        });

        txtEmailId.setEditable(false);

        btnCreateAccount.setText("Create Account");
        btnCreateAccount.setEnabled(false);
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Record Entered");

        lblLastRecord.setText("null");
        lblLastRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAdd.setText("Add Account");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnUpdate.setText("Update");
        BtnUpdate.setEnabled(false);
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnCancel.setText("Cancel");
        BtnCancel.setEnabled(false);
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search by ID"));

        lblSearchUserID.setText("User ID:");

        txtSearchStaffID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchStaffIDInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtSearchStaffID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchStaffIDActionPerformed(evt);
            }
        });
        txtSearchStaffID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchStaffIDKeyTyped(evt);
            }
        });

        BtnSearchStaffByID.setText("Search");
        BtnSearchStaffByID.setEnabled(false);
        BtnSearchStaffByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchStaffByIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblSearchUserID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchStaffID))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(BtnSearchStaffByID)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchUserID)
                    .addComponent(txtSearchStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnSearchStaffByID)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        cbDesignation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Test Coordinator" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStaffName)
                            .addComponent(lblDesignation)
                            .addComponent(lblEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(BtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUserID)
                        .addGap(45, 45, 45)
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblLastRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblUserID))
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLastRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblStaffName)
                        .addGap(13, 13, 13)
                        .addComponent(lblDesignation)
                        .addGap(13, 13, 13)
                        .addComponent(lblEmailID))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnCreateAccount)
                    .addComponent(BtnEdit)
                    .addComponent(BtnUpdate)
                    .addComponent(BtnDelete)
                    .addComponent(BtnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(616, 245));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIdActionPerformed

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        try{
            s=conn.prepareStatement("INSERT INTO staffaccounts VALUES(?,?,?,?,?,?)");
            s.setString(1,txtUserId.getText());
            String pwd=randomString();
            s.setString(2, pwd);
            s.setString(3, txtStaffName.getText());
            s.setString(4, (String) cbDesignation.getSelectedItem());
            s.setString(5, txtEmailId.getText());
            File f=new File("default2.jpg"); 
            f.createNewFile();
            String path=f.getAbsolutePath(); 
             FileInputStream fin=new FileInputStream(f);
             int len=(int)f.length();
             s.setBinaryStream(6, fin, len);
            s.executeUpdate();
            String msg=txtStaffName.getText()+",\nYou are now registered as a "+cbDesignation.getSelectedItem()+" on the Online Assessment Platform.\n"+
"Your log-in credentials are as follows:\n\n"+"Username: "+txtUserId.getText()+"\nPassword: "+pwd+"\nAccount created on "+frmDashboard.getServerDateTime()+"\nUpdated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(txtEmailId.getText(),"OAP Account Credentials",msg);
            lblLastRecord.setText(txtUserId.getText());
            ResetForm();
            switchAdd(false);
           }
           catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Database Error.", JOptionPane.ERROR_MESSAGE);
           }
           catch(Exception ex){
               JOptionPane.showMessageDialog(this,ex,"This record, does not meet data integrity rules.", JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ResetForm();
    }//GEN-LAST:event_formWindowOpened
    private void ResetForm(){
        txtUserId.setText("");
        txtEmailId.setText("");
        txtStaffName.setText("");
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        ResetForm();
        switchAdd(true);
        //add,save,edit,delete,update,next,btnsearchbusbyid
    }//GEN-LAST:event_btnAddActionPerformed
private void switchAdd(boolean a){
        txtUserId.setEditable(a);
        txtStaffName.setEditable(a);
        cbDesignation.setEnabled(a);
        txtEmailId.setEditable(a);
        btnAdd.setEnabled(!a);
        btnCreateAccount.setEnabled(a);
        BtnCancel.setEnabled(a);
        BtnEdit.setEnabled(!a);
        BtnDelete.setEnabled(!a);
        BtnUpdate.setEnabled(false);
        txtSearchStaffID.setEnabled(!a);
    }
private void switchEdit(boolean b){
        txtStaffName.setEditable(b);
        txtEmailId.setEditable(b);
        btnCreateAccount.setEnabled(false);
        BtnDelete.setEnabled(!b);
        BtnUpdate.setEnabled(b);
        BtnCancel.setEnabled(b);
        txtSearchStaffID.setEnabled(!b);
        btnAdd.setEnabled(!b);
        BtnEdit.setEnabled(!b);
    }
    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        switchEdit(true);
        sEmail=txtEmailId.getText();
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        // TODO add your handling code here:
        try{
            String msg,pwd;
            if(!txtEmailId.getText().equals(sEmail)){
                s=conn.prepareStatement("UPDATE staffaccounts SET StaffName=?, EmailAddress=? WHERE UserID=?");
                s.setString(3,txtUserId.getText());
                msg=txtStaffName.getText()+",\n\nYour account details were modified by the Administrator."+
            "\nYour updated account details are as follows:\n\n"+"\nUsername: "+txtUserId.getText()+"\nStaff Name: "+txtStaffName.getText()+"\nEmail Address: "+txtEmailId.getText()+"\nAccount updated on "+frmDashboard.getServerDateTime()+"\nAccount updated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            }
            else{
                s=conn.prepareStatement("UPDATE staffaccounts SET StaffName=?, EmailAddress=?,Password=? WHERE UserID=?");
                s.setString(4,txtUserId.getText());
                pwd=randomString();
                s.setString(3,pwd);
                msg=txtStaffName.getText()+",\n\nYour account details were modified by the Administrator."+
            "\nYour updated account details are as follows:\n\n"+"\nUsername: "+txtUserId.getText()+"\nPassword: "+pwd+"\nStaff Name: "+txtStaffName.getText()+"\nEmail Address: "+txtEmailId.getText()+"\nAccount updated on "+frmDashboard.getServerDateTime()+"\nAccount updated by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            }
            s.setString(1,txtStaffName.getText());
            s.setString(2, txtEmailId.getText());
            s.executeUpdate();
            SendEmail.send(txtEmailId.getText(),"OAP Account Details Updated",msg);
            lblLastRecord.setText(txtUserId.getText());
            ResetForm();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Database Error.", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,ex,"An error occurred while updating this record. New data may not meet data integrity rules.",JOptionPane.ERROR_MESSAGE);
        }
        switchEdit(false);
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        //try{
            if(txtUserId.getText().equals("developer")){
                JOptionPane.showMessageDialog(this,"Cannot delete developer account.","Error! ",JOptionPane.ERROR_MESSAGE);
                return ;
            }
            JOptionPane.showMessageDialog(this,"Account Deletion rules have not been defined.","Cannot delete the account.",JOptionPane.ERROR_MESSAGE);
            /*s=conn.prepareStatement("DELETE FROM studentstestsreports WHERE StudentID=?");
            s.setString(1,txtStudentId.getText());
            s.executeUpdate();
            s=conn.prepareStatement("DELETE FROM testsenrolreq WHERE StudentID=?");
            s.setString(1,txtStudentId.getText());
            s.executeUpdate();*/
            /*s=conn.prepareStatement("DELETE FROM staffaccounts WHERE UserID=?");
            s.setString(1,txtUserId.getText());
            s.executeUpdate();
            String msg=txtStaffName.getText()+",\n\nYour account with Username "+txtUserId.getText()+
            " has been deleted by the Administrator.\nAccount Deleted on: "+frmDashboard.getServerDateTime()+"\nAccounts updated by: "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(txtEmailId.getText(),"OAP Account Credentials",msg);
            lblLastRecord.setText(txtUserId.getText());
            ResetForm();*/
        //}
        /*catch(SQLException e){
            JOptionPane.showMessageDialog(this, e,"Error!",JOptionPane.ERROR_MESSAGE);
        }*/
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

    private void txtSearchStaffIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchStaffIDInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchStaffIDInputMethodTextChanged

    private void txtSearchStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchStaffIDActionPerformed

    }//GEN-LAST:event_txtSearchStaffIDActionPerformed

    private void txtSearchStaffIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStaffIDKeyTyped
        // TODO add your handling code here:
        if (txtSearchStaffID.getText().equals("")==false){
            BtnSearchStaffByID.setEnabled(true);
        }
        else
        {
            BtnSearchStaffByID.setEnabled(false);
        }
    }//GEN-LAST:event_txtSearchStaffIDKeyTyped

    private void BtnSearchStaffByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchStaffByIDActionPerformed
        // TODO add your handling code here:
        try{
            boolean found = ShowStaffbyID(txtSearchStaffID.getText());
            txtSearchStaffID.setText("");
            if (!found){
                JOptionPane.showMessageDialog(this,"Relevant record does not exist in the database.","No record found.",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,e, "Search Error", JOptionPane.ERROR_MESSAGE);
        }
        BtnSearchStaffByID.setEnabled(false);
    }//GEN-LAST:event_BtnSearchStaffByIDActionPerformed

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
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmManageStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnSearchStaffByID;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JComboBox<String> cbDesignation;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblDesignation;
    private javax.swing.JLabel lblEmailID;
    private javax.swing.JLabel lblLastRecord;
    private javax.swing.JLabel lblSearchUserID;
    private javax.swing.JLabel lblStaffName;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtSearchStaffID;
    private javax.swing.JTextField txtStaffName;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
