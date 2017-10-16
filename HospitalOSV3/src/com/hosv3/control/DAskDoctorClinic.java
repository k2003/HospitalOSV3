/*
 * DialogOffDrug.java
 *
 * Created on 13 ����Ҥ� 2547, 18:10 �.
 */

package com.hosv3.control; 
import java.awt.*;
import java.util.*;
import com.hosv3.utility.*;
import com.hosv3.utility.connection.*;

import com.hospital_os.object.*; 
import com.hospital_os.utility.Gutil;
import com.hospital_os.utility.ComboboxModel;

/**
 * 
 * @author amp
 * ¡��ԡ@deprecated �Դ pattern ��ͧ����� dialog �Ѻ����ʴ�
 * ���������ҧ����������ա����¹������ŧ HosObject ��������ѹ���ա���� Object � HO �Դ Pattern
 */
public class DAskDoctorClinic extends javax.swing.JDialog 
{    
    private Vector vDoctorOff ,vClinic;   
    private LookupControl theLookupControl;
    DiagDoctorClinic theDiagDoctorClinic;
    boolean ask_again = true;
    boolean remember_data = false;
    boolean actionperform = false;
    /** Creates new form DialogOrderSet */
    public DAskDoctorClinic(UpdateStatus us,LookupControl lc)
    {  
        super(us.getJFrame(),true);
        initComponents();
        setLanguage("");
        theLookupControl = lc;
        setTitle(Constant.getTextBundle("���͡ᾷ����Ф�չԡ"));   
        
        vDoctorOff = theLookupControl.listDoctor();
        ComboboxModel.initComboBox(this.jComboBoxListDoctor,vDoctorOff);
        vClinic = theLookupControl.listClinic();
        ComboboxModel.initComboBox(this.jComboBoxListClinic,vClinic);
        this.jCheckBoxMemValue.setVisible(true);   
    }
    
