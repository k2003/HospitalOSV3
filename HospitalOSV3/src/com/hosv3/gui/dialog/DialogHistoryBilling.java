/*
 * DialogHistoryBilling.java
 *
 * Created on 26 �á�Ҥ� 2547, 16:10 �.
 */
package com.hosv3.gui.dialog;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import com.hosv3.control.*;
import com.hosv3.utility.*;
import com.hosv3.utility.connection.*;
import com.hosv3.subject.*;
import com.hosv3.usecase.transaction.*;

import com.hospital_os.object.*; 
import com.hospital_os.utility.TaBleModel;
import com.hosv3.utility.Constant;
import com.hospital_os.utility.CellRendererHos;
//import com.hosv3.gui.panel.transaction.HosDialog;
/**
 *
 * @author  Administrator
 * 1.  60-10-28 ����ͧ ¡��ԡ ��˹��·ҧ����Թ
 * Modify doc 11.
 */
public class DialogHistoryBilling extends javax.swing.JFrame 
implements UpdateStatus,ManageBillingResp
{
//    HosDialog theHD;
    HosControl theHC;
    UpdateStatus theUS;
    HosSubject theHS;
    private Patient thePatient;
    private BillingControl theBillingControl;
    private VisitControl theVisitControl;
    private BillingSubject theBillingSubject;
 
    private Vector vBilling;
    private Vector vReceipt;
    
    public boolean actionCommand = false;
    private boolean isDoubleClick = false;
    double remain = 0.0;
    DefaultTableCellRenderer rendererRight = new DefaultTableCellRenderer();
    /** Creates new form DialogHistoryBilling */
    private String[] col_jTableHistoryReceipt = {Constant.getTextBundle("PaymentDate"),
                                         Constant.getTextBundle("����")};
    private String[] col_jTableHistoryBilling = {Constant.getTextBundle("VN"),
                                         Constant.getTextBundle("BillingDate"),
                                         Constant.getTextBundle("��ͧ����"),
                                         Constant.getTextBundle("��������"),
                                         Constant.getTextBundle("Remaining")};
    CellRendererHos vnRender = new CellRendererHos(CellRendererHos.VN);

    private LookupControl theLookupControl;
                                         
    Visit visitVoid=null;        //+1
    public DialogHistoryBilling(HosControl hc,UpdateStatus us)
    {
        initComponents();
        rendererRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        jTableHistoryBilling.requestFocus();

        setSize(800,600);
        setTitle(Constant.getTextBundle("Diag_BillingHist_Title"));
        setLanguage("");
        setTableHistoryReceipt(null);
        setControl(hc,us);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//+1        
        setLocation((screenSize.width - getSize().width) / 2, ((screenSize.height - getSize().height) / 2));//+1
        jButtonVoidDischarge.setEnabled(false);
    }
    public void setControl(HosControl hc,UpdateStatus us){
        theHC = hc;
        theUS = us;
        theBillingControl = hc.theBillingControl;
        theVisitControl = hc.theVisitControl;
        theLookupControl = hc.theLookupControl;
    vnRender = new CellRendererHos(CellRendererHos.VN,theLookupControl.getSequenceDataVN().pattern);
        theHS = hc.theHS;
        theHS.theBillingSubject.attachManageBilling(this);
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
        jLabel2 = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelHN = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistoryBilling = new com.hosv3.gui.component.HJTableSort();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHistoryReceipt = new com.hosv3.gui.component.HJTableSort();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        doubleTextFieldRemain = new com.hospital_os.utility.DoubleTextField();
        jButtonReceipt = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jButtonVoidDischarge = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("MS Sans Serif", 1, 14)); // NOI18N
        jLabel2.setText("NAME");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabelName.setFont(new java.awt.Font("MS Sans Serif", 0, 14)); // NOI18N
        jLabelName.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabelName, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("MS Sans Serif", 1, 14)); // NOI18N
        jLabel4.setText("HN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabelHN.setFont(new java.awt.Font("MS Sans Serif", 0, 14)); // NOI18N
        jLabelHN.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabelHN, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Diag_BillingHist_History"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jTableHistoryBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableHistoryBilling.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableHistoryBillingKeyReleased(evt);
            }
        });
        jTableHistoryBilling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableHistoryBillingMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHistoryBilling);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Diag_BillingHist_Detail"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jTableHistoryReceipt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableHistoryReceipt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableHistoryReceiptKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableHistoryReceipt);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jPanel5, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("MS Sans Serif", 0, 18)); // NOI18N
        jLabel1.setText("PatientRemain");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jLabel1, gridBagConstraints);

        doubleTextFieldRemain.setEditable(false);
        doubleTextFieldRemain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        doubleTextFieldRemain.setColumns(4);
        doubleTextFieldRemain.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        doubleTextFieldRemain.setText("0.0");
        doubleTextFieldRemain.setEnabled(false);
        doubleTextFieldRemain.setFont(new java.awt.Font("MS Sans Serif", 0, 18)); // NOI18N
        doubleTextFieldRemain.setMinimumSize(new java.awt.Dimension(58, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 0);
        jPanel4.add(doubleTextFieldRemain, gridBagConstraints);

        jButtonReceipt.setText("Paid");
        jButtonReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReceiptActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 3, 0);
        jPanel4.add(jButtonReceipt, gridBagConstraints);

        jButtonClose.setText("�Դ");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 3, 3);
        jPanel4.add(jButtonClose, gridBagConstraints);

        jButtonVoidDischarge.setText("¡��ԡ ��˹��·ҧ����Թ");
        jButtonVoidDischarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoidDischargeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        jPanel4.add(jButtonVoidDischarge, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel3.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel3, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed
    private void jButtonReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceiptActionPerformed
        int row = this.jTableHistoryBilling.getSelectedRow();
        if(row==-1) return;
        showVisitBilling(row);
        jTableHistoryBillingMouseReleased(null);
    }//GEN-LAST:event_jButtonReceiptActionPerformed
    private void jTableHistoryReceiptKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableHistoryReceiptKeyReleased

    }    private void jTableHistoryBillingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-LAST:event_jTableHistoryReceiptKeyReleased
        // TODO add your handling code here://GEN-FIRST:event_jTableHistoryBillingKeyReleased
        if(evt.getKeyCode()==evt.VK_UP ||evt.getKeyCode()==evt.VK_DOWN){
            jTableHistoryBillingMouseReleased(null);
        }
    }    private void jTableHistoryBillingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-LAST:event_jTableHistoryBillingKeyReleased
        int row = jTableHistoryBilling.getSelectedRow();//GEN-FIRST:event_jTableHistoryBillingMouseReleased
        if(row==-1) return;
        selectHistoryBilling(row); 
    }//GEN-LAST:event_jTableHistoryBillingMouseReleased
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        actionCommand = true;
        dispose();
    }//GEN-LAST:event_exitForm

    private void jButtonVoidDischargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoidDischargeActionPerformed
        // TODO add your handling code here:
        boolean rs = theUS.confirmBox(Constant.getTextBundle("�س��ͧ��� �Դ ������ ��˹��·ҧ����Թ����� ���������"),UpdateStatus.WARNING);
        if(rs){
            
            theHC.theVisitControl.readVisitPatientByVidPOP(visitVoid.getObjectId(),"0",null);            
            //theHC.theVisitControl.voidDischargeFinnalcial(visitVoid);
        }
        
    }//GEN-LAST:event_jButtonVoidDischargeActionPerformed
    
    private void selectHistoryBilling(int row)
    {
        if(row!=-1)
        {
            Billing billing = null;
            billing = (Billing)vBilling.get(row);
            vReceipt = theBillingControl.listReceiptByVisitIdBillingID(
                billing.visit_id,billing.getObjectId());
            setTableHistoryReceipt(vReceipt);
            billing=null;
        }
    }
    
    /**�ʴ������Ż���ѵԡ���Ѻ����*/
    private void setTableHistoryReceipt(Vector vc)
    {
        Billing billing = null;
        Receipt receipt = null;
        TaBleModel tm;
        if(vc != null)
        {   
            tm = new TaBleModel(col_jTableHistoryReceipt, vc.size());
            for(int i=0 ;i<vc.size(); i++)
            {  
                receipt = (Receipt)vc.get(i);
                
                String date = DateUtil.getDateToString(DateUtil.getDateFromText(receipt.receipt_date),true);
                
                tm.setValueAt(date + "  RN:" + receipt.receipt_no,i,0);
                tm.setValueAt(receipt.paid,i,1);
                visitVoid = theVisitControl.readVisitByVidRet(receipt.vn);      //+1
                jButtonVoidDischarge.setEnabled(true);      //+1
                receipt = null;
            }
        }
        else
        {   
            tm= new TaBleModel(col_jTableHistoryReceipt,0);
            jTableHistoryReceipt.setModel(tm);  
            return;
        }
        jTableHistoryReceipt.setModel(tm);  
        jTableHistoryReceipt.getColumnModel().getColumn(0).setPreferredWidth(300);
        jTableHistoryReceipt.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableHistoryReceipt.getColumnModel().getColumn(1).setCellRenderer(TableRenderer.getRendererRight());
    }
   
    private void showVisitBilling(int row){
	Billing billing = (Billing)vBilling.get(row);
        if(billing.remain.equals("0")){
            JOptionPane.showMessageDialog(this,"������ʹ�Թ��ҧ���� �������ö�Ѻ�����Թ��","��͹",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Visit visit =  theVisitControl.readVisitByVidRet(billing.visit_id);
        DialogPatientPaid.showDialog(theHC,this,billing,visit);
    }
    
    private void setPatient(Patient thePatient)
    {
        //setData
        jLabelName.setText(thePatient.patient_name + " " + thePatient.patient_last_name);
        jLabelHN.setText(theLookupControl.getRenderTextHN(thePatient.hn));
        //settable
        Vector v = theBillingControl.listBillingByPatientID(thePatient.getObjectId());
        setBillingV(v);
        //setRemain
        doubleTextFieldRemain.setText(String.valueOf(remain));
    }
    
    private void setBillingV(Vector vc)
    {
        //private String[] col = {"VN","�ѹ���Դ�Թ","��ͧ����(�ҷ)","��������(�ҷ)","����ҧ(�ҷ)"};
        vBilling = vc;
        Billing billing = null;
        TaBleModel tm;
        if(vc != null)
        {   
            tm = new TaBleModel(col_jTableHistoryBilling, vc.size());
            for(int i=0 ;i<vc.size(); i++)
            {  
                double visit_remain = 0.0;
                billing = (Billing)vc.get(i);
                Visit visit = theVisitControl.readVisitByVidRet(billing.visit_id);
                tm.setValueAt(visit.vn,i,0);
                if(billing.receipt_date.length() >0)
                    tm.setValueAt(DateUtil.getDateToString(DateUtil.getDateFromText(billing.receipt_date),true),i,1);
                else
                    tm.setValueAt(billing.financial_date,i,1);
                tm.setValueAt(billing.patient_share,i,2);                
                tm.setValueAt(billing.paid,i,3);
                tm.setValueAt(billing.remain,i,4);
                
                visit_remain = Double.parseDouble(billing.remain);
                
                billing = null;
                visit = null;
                remain = remain + visit_remain;
            }
        }
        else
        {   
            tm= new TaBleModel(col_jTableHistoryBilling,0);
            jTableHistoryBilling.setModel(tm);  
            return;
        }
        jTableHistoryBilling.setModel(tm);  
        jTableHistoryBilling.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableHistoryBilling.getColumnModel().getColumn(0).setCellRenderer(vnRender);
        jTableHistoryBilling.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableHistoryBilling.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTableHistoryBilling.getColumnModel().getColumn(2).setCellRenderer(rendererRight);
        jTableHistoryBilling.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableHistoryBilling.getColumnModel().getColumn(3).setCellRenderer(rendererRight);
        jTableHistoryBilling.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableHistoryBilling.getColumnModel().getColumn(4).setCellRenderer(rendererRight);
        if(vc.size()>0){
            jTableHistoryBilling.setRowSelectionInterval(0,0);
            this.jTableHistoryBillingMouseReleased(null);
        }
    }
    
    
    public boolean showDialog(Patient patient)//, Office off)
    {
        thePatient = patient;
        remain = 0.0;
        setPatient(thePatient);
       setVisible(true);
       return actionCommand;
    }  
    
    public boolean showDialog(Patient patient,String billing_id)//, Office off)
    {
        Dimension screenSize = getToolkit().getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-getSize().width)/2, (screenSize.height-getSize().height)/2);
        setIconImage(theUS.getJFrame().getIconImage());
        thePatient = patient;
        remain = 0.0;
        setPatient(thePatient);
        for(int i=0;i<vBilling.size();i++){
            Billing bill = (Billing)vBilling.get(i);
            if(bill.getObjectId().equals(billing_id))
            {
                this.jTableHistoryBilling.setRowSelectionInterval(i,i);
                this.jTableHistoryBillingMouseReleased(null);
            }
        }
       setVisible(true);
       return actionCommand;
    }  
   public void setLanguage(String msg)
    {
        GuiLang.setLanguage(jLabel1);
        GuiLang.setLanguage(jLabel2);
        GuiLang.setLanguage(jLabel4);
        GuiLang.setLanguage(jButtonReceipt);
        GuiLang.setLanguage(jButtonClose);
        //deus: more localization
        GuiLang.setTextBundle(jPanel3);
        GuiLang.setTextBundle(jPanel5);
    }
    
    public void notifyPatientPaidMoney(String str, int status)  {
        vBilling = theBillingControl.listBillingByPatientID(thePatient.getObjectId());
        remain = 0.0;
        setBillingV(vBilling);
        doubleTextFieldRemain.setText(String.valueOf(remain));
        setTableHistoryReceipt(null);
    }
    
    public void notifyBillingInvoice(String str, int status) {
    }    
    
    public void notifyCalculateAllBillingInvoice(String str, int status) {
    }
    
    public void notifyCancelBill(String str, int status) {
    }
    
    public void notifyCancelBillingInvoice(String str, int status) {
    }
    
    public boolean confirmBox(String str, int status) {
        int i = JOptionPane.showConfirmDialog(this,str,"��͹"
                ,JOptionPane.YES_NO_OPTION);
        return (i==JOptionPane.YES_OPTION);
    }
    
    public JFrame getJFrame() {
        return this;
    }
    
    public void setStatus(String str, int status) {
        str = Constant.getTextBundle(str);
        JOptionPane.showMessageDialog(this, str, "��͹", JOptionPane.ERROR_MESSAGE); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.utility.DoubleTextField doubleTextFieldRemain;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonReceipt;
    private javax.swing.JButton jButtonVoidDischarge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelHN;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.hosv3.gui.component.HJTableSort jTableHistoryBilling;
    private com.hosv3.gui.component.HJTableSort jTableHistoryReceipt;
    // End of variables declaration//GEN-END:variables
    
 
}
