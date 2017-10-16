/*
 * DialogShowLabResult.java
 *
 * Created on 13 ��Ȩԡ�¹ 2547, 11:09 �.
 */
package com.hosv3.gui.dialog;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import com.hospital_os.object.*; 
import com.hospital_os.utility.TaBleModel;
import com.hospital_os.utility.ComboboxModel;
import com.hospital_os.utility.ComboFix;
import com.hosv3.utility.Constant;
import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hosv3.object.*;
import com.hosv3.gui.component.TextFieldResultLab;
import com.hosv3.gui.component.CellRendererComboBox;
import com.hosv3.gui.component.ComBoBoxEditor;
import com.hosv3.utility.*;

//import com.hosv3.gui.panel.transaction.HosDialog;
/**
 *
 * @author  tong
  *��������¹�� jFrame ���͡��͹����������� �˵ط���� dialog ������ҵ�ͧ������ modal 
 *����ͧ�������ա���Դ�����¤���������ա�����¡�� ����˹�ҵ�ҧ�ѹ�з����Թ memory �ҡ���ǵ�ͧ�Ҥ��
 *�Դ�������Ŵ mem*
 */
public class DialogShowLabResult extends javax.swing.JDialog implements UpdateStatus{
    
    HosObject theHO;
    HosControl theHC;
    UpdateStatus theUS;
//    Vector theResultLabReportV = new Vector(); //
//    Vector theResultLabReportVed = new Vector();
//    Vector vLabResultItem = new Vector();
//    Vector vLabResultItemed = new Vector();
    /** Creates new form DialogShowLabResult */
    /**Control*/
    private OrderControl theOrderControl = null;
    private SystemControl theSystemControl = null;
    private ResultControl theResultControl = null;
    /**Variable*/
    private Vector vOrderLabNoReported = null;
    private Vector vOrderLabReported = null;
    
    //private Vector vLabResult = null;
    private Vector vOrderLab = null;
    private String[] col = {"��¡��","�ѹ������","����","��","˹���","��һ���"};
    
    public DialogShowLabResult(JFrame parent, HosControl hosControl) 
    {
        super(parent,true);
        initComponents();
        setLanguage("");
        setDialog();
        //setIconImage(parent.getIconImage());
        theHC = hosControl;
        theHO = hosControl.theHO;
        theUS = hosControl.theUS;
        theOrderControl = hosControl.theOrderControl;
        theSystemControl = hosControl.theSystemControl;
        theResultControl = hosControl.theResultControl;
        this.jTableNoReport.setControl(theHC);
        this.jTableReported.setControl(theHC);
        //setIconImage(theUS.getJFrame().getIconImage());
        jButtonSend.setVisible(false);  
        jButtonAdd.setVisible(false);  
    }
    ///////////////////////////////////////////////////////////////////////////
//    public void setHosDialog(HosDialog theHD){
//        this.theHD = theHD;
//    }
    public void setLanguage(String msg)
    {        
        GuiLang.setLanguage(jButtonSend);
        GuiLang.setLanguage(jButtonPrinting);
        GuiLang.setLanguage(jButtonSave);
        GuiLang.setLanguage(col);
        GuiLang.setLanguage(jTabbedPane1);
    }      
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonPrinting = new javax.swing.JButton();
        jTableReported = new com.hosv3.gui.component.PanelResultLab();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonSend = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jTableNoReport = new com.hosv3.gui.component.PanelResultLab();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jPanel5.setMinimumSize(new java.awt.Dimension(95, 26));
        jPanel5.setPreferredSize(new java.awt.Dimension(95, 26));
        jButtonPrinting.setText("\u0e1e\u0e34\u0e21\u0e1e\u0e4c\u0e1c\u0e25\u0e41\u0e25\u0e1a");
        jButtonPrinting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintingActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(jButtonPrinting, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel2.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jTableReported, gridBagConstraints);

