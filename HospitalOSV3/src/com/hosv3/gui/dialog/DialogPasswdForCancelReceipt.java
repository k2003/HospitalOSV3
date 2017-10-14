/*
 * DialogPasswdForCancelReceipt.java
 *
 * Created on 10 �ѹ��¹ 2547, 18:33 �.
 */
package com.hosv3.gui.dialog;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import com.hosv3.control.*;
import com.hosv3.utility.*;
import com.hosv3.object.*;
import com.hospital_os.object.*;
import com.hosv3.utility.connection.*;
import com.hospital_os.utility.CryptPassword; 

/**
 *
 * @author amp
 */
public class DialogPasswdForCancelReceipt extends javax.swing.JFrame {
    
    HosControl theHC;
    HosObject theHO;
    JFrame aMain;
    
    public boolean actionCommand = false;
    SetupControl theSetupControl;
    BillingControl theBillingControl;
    LookupControl theLookupControl;
    Vector vOption;
    Option theOption;
    public static boolean closeDialog = false;
 

   /**add new code by noom*/
    public DialogPasswdForCancelReceipt(HosControl hc,UpdateStatus theUS){
        this.theHC = hc;
        this.aMain = theUS.getJFrame();
        theSetupControl = theHC.theSetupControl;
        theBillingControl = theHC.theBillingControl;
        theLookupControl = theHC.theLookupControl;
        initComponents();
        this.setTitle("�׹�ѹ���ʼ�ҹ");
        this.setIconImage(this.aMain.getIconImage());
        this.setDialog();
        setLanguage("");
        setDataAll();
        
    }
    
    private void setDataAll() {
        this.jPasswordFieldCancelReceipt.setText("");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordFieldCancelReceipt = new javax.swing.JPasswordField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jButtonOk, gridBagConstraints);

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel2.add(jButtonCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("\u0e23\u0e32\u0e22\u0e01\u0e32\u0e23\u0e16\u0e39\u0e01\u0e23\u0e31\u0e1a\u0e0a\u0e33\u0e23\u0e30\u0e40\u0e01\u0e34\u0e19 24 \u0e0a\u0e31\u0e48\u0e27\u0e42\u0e21\u0e07\u0e41\u0e25\u0e49\u0e27 \u0e1c\u0e39\u0e49\u0e21\u0e35\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e40\u0e17\u0e48\u0e32\u0e19\u0e31\u0e49\u0e19\u0e17\u0e35\u0e48\u0e08\u0e30\u0e2a\u0e32\u0e21\u0e32\u0e23\u0e16\u0e25\u0e1a\u0e44\u0e14\u0e49");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setText("\u0e16\u0e49\u0e32\u0e17\u0e48\u0e32\u0e19\u0e21\u0e35\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e01\u0e23\u0e38\u0e13\u0e32\u0e01\u0e23\u0e2d\u0e01 \u0e23\u0e2b\u0e31\u0e2a\u0e1c\u0e48\u0e32\u0e19:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        jPasswordFieldCancelReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldCancelReceiptActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 2, 0);
        jPanel3.add(jPasswordFieldCancelReceipt, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jPanel3, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**add new method by noom 25/05/48 when user enter its,program will check password on time*/
    private void jPasswordFieldCancelReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldCancelReceiptActionPerformed
        actionCommand = true;
        checkPasswd();
    }//GEN-LAST:event_jPasswordFieldCancelReceiptActionPerformed
        private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
            actionCommand = false;
            dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed
            private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
                actionCommand = true;
                checkPasswd();
    }//GEN-LAST:event_jButtonOkActionPerformed
            
            /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        this.closeDialog = true;
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //  new DialogAdmit(new javax.swing.JFrame(), true).setVisible(true);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordFieldCancelReceipt;
    // End of variables declaration//GEN-END:variables
    private void checkPasswd() 
    {
        this.theOption = new Option();
        this.theOption = theLookupControl.readOption();
        String passwd = String.valueOf(jPasswordFieldCancelReceipt.getPassword());
        passwd = CryptPassword.encryptText(passwd.trim());
        if(this.theOption.passwd_cancel_receipt.equalsIgnoreCase(""))
            JOptionPane.showMessageDialog(this,"�ѧ������ա�� Set ���ʼ�ҹ ��س����� Set ���ǹ�ͧ Setup","��͹",JOptionPane.OK_OPTION);
        else {
            if(passwd.equals(this.theOption.passwd_cancel_receipt)) {
                if(JOptionPane.showConfirmDialog(this,"ź��¡��","��͹",JOptionPane.OK_CANCEL_OPTION) ==  JOptionPane.OK_OPTION) {
                    //henbe_error this.theBillingControl.CallNotifyCancelReceipt(true);
                    dispose();
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"���ʼ�ҹ���١��ͧ","��͹",JOptionPane.OK_OPTION);

                /**add new code by noom 25/05/2548 for reset old password*/
                setDataAll();
            }
        }
    }
    
    /*-----------------------------------------------------------*/
    private void setDialog() {
        this.setSize(350,140);
        
        Toolkit thekit = this.getToolkit();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width-this.getSize().width)/2, (screenSize.height-this.getSize().height)/2);
        
    }
    
     /**add code by noom 25/05/2548 for reset TextField of password*/
    public boolean showDialog() {
        setDataAll();
        
        this.setVisible(true);
        return this.closeDialog;
    }
    
 
    public void setLanguage(String msg) 
    {
        GuiLang.setLanguage(jButtonOk);
	GuiLang.setLanguage(jButtonCancel);
        GuiLang.setLanguage(jLabel1);
        GuiLang.setLanguage(jLabel2);
    }
    
}
