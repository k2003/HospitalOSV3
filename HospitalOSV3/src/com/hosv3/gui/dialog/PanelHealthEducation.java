/*
 * PanelHealthEducation.java
 *
 * Created on 10 ����Ҥ� 2549, 11:11 �.
 */

package com.hosv3.gui.dialog;
import com.hosv3.utility.Constant;
import com.hosv3.control.*;
import com.hospital_os.object.*;
import com.hosv3.utility.connection.*;
import com.hosv3.utility.*;
import java.util.*;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author  henbe
 */
public class PanelHealthEducation extends javax.swing.JPanel {
    
    HosControl theHC;
    UpdateStatus theUS;
    JDialog theJD;
    Vector vGuide = new Vector(); 
    boolean ret = false;
    /** Creates new form PanelHealthEducation */
    public PanelHealthEducation() {
        initComponents();
        setLanguage(null);
    }
    public PanelHealthEducation(HosControl hc,UpdateStatus us) {
        initComponents();
        setLanguage(null);
        setControl(hc,us);
        initDialog();
    }
    public void setControl(HosControl hc,UpdateStatus us){
        theHC = hc;
        theUS = us;
    }
    public void initDialog()
    {
        theJD = new JDialog(theUS.getJFrame(),true);
        theJD.setTitle(Constant.getTextBundle("�آ�֡��"));
        theJD.getContentPane().add(this);  
        theJD.setSize(415,500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        theJD.setLocation((screenSize.width-theJD.getSize().width)/2
                , (screenSize.height-theJD.getSize().height)/2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jCheckBoxHEPerson = new javax.swing.JCheckBox();
        jCheckBoxHEGroup = new javax.swing.JCheckBox();
        jCheckBoxHEFamily = new javax.swing.JCheckBox();
        jCheckBoxHomeVisit = new javax.swing.JCheckBox();
        jCheckBoxDMethod = new javax.swing.JCheckBox();
        jCheckBoxOther = new javax.swing.JCheckBox();
        jCheckBoxHomeHealthCare = new javax.swing.JCheckBox();
        jTextFieldHEPerson = new javax.swing.JTextField();
        jTextFieldHEFamily = new javax.swing.JTextField();
        jTextFieldHEGroup = new javax.swing.JTextField();
        jTextFieldDMethod = new javax.swing.JTextField();
        jTextFieldHomeVisit = new javax.swing.JTextField();
        jTextFieldHomeHealthCare = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jCheckBoxExercise = new javax.swing.JCheckBox();
        jCheckBoxFood = new javax.swing.JCheckBox();
        jCheckBoxMySelf = new javax.swing.JCheckBox();
        jCheckBoxDrug = new javax.swing.JCheckBox();
        jCheckBoxRelax = new javax.swing.JCheckBox();
        jCheckBoxDisease = new javax.swing.JCheckBox();
        jCheckBoxAppoint = new javax.swing.JCheckBox();
        jCheckBoxHerb = new javax.swing.JCheckBox();
        jScrollPaneNote = new javax.swing.JScrollPane();
        jTextFieldOther = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButtonSaveHE = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBorder(javax.swing.BorderFactory.createTitledBorder("\u0e43\u0e2b\u0e49\u0e04\u0e33\u0e41\u0e19\u0e30\u0e19\u0e33 \u0e2a\u0e38\u0e02\u0e28\u0e36\u0e01\u0e29\u0e32"));
        jCheckBoxHEPerson.setText("\u0e2a\u0e38\u0e02\u0e28\u0e36\u0e01\u0e29\u0e32\u0e23\u0e32\u0e22\u0e1a\u0e38\u0e04\u0e04\u0e25 \u0e40\u0e23\u0e37\u0e48\u0e2d\u0e07");
        jCheckBoxHEPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHEPersonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(jCheckBoxHEPerson, gridBagConstraints);

        jCheckBoxHEGroup.setText("\u0e2a\u0e38\u0e02\u0e28\u0e36\u0e01\u0e29\u0e32\u0e23\u0e32\u0e22\u0e01\u0e25\u0e38\u0e48\u0e21 \u0e40\u0e23\u0e37\u0e48\u0e2d\u0e07");
        jCheckBoxHEGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHEGroupActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        add(jCheckBoxHEGroup, gridBagConstraints);

        jCheckBoxHEFamily.setText("\u0e2a\u0e38\u0e02\u0e28\u0e36\u0e01\u0e29\u0e32\u0e23\u0e32\u0e22\u0e04\u0e23\u0e2d\u0e1a\u0e04\u0e23\u0e31\u0e27 \u0e40\u0e23\u0e37\u0e48\u0e2d\u0e07");
        jCheckBoxHEFamily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHEFamilyActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        add(jCheckBoxHEFamily, gridBagConstraints);

        jCheckBoxHomeVisit.setText("\u0e19\u0e31\u0e14 Home visit");
        jCheckBoxHomeVisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHomeVisitActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        add(jCheckBoxHomeVisit, gridBagConstraints);

        jCheckBoxDMethod.setText("D-Method \u0e42\u0e23\u0e04");
        jCheckBoxDMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDMethodActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        add(jCheckBoxDMethod, gridBagConstraints);

        jCheckBoxOther.setText("\u0e2d\u0e37\u0e48\u0e19\u0e46 (\u0e23\u0e30\u0e1a\u0e38)");
        jCheckBoxOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxOtherActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        add(jCheckBoxOther, gridBagConstraints);

        jCheckBoxHomeHealthCare.setText("\u0e19\u0e31\u0e14 Home health care");
        jCheckBoxHomeHealthCare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHomeHealthCareActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        add(jCheckBoxHomeHealthCare, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 0, 12);
        add(jTextFieldHEPerson, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(jTextFieldHEFamily, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(jTextFieldHEGroup, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(jTextFieldDMethod, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(jTextFieldHomeVisit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(jTextFieldHomeHealthCare, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jCheckBoxExercise.setText("\u0e01\u0e32\u0e23\u0e2d\u0e2d\u0e01\u0e01\u0e33\u0e25\u0e31\u0e07\u0e01\u0e32\u0e22");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jCheckBoxExercise, gridBagConstraints);

        jCheckBoxFood.setText("\u0e01\u0e32\u0e23\u0e04\u0e27\u0e1a\u0e04\u0e38\u0e21\u0e2d\u0e32\u0e2b\u0e32\u0e23");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jCheckBoxFood, gridBagConstraints);

        jCheckBoxMySelf.setText("\u0e01\u0e32\u0e23\u0e1b\u0e0f\u0e34\u0e1a\u0e31\u0e15\u0e34\u0e15\u0e19\u0e17\u0e31\u0e48\u0e27\u0e44\u0e1b");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jCheckBoxMySelf, gridBagConstraints);

        jCheckBoxDrug.setText("\u0e01\u0e32\u0e23\u0e43\u0e0a\u0e49\u0e22\u0e32\u0e17\u0e35\u0e48\u0e16\u0e39\u0e01\u0e15\u0e49\u0e2d\u0e07");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel1.add(jCheckBoxDrug, gridBagConstraints);

        jCheckBoxRelax.setText("\u0e01\u0e32\u0e23\u0e1e\u0e31\u0e01\u0e1c\u0e48\u0e2d\u0e19\u0e41\u0e25\u0e30\u0e25\u0e14\u0e04\u0e27\u0e32\u0e21\u0e40\u0e04\u0e23\u0e35\u0e22\u0e14");
        jCheckBoxRelax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRelaxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        jPanel1.add(jCheckBoxRelax, gridBagConstraints);

        jCheckBoxDisease.setText("\u0e01\u0e32\u0e23\u0e43\u0e2b\u0e49\u0e04\u0e27\u0e32\u0e21\u0e23\u0e39\u0e49\u0e40\u0e23\u0e37\u0e48\u0e2d\u0e07\u0e42\u0e23\u0e04\u0e41\u0e25\u0e30\u0e20\u0e32\u0e27\u0e30\u0e41\u0e17\u0e23\u0e01\u0e0b\u0e49\u0e2d\u0e19");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 0);
        jPanel1.add(jCheckBoxDisease, gridBagConstraints);

        jCheckBoxAppoint.setText("\u0e01\u0e32\u0e23\u0e21\u0e32\u0e15\u0e23\u0e27\u0e08\u0e15\u0e32\u0e21\u0e19\u0e31\u0e14");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        jPanel1.add(jCheckBoxAppoint, gridBagConstraints);

        jCheckBoxHerb.setText("\u0e2a\u0e21\u0e38\u0e19\u0e44\u0e1e\u0e23\u0e17\u0e35\u0e48\u0e40\u0e01\u0e35\u0e48\u0e22\u0e27\u0e02\u0e49\u0e2d\u0e07");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        jPanel1.add(jCheckBoxHerb, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 11, 12);
        add(jPanel1, gridBagConstraints);

        jScrollPaneNote.setMinimumSize(new java.awt.Dimension(3, 35));
        jScrollPaneNote.setPreferredSize(new java.awt.Dimension(3, 35));
        jTextFieldOther.setLineWrap(true);
        jTextFieldOther.setWrapStyleWord(true);
        jScrollPaneNote.setViewportView(jTextFieldOther);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 12);
        add(jScrollPaneNote, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonSaveHE.setText("OK");
        jButtonSaveHE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveHEActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(17, 12, 12, 0);
        jPanel2.add(jButtonSaveHE, gridBagConstraints);

        jButtonCancel.setText("\u0e22\u0e01\u0e40\u0e25\u0e34\u0e01");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(17, 5, 12, 12);
        jPanel2.add(jButtonCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jPanel2, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        if(theJD!=null)
            theJD.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jCheckBoxRelaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRelaxActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxRelaxActionPerformed

    private void jCheckBoxOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxOtherActionPerformed
        if(jCheckBoxOther.isSelected())
        {
            jTextFieldOther.setEnabled(true);
        }
        else
        {
            jTextFieldOther.setEnabled(false);
            jTextFieldOther.setText("");
        }
    }//GEN-LAST:event_jCheckBoxOtherActionPerformed

    private void jCheckBoxHomeHealthCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxHomeHealthCareActionPerformed
        if(jCheckBoxHomeHealthCare.isSelected())
        {
            jTextFieldHomeHealthCare.setEnabled(true);
        }
        else
        {
            jTextFieldHomeHealthCare.setEnabled(false);
            jTextFieldHomeHealthCare.setText("");
        }
    }//GEN-LAST:event_jCheckBoxHomeHealthCareActionPerformed

    private void jCheckBoxHomeVisitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxHomeVisitActionPerformed
        if(jCheckBoxHomeVisit.isSelected())
        {
            jTextFieldHomeVisit.setEnabled(true);
        }
        else
        {
            jTextFieldHomeVisit.setEnabled(false);
            jTextFieldHomeVisit.setText("");
        }
    }//GEN-LAST:event_jCheckBoxHomeVisitActionPerformed

    private void jCheckBoxDMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDMethodActionPerformed
        if(jCheckBoxDMethod.isSelected())
        {
            jTextFieldDMethod.setEnabled(true);
        }
        else
        {
            jTextFieldDMethod.setEnabled(false);
            jTextFieldDMethod.setText("");
        }
    }//GEN-LAST:event_jCheckBoxDMethodActionPerformed

    private void jCheckBoxHEFamilyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxHEFamilyActionPerformed
        if(jCheckBoxHEFamily.isSelected())
        {
            jTextFieldHEFamily.setEnabled(true);
        }
        else
        {
            jTextFieldHEFamily.setEnabled(false);
            jTextFieldHEFamily.setText("");
        }
    }//GEN-LAST:event_jCheckBoxHEFamilyActionPerformed

    private void jCheckBoxHEGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxHEGroupActionPerformed
        if(jCheckBoxHEGroup.isSelected())
        {
            jTextFieldHEGroup.setEnabled(true);
        }
        else
        {
            jTextFieldHEGroup.setEnabled(false);
            jTextFieldHEGroup.setText("");
        }
    }//GEN-LAST:event_jCheckBoxHEGroupActionPerformed