        jTabbedPane1.addTab("\u0e23\u0e32\u0e22\u0e07\u0e32\u0e19\u0e1c\u0e25\u0e41\u0e25\u0e49\u0e27", jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel8.setLayout(new java.awt.GridBagLayout());

        jButtonSave.setText("\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel8.add(jButtonSave, gridBagConstraints);

        jButtonSend.setText("Send");
        jButtonSend.setPreferredSize(new java.awt.Dimension(69, 25));
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel8.add(jButtonSend, gridBagConstraints);

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/plus16.gif")));
        jButtonAdd.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAdd.setMaximumSize(new java.awt.Dimension(26, 26));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(26, 26));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(26, 26));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(jButtonAdd, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel3.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jTableNoReport, gridBagConstraints);

        jTabbedPane1.addTab("\u0e23\u0e2d\u0e1f\u0e31\u0e07\u0e1c\u0e25\u0e41\u0e25\u0e1a", jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-393)/2, (screenSize.height-385)/2, 393, 385);
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        jTableNoReport.setEnabled(true);
        jButtonSave.setEnabled(true);        
    }//GEN-LAST:event_jButtonAddActionPerformed
    private void jButtonPrintingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintingActionPerformed

        if(theHO.theVisit == null || theHO.theVisit.getObjectId()==null)
        {      
            theUS.setStatus("�ѧ������͡������",UpdateStatus.WARNING);
            return;
        }
        DialogSelectLabPrint.showDialog(this,theHC,this,vOrderLab,theHO.theVisit,theHO.thePatient,jTableReported.getResultLabV());   
    }//GEN-LAST:event_jButtonPrintingActionPerformed
    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
         theResultControl.saveResultLab(vOrderLabNoReported,jTableNoReport.getResultLabV(),this);
    }//GEN-LAST:event_jButtonSendActionPerformed
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        int verify = JOptionPane.showConfirmDialog(this,"<HTML>"+Constant.getTextBundle("��¡�÷��ѹ�֡��� ����ʴ��˹����§ҹ������ �ҡ��ͧ�����䢵�ͧ�����˹�ҷ����ͧ��Ժѵԡ��")+"<br>"+Constant.getTextBundle("��ͧ��èкѹ�֡�������")+"</HTML>",Constant.getTextBundle("��͹"),JOptionPane.OK_CANCEL_OPTION);
        if(verify == JOptionPane.OK_OPTION)
        {
            Vector theResultLabReportV = this.jTableNoReport.getResultLabV();
            boolean res = theResultControl.saveResultLab(vOrderLabNoReported
                    ,theResultLabReportV,this);
            if(res)
                spitReported(theOrderControl.listOrderLabInProcess(theHO.theVisit.getObjectId()));
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed
        /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        dispose();
    }//GEN-LAST:event_exitForm
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      //  new DialogShowLabResult().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonPrinting;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.hosv3.gui.component.PanelResultLab jTableNoReport;
    private com.hosv3.gui.component.PanelResultLab jTableReported;
    // End of variables declaration//GEN-END:variables
    

    //henbe
    public void showDialog(){
        Constant.println("public void showDialog(){");
        Vector vO = theOrderControl.listOrderLabInProcess(theHO.theVisit.getObjectId());
        spitReported(vO);
        setVisible(true);
    }
    public void showDialog(OrderItem oi){
        Constant.println("public void showDialog(OrderItem){");
        Vector v0 = theOrderControl.listOrderLabInProcess(oi.visit_id);  
        spitReported(v0);
        setVisible(true);
    }  
    public void showDialog(String visit_id)
    {
        Constant.println("public void showDialog(String){");
        vOrderLab = theOrderControl.listOrderLabInProcess(visit_id);  
        spitReported(vOrderLab);
        setVisible(true);
    }  
    //�¡�����ҧ �Ż���ӡ����§ҹ�šѺ�Ż����ѧ�������§ҹ��
    private void spitReported(Vector vc)
    {
            vOrderLab = vc;
            vOrderLabReported = new Vector();
            vOrderLabNoReported = new Vector();
        
            for(int i=0 ;i<vc.size(); i++)
            {
                OrderItem orderitem = (OrderItem) vc.get(i);
                if(orderitem != null)
                {   //reported
                    if(orderitem.status.equals(OrderStatus.REPORT))
                        vOrderLabReported.add(orderitem);
                    else
                        vOrderLabNoReported.add(orderitem);
                }
            }
            this.jTableNoReport.setResultLabV(vOrderLabNoReported);
            this.jTableReported.setResultLabV(vOrderLabReported);

            if(vOrderLabNoReported.size() == 0)
            {
                setButtonNoReport(false);
                if(jTabbedPane1.isAncestorOf(jPanel2))
                    jTabbedPane1.setSelectedComponent(jPanel2);
            }
            else
            {
                setButtonNoReport(true);
                if(jTabbedPane1.isAncestorOf(jPanel3))
                    jTabbedPane1.setSelectedComponent(jPanel3);
            }
    }    
    ////////////////////////////////////////////////////////////////////////////
    private void setButtonNoReport(boolean b)
    {
//        if(jTableNoReport.getRowCount() == 0)
        { 
            jButtonSave.setEnabled(false);
            jButtonSend.setEnabled(false);
            jButtonAdd.setEnabled(false);
        }
//        else
        {
            jButtonSave.setEnabled(true);
        }          
    }
    
    
    /**
     *��˹�����Ŵ� Dialog
     */
    private void setDialog()
    {
        setSize(640,480);  
        setTitle(Constant.getTextBundle("��§ҹ�� Lab"));
        Toolkit thekit = getToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-getSize().width)/2, (screenSize.height-getSize().height)/2);
             
    }
    ///////////////////////////////////////////////////////////////////////////
    /**
     * @deprecated 
     *�ʴ�������ŧ���ҧ jTableReported
     */
    private void setTableReported(Vector vc,Vector vLri,JTable jtable)
    {
        TaBleModel tm ;
        if(vc == null || vc.isEmpty()
        || vLri == null || vLri.isEmpty())
        {   
            tm= new TaBleModel(col,0);
            jtable.setModel(tm);
            return;
        }       
        tm= new TaBleModel(col,vc.size());
        tm.setEditingCol(3);
        String key = new String();
        Vector vd=null;
        String old_labresult_id="";
        for(int i=0 ;i<vc.size(); i++)
        {
            ResultLab rl = (ResultLab)vc.get(i);
            OrderItem oi = HosObject.getOrderItemFromV(this.vOrderLab, rl.order_item_id);
            if(oi==null)
            {
                oi = theOrderControl.readOrderItemById(rl.order_item_id);
            }
            LabResultItem lri = (LabResultItem)vLri.get(i);
            
            if(!key.equals(oi.getObjectId()) )
            {  
                key = oi.getObjectId();
                tm.setValueAt(oi.common_name,i,0);
                tm.setValueAt(DateUtil.convertFieldDate(oi.order_time),i,1);
            }
            tm.setValueAt(rl.name,i,2);
                
            //amp:22/02/2549 ���͵�Ǩ�ͺ��Ҷ�����Ż���Դ ��� decode ����
            //henbe modify ������ͧ���鴫�ӫ�͹�������Դ���ա�͹���Ǿ������������ code ���ǡѹ
            // ����ҡ����ش��������ͧ���������¨ش��������
            //�����§ҹ�����Ǩ���������
            boolean enable = !oi.status.equals(OrderStatus.REPORT);
            boolean secret = "1".equals(oi.secret);
            boolean can_see = (theHO.theEmployee.authentication_id.equals(Authentication.DOCTOR)
                            || theHO.theEmployee.getObjectId().equals(oi.vertifier));
            //amp:22/02/2549 �Ż���ԡ �����ᾷ�������繤�����Ż ������ö�ͧ��繢�ͤ�����
            //�͡�ҡ��蹨������ ********                    
            if(secret && !can_see)
            {
                jtable.setRowHeight(i,24);
                tm.setValueAt(" ********",i,3);                 
            }
            else
            {
                String result = rl.result;
                //������Ż���Դ������� control ��ͧ����жʹ�����͡������� gui
                if(lri.resultType != null && lri.resultType.equals("0"))
                {
                    jtable.setRowHeight(i,24);
                    TextFieldResultLab jt = new TextFieldResultLab(0,theUS);
                    jt.setEditable(enable);        
                    jt.setMax(lri.max);
                    jt.setMin(lri.min);
                    jt.setText(result);
                    tm.setValueAt(jt,i,3);
                }
                else if(lri.resultType != null && lri.resultType.equals("1"))
                {
                    jtable.setRowHeight(i,24);
                    TextFieldResultLab jt = new TextFieldResultLab(1,theUS);
                    jt.setEditable(enable);        
                    jt.setMax(lri.max);
                    jt.setMin(lri.min);
                    jt.setText(result);
                    tm.setValueAt(jt,i,3);
                }
                else if(lri.resultType == null || lri.resultType.equals("")||lri.resultType.equals("2"))
                {
                    jtable.setRowHeight(i,24);
                    JTextField jt = new JTextField();
                    jt.setEditable(enable);        
                    jt.setText(result);
                    tm.setValueAt(jt,i,3);
                }
                else if(lri.resultType != null && lri.resultType.equals("3"))
                {
                     jtable.setRowHeight(i,50);
                     JTextArea jt = new JTextArea();
                     jt.setEditable(enable);        
                     jt.setWrapStyleWord(true);
                     jt.setLineWrap(true);
                     jt.setText(result);
                     tm.setValueAt(jt,i,3);
                }
                else if(lri.resultType != null && lri.resultType.equals("4"))
                {
                    JComboBox cb = new JComboBox();
                    cb.setEnabled(enable);
                    cb.setEditable(!enable);
                    if(!lri.labresult_id.equals(old_labresult_id))
                        vd = theHC.theSetupControl.listLabCResultDetailByResultType(lri.labresult_id);
                    old_labresult_id = lri.labresult_id;
                    ComboboxModel.initComboBox(cb, vd);
                    if(!result.equals("")){
                        for(int j=0;j<vd.size();j++){
                            ComboFix cf = (ComboFix) vd.get(j);
                            if(cf.getName().trim().equals(result.trim())){
                                ComboboxModel.setCodeComboBox(cb, cf.getCode());
                            }
                        }
                    }
                    tm.setValueAt(cb,i,3);
                }
            }
            tm.setValueAt(rl.unit,i,4);
            String default_value = lri.min;
            if(!lri.max.equals(""))
            {
                default_value = default_value + "-" +lri.max;
            }
            tm.setValueAt(default_value,i,5);
        }
        jtable.setRowHeight(24);
        jtable.setModel(tm);
        jtable.getColumnModel().getColumn(3).setCellRenderer(new CellRendererComboBox());
        jtable.getColumnModel().getColumn(3).setCellEditor(new ComBoBoxEditor(new JComboBox()));        
    }
    
   
    ///////////////////////////////////////////////////////////////////////////////
    /* ��÷ӧҹ ���Ѻ ������Ẻ vector �ͧ ResultLab ����ա���红����������ҧ���� �� OrderItem_id
     * ��鹵͹��÷� ��� 1 �� ��� ��¡�� resultlab ��� �� orderitem_id ������
     *               2 update orderitem ��� �� update ������ executed_time, executer ,status= 4
     *               3 �ӡ�� update ��Ңͧ ResultLab � vector ���բ����� reported_time , result
     */
    public boolean confirmBox(String str, int status) {
        int i = JOptionPane.showConfirmDialog(this,str,"��͹"
                ,JOptionPane.YES_NO_OPTION);
        return (i==JOptionPane.YES_OPTION);
    }
    
    public JFrame getJFrame() {
        return null;
    }
    
    public void setStatus(String str, int status) {
        str = Constant.getTextBundle(str);
        JOptionPane.showMessageDialog(this, str, Constant.getTextBundle("��͹"), JOptionPane.ERROR_MESSAGE);
    }
    
}