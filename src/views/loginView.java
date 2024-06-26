/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;





import com.mysql.jdbc.Connection;
import connection.DataBaseConnection;
import controller.authenController;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_Account;
import model.Model_User;
import views.signupView;

/**
 *
 * @author admin
 */
public class loginView extends javax.swing.JFrame {
  authenController controller = new authenController();
    private void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    public loginView() {
       initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_left = new javax.swing.JPanel();
        left_title = new javax.swing.JLabel();
        changeForm_btn = new javax.swing.JButton();
        logo_app = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        form = new javax.swing.JPanel();
        form_title = new javax.swing.JLabel();
        userName_lable = new javax.swing.JLabel();
        userName_text = new javax.swing.JTextField();
        password_lable = new javax.swing.JLabel();
        password_text = new javax.swing.JPasswordField();
        login_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 255));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        form_left.setBackground(new java.awt.Color(204, 204, 255));
        form_left.setPreferredSize(new java.awt.Dimension(440, 720));

        left_title.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        left_title.setText("Bạn chưa có tài khoản ?");

        changeForm_btn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        changeForm_btn.setText("Đăng Ký");
        changeForm_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeForm_btnActionPerformed(evt);
            }
        });

        logo_app.setText("logo o day");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout form_leftLayout = new javax.swing.GroupLayout(form_left);
        form_left.setLayout(form_leftLayout);
        form_leftLayout.setHorizontalGroup(
            form_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_leftLayout.createSequentialGroup()
                .addGroup(form_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(form_leftLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(form_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(left_title)
                            .addGroup(form_leftLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(changeForm_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(form_leftLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(form_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo_app, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        form_leftLayout.setVerticalGroup(
            form_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, form_leftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo_app)
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addComponent(left_title, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeForm_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );

        getContentPane().add(form_left);
        form_left.setBounds(0, 0, 390, 720);

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setMinimumSize(new java.awt.Dimension(640, 720));
        form.setName(""); // NOI18N
        form.setPreferredSize(new java.awt.Dimension(640, 720));

        form_title.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        form_title.setText("Đăng nhập");
        form_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        userName_lable.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        userName_lable.setText("Tên tài khoản");

        userName_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userName_textActionPerformed(evt);
            }
        });

        password_lable.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        password_lable.setText("Mật khẩu");

        password_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_textActionPerformed(evt);
            }
        });

        login_btn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        login_btn.setText("Đăng nhập");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                        .addComponent(form_title)
                        .addGap(61, 61, 61))
                    .addComponent(userName_text)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                        .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                        .addComponent(password_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))
                    .addComponent(password_text)
                    .addComponent(userName_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(form_title)
                .addGap(50, 50, 50)
                .addComponent(userName_lable)
                .addGap(10, 10, 10)
                .addComponent(userName_text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(password_lable)
                .addGap(10, 10, 10)
                .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        form_title.getAccessibleContext().setAccessibleParent(this);
        userName_text.getAccessibleContext().setAccessibleName("email_text");
        login_btn.getAccessibleContext().setAccessibleName("login_btn");

        getContentPane().add(form);
        form.setBounds(390, 0, 690, 720);
        form.getAccessibleContext().setAccessibleName("form");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        
       try {
            authenController controller = new authenController();
            String userName = this.userName_text != null ? this.userName_text.getText() : "";
            char[] passwordChars = this.password_text.getPassword();

            if (controller.accountExists(userName)==false) {
                showErrorDialog("Tài khoản này không tồn tại");
                return;
            }
            
            if (passwordChars.length == 0 || new String(passwordChars).trim().isEmpty()) {
                showErrorDialog("Không được để trống mật khẩu!!!");
                return;
            }
            Model_Account account = controller.getOneAccount(userName);
            
            if (account==null){
                showErrorDialog("Tài khoản không tồn tại!");
                return;
            }
             if (!new String(passwordChars).trim().equals(account.getPassword())) {
                showErrorDialog("Sai mật khẩu");
                return;
            }
             JOptionPane.showMessageDialog(this, "Đăng nhập thành công.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

        } catch (HeadlessException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_login_btnActionPerformed

    private void userName_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userName_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userName_textActionPerformed

    private void password_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_textActionPerformed

    private void changeForm_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeForm_btnActionPerformed
    signupView  signup = new signupView();
    this.dispose();
       
       
    }//GEN-LAST:event_changeForm_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeForm_btn;
    private javax.swing.JPanel form;
    private javax.swing.JPanel form_left;
    private javax.swing.JLabel form_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel left_title;
    private javax.swing.JButton login_btn;
    private javax.swing.JLabel logo_app;
    private javax.swing.JLabel password_lable;
    private javax.swing.JPasswordField password_text;
    private javax.swing.JLabel userName_lable;
    private javax.swing.JTextField userName_text;
    // End of variables declaration//GEN-END:variables
}
