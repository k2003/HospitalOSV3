/*
 * DialogCause.java
 *
 * Created on 7 ���Ҥ� 2546, 12:04 �.
 */
package com.hosv3.utility;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import com.hosv3.utility.connection.*;
import com.hospital_os.object.*; 

/**
 * @not deprecated ���������� control.gui
 * @author  sumo
 */
public class DialogCauseCancelResultLab extends javax.swing.JDialog {
    
	
	public int actionCommand = 0;  
    OrderItem theOrderItem;
    Vector vOrderItemLab = new Vector();
    int[] row;
    JFrame aMain;
    
    public static boolean closeDialog = false;
    /** Creates new form DialogCause */
    public DialogCauseCancelResultLab(UpdateStatus us, int[] select,Vector vOrderItem)
    {
        super(us.getJFrame(), true);
    	String henbe_deprecate;
        aMain = us.getJFrame();
        vOrderItemLab = vOrderItem;
        row = select;
        initComponents();
        setLanguage("");  
        setDialog(); 
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
        jPanel3 = new javax.swing.JPanel();
        jLabelCause = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldCause = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelCancelLab = new javax.swing.JLabel();
        jLabelLab = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(300, 230));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 230));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(300, 150));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 150));
        jLabelCause.setText("\u0e2a\u0e32\u0e40\u0e2b\u0e15\u0e38\u0e01\u0e32\u0e23\u0e22\u0e01\u0e40\u0e25\u0e34\u0e01\u0e23\u0e32\u0e22\u0e01\u0e32\u0e23\u0e41\u0e25\u0e1b");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel3.add(jLabelCause, gridBagConstraints);

        jTextFieldCause.setLineWrap(true);
        jScrollPane1.setViewportView(jTextFieldCause);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonSave.setText("OK");
        jButtonSave.setMaximumSize(new java.awt.Dimension(72, 26));
        jButtonSave.setMinimumSize(new java.awt.Dimension(72, 26));
        jButtonSave.setPreferredSize(new java.awt.Dimension(72, 26));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jButtonSave, gridBagConstraints);

        jButtonCancel.setText("Cancel");
        jButtonCancel.setMaximumSize(new java.awt.Dimension(72, 26));
        jButtonCancel.setMinimumSize(new java.awt.Dimension(72, 26));
        jButtonCancel.setPreferredSize(new java.awt.Dimension(72, 26));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 5);
        jPanel2.add(jButtonCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabelCancelLab.setText("\u0e23\u0e32\u0e22\u0e01\u0e32\u0e23\u0e41\u0e25\u0e1b\u0e17\u0e35\u0e48\u0e08\u0e30\u0e22\u0e01\u0e40\u0e25\u0e34\u0e01 : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel4.add(jLabelCancelLab, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel4.add(jLabelLab, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel4, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        actionCommand = 2;
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        actionCommand = 1;
        if(vOrderItemLab != null)
        {
            if(jTextFieldCause.getText().trim().length() <=0)
            {
                JOptionPane.showMessageDialog(this,"��سҡ�͡���˵ء��¡��ԡ��¡���Ż","��͹",JOptionPane.OK_OPTION);
                return;
            }
            for(int i=row.length-1;i>=0;i--) 
            { 
                OrderItem oi = (OrderItem)vOrderItemLab.get(row[i]);
                if(oi.isLab() 
                && !oi.status.equals(OrderStatus.NOT_VERTIFY))
                {
                    oi.cause_cancel_resultlab = jTextFieldCause.getText();
                }
            }
            dispose();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);   
        actionCommand = 2;
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
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelCancelLab;
    private javax.swing.JLabel jLabelCause;
    private javax.swing.JLabel jLabelLab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextFieldCause;
    // End of variables declaration//GEN-END:variables

    private void setDialog()
    {
        this.setSize(350,250);
        this.setTitle(Constant.getTextBundle("���˵ء��¡��ԡ��¡���Ż"));
        Toolkit thekit = this.getToolkit();       
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width-this.getSize().width)/2, (screenSize.height-this.getSize().height)/2);
        String Labname ="";
        for(int i=row.length-1;i>=0;i--) 
        { 
            OrderItem oi = (OrderItem)vOrderItemLab.get(row[i]);
            if(oi.isLab()
            && !oi.status.equals(OrderStatus.NOT_VERTIFY))
            {
                if(Labname.equals(""))
                {
                    Labname = oi.common_name;
                }
                else
                {
                    Labname = Labname + "," + oi.common_name;
                }
            }
        }
        jLabelLab.setText(Labname);
    }
    
    public int showDialog()
    {
        this.setVisible(true);
        jTextFieldCause.setText("");
        return actionCommand;
    }
    
    public static int showDialog(UpdateStatus us, int[] select,Vector vOrderItem)
    {
        DialogCauseCancelResultLab dlg = new DialogCauseCancelResultLab(us,select,vOrderItem);
        return dlg.showDialog();
    } 
          
      public void setLanguage(String msg)
      {      
         GuiLang.setLanguage(jButtonCancel);
         GuiLang.setLanguage(jButtonSave);   
         GuiLang.setLanguage(jLabelCause);
      } 
}
