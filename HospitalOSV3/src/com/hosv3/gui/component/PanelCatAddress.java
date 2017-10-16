/*
 * Address1.java
 *
 * Created on 17 �ԧ�Ҥ� 2548, 11:05 �.
 */

package com.hosv3.gui.component;
import com.hosv3.object.*;
import com.hosv3.control.*;
import com.hosv3.control.lookup.*;
import com.hosv3.utility.*;
import com.hosv3.utility.connection.*;
import java.awt.Font;

import java.util.*;

import com.hospital_os.object.*;
import com.hosv3.utility.Constant;
import com.hospital_os.utility.ComboboxModel;
import com.hospital_os.utility.Gutil;

/**
 *
 * @author  sumo
 */
public class PanelCatAddress extends javax.swing.JPanel {
    public static final long  serialVersionUID = 0;
    LookupControl theLookupControl;
    UpdateStatus theUS;  
    Patient thePatient;
    Address2 theAddress2;
    Visit theVisit;
    public String         chan  = "";
    public String         amp  = "";
    public String         tamb  = "";

    private boolean user_mode=true;
    /** Creates new form Address1 */
    public PanelCatAddress() {
        initComponents();
        setLanguage("");
    }
    public void setControl(HosControl hc, UpdateStatus us){   
        setControl(hc.theLookupControl,us);
        setLanguage("");
    }
    public void setControl(LookupControl lc, UpdateStatus us){   
        theUS = us;
        theLookupControl = lc;
        initComboBox();
        setLanguage("");
    }
    public void setLanguage(String str){
        GuiLang.setLanguage(jLabelAmpur);
        GuiLang.setLanguage(jLabelChangwat);
        GuiLang.setLanguage(jLabelTambon);        
    }
    public void setFont(Font font){
        super.setFont(font);
        if(jLabelAmpur!=null)
        jLabelAmpur.setFont(font);
        if(jLabelChangwat!=null)
        jLabelChangwat.setFont(font);
        if(jLabelTambon!=null)
        jLabelTambon.setFont(font);
        if(jComboBoxChangwat!=null)
        jComboBoxChangwat.setFont(font);
        if(jComboBoxAmpur!=null)
        jComboBoxAmpur.setFont(font);
        if(jComboBoxTambon!=null)
        jComboBoxTambon.setFont(font);
        
    }
    private void initComboBox(){   
        //Constant.println(""test henbe hahahahahah");
        jComboBoxChangwat.setControl(null,new ChangwatLookup(theLookupControl),new Address2());
        jComboBoxAmpur.setControl(null,new AmpurLookup(theLookupControl),new Address2()); 
        jComboBoxTambon.setControl(null,new TambonLookup(theLookupControl),new Address2()); 
        ComboboxModel.initComboBox(jComboBoxChangwat,theLookupControl.listChangwat("%"));
    }
    public void setEnabled(boolean b){
        this.jComboBoxAmpur.setEnabled(b);
        this.jComboBoxChangwat.setEnabled(b);
        this.jComboBoxTambon.setEnabled(b);
        this.jTextFieldAmpur.setEnabled(b);
        this.jTextFieldChangwat.setEnabled(b);
        this.jTextFieldTambon.setEnabled(b);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel11 = new javax.swing.JPanel();
        jLabelTambon = new javax.swing.JLabel();
        jLabelAmpur = new javax.swing.JLabel();
        jLabelChangwat = new javax.swing.JLabel();
        jTextFieldChangwat = new com.hospital_os.utility.IntegerTextField();
        jTextFieldAmpur = new com.hospital_os.utility.IntegerTextField();
        jTextFieldTambon = new com.hospital_os.utility.IntegerTextField();
        jComboBoxChangwat = new com.hosv3.gui.component.HosComboBox();
        jComboBoxAmpur = new com.hosv3.gui.component.HosComboBox();
        jComboBoxTambon = new com.hosv3.gui.component.HosComboBox();

        setLayout(new java.awt.GridBagLayout());

        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabelTambon.setText("�Ӻ�");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 1);
        jPanel11.add(jLabelTambon, gridBagConstraints);

