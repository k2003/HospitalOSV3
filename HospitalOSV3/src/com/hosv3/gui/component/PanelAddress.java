/*
 * Address1.java
 *
 * Created on 17 �ԧ�Ҥ� 2548, 11:05 �.
 */

package com.hosv3.gui.component;
import com.hosv3.object.*;
import com.hosv3.control.*;
import com.hosv3.utility.*;
import com.hosv3.utility.connection.*;

import java.awt.*;
import com.hospital_os.utility.Gutil;

/**
 *
 * @author  sumo
 */
public class PanelAddress extends javax.swing.JPanel {
    
    HosObject theHO;
    UpdateStatus theUS;
    LookupControl theLC;
 
    public String        house  = "";
    public String         village  = "";
    public String         road  = "";
    public String         phone  = "";
    public String         mobile  = "";
    public String         chan  = "";
    public String         amp  = "";
    public String         tamb  = "";
    public String         is_other  = "";
    public String         other_address  = "";
    public String         cur_chan  = "";
    public String         cur_amp  = "";
    public String         cur_tamb  = "";

    /** Creates new form Address1 */
    public PanelAddress() {
        initComponents();
    }
    public void setControl(HosControl hc, UpdateStatus us){   
        setControl(hc.theLookupControl,us);
    }
    public void setControl(LookupControl lc, UpdateStatus us){   
        theUS = us;
        theLC = lc;
        setDefaultAddress("","","","","",theLC.readSite().changwat
                , theLC.readSite().amphor,theLC.readSite().tambon,"0","");
        initComboBox();
    }
    public void setOtherAddressVisible(boolean b){
        this.jCheckBoxOtherCountry.setVisible(b);
    }
    public void setFont(Font font){
        super.setFont(font);
        if(panelCatAddress1!=null)
        {
            panelCatAddress1.setFont(font);
            jLabelHouse.setFont(font);
            jLabelMobile.setFont(font);
            jLabelPhone.setFont(font);
            jLabelRoad.setFont(font);
            jLabelVillage.setFont(font);
            this.jTextFieldHouse.setFont(font);
            this.jTextFieldMobile.setFont(font);
            this.jTextFieldPhone.setFont(font);
            this.jTextFieldRoad.setFont(font);
            this.jTextFieldVillage.setFont(font);
            this.jTextArea1.setFont(font);
        }
    }
    public void setLanguage(String str){
        this.panelCatAddress1.setLanguage(str);
        GuiLang.setLanguage(jLabelHouse);
        GuiLang.setLanguage(jLabelMobile);
        GuiLang.setLanguage(jLabelPhone);
        GuiLang.setLanguage(jLabelRoad);
        GuiLang.setLanguage(jLabelVillage);
        GuiLang.setLanguage(jCheckBoxOtherCountry);
    }
    private void initComboBox(){   
        this.panelCatAddress1.setControl(this.theLC,this.theUS);
        //ComboboxModel.initComboBox(jComboBoxChangwat,theLC.listChangwat(""));
    }
    public void requestFocus(){
        jTextFieldHouse.requestFocus();
    }
    public void setEnabled(boolean b){
        this.panelCatAddress1.setEnabled(b);
        this.jTextFieldHouse.setEnabled(b);
        this.jTextFieldMobile.setEnabled(b);
        this.jTextFieldPhone.setEnabled(b);
        this.jTextFieldRoad.setEnabled(b);
        this.jTextFieldVillage.setEnabled(b);
    }
    public void setOtherCountry(boolean b){
        this.jCheckBoxOtherCountry.setSelected(b);
        this.jCheckBoxOtherCountryActionPerformed(null);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jCheckBoxOtherCountry = new javax.swing.JCheckBox();
        jPanelOtherAddress = new javax.swing.JPanel();
        jPanelThaiAddress = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelHouse = new javax.swing.JLabel();
        jTextFieldHouse = new javax.swing.JTextField();
        jLabelVillage = new javax.swing.JLabel();
        jLabelRoad = new javax.swing.JLabel();
        jTextFieldRoad = new javax.swing.JTextField();
        jTextFieldVillage = new com.hospital_os.utility.IntegerTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabelPhone = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabelMobile = new javax.swing.JLabel();
        jTextFieldMobile = new javax.swing.JTextField();
        panelCatAddress1 = new com.hosv3.gui.component.PanelCatAddress();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        jCheckBoxOtherCountry.setFont(getFont());
        jCheckBoxOtherCountry.setText("��������ҧ�����");
        jCheckBoxOtherCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxOtherCountryActionPerformed(evt);
            }
        });
        jCheckBoxOtherCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCheckBoxOtherCountryKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(jCheckBoxOtherCountry, gridBagConstraints);

        jPanelOtherAddress.setLayout(new java.awt.CardLayout());

        jPanelThaiAddress.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelHouse.setFont(getFont());
        jLabelHouse.setText("�Ţ���");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jLabelHouse, gridBagConstraints);

        jTextFieldHouse.setFont(getFont());
        jTextFieldHouse.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldHouse.setMinimumSize(new java.awt.Dimension(50, 21));
        jTextFieldHouse.setPreferredSize(new java.awt.Dimension(50, 21));
        jTextFieldHouse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldHouseKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(jTextFieldHouse, gridBagConstraints);

        jLabelVillage.setFont(getFont());
        jLabelVillage.setText("������");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(jLabelVillage, gridBagConstraints);

        jLabelRoad.setFont(getFont());
        jLabelRoad.setText("���");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(jLabelRoad, gridBagConstraints);

        jTextFieldRoad.setFont(getFont());
        jTextFieldRoad.setMinimumSize(new java.awt.Dimension(63, 21));
        jTextFieldRoad.setPreferredSize(new java.awt.Dimension(63, 21));
        jTextFieldRoad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRoadKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(jTextFieldRoad, gridBagConstraints);

        jTextFieldVillage.setColumns(3);
        jTextFieldVillage.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVillage.setMinimumSize(new java.awt.Dimension(50, 21));
        jTextFieldVillage.setPreferredSize(new java.awt.Dimension(50, 21));
        jTextFieldVillage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldVillageKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(jTextFieldVillage, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelThaiAddress.add(jPanel1, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabelPhone.setFont(getFont());
        jLabelPhone.setText("���Ѿ��");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(jLabelPhone, gridBagConstraints);

        jTextFieldPhone.setFont(getFont());
        jTextFieldPhone.setMinimumSize(new java.awt.Dimension(80, 21));
        jTextFieldPhone.setPreferredSize(new java.awt.Dimension(80, 21));
        jTextFieldPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPhoneKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel10.add(jTextFieldPhone, gridBagConstraints);

        jLabelMobile.setFont(getFont());
        jLabelMobile.setText("��Ͷ��");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel10.add(jLabelMobile, gridBagConstraints);

        jTextFieldMobile.setFont(getFont());
        jTextFieldMobile.setMinimumSize(new java.awt.Dimension(80, 21));
        jTextFieldMobile.setPreferredSize(new java.awt.Dimension(80, 21));
        jTextFieldMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMobileKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel10.add(jTextFieldMobile, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanelThaiAddress.add(jPanel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelThaiAddress.add(panelCatAddress1, gridBagConstraints);

        jPanelOtherAddress.add(jPanelThaiAddress, "card1");

        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jPanelOtherAddress.add(jScrollPane1, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanelOtherAddress, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldVillageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVillageKeyReleased
        Gutil.setTransferCursor(evt,jTextFieldVillage,null,jTextFieldHouse,this.panelCatAddress1,jTextFieldRoad);
    }//GEN-LAST:event_jTextFieldVillageKeyReleased

    private void jTextFieldPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhoneKeyReleased
        Gutil.setTransferCursor(evt,jTextFieldPhone,jTextFieldRoad,panelCatAddress1,jTextFieldMobile,null);

    }//GEN-LAST:event_jTextFieldPhoneKeyReleased

    private void jTextFieldMobileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMobileKeyReleased
        Gutil.setTransferCursor(evt,jTextFieldMobile,jTextFieldPhone,panelCatAddress1,panelCatAddress1,null);

    }//GEN-LAST:event_jTextFieldMobileKeyReleased

    private void jTextFieldRoadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRoadKeyReleased
        Gutil.setTransferCursor(evt,jTextFieldRoad,null,jTextFieldVillage,jTextFieldPhone,null);

    }//GEN-LAST:event_jTextFieldRoadKeyReleased

    private void jTextFieldHouseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHouseKeyReleased
        Gutil.setTransferCursor(evt,jTextFieldHouse,null,null,panelCatAddress1,jTextFieldVillage);

    }//GEN-LAST:event_jTextFieldHouseKeyReleased

    private void jCheckBoxOtherCountryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBoxOtherCountryKeyReleased
        if(evt.getKeyCode()==evt.VK_DOWN)
            this.jTextFieldHouse.requestFocus();
    }//GEN-LAST:event_jCheckBoxOtherCountryKeyReleased

    private void jCheckBoxOtherCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxOtherCountryActionPerformed
        boolean other = jCheckBoxOtherCountry.isSelected();
        CardLayout layoutOrder = (CardLayout)jPanelOtherAddress.getLayout();
        
        if(other)
            layoutOrder.show(jPanelOtherAddress,"card2");
        else
            layoutOrder.show(jPanelOtherAddress,"card1");
    }//GEN-LAST:event_jCheckBoxOtherCountryActionPerformed
	
	// Variables declaration - do not modify
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxOtherCountry;
    private javax.swing.JLabel jLabelHouse;
    private javax.swing.JLabel jLabelMobile;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelRoad;
    private javax.swing.JLabel jLabelVillage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanelOtherAddress;
    private javax.swing.JPanel jPanelThaiAddress;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldHouse;
    private javax.swing.JTextField jTextFieldMobile;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldRoad;
    private com.hospital_os.utility.IntegerTextField jTextFieldVillage;
    private com.hosv3.gui.component.PanelCatAddress panelCatAddress1;
    // End of variables declaration//GEN-END:variables
     public String getHouse()
    {
        String house = Gutil.CheckReservedWords(jTextFieldHouse.getText());
        return house;
    }
     
    public String getVillage()
    {
        String village = Gutil.CheckReservedWords(jTextFieldVillage.getText());
        return village;
    }
    
    public String getRoad()
    {
        String road = Gutil.CheckReservedWords(jTextFieldRoad.getText()); 
        return road;
    }
    
    public String getPhone()
    {
        String phone = jTextFieldPhone.getText();
        return phone;
    }

    public String getMobile()
    {
        String mobile = jTextFieldMobile.getText();
        return mobile;
    }
    
    public String getChangwat()
    {
        return panelCatAddress1.getChangwat();
    }
    public String getAmpur()
    {
        return panelCatAddress1.getAmpur();
    }
    
    public String getTambon()
    {
        return panelCatAddress1.getTambon();
    }
    public String isOtherCountry()
    {
        if(jCheckBoxOtherCountry.isSelected())
            return "1";
        else
            return "0";
    }
    public String getOtherCountry()
    {
        return jTextArea1.getText();
    }
    public void setAddress(String house,String village,String road,String phone
            ,String mobile,String chan,String amp,String tamb)
    {
        setAddress(house,village,road,phone,mobile,chan,amp,tamb,"0","");
    }
    public void setDefaultAddress(String house,String village,String road,String phone
            ,String mobile,String chan,String amp,String tamb,String is_other
            ,String other_address)
    {
        this.house = house;
        this.village = village;
        this.road = road;
        this.phone = phone;
        this.mobile = mobile;
        this.chan = chan;
        this.amp = amp;
        this.tamb = tamb;
        this.is_other = is_other;
        this.other_address = other_address;
    }
    public void reset()
    {
        jTextFieldHouse.setText("");
        jTextFieldVillage.setText("");
        jTextFieldRoad.setText("");
        jTextFieldPhone.setText("");
        jTextFieldMobile.setText("");
        jTextArea1.setText("");
    }
    public void setAddress(String house,String village,String road,String phone
            ,String mobile,String chan,String amp,String tamb,String is_other
            ,String other_address)
    {
        
//        Constant.println("tambon________________tambon" + tamb);
//        Constant.println("_________________public void setAddress(" + chan + amp + tamb);
        //�������˹��繤�� default �óշ������������
        if(house==null || house.equals(""))
            house = this.house;
        jTextFieldHouse.setText(house);
        if(village==null || village.equals(""))
            village = this.village;
        jTextFieldVillage.setText(village);
        if(road==null || road.equals(""))
            road = this.road;
        jTextFieldRoad.setText(road);
        if(phone==null || phone.equals(""))
            phone = this.phone;
        jTextFieldPhone.setText(phone);
        if(mobile==null || mobile.equals(""))
            mobile = this.mobile;
        jTextFieldMobile.setText(mobile);
        this.panelCatAddress1.setAddress(chan,amp,tamb);

        if(is_other==null || is_other.equals(""))
            is_other = this.is_other;
        boolean other = is_other.equals("1");
        jCheckBoxOtherCountry.setSelected(other);
        jCheckBoxOtherCountryActionPerformed(null);
        if(other_address==null || other_address.equals(""))
            other_address = this.other_address;
        jTextArea1.setText(other_address);
    }
 
    public static void main(String[] argc){
        System.setProperty("Debug","1");
        US jf = new US();
        javax.swing.JTabbedPane jt = new javax.swing.JTabbedPane();
        PanelAddress psd5 = new PanelAddress();
        HosControl hc = new HosControl();
        //HosDialog hd = new HosDialog(hc,jf);
        psd5.setControl(hc,jf);
        psd5.setAddress("01","01","01","01","01","810000","810200","810202");
        jf.setSize(300, 200);
        jt.add(psd5);
        java.awt.BorderLayout bl = new java.awt.BorderLayout();
        jf.getContentPane().setLayout(new java.awt.BorderLayout());
        jf.getContentPane().add(jt,bl.CENTER);
        jf.setVisible(true);
    }
}
