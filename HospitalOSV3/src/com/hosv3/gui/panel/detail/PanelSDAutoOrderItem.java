/*
 * PanelSDSetupAutoOrderItem.java
 *
 * Created on April 1, 2009, 12:37 PM
 */

package com.hosv3.gui.panel.detail;

import com.hospital_os.object.AutoOrderItem;
import com.hospital_os.object.Item;
import com.hospital_os.usecase.connection.Persistent;
import com.hospital_os.utility.ComboboxModel;
import com.hosv3.utility.Constant;
import com.hospital_os.utility.Gutil;
import com.hosv3.control.HosControl;
import com.hosv3.control.LookupControl;
import com.hosv3.control.SetupControl;
import com.hosv3.gui.component.PanelSetupImp;
import com.hosv3.gui.dialog.PanelSetupSearchSub;
import com.hosv3.subject.SetupSubject;
import com.hosv3.utility.GuiLang;
import com.hosv3.utility.connection.UpdateStatus;
import java.util.Vector;

/**
 *
 * @author  Administrator
 */
public class PanelSDAutoOrderItem extends javax.swing.JPanel implements PanelSetupImp{
    UpdateStatus theUS;
    HosControl theHC;
    SetupControl theSetupControl;
    SetupSubject theSetupSubject;
    Item theItem;
    private AutoOrderItem theAutoOrderItem;
    LookupControl theLookupControl;
    PanelSetupSearchSub  psep;
    Vector vAutoOrder;
    int row=0;
    int offset = 25;
    int next = 0;
    int prev = 0;
    /** pu : 26/08/2549 : �� Index �ͧ Item �����ҧ�ش�ͧ˹�һѨ�غѹ*/
    int curNext = 0;
    /** pu : 26/08/2549 : �� Index �ͧ Item �����ҧ�ش�ͧ˹�ҡ�͹˹�һѨ�غѹ*/
    int curPrev = 0;
    String[] col = {"����","������¡��"};
    /** Creates new form PanelSDSetupAutoOrderItem */
    public PanelSDAutoOrderItem() {
        initComponents();
        setLanguage();
    }
    