        jLabelAmpur.setText("�����");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 1);
        jPanel11.add(jLabelAmpur, gridBagConstraints);

        jLabelChangwat.setText("�ѧ��Ѵ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 1);
        jPanel11.add(jLabelChangwat, gridBagConstraints);

        jTextFieldChangwat.setColumns(2);
        jTextFieldChangwat.setMaximumSize(new java.awt.Dimension(23, 22));
        jTextFieldChangwat.setMinimumSize(new java.awt.Dimension(23, 22));
        jTextFieldChangwat.setPreferredSize(new java.awt.Dimension(23, 20));
        jTextFieldChangwat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldChangwatActionPerformed(evt);
            }
        });
        jTextFieldChangwat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldChangwatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldChangwatFocusLost(evt);
            }
        });
        jTextFieldChangwat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldChangwatKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 1, 1);
        jPanel11.add(jTextFieldChangwat, gridBagConstraints);

        jTextFieldAmpur.setColumns(2);
        jTextFieldAmpur.setText("12");
        jTextFieldAmpur.setMaximumSize(new java.awt.Dimension(23, 22));
        jTextFieldAmpur.setMinimumSize(new java.awt.Dimension(23, 22));
        jTextFieldAmpur.setPreferredSize(new java.awt.Dimension(23, 20));
        jTextFieldAmpur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAmpurActionPerformed(evt);
            }
        });
        jTextFieldAmpur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAmpurFocusLost(evt);
            }
        });
        jTextFieldAmpur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAmpurKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel11.add(jTextFieldAmpur, gridBagConstraints);

        jTextFieldTambon.setColumns(2);
        jTextFieldTambon.setText("12");
        jTextFieldTambon.setMaximumSize(new java.awt.Dimension(23, 22));
        jTextFieldTambon.setMinimumSize(new java.awt.Dimension(23, 22));
        jTextFieldTambon.setPreferredSize(new java.awt.Dimension(23, 20));
        jTextFieldTambon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTambonActionPerformed(evt);
            }
        });
        jTextFieldTambon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTambonFocusLost(evt);
            }
        });
        jTextFieldTambon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTambonKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 0, 1);
        jPanel11.add(jTextFieldTambon, gridBagConstraints);

        jComboBoxChangwat.setMinimumSize(new java.awt.Dimension(38, 22));
        jComboBoxChangwat.setPreferredSize(new java.awt.Dimension(38, 22));
        jComboBoxChangwat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxChangwatActionPerformed(evt);
            }
        });
        jComboBoxChangwat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxChangwatFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 1, 0);
        jPanel11.add(jComboBoxChangwat, gridBagConstraints);

        jComboBoxAmpur.setMinimumSize(new java.awt.Dimension(38, 22));
        jComboBoxAmpur.setPreferredSize(new java.awt.Dimension(38, 22));
        jComboBoxAmpur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAmpurActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 0);
        jPanel11.add(jComboBoxAmpur, gridBagConstraints);

        jComboBoxTambon.setMinimumSize(new java.awt.Dimension(38, 22));
        jComboBoxTambon.setPreferredSize(new java.awt.Dimension(38, 22));
        jComboBoxTambon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTambonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 0, 0);
        jPanel11.add(jComboBoxTambon, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        add(jPanel11, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldChangwatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldChangwatFocusGained
//        setAddress("20","02","02");
    }//GEN-LAST:event_jTextFieldChangwatFocusGained

    private void jTextFieldTambonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTambonFocusLost
        if(!user_mode) return;
        Gutil.setGuiData(jComboBoxTambon, 
                Gutil.getGuiData(jTextFieldChangwat)
                +Gutil.getGuiData(jTextFieldAmpur)
                +Gutil.getGuiData(jTextFieldTambon));
    }//GEN-LAST:event_jTextFieldTambonFocusLost

    private void jTextFieldAmpurFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAmpurFocusLost
        if(!user_mode) return;
        Gutil.setGuiData(jComboBoxAmpur
                , Gutil.getGuiData(jTextFieldChangwat)+Gutil.getGuiData(jTextFieldAmpur)+"00");
    }//GEN-LAST:event_jTextFieldAmpurFocusLost

    private void jTextFieldChangwatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldChangwatFocusLost
        if(!user_mode) return;
        Gutil.setGuiData(jComboBoxChangwat,Gutil.getGuiData(jTextFieldChangwat)+"0000");
    }//GEN-LAST:event_jTextFieldChangwatFocusLost

    private void jComboBoxChangwatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxChangwatFocusLost

    }//GEN-LAST:event_jComboBoxChangwatFocusLost
    private void jComboBoxTambonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTambonActionPerformed
        if(user_mode){
        String tam = Gutil.getGuiData(jComboBoxTambon);   
        if(tam !=null && !tam.equals("")) {   
            String a = tam.substring(4,6);
            if(!a.equals("00"))
                Gutil.setGuiData(jTextFieldTambon, a);
        }
        }
    }//GEN-LAST:event_jComboBoxTambonActionPerformed
    private void jComboBoxAmpurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAmpurActionPerformed
        if(user_mode){
        String amp = Gutil.getGuiData(jComboBoxAmpur);   
        if(amp.length()>4){
            Vector v = theLookupControl.listTambon("",amp);
            ComboboxModel.initComboBox(jComboBoxTambon,v);
            if(!amp.substring(2,4).equals("00"))
                Gutil.setGuiData(jTextFieldAmpur, amp.substring(2,4));
        }
        }
    }//GEN-LAST:event_jComboBoxAmpurActionPerformed
    private void jComboBoxChangwatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxChangwatActionPerformed
        if(user_mode){
        String a=Gutil.getGuiData(jComboBoxChangwat);
        if(a.length()>2){
            Vector v = theLookupControl.listAmpurSuit("",a);
            ComboboxModel.initComboBox(jComboBoxAmpur,(Vector)v.get(0));
            ComboboxModel.initComboBox(jComboBoxTambon,(Vector)v.get(1));
            Gutil.setGuiData(jTextFieldChangwat, a.substring(0,2));       
        }
        }
    }//GEN-LAST:event_jComboBoxChangwatActionPerformed
    private void jTextFieldAmpurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmpurKeyReleased
        if(!user_mode) return;
        Constant.filterTextKey(jTextFieldAmpur,2);
        String ampur = jTextFieldAmpur.getText();
        if(ampur.length()==2)
            jTextFieldTambon.requestFocus();
