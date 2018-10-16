package TestManagement;

import Common.SendEmail;
import Common.ServerConfig;
import Common.frmDashboard;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class frmManageTestEnrolment extends javax.swing.JFrame {

    private Connection conn;
    private PreparedStatement s;
    DefaultListModel dlm = new DefaultListModel();
    DefaultListModel dlm2;
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmManageTestEnrolment() {
        initComponents();
        try{
            setConnection();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(this,e, "Database Connection Error", HEIGHT);
               this.dispose();
           }
        try{
           Statement sl = conn.createStatement();
           String strl = "SELECT TestID from tests WHERE Status=\""+"Y"+"\""+" AND TestCoordinator=\""+frmDashboard.StaffUserID+"\"";
           ResultSet rsl = sl.executeQuery(strl);
           String sd1;
           while(rsl.next()){
             sd1=rsl.getString(1);
             dlm.addElement(sd1);
           }
             jList1.setModel(dlm);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e, "Could not fetch data.",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        lblTestID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTestName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTestDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTestTime = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDuration = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblStudentName = new javax.swing.JLabel();
        lblEmailId = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnEnrol = new javax.swing.JButton();
        btnDeny = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Tests Enrolment Approvals");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jList1.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTestID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Test ID:");

        lblTestName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Test Name: ");

        lblTestDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Test Date:");

        lblTestTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Test Time:");

        jLabel8.setText("Duration:");

        lblDuration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(17, 17, 17)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTestDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTestTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTestID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTestName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(27, 27, 27)
                        .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTestID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTestTime, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        jList2.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Student ID:");

        jLabel6.setText("Student Name:");

        jLabel7.setText("Email Address:");

        lblStudentID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblStudentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblEmailId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudentID, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(lblStudentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmailId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(lblEmailId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnEnrol.setText("Enrol Student");
        btnEnrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrolActionPerformed(evt);
            }
        });

        btnDeny.setText("Deny Enrolment");
        btnDeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeny)
                    .addComponent(btnEnrol, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnEnrol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeny)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        String str = jList1.getSelectedValue();
        try{
            Statement sl = conn.createStatement();
            String var="Y";
            String strl = "SELECT TestName,TestDate,StartTime,Duration from tests WHERE Status=\""+var+"\" AND TestID=\""+str+"\"";
            ResultSet rsl = sl.executeQuery(strl);
            while(rsl.next()){
                lblTestID.setText(str);
                lblTestName.setText(rsl.getString(1));
                lblTestDate.setText(rsl.getString(2));
                lblTestTime.setText(rsl.getString(3));
                lblDuration.setText(rsl.getString(4));
            }
            var="P";
            Statement s2=conn.createStatement();
            String str2="SELECT StudentID from testsenrolreq WHERE Status=\""+var+"\" AND TestID=\""+lblTestID.getText()+"\"";
            ResultSet rs2=s2.executeQuery(str2);
            String sl2;
            dlm2=new DefaultListModel();
            while(rs2.next()){
             sl2=rs2.getString(1);
             dlm2.addElement(sl2);   
            }
            jList2.setModel(dlm2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e, "Could not fetch data for this test.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        String str = jList2.getSelectedValue();
        try{
            Statement sl = conn.createStatement();            
            String strl = "SELECT StudentName,EmailAddress from oapstudents WHERE StudentID=\""+str+"\"";
            ResultSet rsl = sl.executeQuery(strl);
            while(rsl.next()){
                lblStudentID.setText(str);
                lblStudentName.setText(rsl.getString(1));
                lblEmailId.setText(rsl.getString(2));
            }
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(this,e, "Could not fetch data for this student.",JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_jList2ValueChanged

    private void btnEnrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrolActionPerformed
       try{
       if(jList1.getSelectedValue().equals("") || jList2.getSelectedValue().equals("")){
         JOptionPane.showMessageDialog(this,"Invalid selection.");
         return ;
       }
       }
       catch(Exception e){
           return ;
       }
           try{
           Statement sl = conn.createStatement();
           String var="A";
           String strl = "UPDATE testsenrolreq SET Status=\""+var+"\""+"WHERE StudentID=\""+lblStudentID.getText() + "\" AND TestID=\""+lblTestID.getText()+"\"";
           sl.executeUpdate(strl);
           String msg=lblStudentName.getText()+",\n\nYou have been enrolled for the test ( "+lblTestID.getText()+" ) "+lblTestName.getText()+" to be conducted on "+lblTestDate.getText()+" at "+lblTestTime.getText()+
            "\nThe test duration is of "+lblDuration.getText()+" minutes."+"\nYour Enrolment Status was updated on "+frmDashboard.getServerDateTime()+" by "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\nAll the best for the test!"+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(lblEmailId.getText(),"OAP Test Enrolment Status Update",msg);
            dlm2.removeElement(lblStudentID.getText());
           jList2.setModel(dlm2);
           ResetStudent();
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(this,"Error!\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnEnrolActionPerformed
    private void ResetStudent(){
        lblStudentID.setText("");
        lblStudentName.setText("");
        lblEmailId.setText("");
    }
    private void btnDenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenyActionPerformed
        try{
            if(jList1.getSelectedValue().equals("") || jList2.getSelectedValue().equals("")){
                JOptionPane.showMessageDialog(this,"Invalid selection.");
                return ;
            }
            
        }
        catch (Exception e){
            return ;
        }
           try{
           String reason=JOptionPane.showInputDialog("Reason: ");
           String msg=lblStudentName.getText()+",\n\nYou had applied for enrollment to the test ( "+lblTestID.getText()+" ) "+lblTestName.getText()+" to be conducted on "+lblTestDate.getText()+" at "+lblTestTime.getText()+
           ".\nYour request has been denied, henceforth you are not allowed to appear for the said examination."+"\nReason: "+reason+"\nYour Enrolment Status was updated on "+frmDashboard.getServerDateTime()+" by: "+frmDashboard.StaffName+" , "+frmDashboard.StaffDesignation+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";        
           SendEmail.send(lblEmailId.getText(),"OAP Test Enrolment Status Update",msg);
           Statement sl = conn.createStatement();
           String strl = "DELETE FROM testsenrolreq WHERE StudentID=\""+lblStudentID.getText() + "\" AND TestID=\""+lblTestID.getText()+"\"";
           sl.executeUpdate(strl);
           dlm2.removeElement(lblStudentID.getText());
           jList2.setModel(dlm2);
           ResetStudent();
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(this,"Error!\n"+e);
       }
    }//GEN-LAST:event_btnDenyActionPerformed
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
            java.util.logging.Logger.getLogger(frmManageTestEnrolment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManageTestEnrolment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManageTestEnrolment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManageTestEnrolment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmManageTestEnrolment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeny;
    private javax.swing.JButton btnEnrol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblTestDate;
    private javax.swing.JLabel lblTestID;
    private javax.swing.JLabel lblTestName;
    private javax.swing.JLabel lblTestTime;
    // End of variables declaration//GEN-END:variables
}
