/*
 * PanelDiabetes.java
 *
 * Created on 7 ����¹ 2549, 9:26 �.
 */

package com.healthy.gui.panel;
import com.healthy.object.ResultType;
import com.hosv3.utility.DateUtil;
import com.pcu.control.HtControl;
import com.hosv3.utility.connection.UpdateStatus;
import com.pcu.utility.GutilPCU;
import java.util.*;
import javax.swing.*;
import com.healthy.object.*;
import com.hospital_os.utility.*;
import com.pcu.object.*;
import java.awt.*;

/**
 *
 * @author  hospitalos5
 */
public class PanelDiabetes extends javax.swing.JPanel  {
    public Vector theDiabetesV;
    public Diabetes theDiabetes;
    public HtControl theHtControl;
    public Family theFamily;
    JDialog jDialog = null; 

    private UpdateStatus theUS;
     
    /** Creates new form PanelDiabetes */
    public PanelDiabetes() {
        initComponents();
        theDiabetes = new Diabetes();
        setDisable();
        setLanguage();
    }
    
    public void setControl(HtControl ht,UpdateStatus us){
         theUS = us;
        theHtControl = ht;   
        this.dateComboBoxSurvey.setEditable(true);
        this.jTextFieldYearBudget.setText(theHtControl.getYear());
        buttonDeleteEnable();
        setLanguage();
    }
    
    public void updateOGDiabetes(Vector v) {
        theDiabetesV = v;
        if (v==null) v = new Vector();
        String[] column = {"�ѹ����Ѻ��ا����ش"};
        GutilPCU.setLanguage(column);
        TaBleModel tm = new TaBleModel(column, v.size());
        
        for (int i=0 ; i<v.size() ; i++) {
            Diabetes diabetes = (Diabetes)v.get(i);
            tm.setValueAt(GutilPCU.changDateToString(diabetes.record_time), i, 0);
        }
        this.jTable5.setModel(tm);
    }
    public void updateOGDiabetes(Diabetes diabetes) {
        //������дѺ��ӵ������ʹ
        this.jTextFieldBloodSugar.setText(diabetes.bisugar);
        //������ radio ������ҹ�ҡ��������ɳ�
        this.jRadioButtonAskIll.setSelected(false);
        this.jRadioButtonAskNormal.setSelected(false);
        this.jRadioButtonAskRisk.setSelected(false);
        if(diabetes.verbal_result.equals(ResultType.ILLNESS))
            this.jRadioButtonAskIll.setSelected(true);    
        else if(diabetes.verbal_result.equals(ResultType.NORMAL))
            this.jRadioButtonAskNormal.setSelected(true);    
        else if(diabetes.verbal_result.equals(ResultType.RISK))
            this.jRadioButtonAskRisk.setSelected(true);
        //������ radio ������ҹ�ҡ��õ�Ǩ�дѺ��ӵ��
        this.jRadioButtonResultIll.setSelected(false);
        this.jRadioButtonResultRisk.setSelected(false);
        this.jRadioButtonResultNormal.setSelected(false);
        if(diabetes.result.equals(ResultType.ILLNESS))
            this.jRadioButtonResultIll.setSelected(true);
        else if(diabetes.result.equals(ResultType.RISK))
            this.jRadioButtonResultRisk.setSelected(true);
        else if(diabetes.result.equals(ResultType.NORMAL))
            this.jRadioButtonResultNormal.setSelected(true);
        //����һէ�����ҳ
        this.jTextFieldYearBudget.setText(diabetes.idy);
        //������ѹ������Ǩ
        this.dateComboBoxSurvey.setText(com.hosv3.utility.DateUtil.convertFieldDate(diabetes.date_serv));
       
        if (diabetes.getObjectId() == null) {            
            this.jRadioButtonAskNormal.setSelected(true);
            this.jRadioButtonResultNormal.setSelected(true);
            this.jTextFieldYearBudget.setText(theHtControl.getYear());
        }
    }
    
