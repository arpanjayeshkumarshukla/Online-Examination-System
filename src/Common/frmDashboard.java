package Common;
import Administration.*;
import Students.*;
import TestManagement.frmManageTestEnrolment;
import TestManagement.frmTestsGradebooks;
import TestManagement.frmManageUpcomingTests;
import TestManagement.frmTestRequests;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
/**
 *
 * @author Dell
 */

 

public class frmDashboard extends javax.swing.JFrame {
    public static String StaffName,StaffDesignation,StaffEmailID,StaffUserID;
    BufferedImage img;
    int w=180;
    int h=205;
    public static String getServerDateTime(){
        Date dNow = null;
        SimpleDateFormat ft = new SimpleDateFormat ("E dd MMM yyyy 'at' hh:mm:ss a zzz");
        try{
            Connection conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
            PreparedStatement s=conn.prepareStatement("SELECT CURRENT_TIMESTAMP");
            ResultSet rsDT=s.executeQuery();
            if(rsDT.next()){
             return ft.format(rsDT.getTimestamp(1));
            }
        }catch(Exception e){
            dNow = new Date();
        }
        if(ft!=null)
            return (ft.format(dNow));
        else
            return null;
    }
    public frmDashboard(String Name,String Designation,String Email,String UserID,InputStream in) throws FileNotFoundException, IOException {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        StaffName=Name;
        StaffDesignation=Designation;
        StaffEmailID=Email;
        StaffUserID=UserID;
        lblUserID.setText(UserID);
        lblEmailID.setText(Email);
        lblDesignation.setText(Designation);
        lblName.setText(Name);
        int i=1;
         File f1=new File("test"+i+".jpg");
        OutputStream f = new FileOutputStream(f1);
        i++;
        
            int c = 0;
            while ((c = in.read()) > -1) {
                f.write(c);
            }
            in.close();
            f.close();
            
           if(f1.length()!=0){
        
                BufferedImage originalImage = ImageIO.read(f1);
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		ImageIO.write(resizeImageJpg, "jpg", f1);
        
        
                  
            
         String path=f1.getAbsolutePath(); 
         //lblPhoto.setIcon(new ImageIcon(path));
         lblPhoto.setIcon(new ImageIcon(resizeImageJpg));
               
               
           }
           else{
                   
         String path=f1.getAbsolutePath(); 
         //lblPhoto.setIcon(new ImageIcon(path));
         lblPhoto.setIcon(new ImageIcon(path));
           }
            /* img = ImageIO.read(f1);
             
             BufferedImage dimg = (BufferedImage) img.getScaledInstance(272, 290,        Image.SCALE_SMOOTH);

            ImageIcon imageIcon = new ImageIcon(dimg);*/
        
       
        if(Designation.equals("Administrator"))
        {
            mnuUserAccounts.setVisible(true);	
            mnuApprovals.setVisible(true);
            mnuTests.setVisible(false);
            mnuOnlineTestsSystem.setVisible(false);
            
        }
        else if(Designation.equals("Test Coordinator")){
            mnuUserAccounts.setVisible(false);	
            mnuApprovals.setVisible(false);
            mnuTests.setVisible(true);
            mnuOnlineTestsSystem.setVisible(false);
        }
        else if(Designation.equals("Student")){
            mnuUserAccounts.setVisible(false);	
            mnuApprovals.setVisible(false);
            mnuTests.setVisible(false);
            mnuOnlineTestsSystem.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    
    private BufferedImage resizeImage(BufferedImage originalImage, int type){
	BufferedImage resizedImage = new BufferedImage(w,h, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, w, h, null);
	g.dispose();

	return resizedImage;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblDesignation = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();
        lblEmailID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblPhoto = new javax.swing.JLabel();
        btnUploadPic = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuUserAccounts = new javax.swing.JMenu();
        mnuStaffAccounts = new javax.swing.JMenuItem();
        mnuRegStu = new javax.swing.JMenuItem();
        mnuView = new javax.swing.JMenu();
        mnuViewStaff = new javax.swing.JMenuItem();
        mnuViewStudents = new javax.swing.JMenuItem();
        mnuViewTests = new javax.swing.JMenuItem();
        mnuViewAnswerKey = new javax.swing.JMenuItem();
        mnuApprovals = new javax.swing.JMenu();
        mnuTestApprovals = new javax.swing.JMenuItem();
        mnuStudentAccountApprovals = new javax.swing.JMenuItem();
        mnuTests = new javax.swing.JMenu();
        mnuRequestForTest = new javax.swing.JMenuItem();
        mnuManageTest = new javax.swing.JMenuItem();
        mnuTestEnrolmentApprovals = new javax.swing.JMenuItem();
        mnuTestsReports = new javax.swing.JMenuItem();
        mnuOnlineTestsSystem = new javax.swing.JMenu();
        mnuEnrolForTests = new javax.swing.JMenuItem();
        mnuMyTests = new javax.swing.JMenuItem();
        mnuViewMyTestsReports = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuChangePassword = new javax.swing.JMenuItem();
        mnuLogOut = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Online Assessment Platform Dashboard");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDesignation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblUserID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblEmailID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Welcome");

        jLabel3.setText("Designation:");

        jLabel4.setText("Username:");

        jLabel5.setText("Email ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDesignation, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmailID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnUploadPic.setText("Upload Picture");
        btnUploadPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadPicActionPerformed(evt);
            }
        });

