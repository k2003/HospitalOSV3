/*
 * DialogCalBilling.java
 *
 * Created on 29 ����Ҥ� 2547, 11:58 �.
 */
package com.hosv3.gui.dialog;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.hosv3.utility.*;
import com.hosv3.object.*;
import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hospital_os.object.*; 
import com.hospital_os.utility.Gutil;
import com.hospital_os.utility.ComboboxModel;
import com.hospital_os.utility.ComBoBoxEditor;
import com.hospital_os.utility.CheckBoxEditor;
import com.hospital_os.utility.CellRendererComboBox;
import com.hospital_os.utility.CellRendererCheckBox;
import com.hospital_os.utility.TaBleModel;
import com.hosv3.utility.Constant;

/**
 *
 * @author  tong
    
 */
public class DialogCalBilling extends javax.swing.JFrame implements UpdateStatus {
    
    /** Creates new form DialogCalBilling */
    HosControl theHC;    
    HosObject theHO;
    private boolean over_limit=false;
    private VisitControl theVisitControl;
    private LookupControl theLookupControl;
    private BillingControl theBillingControl;
    private Vector vOrderItem;
    private Vector vFixComboPayment;
    private Vector[] avOrderItem;
    private double dpayershare = 0;
    private double dpatientshare = 0;
    public static boolean actionCommand = false;
    private double dlimitmoney = 0;
    private double totalPatientShare = 0;
    private double totalPayerShare = 0;
    private String[] col_jTablePayment = {"�ӴѺ","�Է��"};
    private String[] col_jTableCalculateBilling = {"��¡��","�Է�Ԫ���","�����ª���","�Է��","�ԡ��","�͵�Ǩ"};

    private boolean all_order_selected;
    
    public DialogCalBilling(HosControl hc,UpdateStatus us) 
    {
        //super(us.getJFrame(), true);
        this.setIconImage(us.getJFrame().getIconImage());
        theHC = hc;
        theVisitControl = hc.theVisitControl;
        theBillingControl = hc.theBillingControl;
        theLookupControl = hc.theLookupControl;
        theHO = hc.theHO;
        initComponents();
        this.jTableCalculateBilling.setGuiMode(true);
        this.jTablePayment.setGuiMode(true);
        setLanguage(""); 
        setSize(640,480);
        setTitle(Constant.getTextBundle("��¡�äӹǳ��������"));
        Toolkit thekit = getToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//thekit.getScreenSize();
        setLocation((screenSize.width-getSize().width)/2, (screenSize.height-getSize().height)/2);
    }
    
