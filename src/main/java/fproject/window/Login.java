package fproject.window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Jack
 */
public class Login extends javax.swing.JFrame {
    private File userFile;
    private boolean isFirstRun;
    private String password;
    /**
     * Creates new form Login
     */
    public Login() {
        userFile = new File("user.dat"); 
        System.out.println(userFile.getAbsolutePath());
        isFirstRun = !userFile.exists();
        initComponents();
        if(isFirstRun){
            btnlogin.setText("Sign Up");
        }else{
            jpf2.setVisible(false);
        }
    }

    public void saveUser(String password){
        try{
            FileOutputStream fout = new FileOutputStream(userFile);
            ObjectOutputStream uout = new ObjectOutputStream(fout);
            uout.writeObject(password);
        }
        catch(FileNotFoundException e){
            
        } catch (IOException ex) {
            
        }
    }
    public void loadUser(){
        try{
            FileInputStream fin = new FileInputStream(userFile);
            ObjectInputStream uin = new ObjectInputStream(fin);
            password = (String) uin.readObject();
        }
        catch(FileNotFoundException e){
            
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpf1 = new javax.swing.JPasswordField();
        jpf2 = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log in/Sign up");

        btnlogin.setText("Log in");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        lblerror.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblerror, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpf2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jpf1)
                            .addComponent(btnlogin, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        String pass1 = String.valueOf(jpf1.getPassword());
        if(isFirstRun){
            
            String pass2 = String.valueOf(jpf2.getPassword());
            System.out.println(pass1);
            System.out.println(pass2);
            if (pass1.equals(pass2)){
                saveUser(String.valueOf(jpf1.getPassword()));
                isFirstRun = false;
                btnlogin.setText("Log In");
                jpf2.setVisible(false);
            }
            else{
                lblerror.setText("Passwords Don't Match");
            }
        }
        else{
            loadUser();
            if (pass1.equals(password)){
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Window().setVisible(true);

                    }
                });
                this.dispose();
            }
            else{
                lblerror.setText("Incorrect Password");
            }
        }
        
    }//GEN-LAST:event_btnloginActionPerformed

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
            
        } catch (InstantiationException ex) {
           
        } catch (IllegalAccessException ex) {
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JPasswordField jpf1;
    private javax.swing.JPasswordField jpf2;
    private javax.swing.JLabel lblerror;
    // End of variables declaration//GEN-END:variables
}