//        Gutil.setGuiData(jComboBoxAmpur, Gutil.getGuiData(jTextFieldChangwat)+Gutil.getGuiData(jTextFieldAmpur)+"00");
    }//GEN-LAST:event_jTextFieldAmpurKeyReleased
    private void jTextFieldAmpurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAmpurActionPerformed
    }//GEN-LAST:event_jTextFieldAmpurActionPerformed
    private void jTextFieldTambonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTambonKeyReleased
//        Gutil.setGuiData(jComboBoxTambon, Gutil.getGuiData(jTextFieldChangwat)+Gutil.getGuiData(jTextFieldAmpur)+Gutil.getGuiData(jTextFieldTambon));
    }//GEN-LAST:event_jTextFieldTambonKeyReleased
    private void jTextFieldTambonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTambonActionPerformed
    }//GEN-LAST:event_jTextFieldTambonActionPerformed
    private void jTextFieldChangwatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldChangwatActionPerformed
    }//GEN-LAST:event_jTextFieldChangwatActionPerformed
    private void jTextFieldChangwatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldChangwatKeyReleased
        if(!user_mode) return;
        Constant.filterTextKey(jTextFieldChangwat,2);
        String changwat = jTextFieldChangwat.getText();
        if(changwat.length()==2)
            jTextFieldAmpur.requestFocus();
