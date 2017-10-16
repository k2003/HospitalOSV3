/*
 * PanelRegisterNCD.java
 *
 * Created on 17 �Զع�¹ 2549, 15:56 �.
 */

package com.hosv3.gui.component.nan;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hosv3.object.*;

import com.hospital_os.utility.*;
import com.hospital_os.object.*;
/**
 *
 * @author  amp
 */
public class PanelRegisterNCD extends javax.swing.JPanel
{
    HosObject theHO;
    HosControl theHC;
    UpdateStatus theUS;
    JDialog theJD;
    
    private Vector vNCDGroup;
    private NCD theNCD = new NCD();
    private int result = 0;
    private boolean set_patient = false;
    private boolean set_visit = true;
    
    /** Creates new form PanelRegisterNCD */
    public PanelRegisterNCD(HosControl hc,UpdateStatus us)
    {
        theHC = hc;
        theUS = us;
        theHO = hc.theHO;
        initComponents();
        initDialog();
        initData();
    }
    
    public void initDialog()
    {
        theJD = new JDialog(theUS.getJFrame(),true);
        theJD.setTitle("���ѡ�ҡ�����ä NCD");
        theJD.getContentPane().add(this);  
        theJD.setSize(390,110);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        theJD.setLocation((screenSize.width-theJD.getSize().width)/2
                , (screenSize.height-theJD.getSize().height)/2);        
    }
    
    public void showDialog(boolean pt,boolean vs)
    {
        set_patient = pt;
        set_visit = vs;
        checkNumber();
        theJD.setVisible(true);
    }
    
    private void initData()
    {        
        ComboboxModel.initComboBox(jComboBoxNCDGroup,theHC.theLookupControl.listNCDGroup());
        if(theHO.theVisit!=null && "1".equals(theHO.theVisit.ncd))
        {
            jCheckBoxNCD.setSelected(true);
            Gutil.setGuiData(jComboBoxNCDGroup,theHO.theVisit.ncd_group); 
            //��� visit �������㹡���� ncd ���Ǩ�����¹�������������� �������¹��������Ţ��ͧ����¹������¹�
            jComboBoxNCDGroup.setEnabled(true);
            integerTextFieldNumber.setEnabled(true);
        }
        else
        {
            jCheckBoxNCD.setSelected(false);
            jComboBoxNCDGroup.setEnabled(false);
            integerTextFieldNumber.setEnabled(false);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jCheckBoxNCD = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonAbort = new javax.swing.JButton();
        jComboBoxNCDGroup = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        integerTextFieldNumber = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        jCheckBoxNCD.setText("NCD");
        jCheckBoxNCD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBoxNCDActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        add(jCheckBoxNCD, gridBagConstraints);

        jLabel1.setText("\u0e01\u0e25\u0e38\u0e48\u0e21");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        add(jLabel1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonSave.setText("\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01");
        jButtonSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jButtonSave, gridBagConstraints);

        jButtonAbort.setText("\u0e22\u0e01\u0e40\u0e25\u0e34\u0e01");
        jButtonAbort.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAbortActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel1.add(jButtonAbort, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel1, gridBagConstraints);

        jComboBoxNCDGroup.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxNCDGroupActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        add(jComboBoxNCDGroup, gridBagConstraints);

        jLabel2.setText("\u0e2b\u0e21\u0e32\u0e22\u0e40\u0e25\u0e02");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        add(integerTextFieldNumber, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents

    private void jComboBoxNCDGroupActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxNCDGroupActionPerformed
    {//GEN-HEADEREND:event_jComboBoxNCDGroupActionPerformed
        checkNumber();
    }//GEN-LAST:event_jComboBoxNCDGroupActionPerformed

    private void jCheckBoxNCDActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxNCDActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxNCDActionPerformed
        if(jCheckBoxNCD.isSelected())
        {
            //if(set_visit && theHO.theVisit!=null && "1".equals(theHO.theVisit.ncd))
            //    jComboBoxNCDGroup.setEnabled(false);
            //else
            jComboBoxNCDGroup.setEnabled(true);            
            integerTextFieldNumber.setEnabled(true);
        }
        else
        {
            jComboBoxNCDGroup.setEnabled(false);
            integerTextFieldNumber.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxNCDActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSaveActionPerformed
    {//GEN-HEADEREND:event_jButtonSaveActionPerformed
        saveNCD();  
        if(result==1)
        {
            if(theJD!=null)
                theJD.dispose();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonAbortActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAbortActionPerformed
    {//GEN-HEADEREND:event_jButtonAbortActionPerformed
        if(theJD!=null)
            theJD.dispose();
    }//GEN-LAST:event_jButtonAbortActionPerformed
    
    private void saveNCD()
    {
        updateGONCD();
        result = theHC.theVisitControl.saveVisitNCD(theNCD,jCheckBoxNCD.isSelected());
    }
    
    private void updateGONCD()
    {  
        if(theNCD==null) theNCD = new NCD(); 
        theNCD.patient_id = theHO.thePatient.getObjectId();
        theNCD.ncd_group_id = Gutil.getGuiData(jComboBoxNCDGroup);
        theNCD.ncd_number = integerTextFieldNumber.getText();
    }
    
    private void checkNumber()
    { 
        jLabel3.setText("�ҡ����͡������ �����Ţ NCD �������� " 
                + theHC.theSetupControl.readNCDGroupByPk(Gutil.getGuiData(jComboBoxNCDGroup)).value);
        integerTextFieldNumber.setText("");
        if(theHO.vNCD != null)
        {
            theNCD = new NCD();
            loop:for(int i=0,size=theHO.vNCD.size(); i<size; i++)
            {
                NCD ncd = (NCD)theHO.vNCD.get(i);
                //if(theHO.theVisit.ncd_group.equals(ncd.ncd_group_id))
                if(Gutil.getGuiData(jComboBoxNCDGroup).equals(ncd.ncd_group_id))
                {
                    integerTextFieldNumber.setText(ncd.ncd_number);
                    theNCD = ncd;
                    break loop;
                }
            }
        }
        else
        {
            theNCD=null;
        }        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField integerTextFieldNumber;
    private javax.swing.JButton jButtonAbort;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxNCD;
    private javax.swing.JComboBox jComboBoxNCDGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}