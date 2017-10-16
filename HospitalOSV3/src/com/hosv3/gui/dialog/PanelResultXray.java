/*
 * PanelResultXrayjava
 *
 * Created on 19 ���Ҥ� 2546, 17:07 �.
 */
package com.hosv3.gui.dialog;


import java.awt.*;
import javax.swing.*;
import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hosv3.utility.*;
import com.hosv3.object.*;
import com.hospital_os.object.*;
import com.hosv3.utility.Constant;
/**
 *
 * @author  amp
 *��������¹�� jFrame ���͡��͹����������� �˵ط���� dialog ������ҵ�ͧ������ modal 
 *����ͧ�������ա���Դ�����¤���������ա�����¡�� ����˹�ҵ�ҧ�ѹ�з����Թ memory �ҡ���ǵ�ͧ�Ҥ��
 *�Դ�������Ŵ mem
 */ 
public class PanelResultXray extends javax.swing.JDialog 
{
    HosControl theHC;
    HosObject theHO;
    private UpdateStatus theUpdateStatus; 
    //javax.swing.JFrame aMain;    
    public OrderControl theOrderControl;
    public SetupControl theSetupControl;
    public PatientControl thePatientControl;    
    private ResultXRay theResultXRay = new ResultXRay();
    private OrderItem theOrderItem = new OrderItem();
    private String theEmployee;  
    private Patient thePatient = new Patient();
    public static boolean closePanel = false;
    /** Creates new form PanelResultXray */
    public PanelResultXray()
    {    
        initComponents();     
    } 
    
    public PanelResultXray(JFrame frm,HosControl hc)
    {   
        super(frm,true);
        theHC = hc;
        theHO = hc.theHO;
        theOrderControl = hc.theOrderControl;
        theSetupControl = hc.theSetupControl;
        thePatientControl = hc.thePatientControl;
        initComponents();
        setDialog();
        
        setvisible(false);
    }
    