    private void jCheckBoxHEPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxHEPersonActionPerformed
        if(jCheckBoxHEPerson.isSelected())
        {
            jTextFieldHEPerson.setEnabled(true);
        }
        else
        {
            jTextFieldHEPerson.setEnabled(false);
            jTextFieldHEPerson.setText("");
        }
    }//GEN-LAST:event_jCheckBoxHEPersonActionPerformed

    private void jButtonSaveHEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveHEActionPerformed
        getGuideV();
        ret = true;
        if(theJD!=null)
            theJD.dispose();
    }//GEN-LAST:event_jButtonSaveHEActionPerformed
    public boolean showDialog(Vector guide)
    {
        ret = false;
        setDefault();
        setGuideV(guide);
        theJD.setVisible(true);
        return ret;
    }
    
    public void getGuideHealth(Vector v,String body,String detail,boolean check)
    {
        for(int i=0,size= v.size();i <size;i++)
        {
            GuideAfterDxTransaction gfdt = (GuideAfterDxTransaction)v.get(i);
            if(gfdt.health_head.equals(body))
            {
                v.remove(gfdt);
                break;
            }
        }
        if(check){
            GuideAfterDxTransaction gu = new GuideAfterDxTransaction();
            gu.health_head = body;
            gu.guide = detail;
            v.add(gu);
        }
    }
    
    public Vector getGuideV()
    {
        getGuideHealth(vGuide,"�آ�֡����ºؤ��",jTextFieldHEPerson.getText(),jCheckBoxHEPerson.isSelected());
        getGuideHealth(vGuide,"�آ�֡����¡����",jTextFieldHEGroup.getText(),jCheckBoxHEGroup.isSelected());
        getGuideHealth(vGuide,"�آ�֡����¤�ͺ����",jTextFieldHEFamily.getText(),jCheckBoxHEFamily.isSelected());
        getGuideHealth(vGuide,"D-Method �ä",jTextFieldDMethod.getText(),jCheckBoxDMethod.isSelected());
        getGuideHealth(vGuide,"�Ѵ Home visit",jTextFieldHomeVisit.getText(),jCheckBoxHomeVisit.isSelected());
        getGuideHealth(vGuide,"�Ѵ Home health care",jTextFieldHomeHealthCare.getText(),jCheckBoxHomeHealthCare.isSelected());
        getGuideHealth(vGuide,"����",jTextFieldOther.getText(),jCheckBoxOther.isSelected());
        getGuideHealth(vGuide,"����͡���ѧ���","",jCheckBoxExercise.isSelected());
        getGuideHealth(vGuide,"��äǺ��������","",jCheckBoxFood.isSelected());
        getGuideHealth(vGuide,"��û�ԺѵԵ������","",jCheckBoxMySelf.isSelected());
        getGuideHealth(vGuide,"������ҷ��١��ͧ","",jCheckBoxDrug.isSelected());
        getGuideHealth(vGuide,"��þѡ��͹���Ŵ�������´","",jCheckBoxRelax.isSelected());
        getGuideHealth(vGuide,"����ҵ�Ǩ����Ѵ","",jCheckBoxAppoint.isSelected());
        getGuideHealth(vGuide,"��ع�÷������Ǣ�ͧ","",jCheckBoxHerb.isSelected());
        getGuideHealth(vGuide,"����������������ͧ�ä��������á��͹","",jCheckBoxDisease.isSelected());
        return vGuide;
    } 
    
    public void setGuideV(Vector v)
    {
        this.vGuide = v;
        for(int i=0,size=v.size();i<size;i++)
        {    
            GuideAfterDxTransaction gu = (GuideAfterDxTransaction)v.get(i);
            if(gu.health_head.equals("�آ�֡����ºؤ��")) 
            {
                jCheckBoxHEPerson.setSelected(true);
                jTextFieldHEPerson.setText(gu.guide);
            }
            else if(gu.health_head.equals("�آ�֡����¡����"))
            {
                jCheckBoxHEGroup.setSelected(true);
                jTextFieldHEGroup.setText(gu.guide);
            }
            else if(gu.health_head.equals("�آ�֡����¤�ͺ����"))
            {
                jCheckBoxHEFamily.setSelected(true);
                jTextFieldHEFamily.setText(gu.guide);
            }
            else if(gu.health_head.equals("D-Method �ä"))
            {
                jCheckBoxDMethod.setSelected(true);
                jTextFieldDMethod.setText(gu.guide);
            }
            else if(gu.health_head.equals("�Ѵ Home visit"))
            {
                jCheckBoxHomeVisit.setSelected(true);
                jTextFieldHomeVisit.setText(gu.guide);
            }
            else if(gu.health_head.equals("�Ѵ Home health care"))
            {
                jCheckBoxHomeHealthCare.setSelected(true);
                jTextFieldHomeHealthCare.setText(gu.guide);
            }
            else if(gu.health_head.equals("����"))
            {
                jCheckBoxOther.setSelected(true);
                jTextFieldOther.setText(gu.guide);
            }
            else if(gu.health_head.equals("����͡���ѧ���"))
            {
                jCheckBoxExercise.setSelected(true);
            }
            else if(gu.health_head.equals("��äǺ��������"))
            {
                jCheckBoxFood.setSelected(true);
            }
            else if(gu.health_head.equals("��û�ԺѵԵ������"))
            {
                jCheckBoxMySelf.setSelected(true);
            }
            else if(gu.health_head.equals("������ҷ��١��ͧ"))
            {
                jCheckBoxDrug.setSelected(true);
            }
            else if(gu.health_head.equals("��þѡ��͹���Ŵ�������´"))
            {
                jCheckBoxRelax.setSelected(true);
            }
            else if(gu.health_head.equals("����ҵ�Ǩ����Ѵ"))
            {
                jCheckBoxAppoint.setSelected(true);
            }
            else if(gu.health_head.equals("��ع�÷������Ǣ�ͧ"))
            {
                jCheckBoxHerb.setSelected(true);
            }
            else if(gu.health_head.equals("����������������ͧ�ä��������á��͹"))
            {
                jCheckBoxDisease.setSelected(true);
            }
        }
        jCheckBoxHEPersonActionPerformed(null);
        jCheckBoxHEGroupActionPerformed(null);
        jCheckBoxHEFamilyActionPerformed(null);
        jCheckBoxDMethodActionPerformed(null);
        jCheckBoxHomeVisitActionPerformed(null);
        jCheckBoxHomeHealthCareActionPerformed(null);
        jCheckBoxOtherActionPerformed(null); 
    }
    
    public void setLanguage(String msg)
    {
        GuiLang.setLanguage(jCheckBoxAppoint);
        GuiLang.setLanguage(jCheckBoxDMethod);
        GuiLang.setLanguage(jCheckBoxDisease);
        GuiLang.setLanguage(jCheckBoxDrug);
        GuiLang.setLanguage(jCheckBoxExercise);
        GuiLang.setLanguage(jCheckBoxFood);
        GuiLang.setLanguage(jCheckBoxHEFamily);
        GuiLang.setLanguage(jCheckBoxHEGroup);
        GuiLang.setLanguage(jCheckBoxHEPerson);
        GuiLang.setLanguage(jCheckBoxHerb);
        GuiLang.setLanguage(jCheckBoxHomeHealthCare);
        GuiLang.setLanguage(jCheckBoxHomeVisit);
        GuiLang.setLanguage(jCheckBoxMySelf);
        GuiLang.setLanguage(jCheckBoxOther);
        GuiLang.setLanguage(jCheckBoxRelax);
        GuiLang.setLanguage(jButtonSaveHE);
        GuiLang.setLanguage(jButtonCancel);
        GuiLang.setTextBundle(this);
    }

    public void setDefault()
    {
        jCheckBoxHEPerson.setSelected(false);
        jCheckBoxHEGroup.setSelected(false);
        jCheckBoxHEFamily.setSelected(false);
        jCheckBoxDMethod.setSelected(false);
        jCheckBoxHomeVisit.setSelected(false);
        jCheckBoxHomeHealthCare.setSelected(false);
        jCheckBoxOther.setSelected(false);
        jTextFieldHEPerson.setEnabled(false);
        jTextFieldHEPerson.setText("");
        jTextFieldHEGroup.setEnabled(false);
        jTextFieldHEGroup.setText("");
        jTextFieldHEFamily.setEnabled(false);
        jTextFieldHEFamily.setText("");
        jTextFieldDMethod.setEnabled(false);
        jTextFieldDMethod.setText("");
        jTextFieldHomeVisit.setEnabled(false);
        jTextFieldHomeVisit.setText("");
        jTextFieldHomeHealthCare.setEnabled(false);
        jTextFieldHomeHealthCare.setText("");
        jTextFieldOther.setEnabled(false);
        jTextFieldOther.setText("");
        jCheckBoxExercise.setSelected(false);
        jCheckBoxFood.setSelected(false);
        jCheckBoxMySelf.setSelected(false);
        jCheckBoxDrug.setSelected(false);
        jCheckBoxRelax.setSelected(false);
        jCheckBoxHerb.setSelected(false);
        jCheckBoxRelax.setSelected(false);
        jCheckBoxDisease.setSelected(false);
        jCheckBoxAppoint.setSelected(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSaveHE;
    private javax.swing.JCheckBox jCheckBoxAppoint;
    private javax.swing.JCheckBox jCheckBoxDMethod;
    private javax.swing.JCheckBox jCheckBoxDisease;
    private javax.swing.JCheckBox jCheckBoxDrug;
    private javax.swing.JCheckBox jCheckBoxExercise;
    private javax.swing.JCheckBox jCheckBoxFood;
    private javax.swing.JCheckBox jCheckBoxHEFamily;
    private javax.swing.JCheckBox jCheckBoxHEGroup;
    private javax.swing.JCheckBox jCheckBoxHEPerson;
    private javax.swing.JCheckBox jCheckBoxHerb;
    private javax.swing.JCheckBox jCheckBoxHomeHealthCare;
    private javax.swing.JCheckBox jCheckBoxHomeVisit;
    private javax.swing.JCheckBox jCheckBoxMySelf;
    private javax.swing.JCheckBox jCheckBoxOther;
    private javax.swing.JCheckBox jCheckBoxRelax;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneNote;
    private javax.swing.JTextField jTextFieldDMethod;
    private javax.swing.JTextField jTextFieldHEFamily;
    private javax.swing.JTextField jTextFieldHEGroup;
    private javax.swing.JTextField jTextFieldHEPerson;
    private javax.swing.JTextField jTextFieldHomeHealthCare;
    private javax.swing.JTextField jTextFieldHomeVisit;
    private javax.swing.JTextArea jTextFieldOther;
    // End of variables declaration//GEN-END:variables
    
}