    public PanelSDAutoOrderItem(HosControl hc,UpdateStatus us)
    {
        initComponents();
        setLanguage();
        setControl(hc,us);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jCheckBoxAllPlan = new javax.swing.JCheckBox();
        jComboBoxPlan = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jCheckBoxMonToFri = new javax.swing.JCheckBox();
        jCheckBoxMonTime = new javax.swing.JCheckBox();
        timeTextFieldMonFrom = new com.hospital_os.utility.TimeTextField();
        timeTextFieldMonTo = new com.hospital_os.utility.TimeTextField();
        jCheckBoxSat = new javax.swing.JCheckBox();
        jCheckBoxSatTime = new javax.swing.JCheckBox();
        timeTextFieldSatFrom = new com.hospital_os.utility.TimeTextField();
        timeTextFieldSatTo = new com.hospital_os.utility.TimeTextField();
        jCheckBoxSun = new javax.swing.JCheckBox();
        jCheckBoxSunTime = new javax.swing.JCheckBox();
        timeTextFieldSunFrom = new com.hospital_os.utility.TimeTextField();
        timeTextFieldSunTo = new com.hospital_os.utility.TimeTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextAreaCommonName = new javax.swing.JTextArea();
        jTextFieldCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTradeName = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAutoCode = new javax.swing.JTextField();
        jTextFieldNickName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(300, 400));
        setMinimumSize(new java.awt.Dimension(300, 400));
        setPreferredSize(new java.awt.Dimension(300, 400));
        setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jCheckBoxAllPlan.setFont(defaultFont1);
        jCheckBoxAllPlan.setText("�ء�Է�ԡ���ѡ��");
        jCheckBoxAllPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAllPlanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 3, 10);
        jPanel7.add(jCheckBoxAllPlan, gridBagConstraints);

        jComboBoxPlan.setFont(defaultFont1);
        jComboBoxPlan.setMinimumSize(new java.awt.Dimension(26, 24));
        jComboBoxPlan.setPreferredSize(new java.awt.Dimension(26, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel7.add(jComboBoxPlan, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(jPanel7, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jCheckBoxMonToFri.setFont(defaultFont1);
        jCheckBoxMonToFri.setText("�ѹ���-�ء��");
        jCheckBoxMonToFri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMonToFriActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel6.add(jCheckBoxMonToFri, gridBagConstraints);

        jCheckBoxMonTime.setFont(defaultFont1);
        jCheckBoxMonTime.setText("�к�����");
        jCheckBoxMonTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMonTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel6.add(jCheckBoxMonTime, gridBagConstraints);

        timeTextFieldMonFrom.setText("00:00");
        timeTextFieldMonFrom.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel6.add(timeTextFieldMonFrom, gridBagConstraints);

        timeTextFieldMonTo.setText("00:00");
        timeTextFieldMonTo.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel6.add(timeTextFieldMonTo, gridBagConstraints);

        jCheckBoxSat.setFont(defaultFont1);
        jCheckBoxSat.setText("�����");
        jCheckBoxSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel6.add(jCheckBoxSat, gridBagConstraints);

        jCheckBoxSatTime.setFont(defaultFont1);
        jCheckBoxSatTime.setText("�к�����");
        jCheckBoxSatTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSatTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel6.add(jCheckBoxSatTime, gridBagConstraints);

        timeTextFieldSatFrom.setText("00:00");
        timeTextFieldSatFrom.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel6.add(timeTextFieldSatFrom, gridBagConstraints);

        timeTextFieldSatTo.setText("00:00");
        timeTextFieldSatTo.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel6.add(timeTextFieldSatTo, gridBagConstraints);

        jCheckBoxSun.setFont(defaultFont1);
        jCheckBoxSun.setText("�ҷԵ��");
        jCheckBoxSun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSunActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel6.add(jCheckBoxSun, gridBagConstraints);

        jCheckBoxSunTime.setFont(defaultFont1);
        jCheckBoxSunTime.setText("�к�����");
        jCheckBoxSunTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSunTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel6.add(jCheckBoxSunTime, gridBagConstraints);

        timeTextFieldSunFrom.setText("00:00");
        timeTextFieldSunFrom.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel6.add(timeTextFieldSunFrom, gridBagConstraints);

        timeTextFieldSunTo.setText("00:00");
        timeTextFieldSunTo.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel6.add(timeTextFieldSunTo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(jPanel6, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(defaultFont1);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/hosv3/property/thai"); // NOI18N
        jLabel2.setText(bundle.getString("ITEM_COMMON_NAME")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jScrollPane21.setMaximumSize(new java.awt.Dimension(150, 45));
        jScrollPane21.setMinimumSize(new java.awt.Dimension(150, 45));
        jScrollPane21.setPreferredSize(new java.awt.Dimension(150, 45));

        jTextAreaCommonName.setFont(defaultFont1);
        jTextAreaCommonName.setLineWrap(true);
        jTextAreaCommonName.setMaximumSize(new java.awt.Dimension(150, 45));
        jTextAreaCommonName.setMinimumSize(new java.awt.Dimension(150, 40));
        jTextAreaCommonName.setPreferredSize(new java.awt.Dimension(150, 40));
        jScrollPane21.setViewportView(jTextAreaCommonName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        jPanel2.add(jScrollPane21, gridBagConstraints);

        jTextFieldCode.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        jPanel2.add(jTextFieldCode, gridBagConstraints);

        jLabel4.setFont(defaultFont1);
        jLabel4.setText(bundle.getString("ITEM_NICK_NAME")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(defaultFont1);
        jLabel5.setText(bundle.getString("ITEM_TRADE_NAME")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        jPanel2.add(jLabel5, gridBagConstraints);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(150, 45));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(150, 45));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 45));

        jTextAreaTradeName.setFont(defaultFont1);
        jTextAreaTradeName.setMaximumSize(new java.awt.Dimension(150, 40));
        jTextAreaTradeName.setMinimumSize(new java.awt.Dimension(150, 40));
        jTextAreaTradeName.setPreferredSize(new java.awt.Dimension(150, 40));
        jScrollPane2.setViewportView(jTextAreaTradeName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jLabel6.setFont(defaultFont1);
        jLabel6.setText("����");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        jPanel2.add(jLabel6, gridBagConstraints);

        jTextFieldAutoCode.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 10);
        jPanel2.add(jTextFieldAutoCode, gridBagConstraints);

        jTextFieldNickName.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        jPanel2.add(jTextFieldNickName, gridBagConstraints);

        jLabel1.setFont(defaultFont1);
        jLabel1.setText("Item code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        jPanel2.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMonToFriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMonToFriActionPerformed
        checkMon();
    }//GEN-LAST:event_jCheckBoxMonToFriActionPerformed

    private void jCheckBoxMonTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMonTimeActionPerformed
        if(jCheckBoxMonTime.isSelected()) {
            timeTextFieldMonFrom.setEnabled(true);
            timeTextFieldMonTo.setEnabled(true);
        } else {
            timeTextFieldMonFrom.setEnabled(false);
            timeTextFieldMonTo.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxMonTimeActionPerformed

    private void jCheckBoxSatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSatActionPerformed
        checkSat();
    }//GEN-LAST:event_jCheckBoxSatActionPerformed

    private void jCheckBoxSatTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSatTimeActionPerformed
        if(jCheckBoxSatTime.isSelected()) {
            timeTextFieldSatFrom.setEnabled(true);
            timeTextFieldSatTo.setEnabled(true);
        } else {
            timeTextFieldSatFrom.setEnabled(false);
            timeTextFieldSatTo.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxSatTimeActionPerformed

    private void jCheckBoxSunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSunActionPerformed
        checkSun();
    }//GEN-LAST:event_jCheckBoxSunActionPerformed

    private void jCheckBoxSunTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSunTimeActionPerformed
        if(jCheckBoxSunTime.isSelected()) {
            timeTextFieldSunFrom.setEnabled(true);
            timeTextFieldSunTo.setEnabled(true);
        } else {
            timeTextFieldSunFrom.setEnabled(false);
            timeTextFieldSunTo.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxSunTimeActionPerformed

    private void jCheckBoxAllPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAllPlanActionPerformed
        if(jCheckBoxAllPlan.isSelected()) {
            jComboBoxPlan.setEnabled(false);
        } else {
            jComboBoxPlan.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBoxAllPlanActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private javax.swing.JCheckBox jCheckBoxAllPlan;
    private javax.swing.JCheckBox jCheckBoxMonTime;
    private javax.swing.JCheckBox jCheckBoxMonToFri;
    private javax.swing.JCheckBox jCheckBoxSat;
    private javax.swing.JCheckBox jCheckBoxSatTime;
    private javax.swing.JCheckBox jCheckBoxSun;
    private javax.swing.JCheckBox jCheckBoxSunTime;
    private javax.swing.JComboBox jComboBoxPlan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JTextArea jTextAreaCommonName;
    private javax.swing.JTextArea jTextAreaTradeName;
    private javax.swing.JTextField jTextFieldAutoCode;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldNickName;
    private com.hospital_os.utility.TimeTextField timeTextFieldMonFrom;
    private com.hospital_os.utility.TimeTextField timeTextFieldMonTo;
    private com.hospital_os.utility.TimeTextField timeTextFieldSatFrom;
    private com.hospital_os.utility.TimeTextField timeTextFieldSatTo;
    private com.hospital_os.utility.TimeTextField timeTextFieldSunFrom;
    private com.hospital_os.utility.TimeTextField timeTextFieldSunTo;
    // End of variables declaration//GEN-END:variables

      public void setEnabled(boolean var)
    {   
       if(var == false)
        {
            //jTextFieldAutoCode.setEnabled(false);
            jTextFieldCode.setEnabled(false);
            jTextAreaCommonName.setEnabled(false);
            jTextAreaTradeName.setEnabled(false);
            jTextFieldNickName.setEnabled(false);
            //jButtonDel.setEnabled(false);
            checkMon();
            checkSat();
            checkSun();
            jCheckBoxAllPlan.setEnabled(false);
            jComboBoxPlan.setEnabled(false);
            //jButtonSave.setEnabled(false);
        }
        else
        {
            //jTextFieldAutoCode.setEnabled(true);
            jTextFieldCode.setEnabled(true);
            jTextAreaCommonName.setEnabled(true);
            jTextAreaTradeName.setEnabled(true);
            jTextFieldNickName.setEnabled(true);
            jCheckBoxAllPlan.setEnabled(true);
            //jButtonSave.setEnabled(true);
            //jButtonDel.setEnabled(true);
            checkMon();
            checkSat();
            checkSun();
        }
    }
      
    public void clearAll() {
        jComboBoxPlan.setEnabled(true);
        theAutoOrderItem = new AutoOrderItem();
        showItem();
        this.setTheAutoOrderItem(new AutoOrderItem());
        
    }
    
     private void showItem()
    {
        if(psep==null)
        {
            psep = new PanelSetupSearchSub(theHC,theUS,13);
            psep.setTitle("������¡�õ�Ǩ�ѡ��");
            psep.setTextConponent(jTextFieldCode,jTextAreaCommonName,jTextAreaTradeName,jTextFieldNickName);
            psep.showSearch();
        }
        psep = null;
    }

    public Persistent getXPer() {
        return this.getTheAutoOrderItem();
    }

    public void setXPer(Persistent x) {
        this.setTheAutoOrderItem((AutoOrderItem)x);
    }

    
    
    public void setLanguage() {
        //GuiLang.setLanguage(jLabel3);
//        GuiLang.setLanguage(jLabelICD9code);
//        GuiLang.setLanguage(jButtonSearch);
        GuiLang.setLanguage(jLabel6);
        GuiLang.setLanguage(jLabel2);
        GuiLang.setLanguage(jLabel5);
        GuiLang.setLanguage(jLabel4);
        GuiLang.setLanguage(jLabel1);
        GuiLang.setLanguage(jCheckBoxMonToFri);
        GuiLang.setLanguage(jCheckBoxSat);
        GuiLang.setLanguage(jCheckBoxSun);
        GuiLang.setLanguage(jCheckBoxMonTime);
        GuiLang.setLanguage(jCheckBoxSatTime);
        GuiLang.setLanguage(jCheckBoxSunTime);
        GuiLang.setLanguage(jCheckBoxAllPlan);
        //GuiLang.setLanguage(jButtonSave);
        GuiLang.setLanguage(col);
        GuiLang.setLanguage(jCheckBoxSun);
    }

    public void setControl(HosControl hc, UpdateStatus us) {
        //jTable1.setGuiMode(true);
        theUS = us;
        theHC = hc;
        theSetupControl = hc.theSetupControl;
        theSetupSubject = hc.theHS.theSetupSubject;
        theLookupControl = hc.theLookupControl;
        hc.theHS.theSetupSubject.addpanelrefrash(this);
        hc.theHS.theSetupSubject.addAllItem(this);
        hc.theHS.theSetupSubject.addForLiftAttach(this);
        setEnabled(false);
        setupLookup();
        jTextAreaCommonName.setEnabled(false);
        jTextAreaTradeName.setEnabled(false);
        jTextFieldNickName.setEnabled(false);
        jTextFieldCode.setEnabled(false);
    }

    public void setupLookup() {
        ComboboxModel.initComboBox(jComboBoxPlan, theLookupControl.listPlan());
    }

    public boolean deleteXPer(Persistent x) {
        boolean confirm = theUS.confirmBox(Constant.getTextBundle("�׹�ѹ����ź��¡�ù�� �Ҩ�Դ�š�з��Ѻ������㹰ҹ��������"), UpdateStatus.WARNING);
        if(!confirm) 
            return false;
        return (this.theSetupControl.deleteAutoOrderItemReq((AutoOrderItem)x)>0);
    }

    public boolean saveXPer(Persistent x) {
         return (this.theSetupControl.saveAutoOrderItemReq((AutoOrderItem)x));
    }

    public Vector listXPer(String key, String active, int offset) {
        return theSetupControl.listAutoOrderItemReq(key);
    }

    public boolean isActiveVisible() {
        return false;
    }

    public static String TITLE = Constant.getTextBundle("��¡���ѡ���ѵ��ѵ�");
    public String getTitle() {
        return TITLE;
    }
    
    /*
     * ���ͷӡ�� check �����ѹ�����͡�繶�� checkbox mon
     * �١ check ��¡�����Ҩ��ʴ�������͡��
     * input  :
     * outpit :
     */
    private void checkMon()
    {
        if(jCheckBoxMonToFri.isSelected())
        {
            jCheckBoxMonTime.setEnabled(true);
            timeTextFieldMonFrom.setEnabled(false);
            timeTextFieldMonTo.setEnabled(false);
            return;
        }
        jCheckBoxMonTime.setEnabled(false);
        timeTextFieldMonFrom.setEnabled(false);
        timeTextFieldMonTo.setEnabled(false);
    }
    /*
     * ���ͷӡ�� check �����ѹ�����͡�繶�� checkbox sat
     * �١ check ��¡�����Ҩ��ʴ�������͡��
     * input  :
     * outpit :
     */
    private void checkSat()
    {
        if(jCheckBoxSat.isSelected())
        {
            jCheckBoxSatTime.setEnabled(true);
            timeTextFieldSatFrom.setEnabled(false);
            timeTextFieldSatTo.setEnabled(false);
            return;
        }
        jCheckBoxSatTime.setEnabled(false);
        timeTextFieldSatFrom.setEnabled(false);
        timeTextFieldSatTo.setEnabled(false);
    }
    /*
     * ���ͷӡ�� check �����ѹ�����͡�繶�� checkbox sun
     * �١ check ��¡�����Ҩ��ʴ�������͡��
     * input  :
     * outpit :
     */
    private void checkSun()
    {
        if(jCheckBoxSun.isSelected())
        {
            jCheckBoxSunTime.setEnabled(true);
            timeTextFieldSunFrom.setEnabled(false);
            timeTextFieldSunTo.setEnabled(false);
            return;
        }
        jCheckBoxSunTime.setEnabled(false);
        timeTextFieldSunFrom.setEnabled(false);
        timeTextFieldSunTo.setEnabled(false);
    }

    public AutoOrderItem getTheAutoOrderItem() {
        theAutoOrderItem.auto_order_item_id= jTextFieldAutoCode.getText();
        theAutoOrderItem.item_id = theSetupControl.listItemByItemIdReq(jTextFieldCode.getText()).getObjectId();
        if(jCheckBoxAllPlan.isSelected())
        {
            theAutoOrderItem.plan_id="";
        }
        else
        {
            theAutoOrderItem.plan_id = Gutil.getGuiData(jComboBoxPlan);
        }
        if(jCheckBoxMonToFri.isSelected())
        {
            theAutoOrderItem.monday="1";
            if(jCheckBoxMonTime.isSelected())
            {
                theAutoOrderItem.mon_alltime="0";
                theAutoOrderItem.mon_time_start = timeTextFieldMonFrom.getTextTime();
                theAutoOrderItem.mon_time_stop = timeTextFieldMonTo.getTextTime();
            }
            else
            {
                theAutoOrderItem.mon_alltime="1";
                theAutoOrderItem.mon_time_start = "00:00";
                theAutoOrderItem.mon_time_stop ="00:00";
            }
        }
        else
        {
            theAutoOrderItem.monday="0";
            theAutoOrderItem.mon_alltime="0";
            theAutoOrderItem.mon_time_start = "00:00";
            theAutoOrderItem.mon_time_stop ="00:00";
        }
        if(jCheckBoxSat.isSelected())
        {
            theAutoOrderItem.saturday="1";
            if(jCheckBoxSatTime.isSelected())
            {
                theAutoOrderItem.sat_alltime="0";
                theAutoOrderItem.sat_time_start = timeTextFieldSatFrom.getTextTime();
                theAutoOrderItem.sat_time_stop = timeTextFieldSatTo.getTextTime();
            }
            else
            {
                theAutoOrderItem.sat_alltime="1";
                theAutoOrderItem.sat_time_start = "00:00";
                theAutoOrderItem.sat_time_stop = "00:00";
            }
        }
        else
        {
            theAutoOrderItem.saturday="0";
            theAutoOrderItem.sat_alltime="0";
            theAutoOrderItem.sat_time_start = "00:00";
            theAutoOrderItem.sat_time_stop = "00:00";
        }
        if(jCheckBoxSun.isSelected())
        {
            theAutoOrderItem.sunday="1";
            if(jCheckBoxSunTime.isSelected())
            {
                theAutoOrderItem.sun_alltime="0";
                theAutoOrderItem.sun_time_start = timeTextFieldSunFrom.getTextTime();
                theAutoOrderItem.sun_time_stop = timeTextFieldSunTo.getTextTime();
            }
            else
            {
                theAutoOrderItem.sun_alltime="1";
                theAutoOrderItem.sun_time_start = "00:00";
                theAutoOrderItem.sun_time_stop = "00:00";
            }
        }
        else
        {
            theAutoOrderItem.sunday="0";
            theAutoOrderItem.sun_alltime="0";
            theAutoOrderItem.sun_time_start = "00:00";
            theAutoOrderItem.sun_time_stop = "00:00";
        }
        return theAutoOrderItem;
    }

    public void setTheAutoOrderItem(AutoOrderItem Item) {
        theAutoOrderItem = Item;
//         jButtonSave.setEnabled(true);
        if(theAutoOrderItem.getObjectId()==null)
        {
            jCheckBoxMonToFri.setSelected(true);
            jCheckBoxSat.setSelected(true);
            jCheckBoxSun.setSelected(true);
            jCheckBoxAllPlan.setSelected(true);
            timeTextFieldMonFrom.setEnabled(false);
            timeTextFieldMonTo.setEnabled(false);
            timeTextFieldSatFrom.setEnabled(false);
            timeTextFieldSatTo.setEnabled(false);
            timeTextFieldSunFrom.setEnabled(false);
            timeTextFieldSunTo.setEnabled(false);
            timeTextFieldSatFrom.setEnabled(false);
            jCheckBoxAllPlan.setEnabled(false);
            if(theItem!=null)
            {
                jTextFieldCode.setText(theItem.item_id);
                jTextAreaCommonName.setText(theItem.common_name);
                jTextAreaTradeName.setText(theItem.trade_name);
                jTextFieldNickName.setText(theItem.nick_name);
            }
            else
            {

            }
            jTextFieldCode.setEnabled(false);
            jTextAreaCommonName.setEnabled(false);
            jTextAreaTradeName.setEnabled(false);
            jTextFieldNickName.setEnabled(false);
        }
        else
        {
//            jButtonDel.setEnabled(true);
            jTextFieldAutoCode.setText(theAutoOrderItem.auto_order_item_id);
            Item it=theSetupControl.listItemByPk(theAutoOrderItem.item_id);
            jTextFieldCode.setText(it.item_id);
            jTextAreaCommonName.setText(it.common_name);
            jTextAreaTradeName.setText(it.trade_name);
            jTextFieldNickName.setText(it.nick_name);
            jTextFieldCode.setEnabled(false);
            jTextAreaCommonName.setEnabled(false);
            jTextAreaTradeName.setEnabled(false);
            jTextFieldNickName.setEnabled(false);
            if(!theAutoOrderItem.plan_id.equals(""))
            {
                jCheckBoxAllPlan.setSelected(false);
                Gutil.setGuiData(jComboBoxPlan, theAutoOrderItem.plan_id);
                jCheckBoxAllPlan.setEnabled(true);
                jComboBoxPlan.setEnabled(true);
            }
            else
            {
                jCheckBoxAllPlan.setSelected(true);
                jCheckBoxAllPlan.setEnabled(true);
                jComboBoxPlan.setEnabled(false);
            }
            if(theAutoOrderItem.monday.equals("1"))
            {
                jCheckBoxMonToFri.setSelected(true);
                jCheckBoxMonTime.setEnabled(true);
                if(theAutoOrderItem.mon_alltime.equals("1"))
                {
                    jCheckBoxMonTime.setSelected(false);
                    timeTextFieldMonFrom.setText("00:00");
                    timeTextFieldMonTo.setText("00:00");
                    timeTextFieldMonFrom.setEnabled(false);
                    timeTextFieldMonTo.setEnabled(false);
                }
                else
                {
                    jCheckBoxMonTime.setSelected(true);
                    timeTextFieldMonFrom.setEnabled(true);
                    timeTextFieldMonTo.setEnabled(true);
                    timeTextFieldMonFrom.setText(theAutoOrderItem.mon_time_start);
                    timeTextFieldMonTo.setText(theAutoOrderItem.mon_time_stop);
                    
                }
            }
            else
            {
                jCheckBoxMonToFri.setSelected(false);
                jCheckBoxMonTime.setSelected(false);
                timeTextFieldMonFrom.setText("00:00");
                timeTextFieldMonTo.setText("00:00");
                timeTextFieldMonFrom.setEnabled(false);
                timeTextFieldMonTo.setEnabled(false);
            }
            if(theAutoOrderItem.saturday.equals("1"))
            {
                jCheckBoxSat.setSelected(true);
                jCheckBoxSatTime.setEnabled(true);
                if(theAutoOrderItem.sat_alltime.equals("1"))
                {
                    jCheckBoxSatTime.setSelected(false);
                    timeTextFieldSatFrom.setText("00:00");
                    timeTextFieldSatTo.setText("00:00");
                    timeTextFieldSatFrom.setEnabled(false);
                    timeTextFieldSatTo.setEnabled(false);
                }
                else
                {
                    jCheckBoxSatTime.setSelected(true);
                    timeTextFieldSatFrom.setEnabled(true);
                    timeTextFieldSatTo.setEnabled(true);
                    timeTextFieldSatFrom.setText(theAutoOrderItem.sat_time_start);
                    timeTextFieldSatTo.setText(theAutoOrderItem.sat_time_stop);
                    
                }
            }
            else
            {
                jCheckBoxSat.setSelected(false);
                jCheckBoxSatTime.setSelected(false);
                timeTextFieldSatFrom.setText("00:00");
                timeTextFieldSatTo.setText("00:00");
                timeTextFieldSatFrom.setEnabled(false);
                timeTextFieldSatTo.setEnabled(false);
            }
            if(theAutoOrderItem.sunday.equals("1"))
            {
                jCheckBoxSun.setSelected(true);
                jCheckBoxSunTime.setEnabled(true);
                if(theAutoOrderItem.sun_alltime.equals("1"))
                {
                    jCheckBoxSunTime.setSelected(false);
                    timeTextFieldSunFrom.setText("00:00");
                    timeTextFieldSunTo.setText("00:00");
                    timeTextFieldSunFrom.setEnabled(false);
                    timeTextFieldSunTo.setEnabled(false);
                }
                else
                {
                    jCheckBoxSunTime.setSelected(true);
                    timeTextFieldSunFrom.setEnabled(true);
                    timeTextFieldSunTo.setEnabled(true);
                    timeTextFieldSunFrom.setText(theAutoOrderItem.sun_time_start);
                    timeTextFieldSunTo.setText(theAutoOrderItem.sun_time_stop);
                    
                }
            }
            else
            {
                jCheckBoxSun.setSelected(false);
                jCheckBoxSunTime.setSelected(false);
                timeTextFieldSunFrom.setText("00:00");
                timeTextFieldSunTo.setText("00:00");
                timeTextFieldSunFrom.setEnabled(false);
                timeTextFieldSunTo.setEnabled(false);
            }
        }
    }
    
    public boolean isStartVisible() {
        return false;
    }

    

}
