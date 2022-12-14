/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view;

import hr.algebra.AdminFrame;
import hr.algebra.UserFrame;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Korisnik
 */
public class LoginUser extends javax.swing.JPanel {

    /**
     * Creates new form LoginUser
     */
    public LoginUser()  {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUsername = new javax.swing.JTextField();
        lbUsername = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        lbPassword = new javax.swing.JLabel();
        lbUsernameError = new javax.swing.JLabel();
        lbPasswordError = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        rbAdmin = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(1200, 773));

        lbUsername.setText("Username");

        lbPassword.setText("Password");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        rbAdmin.setText("Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbUsername)
                    .addComponent(lbPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAdmin)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPassword)
                            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbUsernameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnLogin)))
                .addContainerGap(610, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbUsername)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPassword)
                    .addComponent(lbPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addContainerGap(464, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
      try {
            checkUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

  
    public void checkUser (){
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        try {
         List<User> users = RepositoryFactory.getRepository().selectUsers();
         
         users.forEach(u->System.out.println(u.username + " " + u.password));
         
         users.forEach(u->{ 
             
             
             if(!username.equals(u.username) && password.equals(u.password) ){
                 lbUsernameError.setText("X");
                 lbPasswordError.setText("X");
                  if( rbAdmin.isSelected() == true && u.isAdmin() == false){
                     lbUsernameError.setText("X");
                     lbPasswordError.setText("X");
                     System.out.println("he's not admin");
                     
                 } 
                 
             }else if (!rbAdmin.isSelected() && u.isAdmin() == true)
                 {
                 lbUsernameError.setText("X");
                     lbPasswordError.setText("X");
                     System.out.println("he's admin, select the admin option");
                 
                 }
             
             
            
             
             else if(username.equals(u.username) && password.equals(u.password))
             {
                 
                 if(u.isAdmin() != true){
                 lbUsernameError.setText(" ");
                 lbPasswordError.setText(" ");
                     try {
                        UserFrame userFrame;
                        userFrame = new UserFrame();
                        userFrame.setVisible(true);
                        System.out.println("user has logged in");
                         
                     } catch (Exception ex) {
                         Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null, ex);
                     }
               
                 }

               else if(rbAdmin.isSelected() == u.isAdmin() && u.isAdmin() == true){
                    
                 lbUsernameError.setText(" ");
                 lbPasswordError.setText(" ");
                    AdminFrame frame = new AdminFrame();
                    frame.setVisible(true);
                    
                    
                }

             } 
             
         
         });
         
        
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbPasswordError;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lbUsernameError;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
