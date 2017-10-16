/*
 * PanelSetupWaterType.java
 *
 * Created on 15 �Զع�¹ 2548, 15:04 �.
 */

package com.pcu.gui.panel.setup;

import java.awt.event.KeyEvent;
import java.util.*;
import com.hospital_os.utility.*;
import com.pcu.utility.*;
import com.pcu.object.*;
import com.pcu.control.HosManage;
import com.pcu.control.SetupPcuControl;
/**
 *
 * @author  amp
 */
public class PanelSetupWaterType extends javax.swing.JPanel //implements setEnableForLiftResp
{
    private SetupPcuControl theSetupPcuControl;
    private WaterType theWaterType;
    private Vector vWaterType = new Vector();
    private boolean Forlift = false;
    private HosManage theHM;
    /** Creates new form PanelSetupWaterType */
    public PanelSetupWaterType(HosManage hm) 
    {
        theHM = hm;
        theSetupPcuControl = hm.theHosControl.theSetupPcuControl;

        //hm.theHosControl.theSetupSubject.addForLiftAttach(this);/*�Ѻ notify �ҡ hospital_os ����� user �͡��� ��ҹ��ԧ ����ź�е�ͧ�ͧ������*/

        initComponents();
        setLanguage();
        initDatas();
    }
    
    private void initDatas()
    {
        setEnableGui(false);
    }
 /**��㹡�á�˹�������ź����ö�ӧҹ���������
     *���觤���Ҩҡ module hospitalos �ѧ���㹵�ͧ�ӧҹ���� ����ͧ��ҹ
     *@param enabled �� boolean ���˹� ��� true ������ ź����ö�ӧҹ�� ����� false �����ӧҹ
     */
    public void setEnableButtonSetupPanel(boolean enabled)
    {
        this.Forlift=enabled;
    }   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fontTitle1 = new com.pcu.utility.FontTitle();
        defaultFont1 = new com.hospital_os.gui.font.DefaultFont();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jCheckBoxSearchActive = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableWaterType = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jCheckBoxActive = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(fontTitle1);
        jLabel1.setText("WaterTypeSetup");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 0, 11);
        add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(300, 25));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 404));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(defaultFont1);
        jLabel2.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel2, gridBagConstraints);

        jTextFieldSearch.setFont(defaultFont1);
        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        jPanel4.add(jTextFieldSearch, gridBagConstraints);

        jButtonSearch.setFont(defaultFont1);
        jButtonSearch.setText("Search");
        jButtonSearch.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSearch.setMaximumSize(new java.awt.Dimension(67, 25));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(67, 25));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(67, 25));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(jButtonSearch, gridBagConstraints);

        jCheckBoxSearchActive.setFont(defaultFont1);
        jCheckBoxSearchActive.setSelected(true);
        jCheckBoxSearchActive.setText("Active");
        jCheckBoxSearchActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSearchActiveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 0, 0);
        jPanel4.add(jCheckBoxSearchActive, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jTableWaterType.setFont(defaultFont1);
        jTableWaterType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableWaterType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableWaterTypeMouseReleased(evt);
            }
        });
        jTableWaterType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableWaterTypeKeyReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jTableWaterType);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel2.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 0);
        add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(350, 25));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 25));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("\u0e23\u0e32\u0e22\u0e25\u0e30\u0e40\u0e2d\u0e35\u0e22\u0e14"));
        jLabel3.setFont(defaultFont1);
        jLabel3.setText("Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel6.add(jLabel3, gridBagConstraints);

        jTextFieldNumber.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 11, 0, 5);
        jPanel6.add(jTextFieldNumber, gridBagConstraints);

        jLabel4.setFont(defaultFont1);
        jLabel4.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel6.add(jLabel4, gridBagConstraints);

        jTextFieldName.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 11, 0, 5);
        jPanel6.add(jTextFieldName, gridBagConstraints);

        jCheckBoxActive.setFont(defaultFont1);
        jCheckBoxActive.setText("Active");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 5, 5);
        jPanel6.add(jCheckBoxActive, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jPanel6, gridBagConstraints);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jButtonAdd.setFont(defaultFont1);
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/plus16.gif")));
        jButtonAdd.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAdd.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(jButtonAdd, gridBagConstraints);

        jButtonDelete.setFont(defaultFont1);
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/minus16.gif")));
        jButtonDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonDelete.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonDelete.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonDelete.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        jPanel7.add(jButtonDelete, gridBagConstraints);

        jButtonSave.setFont(defaultFont1);
        jButtonSave.setText("Save");
        jButtonSave.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSave.setMaximumSize(new java.awt.Dimension(67, 25));
        jButtonSave.setMinimumSize(new java.awt.Dimension(67, 25));
        jButtonSave.setPreferredSize(new java.awt.Dimension(67, 25));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        jPanel3.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        add(jPanel3, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jTableWaterTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableWaterTypeKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
            select();
    }//GEN-LAST:event_jTableWaterTypeKeyReleased

    private void jTableWaterTypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableWaterTypeMouseReleased
        select();
    }//GEN-LAST:event_jTableWaterTypeMouseReleased

    private void jCheckBoxSearchActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSearchActiveActionPerformed
        search();
    }//GEN-LAST:event_jCheckBoxSearchActiveActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        search();
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        search();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        save();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        delete();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        add();
    }//GEN-LAST:event_jButtonAddActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private com.pcu.utility.FontTitle fontTitle1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JCheckBox jCheckBoxActive;
    private javax.swing.JCheckBox jCheckBoxSearchActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableWaterType;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
    
    
    private void setLanguage()
    {
        /*jLabel*/
        jLabel1.setText(GutilPCU.getTextBundle(jLabel1.getText()));
        jLabel2.setText(GutilPCU.getTextBundle(jLabel2.getText()));
        jLabel3.setText(GutilPCU.getTextBundle(jLabel3.getText()));
        jLabel4.setText(GutilPCU.getTextBundle(jLabel4.getText()));
        
        /*jButton*/
        jButtonSearch.setText(GutilPCU.getTextBundle(jButtonSearch.getText()));
        jButtonAdd.setText(GutilPCU.getTextBundle(jButtonAdd.getText()));
        jButtonDelete.setText(GutilPCU.getTextBundle(jButtonDelete.getText()));
        jButtonSave.setText(GutilPCU.getTextBundle(jButtonSave.getText()));
                
        /*jCheckBox*/
        jCheckBoxSearchActive.setText(GutilPCU.getTextBundle(jCheckBoxSearchActive.getText()));
        jCheckBoxActive.setText(GutilPCU.getTextBundle(jCheckBoxActive.getText()));
    }
    
    private void save()
    {
        this.theWaterType.number = this.jTextFieldNumber.getText();
        this.theWaterType.description = this.jTextFieldName.getText();
        if("".equalsIgnoreCase(theWaterType.number))
        {
            theHM.theHosInf.setStatus(GutilPCU.getTextBundle("��س��к��ӴѺ"), 2);
            return;
        }
        if("".equalsIgnoreCase(theWaterType.description ))
        {
            theHM.theHosInf.setStatus(GutilPCU.getTextBundle("��سҡ�͡��������´"), 2);
            return;
        }
        if(this.jCheckBoxActive.isSelected())
            this.theWaterType.active = "1";
        else
            this.theWaterType.active = "0";
        
        //��Ǩ�ͺ������������ū�� �� 20/12/2549
        Vector vList = new Vector();
        vList=  this.theSetupPcuControl.listWaterTypeByNameOrNumberAndActive("", this.theWaterType.active);
        for(int i=0,size = vList.size();i <size; i++)
        {
            WaterType wt = (WaterType)vList.elementAt(i);
            if(this.theWaterType.getObjectId()==null
                    && this.theWaterType.description.equalsIgnoreCase(wt.description))
            {
                this.theHM.theHosInf.setStatus("���ͻ��������觹�ӹ��������㹰ҹ����������", 2);
                jTextFieldName.requestFocus();
                return;
            }
            else if(this.theWaterType.description.equalsIgnoreCase(wt.description)
            &&!this.theWaterType.getObjectId().equalsIgnoreCase(wt.getObjectId()))
            {
                this.theHM.theHosInf.setStatus("���ͻ��������觹�ӹ��������㹰ҹ����������", 2);
                jTextFieldName.requestFocus();
                return;
            }
            if(this.theWaterType.getObjectId()==null
                    && this.theWaterType.number.equalsIgnoreCase(wt.number))
            {
                this.theHM.theHosInf.setStatus("�ӴѺ���������㹰ҹ����������", 2);
                jTextFieldNumber.requestFocus();
                return;
            }
            else if(this.theWaterType.number.equalsIgnoreCase(wt.number)
            &&!this.theWaterType.getObjectId().equalsIgnoreCase(wt.getObjectId()))
            {
                theHM.theHosInf.setStatus("�ӴѺ���������㹰ҹ����������", 2);
                jTextFieldNumber.requestFocus();
                return;
            }
        }
        this.theSetupPcuControl.saveWaterType(this.theWaterType);
        this.theWaterType = null;
        
        setEnableGui(false);
        search();
    }
    
    private void clearGui()
    {
        this.jTextFieldNumber.setText("");
        this.jTextFieldName.setText("");
        this.jCheckBoxActive.setSelected(true);           
    }
    
    private void setEnableGui(boolean flag)
    {
        this.jTextFieldNumber.setEnabled(flag);
        this.jTextFieldName.setEnabled(flag);
        this.jCheckBoxActive.setEnabled(flag);
        if(this.Forlift)
            this.jButtonDelete.setEnabled(false);
        else
            this.jButtonDelete.setEnabled(flag);
        this.jButtonSave.setEnabled(flag);
    }
    
    private void search()
    {
        /***����ࢵ����������ҹ***/
        String search = this.jTextFieldSearch.getText();  
        String active = "0";
        if(this.jCheckBoxSearchActive.isSelected())
            active = "1";
        this.vWaterType =  this.theSetupPcuControl.listWaterTypeByNameOrNumberAndActive(search,active);
        
        /***SetTable***/
        String[] col = {GutilPCU.getTextBundle("Number"),
                    GutilPCU.getTextBundle("Description")};
                    
        WaterType waterTypeTemp = new WaterType();
        TaBleModel tm;
        
        if(this.vWaterType != null)
        {   
            tm = new TaBleModel(col,this.vWaterType.size());
            for(int i=0, size=this.vWaterType.size(); i<size; i++)
            {  
                waterTypeTemp = (WaterType)this.vWaterType.get(i);
                tm.setValueAt(waterTypeTemp.number,i,0); 
                tm.setValueAt(waterTypeTemp.description,i,1);                
            }
        }
        else
        {   
            tm= new TaBleModel(col,0);
        } 
        
        waterTypeTemp = null;
        this.jTableWaterType.setModel(tm);  
        jTableWaterType.setRowHeight(20);
        /***SetTableDefault***/
        jTableWaterType.getColumnModel().getColumn(0).setPreferredWidth(80);      /*����ࢵ����������ҹ*/
        jTableWaterType.getColumnModel().getColumn(1).setPreferredWidth(200);     /*����ࢵ�����*/        
    }
    
    private void select()
    {
        int row = this.jTableWaterType.getSelectedRow();
        this.theWaterType = (WaterType)this.vWaterType.get(row); 
        
        this.jTextFieldName.setText(this.theWaterType.description);
        this.jTextFieldNumber.setText(this.theWaterType.number);
        if(this.theWaterType.active.equals("1"))
            this.jCheckBoxActive.setSelected(true);
        else
            this.jCheckBoxActive.setSelected(false); 
        
        setEnableGui(true);
    }
    
    private void delete()
    {
        this.theSetupPcuControl.deleteWaterType(this.theWaterType);
        this.theWaterType = null;
        
        setEnableGui(false);
        clearGui();
        search();
    }
    
    private void add()
    {
        clearGui();
        setEnableGui(true);
        this.theWaterType = new WaterType();
    }
    
    public void notifysetEnableForLift(boolean b)
    {
        this.jButtonDelete.setVisible(false);
    }
}