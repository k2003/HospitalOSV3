/*
 * DialogHistoryOrderContinue.java
 *
 * Created on 14 ����Ҥ� 2547, 17:26 �.
 */

package com.hosv3.gui.dialog;

import com.hosv3.utility.Constant;
import com.hosv3.control.*;
import com.hosv3.utility.*;
import com.hospital_os.object.*; 
import com.hospital_os.utility.TaBleModel;
import java.util.*;
import java.awt.*;
import com.hosv3.utility.connection.*;
import com.hospital_os.utility.CellRendererHos;
/**
 *
 * @author  amp
 */

public class DialogHistoryOrderContinue extends javax.swing.JDialog 
{    
    public boolean actionCommand = false;  
    
    private Visit theVisit;
    private Vector vHOC;
    private HosControl theHC;
    private String[] col_jTableReceiveDrug = {"������¡��","�ѹ�����觵�����ͧ","ᾷ������觵�����ͧ","�ѹ��� OFF","ᾷ���� OFF"};
    CellRendererHos dateRender = new CellRendererHos(CellRendererHos.DATE_TIME);
    
    /** Creates new form DialogHistoryPatient */  
    public DialogHistoryOrderContinue(HosControl hc,UpdateStatus us)
    {
        super(us.getJFrame(),true);
         theHC = hc;
        //setIconImage(us.getJFrame().getIconImage());
        initComponents();
        setLanguage("");
        setDialog();
          
    }
   public void setLanguage(String msg)
    {
        GuiLang.setLanguage(col_jTableReceiveDrug);
    }     
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReceiveDrug = new com.hosv3.gui.component.HJTableSort();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        jTableReceiveDrug.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableReceiveDrug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableReceiveDrugMouseReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jTableReceiveDrug);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-643)/2, (screenSize.height-431)/2, 643, 431);
    }
    // </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        
    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void jTableReceiveDrugMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReceiveDrugMouseReleased
       
    }//GEN-LAST:event_jTableReceiveDrugMouseReleased

    private void listOffice1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listOffice1KeyReleased
    }//GEN-LAST:event_listOffice1KeyReleased

    private void listOffice1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOffice1MouseReleased
        
    }//GEN-LAST:event_listOffice1MouseReleased
    private void comboBoxAmphur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAmphur1ActionPerformed
    }//GEN-LAST:event_comboBoxAmphur1ActionPerformed
    private void comboBoxChangwat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxChangwat1ActionPerformed
    }//GEN-LAST:event_comboBoxChangwat1ActionPerformed
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        dispose();
    }//GEN-LAST:event_closeDialog
     
    /**
     *�繡�� show �����š�ä׹�����������ͧ�Ҿ����������Ѻ�Ҥ׹�������
     */
    private void setTableOrderContinue()
    {
        TaBleModel tm ;
        if(this.vHOC != null)
        {
            tm= new TaBleModel(col_jTableReceiveDrug,this.vHOC.size());
            //tm.setEditingCol(2);
            for(int i=0;i<this.vHOC.size();i++)
            {
                OrderContinue oc = (OrderContinue)this.vHOC.get(i);
                Employee emp_order = this.theHC.theLookupControl.readEmployeeById(oc.doctor_set_continue);
                Employee emp_off = this.theHC.theLookupControl.readEmployeeById(oc.doctor_set_off);
                
                tm.setValueAt(oc.common_name ,i ,0);
                //tm.setValueAt(DateUtil.convertFieldDate(oc.date_continue) ,i ,1);
                tm.setValueAt(DateUtil.getDateFromText(oc.date_continue),i,1);     
               
               if(oc.doctor_set_continue.equalsIgnoreCase("null") || oc.doctor_set_continue.equals("")
                   || emp_order==null)
                   tm.setValueAt("" ,i ,2);
               else
                   tm.setValueAt( emp_order.fname + " " + emp_order.lname ,i ,2);
               
               if(oc.date_off.equalsIgnoreCase("null") || oc.date_off.equals(""))               
                    tm.setValueAt("" ,i ,3);
               else
                    //tm.setValueAt(DateUtil.convertFieldDate(oc.date_off) ,i ,3);
                    tm.setValueAt(DateUtil.getDateFromText(oc.date_off),i,3);
               
               if(oc.user_off.equalsIgnoreCase("null") || oc.user_off.equals("") || emp_off==null)
                    tm.setValueAt("" ,i ,4);
               else
                    tm.setValueAt(emp_off.fname + " " + emp_off.lname ,i ,4);
            }
        }
        else
        {
            tm= new TaBleModel(col_jTableReceiveDrug,0);
        }
        this.jTableReceiveDrug.setModel(tm); 
        this.jTableReceiveDrug.getColumnModel().getColumn(0).setPreferredWidth(120);     
        this.jTableReceiveDrug.getColumnModel().getColumn(1).setCellRenderer(dateRender);
        this.jTableReceiveDrug.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.jTableReceiveDrug.getColumnModel().getColumn(2).setPreferredWidth(130);
        this.jTableReceiveDrug.getColumnModel().getColumn(3).setCellRenderer(dateRender);
        this.jTableReceiveDrug.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.jTableReceiveDrug.getColumnModel().getColumn(4).setPreferredWidth(130);
    }    
    
   
    private void setDialog()
    {
        this.setTitle(Constant.getTextBundle("����ѵԡ����觵�Ǩ������ͧ"));
        Toolkit thekit = this.getToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width-this.getSize().width)/2, (screenSize.height-this.getSize().height)/2);
    }
/*-----------------------------------------------------------*/    
    public void showDialog(Visit visit)
    {
        this.theVisit = visit;
        this.vHOC = this.theHC.theOrderControl.listOrderContinueByVisitID(this.theVisit.getObjectId());
        if(this.vHOC==null) return;
        setTableOrderContinue();      
        this.setVisible(true);
    }  
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.hosv3.gui.component.HJTableSort jTableReceiveDrug;
    // End of variables declaration//GEN-END:variables
    
}
