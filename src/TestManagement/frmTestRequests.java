package TestManagement;

import Common.SendEmail;
import Common.ServerConfig;
import Common.frmDashboard;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class frmTestRequests extends javax.swing.JFrame {

    /**
     * Creates new form frmTestRequests
     */
    private Connection conn;
    private PreparedStatement s;
    
    String sUserID,sDesignation,sEmail;
    
    int TestID = 1;
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmTestRequests() {
        initComponents();
        sUserID=frmDashboard.StaffUserID;
        sDesignation=frmDashboard.StaffDesignation;
        sEmail=frmDashboard.StaffEmailID;
        JTextFieldDateEditor editor = (JTextFieldDateEditor) calDate.getDateEditor();
        editor.setEditable(false);
        cbHour.removeAllItems();
        cbMinute.removeAllItems();
        cbSecond.removeAllItems();
        FillTimeCb();
        try{
            setConnection();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(this,e, "Database Connection Error",JOptionPane.ERROR_MESSAGE);
               this.dispose();
           }
    }
    private void FillTimeCb(){
        int i;
        for(i=0;i<=9;++i){
            cbHour.addItem("0"+i);
            cbMinute.addItem("0"+i);
            cbSecond.addItem("0"+i);
        }
        for(i=10;i<=23;++i){
            cbHour.addItem(""+i);
            cbMinute.addItem(""+i);
            cbSecond.addItem(""+i);
        }
        for(i=24;i<=59;++i){
            cbMinute.addItem(""+i);
            cbSecond.addItem(""+i);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTestName = new javax.swing.JTextField();
        calDate = new com.toedter.calendar.JDateChooser();
        txtDuration = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRequest = new javax.swing.JButton();
        cbHour = new javax.swing.JComboBox<>();
        cbMinute = new javax.swing.JComboBox<>();
        cbSecond = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Test Name:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Test Date:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Test Time:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Duration:");

        calDate.setMaxSelectableDate(new java.util.Date(4638886269000L));
        calDate.setMinSelectableDate(new java.util.Date(1483212669000L));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText(":");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText(":");

        btnRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRequest.setForeground(new java.awt.Color(255, 0, 0));
        btnRequest.setText("Send Test Request");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        cbHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbSecond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(cbSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtTestName)
                                    .addComponent(calDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(calDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(385, 274));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        try{
            try{
                Date d1 = null;
                String sqlstr="SELECT MAX(TestID) FROM tests";
                Statement s1=conn.createStatement();
                ResultSet rs1=s1.executeQuery(sqlstr);
                
                while(rs1.next()){
                if(rs1.getString(1)==null)
                    TestID=1;
                else
                    TestID=Integer.parseInt(rs1.getString(1))+1;
            }
            }
            catch(SQLException | NumberFormatException e){
                TestID=1;
            }
            s=conn.prepareStatement("INSERT INTO tests VALUES(?,?,?,?,?,?,?,?)");
            s.setInt(1,TestID);
            s.setString(2,txtTestName.getText());
            s.setString(3, sUserID);
            java.util.Date utilDate = calDate.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            s.setDate(4,sqlDate);
            String TestTime = ((cbHour.getSelectedItem()+":").concat(cbMinute.getSelectedItem()+":")).concat((String) cbSecond.getSelectedItem());
            try{
                 DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                 Date d1 = dateFormat.parse(TestTime);
                 java.sql.Time sqlTime=new java.sql.Time(d1.getTime());
                 s.setTime(5,sqlTime);
            }
            catch(ParseException | SQLException e){
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            s.setString(6, txtDuration.getText());
            s.setString(7, "P");
            s.setString(8, "10");
            s.executeUpdate();
            String msg=sUserID+",\nYour request for conducting the test has been sent to the Administrator for approval. You will notified of the status of the test via email soon."+
"\nHere are the test details for your reference.\n\nTest ID: ( "+TestID+" )\nTest Name: "+txtTestName.getText()+"\nTest Date: "+sqlDate.toString()+"\nTest Time: "+TestTime+"\nDuration: "+txtDuration.getText()+"\nRequest sent on  "+frmDashboard.getServerDateTime()+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            
            SendEmail.send(sEmail,"OAP Test Request Sent",msg);
           }
           catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Database Error.", JOptionPane.ERROR_MESSAGE);
           }
           catch(HeadlessException ex){
               throw ex;
                //JOptionPane.showMessageDialog(this,ex,"This record, does not meet data integrity rules.\n"+ex, JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_btnRequestActionPerformed

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
            java.util.logging.Logger.getLogger(frmTestRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTestRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTestRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTestRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTestRequests().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRequest;
    private com.toedter.calendar.JDateChooser calDate;
    private javax.swing.JComboBox<String> cbHour;
    private javax.swing.JComboBox<String> cbMinute;
    private javax.swing.JComboBox<String> cbSecond;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtTestName;
    // End of variables declaration//GEN-END:variables
}
