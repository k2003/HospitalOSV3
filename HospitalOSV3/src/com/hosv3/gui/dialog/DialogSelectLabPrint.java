/*
 * DialogSelectLabPrint.java
 *
 * Created on 15 �Զع�¹ 2547, 10:58 �.
 */
package com.hosv3.gui.dialog;
import com.hospital_os.utility.CellRendererHos;
import com.hosv3.utility.Constant;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hosv3.utility.*;
import com.hosv3.object.*;

import com.hospital_os.utility.TaBleModel;
import com.hospital_os.utility.CelRendererLabReferOut;
import com.hospital_os.utility.CelRenderer;
import com.hospital_os.utility.CelRendererContinue; 
import com.hospital_os.object.*;
/**
 *
 * @author  ojika
 *  �� Dialog �ͧ������͡��¡�� Lab
 */
public class DialogSelectLabPrint extends javax.swing.JDialog {

    HosControl theHC;
    HosObject theHO;
    UpdateStatus theUS;
    JFrame aMain; 
    public boolean actionCommand = false;
    
    /*Vector*/
    private Vector vFromPanelLab = new Vector();/*�� Object �ͧ orderitem*/
    
    /*Control***/
    private PatientControl thePatientControl;
    private SystemControl theSystemControl;
    private VisitControl theVisitControl;
    private OrderControl theOrderControl;
    private SetupControl theSetupControl;
    private ResultControl theResultControl;
    