        mnuUserAccounts.setText("Manage Users");

        mnuStaffAccounts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuStaffAccounts.setText("Manage Staff");
        mnuStaffAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuStaffAccountsActionPerformed(evt);
            }
        });
        mnuUserAccounts.add(mnuStaffAccounts);

        mnuRegStu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        mnuRegStu.setText("Manage Students");
        mnuRegStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegStuActionPerformed(evt);
            }
        });
        mnuUserAccounts.add(mnuRegStu);

        jMenuBar1.add(mnuUserAccounts);

        mnuView.setText("View");

        mnuViewStaff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mnuViewStaff.setText("View Staff");
        mnuViewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewStaffActionPerformed(evt);
            }
        });
        mnuView.add(mnuViewStaff);

        mnuViewStudents.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        mnuViewStudents.setText("View Students");
        mnuViewStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewStudentsActionPerformed(evt);
            }
        });
        mnuView.add(mnuViewStudents);

        mnuViewTests.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        mnuViewTests.setText("View Upcoming Tests");
        mnuViewTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewTestsActionPerformed(evt);
            }
        });
        mnuView.add(mnuViewTests);

        mnuViewAnswerKey.setText("View Answer Key");
        mnuViewAnswerKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewAnswerKeyActionPerformed(evt);
            }
        });
        mnuView.add(mnuViewAnswerKey);

        jMenuBar1.add(mnuView);

        mnuApprovals.setText("Administrative Approvals");

        mnuTestApprovals.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnuTestApprovals.setText("Manage Tests Approvals ");
        mnuTestApprovals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTestApprovalsActionPerformed(evt);
            }
        });
        mnuApprovals.add(mnuTestApprovals);

        mnuStudentAccountApprovals.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mnuStudentAccountApprovals.setText("Manage Student Registrations Approvals");
        mnuStudentAccountApprovals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuStudentAccountApprovalsActionPerformed(evt);
            }
        });
        mnuApprovals.add(mnuStudentAccountApprovals);

        jMenuBar1.add(mnuApprovals);

        mnuTests.setText("Tests Management");

        mnuRequestForTest.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuRequestForTest.setText("File Tests Requests");
        mnuRequestForTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRequestForTestActionPerformed(evt);
            }
        });
        mnuTests.add(mnuRequestForTest);

        mnuManageTest.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mnuManageTest.setText("Tests Management Dashboard");
        mnuManageTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuManageTestActionPerformed(evt);
            }
        });
        mnuTests.add(mnuManageTest);

        mnuTestEnrolmentApprovals.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnuTestEnrolmentApprovals.setText("Tests Enrolment Management");
        mnuTestEnrolmentApprovals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTestEnrolmentApprovalsActionPerformed(evt);
            }
        });
        mnuTests.add(mnuTestEnrolmentApprovals);

        mnuTestsReports.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mnuTestsReports.setText("View Tests Gradebook");
        mnuTestsReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTestsReportsActionPerformed(evt);
            }
        });
        mnuTests.add(mnuTestsReports);

        jMenuBar1.add(mnuTests);

        mnuOnlineTestsSystem.setText("Students Online Tests System");

        mnuEnrolForTests.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        mnuEnrolForTests.setText("File Test Enrolment Requests");
        mnuEnrolForTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEnrolForTestsActionPerformed(evt);
            }
        });
        mnuOnlineTestsSystem.add(mnuEnrolForTests);

        mnuMyTests.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        mnuMyTests.setText("My Upcoming Tests");
        mnuMyTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMyTestsActionPerformed(evt);
            }
        });
        mnuOnlineTestsSystem.add(mnuMyTests);

        mnuViewMyTestsReports.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        mnuViewMyTestsReports.setText("My Gradebook");
        mnuViewMyTestsReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewMyTestsReportsActionPerformed(evt);
            }
        });
        mnuOnlineTestsSystem.add(mnuViewMyTestsReports);

        jMenuBar1.add(mnuOnlineTestsSystem);

        jMenu3.setText("Miscellaneous");

        mnuChangePassword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnuChangePassword.setText("Change Password");
        mnuChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuChangePasswordActionPerformed(evt);
            }
        });
        jMenu3.add(mnuChangePassword);

        mnuLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuLogOut.setText("Logout");
        mnuLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogOutActionPerformed(evt);
            }
        });
        jMenu3.add(mnuLogOut);

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu3.add(mnuExit);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnUploadPic)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUploadPic)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(653, 316));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogOutActionPerformed
        // TODO add your handling code here:
            this.dispose();
            new frmLogin().setVisible(true);
    }//GEN-LAST:event_mnuLogOutActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuStaffAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuStaffAccountsActionPerformed
        // TODO add your handling code here:
        new frmManageStaff().setVisible(true);
    }//GEN-LAST:event_mnuStaffAccountsActionPerformed

    private void mnuRegStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegStuActionPerformed
        // TODO add your handling code here:
        new frmManageStudents("Administrator").setVisible(true);
    }//GEN-LAST:event_mnuRegStuActionPerformed

    private void mnuStudentAccountApprovalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuStudentAccountApprovalsActionPerformed
        // TODO add your handling code here:
        new StudentApprovals().setVisible(true);
    }//GEN-LAST:event_mnuStudentAccountApprovalsActionPerformed

    private void mnuRequestForTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRequestForTestActionPerformed
        // TODO add your handling code here:
        new frmTestRequests().setVisible(true);
    }//GEN-LAST:event_mnuRequestForTestActionPerformed

    private void mnuManageTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuManageTestActionPerformed
        new frmManageUpcomingTests().setVisible(true);
    }//GEN-LAST:event_mnuManageTestActionPerformed

    private void mnuTestEnrolmentApprovalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTestEnrolmentApprovalsActionPerformed
        new frmManageTestEnrolment().setVisible(true);
    }//GEN-LAST:event_mnuTestEnrolmentApprovalsActionPerformed

    private void mnuTestApprovalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTestApprovalsActionPerformed
        // TODO add your handling code here:
        new frmTestApprovals().setVisible(true);
    }//GEN-LAST:event_mnuTestApprovalsActionPerformed

    private void mnuEnrolForTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEnrolForTestsActionPerformed
        new TestEnrolment().setVisible(true);
    }//GEN-LAST:event_mnuEnrolForTestsActionPerformed

    private void mnuMyTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMyTestsActionPerformed
        new MyUpcomingTests().setVisible(true);
    }//GEN-LAST:event_mnuMyTestsActionPerformed

    private void mnuViewStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewStudentsActionPerformed
        new frmViewStudents().setVisible(true);
    }//GEN-LAST:event_mnuViewStudentsActionPerformed

    private void mnuViewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewStaffActionPerformed
        new frmViewStaff().setVisible(true);
    }//GEN-LAST:event_mnuViewStaffActionPerformed

    private void mnuViewTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewTestsActionPerformed
        new frmViewUpcomingTests().setVisible(true);
    }//GEN-LAST:event_mnuViewTestsActionPerformed

    private void mnuViewMyTestsReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewMyTestsReportsActionPerformed
        new MyTestsReports().setVisible(true);
    }//GEN-LAST:event_mnuViewMyTestsReportsActionPerformed

    private void mnuChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuChangePasswordActionPerformed
        new ChangePassword().setVisible(true);
    }//GEN-LAST:event_mnuChangePasswordActionPerformed

    private void mnuTestsReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTestsReportsActionPerformed
        new frmTestsGradebooks().setVisible(true);
    }//GEN-LAST:event_mnuTestsReportsActionPerformed

    private void btnUploadPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadPicActionPerformed
        JFileChooser fc=new JFileChooser(); 
        fc.showOpenDialog(this); 
        File f;
        String path;
        try{
            f=fc.getSelectedFile(); 
            path=f.getAbsolutePath(); 
        }
        catch(NullPointerException e){
            return ;
        }
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(f);
        } catch (IOException ex) {
            Logger.getLogger(frmDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
        try {
            ImageIO.write(resizeImageJpg, "jpg", f);
        } catch (IOException ex) {
            Logger.getLogger(frmDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         //lblPhoto.setIcon(new ImageIcon(path));
         lblPhoto.setIcon(new ImageIcon(resizeImageJpg));
    //lblPhoto.setIcon(new ImageIcon(path));
     try{ 
        FileInputStream fin=new FileInputStream(f); 
        Connection conn=DriverManager.getConnection(ServerConfig.PATH,"oap","oap");
        PreparedStatement ps = null;
        if(StaffDesignation=="Student"){
           ps=conn.prepareStatement("UPDATE oapstudents SET photo=? WHERE StudentID=?");
        }
        else{
             ps=conn.prepareStatement("UPDATE staffaccounts SET photo=? WHERE UserID=?");
        }         
        int id =1;
        int len=(int)f.length();
        ps.setString(2, StaffUserID);
        ps.setBinaryStream(1, fin, len);
        ps.executeUpdate();  
    }catch(Exception e){
        System.out.println(e); 
    }
    }//GEN-LAST:event_btnUploadPicActionPerformed

    private void mnuViewAnswerKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewAnswerKeyActionPerformed
        try {
            // TODO add your handling code here:
            new frmViewAnswerKey().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuViewAnswerKeyActionPerformed

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
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        InputStream in2 = null;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmDashboard("","","","",in2).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(frmDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUploadPic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDesignation;
    private javax.swing.JLabel lblEmailID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JMenu mnuApprovals;
    private javax.swing.JMenuItem mnuChangePassword;
    private javax.swing.JMenuItem mnuEnrolForTests;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuLogOut;
    private javax.swing.JMenuItem mnuManageTest;
    private javax.swing.JMenuItem mnuMyTests;
    private javax.swing.JMenu mnuOnlineTestsSystem;
    private javax.swing.JMenuItem mnuRegStu;
    private javax.swing.JMenuItem mnuRequestForTest;
    private javax.swing.JMenuItem mnuStaffAccounts;
    private javax.swing.JMenuItem mnuStudentAccountApprovals;
    private javax.swing.JMenuItem mnuTestApprovals;
    private javax.swing.JMenuItem mnuTestEnrolmentApprovals;
    private javax.swing.JMenu mnuTests;
    private javax.swing.JMenuItem mnuTestsReports;
    private javax.swing.JMenu mnuUserAccounts;
    private javax.swing.JMenu mnuView;
    private javax.swing.JMenuItem mnuViewAnswerKey;
    private javax.swing.JMenuItem mnuViewMyTestsReports;
    private javax.swing.JMenuItem mnuViewStaff;
    private javax.swing.JMenuItem mnuViewStudents;
    private javax.swing.JMenuItem mnuViewTests;
    // End of variables declaration//GEN-END:variables
}
