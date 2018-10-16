package TestManagement;

import Common.SendEmail;
import Common.ServerConfig;
import Common.frmDashboard;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class frmManageUpcomingTests extends javax.swing.JFrame {

    private Connection conn;
    private int tid;
    private java.sql.Date sqldate;
    private java.sql.Time sqltime;
    DefaultListModel dlm = new DefaultListModel();
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmManageUpcomingTests() {
        initComponents();
         ShowTests();  
         ResetForm();
    }
    private void ResetForm(){
        lblTestID.setText("");
        lblTestName.setText("");
        lblTestDate.setText("");
        lblTestTime.setText("");
        lblDuration.setText("");
        lblStatus.setText("");
        BtnCloseEnrolment.setEnabled(false);
        BtnManageQP.setEnabled(false);
    }
    private void ShowTests(){
        try{
            setConnection();
            dlm.removeAllElements();
            jList1.setModel(dlm);
            Statement sl = conn.createStatement();
            String strl="SELECT TestID FROM tests WHERE TestCoordinator=\""+frmDashboard.StaffUserID+"\" AND Status<>\""+"S"+"\"";
            ResultSet rsl = sl.executeQuery(strl);
            while(rsl.next()){
                dlm.addElement(rsl.getString(1));
            }
            jList1.setModel(dlm);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,e, "Could not fetch data.",JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        lblTestID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTestName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTestDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTestTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDuration = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        BtnCloseEnrolment = new javax.swing.JButton();
        BtnManageQP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Upcoming Tests Management Window");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jList1.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTestID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Test ID:");

        lblTestName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Test Name: ");

        lblTestDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Test Date:");

        lblTestTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Test Time:");

        jLabel10.setText("Duration:");

        lblDuration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Status:");

        lblStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTestTime, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTestDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTestName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTestID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTestID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTestTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BtnCloseEnrolment.setText("Close Enrolment");
        BtnCloseEnrolment.setEnabled(false);
        BtnCloseEnrolment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseEnrolmentActionPerformed(evt);
            }
        });

        BtnManageQP.setText("Question Paper");
        BtnManageQP.setEnabled(false);
        BtnManageQP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnManageQPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCloseEnrolment, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(BtnManageQP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(BtnManageQP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCloseEnrolment)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(719, 298));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        String str = jList1.getSelectedValue();
        if(str==null)
            return ;
        ResetForm();
        try{
            setConnection();
            Statement sl = conn.createStatement();
            tid=Integer.parseInt(str);
            String strl="SELECT TestName,TestDate,StartTime,Duration,Status FROM tests WHERE TestID="+tid;
            ResultSet rsl = sl.executeQuery(strl);
            while(rsl.next()){
                lblTestID.setText(str);
                lblTestName.setText(rsl.getString(1));
                
                sqldate=rsl.getDate(2);
                DateFormat ft=new SimpleDateFormat("dd MMM yyyy");
                lblTestDate.setText(ft.format(sqldate));
                
                sqltime=rsl.getTime(3);
                ft=new SimpleDateFormat("hh:mm:ss a");
                lblTestTime.setText(ft.format(sqltime));
                
                lblDuration.setText(rsl.getString(4));
                String var=rsl.getString(5);
                
                switch (var) {
                        case "R":
                            lblStatus.setText("Running");
                            break;
                        case "Y":
                            lblStatus.setText("Enrolment: Open");
                            BtnCloseEnrolment.setEnabled(true);
                            break;
                        case "X":
                            lblStatus.setText("Enrolment: Closed");
                            break;
                        case "A":
                            lblStatus.setText("Approved");
                            BtnManageQP.setEnabled(true);
                            break;
                        case "P":
                            lblStatus.setText("Pending");
                            break;
                    }
            }
        }
        catch(SQLException  | NumberFormatException e){
            JOptionPane.showMessageDialog(this,e, "Could not fetch data.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jList1ValueChanged
    private void ChangeStatus(String var){
        try{
            setConnection();
            Statement sl = conn.createStatement();
            String strl="UPDATE tests SET Status=\""+var+"\" WHERE TestID="+tid;
            sl.executeUpdate(strl);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void BtnCloseEnrolmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseEnrolmentActionPerformed
        ChangeStatus("X");
        try{
            setConnection();
            Statement sl = conn.createStatement();           
            String strl="DELETE FROM testsenrolreq WHERE Status=\""+"P"+"\" AND TestID="+tid;
            sl.executeUpdate(strl);
            JOptionPane.showMessageDialog(this,"All pending enrolment requests for this test have been deleted.","Enrolment Closed.",JOptionPane.INFORMATION_MESSAGE);
            AllocateSets(""+tid);
            sl = conn.createStatement();           
            strl="DELETE FROM testsenrolreq WHERE Status=\""+"A"+"\" AND TestID="+tid;
            sl.executeUpdate(strl);
            ShowTests();
            ResetForm();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this,e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnCloseEnrolmentActionPerformed

    private void BtnManageQPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnManageQPActionPerformed
        new frmQuestionPaperProperties(Integer.parseInt(lblTestID.getText())).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnManageQPActionPerformed
private void AllocateSets(String a){
        try{
            String str=a;
            if(str==null)
                return;
            int SelectedTestID=Integer.parseInt(str);
            setConnection();
            PreparedStatement pstmt;
            pstmt=conn.prepareStatement("SELECT NoOfSets from tests WHERE TestID=?");
            pstmt.setInt(1,SelectedTestID);
            ResultSet rs = pstmt.executeQuery();
            Timestamp sessionexpiryts = null;
            Timestamp deletesessionssts = null;
            int CountSets = 0;
            int Duration = 0;
            DateFormat ft=new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
            Date examstartdatetime = null;
            Date sessionexpirydatetime = null;
            try {
                examstartdatetime = ft.parse(lblTestDate.getText()+" "+lblTestTime.getText());
            } catch (ParseException ex) {
                Logger.getLogger(frmManageUpcomingTests.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date testclosetime = null,deletesessionsdatetime;
            if(rs.next()){
                CountSets=rs.getInt(1);
                Duration=Integer.parseInt(lblDuration.getText());
                int threshold = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter a threshold value in mintues to calculate the session expiry timestamp.",15));
                Calendar cal1=Calendar.getInstance();
                cal1.setTime(examstartdatetime);
                cal1.add(Calendar.MINUTE,Duration+threshold);
                sessionexpirydatetime=cal1.getTime();
                Calendar cal2=Calendar.getInstance();
                cal2.setTime(examstartdatetime);
                cal2.add(Calendar.MINUTE,threshold);
                testclosetime=cal2.getTime();
                Calendar cal3=Calendar.getInstance();
                cal3.setTime(examstartdatetime);
                cal3.add(Calendar.MINUTE,Duration+threshold+1);
                deletesessionsdatetime=cal3.getTime();
                sessionexpiryts=new Timestamp(sessionexpirydatetime.getTime());
                deletesessionssts = new Timestamp(deletesessionsdatetime.getTime());
            }
            pstmt=conn.prepareStatement("SELECT StudentID from testsenrolreq WHERE TestID=? ORDER BY StudentID ASC");
            pstmt.setInt(1,SelectedTestID);
            rs = pstmt.executeQuery();
            PreparedStatement ps=conn.prepareStatement("INSERT INTO sessions VALUES(?,?,?,?,?,?,?)");
            int i = 1;
            while(rs.next()){
                ps.setInt(1,SelectedTestID);
                ps.setString(2,rs.getString(1));
                ps.setInt(3,i);
                ps.setInt(4,Duration);
                ps.setString(5,"");
                ps.setTimestamp(6,sessionexpiryts);
                ps.setString(7,"Not Started");
                ps.executeUpdate();
                if(i==CountSets)
                    i=1;
                else
                    ++i;
            }
            Timestamp startexam=new Timestamp(examstartdatetime.getTime());
            Timestamp closeexam=new Timestamp(testclosetime.getTime());            
            String event="CREATE EVENT ScheduleTest"+SelectedTestID +" ON SCHEDULE AT \""+startexam+"\" DO UPDATE tests SET Status=\"R\""+" WHERE TestID="+SelectedTestID;
            System.out.println(event);
            ps.executeUpdate(event);
            event="CREATE EVENT MarkAbsenteesTest"+SelectedTestID +" ON SCHEDULE AT \""+closeexam+"\" DO UPDATE sessions SET SessionStatus=\""+"Absent"+"\" WHERE TestID="+SelectedTestID+" AND SessionStatus=\"Not Started\"";            
            System.out.println(event);
            ps.executeUpdate(event);
            event="CREATE EVENT SaveAbsenteesTest"+SelectedTestID +" ON SCHEDULE AT \""+sessionexpiryts+"\" DO INSERT INTO studentstestsreports(StudentID,TestID,SetNo,TestDateTime)\n"+"SELECT StudentID,TestID,SetNo,SessionExpiryTimestamp FROM sessions WHERE SessionStatus=\"Absent\"";           
            System.out.println(event);
            ps.executeUpdate(event);
            event="CREATE EVENT SaveSessionsTest"+SelectedTestID +" ON SCHEDULE AT \""+sessionexpiryts+"\" DO UPDATE studentstestsreports SET ResponseString=(SELECT ResponseString FROM sessions WHERE sessions.StudentID=studentstestsreports.StudentID AND sessions.TestID="+SelectedTestID+")";           
            System.out.println(event);
            ps.executeUpdate(event);
            event="CREATE EVENT CloseTest"+SelectedTestID +" ON SCHEDULE AT \""+deletesessionssts+"\" DO UPDATE tests SET Status=\"S\""+" WHERE TestID="+SelectedTestID+";";
            System.out.println(event);
            ps.executeUpdate(event);
            event="CREATE EVENT DeleteSessionsTest"+SelectedTestID +" ON SCHEDULE AT \""+deletesessionssts+"\" DO DELETE FROM sessions WHERE TestID="+SelectedTestID;
            System.out.println(event);
            ps.executeUpdate(event);
            String msg=frmDashboard.StaffName+",\n"+
            "Test sessions have been created and sets allocated to all the enrolled students. Kindly note the following schedule:\n"+
            "Test commences at "+lblTestDate.getText()+" "+lblTestTime.getText()+".\n"+
            "Candidates will not be allowed to start their test attempt after "+ft.format(testclosetime)+" and will be marked absent.\n"+
            "Test sessions will expire automatically at "+ft.format(sessionexpirydatetime)+".\nAll incomplete sessions will be automatically saved.\nYou will have to generate grades for such incomplete attempt sessions manually using the Publish Gradebook feature available in Test Gradebooks.";
            JOptionPane.showMessageDialog(this,msg,"Test Schedule",JOptionPane.INFORMATION_MESSAGE);
            SendEmail.send(frmDashboard.StaffEmailID,"Schedule for Test "+SelectedTestID, msg+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform");
        }
        catch(NumberFormatException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this,"An error occurred as follows: "+e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(frmManageUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManageUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManageUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManageUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmManageUpcomingTests().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCloseEnrolment;
    private javax.swing.JButton BtnManageQP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTestDate;
    private javax.swing.JLabel lblTestID;
    private javax.swing.JLabel lblTestName;
    private javax.swing.JLabel lblTestTime;
    // End of variables declaration//GEN-END:variables
}
