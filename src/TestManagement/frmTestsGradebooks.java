package TestManagement;

import Common.ServerConfig;
import Common.frmDashboard;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dell
 */
public class frmTestsGradebooks extends javax.swing.JFrame {

     private Connection conn;
    DefaultListModel dlm = new DefaultListModel();
    private void setConnection(){
        try{
            conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"An error occurred while connecting to the server.\n"+e,"Connection Error!",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
    private void LoadTests(){
        try{
            Statement sl = conn.createStatement();
            String strl="SELECT TestID FROM tests WHERE Status=\""+"S"+"\""+" OR Status=\""+"R" +"\" AND TestCoordinator=\""+frmDashboard.StaffUserID+"\"";
            ResultSet rsl = sl.executeQuery(strl);
            while(rsl.next()){
                dlm.addElement(rsl.getString(1));
            }
            jList1.setModel(dlm);
        }
        catch(SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(this,e, "Could not fetch data.",JOptionPane.ERROR_MESSAGE);
        }
    }
    public frmTestsGradebooks() {
        initComponents();
        setConnection();
        LoadTests();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Tests Gradebooks");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(17, 17, 17)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTestDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTestTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTestID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTestName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(27, 27, 27)
                        .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTestID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTestTime, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        jList1.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Set Number", "Test DateTime", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table);

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnExport)
                        .addGap(87, 87, 87)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(776, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        String str = jList1.getSelectedValue();
        int tid=Integer.parseInt(str);
        ShowTestDetails(tid);
        GradeSessions(tid);
        ShowGradeBook(tid);
    }//GEN-LAST:event_jList1ValueChanged
    public void toExcel(JTable table, File file){
    try{
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + ",");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString()+",");
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}
    private int CountIncompleteSessions(int TestID) {
        String sql="SELECT Count(*) FROM studentstestsreports WHERE TestID="+TestID+" AND Score Is Null AND ResponseString Is Not Null";
        int ans=-1;
        try{
            Statement s=conn.createStatement();
            ResultSet rscount=s.executeQuery(sql);
            if(rscount.next())
                ans=rscount.getInt(1);
            rscount.close();
            s.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this,"Unable to count incomplete sessions for the test ID: "+TestID+"\n"+ex,"Error, while determining number of incomplete sessions: ",JOptionPane.ERROR_MESSAGE);
             ans= -1;
         }
        return ans;
    }
    private int CountQuestions(int TestID){
        PreparedStatement pstmt;
        int ans=0;
         try {
             pstmt=conn.prepareStatement("SELECT COUNT(*) FROM qabank WHERE TestID=?");
             pstmt.setInt(1,TestID);
             ResultSet rsquescount=pstmt.executeQuery();            
             if(rsquescount.next()){
                ans=rsquescount.getInt(1);
              }
             rsquescount.close();
             pstmt.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this,"Unable to count number of questions for the test ID: "+TestID+"\n"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
             ans= -1;
         }
        return ans;
    }
    private void GradeSessions(int TestID){
        if(CountIncompleteSessions(TestID)==0){
            return ;
        }
        String sql="SELECT StudentID,SetNo,ResponseString FROM studentstestsreports WHERE TestID="+TestID+" AND Score Is Null AND ResponseString Is Not Null";
        try{
            Statement s=conn.createStatement();
            Statement qs=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            ResultSet rsans;
            ResultSet rsq;
            String ans;
            int marks;
            int score,i,SetNo;
            int arr[]=new int[CountQuestions(TestID)+1];
            String choice,ResponseString;
            while(rs.next()){
                score=0;
                SetNo=rs.getInt(2);
                ResponseString=rs.getString(3);
                rsq=qs.executeQuery("SELECT QuestionID FROM sets WHERE TestID="+TestID+" ORDER BY Set"+SetNo+" ASC");
                i=1;
                while(rsq.next()){
                    arr[i]=rsq.getInt(1);
                    i++;
                }
                for(i=1;i<=ResponseString.length();++i){
                    rsans=qs.executeQuery("SELECT Answer,Marks FROM qabank WHERE TestID="+TestID+" AND QuestionID="+arr[i]);
                    if(rsans.next()){
                        ans=rsans.getString(1);
                        marks=rsans.getInt(2);
                        choice=""+ResponseString.charAt(i-1);
                        if(choice.equals(ans))
                            score+=marks;
                    }
                }
                PreparedStatement ps=conn.prepareStatement("UPDATE studentstestsreports SET Score=? WHERE TestID=? AND StudentID=?");
                ps.setInt(1,score);
                ps.setInt(2,TestID);
                ps.setString(3,rs.getString(1));
                ps.executeUpdate();
            }
            }            
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(this,"Unable to grade sessions for the test ID: "+TestID+"\n"+ex,"Error, while determining number of incomplete sessions: ",JOptionPane.ERROR_MESSAGE);
         }
    }
    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        
        //JFileChooser fc=new JFileChooser(); 
    //fc.showOpenDialog(this); 
    //File f=fc.getSelectedFile();
        File f = new File(lblTestID.getText()+"_"+lblTestName.getText()
                +"_"+lblTestDate.getText()+"_"+"grades.csv");
         
         try {
             f.createNewFile();
         } catch (IOException ex) {
             Logger.getLogger(frmTestsGradebooks.class.getName()).log(Level.SEVERE, null, ex);
         }
             toExcel(table,f);     
             
             JOptionPane.showMessageDialog(this, "Data Exported Successfully..","" , HEIGHT);
    }//GEN-LAST:event_btnExportActionPerformed
    private void ShowTestDetails(int tid){
        try{
            setConnection();
            Statement sl = conn.createStatement();
            String strl="SELECT TestName,TestDate,StartTime,Duration FROM tests WHERE TestID="+tid;
            ResultSet rsl = sl.executeQuery(strl);
            while(rsl.next()){
                lblTestID.setText(""+tid);
                lblTestName.setText(rsl.getString(1));
                lblTestDate.setText(rsl.getString(2));
                lblTestTime.setText(rsl.getString(3));
                lblDuration.setText(rsl.getString(4));
            }
        }
        catch(SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(this,e, "Could not fetch data for this test.",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void ShowGradeBook(int tid){
        try{
            setConnection();
            Statement s2=conn.createStatement();
            String sql2 = "SELECT studentstestsreports.StudentID,StudentName,SetNo,TestDateTime,Score FROM studentstestsreports,oapstudents,tests WHERE tests.TestCoordinator=\""+frmDashboard.StaffUserID+"\" AND studentstestsreports.TestID="+tid+" AND oapstudents.StudentID=studentstestsreports.StudentID";
            ResultSet rs2=s2.executeQuery(sql2);
            DefaultTableModel t=(DefaultTableModel) table.getModel();
            t.setRowCount(0);
            while(rs2.next()){
                t.addRow(new String[]{rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5)});
            }
        }
        catch(SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(this,e, "Could not fetch data for this test.",JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(frmTestsGradebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTestsGradebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTestsGradebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTestsGradebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblTestDate;
    private javax.swing.JLabel lblTestID;
    private javax.swing.JLabel lblTestName;
    private javax.swing.JLabel lblTestTime;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
