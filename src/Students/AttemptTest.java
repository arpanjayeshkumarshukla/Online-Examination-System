package Students;

import Common.SendEmail;
import Common.ServerConfig;
import Common.frmDashboard;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class AttemptTest extends javax.swing.JFrame {

    private Connection conn;
    private final int SetNo;
    private int DurationRemaining;
    private String ResponseString;
    private final Timestamp SessionExpiry;  
    private int CurrentSrNo;
    private final int TestID;
    int CountQ;
    Statement quesID_stmt;
    ResultSet rs;
    int arr[];
    private Timer timer=null;
    private int sessionClosed;
    private void setConnection() throws SQLException{
        conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
    }
    public AttemptTest(int TID,int SetNumber,int Duration,String responseStr,Timestamp ts) {
        initComponents();
        this.sessionClosed = 0;
        TestID=TID;
        SetNo=SetNumber;
        DurationRemaining=Duration;
        if(responseStr==null){
            ResponseString="";
            CurrentSrNo=0;
        }
        else{
            ResponseString=responseStr;
            CurrentSrNo=ResponseString.length();
        }
        SessionExpiry=ts;
        LoadQuestions();
        try{
            setConnection();
            PreparedStatement pstmt=conn.prepareStatement("SELECT CURRENT_TIMESTAMP");
            ResultSet rsTime=pstmt.executeQuery();
            Timestamp currTimestamp = null,TimeLeft;
            if(rsTime.next()){
                currTimestamp=rsTime.getTimestamp(1);
            }
            if(!SessionExpiry.after(currTimestamp)){
                JOptionPane.showMessageDialog(this,"Your test session has expired, calculating your scores now...","Session Expired!",JOptionPane.INFORMATION_MESSAGE);
                closeSession();
            }
            else{
                TimeLeft=new Timestamp(SessionExpiry.getTime()-currTimestamp.getTime());
                long DurationinMillis=DurationRemaining*60*1000;
                if(TimeLeft.getTime()<DurationinMillis){
                    DurationinMillis=TimeLeft.getTime();
                    DurationRemaining=(int) (DurationinMillis/60000);
                }
                updateDuration();
                startTimer();
                if(FetchQuestion()==-1){
                    closeSession();
                }
            }
           }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this,"An error occurred while trying to load the test d ata.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this,"Kindly check connection settings and try again. If error persists, contact the invigilator and change your workstation.");
            InterruptSession();
        }
    }
    private void startTimer(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new countDownTask(DurationRemaining),1000,1000);
    }
    private class countDownTask extends TimerTask{
        int i;
        private countDownTask(int t){
            i=t*60;
        }
        @Override
        public void run() {
            lblTimeRemaining.setText(""+(i/60)+":"+(i%60));
            DurationRemaining=i/60;
            i--;
            if(i<0){
                {
                    BtnNext.setEnabled(false);
                    JOptionPane.showMessageDialog(null,"Time up! Your session has now expired , calculating scores now...","Session Expired!",JOptionPane.INFORMATION_MESSAGE);
                    this.cancel();
                    closeSession();
                }
            }
            else if(i%60==0){
                updateDuration();
            }
        }
    }
    private void updateDuration(){
        try{
            setConnection();
            PreparedStatement ps=conn.prepareStatement("UPDATE sessions SET DurationRemaining=? WHERE TestID=? AND StudentID=?");
            ps.setInt(1,DurationRemaining);
            ps.setInt(2,TestID);
            ps.setString(3,frmDashboard.StaffUserID);
            ps.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Unable to update test duration on the server. Kindly change your workstation.\nThis window will now close.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
            getAnswer();
            InterruptSession();
        }
    }
    private void LoadQuestions(){
        try{
            setConnection();
            PreparedStatement pstmt=conn.prepareStatement("SELECT COUNT(*) FROM qabank WHERE TestID=?");
            pstmt.setInt(1,TestID);
            ResultSet rsc=pstmt.executeQuery();            
            if(rsc.next()){
                CountQ=rsc.getInt(1);
                arr=new int[CountQ+1];
            }
            quesID_stmt=conn.createStatement();
            rs=quesID_stmt.executeQuery("SELECT QuestionID FROM sets WHERE TestID="+TestID+" ORDER BY Set"+SetNo+" ASC");
            int i=1;
            while(rs.next()){
                arr[i]=rs.getInt(1);
                i++;
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error!Unable to Load test questions for your set. This window will now close.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
            InterruptSession();
        }
    }
    private void closeSession(){
        if(sessionClosed==1){
            return ;
        }
        sessionClosed=1;
        if(timer!=null)
                timer.cancel();
        try{
            getAnswer();
            int score = CalculateScore();
            PreparedStatement ps=conn.prepareStatement("UPDATE studentstestsreports SET Score=? , ResponseString=? WHERE TestID=? AND StudentID=?");
            ps.setInt(1,score);
            ps.setString(2,ResponseString);
            ps.setInt(3,TestID);
            ps.setString(4,frmDashboard.StaffUserID);
            ps.executeUpdate();
            ps=conn.prepareStatement("DELETE FROM sessions WHERE TestID=? AND StudentID=?");
            ps.setInt(1,TestID);
            ps.setString(2,frmDashboard.StaffUserID);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Your score is "+score+".","Congratulations!",JOptionPane.INFORMATION_MESSAGE);
            String msg=frmDashboard.StaffName+",\nYou recently appeared for an exam ("+TestID+") on the Online Assessment Platform."+
                    "\nThe scores have been calculated and we would like to inform you that you scored "+score+" marks in this test."+
                    "\nCongratulations, and all the best for your forthcoming examinations."+"\n\nRegards,\nNotifications Mailer\nOnline Assessment Platform";
            SendEmail.send(frmDashboard.StaffEmailID,"OAP Test Result",msg);
            this.dispose();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error, cannot close the test.This window will now close.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
            InterruptSession();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpAnswers = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        optA = new javax.swing.JRadioButton();
        optB = new javax.swing.JRadioButton();
        optC = new javax.swing.JRadioButton();
        optD = new javax.swing.JRadioButton();
        BtnNext = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTimeRemaining = new javax.swing.JLabel();
        skipQ = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Online Test System");
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Question:");

        lblQuestion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Options:");

        btngrpAnswers.add(optA);
        optA.setText("Option A");
        optA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        optA.setBorderPainted(true);
        optA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAActionPerformed(evt);
            }
        });

        btngrpAnswers.add(optB);
        optB.setText("Option B");
        optB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        optB.setBorderPainted(true);
        optB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optBActionPerformed(evt);
            }
        });

        btngrpAnswers.add(optC);
        optC.setText("Option C");
        optC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        optC.setBorderPainted(true);
        optC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optCActionPerformed(evt);
            }
        });

        btngrpAnswers.add(optD);
        optD.setText("Option D");
        optD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        optD.setBorderPainted(true);
        optD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDActionPerformed(evt);
            }
        });

        BtnNext.setText("Next");
        BtnNext.setEnabled(false);
        BtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNextActionPerformed(evt);
            }
        });

        jLabel3.setText("Time Remaining:");

        lblTimeRemaining.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btngrpAnswers.add(skipQ);
        skipQ.setText("Skip this Question");
        skipQ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        skipQ.setBorderPainted(true);
        skipQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(optD, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(optC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(optB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(optA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTimeRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnNext, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(skipQ, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optA, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel3)
                    .addComponent(lblTimeRemaining, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optB, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(optC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(skipQ, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnNext)
                        .addGap(13, 13, 13))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int FetchQuestion(){
        try{
            CurrentSrNo++;
            Statement question_stmt=conn.createStatement();
            ResultSet rs2 = null;
            if(CurrentSrNo==(CountQ+1)){
                JOptionPane.showMessageDialog(this,"Test is over.");
                return -1;
            }
            rs2=question_stmt.executeQuery("SELECT Question,OptionA,OptionB,OptionC,OptionD FROM qabank WHERE QuestionID="+arr[CurrentSrNo]);
            if(rs2.next()){
                lblQuestion.setText(rs2.getString(1));
                optA.setText(rs2.getString(2));
                optB.setText(rs2.getString(3));
                optC.setText(rs2.getString(4));
                optD.setText(rs2.getString(5));
            }
            return 0;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Unable to fetch next question from the server. This window will now close.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
            InterruptSession();
            return -1;
        }
    }
    private int CalculateScore(){
        try{
            setConnection();
            int i;
            int score=0,marks;
            Statement ps;
            ResultSet rsans;
            String ans,choice;
            for(i=1;i<=ResponseString.length();++i){
                ps=conn.createStatement();
                rsans=ps.executeQuery("SELECT Answer,Marks FROM qabank WHERE TestID="+TestID+" AND QuestionID="+arr[i]);    
                while(rsans.next()){
                    ans=rsans.getString(1);
                    marks=rsans.getInt(2);
                    choice=""+ResponseString.charAt(i-1);
                    if(choice.equals(ans))
                        score+=marks;
                }
            }
            return score;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"An error occurred while calculating the score.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);           
            return -1;
        }
    }
    private void updateResponseString(char Ans){
        ResponseString=ResponseString+Ans;
        try{
            setConnection();
            PreparedStatement ps=conn.prepareStatement("UPDATE sessions SET ResponseString=? WHERE TestID=? AND StudentID=?");
            ps.setString(1,ResponseString);
            ps.setInt(2,TestID);
            ps.setString(3,frmDashboard.StaffUserID);
            ps.executeUpdate();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Unable to update answers on the server.\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
            InterruptSession();
        }
    }
    private void InterruptSession(){
        if(timer!=null)
            timer.cancel();
        this.dispose();
    }
    private void getAnswer(){
        if(ResponseString.length()==CountQ){
            return ;
        }
        if(optA.isSelected())
            updateResponseString('A');
        else if(optB.isSelected())
            updateResponseString('B');
        else if(optC.isSelected())
            updateResponseString('C');
        else if(optD.isSelected())
            updateResponseString('D');
        else if(skipQ.isSelected())
            updateResponseString('E');
        btngrpAnswers.clearSelection();
    }
    
    private void BtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNextActionPerformed
        if(btngrpAnswers.getSelection()==null)
        {
            JOptionPane.showMessageDialog(this,"Please select one amongst the given options.","Error!",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        getAnswer();
        if(FetchQuestion()==-1){
            closeSession();
        }
    }//GEN-LAST:event_BtnNextActionPerformed
    private void skipQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipQActionPerformed
        BtnNext.setEnabled(true);
    }//GEN-LAST:event_skipQActionPerformed

    private void optAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAActionPerformed
        BtnNext.setEnabled(true);
    }//GEN-LAST:event_optAActionPerformed

    private void optBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optBActionPerformed
        BtnNext.setEnabled(true);
    }//GEN-LAST:event_optBActionPerformed

    private void optCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optCActionPerformed
        BtnNext.setEnabled(true);
    }//GEN-LAST:event_optCActionPerformed

    private void optDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDActionPerformed
        BtnNext.setEnabled(true);
    }//GEN-LAST:event_optDActionPerformed
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
            java.util.logging.Logger.getLogger(AttemptTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttemptTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttemptTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttemptTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNext;
    private javax.swing.ButtonGroup btngrpAnswers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblTimeRemaining;
    private javax.swing.JRadioButton optA;
    private javax.swing.JRadioButton optB;
    private javax.swing.JRadioButton optC;
    private javax.swing.JRadioButton optD;
    private javax.swing.JRadioButton skipQ;
    // End of variables declaration//GEN-END:variables
}
