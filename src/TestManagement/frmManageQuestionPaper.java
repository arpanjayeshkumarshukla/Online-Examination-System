package TestManagement;

import Common.ServerConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class frmManageQuestionPaper extends javax.swing.JFrame {

    private Connection conn;
    private PreparedStatement s;
    int TID,TNQ,TNS,lastQ;
    int count=0;
    DefaultListModel dlm = new DefaultListModel();
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public frmManageQuestionPaper(String TestID,String TotalNoOfQue,String TotalNoOfSets) {
        initComponents();
        TID=Integer.parseInt(TestID);
        TNQ=Integer.parseInt(TotalNoOfQue);
        TNS=Integer.parseInt(TotalNoOfSets);
        LoadList();
    }
    private void LoadList(){
        try{
            setConnection();
            s=conn.prepareStatement("SELECT QuestionID from qabank WHERE TestID=?");
            s.setInt(1,TID);
            dlm.removeAllElements();
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                dlm.addElement(rs.getString(1));
            }
            lsQuestionID.setModel(dlm);
            count=dlm.size();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(this,e, "Database Connection Error", JOptionPane.ERROR_MESSAGE);
           }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        btnADD = new javax.swing.JButton();
        txtQuestion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOptionA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOptionB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOptionC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtOptionD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbAnswer = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtMarks = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsQuestionID = new javax.swing.JList<>();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        BtnFinish = new javax.swing.JButton();

        jButton2.setText("jButton2");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Questions");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        lblQuestion.setText("Question No. 1:");

        btnADD.setText("Add");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });

        txtQuestion.setEditable(false);
        txtQuestion.setNextFocusableComponent(txtOptionA);

        jLabel4.setText("Option A:");

        txtOptionA.setEditable(false);
        txtOptionA.setNextFocusableComponent(txtOptionB);

        jLabel5.setText("Option B:");

        txtOptionB.setEditable(false);
        txtOptionB.setNextFocusableComponent(txtOptionC);

        jLabel6.setText("Option C:");

        txtOptionC.setEditable(false);
        txtOptionC.setNextFocusableComponent(txtOptionD);

        jLabel7.setText("Option D:");

        txtOptionD.setEditable(false);
        txtOptionD.setNextFocusableComponent(cbAnswer);

        jLabel8.setText("Answer:");

        cbAnswer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        cbAnswer.setNextFocusableComponent(txtMarks);

        jLabel9.setText("Marks:");

        txtMarks.setEditable(false);

        lsQuestionID.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsQuestionID.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lsQuestionID);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        BtnFinish.setText("Finish and Start Enrolment");
        BtnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuestion)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnADD)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOptionD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtOptionC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOptionB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOptionA, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnFinish)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion)
                    .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtOptionD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnADD)
                            .addComponent(btnEdit)
                            .addComponent(btnUpdate)
                            .addComponent(btnSave)
                            .addComponent(btnCancel)
                            .addComponent(btnDelete)
                            .addComponent(BtnFinish)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(752, 276));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     private void ClearForm(){
         txtQuestion.setText("");
         txtOptionA.setText("");
         txtOptionB.setText("");
         txtOptionC.setText("");
         txtOptionD.setText("");
         cbAnswer.setSelectedItem("A");
         txtMarks.setText("");
    }
    private void switchAdd(boolean a){       
        txtQuestion.setEditable(a);
        txtOptionA.setEditable(a);
        txtOptionB.setEditable(a);
        txtOptionC.setEditable(a);
        txtOptionD.setEditable(a);
        txtMarks.setEditable(a);
        btnADD.setEnabled(!a);
        btnSave.setEnabled(a);
        btnCancel.setEnabled(a);
        btnEdit.setEnabled(!a);
        btnDelete.setEnabled(!a);
        btnUpdate.setEnabled(false);
    }
    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        if(count!=TNQ){
            lblQuestion.setText("Question No. "+(count+1));
            ClearForm();
            switchAdd(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"You have already set the maximum no. of questions defined earlier.");
            return ;
        }
    }//GEN-LAST:event_btnADDActionPerformed
    private void switchEdit(boolean b){
         txtQuestion.setEditable(b);
         txtOptionA.setEditable(b);
         txtOptionB.setEditable(b);
         txtOptionC.setEditable(b);
         txtOptionD.setEditable(b);
         txtMarks.setEditable(b);
         btnSave.setEnabled(false);
         btnDelete.setEnabled(!b);
         btnUpdate.setEnabled(b);
         btnCancel.setEnabled(b);
         btnADD.setEnabled(!b);
         btnEdit.setEnabled(!b);
    }
     private void startSituation(boolean c){
         btnADD.setEnabled(c);
         btnSave.setEnabled(!c);
         btnEdit.setEnabled(c);
         btnUpdate.setEnabled(!c);
         btnDelete.setEnabled(c);
         btnCancel.setEnabled(!c);
         txtQuestion.setEditable(false);
         txtOptionA.setEditable(false);
         txtOptionB.setEditable(false);
         txtOptionC.setEditable(false);
         txtOptionD.setEditable(false);
         txtMarks.setEditable(false);
     }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(!lsQuestionID.getSelectedValue().equals("")){
            switchEdit(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ClearForm();
        if (btnSave.isEnabled()==true)
        {
            switchAdd(false);
        }
        else if(btnUpdate.isEnabled()==true)
            switchEdit(false); 
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if("".equals(txtMarks.getText())){
            JOptionPane.showMessageDialog(this,"Please enter the marks for this question.");
            return ;
        }
        try{
            setConnection();
            s=conn.prepareStatement("INSERT INTO qabank VALUES(?,?,?,?,?,?,?,?,?)");
            s.setInt(1,TID);
            s.setInt(2,count+1);
            s.setString(3,txtQuestion.getText());
            s.setString(4,txtOptionA.getText());
            s.setString(5,txtOptionB.getText());
            s.setString(6,txtOptionC.getText());
            s.setString(7,txtOptionD.getText());
            s.setString(8,cbAnswer.getSelectedItem().toString());
            s.setInt(9,Integer.parseInt(txtMarks.getText()));
            s.executeUpdate();
            ClearForm();
            startSituation(true);
            count++;            
            Integer q=count;
            dlm.addElement(q.toString());
            lsQuestionID.setModel(dlm);
            }
           catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Database Error.", JOptionPane.ERROR_MESSAGE);
           }
        switchAdd(false);
    }//GEN-LAST:event_btnSaveActionPerformed
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try{
            int QID=Integer.parseInt(lsQuestionID.getSelectedValue());
            s=conn.prepareStatement("UPDATE qabank SET Question=?, OptionA=? , OptionB=? , OptionC=? , OptionD=? , Answer=? , Marks=? WHERE TestID=? AND QuestionID=?");
            s.setString(1,txtQuestion.getText());
            s.setString(2, txtOptionA.getText());
            s.setString(3, txtOptionB.getText());
            s.setString(4, txtOptionC.getText());
            s.setString(5, txtOptionD.getText());
            s.setString(6,cbAnswer.getSelectedItem().toString());
            s.setInt(7,Integer.parseInt(txtMarks.getText()));
            s.setInt(8,TID);
            s.setInt(9,QID);
            s.executeUpdate();
           }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,e,"Database Error.", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(this,ex,"Error while updating record.New data may not meet data integrity rules.", JOptionPane.ERROR_MESSAGE);
        }
        switchEdit(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
       
        String str=lsQuestionID.getSelectedValue();
        startSituation(true);
       try{
            Statement sl = conn.createStatement();
            String strl = "SELECT Question,OptionA,OptionB,OptionC,OptionD,Answer,Marks from qabank WHERE QuestionID="+str;
            ResultSet rsl = sl.executeQuery(strl);
            String sd1,sd2,sd3,sd4,sd5,sd6;
                   sd1 = sd2 = sd3  = sd4 = sd5 = sd6= "";
            String sd7 = null;
           lblQuestion.setText("Question No. "+str);
           while(rsl.next()){
              sd1=rsl.getString(1);
              sd2=rsl.getString(2);
              sd3=rsl.getString(3);
              sd4=rsl.getString(4);
              sd5=rsl.getString(5);
              sd6=rsl.getString(6);
              sd7=rsl.getString(7);
           }
           txtQuestion.setText(sd1);
           txtOptionA.setText(sd2);
           txtOptionB.setText(sd3);
           txtOptionC.setText(sd4);
           txtOptionD.setText(sd5);
           cbAnswer.setSelectedItem(sd6);
           txtMarks.setText(sd7);
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e,"Error!",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_listValueChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(lsQuestionID.getSelectedValue()==null){
            JOptionPane.showMessageDialog(this,"Choose a Question ID to delete a question.","Error!",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        int q=Integer.parseInt(lsQuestionID.getSelectedValue());
        try{
            s=conn.prepareStatement("DELETE FROM qabank WHERE TestID=? AND QuestionID=?");
            s.setInt(1,TID);
            s.setInt(2,q);
            s.executeUpdate();
            int i;
            for(i=q+1;i<=count;++i){
                s=conn.prepareStatement("UPDATE qabank SET QuestionID=? WHERE TestID=? AND QuestionID=? ORDER BY QuestionID ASC");
                s.setInt(1,i-1);
                s.setInt(2,TID);
                s.setInt(3, i);
                s.executeUpdate();
            }
            count--;
            LoadList();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e,"Error! Unable to delete records.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
public static int[] shuffle ( int a[], int n )
{
    int[] arr;
    arr = Arrays.copyOf(a,a.length);
    Random rand;
    rand = new Random();
    int temp;
    // Start from the last element and swap one by one. We don't
    // need to run for the first element that's why i > 0
    for (int i = n-1; i > 0; i--)
    {
        // Pick a random index from 0 to i
        int j=rand.nextInt(i+1);
        // Swap arr[i] with the element at random index
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    return arr;
}
private void GenerateSets(){
        int i,CountQ = 0,CountSets = 0;
        int []arr = null;
        try{
            setConnection();
            PreparedStatement pstmt;
            pstmt=conn.prepareStatement("DELETE FROM sets WHERE TestID=?");
            pstmt.setInt(1,TID);
            pstmt.executeUpdate();
            pstmt=conn.prepareStatement("SELECT COUNT(*) FROM qabank WHERE TestID=?");
            pstmt.setInt(1,TID);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                CountQ=rs.getInt(1);
                arr=new int[CountQ];
            }
            for(i=1;i<=CountQ;++i){
                arr[i-1]=i;
            }
            pstmt=conn.prepareStatement("SELECT NoOfSets FROM tests WHERE TestID=?");
            pstmt.setInt(1,TID);
            rs=pstmt.executeQuery();
            if(rs.next()){
                CountSets=rs.getInt(1);
            }
            int[][] sets=new int[CountSets][CountQ];
            for(i=0;i<CountSets;++i){
                sets[i]=shuffle(arr,arr.length);
            }
            Statement s=conn.createStatement();
            rs=s.executeQuery("SELECT QuestionID from qabank WHERE TestID="+TID+" ORDER BY QuestionID DESC");
            int k=0;
            PreparedStatement ps;
            while(rs.next()){
                ps=conn.prepareStatement("INSERT INTO sets VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
                int QuestionID=rs.getInt(1);
                ps.setInt(1,TID);
                ps.setInt(2,QuestionID);
                for(i=1;i<=CountSets;++i){
                    ps.setInt(2+i,sets[i-1][k]);
                }
                for(;i<=10;++i){
                    ps.setInt(2+i,0);
                }
                ps.executeUpdate();
                k++;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"An error occurred as follows: "+e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
}
    private void BtnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinishActionPerformed
        if(count!=TNQ){
            return ;
        }            
        try {            
              int i=JOptionPane.showConfirmDialog(this,"Do you want to finalize the Question Paper?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
              if(i==0){   
                s=conn.prepareStatement("UPDATE tests SET Status=? WHERE TestID=?");
                s.setString(1,"Y");
                s.setInt(2,TID);
                s.executeUpdate();
                JOptionPane.showMessageDialog(this,"The question paper has been set and enrolment for the test has begun.","Notification",JOptionPane.INFORMATION_MESSAGE);
                GenerateSets();
                JOptionPane.showMessageDialog(this,"Sets have been generated and saved.","Sets generated",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
              }
        }
        catch (SQLException e) {
           JOptionPane.showMessageDialog(this,"Error, unable to save data on server.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnFinishActionPerformed
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
            java.util.logging.Logger.getLogger(frmManageQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManageQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManageQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManageQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmManageQuestionPaper("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFinish;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbAnswer;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JList<String> lsQuestionID;
    private javax.swing.JTextField txtMarks;
    private javax.swing.JTextField txtOptionA;
    private javax.swing.JTextField txtOptionB;
    private javax.swing.JTextField txtOptionC;
    private javax.swing.JTextField txtOptionD;
    private javax.swing.JTextField txtQuestion;
    // End of variables declaration//GEN-END:variables
}
