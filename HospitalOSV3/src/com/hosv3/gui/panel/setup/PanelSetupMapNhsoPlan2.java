/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelSetupMapNhsoPlan.java
 *
 * Created on 7 �.�. 2554, 11:55:05
 */

package com.hosv3.gui.panel.setup;

import com.hospital_os.utility.TaBleModel;
import com.hosv3.control.HosControl;
import com.hosv3.gui.dialog.PanelSearchPlan;
import com.hosv3.object.MapNhsoPlan;
import com.hosv3.object.NhsoRight;
import com.hosv3.utility.connection.UpdateStatus;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author LionHeart
 */
public class PanelSetupMapNhsoPlan2 extends javax.swing.JPanel {

    public NhsoRight theNhsoRight;
    Vector theNhsoRightV;
    HosControl theHC;
    UpdateStatus theUS;
    private JDialog theJD;
    String[] col = {"�Է��� ʻʪ"};
    String[] col2 = {"�Է����ç��Һ��"};
    PanelSearchPlan thePanelSearchPlan;
    Vector theMapNhsoPlanV;
    public PanelSetupMapNhsoPlan2() {
        initComponents();
    }
    public NhsoRight getNhsoRight()
    {
        if(theNhsoRight==null)
            theNhsoRight = new NhsoRight();
        theNhsoRight.des = jTextFieldDes.getText();
        if(jCheckBoxActive.isSelected())
            theNhsoRight.active = "1";
        else
            theNhsoRight.active = "0";
        return theNhsoRight;
    }
    public void setNhsoRight(NhsoRight nhsoRight)
    {
        theNhsoRight = nhsoRight;
        if(theNhsoRight == null)
            theNhsoRight = new NhsoRight();
        jTextFieldDes.setText(theNhsoRight.des);
        if(theNhsoRight.active.equals("1")||theNhsoRight.active.equals(""))
            jCheckBoxActive.setSelected(true);
        else
            jCheckBoxActive.setSelected(false);
    }
    public void setNhsoRightV(Vector v)
    {
        theNhsoRightV = v;
        if(theNhsoRightV == null)
            theNhsoRightV = new Vector();
        TaBleModel tm = new TaBleModel(col,theNhsoRightV.size());
        for(int i=0;i<theNhsoRightV.size();i++)
        {
            NhsoRight nhsoRight = (NhsoRight) theNhsoRightV.get(i);
            tm.setValueAt(nhsoRight.des, i, 0);
        }
        jTable1.setModel(tm);
        jTable2.setModel(tm);
    }
    public void setMapNhsoPlanV(Vector v)
    {
        theMapNhsoPlanV = v;
        if(theMapNhsoPlanV == null)
            theMapNhsoPlanV = new Vector();
        TaBleModel tm = new TaBleModel(col2,theMapNhsoPlanV.size());
        for(int i=0;i<theMapNhsoPlanV.size();i++)
        {
            MapNhsoPlan mapNhsoPlan = (MapNhsoPlan) theMapNhsoPlanV.get(i);
            tm.setValueAt(mapNhsoPlan.contract_plans_des, i, 0);
        }
        jTable3.setModel(tm);
    }
    public void setControl(HosControl hc,UpdateStatus us)
    {
        theHC = hc;
        theUS = us;
        setNhsoRightV(theHC.theSystemControl.listNhsoRight());
    }
    public void showDialog()
    {
        if(theJD==null)
            theJD = new JDialog(theUS.getJFrame());
        theJD.add(this);
        theJD.setSize(600,500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        theJD.setLocation((screenSize.width - theJD.getSize().width) / 2, (screenSize.height - theJD.getSize().height) / 2);
        theJD.setTitle("��駤�ҡ�èѺ����Է���ͧ ʻʪ �Ѻ�Է���ͧ�ç��Һ��");
        theJD.setModal(true);
        theJD.setVisible(true);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDes = new javax.swing.JTextField();
        jCheckBoxActive = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel3.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(20, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 396;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("�����Է��� ʻʪ"));
        jPanel4.setMinimumSize(new java.awt.Dimension(20, 23));
        jPanel4.setPreferredSize(new java.awt.Dimension(20, 569));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("�����Է���");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        jTextFieldDes.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextFieldDes.setPreferredSize(new java.awt.Dimension(200, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jTextFieldDes, gridBagConstraints);

        jCheckBoxActive.setSelected(true);
        jCheckBoxActive.setText("Active");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 2, 0, 0);
        jPanel4.add(jCheckBoxActive, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jButtonAdd.setText("+");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel5.add(jButtonAdd, gridBagConstraints);

        jButtonDelete.setText("-");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel5.add(jButtonDelete, gridBagConstraints);

        jButtonSave.setText("�ѹ�֡");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jPanel5, gridBagConstraints);

        jTabbedPane1.addTab("�Է�� ʻʪ", jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(20, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(20, 20));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel2.add(jScrollPane3, gridBagConstraints);

        jButton1.setText("-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 4);
        jPanel2.add(jButton1, gridBagConstraints);

        jTabbedPane1.addTab("�Ѻ����Է�� ʻʪ �Ѻ�Է�Ԣͧ�ç��Һ��", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        setNhsoRight(null);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        getNhsoRight();
        theHC.theSystemControl.saveNhsoRight(theNhsoRight);
        setNhsoRightV(theHC.theSystemControl.listNhsoRight());
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        int select = jTable1.getSelectedRow();
        NhsoRight nhsoRight = (NhsoRight) this.theNhsoRightV.get(select);
        this.setNhsoRight(nhsoRight);
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this.theUS.getJFrame(),"�׹�ѹ���ź������","�׹�ѹ���ź������",JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.NO_OPTION)
            return;
        int select = jTable1.getSelectedRow();
        NhsoRight nhsoRight = (NhsoRight) this.theNhsoRightV.get(select);
        theHC.theSystemControl.deleteNhsoRight(nhsoRight);
        setNhsoRightV(theHC.theSystemControl.listNhsoRight());
        setNhsoRight(null);
        setMapNhsoPlanV(null);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        int select = jTable2.getSelectedRow();
        NhsoRight nhsoRight = (NhsoRight) this.theNhsoRightV.get(select);
        if(evt.getClickCount()==2)
        {
            if(thePanelSearchPlan == null)
            {
                thePanelSearchPlan = new PanelSearchPlan();
                thePanelSearchPlan.setControl(theHC, theUS);
            }

//            thePanelSearchPlan.showDialog(nhsoRight);
            setMapNhsoPlanV(theHC.theSystemControl.listMapNhsoPlanByNhsoRightID(nhsoRight.getObjectId()));
        }
        else
        {
            setMapNhsoPlanV(theHC.theSystemControl.listMapNhsoPlanByNhsoRightID(nhsoRight.getObjectId()));
        }
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this.theUS.getJFrame(),"�׹�ѹ���ź������","�׹�ѹ���ź������",JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.NO_OPTION)
            return;
        int[] select = jTable3.getSelectedRows();
        int select2 = jTable2.getSelectedRow();
        NhsoRight nhsoRight = (NhsoRight) this.theNhsoRightV.get(select2);
        for(int i=0;i<select.length;i++)
        {
            MapNhsoPlan mapNhsoPlan = (MapNhsoPlan) theMapNhsoPlanV.get(select[i]);
//            theHC.theSystemControl.deleteMapNhsoPlan(mapNhsoPlan);
            setMapNhsoPlanV(theHC.theSystemControl.listMapNhsoPlanByNhsoRightID(nhsoRight.getObjectId()));
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextFieldDes;
    // End of variables declaration//GEN-END:variables

}
