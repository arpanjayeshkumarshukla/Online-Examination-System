package Students;

import Common.ServerConfig;
import Common.frmDashboard;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Dell
 */
public class MyUpcomingTests extends javax.swing.JFrame {
    private Connection conn;
    private PreparedStatement s,s2;
    private ResultSet rs,rs2;    
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public MyUpcomingTests() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        DefaultTableModel t=(DefaultTableModel) table.getModel();
        String EnrolmentStatus = null;
        String TestStatus;
        t.setRowCount(0);
        try{
            setConnection();
            
            s=conn.prepareStatement("SELECT TestID,Status FROM testsenrolreq WHERE StudentID=? ORDER BY Status");
            s.setString(1,frmDashboard.StaffUserID);
            rs=s.executeQuery();
            while(rs.next()){   
                s2=conn.prepareStatement("SELECT TestName,TestCoordinator,TestDate,StartTime,Duration,Status FROM tests WHERE TestID=?");
                s2.setString(1,rs.getString(1));
                if(rs.getString(2).equals("A"))
                    EnrolmentStatus="Enrolled";
                else
                    EnrolmentStatus="Pending Approval.";
                rs2=s2.executeQuery();
                if(rs2.next()){
                        TestStatus="Enrol";
                        t.addRow(new String[]{rs.getString(1),rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5),EnrolmentStatus,TestStatus});
                }
            }
            s=conn.prepareStatement("SELECT TestID,SessionStatus FROM sessions WHERE StudentID=? ORDER BY SessionStatus DESC");
            s.setString(1,frmDashboard.StaffUserID);
            rs=s.executeQuery();
            int flag;
            while(rs.next()){
                flag=1;
                s2=conn.prepareStatement("SELECT TestName,TestCoordinator,TestDate,StartTime,Duration,Status FROM tests WHERE TestID=?");
                s2.setString(1,rs.getString(1));
                if(rs.getString(2).equals("Not Started"))
                    EnrolmentStatus="Session Not Started";
                else if(rs.getString(2).equals("Running"))
                    EnrolmentStatus="Running Session";
                else if(rs.getString(2).equals("Absent"))
                    EnrolmentStatus="Absent";
                rs2=s2.executeQuery();
                if(rs2.next()){
                    switch (rs2.getString(6)) {
                        case "X":
                            TestStatus="Inactive";
                            break;
                        default:
                            TestStatus="Running";
                            break;
                    }
                    if(flag==1)
                        t.addRow(new String[]{rs.getString(1),rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5),EnrolmentStatus,TestStatus});
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Error! Unable to fetch data from server.",JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        BtnStartTest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("My Tests");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Test Name", "Test Coordinator", "Test Date", "Start Time", "Duration", "Enrolment Status", "Test Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(1);
        }

        BtnStartTest.setText("Start Test");
        BtnStartTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStartTestActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("My Upcoming Tests");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(BtnStartTest)
                .addContainerGap(444, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(BtnStartTest)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(959, 364));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void BtnStartTestActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int i = table.getSelectedRow();
        try{
            if(!table.getValueAt(i,7).equals("Running"))
        {
            JOptionPane.showMessageDialog(this,"The selected test has not started yet. Please wait for the status to change to Running.","Error! Cannot start test.",JOptionPane.ERROR_MESSAGE);
            return;
        }   
        String TestID=(String) table.getValueAt(i,0);
        setConnection();
        s=conn.prepareStatement("SELECT SetNo,DurationRemaining,ResponseString,SessionExpiryTimestamp FROM sessions WHERE TestID=? AND StudentID=?");
        s.setString(1, TestID);
        s.setString(2,frmDashboard.StaffUserID);
        rs=s.executeQuery();
        if(rs.next()){
                int SetNo = rs.getInt(1);
                int Duration = rs.getInt(2);
                String ResponseString = rs.getString(3);
                Timestamp SessionExpiry = rs.getTimestamp(4);
                if(table.getValueAt(i,6).equals("Session Not Started")){
                    PreparedStatement ps=conn.prepareStatement("UPDATE sessions SET SessionStatus=? WHERE TestID=? AND StudentID=?");
                    ps.setString(2,TestID);
                    ps.setString(3,frmDashboard.StaffUserID);
                    ps.setString(1,"Running");
                    ps.executeUpdate();
                    ps=conn.prepareStatement("SELECT CURRENT_TIMESTAMP");
                    ResultSet rs2=ps.executeQuery();
                    Timestamp curr = null;
                    if(rs2.next())
                        curr=rs2.getTimestamp(1);
                    ps=conn.prepareStatement("INSERT INTO `studentstestsreports` (`StudentID`, `TestID`, `SetNo`, `TestDateTime`, `Score`, `ResponseString`) VALUES (?,?,?,?,NULL,NULL)");
                    ps.setString(1,frmDashboard.StaffUserID);
                    ps.setString(2, TestID);
                    ps.setInt(3, SetNo);
                    ps.setTimestamp(4,curr);
                    ps.executeUpdate();
                }
                AttemptTest TestScreen=new AttemptTest(Integer.parseInt(TestID),SetNo,Duration,ResponseString,SessionExpiry);
                TestScreen.setExtendedState(TestScreen.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                TestScreen.setVisible(true);
                TestScreen.setResizable(false);
                this.dispose();
        }
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, e,"Invalid selection.",JOptionPane.ERROR_MESSAGE);
        }
        catch(HeadlessException | SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(this,"An error occurred with details as follows:\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
        
    }                                            

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
            java.util.logging.Logger.getLogger(MyUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyUpcomingTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyUpcomingTests().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BtnStartTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable table;
    // End of variables declaration                   
}