    public void setLanguage(String msg)
    {
        GuiLang.setLanguage(jLabelDoctorName);
	GuiLang.setLanguage(jButtonOk);
        GuiLang.setLanguage(jLabelClinicName);
        GuiLang.setLanguage(jCheckBoxMemValue);
        
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
        jPanelShowDoctor = new javax.swing.JPanel();
        jLabelDoctorName = new javax.swing.JLabel();
        jComboBoxListDoctor = new javax.swing.JComboBox();
        jLabelClinicName = new javax.swing.JLabel();
        jComboBoxListClinic = new javax.swing.JComboBox();
        jPanelControl = new javax.swing.JPanel();
        jButtonOk = new javax.swing.JButton();
        jCheckBoxMemValue = new javax.swing.JCheckBox();
        jCheckBoxDontAsk = new javax.swing.JCheckBox();
        jLabelWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanelShowDoctor.setLayout(new java.awt.GridBagLayout());

        jLabelDoctorName.setText("ᾷ��");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelShowDoctor.add(jLabelDoctorName, gridBagConstraints);

        jComboBoxListDoctor.setMinimumSize(new java.awt.Dimension(25, 24));
        jComboBoxListDoctor.setPreferredSize(new java.awt.Dimension(25, 24));
        jComboBoxListDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxListDoctorKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelShowDoctor.add(jComboBoxListDoctor, gridBagConstraints);

        jLabelClinicName.setText("��չԡ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanelShowDoctor.add(jLabelClinicName, gridBagConstraints);

        jComboBoxListClinic.setMinimumSize(new java.awt.Dimension(25, 24));
        jComboBoxListClinic.setPreferredSize(new java.awt.Dimension(25, 24));
        jComboBoxListClinic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxListClinicKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanelShowDoctor.add(jComboBoxListClinic, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jPanelShowDoctor, gridBagConstraints);

        jPanelControl.setLayout(new java.awt.GridBagLayout());

        jButtonOk.setText("OK");
        jButtonOk.setMaximumSize(new java.awt.Dimension(67, 24));
        jButtonOk.setMinimumSize(new java.awt.Dimension(67, 25));
        jButtonOk.setPreferredSize(new java.awt.Dimension(67, 25));
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanelControl.add(jButtonOk, gridBagConstraints);

        jCheckBoxMemValue.setText("�Ӥ�ҹ�����");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelControl.add(jCheckBoxMemValue, gridBagConstraints);

        jCheckBoxDontAsk.setText("����ͧ����ա");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelControl.add(jCheckBoxDontAsk, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 5, 5, 5);
        jPanel1.add(jPanelControl, gridBagConstraints);

        jLabelWarning.setText("  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel1.add(jLabelWarning, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-327)/2, (screenSize.height-145)/2, 327, 145);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxListClinicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxListClinicKeyReleased
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            jButtonOkActionPerformed(null);
        }
    }//GEN-LAST:event_jComboBoxListClinicKeyReleased

    private void jComboBoxListDoctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxListDoctorKeyReleased
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            jButtonOkActionPerformed(null);
        }
    }//GEN-LAST:event_jComboBoxListDoctorKeyReleased

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        //�ó��繡�úѹ�֡ Diag �ͧᾷ������觼�ҹ�ҧ����õ�ǹ��
        actionperform = true;
        ask_again = !jCheckBoxDontAsk.isSelected();
        remember_data = jCheckBoxMemValue.isSelected();
        theDiagDoctorClinic.clinic_id = Gutil.getGuiData(jComboBoxListClinic);
        if(this.jComboBoxListDoctor.isVisible())
            theDiagDoctorClinic.doctor_id = Gutil.getGuiData(jComboBoxListDoctor);
        dispose();
        
    }//GEN-LAST:event_jButtonOkActionPerformed
    
    public void eventInComboBoxListDoctor(java.awt.event.KeyEvent evt)
    {
        if(java.awt.event.KeyEvent.VK_ENTER == evt.getKeyCode())
        {
            jButtonOkActionPerformed(null);
        }
    }
    /**
     * ������Ѻ�����������ä�ͧ��� map dx �Ѻ ICD10
     * @param emp �� Object �ͧ Employee �����ҡ������͡ (call by value)
     * @param clinic �� Object �ͧ Clinic �����ҡ������͡ (call by value)
     * @author padungrat(tong)
     * @date 19/04/2549,10:55
     */
    public DiagDoctorClinic showDialog()
    {
        if(!ask_again)
            return theDiagDoctorClinic;
        if(!remember_data)
            setDiagDoctorClinic(new DiagDoctorClinic());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();        
        setLocation((screenSize.width-getSize().width)/2, (screenSize.height-getSize().height)/2);     
        setVisible(true);
        return theDiagDoctorClinic;
    }
    
    /**
     * ��㹡�á�˹����Ӥ������
     * @author padungrat(tong)
     * @date 19/04/2549,16:30
     */
    private void setDiagDoctorClinic(DiagDoctorClinic ddc)
    {
        this.theDiagDoctorClinic = ddc;
        if(ddc.doctor_id !=null && !ddc.doctor_id.equals(""))
        {
            ComboboxModel.setCodeComboBox(this.jComboBoxListDoctor,ddc.doctor_id);
        }  
        if(ddc.clinic_id !=null && !ddc.clinic_id.equals(""))
        {
            ComboboxModel.setCodeComboBox(this.jComboBoxListClinic,ddc.clinic_id);
        }  
        this.jLabelWarning.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JCheckBox jCheckBoxDontAsk;
    private javax.swing.JCheckBox jCheckBoxMemValue;
    private javax.swing.JComboBox jComboBoxListClinic;
    private javax.swing.JComboBox jComboBoxListDoctor;
    private javax.swing.JLabel jLabelClinicName;
    private javax.swing.JLabel jLabelDoctorName;
    private javax.swing.JLabel jLabelWarning;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelShowDoctor;
    // End of variables declaration//GEN-END:variables
    
}