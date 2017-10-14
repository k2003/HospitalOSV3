/*
 * PanelSetupDrugStandard.java
 *
 * Created on 14 �չҤ� 2549, 9:52 �.
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.hosv3.gui.panel.setup;

import java.awt.*;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;

import com.hosv3.usecase.setup.*;
import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hosv3.utility.GuiLang;
import com.hospital_os.utility.*;
import com.hospital_os.object.*;

/**
 *
 * @author amp
 */

public class PanelSetupDrugStandard extends javax.swing.JPanel implements 
ManageOptionReq
{
    UpdateStatus theUS;
    SetupControl theSetupControl;
    DrugStandard theDrugStandard;
    Vector vDrugStandard = new Vector();
    int offset = 23;
    int next = 0;
    int prev = 0;
    int saved = 0;
    /** pu : 28/08/2549 : �� Index �ͧ ���ҵðҹ �����ҧ�ش�ͧ˹�һѨ�غѹ*/
    int curNext = 0;
    /** pu : 28/08/2549 : �� Index �ͧ ���ҵðҹ �����ҧ�ش�ͧ˹�ҡ�͹˹�һѨ�غѹ*/
    int curPrev = 0;
    String[] col = {"����","����"};
    
    /** Creates a new instance of PanelSetupDrugStandard */
    public PanelSetupDrugStandard(HosControl hc,UpdateStatus us)
    {
        initComponents();
        setLanguage();
        setControl(hc,us);
    }
    public PanelSetupDrugStandard()
    {
        initComponents();
        setLanguage();
    }
    
    /**
     *@Author : amp
     *@date : 14/03/2549
     *@see : �Ѵ�������ǡѺ����
     */
    private void setLanguage()
    {
        GuiLang.setLanguage(jLabel3);
        GuiLang.setLanguage(jLabelICD9code);
        GuiLang.setLanguage(jButtonSearch);
        GuiLang.setLanguage(jLabel1);
        GuiLang.setLanguage(jLabel2);
        GuiLang.setLanguage(jCheckBoxS);
        GuiLang.setLanguage(jButtonSave);
        GuiLang.setLanguage(jCheckBox1);
        GuiLang.setLanguage(col);
    }
    
/////////////////////Use this for decrease memory usage
    public void setControl(HosControl hc,UpdateStatus us)
    {
        theUS = us;
        theSetupControl = hc.theSetupControl;
        hc.theHS.theSetupSubject.addpanelrefrash(this);
        hc.theHS.theSetupSubject.addForLiftAttach(this);
        setEnableAll(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fontFormatTitle1 = new com.hospital_os.gui.font.FontFormatTitle();
        defaultFont1 = new com.hospital_os.gui.font.DefaultFont();
        fontFormatTitle2 = new com.hospital_os.gui.font.FontFormatTitle();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelICD9code = new javax.swing.JLabel();
        jTextFieldSCode = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jCheckBoxS = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new com.hosv3.gui.component.HJTableSort();
        jPanel5 = new javax.swing.JPanel();
        jButtonPrev = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaName = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDel = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(fontFormatTitle1);
        jLabel3.setText("\u0e0a\u0e37\u0e48\u0e2d\u0e2a\u0e32\u0e21\u0e31\u0e0d\u0e17\u0e32\u0e07\u0e22\u0e32 Generic Name");
        jPanel4.add(jLabel3, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jPanel4, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(300, 25));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 404));
        jLabelICD9code.setFont(defaultFont1);
        jLabelICD9code.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SEARCH"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 11);
        jPanel3.add(jLabelICD9code, gridBagConstraints);

        jTextFieldSCode.setFont(defaultFont1);
        jTextFieldSCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSCodeActionPerformed(evt);
            }
        });
        jTextFieldSCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSCodeKeyReleased(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(jTextFieldSCode, gridBagConstraints);

        jButtonSearch.setFont(defaultFont1);
        jButtonSearch.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SEARCH"));
        jButtonSearch.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSearch.setMaximumSize(new java.awt.Dimension(67, 25));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(67, 25));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(67, 25));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(jButtonSearch, gridBagConstraints);

        jCheckBoxS.setFont(defaultFont1);
        jCheckBoxS.setSelected(true);
        jCheckBoxS.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("ACTIVE"));
        jCheckBoxS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel3.add(jCheckBoxS, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 22));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 80));
        jTable1.setFont(defaultFont1);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jButtonPrev.setFont(defaultFont1);
        jButtonPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hospital_os/images/Back16.gif")));
        jButtonPrev.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonPrev.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonPrev.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel5.add(jButtonPrev, gridBagConstraints);

        jButtonNext.setFont(defaultFont1);
        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hospital_os/images/Forward16.gif")));
        jButtonNext.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonNext.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonNext.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel5.add(jButtonNext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(jPanel3, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(350, 120));
        jPanel2.setMinimumSize(new java.awt.Dimension(350, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 120));
        jLabel1.setFont(defaultFont1);
        jLabel1.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("CODE"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel1, gridBagConstraints);

        jTextFieldCode.setFont(defaultFont1);
        jTextFieldCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodeKeyReleased(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel2.add(jTextFieldCode, gridBagConstraints);

        jLabel2.setFont(defaultFont1);
        jLabel2.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("NAME"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jCheckBox1.setFont(defaultFont1);
        jCheckBox1.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("ACTIVE"));
        jCheckBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCheckBox1KeyReleased(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jCheckBox1, gridBagConstraints);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(150, 48));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(150, 48));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 48));
        jTextAreaName.setFont(defaultFont1);
        jTextAreaName.setLineWrap(true);
        jTextAreaName.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jPanel2, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonAdd.setFont(defaultFont1);
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/plus16.gif")));
        jButtonAdd.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAdd.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jButtonAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonAddKeyReleased(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jButtonAdd, gridBagConstraints);

        jButtonDel.setFont(defaultFont1);
        jButtonDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/minus16.gif")));
        jButtonDel.setEnabled(false);
        jButtonDel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonDel.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonDel.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonDel.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelActionPerformed(evt);
            }
        });
        jButtonDel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonDelKeyReleased(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel1.add(jButtonDel, gridBagConstraints);

        jButtonSave.setFont(defaultFont1);
        jButtonSave.setText("\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01\n");
        jButtonSave.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSave.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonSave.setPreferredSize(new java.awt.Dimension(60, 24));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jButtonSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonSaveKeyReleased(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jPanel1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxSActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxSActionPerformed
        //pu : 29/08/2549 : ��˹�������Ѻ Index ����Ѻ�кض֧˹�һѨ�غѹ�ͧ��¡��
        this.curNext = 0;
        this.curPrev = 0;
        search();
    }//GEN-LAST:event_jCheckBoxSActionPerformed

    private void jCheckBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox1KeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_UP)
        {
            jTextAreaName.requestFocus();
        }
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            jButtonAdd.requestFocus();
        }
    }//GEN-LAST:event_jCheckBox1KeyReleased

    private void jTextFieldCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodeKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            jTextAreaName.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldCodeKeyReleased

    private void jButtonSaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSaveKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
            jButtonDel.requestFocus();
        }
    }//GEN-LAST:event_jButtonSaveKeyReleased

    private void jButtonDelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonDelKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            jButtonSave.requestFocus();
        }
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
            jButtonAdd.requestFocus();
        }
    }//GEN-LAST:event_jButtonDelKeyReleased

    private void jButtonAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonAddKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            jButtonDel.requestFocus();
        }
        if(evt.getKeyCode() == KeyEvent.VK_UP)
        {
            jCheckBox1.requestFocus();
        }
    }//GEN-LAST:event_jButtonAddKeyReleased

    private void jTextFieldSCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSCodeKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            jTable1.requestFocus();
            jTable1.setRowSelectionInterval(0, 0);
            select();
        }
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) search();
        if(this.jTextFieldSCode.getText().length() > 1) search();
    }//GEN-LAST:event_jTextFieldSCodeKeyReleased
    private void jButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelActionPerformed
        delete();       
    }//GEN-LAST:event_jButtonDelActionPerformed
    private void jTextFieldSCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSCodeActionPerformed
        //pu : 28/08/2549 : ��˹�������Ѻ Index ����Ѻ�кض֧˹�һѨ�غѹ�ͧ��¡��
        this.curNext = 0;
        this.curPrev = 0;
        search();         
    }//GEN-LAST:event_jTextFieldSCodeActionPerformed
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        save();
    }//GEN-LAST:event_jButtonSaveActionPerformed
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        theDrugStandard = null;
        setEnableAll(true);
        clearAll();
    }//GEN-LAST:event_jButtonAddActionPerformed
    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        next();        
    }//GEN-LAST:event_jButtonNextActionPerformed
    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevActionPerformed
        prev();       
    }//GEN-LAST:event_jButtonPrevActionPerformed
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        //pu : 28/08/2549 : ��˹�������Ѻ Index ����Ѻ�кض֧˹�һѨ�غѹ�ͧ��¡��
        this.curNext = 0;
        this.curPrev = 0;
        search();        
    }//GEN-LAST:event_jButtonSearchActionPerformed
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        select();
    }//GEN-LAST:event_jTable1MouseReleased
    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        select();
        if(evt.getKeyCode() == KeyEvent.VK_INSERT)
        {
            jButtonAddActionPerformed(null);
        }
        if(evt.getKeyCode() == KeyEvent.VK_DELETE)
        {
            jButtonDelActionPerformed(null);
        }
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            jButtonNextActionPerformed(null);
            jTable1.setRowSelectionInterval(0,0);
            select();
        }
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
            jButtonPrevActionPerformed(null);
            jTable1.setRowSelectionInterval(0,0);
            select();
        }
        if(evt.getKeyCode() == KeyEvent.VK_SPACE)
        {
            jTextFieldCode.requestFocus();
        }
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            jTextFieldSCode.requestFocus();
        }
	}//GEN-LAST:event_jTable1KeyReleased
    
    private void next()
    {   
        setTable(vDrugStandard,1);
    }
    
    private void prev()
    {   
        setTable(vDrugStandard,0);
    }
    
    private void delete()
    {   
        int ret = theSetupControl.deleteDrugStandard(theDrugStandard);        
        if(ret==0)
            return;
        setEnableAll(false);
        clearAll();
        //pu : 25/08/2549 : �� Index �Ѩ�غѹ�ͧ˹����¡�÷����ѧ�ѹ�֡
        int count = next - prev;
        this.curNext = next - count;
        this.curPrev = prev - offset;
        search();
    }
    
    private void clearAll()
    {
        jTextFieldCode.setText("");
        jTextAreaName.setText("");
        jCheckBox1.setSelected(true);
        jTextFieldCode.requestFocus();
    }
    
    private void setEnableAll(boolean var)
    {
        jTextFieldCode.setEditable(var);
        jTextAreaName.setEditable(var);
        jButtonSave.setEnabled(var);
        jCheckBox1.setEnabled(var);
        jButtonDel.setEnabled(var);
    }
    
    private void select()
    {
        setEnableAll(true);
        saved = 0;
        int row = jTable1.getSelectedRow();      
        theDrugStandard = (DrugStandard)vDrugStandard.get(row + prev);
        jTextFieldCode.setText(theDrugStandard.number);
        jTextAreaName.setText(theDrugStandard.description);
        
        /*String of = (String)jTable1.getValueAt(row, 0);
        jTextFieldCode.setText(of);
        jTextAreaName.setText((String)jTable1.getValueAt(row, 1));
        DrugStandard bgi = new DrugStandard();
        for(int i =0 ; i< vDrugStandard.size() ; i++)
        {
            if(of.equalsIgnoreCase(((DrugStandard)vDrugStandard.get(i)).number))
                bgi = (DrugStandard)vDrugStandard.get(i);
        }
        theDrugStandard = bgi;*/
        jCheckBox1.setSelected(false);
        /*if(bgi.active.equals("1"))
        {
            jCheckBox1.setSelected(true);
        }*/
        if(theDrugStandard.active.equals("1"))
        {
            jCheckBox1.setSelected(true);
        }
    }
    
    private void setTableListDefault()
    {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60); //����
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100); //��������´
    }
    
    private void search()
    {   //pu : 28/08/2549 : ��˹���� Index ���Ѻ˹�ҷ���ͧ����ʴ���¡��
        next = this.curNext;
        prev =  this.curPrev;
        String search = jTextFieldSCode.getText();
        String active = "0";
        if(jCheckBoxS.isSelected())
            active = "1";
        vDrugStandard = theSetupControl.listDrugStandardByCodeName(search,active);
        setTable(vDrugStandard,1);
    }
    
    private void setTable(Vector voffice,int off)
    {
        DrugStandard of = new DrugStandard();
        int count = offset;
        int p =0;
        int n =0;
        int c =0;
        if(voffice != null && voffice.size() != 0)
        {
            if(off == 1)
            {
                p = prev;
                n = next;
                prev = next;
                next = next + offset;
                if(next >= vDrugStandard.size())
                {
                    next = vDrugStandard.size();
                    count = next - prev;
                }
                if(count == 0)
                {
                    prev = p;
                    next = n;
                    count = n - p;
                }
            }
            else
            {
                next = prev;
                prev = prev - offset;
                if(prev <=0)
                {
                    prev = 0;
                    next = offset;
                }
                if(next >= vDrugStandard.size())
                {
                    next = vDrugStandard.size();
                    count = next;
                }
            }
            TaBleModel tm = new TaBleModel(col,count);
            for(int i=0 ;i<count;i++)
            {
                of = (DrugStandard)voffice.get(i+prev);
                tm.setValueAt(of.number,i,0);
                tm.setValueAt(of.description,i,1);
            }
            jTable1.setModel(tm);
        }
        else
        {
            TaBleModel tm = new TaBleModel(col,0);
            jTable1.setModel(tm);
        }
        setTableListDefault();
    }
    
    private void save()
    {
        updateGO();
        int ret = theSetupControl.saveDrugStandard(theDrugStandard);
        if(ret==0)
            return;
        setEnableAll(false);
        //pu : 28/08/2549 : �� Index �Ѩ�غѹ�ͧ˹����¡�÷����ѧ�ѹ�֡
        int count = next - prev;
        this.curNext = next - count;
        this.curPrev = prev - offset;
        search();
    }
    
    public static void main(String args[])
    {
        JFrame frm = new JFrame("Test");
        frm.getContentPane().setLayout(new BorderLayout());
        PanelSetupWard pnl = new PanelSetupWard();
        frm.getContentPane().add(pnl,  BorderLayout.CENTER);
        frm.addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent e)
            {    System.exit(0);
            }
        });
        frm.pack();
        frm.setVisible(true);
    }
    
    public void notifyreFrashPanel()
    {
    }
    
    public void notifysetEnableForLift(boolean b)
    {
        jButtonDel.setVisible(b);
    }
    
    public int editOption(Option option)
    {
        Constant.println("PanelSetupWard function is not use.");
        return -1;
    }
    
    public Vector listOptionAll()
    {
        Constant.println("PanelSetupWard function is not use.");
        return null;
    }
    
    public void reFrashPanel()
    {
    }
    
    public Option readOption()
    {
        Constant.println("PanelSetupWard function is not use.");
        return null;
    }
    
    public int saveOption(Option option)
    {
        Constant.println("PanelSetupWard function is not use.");
        return -1;
    }
    
    public void setEnableForLift(boolean b)
    {
    }
    
    public void updateGO()
    {
        if(theDrugStandard==null)
        {
            theDrugStandard = new DrugStandard();
        }
        theDrugStandard.number = jTextFieldCode.getText();
        theDrugStandard.description = jTextAreaName.getText();
        if(jCheckBox1.isSelected())

            theDrugStandard.active = "1";
        else
            theDrugStandard.active = "0";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private com.hospital_os.gui.font.FontFormatTitle fontFormatTitle1;
    private com.hospital_os.gui.font.FontFormatTitle fontFormatTitle2;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDel;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelICD9code;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.hosv3.gui.component.HJTableSort jTable1;
    private javax.swing.JTextArea jTextAreaName;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldSCode;
    // End of variables declaration//GEN-END:variables
}