    private void updateOG(Patient patient,Visit visit)
    {
        if(patient == null)
            return ;
          
        jTextFieldName.setText(
            theHC.theLookupControl.readPrefixString(patient.f_prefix_id)
            + " " + patient.patient_name + " " + patient.patient_last_name);

        jLabelDate.setText(DateUtil.getDateToString(DateUtil.getDateFromText(theHO.date_time),true));
        String age = DateUtil.calculateAgeLong(patient.patient_birthday,theHO.date_time);
//        if(patient.true_birthday==null || !patient.true_birthday.equals("1")){
//            if(age!=null && age.length()>=2)
//            {
//                age = " " + age.substring(0,2) +" " +
//                        Constant.getTextBundle("��");
//            }
//            else age = "";
//        }
        jLabelAgePatient.setText(age);
        jLabelHNPatient.setText(theLookupControl.getRenderTextHN(patient.hn));
        if(visit.visit_type.equals(VisitType.OPD)){
            jLabelVN.setText("VN");
            jLabelVN.setForeground(Color.BLACK);
            jLabelVNPatient.setText(theLookupControl.getRenderTextVN(visit.vn));
            jLabelVNPatient.setForeground(Color.BLACK);
        }
        else{
            jLabelVN.setText("AN");
            jLabelVN.setForeground(Color.RED);
            jLabelVNPatient.setText(theLookupControl.getRenderTextVN(visit.vn));
            jLabelVNPatient.setForeground(Color.RED);
        }
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCalculateBilling = new com.hosv3.gui.component.HJTableSort();
        jPanel10 = new javax.swing.JPanel();
        jLabelPayment = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelSumPaymentPayerShare = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelSumPaymentPatientShare = new javax.swing.JLabel();
        jLabelLimitMoney = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelDay = new javax.swing.JLabel();
        jLabelAge = new javax.swing.JLabel();
        jLabelAgePatient = new javax.swing.JLabel();
        jLabelVN = new javax.swing.JLabel();
        jLabelHN = new javax.swing.JLabel();
        jLabelVNPatient = new javax.swing.JLabel();
        jLabelHNPatient = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButtonSavePaid = new javax.swing.JButton();
        jButtonCalculate = new javax.swing.JButton();
        jButtonSaveBill = new javax.swing.JButton();
        jButtonFDischarge = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelSumAllPaymentPayerShare = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelSumAllPaymentPatientShare = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePayment = new com.hosv3.gui.component.HJTableSort();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(new javax.swing.border.TitledBorder("\u0e02\u0e49\u0e2d\u0e21\u0e39\u0e25\u0e01\u0e32\u0e23\u0e40\u0e07\u0e34\u0e19"));
        jTableCalculateBilling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCalculateBillingMouseReleased(evt);
            }
        });

        jScrollPane3.setViewportView(jTableCalculateBilling);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane3, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());

        jPanel10.setBorder(new javax.swing.border.TitledBorder(""));
        jLabelPayment.setText("Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel10.add(jLabelPayment, gridBagConstraints);

        jLabel8.setText("PayerShare");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel10.add(jLabel8, gridBagConstraints);

        jLabelSumPaymentPayerShare.setText("jLabel9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel10.add(jLabelSumPaymentPayerShare, gridBagConstraints);

        jLabel10.setText("PatientShare");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        jPanel10.add(jLabel10, gridBagConstraints);

        jLabelSumPaymentPatientShare.setText("jLabel11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel10.add(jLabelSumPaymentPatientShare, gridBagConstraints);

        jLabelLimitMoney.setText("LimitMoney");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel10.add(jLabelLimitMoney, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel3.add(jPanel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(new javax.swing.border.TitledBorder("\u0e02\u0e49\u0e2d\u0e21\u0e39\u0e25\u0e17\u0e31\u0e48\u0e27\u0e44\u0e1b\u0e02\u0e2d\u0e07\u0e1c\u0e39\u0e49\u0e1b\u0e48\u0e27\u0e22"));
        jPanel5.setMinimumSize(new java.awt.Dimension(300, 110));
        jLabel1.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabel1, gridBagConstraints);

        jLabelDate.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelDate, gridBagConstraints);

        jLabelDay.setText("Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelDay, gridBagConstraints);

        jLabelAge.setText("\u0e2d\u0e32\u0e22\u0e38");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelAge, gridBagConstraints);

        jLabelAgePatient.setText("jLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelAgePatient, gridBagConstraints);

        jLabelVN.setText("VN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelVN, gridBagConstraints);

        jLabelHN.setText("HN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelHN, gridBagConstraints);

        jLabelVNPatient.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelVNPatient, gridBagConstraints);

        jLabelHNPatient.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jLabelHNPatient, gridBagConstraints);

        jTextFieldName.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 5);
        jPanel5.add(jTextFieldName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jButtonSavePaid.setText("\u0e0a\u0e33\u0e23\u0e30\u0e40\u0e07\u0e34\u0e19");
        jButtonSavePaid.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButtonSavePaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavePaidActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel6.add(jButtonSavePaid, gridBagConstraints);

        jButtonCalculate.setText("Calculate");
        jButtonCalculate.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(jButtonCalculate, gridBagConstraints);

        jButtonSaveBill.setText("\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01");
        jButtonSaveBill.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButtonSaveBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveBillActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel6.add(jButtonSaveBill, gridBagConstraints);

        jButtonFDischarge.setText("\u0e08\u0e33\u0e2b\u0e19\u0e48\u0e32\u0e22");
        jButtonFDischarge.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButtonFDischarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFDischargeActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel6.add(jButtonFDischarge, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel1.add(jPanel6, gridBagConstraints);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBorder(new javax.swing.border.TitledBorder(""));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("PayerShare");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel11.add(jLabel3, gridBagConstraints);

        jLabelSumAllPaymentPayerShare.setText("...................");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel11.add(jLabelSumAllPaymentPayerShare, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("MS Sans Serif", 1, 13));
        jLabel5.setText("PatientShare");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel11.add(jLabel5, gridBagConstraints);

        jLabelSumAllPaymentPatientShare.setFont(new java.awt.Font("MS Sans Serif", 1, 13));
        jLabelSumAllPaymentPatientShare.setText("...................");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel11.add(jLabelSumAllPaymentPatientShare, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        jPanel9.add(jPanel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel1.add(jPanel9, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(new javax.swing.border.TitledBorder("\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e01\u0e32\u0e23\u0e23\u0e31\u0e01\u0e29\u0e32"));
        jTablePayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTablePaymentMouseReleased(evt);
            }
        });

        jScrollPane2.setViewportView(jTablePayment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void jButtonFDischargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFDischargeActionPerformed
        jButtonCalculateActionPerformed(null);
        if(over_limit){
            this.setStatus("ǧ�Թ�Թ�ͺࢵ�ͧ�Է�ԡ�سһ�Ѻ��¡�������ա����", UpdateStatus.WARNING);
            return;
        }
        theHC.theBillingControl.dischargeFinancial(avOrderItem,vOrderItem,"0");
        this.dispose();
    }//GEN-LAST:event_jButtonFDischargeActionPerformed

    private void jButtonSaveBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveBillActionPerformed
        jButtonCalculateActionPerformed(null);
        if(over_limit){
            this.setStatus("ǧ�Թ�Թ�ͺࢵ�ͧ�Է�ԡ�سһ�Ѻ��¡�������ա����", UpdateStatus.WARNING);
            return;
        }
        theBillingControl.billingInvoice(avOrderItem,vOrderItem,all_order_selected);
        //������úѹ�֡�����¡�����˹���� � ���ж�Ҥӹǹ���������������������ҡ���ͧ
        Vector billInv = theHC.theBillingControl.listBillingInvoiceByVisitID(
            theHO.theVisit.getObjectId());
        if(theHO.theVisit.visit_type.equals(VisitType.OPD))
            theHC.theBillingControl.calculateAllBillingInvoice(billInv,"0");
        this.dispose();
    }//GEN-LAST:event_jButtonSaveBillActionPerformed
    private void jTableCalculateBillingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCalculateBillingMouseReleased
    }//GEN-LAST:event_jTableCalculateBillingMouseReleased
   	
	private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        totalPatientShare = 0;
        totalPayerShare = 0;
        //�ӹǳ��������
        calculateBillingInvoiceItem(avOrderItem);
        avOrderItem = theBillingControl.calBillingVisitCont(avOrderItem);
        jTablePaymentMouseReleased(null);
        updateOverAll(avOrderItem);
    }//GEN-LAST:event_jButtonCalculateActionPerformed

        private void jButtonSavePaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavePaidActionPerformed
        jButtonCalculateActionPerformed(null);
        if(over_limit){
            this.setStatus("ǧ�Թ�Թ�ͺࢵ�ͧ�Է�ԡ�سһ�Ѻ��¡�������ա����", UpdateStatus.WARNING);
            return;
        }
        theBillingControl.billingInvoice(avOrderItem,vOrderItem);
        //����繼����¹͡�Т�� dialog �Ѻ�����Թ���ѹ��
        //if(theHO.theVisit.visit_type.equals(VisitType.OPD)){
            Vector billInv = theHC.theBillingControl.listBillingInvoiceByVisitID(
                theHO.theVisit.getObjectId());
            theHC.theBillingControl.calculateAllBillingInvoice(billInv,"0");
            Billing billing = new Billing();
            if(theHO.vBilling!=null)
                billing = (Billing)theHO.vBilling.get(theHO.vBilling.size()-1);
            DialogPatientPaid.showDialog(theHC,this,billing,theHO.theVisit);
            this.jButtonCalculate.setEnabled(false);
            this.jButtonSavePaid.setEnabled(false);
        //}
        this.dispose();        
        }//GEN-LAST:event_jButtonSavePaidActionPerformed

	private void jTablePaymentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePaymentMouseReleased
        int row = jTablePayment.getSelectedRow();
        if(row==-1) return;
        updateOGPayment(row);
    }//GEN-LAST:event_jTablePaymentMouseReleased
    
    public void updateOGPayment(int row)
    {
        if(row == -1) return;
        over_limit = false;
        Payment pm = (Payment)theHO.vVisitPayment.get(row);
        if(pm.use_money_limit.equalsIgnoreCase("null"))
            pm.use_money_limit = "0";
        try{
            dlimitmoney = Double.parseDouble(pm.money_limit);
        }
        catch(Exception ex) {
            dlimitmoney = 0;
        }
        updateOGBillingOrderItemV(avOrderItem[row]);
        ///////////////////////////////////////////////////////////////////////
        jLabelPayment.setText((String)jTablePayment.getValueAt(row,1));
        jLabelSumPaymentPatientShare.setText(Constant.dicimal(String.valueOf(dpatientshare)));
        jLabelSumPaymentPayerShare.setText(Constant.dicimal(String.valueOf(dpayershare)));
        if(dlimitmoney >0){   
            if(dpayershare > dlimitmoney){   
                over_limit = true;
                jLabelLimitMoney.setText(Constant.getTextBundle("�Թǧ�Թ") +
                        " " + dlimitmoney + " " + Constant.getTextBundle("�ҷ"));
                jLabelLimitMoney.setBackground(new Color(255,9,210));
                jLabelLimitMoney.setOpaque(true);
                jButtonSavePaid.setEnabled(false);
            }
            else{
                jLabelLimitMoney.setText(Constant.getTextBundle("ǧ�Թ") +
                        " " +  dlimitmoney + " " + Constant.getTextBundle("�ҷ"));
                jLabelLimitMoney.setOpaque(false);
                jButtonSavePaid.setEnabled(true);
            }
        }
        else{
            jLabelLimitMoney.setText(Constant.getTextBundle("�����ǧ�Թ"));
            jLabelLimitMoney.setOpaque(false);
            jButtonSavePaid.setEnabled(true);
        }        
    }
    ///////////////////////////////////////////////////////////////////////
    public void updateOverAll(Vector[] avOrderItem)
    {
        totalPatientShare = 0;
        totalPayerShare = 0;
        for(int i=0 ;i<avOrderItem.length;i++)
        {
            dpayershare = 0;
            dpatientshare = 0;
            Vector vc = avOrderItem[i];
            for(int j =0 ; j< vc.size() ; j++)
            {   
                BillingOrderItem orderitem = (BillingOrderItem)vc.get(j);
                dpayershare = dpayershare + Double.parseDouble(BillingControl.calBil(orderitem.payershare));
                dpatientshare = dpatientshare + Double.parseDouble(BillingControl.calBil(orderitem.patientshare));
            }
            totalPatientShare = totalPatientShare + dpatientshare;
            totalPayerShare = totalPayerShare + dpayershare;
        }
        this.jLabelSumAllPaymentPatientShare.setText(Constant.dicimal(String.valueOf(totalPatientShare)));
        this.jLabelSumAllPaymentPayerShare.setText(Constant.dicimal(String.valueOf(totalPayerShare)));
        boolean must_paid = (totalPatientShare>0.1);
        boolean pharm = theHO.theEmployee.authentication_id.equals(Authentication.PHARM);
        boolean is_ipd = theHO.theVisit.visit_type.equals(VisitType.IPD);
        
        //����Թ���ͧ��繻����ѹ�֡������դ������� ���� ��˹��·ҧ���ᾷ��������դ�������
        //���Ѫ�è��ͧ��繻����ѹ�֡������դ������� ���ͨ�˹��·ҧ���ᾷ���ҡ����դ�������
        //
        jButtonFDischarge.setVisible(false);
        jButtonSavePaid.setVisible(false);
        //jButtonSaveBill.setVisible(false);
        Constant.println("______________________totalPatientShare" + totalPatientShare + must_paid);
        if(must_paid)
            jButtonSavePaid.setVisible(true);
        else
            jButtonFDischarge.setVisible(true);
    }
    /**
     *  �ӡ������¹������ŧ Vector 
     *  ����Ѻ��¡�÷���ա������¹�ŧ�Է�ԡ���ѡ���¨�����������ա vector ˹��
     */
    private void calculateBillingInvoiceItem(Vector[] avOrderItem)
    {
        int rowpayment = jTablePayment.getSelectedRow();
        int rowcal = jTableCalculateBilling.getSelectedRow();
        int rowTable = jTableCalculateBilling.getRowCount();
        over_limit = false;
        Vector vorderpayment = avOrderItem[rowpayment];
        //loop ���� ����¡�� ���١����¹�ŧ
        //�¡�õ�Ǩ�ͺ��¡�����͡ ComboBox ������͡ 
        for(int i = vorderpayment.size() -1 ; i >=0 ;i--)
        {
            JComboBox jcb = (JComboBox)jTableCalculateBilling.getValueAt(i,3);
            String payment_id = Gutil.getGuiData(jcb);
            BillingOrderItem orderitem = (BillingOrderItem)vorderpayment.get(i);
            Boolean bl = (Boolean)jTableCalculateBilling.getValueAt(i,4);
            orderitem.draw = bl.booleanValue()?"1":"0";
            //��Ǩ�ͺ��¡����ҵç�ѹ�������Ҷ�����ç�ѹ�����ӡ��ź
            //���������ѧ vector ������
            if(!orderitem.payment_id.equalsIgnoreCase(payment_id))
            {
                //�ӡ������¹�ŧ������ �� plan_id ��� payment_id �ͧ �Է�ԡ���ѡ��
                Payment payment = (Payment)theHO.vVisitPayment.get(jcb.getSelectedIndex());
                orderitem.payment_id = payment.getObjectId();
                orderitem.plan_id = payment.plan_kid;
                avOrderItem[jcb.getSelectedIndex()].add(orderitem);
                vorderpayment.remove(i);
            }
        }
    }
    
    
    
    
    
    /**list �Է�ԡ���ѡ�Ңͧ������*/
    private void setDataTableToVectorOrder(Vector vc)
    {
        for(int i = vc.size()-1 ; i >=0 ; i--)
        {
            BillingOrderItem orderitem = (BillingOrderItem)vc.get(i);
            vc.remove(i);
            orderitem.payment_id = Gutil.getGuiData((JComboBox)jTableCalculateBilling.getValueAt(i, 3));//plan;
            orderitem.plan_id = checkPaymentAndPlan(orderitem.payment_id);
            Boolean bl = (Boolean)jTableCalculateBilling.getValueAt(i, 5);
            orderitem.request = bl.booleanValue()?"1":"0";
            bl = (Boolean)jTableCalculateBilling.getValueAt(i, 4);
            orderitem.draw = bl.booleanValue()?"1":"0";
            vc.add(i,orderitem);
        }
    }
    private String checkPaymentAndPlan(String payment_id)
    {   String code = new String();
        for(int i = 0; i< theHO.vVisitPayment.size();i++)
        {
            Payment p = new Payment();
            p = (Payment)theHO.vVisitPayment.get(i);
            if(p.getObjectId().equalsIgnoreCase(payment_id))
            {
                code = p.plan_kid;
                p = null;
                break;
            }
            p = null;
        }
        return code;
    }
    
    public void updateOGBillingOrderItemV(Vector vc)
    {
        dpayershare = 0;
        dpatientshare = 0;
        Payment p = new Payment();
        int billing = 0;
        TaBleModel tm ;
        if(vc != null)
        {   
            tm= new TaBleModel(col_jTableCalculateBilling,vc.size());
            BillingOrderItem orderitem = null;
            Payment pm = null;
            JComboBox jcb = null;
            for(int i=0 ;i<vc.size(); i++)
            {  
                orderitem = (BillingOrderItem)vc.get(i);
                pm = theHO.getVPayment(orderitem.payment_id);
                jcb = new JComboBox();
                ComboboxModel.initComboBox(jcb,vFixComboPayment);
                Gutil.setGuiData(jcb,pm.plan_kid);
                tm.setValueAt(orderitem.common_name, i,0);
                tm.setValueAt(Constant.dicimal(BillingControl.calBil(orderitem.payershare)), i,1);
                tm.setValueAt(Constant.dicimal(BillingControl.calBil(orderitem.patientshare)), i,2);
                tm.setValueAt(jcb, i,3);
                tm.setValueAt(Boolean.valueOf(Gutil.isSelected(orderitem.draw)), i,4);
                tm.setValueAt(Boolean.valueOf(Gutil.isSelected(orderitem.request)), i,5);
                dpayershare = dpayershare + Double.parseDouble(Constant.dicimal(
                    BillingControl.calBil(orderitem.payershare)));
                dpatientshare = dpatientshare + Double.parseDouble(Constant.dicimal(
                    BillingControl.calBil(orderitem.patientshare)));
                if(Gutil.isSelected(orderitem.charge_complete))      billing =1;
                else    billing =0;
                orderitem = null;
                pm = null;
                jcb = null;
            }
            if(billing == 0)     tm.setEditingCol(3,4);
        }
        else{   
            tm= new TaBleModel(col_jTableCalculateBilling,0);
        }
        jTableCalculateBilling.setModel(tm);
        jTableCalculateBilling.setRowHeight(24);
        jTableCalculateBilling.getColumnModel().getColumn(0).setPreferredWidth(300);// ��¡��
        jTableCalculateBilling.getColumnModel().getColumn(1).setPreferredWidth(70);// �Է������
        jTableCalculateBilling.getColumnModel().getColumn(1).setCellRenderer(TableRenderer.getRendererRight());
        jTableCalculateBilling.getColumnModel().getColumn(2).setPreferredWidth(70);// �����ª���
        jTableCalculateBilling.getColumnModel().getColumn(2).setCellRenderer(TableRenderer.getRendererRight());
        jTableCalculateBilling.getColumnModel().getColumn(3).setPreferredWidth(300);// �Է�Է����
        jTableCalculateBilling.getColumnModel().getColumn(3).setCellRenderer(new CellRendererComboBox());
        jTableCalculateBilling.getColumnModel().getColumn(3).setCellEditor(new ComBoBoxEditor(new JComboBox()));
        jTableCalculateBilling.getColumnModel().getColumn(4).setPreferredWidth(60);// �ԡ��
        jTableCalculateBilling.getColumnModel().getColumn(4).setCellRenderer(new CellRendererCheckBox());
        jTableCalculateBilling.getColumnModel().getColumn(4).setCellEditor(new CheckBoxEditor(new JCheckBox()));
        jTableCalculateBilling.getColumnModel().getColumn(5).setPreferredWidth(60);// �͵�Ǩ
        jTableCalculateBilling.getColumnModel().getColumn(5).setCellRenderer(new CellRendererCheckBox());
        jTableCalculateBilling.getColumnModel().getColumn(5).setCellEditor(new CheckBoxEditor(new JCheckBox()));
    }
    /**
     *  �ʴ��Է�ԡ���ѡ�Ңͧ������
     */
    public void updateOGPaymentV(Vector vc)
    {
        vFixComboPayment = new Vector();
        Payment p = new Payment();
        TaBleModel tm ;
        if(vc == null) {
            tm= new TaBleModel(col_jTablePayment,0);
            jTablePayment.setModel(tm);
            return;
        }
        tm= new TaBleModel(col_jTablePayment,vc.size());
        for(int i=0 ;i<vc.size(); i++)
        {  
            p = (Payment)vc.get(i);
            tm.setValueAt(String.valueOf(i+1),i,0);
            Plan plan = theLookupControl.readPlanById(p.plan_kid);
            tm.setValueAt( plan.description,i,1);
            vFixComboPayment.add(plan);
            plan = null;
        }
        jTablePayment.setModel(tm);
        jTablePayment.getColumnModel().getColumn(0).setPreferredWidth(100);// �ӴѺ���
        jTablePayment.getColumnModel().getColumn(0).setCellRenderer(TableRenderer.getRendererRight());
        jTablePayment.getColumnModel().getColumn(1).setPreferredWidth(800);// �Է�Է����
    }
    /**
     *@deprecated henbe unused
     **/
    public void showDialog(Vector vOrderItem)
    {
        Constant.println("showDialog(vOrderItem,false);");
        showDialog(vOrderItem,false);
    }
    
    public void showDialog(Vector vOrderItem,boolean all)
    {
        /**����¡�äԴ�Թ*/
        all_order_selected = all;
        this.vOrderItem = vOrderItem;
        avOrderItem = theBillingControl.calBillingVisit(vOrderItem,all);
        updateOverAll(avOrderItem);        
        updateOG(theHO.thePatient,theHO.theVisit);        
        updateOGPaymentV(theHO.getVisitPaymentActive());//theHO.vVisitPayment);
        this.jTablePayment.setRowSelectionInterval(0,0);
        this.updateOGPayment(0);
        //jButtonCalculateActionPerformed(null);
        this.jButtonCalculate.setEnabled(true);
        setVisible(true);
    } 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonFDischarge;
    private javax.swing.JButton jButtonSaveBill;
    private javax.swing.JButton jButtonSavePaid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelAgePatient;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDay;
    private javax.swing.JLabel jLabelHN;
    private javax.swing.JLabel jLabelHNPatient;
    private javax.swing.JLabel jLabelLimitMoney;
    private javax.swing.JLabel jLabelPayment;
    private javax.swing.JLabel jLabelSumAllPaymentPatientShare;
    private javax.swing.JLabel jLabelSumAllPaymentPayerShare;
    private javax.swing.JLabel jLabelSumPaymentPatientShare;
    private javax.swing.JLabel jLabelSumPaymentPayerShare;
    private javax.swing.JLabel jLabelVN;
    private javax.swing.JLabel jLabelVNPatient;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.hosv3.gui.component.HJTableSort jTableCalculateBilling;
    private com.hosv3.gui.component.HJTableSort jTablePayment;
    private javax.swing.JLabel jTextFieldName;
    // End of variables declaration//GEN-END:variables
     
     public void setLanguage(String msg)
    {
        GuiLang.setLanguage(jLabel8);//payerShare
	GuiLang.setLanguage(jLabel10);//patientShare
	GuiLang.setLanguage(jButtonSavePaid);//Bill
	GuiLang.setLanguage(jButtonCalculate);//Cal
	GuiLang.setLanguage(jLabelAge);
	GuiLang.setLanguage(jLabelDay);
	GuiLang.setLanguage(jLabel1);
	GuiLang.setLanguage(jLabelVN);
        GuiLang.setLanguage(jLabelHN);
	GuiLang.setLanguage(jLabel3);
        GuiLang.setLanguage(jLabel5);
        GuiLang.setLanguage(jLabelPayment);
	GuiLang.setLanguage(jLabelLimitMoney);
	GuiLang.setLanguage(jButtonSaveBill);
        GuiLang.setLanguage(jButtonFDischarge);
	GuiLang.setLanguage(col_jTablePayment);
        GuiLang.setLanguage(col_jTableCalculateBilling);
        GuiLang.setTextBundle(jPanel5);
        GuiLang.setTextBundle(jPanel2);
        GuiLang.setTextBundle(jPanel3);         
     }
    
    public boolean confirmBox(String str, int status) {
        Constant.println("DialogCalBilling:Incomplete");
        return false;
    }
    
    public JFrame getJFrame() {
        return this;
    }
    
    public void setStatus(String str, int status) {
        str = Constant.getTextBundle(str);
        JOptionPane.showMessageDialog(this,str);
    }
    public static void main(String[] argc){
        double a = 0.0;
        Constant.println("test" + (a!=0));
    }
}