    public void updateGODiabetes(Diabetes diabetes) {
        diabetes.family_id = theFamily.getObjectId();
        diabetes.idy = jTextFieldYearBudget.getText();
        diabetes.date_serv = dateComboBoxSurvey.getText();
        
        if (this.jRadioButtonAskNormal.isSelected())
            diabetes.verbal_result = ResultType.NORMAL;
        else if (this.jRadioButtonAskRisk.isSelected())
            diabetes.verbal_result = ResultType.RISK;
        else if (this.jRadioButtonAskIll.isSelected())
            diabetes.verbal_result = ResultType.ILLNESS;
        
        diabetes.bisugar = this.jTextFieldBloodSugar.getText();
        
        if (this.jRadioButtonResultNormal.isSelected())
            diabetes.result = ResultType.NORMAL;
        else if (this.jRadioButtonResultRisk.isSelected())
            diabetes.result = ResultType.RISK;
        else if (this.jRadioButtonResultIll.isSelected())
            diabetes.result = ResultType.ILLNESS;
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupVerbalScan = new javax.swing.ButtonGroup();
        buttonGroupDiabetesResult = new javax.swing.ButtonGroup();
        jPanelSweet = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jTextFieldYearBudget = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jRadioButtonAskNormal = new javax.swing.JRadioButton();
        jRadioButtonAskRisk = new javax.swing.JRadioButton();
        jRadioButtonAskIll = new javax.swing.JRadioButton();
        jLabel43 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jRadioButtonResultNormal = new javax.swing.JRadioButton();
        jRadioButtonResultRisk = new javax.swing.JRadioButton();
        jRadioButtonResultIll = new javax.swing.JRadioButton();
        jPanel23 = new javax.swing.JPanel();
        jTextFieldBloodSugar = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        dateComboBoxSurvey = new com.hospital_os.utility.DateComboBox();
        jPanel20 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelSweet.setLayout(new java.awt.GridBagLayout());

        jPanelSweet.setMinimumSize(new java.awt.Dimension(346, 250));
        jPanelSweet.setPreferredSize(new java.awt.Dimension(346, 250));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("\u0e1b\u0e23\u0e30\u0e27\u0e31\u0e15\u0e34\u0e01\u0e32\u0e23\u0e04\u0e31\u0e14\u0e01\u0e23\u0e2d\u0e07"));
        jPanel18.setMinimumSize(new java.awt.Dimension(180, 90));
        jPanel18.setPreferredSize(new java.awt.Dimension(180, 90));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 150));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable5MouseReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jTable5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel18.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        jPanelSweet.add(jPanel18, gridBagConstraints);

        jPanel19.setLayout(new java.awt.GridBagLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("\u0e02\u0e49\u0e2d\u0e21\u0e39\u0e25\u0e04\u0e31\u0e14\u0e01\u0e23\u0e2d\u0e07\u0e40\u0e1a\u0e32\u0e2b\u0e27\u0e32\u0e19"));
        jLabel38.setText("\u0e1b\u0e35\u0e07\u0e1a\u0e1b\u0e23\u0e30\u0e21\u0e32\u0e13 : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel19.add(jLabel38, gridBagConstraints);

        jTextFieldYearBudget.setMinimumSize(new java.awt.Dimension(60, 21));
        jTextFieldYearBudget.setPreferredSize(new java.awt.Dimension(60, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel19.add(jTextFieldYearBudget, gridBagConstraints);

        jLabel39.setText("\u0e27\u0e31\u0e19\u0e17\u0e35\u0e48\u0e2a\u0e33\u0e23\u0e27\u0e08 : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 0, 0);
        jPanel19.add(jLabel39, gridBagConstraints);

        jLabel40.setText("\u0e2a\u0e23\u0e38\u0e1b\u0e20\u0e32\u0e27\u0e30\u0e40\u0e1a\u0e32\u0e2b\u0e27\u0e32\u0e19\u0e08\u0e32\u0e01\u0e01\u0e32\u0e23\u0e2a\u0e31\u0e21\u0e20\u0e32\u0e29\u0e13\u0e4c : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel19.add(jLabel40, gridBagConstraints);

        jPanel21.setLayout(new java.awt.GridBagLayout());

        buttonGroupVerbalScan.add(jRadioButtonAskNormal);
        jRadioButtonAskNormal.setSelected(true);
        jRadioButtonAskNormal.setText("\u0e1b\u0e01\u0e15\u0e34");
        jPanel21.add(jRadioButtonAskNormal, new java.awt.GridBagConstraints());

        buttonGroupVerbalScan.add(jRadioButtonAskRisk);
        jRadioButtonAskRisk.setText("\u0e40\u0e2a\u0e35\u0e48\u0e22\u0e07");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        jPanel21.add(jRadioButtonAskRisk, gridBagConstraints);

        buttonGroupVerbalScan.add(jRadioButtonAskIll);
        jRadioButtonAskIll.setText("\u0e1b\u0e48\u0e27\u0e22");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        jPanel21.add(jRadioButtonAskIll, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        jPanel19.add(jPanel21, gridBagConstraints);

        jLabel43.setText("\u0e2a\u0e23\u0e38\u0e1b\u0e20\u0e32\u0e27\u0e30\u0e40\u0e1a\u0e32\u0e2b\u0e27\u0e32\u0e19 :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        jPanel19.add(jLabel43, gridBagConstraints);

        jPanel22.setLayout(new java.awt.GridBagLayout());

        buttonGroupDiabetesResult.add(jRadioButtonResultNormal);
        jRadioButtonResultNormal.setSelected(true);
        jRadioButtonResultNormal.setText("\u0e1b\u0e01\u0e15\u0e34");
        jPanel22.add(jRadioButtonResultNormal, new java.awt.GridBagConstraints());

        buttonGroupDiabetesResult.add(jRadioButtonResultRisk);
        jRadioButtonResultRisk.setText("\u0e40\u0e2a\u0e35\u0e48\u0e22\u0e07");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        jPanel22.add(jRadioButtonResultRisk, gridBagConstraints);

        buttonGroupDiabetesResult.add(jRadioButtonResultIll);
        jRadioButtonResultIll.setText("\u0e1b\u0e48\u0e27\u0e22");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        jPanel22.add(jRadioButtonResultIll, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel19.add(jPanel22, gridBagConstraints);

        jPanel23.setLayout(new java.awt.GridBagLayout());

        jTextFieldBloodSugar.setMinimumSize(new java.awt.Dimension(50, 21));
        jTextFieldBloodSugar.setPreferredSize(new java.awt.Dimension(50, 21));
        jPanel23.add(jTextFieldBloodSugar, new java.awt.GridBagConstraints());

        jLabel42.setText(" \u0e21\u0e34\u0e25\u0e25\u0e34\u0e01\u0e23\u0e31\u0e21\u0e40\u0e1b\u0e2d\u0e23\u0e4c\u0e40\u0e0b\u0e19\u0e15\u0e4c");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel23.add(jLabel42, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel19.add(jPanel23, gridBagConstraints);

        jLabel41.setText("\u0e1b\u0e23\u0e34\u0e21\u0e32\u0e13\u0e19\u0e49\u0e33\u0e15\u0e32\u0e25\u0e43\u0e19\u0e40\u0e25\u0e37\u0e2d\u0e14 : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(jLabel41, gridBagConstraints);

        dateComboBoxSurvey.setMinimumSize(new java.awt.Dimension(100, 24));
        dateComboBoxSurvey.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(dateComboBoxSurvey, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelSweet.add(jPanel19, gridBagConstraints);

        jPanel20.setLayout(new java.awt.GridBagLayout());

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

        jPanel20.add(jButtonAdd, new java.awt.GridBagConstraints());

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/minus16.gif")));
        jButtonDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonDelete.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonDelete.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonDelete.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel20.add(jButtonDelete, gridBagConstraints);

        jButtonSave.setText("\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01");
        jButtonSave.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSave.setMaximumSize(new java.awt.Dimension(60, 24));
        jButtonSave.setMinimumSize(new java.awt.Dimension(60, 24));
        jButtonSave.setPreferredSize(new java.awt.Dimension(60, 24));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel20.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanelSweet.add(jPanel20, gridBagConstraints);

        add(jPanelSweet, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void jTable5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseReleased
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));            
        int index = this.jTable5.getSelectedRow();
        if(index==-1)
            return;
        theDiabetes = (Diabetes)theDiabetesV.get(index);
        updateOGDiabetes(theDiabetes);
        /*this.jTextFieldStatus.setText(theImageLink.image_path);
        this.jTextFieldHN1.setText(theImageLink.note);
        this.jCheckBox1.setSelected(theImageLink.note.equals(
            ImageLink.ST_PatientImage));
        this.jTextFieldHN1.setEditable(!this.jCheckBox1.isSelected());*/
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); 
        buttonDeleteEnable();
        setEnable();
    }//GEN-LAST:event_jTable5MouseReleased

    private void buttonDeleteEnable() {
        if (theDiabetes.getObjectId()!=null) 
            this.jButtonDelete.setEnabled(true);
        else
            this.jButtonDelete.setEnabled(false);
    }
    
    private void setEnable() {
        this.jTextFieldYearBudget.setEnabled(true);
        this.jTextFieldBloodSugar.setEnabled(true);
        this.dateComboBoxSurvey.setEnabled(true);
        this.jRadioButtonAskIll.setEnabled(true);
        this.jRadioButtonAskNormal.setEnabled(true);
        this.jRadioButtonAskRisk.setEnabled(true);
        this.jRadioButtonResultIll.setEnabled(true);
        this.jRadioButtonResultNormal.setEnabled(true);
        this.jRadioButtonResultRisk.setEnabled(true);
        this.jButtonSave.setEnabled(true);
    }
    
    private void setDisable() {
        this.jTextFieldYearBudget.setEnabled(false);
        this.jTextFieldBloodSugar.setEnabled(false);
        this.dateComboBoxSurvey.setEnabled(false);
        this.jRadioButtonAskIll.setEnabled(false);
        this.jRadioButtonAskNormal.setEnabled(false);
        this.jRadioButtonAskRisk.setEnabled(false);
        this.jRadioButtonResultIll.setEnabled(false);
        this.jRadioButtonResultNormal.setEnabled(false);
        this.jRadioButtonResultRisk.setEnabled(false);
        this.jButtonSave.setEnabled(false);
    }
    
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (!theUS.confirmBox("�س��ͧ���ź�����ŷ�����͡�������",UpdateStatus.WARNING))
            return;
        {
            this.theHtControl.deleteDiabetes(theDiabetes);
            this.updateFamily(theFamily);
            theDiabetes = new Diabetes();
            updateOGDiabetes(theDiabetes);
            buttonDeleteEnable();
            setDisable();
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        theDiabetes = new Diabetes();
        updateOGDiabetes(theDiabetes);
        setEnable();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        this.updateGODiabetes(theDiabetes);
        this.theHtControl.saveDiabetes(theDiabetes);
        this.updateFamily(theFamily);
        buttonDeleteEnable();
    }//GEN-LAST:event_jButtonSaveActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDiabetesResult;
    private javax.swing.ButtonGroup buttonGroupVerbalScan;
    private com.hospital_os.utility.DateComboBox dateComboBoxSurvey;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanelSweet;
    private javax.swing.JRadioButton jRadioButtonAskIll;
    private javax.swing.JRadioButton jRadioButtonAskNormal;
    private javax.swing.JRadioButton jRadioButtonAskRisk;
    private javax.swing.JRadioButton jRadioButtonResultIll;
    private javax.swing.JRadioButton jRadioButtonResultNormal;
    private javax.swing.JRadioButton jRadioButtonResultRisk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextFieldBloodSugar;
    private javax.swing.JTextField jTextFieldYearBudget;
    // End of variables declaration//GEN-END:variables
    
    public void updateFamily(Family family) {
        theFamily = family;
        Vector familyV = theHtControl.listDiabetesByFid(family.getObjectId());
        updateOGDiabetes(familyV);
        updateOGDiabetes(new Diabetes());
   }
    
    public void showDialog(Family family) 
    {
        if(jDialog==null)
        {        
            if(theHtControl.theUS!=null)
                jDialog = new JDialog(this.theHtControl.theUS.getJFrame(),true);
            else
                jDialog = new JDialog();
            jDialog.getContentPane().add(this);
            jDialog.setSize(650, 194);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            jDialog.setLocation((screenSize.width-jDialog.getSize().width)/2
                    , (screenSize.height-jDialog.getSize().height)/2);
        }
        updateFamily(family);
        setDisable();
        jDialog.setVisible(true);
    }
    
//    public static void showDialog(Family family, ConnectionInf con) {
//        JDialog jDialog = new JDialog();
//        PanelDiabetes panel = new PanelDiabetes();
//        jDialog.getContentPane().add(panel);
//        HtControl hc = new HtControl(con);
//        panel.setControl(hc);
//        panel.updateFamily(family);
//        jDialog.setSize(650, 194);     
//        jDialog.setVisible(true);
//    }
    
    public static void main(String[] argc)
    {
        System.setProperty("debug", "1");
        Family family = new Family();
        family.hospital_site = "00000";
        family.setObjectId("555");
        HtControl hc = new HtControl();
        PanelDiabetes thePanelDiabetes = new PanelDiabetes();
        thePanelDiabetes.setControl(hc,hc.theUS);        
        thePanelDiabetes.showDialog(family);
    }

    private void setLanguage() {
        GutilPCU.setLanguage(jPanel18);
        GutilPCU.setLanguage(jPanel19);
        GutilPCU.setLanguage(jLabel38);
        GutilPCU.setLanguage(jLabel39);
        GutilPCU.setLanguage(jLabel40);
        GutilPCU.setLanguage(jRadioButtonAskNormal);
        GutilPCU.setLanguage(jRadioButtonAskRisk);
        GutilPCU.setLanguage(jRadioButtonAskIll);
        GutilPCU.setLanguage(jLabel43);
        GutilPCU.setLanguage(jRadioButtonResultNormal);
        GutilPCU.setLanguage(jRadioButtonResultRisk);
        GutilPCU.setLanguage(jRadioButtonResultIll);
        GutilPCU.setLanguage(jLabel42);
        GutilPCU.setLanguage(jLabel41);
        GutilPCU.setLanguage(jButtonSave);
    }
    
}