    private void setvisible(boolean b)
    {   
        jTextAreaPosition.setEditable(false);
        jLabel2.setVisible(b);
        jTextFieldFilmNO.setVisible(b);
        jLabel3.setVisible(b);
        jTextFieldFilmSize.setVisible(b);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelDetail = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldXn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFilmNO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFilmSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPanePosition = new javax.swing.JScrollPane();
        jTextAreaPosition = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldXrayer = new javax.swing.JTextField();
        jLabelExecuter = new javax.swing.JLabel();
        jTextFieldXRayExecuter = new javax.swing.JTextField();
        jLabelOrderItemXRay = new javax.swing.JLabel();
        jPanelResult = new javax.swing.JPanel();
        jScrollPaneResult = new javax.swing.JScrollPane();
        jTextAreaResult = new javax.swing.JTextArea();
        jPanelButton = new javax.swing.JPanel();
        jButtonSaveXray = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelDetail.setLayout(new java.awt.GridBagLayout());

        jPanelDetail.setBorder(new javax.swing.border.TitledBorder("\u0e23\u0e32\u0e22\u0e25\u0e30\u0e40\u0e2d\u0e35\u0e22\u0e14\u0e01\u0e32\u0e23 XRay"));
        jPanelDetail.setMinimumSize(new java.awt.Dimension(300, 170));
        jPanelDetail.setPreferredSize(new java.awt.Dimension(300, 170));
        jLabel1.setText("Xn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanelDetail.add(jLabel1, gridBagConstraints);

        jTextFieldXn.setColumns(5);
        jTextFieldXn.setEditable(false);
        jTextFieldXn.setMinimumSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 2, 0, 0);
        jPanelDetail.add(jTextFieldXn, gridBagConstraints);

        jLabel2.setText("FilmNo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanelDetail.add(jLabel2, gridBagConstraints);

        jTextFieldFilmNO.setEditable(false);
        jTextFieldFilmNO.setMinimumSize(new java.awt.Dimension(100, 21));
        jTextFieldFilmNO.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanelDetail.add(jTextFieldFilmNO, gridBagConstraints);

        jLabel3.setText("FilmSize");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanelDetail.add(jLabel3, gridBagConstraints);

        jTextFieldFilmSize.setEditable(false);
        jTextFieldFilmSize.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldFilmSize.setMinimumSize(new java.awt.Dimension(100, 21));
        jTextFieldFilmSize.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanelDetail.add(jTextFieldFilmSize, gridBagConstraints);

        jLabel4.setText("XrayNote");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanelDetail.add(jLabel4, gridBagConstraints);

        jScrollPanePosition.setMinimumSize(new java.awt.Dimension(300, 63));
        jScrollPanePosition.setPreferredSize(new java.awt.Dimension(300, 63));
        jTextAreaPosition.setEditable(false);
        jTextAreaPosition.setLineWrap(true);
        jTextAreaPosition.setWrapStyleWord(true);
        jTextAreaPosition.setMinimumSize(new java.awt.Dimension(400, 121));
        jTextAreaPosition.setPreferredSize(new java.awt.Dimension(400, 121));
        jScrollPanePosition.setViewportView(jTextAreaPosition);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 0);
        jPanelDetail.add(jScrollPanePosition, gridBagConstraints);

        jLabel5.setText("XRayer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanelDetail.add(jLabel5, gridBagConstraints);

        jTextFieldXrayer.setEditable(false);
        jTextFieldXrayer.setMinimumSize(new java.awt.Dimension(100, 21));
        jTextFieldXrayer.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanelDetail.add(jTextFieldXrayer, gridBagConstraints);

        jLabelExecuter.setText("XRayExecuter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanelDetail.add(jLabelExecuter, gridBagConstraints);

        jTextFieldXRayExecuter.setEditable(false);
        jTextFieldXRayExecuter.setMinimumSize(new java.awt.Dimension(100, 21));
        jTextFieldXRayExecuter.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanelDetail.add(jTextFieldXRayExecuter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelDetail.add(jLabelOrderItemXRay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 4, 4);
        getContentPane().add(jPanelDetail, gridBagConstraints);

        jPanelResult.setLayout(new java.awt.GridBagLayout());

        jPanelResult.setBorder(new javax.swing.border.TitledBorder("\u0e1c\u0e25\u0e01\u0e32\u0e23\u0e2d\u0e48\u0e32\u0e19\u0e1f\u0e34\u0e25\u0e4c\u0e21"));
        jPanelResult.setMinimumSize(new java.awt.Dimension(146, 150));
        jPanelResult.setPreferredSize(new java.awt.Dimension(269, 150));
        jScrollPaneResult.setPreferredSize(new java.awt.Dimension(259, 100));
        jTextAreaResult.setLineWrap(true);
        jScrollPaneResult.setViewportView(jTextAreaResult);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanelResult.add(jScrollPaneResult, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jPanelResult, gridBagConstraints);

        jPanelButton.setLayout(new java.awt.GridBagLayout());

        jButtonSaveXray.setText("Save");
        jButtonSaveXray.setMaximumSize(new java.awt.Dimension(70, 24));
        jButtonSaveXray.setMinimumSize(new java.awt.Dimension(70, 24));
        jButtonSaveXray.setPreferredSize(new java.awt.Dimension(70, 24));
        jButtonSaveXray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveXrayActionPerformed(evt);
            }
        });

        jPanelButton.add(jButtonSaveXray, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanelButton, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
    private void jButtonSaveXrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveXrayActionPerformed
        setDataToObject();
        saveOrderXray(); 
        dispose();
    }//GEN-LAST:event_jButtonSaveXrayActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSaveXray;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelExecuter;
    private javax.swing.JLabel jLabelOrderItemXRay;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelResult;
    private javax.swing.JScrollPane jScrollPanePosition;
    private javax.swing.JScrollPane jScrollPaneResult;
    private javax.swing.JTextArea jTextAreaPosition;
    private javax.swing.JTextArea jTextAreaResult;
    private javax.swing.JTextField jTextFieldFilmNO;
    private javax.swing.JTextField jTextFieldFilmSize;
    private javax.swing.JTextField jTextFieldXRayExecuter;
    private javax.swing.JTextField jTextFieldXn;
    private javax.swing.JTextField jTextFieldXrayer;
    // End of variables declaration//GEN-END:variables
    private void showDataXray(String itemid,String vn)
    {
        setLanguage("");
        setTitle(Constant.getTextBundle("��§ҹ �� XRay"));
        theResultXRay = theOrderControl.readOrderXrayByVNItemId(itemid,vn);
        if(theResultXRay != null)
        {
            jLabelOrderItemXRay.setText("");
            if(theOrderItem != null && theOrderItem.getObjectId() !=null)
            {
                
                jLabelOrderItemXRay.setText(Constant.getTextBundle("��¡�� : ") + theOrderItem.common_name);
                this.setTitle(this.getTitle() + Constant.getTextBundle(" �ͧ ") +  theOrderItem.common_name);
            }
            if(theResultXRay.xn.equals(""))
            {
                theResultXRay.xn = theHO.thePatient.xn;
            }
            jTextFieldXn.setText(theResultXRay.xn);
            jTextAreaPosition.setText(theResultXRay.xray_point);
            jTextAreaResult.setText(theResultXRay.description);
            jTextFieldFilmNO.setText(theResultXRay.xray_id);
            jTextFieldFilmSize.setText(theResultXRay.size_film);
            Employee emp= theHC.theLookupControl.readEmployeeById(theResultXRay.reporter);
            if(emp!=null)
            {
                jTextFieldXrayer.setText(emp.fname + " " + emp.lname);
                jTextFieldXrayer.setToolTipText(jTextFieldXrayer.getText());
            }
            else{
                jTextFieldXrayer.setText(Constant.getTextBundle("��辺���ѹ�֡��"));
                Constant.println(Constant.getTextBundle("��辺���ѹ�֡��")+" '" + theResultXRay.reporter + "'");
                jTextFieldXrayer.setToolTipText("");
            }
            emp= theHC.theLookupControl.readEmployeeById(theResultXRay.excetue_film);
            if(emp!=null)
            {
                jTextFieldXRayExecuter.setText(emp.fname + " " + emp.lname);
                jTextFieldXRayExecuter.setToolTipText(jTextFieldXRayExecuter.getText());
            }
            else{
                jTextFieldXRayExecuter.setText(Constant.getTextBundle("��辺������ѧ��"));
                Constant.println(Constant.getTextBundle("��辺������ѧ��")+" '" + theResultXRay.excetue_film + "'");
                jTextFieldXRayExecuter.setToolTipText("");
            }
            emp = null;
        }
        else
        {   
            if(thePatient.xn.trim().length() == 0)
            {   
                genXN();                
            }
            else
            {   
                jTextFieldXn.setText(thePatient.xn);                
            }
        }
    } 
    
    private void genXN()
    {   String xn = thePatient.xn;

        theHC.theResultControl.savePatientXn(xn, true);
         /*thePatient.xn = xn;
        thePatientControl.savePatientWithNotNotify(thePatient);*/
        jTextFieldXn.setText(xn);            
    }
    
    private void setDataToObject()
    {   
        if(theResultXRay == null)
        {    
            theResultXRay = new ResultXRay();
            theResultXRay.xn = jTextFieldXn.getText();
            theResultXRay.description = jTextAreaResult.getText();
            theResultXRay.record_time = 
                theHC.theLookupControl.getTextCurrentDateTime();           
            theResultXRay.order_item_id = theOrderItem.getObjectId();
            theResultXRay.hn = theOrderItem.hn;
            theResultXRay.vn = theOrderItem.visit_id;
            theResultXRay.excetue_film = theEmployee;
            theResultXRay.reporter = theEmployee;
            theOrderItem.status = "4";
            //henbe_error theHC.theOrderControl.saveQueueOfOrder(theOrderItem,false);
        }
        else
        {
            theResultXRay.description = jTextAreaResult.getText();
            theResultXRay.reporter = theEmployee;
        }
            theOrderItem.status = "4";
            theOrderItem.reporter = theEmployee;
            theOrderItem.reported_time = this.theHC.theLookupControl.getTextCurrentDateTime();
    }
    
      
    private void saveOrderXray()
    {   
        theOrderControl.saveDataResultXrayReq(theResultXRay,theOrderItem,null,null);        
    }
    
    public void gc()
    {
        theUpdateStatus = null;
        theResultXRay = null;
        theOrderItem = null;
        theEmployee = null;
        
        jButtonSaveXray = null;
        jLabel1 = null;
        jLabel2 = null;
        jLabel3 = null;
        jLabel4 = null;
        jPanelButton = null;
        jPanelDetail = null;
        jPanelResult = null;
        jScrollPanePosition = null;
        jScrollPaneResult = null;
        jTextAreaPosition = null;
        jTextAreaResult = null;
        jTextFieldFilmNO = null;
        jTextFieldFilmSize = null;
        jTextFieldXn = null;
    
    }    
    
    public void setLanguage(String msg)
    {

//        jLabel2.setText(Constant.getTextBundle(jLabel2.getText()));
//        jLabel3.setText(Constant.getTextBundle(jLabel3.getText()));
//        jLabel4.setText(Constant.getTextBundle(jLabel4.getText()));
//        jLabel5.setText(Constant.getTextBundle(jLabel5.getText()));    
//        jLabelExecuter.setText(Constant.getTextBundle(jLabelExecuter.getText()));    
//        jButtonSaveXray.setText(Constant.getTextBundle(jButtonSaveXray.getText()));
        GuiLang.setLanguage(jLabelExecuter);
        GuiLang.setLanguage(jLabel1);
        GuiLang.setLanguage(jLabel2);
        GuiLang.setLanguage(jLabel3);
        GuiLang.setLanguage(jLabel4);
        GuiLang.setLanguage(jLabel5);
        GuiLang.setLanguage(jButtonSaveXray);
        GuiLang.setTextBundle(jPanelDetail);
        GuiLang.setTextBundle(jPanelResult);

    } 
    
    /**��˹�����Ŵ� Dialog*/
    private void setDialog()
    {
        setSize(250,250);
        
        setResizable(false);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-getSize().width)/2, (screenSize.height - getSize().height)/2);
        closePanel = false;
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closePanel = true;
                dispose();
            }
        });
    }
    
    public boolean showSearch(OrderItem orderItemXray)
    {   
        thePatient = theHO.thePatient;
        theOrderItem = orderItemXray;
        theEmployee = theHO.theEmployee.getObjectId();
        String itemid = orderItemXray.getObjectId();
        String vn = orderItemXray.visit_id;
        showDataXray(itemid,vn);
        setVisible(true);
        return closePanel;
    }
    public static void showDialogResultXray(JFrame frm,HosControl hc,OrderItem oi)
    {   
        PanelResultXray prx = new PanelResultXray(frm,hc);
        prx.showSearch(oi);
    }    
    
}    
    
    
    
    
    
    
    