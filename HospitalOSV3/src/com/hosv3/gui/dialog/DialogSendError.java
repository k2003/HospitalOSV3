/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogSendError.java
 *
 * Created on 24 ��.�. 2553, 14:20:11
 */
package com.hosv3.gui.dialog;

import com.hosv3.object.HosObject;
import com.hosv3.utility.GuiLang;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author LionHearth
 */
public class DialogSendError extends java.awt.Dialog {

    /** Creates new form DialogSendError */
    HosObject theHO;
    public DialogSendError(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jEditorPaneTitle.setEditable(false);
        //������� EditorPane setLineWrap ��
        jEditorPaneTitle.setEditorKit(new StyledEditorKit());
        jEditorPaneTitle.setContentType("text/html");
        setLanguage();
    }

    public void setLanguage()
    {
        GuiLang.setLanguage(jToggleButtonEdit);
        GuiLang.setLanguage(jCheckBoxSendLog);
        GuiLang.setLanguage(jButtonSendReportError);
        GuiLang.setLanguage(jButtonDontSend);
    }

    public void setTitle1(String title) {
        jEditorPaneTitle.setText("<html><body><b><font size=5>���ѭ�� " + title + "</font></b></body></html>");
    }

    public void setException(String exception) {
        jTextAreaException.setText(exception);
    }

    public String getException() {
        if (jCheckBoxSendLog.isSelected()) {
            return jTextAreaException.getText() + "sendlog";
        } else {
            return jTextAreaException.getText();
        }
    }
    public void setHosObject(HosObject ho)
    {
        theHO = ho;
    }

    public String showSendError(String title, String error_message) {
        setSize(528, 341);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getSize().width) / 2, (screenSize.height - getSize().height) / 2);
        setTitle(title);
        setTitle1(title);
        setException(error_message);
        String working_dir = System.getProperty("user.dir");
        File f = new File(working_dir + File.separator + "config" + File.separator + "sendlog.txt");
        if (theHO.is_attach_file_to_mail) {
            setSendLog(true);
        } else {
            setSendLog(false);
        }
        setVisible(true);
        return getException();
    }

    public void setSendLog(boolean b) {
        jCheckBoxSendLog.setSelected(b);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        defaultFont1 = new com.hospital_os.gui.font.DefaultFont();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonSendReportError = new javax.swing.JButton();
        jButtonDontSend = new javax.swing.JButton();
        jToggleButtonEdit = new javax.swing.JToggleButton();
        jCheckBoxSendLog = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaException = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPaneTitle = new javax.swing.JEditorPane();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonSendReportError.setFont(defaultFont1);
        jButtonSendReportError.setText("����§ҹ��ͼԴ��Ҵ");
        jButtonSendReportError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendReportErrorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel2.add(jButtonSendReportError, gridBagConstraints);

        jButtonDontSend.setFont(defaultFont1);
        jButtonDontSend.setText("�����");
        jButtonDontSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDontSendActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel2.add(jButtonDontSend, gridBagConstraints);

        jToggleButtonEdit.setFont(defaultFont1);
        jToggleButtonEdit.setText("��䢢�ͤ���");
        jToggleButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jToggleButtonEdit, gridBagConstraints);

        jCheckBoxSendLog.setFont(defaultFont1);
        jCheckBoxSendLog.setText("Ṻ Log");
        jCheckBoxSendLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSendLogActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jCheckBoxSendLog, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        jTextAreaException.setBackground(new java.awt.Color(236, 233, 216));
        jTextAreaException.setColumns(20);
        jTextAreaException.setEditable(false);
        jTextAreaException.setFont(defaultFont1);
        jTextAreaException.setLineWrap(true);
        jTextAreaException.setRows(5);
        jTextAreaException.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaException);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(jPanel1, gridBagConstraints);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(23, 75));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(108, 75));

        jEditorPaneTitle.setFont(defaultFont1);
        jScrollPane2.setViewportView(jEditorPaneTitle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 2);
        add(jScrollPane2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        jTextAreaException.setText("");
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jToggleButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEditActionPerformed
        if (jToggleButtonEdit.isSelected()) {
            jTextAreaException.setEditable(true);
            jTextAreaException.setBackground(Color.WHITE);
            jTextAreaException.requestFocus();
        } else {
            jTextAreaException.setEditable(false);
            jTextAreaException.setBackground(new Color(236, 233, 216));
        }
    }//GEN-LAST:event_jToggleButtonEditActionPerformed

    private void jButtonSendReportErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendReportErrorActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonSendReportErrorActionPerformed

    private void jButtonDontSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDontSendActionPerformed
        jTextAreaException.setText("");
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonDontSendActionPerformed

    private void jCheckBoxSendLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSendLogActionPerformed
        if(jCheckBoxSendLog.isSelected())
            theHO.is_attach_file_to_mail = true;
        else
            theHO.is_attach_file_to_mail = false;
    }//GEN-LAST:event_jCheckBoxSendLogActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DialogSendError dialog = new DialogSendError(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private javax.swing.JButton jButtonDontSend;
    private javax.swing.JButton jButtonSendReportError;
    private javax.swing.JCheckBox jCheckBoxSendLog;
    private javax.swing.JEditorPane jEditorPaneTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaException;
    private javax.swing.JToggleButton jToggleButtonEdit;
    // End of variables declaration//GEN-END:variables
}
