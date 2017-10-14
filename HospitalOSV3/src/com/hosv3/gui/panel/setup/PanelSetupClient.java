/*
 * PanelSetupClient.java
 *
 * Created on 14 ���Ҥ� 2546, 11:52 �.
 */

package com.hosv3.gui.panel.setup;
import java.awt.*;
import java.util.Vector;

import java.awt.event.*;
import javax.swing.*;

import com.hosv3.usecase.setup.*;
import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hospital_os.utility.*;
import com.hospital_os.object.*;
/**
 *
 * @Label author  Ojika
 */
public class PanelSetupClient extends javax.swing.JPanel  implements 
ManageOptionReq{
    UpdateStatus theUS;
    /** Creates new form PanelSetupClient */
    public PanelSetupClient(HosControl hc,UpdateStatus us) {
        initComponents();
        //setLanguage();
        setControl(hc,us);
    }
	public PanelSetupClient() {
        initComponents();
        //setLanguage();
    }

    /////////////////////Use this for decrease memory usage
	public void setControl(HosControl hc,UpdateStatus us){
		theUS = us;
		hc.theHS.theSetupSubject.addpanelrefrash(this);
    }
    /////////////////////Use this for decrease memory usage    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        defaultFont1 = new com.hospital_os.gui.font.DefaultFont();
        fontFormatTitle1 = new com.hospital_os.gui.font.FontFormatTitle();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxHuman = new javax.swing.JComboBox();
        jCheckBoxRefreshPatient = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldRefreshPatientTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxSearchItem = new javax.swing.JCheckBox();
        jRadioButtonSearchTrueData = new javax.swing.JRadioButton();
        jRadioButtonSearchCopyData = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldWeight = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldHeight = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldNationCode = new javax.swing.JTextField();
        jComboBoxNationDescription = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextFieldOriginCode = new javax.swing.JTextField();
        jComboBoxOriginDescription = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPatientCount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldICDCount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldOrderCount = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonRefresh = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(fontFormatTitle1);
        jLabel1.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SETUP_CLIENT"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 300));
        jLabel2.setFont(defaultFont1);
        jLabel2.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("HUMAN_SHOW"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jComboBoxHuman.setFont(defaultFont1);
        jComboBoxHuman.setMaximumSize(new java.awt.Dimension(150, 24));
        jComboBoxHuman.setMinimumSize(new java.awt.Dimension(150, 24));
        jComboBoxHuman.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jComboBoxHuman, gridBagConstraints);

        jCheckBoxRefreshPatient.setFont(defaultFont1);
        jCheckBoxRefreshPatient.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("REFRESH_PATIENT_ORDER"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jCheckBoxRefreshPatient, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jTextFieldRefreshPatientTime.setColumns(4);
        jTextFieldRefreshPatientTime.setFont(defaultFont1);
        jTextFieldRefreshPatientTime.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldRefreshPatientTime.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldRefreshPatientTime.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(jTextFieldRefreshPatientTime, gridBagConstraints);

        jLabel3.setFont(defaultFont1);
        jLabel3.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SECOND"));
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(150, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel5.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jPanel5, gridBagConstraints);

        jCheckBoxSearchItem.setFont(defaultFont1);
        jCheckBoxSearchItem.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SEARCH_ORDER_WHEN_KEYUP"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jCheckBoxSearchItem, gridBagConstraints);

        jRadioButtonSearchTrueData.setFont(defaultFont1);
        jRadioButtonSearchTrueData.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SEARCH_FROM_TRUE_DATA_ON_SERVER"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 0);
        jPanel2.add(jRadioButtonSearchTrueData, gridBagConstraints);

        jRadioButtonSearchCopyData.setFont(defaultFont1);
        jRadioButtonSearchCopyData.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SEARCH_FROM_DATA_COPY_ON_CLIENT"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jRadioButtonSearchCopyData, gridBagConstraints);

        jLabel4.setFont(defaultFont1);
        jLabel4.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("DEFAULT_SITET_WINDOWS"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTextFieldWeight.setColumns(4);
        jTextFieldWeight.setFont(defaultFont1);
        jTextFieldWeight.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldWeight.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldWeight.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jTextFieldWeight, gridBagConstraints);

        jLabel5.setFont(defaultFont1);
        jLabel5.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("MULTIPLY"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        jTextFieldHeight.setColumns(4);
        jTextFieldHeight.setFont(defaultFont1);
        jTextFieldHeight.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldHeight.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldHeight.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel4.add(jTextFieldHeight, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jPanel4, gridBagConstraints);

        jLabel6.setFont(defaultFont1);
        jLabel6.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("NATION_DEFAULT"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel6, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jTextFieldNationCode.setColumns(4);
        jTextFieldNationCode.setFont(defaultFont1);
        jTextFieldNationCode.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldNationCode.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldNationCode.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(jTextFieldNationCode, gridBagConstraints);

        jComboBoxNationDescription.setFont(defaultFont1);
        jComboBoxNationDescription.setMaximumSize(new java.awt.Dimension(150, 24));
        jComboBoxNationDescription.setMinimumSize(new java.awt.Dimension(150, 24));
        jComboBoxNationDescription.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel6.add(jComboBoxNationDescription, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jPanel6, gridBagConstraints);

        jLabel7.setFont(defaultFont1);
        jLabel7.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("ORIGIN_DEFAULT"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel7, gridBagConstraints);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jTextFieldOriginCode.setColumns(4);
        jTextFieldOriginCode.setFont(defaultFont1);
        jTextFieldOriginCode.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldOriginCode.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldOriginCode.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(jTextFieldOriginCode, gridBagConstraints);

        jComboBoxOriginDescription.setFont(defaultFont1);
        jComboBoxOriginDescription.setMaximumSize(new java.awt.Dimension(150, 24));
        jComboBoxOriginDescription.setMinimumSize(new java.awt.Dimension(150, 24));
        jComboBoxOriginDescription.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel7.add(jComboBoxOriginDescription, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jPanel7, gridBagConstraints);

        jLabel8.setFont(defaultFont1);
        jLabel8.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("RECORD_COUNT_OF_PATIENT"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel8, gridBagConstraints);

        jTextFieldPatientCount.setColumns(4);
        jTextFieldPatientCount.setFont(defaultFont1);
        jTextFieldPatientCount.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldPatientCount.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldPatientCount.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jTextFieldPatientCount, gridBagConstraints);

        jLabel9.setFont(defaultFont1);
        jLabel9.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("RECORD_COUNT_OF_CODE_ICD"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel9, gridBagConstraints);

        jTextFieldICDCount.setColumns(4);
        jTextFieldICDCount.setFont(defaultFont1);
        jTextFieldICDCount.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldICDCount.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldICDCount.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jTextFieldICDCount, gridBagConstraints);

        jLabel10.setFont(defaultFont1);
        jLabel10.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("RECORD_COUNT_OF_ORDER"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(jLabel10, gridBagConstraints);

        jTextFieldOrderCount.setColumns(4);
        jTextFieldOrderCount.setFont(defaultFont1);
        jTextFieldOrderCount.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldOrderCount.setMinimumSize(new java.awt.Dimension(38, 21));
        jTextFieldOrderCount.setPreferredSize(new java.awt.Dimension(38, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jTextFieldOrderCount, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButtonRefresh.setFont(defaultFont1);
        jButtonRefresh.setText("\u0e40\u0e23\u0e35\u0e22\u0e01\u0e14\u0e39\u0e43\u0e2b\u0e21\u0e48");
        jButtonRefresh.setMaximumSize(new java.awt.Dimension(85, 26));
        jButtonRefresh.setMinimumSize(new java.awt.Dimension(85, 26));
        jButtonRefresh.setPreferredSize(new java.awt.Dimension(85, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jButtonRefresh, gridBagConstraints);

        jButtonSave.setFont(defaultFont1);
        jButtonSave.setText("\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01");
        jButtonSave.setMinimumSize(new java.awt.Dimension(76, 26));
        jButtonSave.setPreferredSize(new java.awt.Dimension(76, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jPanel3, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
    public static void main(String args[])
    {
        JFrame frm = new JFrame("Test");
        frm.getContentPane().setLayout(new BorderLayout());
        PanelSetupClient pnl = new PanelSetupClient();
    //    DBConnection db=new DBConnection();
     
        frm.getContentPane().add(pnl,  BorderLayout.CENTER);
        frm.addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent e)
            {    System.exit(0);
            }
        });
        frm.pack();
        frm.setVisible(true);
        frm.setSize(500, 500);
    }   
    public void notifyreFrashPanel() {
    }
    public int editOption(Option option) {
        Constant.println("PanelSetupGuideAfterDx function is not use.");
        return -1;
    }
    public Vector listOptionAll() {
        Constant.println("PanelSetupGuideAfterDx function is not use.");
        return null;
    }
    public void notifysetEnableForLift(boolean b) {
    }
    public void reFrashPanel() {
    }
    public Option readOption() {
        Constant.println("PanelSetupGuideAfterDx function is not use.");
        return null;
    }
    public int saveOption(Option option) {
        Constant.println("PanelSetupGuideAfterDx function is not use.");
        return -1;
    }
    public void setEnableForLift(boolean b) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private com.hospital_os.gui.font.FontFormatTitle fontFormatTitle1;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxRefreshPatient;
    private javax.swing.JCheckBox jCheckBoxSearchItem;
    private javax.swing.JComboBox jComboBoxHuman;
    private javax.swing.JComboBox jComboBoxNationDescription;
    private javax.swing.JComboBox jComboBoxOriginDescription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButtonSearchCopyData;
    private javax.swing.JRadioButton jRadioButtonSearchTrueData;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldICDCount;
    private javax.swing.JTextField jTextFieldNationCode;
    private javax.swing.JTextField jTextFieldOrderCount;
    private javax.swing.JTextField jTextFieldOriginCode;
    private javax.swing.JTextField jTextFieldPatientCount;
    private javax.swing.JTextField jTextFieldRefreshPatientTime;
    private javax.swing.JTextField jTextFieldWeight;
    // End of variables declaration//GEN-END:variables
}
