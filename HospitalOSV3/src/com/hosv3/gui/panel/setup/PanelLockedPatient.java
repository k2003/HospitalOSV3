/*
 * PanelLockedPatientt.java
 *
 * Created on 
 */

package com.hosv3.gui.panel.setup;

import java.awt.*;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;

import com.hosv3.usecase.setup.*;
import com.hosv3.control.*;
import com.hosv3.object.*;
import com.hosv3.utility.connection.*;
import com.hosv3.utility.GuiLang;
import com.hosv3.gui.component.*;
import com.hosv3.utility.Constant;
import com.hospital_os.object.*;
import com.hospital_os.utility.CellRendererHos;
import com.hospital_os.utility.TaBleModel;
/**
 *
 *
 *
 * @panel author : amp
 */
public class PanelLockedPatient extends javax.swing.JPanel implements ManageOptionReq,PanelSetup
{   
    /**��㹡�� query ���������ǹ�ͧ setup*/
    UpdateStatus theUS;
    SetupControl theSetupControl;
    VisitControl theVisitControl;
    LookupControl theLookupControl;
    /** Vector �� Object �ͧ visit*/
    private Vector vVisit = new Vector();
    /** Object �ͧ visit*/
    private Visit theVisit;
    CellRendererHos vnRender = new CellRendererHos(CellRendererHos.VN);
    CellRendererHos hnRender = new CellRendererHos(CellRendererHos.HN);
    
