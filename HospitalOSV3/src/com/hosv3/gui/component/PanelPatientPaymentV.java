/*
 * PanelPatientPaymentV.java
 *
 * Created on 25 ���Ҥ� 2548, 16:49 �.
 */

package com.hosv3.gui.component;

import java.util.*;

import com.hospital_os.utility.TaBleModel;
import com.hospital_os.object.*;
import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hosv3.utility.GuiLang;

/**
 *
 * @author  henbe
 */
public class PanelPatientPaymentV extends javax.swing.JPanel {

    static String[] column_jTablePatientPayment = {"�Ţ���ѵ�","�Է��"};    

    UpdateStatus theUS;
    PatientControl thePatientControl;
    LookupControl theLookupControl;
    Vector vPatientPayment;
    /** Creates new form PanelPatientPaymentV */
    public PanelPatientPaymentV() {
        initComponents();
    }
    public void setControl(HosControl hc, UpdateStatus us) {
        thePatientControl = hc.thePatientControl;
        theUS = us;
        theLookupControl = hc.theLookupControl;
    }
    public void setLanguage()
    {
        GuiLang.setLanguage(this.jButtonDeletePp);
        GuiLang.setLanguage(this.jButtonDown1);
        GuiLang.setLanguage(this.jButtonUp2);
    }    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePatientPayment = new com.hosv3.gui.component.HJTableSort();
        jPanel15 = new javax.swing.JPanel();
        jButtonDeletePp = new javax.swing.JButton();
        jButtonDown1 = new javax.swing.JButton();
        jButtonUp2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(new javax.swing.border.TitledBorder("\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e1b\u0e23\u0e30\u0e08\u0e33\u0e15\u0e31\u0e27\u0e1c\u0e39\u0e49\u0e1b\u0e48\u0e27\u0e22"));
        jPanel3.setMinimumSize(new java.awt.Dimension(120, 160));
        jPanel3.setPreferredSize(new java.awt.Dimension(120, 160));
        jTablePatientPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTablePatientPaymentMouseReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jTablePatientPayment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jPanel15.setLayout(new java.awt.GridBagLayout());

        jButtonDeletePp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/minus16.gif")));
        jButtonDeletePp.setToolTipText("\u0e25\u0e1a\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e4c\u0e1b\u0e23\u0e30\u0e08\u0e33\u0e15\u0e31\u0e27");
        jButtonDeletePp.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonDeletePp.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonDeletePp.setMinimumSize(new java.awt.Dimension(26, 26));
        jButtonDeletePp.setPreferredSize(new java.awt.Dimension(26, 26));
        jButtonDeletePp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletePpActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jPanel15.add(jButtonDeletePp, gridBagConstraints);

        jButtonDown1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hospital_os/images/down.gif")));
        jButtonDown1.setToolTipText("\u0e40\u0e25\u0e37\u0e48\u0e2d\u0e19\u0e25\u0e07");
        jButtonDown1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonDown1.setMaximumSize(new java.awt.Dimension(26, 26));
        jButtonDown1.setMinimumSize(new java.awt.Dimension(26, 26));
        jButtonDown1.setPreferredSize(new java.awt.Dimension(26, 26));
        jButtonDown1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDown1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel15.add(jButtonDown1, gridBagConstraints);

        jButtonUp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hospital_os/images/up.gif")));
        jButtonUp2.setToolTipText("\u0e40\u0e25\u0e37\u0e48\u0e2d\u0e19\u0e02\u0e36\u0e49\u0e19");
        jButtonUp2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonUp2.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonUp2.setMinimumSize(new java.awt.Dimension(26, 26));
        jButtonUp2.setPreferredSize(new java.awt.Dimension(26, 26));
        jButtonUp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUp2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel15.add(jButtonUp2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 2, 0);
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jPanel15, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    private void jTablePatientPaymentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePatientPaymentMouseReleased

    }//GEN-LAST:event_jTablePatientPaymentMouseReleased

    private void jButtonDeletePpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletePpActionPerformed
        int[] select = jTablePatientPayment.getSelectedRows();
        thePatientControl.deletePatientPayment(vPatientPayment,select);
    }//GEN-LAST:event_jButtonDeletePpActionPerformed

    private void jButtonDown1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDown1ActionPerformed
        int row = jTablePatientPayment.getSelectedRow();
        int size = jTablePatientPayment.getRowCount();
        thePatientControl.downPriorityPatientPayment(vPatientPayment,row);
        if(row +1 >= size){
            jTablePatientPayment.setRowSelectionInterval(size -1 ,size -1);
            return;
        }
        jTablePatientPayment.setRowSelectionInterval(row+1,row+1);
    }//GEN-LAST:event_jButtonDown1ActionPerformed

    private void jButtonUp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUp2ActionPerformed
        int row = jTablePatientPayment.getSelectedRow();
        int size = jTablePatientPayment.getRowCount();
        thePatientControl.upPriorityPatientPayment(vPatientPayment,row);
         if(row-1 <= 0){
            jTablePatientPayment.setRowSelectionInterval(0,0);
            return ;
        }
        jTablePatientPayment.setRowSelectionInterval(row-1,row-1);
    }//GEN-LAST:event_jButtonUp2ActionPerformed
    
    private void updateOGPatientPaymentV(Vector pp)
    {
        this.vPatientPayment = pp;
        TaBleModel tm;
       if((vPatientPayment == null))
        {
            vPatientPayment = new Vector();
            tm = new TaBleModel(column_jTablePatientPayment,0);
            jTablePatientPayment.setModel(tm);
            return;
        }
       tm = new TaBleModel(column_jTablePatientPayment,vPatientPayment.size());
       for(int i=0,size = vPatientPayment.size() ; i<size; i++)
       {
           Payment pd = (Payment)vPatientPayment.get(i);
           String p = theLookupControl.readPlanString(pd.plan_kid);
           tm.setValueAt(pd.card_id,i,0);
           tm.setValueAt(p,i,1);
       }
       jTablePatientPayment.setModel(tm);  
       jTablePatientPayment.getColumnModel().getColumn(0).setPreferredWidth(100);
       jTablePatientPayment.getColumnModel().getColumn(1).setPreferredWidth(300);
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletePp;
    private javax.swing.JButton jButtonDown1;
    private javax.swing.JButton jButtonUp2;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hosv3.gui.component.HJTableSort jTablePatientPayment;
    // End of variables declaration//GEN-END:variables
    
}