    /*Object*/
    private Patient thePatient;    
    private Visit theVisit;
    private String[] col_jTableOrderLabPrint = {"�ӴѺ","����","ʶҹ�","�ѹ���","Refer"};
    CelRendererLabReferOut celRendererLabReferOut = new CelRendererLabReferOut();
    CelRenderer cellRenderer = new CelRenderer();
    CelRendererContinue cellRendererContinue = new CelRendererContinue();
    CellRendererHos dateRender = new CellRendererHos(CellRendererHos.DATE_TIME);
    Vector vResultLabReport;
       
    
    public DialogSelectLabPrint(JFrame jf,HosControl hc, UpdateStatus us) {
        super(jf, true);
        //this.aMain = theUS.getJFrame();
        initComponents();
        setLanguage("");
        theUS = us;
        theHC = hc;
        theHO = hc.theHO;
        theSetupControl = theHC.theSetupControl;
        theOrderControl = theHC.theOrderControl;
        theResultControl = theHC.theResultControl;
        theSystemControl = theHC.theSystemControl;
        theVisitControl = theHC.theVisitControl;
        thePatientControl= theHC.thePatientControl;
        theVisit = theHO.theVisit;
        thePatient = theHO.thePatient;       
        //this.setIconImage(theUS.getJFrame().getIconImage());
        //setTableOrderLabPrint(vFromPanelLab);
    }
    public DialogSelectLabPrint(JDialog jf,HosControl hc, UpdateStatus us) {
        super(jf, true);
        //this.aMain = theUS.getJFrame();
        initComponents();
        setLanguage("");
        theUS = us;
        theHC = hc;
        theHO = hc.theHO;
        theSetupControl = theHC.theSetupControl;
        theOrderControl = theHC.theOrderControl;
        theResultControl = theHC.theResultControl;
        theSystemControl = theHC.theSystemControl;
        theVisitControl = theHC.theVisitControl;
        thePatientControl= theHC.thePatientControl;
        theVisit = theHO.theVisit;
        thePatient = theHO.thePatient;  
        //this.setIconImage(theUS.getJFrame().getIconImage());
        //setTableOrderLabPrint(vFromPanelLab);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrderLabPrint = new com.hosv3.gui.component.HJTableSort();
        jPanel4 = new javax.swing.JPanel();
        jButtonPrintLab = new javax.swing.JButton();
        jCheckBoxSelectAll = new javax.swing.JCheckBox();
        jCheckBoxPreview = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("��¡�� Lab ����Ѻ�����"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(new java.awt.Dimension(200, 300));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 300));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 300));

        jTableOrderLabPrint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableOrderLabPrint);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButtonPrintLab.setText("PrintResultLab");
        jButtonPrintLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintLabActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 4, 5, 5);
        jPanel4.add(jButtonPrintLab, gridBagConstraints);

        jCheckBoxSelectAll.setSelected(true);
        jCheckBoxSelectAll.setText("����������");
        jCheckBoxSelectAll.setToolTipText("�������¡���Ż��������������§ҹ�š���");
        jCheckBoxSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSelectAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 5, 1, 0);
        jPanel4.add(jCheckBoxSelectAll, gridBagConstraints);

        jCheckBoxPreview.setText("�Ҿ��͹�����");
        jCheckBoxPreview.setToolTipText("�������¡���Ż��������������§ҹ�š���");
        jCheckBoxPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPreviewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 5, 1, 0);
        jPanel4.add(jCheckBoxPreview, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSelectAllActionPerformed
        if(jCheckBoxSelectAll.isSelected()){
            int all = jTableOrderLabPrint.getRowCount();
            this.jTableOrderLabPrint.setRowSelectionInterval(0, all-1);
        } else{
            this.jTableOrderLabPrint.clearSelection();
        }
    }//GEN-LAST:event_jCheckBoxSelectAllActionPerformed
    private void jButtonPrintLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintLabActionPerformed
        int[] rows = jTableOrderLabPrint.getSelectedRows();
        boolean ret = theHC.thePrintControl.printResultLab(vFromPanelLab
                ,vResultLabReport,rows,jCheckBoxSelectAll.isSelected()
                ,jCheckBoxPreview.isSelected());
        if(ret == false)
        {
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonPrintLabActionPerformed

    private void jCheckBoxPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPreviewActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCheckBoxPreviewActionPerformed
     /**
     * �� function 㹡�èѴ��� Program 
     * input : Vector �ͧ��¡�� order 
     * output : �ʴ���¡�� Order 
     **/
    private void setTableOrderLabPrint(Vector vc)
    {
            TaBleModel tm= new TaBleModel(col_jTableOrderLabPrint,0);
            if(vc == null)
            {   
                jTableOrderLabPrint.setModel(tm);
                return;
            }
            tm= new TaBleModel(col_jTableOrderLabPrint,vc.size());
            for(int i=0 ;i<vc.size(); i++)
            {  
                OrderItem p = (OrderItem)vc.get(i);                        
                //Item it = theHC.theLookupControl.readItemById(p.item_code);                        
                tm.setValueAt(String.valueOf(i+1),i,0);
                tm.setValueAt(p.common_name,i,1);  
                if(p.status.equals(OrderStatus.REPORT))
                    tm.setValueAt(Constant.getTextBundle("��§ҹ��"),i,2);
                else if(p.status.equals(OrderStatus.EXECUTE))
                    tm.setValueAt(Constant.getTextBundle("���Թ���"),i,2);
                else
                    tm.setValueAt(Constant.getTextBundle("�׹�ѹ"),i,2);
                
                tm.setValueAt(DateUtil.getDateFromText(p.vertify_time),i,3);    
                tm.setValueAt(p.refer_out,i,4);    
            }
            this.jTableOrderLabPrint.setModel(tm);
            jTableOrderLabPrint.getColumnModel().getColumn(0).setPreferredWidth(50); // ���ʢͧ Order Lab      
            jTableOrderLabPrint.getColumnModel().getColumn(0).setCellRenderer(TableRenderer.getRendererRight());     
            jTableOrderLabPrint.getColumnModel().getColumn(1).setPreferredWidth(500); // ���ͧ͢��¡�� Order
            jTableOrderLabPrint.getColumnModel().getColumn(2).setPreferredWidth(100); // ʶҹТͧ Order
            jTableOrderLabPrint.getColumnModel().getColumn(3).setPreferredWidth(300); // Refer Out
            jTableOrderLabPrint.getColumnModel().getColumn(3).setCellRenderer(dateRender);
            jTableOrderLabPrint.getColumnModel().getColumn(4).setPreferredWidth(80); // Refer Out
            jTableOrderLabPrint.getColumnModel().getColumn(4).setCellRenderer(celRendererLabReferOut);  
    }    
    
    
    public boolean showDialog(Vector vorderlab,Visit visit,Patient patient,Vector orderlab,Vector vResultLab)
    {  
        vFromPanelLab = orderlab ;     
        vResultLabReport = vResultLab;
        setTableOrderLabPrint(vFromPanelLab);
        int all = jTableOrderLabPrint.getRowCount();
        this.jTableOrderLabPrint.setRowSelectionInterval(0, all-1);
        setSize(400,400);
        setTitle(Constant.getTextBundle("��¡�� Lab ����ͧ��þ����"));  
//        setLanguage("");  
        Toolkit thekit = getToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-getSize().width)/2, (screenSize.height-getSize().height)/2);        
        setVisible(true);
        jCheckBoxSelectAll.setSelected(true);
        if(actionCommand){      
              return true;
        }       
        System.gc();
        return false;
    } 
    ///////////////////////////////////////////////////////////////////////////
    
    public static boolean showDialog(JFrame jf,HosControl hc, UpdateStatus us,Vector orderlab,Visit visit,Patient patient,Vector vResultLab)
    {   
        DialogSelectLabPrint dl = new DialogSelectLabPrint(jf,hc,us);
        return dl.showDialog(orderlab,visit,patient,orderlab,vResultLab);
    } 
    public static boolean showDialog(JDialog jd,HosControl hc, UpdateStatus us,Vector orderlab,Visit visit,Patient patient,Vector vResultLab)
    {   
        DialogSelectLabPrint dl = new DialogSelectLabPrint(jd,hc,us);
        return dl.showDialog(orderlab,visit,patient,orderlab,vResultLab);
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      //  new DialogSelectLabPrint(new javax.swing.JFrame(), true).setVisible(true);
    }
    
    public void setLanguage(String msg)
    {
        GuiLang.setLanguage(jButtonPrintLab);
        GuiLang.setLanguage(col_jTableOrderLabPrint);
        GuiLang.setLanguage(jCheckBoxSelectAll);
        GuiLang.setLanguage(jCheckBoxPreview);
        GuiLang.setTextBundle(jPanel2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrintLab;
    private javax.swing.JCheckBox jCheckBoxPreview;
    private javax.swing.JCheckBox jCheckBoxSelectAll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hosv3.gui.component.HJTableSort jTableOrderLabPrint;
    // End of variables declaration//GEN-END:variables
    
}