    String[] col = {"HN","VN","����","���ʡ��","��� Lock","���ҷ�� Lock"};
    ///////////////////////////////////////////////////////
    public PanelLockedPatient() 
    {
        initComponents();
        setLanguage();
    }
    public PanelLockedPatient(HosControl hc, UpdateStatus us){
        initComponents();
        setLanguage();        
		setControl(hc,us);
    }    /////////////////////Use this for decrease memory usage
    public void setControl(HosControl hc,UpdateStatus us){
		theUS = us;
        theSetupControl = hc.theSetupControl;
        theVisitControl = hc.theVisitControl;
        theLookupControl = hc.theLookupControl;
    vnRender = new CellRendererHos(CellRendererHos.VN,theLookupControl.getSequenceDataVN().pattern);
    hnRender = new CellRendererHos(CellRendererHos.HN,theLookupControl.getSequenceDataHN().pattern);
        hc.theHS.theSetupSubject.addpanelrefrash(this);
        hc.theHS.theSetupSubject.addForLiftAttach(this);
//        vVisit = theVisitControl.listVisitLocking(jRadioButtonInProcess.isSelected());
//        setTableListForLife(vVisit);
    }
    public void setTitleLabel(String str){
        jLabel3.setText(str);
    }
   /**
     *@Author : amp
     *@date : 29/02/2549
     *@see : �Ѵ�������ǡѺ����    
     */
    private void setLanguage()
    {
        GuiLang.setLanguage(jLabel3);
        GuiLang.setLanguage(jLabel1);
        GuiLang.setLanguage(jButtonRefresh);
        GuiLang.setLanguage(jButtonUnlock);
        GuiLang.setLanguage(jRadioButtonInProcess);
        GuiLang.setLanguage(jRadioButtonOutProcess);
        GuiLang.setLanguage(col);
        
    }        
    ///////////////////////////////////////////////////////
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        defaultFont1 = new com.hospital_os.gui.font.DefaultFont();
        fontFormatTitle1 = new com.hospital_os.gui.font.FontFormatTitle();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableForLife = new com.hosv3.gui.component.HJTableSort();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldHN = new javax.swing.JTextField();
        jRadioButtonInProcess = new javax.swing.JRadioButton();
        jRadioButtonOutProcess = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jButtonRefresh = new javax.swing.JButton();
        jButtonUnlock = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setMinimumSize(new java.awt.Dimension(422, 670));
        setPreferredSize(new java.awt.Dimension(685, 670));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel4.setMinimumSize(new java.awt.Dimension(118, 250));
        jPanel4.setPreferredSize(new java.awt.Dimension(463, 250));
        jLabel3.setFont(fontFormatTitle1);
        jLabel3.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("LIST_PATIENT"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jTableForLife.setFont(defaultFont1);
        jScrollPane2.setViewportView(jTableForLife);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jScrollPane2, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(10, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(10, 30));
        jLabel1.setFont(defaultFont1);
        jLabel1.setText("HN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        jTextFieldHN.setFont(defaultFont1);
        jTextFieldHN.setMinimumSize(new java.awt.Dimension(70, 21));
        jTextFieldHN.setPreferredSize(new java.awt.Dimension(70, 21));
        jTextFieldHN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHNActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jTextFieldHN, gridBagConstraints);

        buttonGroup1.add(jRadioButtonInProcess);
        jRadioButtonInProcess.setFont(defaultFont1);
        jRadioButtonInProcess.setSelected(true);
        jRadioButtonInProcess.setText("\u0e43\u0e19\u0e01\u0e23\u0e30\u0e1a\u0e27\u0e19\u0e01\u0e32\u0e23");
        jRadioButtonInProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInProcessActionPerformed(evt);
            }
        });

        jPanel1.add(jRadioButtonInProcess, new java.awt.GridBagConstraints());

        buttonGroup1.add(jRadioButtonOutProcess);
        jRadioButtonOutProcess.setFont(defaultFont1);
        jRadioButtonOutProcess.setText("\u0e08\u0e1a\u0e01\u0e23\u0e30\u0e1a\u0e27\u0e19\u0e01\u0e32\u0e23");
        jRadioButtonOutProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOutProcessActionPerformed(evt);
            }
        });

        jPanel1.add(jRadioButtonOutProcess, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel4.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jPanel4, gridBagConstraints);

        jPanel11.setLayout(new java.awt.GridBagLayout());

        jButtonRefresh.setFont(defaultFont1);
        jButtonRefresh.setText("\u0e40\u0e23\u0e35\u0e22\u0e01\u0e14\u0e39\u0e43\u0e2b\u0e21\u0e48");
        jButtonRefresh.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jButtonRefresh.setMaximumSize(new java.awt.Dimension(67, 26));
        jButtonRefresh.setMinimumSize(new java.awt.Dimension(67, 26));
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel11.add(jButtonRefresh, gridBagConstraints);

        jButtonUnlock.setFont(defaultFont1);
        jButtonUnlock.setText("\u0e1b\u0e25\u0e14\u0e25\u0e47\u0e2d\u0e01");
        jButtonUnlock.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jButtonUnlock.setMaximumSize(new java.awt.Dimension(59, 26));
        jButtonUnlock.setMinimumSize(new java.awt.Dimension(59, 26));
        jButtonUnlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnlockActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel11.add(jButtonUnlock, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(jPanel11, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonOutProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOutProcessActionPerformed
        jButtonRefreshActionPerformed(evt);
    }//GEN-LAST:event_jRadioButtonOutProcessActionPerformed

    private void jRadioButtonInProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInProcessActionPerformed
        jButtonRefreshActionPerformed(evt);
    }//GEN-LAST:event_jRadioButtonInProcessActionPerformed

    private void jTextFieldHNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHNActionPerformed
        vVisit = theVisitControl.listVisitLocking(jRadioButtonInProcess.isSelected(),jTextFieldHN.getText());
        setTableListForLife(vVisit);
    }//GEN-LAST:event_jTextFieldHNActionPerformed

    private void jButtonUnlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnlockActionPerformed
        keepObjFromVector();
        jButtonRefreshActionPerformed(null);
    }//GEN-LAST:event_jButtonUnlockActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        vVisit = theVisitControl.listVisitLocking(jRadioButtonInProcess.isSelected());
        setTableListForLife(vVisit);
    }//GEN-LAST:event_jButtonRefreshActionPerformed
    /**
     *���͡ Obj ���лŴ��͡
     *���������: Obj �ͧ visit ������͡
     *�������͡: �����
     **/
    private void keepObjFromVector()
    {
        //int row = jTableForLife.getSelectedRow();
        //theVisit = (Visit)vVisit.get(row);
        int a[] = jTableForLife.getSelectedRows();
        for(int i=0; i<a.length; i++)
        {
            theVisit = (Visit)vVisit.get(a[i]);
            theVisitControl.unlockVisit(theVisit); 
        }
    }
    /**
     *�ʴ���ª��ͤ�������ѧ�Ѻ��ԡ��
     *���������: �����
     *�������͡: ��ʵ���ª��ͤ�������ѧ�Ѻ��ԡ��
     */
    private void setTableListForLife(Vector vVisit)
    {
//        String[] col = {"HN","VN","����","���ʡ��","��� Lock","���ҷ�� Lock"};
        TaBleModel tm ;
        if(vVisit != null){   
            if(vVisit.size()>50) tm= new TaBleModel(col,50);
            else tm= new TaBleModel(col,vVisit.size());
            Employee emp = null;
            for(int i=0 ;i<vVisit.size()&&i<50; i++){  
                VisitPatient v = (VisitPatient)vVisit.get(i);
                tm.setValueAt(v.hn,i,0);
                tm.setValueAt(v.vn,i,1);
                if(v.thePatient != null){
                    // Somprasong 110809 fix bug � family ����դ��
//                    tm.setValueAt(v.thePatient.getFamily().patient_name,i,2);
//                    tm.setValueAt(v.thePatient.patient_last_name,i,3);
                    tm.setValueAt(v.thePatient.fname,i,2);
                    tm.setValueAt(v.thePatient.lname,i,3);
                }
                else{
                    tm.setValueAt(Constant.getTextBundle("�����Ţͧ�������ջѭ��"),i,2);                
                    tm.setValueAt("",i,3);  
                }
                emp = theLookupControl.readEmployeeById(v.lock_user);
                if(emp != null){
                    tm.setValueAt(emp.fname + " " + emp.lname ,i,4);
                }
                else{
                    tm.setValueAt(Constant.getTextBundle("�����ҹ�ҧ���١ź�͡�ҡ�ҹ������") ,i,4);
                }
                emp = null;
                tm.setValueAt(v.lock_time,i,5);
            }
        }
        else{   
            tm= new TaBleModel(col,0);
        }
            jTableForLife.setModel(tm);
            setTableOrderHistoryDefault();
    }
    /**��㹡�� ��˹���Ҵ����ʴ��Ţͧ���ҧ*/
    private void setTableOrderHistoryDefault()
    {
        jTableForLife.getColumnModel().getColumn(0).setPreferredWidth(80); 
        jTableForLife.getColumnModel().getColumn(0).setCellRenderer(hnRender); // HN
        jTableForLife.getColumnModel().getColumn(1).setPreferredWidth(80); 
        jTableForLife.getColumnModel().getColumn(1).setCellRenderer(vnRender); // VN
        jTableForLife.getColumnModel().getColumn(2).setPreferredWidth(100); 
        jTableForLife.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableForLife.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTableForLife.getColumnModel().getColumn(5).setPreferredWidth(120); 
    }    
    public static void main(String args[])
    {
        JFrame frm = new JFrame("Test");
        frm.getContentPane().setLayout(new BorderLayout());
        PanelLockedPatient pnl = new PanelLockedPatient();
        frm.getContentPane().add(pnl,  BorderLayout.NORTH);
        frm.addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        frm.pack();
        frm.setVisible(true);
        frm.setSize(700,700);
    }
    public void notifyreFrashPanel() 
    {
    }
    public void notifysetEnableForLift(boolean b) {
    }
    public int editOption(Option option) {
        Constant.println("PanelLockedPatient function is not use.");
        return-1;
    }
    public Vector listOptionAll() {
        Constant.println("PanelLockedPatient function is not use.");
        return null;
    }
    public void reFrashPanel() {
    }
    public Option readOption() {
        Constant.println("PanelLockedPatient function is not use.");
        return null;
    }
    public int saveOption(Option option) {
        Constant.println("PanelLockedPatient function is not use.");
        return -1;
    }
    public void setEnableForLift(boolean b) {
    }

    public void setupLookup() {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private com.hospital_os.gui.font.FontFormatTitle fontFormatTitle1;
    protected javax.swing.JButton jButtonRefresh;
    protected javax.swing.JButton jButtonUnlock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonInProcess;
    private javax.swing.JRadioButton jRadioButtonOutProcess;
    private javax.swing.JScrollPane jScrollPane2;
    private com.hosv3.gui.component.HJTableSort jTableForLife;
    private javax.swing.JTextField jTextFieldHN;
    // End of variables declaration//GEN-END:variables
}
