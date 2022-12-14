/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fproject.window;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jack
 */
public class Window extends javax.swing.JFrame {
    private final static String[] columnHeaders = {"Website", "Username", "Password"};
    private DefaultTableModel accountsTableModel;
    private ArrayList<Account> accounts;
    private CompanyAPI api;
    
    /**
     * Creates new form Window
     */
    public Window() {
        api = new CompanyAPI();
        accountsTableModel = new DefaultTableModel(null, columnHeaders){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        accounts = new ArrayList<>();
        initComponents();
        loadAccounts();
    }
    
    private void update(){
        accountsTableModel = new DefaultTableModel(null, columnHeaders){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        for(Account a:accounts){
            accountsTableModel.addRow(a.getRow());
        }
        accTable.setModel(accountsTableModel);
    }
    
    public void saveAccounts(){
        try{
            FileOutputStream fout = new FileOutputStream("accounts.dat");
            ObjectOutputStream aout = new ObjectOutputStream(fout);
            for(Account a: accounts){
                aout.writeObject(a);
            }
        }
        catch(FileNotFoundException e){
            
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadAccounts(){
        try{
            FileInputStream fin = new FileInputStream("accounts.dat");
            ObjectInputStream ain = new ObjectInputStream(fin);
            Account a;
            while((a = (Account) ain.readObject()) != null){
                accounts.add(a);
            }
            
        }
        catch(FileNotFoundException e){
            
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } finally {
            update();
        }
    }
    
    public void returnFromSearch(Company company){
        if(company != null){
            String newUName = JOptionPane.showInputDialog(null, "Enter New Username", "Question: 1/2", JOptionPane.QUESTION_MESSAGE);
            String newPWord = JOptionPane.showInputDialog(null, "Enter New Password", "Question: 2/2", JOptionPane.QUESTION_MESSAGE);
            Account a = new Account(newUName, newPWord, company);
            accounts.add(a);
            update();
        }
        this.setEnabled(true);
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextSearchBar = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        accTable = new javax.swing.JTable();
        cboxSort = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchBarActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit Account");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        accTable.setModel(accountsTableModel);
        jScrollPane2.setViewportView(accTable);

        cboxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oldest to Newest" }));
        cboxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSortActionPerformed(evt);
            }
        });

        btnAdd.setText("Add Account");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Account");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxSort, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jTextSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
  
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jTextSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearchBarActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int i = accTable.getSelectedRow();
        if(i < 0 || i >= accounts.size()){
            return;
        }
        //String webName = (String) accountsTableModel.getValueAt(i, 0);
        String newUName = JOptionPane.showInputDialog(null, "Enter New Username", "Question: 1/2", JOptionPane.QUESTION_MESSAGE);
        String newPWord = JOptionPane.showInputDialog(null, "Enter New Password", "Question: 2/2", JOptionPane.QUESTION_MESSAGE);
        Account a = accounts.get(i);
        a.setUsername(newUName);
        a.setPassword(newPWord);
        update();     
    }//GEN-LAST:event_btnEditActionPerformed

    private void cboxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxSortActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new CompanySearchFrame(this).setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int i = accTable.getSelectedRow();
        if(i < 0 || i >= accounts.size()){
            return;
        }
        accounts.remove(i);
        accountsTableModel.removeRow(i);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        saveAccounts();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboxSort;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextSearchBar;
    // End of variables declaration//GEN-END:variables
}