//        Gutil.setGuiData(jComboBoxChangwat,Gutil.getGuiData(jTextFieldChangwat)+"0000");
    }//GEN-LAST:event_jTextFieldChangwatKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hosv3.gui.component.HosComboBox jComboBoxAmpur;
    private com.hosv3.gui.component.HosComboBox jComboBoxChangwat;
    private com.hosv3.gui.component.HosComboBox jComboBoxTambon;
    private javax.swing.JLabel jLabelAmpur;
    private javax.swing.JLabel jLabelChangwat;
    private javax.swing.JLabel jLabelTambon;
    private javax.swing.JPanel jPanel11;
    private com.hospital_os.utility.IntegerTextField jTextFieldAmpur;
    private com.hospital_os.utility.IntegerTextField jTextFieldChangwat;
    private com.hospital_os.utility.IntegerTextField jTextFieldTambon;
    // End of variables declaration//GEN-END:variables
     
    
    public String getChangwat()
    {
        String chang = jComboBoxChangwat.getText();
        return chang;
    }
    public String getAmpur()
    {
        String amp = jComboBoxAmpur.getText();
        return amp;
    }
    
    public String getTambon()
    {
        String tamb = jComboBoxTambon.getText();
        return tamb;
    }
    public void setDefaultAddress(String chan,String amp,String tamb)
    {
        this.chan = chan;
        this.amp = amp;
        this.tamb = tamb;
    }
//    public void setAddress(String chan,String amp,String tamb)
//    {
//        ////Constant.println(""site.changwat, site.amphor,site.tambon"+chan + amp +tamb);
//        if(chan.length()==2 && amp.length()==2 && tamb.length()==2){
//            chan = chan+ "0000";
//            amp = chan+ amp+"00";
//            tamb = chan+ amp+ tamb;
//        }
//        jComboBoxChangwat.setText(chan);
//        jComboBoxAmpur.setText(amp);
//        jComboBoxTambon.setText(tamb);
//    }
    

    public void setAddress(String chan,String amp,String tamb)
    {
//        Constant.println("setAddress" +  chan);
//        Constant.println("setAddress" +  amp);
//        Constant.println("setAddress" +  tamb);
        if(chan==null || chan.equals("")
            || amp==null || amp.equals("")
            || tamb==null || tamb.equals(""))
            return;
        if(chan.length()==2)
            tamb = chan+amp+tamb;
        setAddress(tamb);
    }
    public void setAddress(String tamb)
    {
        if(tamb.length()==2)
            tamb = chan+amp+tamb;
        if(tamb.length()==6){
            amp = tamb.substring(0,4)+"00";
            chan = tamb.substring(0,2)+"0000";
        }
        setUserMode(false);
        Vector v = theLookupControl.listCatAddressByCode(tamb);
        jComboBoxChangwat.setText(chan);
        jTextFieldChangwat.setText(chan.substring(0,2));
        ComboboxModel.initComboBox(jComboBoxAmpur,(Vector)v.get(0));
        ComboboxModel.initComboBox(jComboBoxTambon,(Vector)v.get(1));
        jTextFieldAmpur.setText(amp.substring(2,4));
        jTextFieldTambon.setText(tamb.substring(4));
        jComboBoxAmpur.setText(amp);
        jComboBoxTambon.setText(tamb);
        setUserMode(true);
    }
    
    public static void main(String[] argc){
        US jf = new US();
        javax.swing.JTabbedPane jt = new javax.swing.JTabbedPane();
        PanelCatAddress psd5 = new PanelCatAddress();
        HosControl hc = new HosControl();
        psd5.setControl(hc,jf);
        psd5.setAddress("10","02","02");
        jf.setSize(200, 200);
        jt.add(psd5);
        jf.getContentPane().setLayout(new java.awt.BorderLayout());
        jf.getContentPane().add(jt,java.awt.BorderLayout.CENTER);
        
        jf.setVisible(true);
    }

    private void setUserMode(boolean b) {
        user_mode = b;
        jComboBoxAmpur.setPauseMode(!user_mode);
        jComboBoxChangwat.setPauseMode(!user_mode);
        jComboBoxTambon.setPauseMode(!user_mode);
    }
}