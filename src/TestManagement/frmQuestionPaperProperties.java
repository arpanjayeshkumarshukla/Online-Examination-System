package TestManagement;

import Common.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class frmQuestionPaperProperties extends javax.swing.JFrame {
    private Connection conn;
    private PreparedStatement s;
    private final int TestID;
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmQuestionPaperProperties(int x) {
        initComponents();
        TestID=x;
        txtTestID.setText(""+x);
        try{
            setConnection();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(this,e, "Database Connection Error", HEIGHT);
               this.dispose();
           }
        try{
           Statement sl = conn.createStatement();
           String strl = "SELECT COUNT(*) FROM qabank WHERE TestID="+TestID;
           ResultSet rsl = sl.executeQuery(strl);
           if(rsl.next()){
               txtTotalNoOfQuestions.setText(rsl.getString(1));
           }
           strl = "SELECT NoOfSets FROM tests WHERE TestID="+TestID;
           rsl = sl.executeQuery(strl);
           if(rsl.next()){
               txtTotalNoOfSets.setText(rsl.getString(1));
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e,"Error!",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSetQPaper = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalNoOfSets = new javax.swing.JTextField();
        txtTotalNoOfQuestions = new javax.swing.JTextField();
        txtTestID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Set Question Paper Properties");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        btnSetQPaper.setText("Set Question Paper");
        btnSetQPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetQPaperActionPerformed(evt);
            }
        });

        jLabel1.setText("Test ID:");

        jLabel2.setText("Total No. of Questions:");

        jLabel3.setText("Total No. of Sets(MAX10):");

        txtTotalNoOfSets.setNextFocusableComponent(btnSetQPaper);

        txtTotalNoOfQuestions.setFocusCycleRoot(true);
        txtTotalNoOfQuestions.setNextFocusableComponent(txtTotalNoOfSets);

        txtTestID.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalNoOfSets, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTestID, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                    .addComponent(txtTotalNoOfQuestions)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnSetQPaper)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTestID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotalNoOfQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalNoOfSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSetQPaper)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetQPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetQPaperActionPerformed
        try{
            s=conn.prepareStatement("UPDATE tests SET NoOfSets=? WHERE TestID=?");
            s.setString(1,txtTotalNoOfSets.getText());
            s.setString(2, txtTestID.getText());
            s.executeUpdate();
         }
        catch(Exception e){
             JOptionPane.showMessageDialog(this,"An error occurred while trying to update the details of this test.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
        new frmManageQuestionPaper(txtTestID.getText(),txtTotalNoOfQuestions.getText(),txtTotalNoOfSets.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSetQPaperActionPerformed

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
            java.util.logging.Logger.getLogger(frmQuestionPaperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuestionPaperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuestionPaperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuestionPaperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuestionPaperProperties(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetQPaper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtTestID;
    private javax.swing.JTextField txtTotalNoOfQuestions;
    private javax.swing.JTextField txtTotalNoOfSets;
    // End of variables declaration//GEN-END:variables
}
