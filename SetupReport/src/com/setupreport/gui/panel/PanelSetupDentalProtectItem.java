/*
 * PanelSetupDentalProtectItem.java
 *
 * Created on 6 �չҤ� 2549, 16:49 �.
 */

package com.setupreport.gui.panel;

import com.setupreport.utility.TableModelGUI;
import com.setupreport.utility.Language;
import com.setupreport.object.DentalProtectItem;
import com.setupreport.gui.dialog.DialogSearchItem;
import com.setupreport.usecase.SaveDentalProtectItem;
import com.setupreport.manage.HosManage;
import com.setupreport.object.*;

import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.*;
/**
 *
 * @author  Ojika
 */
public class PanelSetupDentalProtectItem extends javax.swing.JPanel implements SaveDentalProtectItem
{
    
    /** Creates new form PanelSetupDentalProtectItem */
    HosManage theHosManage;
    TableModelGUI theTableModelGUI;
    String[] colName;
    final String panelname = "DentalProtectItem";
    int language = 1;
    /**���Ǩ�ͺ��Ң����� item ������͡����Ѻ����������������㹢���������������*/
    int status = 1;
    
    Vector vDentalProtectItem;
    DentalProtectItem theDentalProtectItem;
    
    public PanelSetupDentalProtectItem(HosManage hosManage)
    {
        this.theHosManage = hosManage;
        initComponents();
        setLanguage();
        this.theHosManage.theHosControl.theHosSubject.theDentalProtectItemSubject.registerMainReportManage(this);
        Language.getTextBundle(panelname, language);
        searchDentalProtectItem();
    }
    
    public String getPanelName()
    {
        return panelname;
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
        jPanelTop = new javax.swing.JPanel();
        jLabelSetupName = new javax.swing.JLabel();
        jPanelLeft = new javax.swing.JPanel();
        jPanelSearch = new javax.swing.JPanel();
        jLabelSearch = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jPanelShowList = new javax.swing.JPanel();
        jScrollPaneShowList = new javax.swing.JScrollPane();
        jTableShowList = new javax.swing.JTable();
        jPanelRight = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelCode = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jTextFieldDescrpiton = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelSetupName.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelSetupName.setText("DentalProtectItem");
        jPanelTop.add(jLabelSetupName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanelTop, gridBagConstraints);

        jPanelLeft.setLayout(new java.awt.GridBagLayout());

        jPanelLeft.setMinimumSize(new java.awt.Dimension(200, 53));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(200, 433));
        jPanelSearch.setLayout(new java.awt.GridBagLayout());

        jLabelSearch.setText("Search");
        jPanelSearch.add(jLabelSearch, new java.awt.GridBagConstraints());

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanelSearch.add(jTextFieldSearch, gridBagConstraints);

        jButtonSearch.setText("Search");
        jButtonSearch.setMaximumSize(new java.awt.Dimension(75, 24));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(75, 24));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(75, 24));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelSearch.add(jButtonSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanelLeft.add(jPanelSearch, gridBagConstraints);

        jPanelShowList.setLayout(new java.awt.GridBagLayout());

        jTableShowList.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableShowList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableShowListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableShowListMouseReleased(evt);
            }
        });

        jScrollPaneShowList.setViewportView(jTableShowList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelShowList.add(jScrollPaneShowList, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanelLeft.add(jPanelShowList, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        jPanel1.add(jPanelLeft, gridBagConstraints);

        jPanelRight.setLayout(new java.awt.GridBagLayout());

        jPanelRight.setMinimumSize(new java.awt.Dimension(350, 24));
        jPanelRight.setPreferredSize(new java.awt.Dimension(350, 24));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabelCode.setText("Code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel2.add(jLabelCode, gridBagConstraints);

        jLabelDescription.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabelDescription, gridBagConstraints);

        jTextFieldCode.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 5);
        jPanel2.add(jTextFieldCode, gridBagConstraints);

        jTextFieldDescrpiton.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 5);
        jPanel2.add(jTextFieldDescrpiton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelRight.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel3.add(jButtonAdd, gridBagConstraints);

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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel3.add(jButtonDelete, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelRight.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 3);
        jPanel1.add(jPanelRight, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jTableShowListMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableShowListMouseReleased
    {//GEN-HEADEREND:event_jTableShowListMouseReleased
        // ���͡��¡�õ�Ǩ�ѡ�Ңͧ�ѹ�������ͧ�ѹ
        selectDentalProtectItem(jTableShowList.getSelectedRow());
    }//GEN-LAST:event_jTableShowListMouseReleased

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddActionPerformed
    {//GEN-HEADEREND:event_jButtonAddActionPerformed
        // ������¡�õ�Ǩ�ѡ�Ңͧ�ѹ�������ͧ�ѹ
        addDentalProtectItem();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeleteActionPerformed
    {//GEN-HEADEREND:event_jButtonDeleteActionPerformed
        // ź��¡�÷�����͡
        int confirm_del = JOptionPane.showConfirmDialog(this,Language.getTextBundle("confirm_del_effect_report", language),Language.getTextBundle("confirm_del", language),JOptionPane.YES_NO_OPTION);
        
        if(confirm_del == 0)
        {
            deleteDentalProtectItem();
        }
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableShowListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableShowListMouseClicked
    {//GEN-HEADEREND:event_jTableShowListMouseClicked
        // ���͡��¡�õ�Ǩ�ѡ�Ңͧ�ѹ�������ͧ�ѹ
        selectDentalProtectItem(jTableShowList.getSelectedRow());
    }//GEN-LAST:event_jTableShowListMouseClicked

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldSearchActionPerformed
    {//GEN-HEADEREND:event_jTextFieldSearchActionPerformed
        // ������¡�õ�Ǩ�ѡ�Ңͧ�ѹ�������ͧ�ѹ
        searchDentalProtectItem();
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSearchActionPerformed
    {//GEN-HEADEREND:event_jButtonSearchActionPerformed
        // ������¡�õ�Ǩ�ѡ�Ңͧ�ѹ�������ͧ�ѹ
        searchDentalProtectItem();
    }//GEN-LAST:event_jButtonSearchActionPerformed
    
    /**
     * �ʴ� Dialog ����Ѻ���͡��¡�õ�Ǩ�ѡ��
     * @Author Ojika
     * @Date 07/03/2549 
     **/
    private void addDentalProtectItem()
    {
        DialogSearchItem dialog = new DialogSearchItem(new JFrame(), true,this.theHosManage, 0);
        dialog.setVisible(true);
    }
    
    /**
     * ź��¡�÷�����͡�͡�ҡ�ҹ������
     * @Author Ojika
     * @Date 07/03/2549
     **/
    private void deleteDentalProtectItem()
    {
        if(this.theDentalProtectItem != null)
        {
            // �觤�Ңͧ Object �ź
            this.theHosManage.theHosControl.theDentalProtectItemControl.deleteDentalProtectItemByKeyId(this.theDentalProtectItem);
            // �駺͡ʶҹС��ź��¡��         
            
            // ���¡�����ա����
            searchDentalProtectItem();
        }        
    }    
    
    /**
     * ���͡��¡�õ�Ǩ�ѡ�ҷѹ���������ͧ ��� �ʴ���������´
     * @Author Ojika
     * @Date 07/03/2549
     **/
     private void selectDentalProtectItem(int row)
     {
        if(row > -1)
        {
            // �ա�����͡�ҡ���ҧ
            if(this.vDentalProtectItem != null)
            {                
                this.theDentalProtectItem = (DentalProtectItem)vDentalProtectItem.get(row);
                // �ʴ���������´������    
                setObjectToData();
            }
        }
     }
     
     /**
      * �ʴ���Ҩҡ Object ���Ѻ GUI
      * @Author Ojika
      * @Date 07/03/2549
      **/
     private void setObjectToData()
     {
        if(this.theDentalProtectItem != null)
        {
            jTextFieldCode.setText(this.theDentalProtectItem.dental_protect_item_number);
            jTextFieldDescrpiton.setText(this.theDentalProtectItem.dental_protect_item_common_name);
        }
        else
        {
            clearGUI();
        }
     }
     
     /**
      * ����������ź� Gui 
      * @Author Ojika
      * @Date 07/03/2549
      **/
     private void clearGUI()
     {
        jTextFieldCode.setText("");
        jTextFieldDescrpiton.setText("");
     }
     
    /**
     * ����Ѻ������¡�õ�Ǩ�ѡ�Ңͧ�ѹ�������ͧ�ѹ ��� �觢�������ʴ�㹵��ҧ
     * @Author Ojika
     * @Date 07/03/2549
     **/
    private void searchDentalProtectItem()
    {
        // ������¡�� ���� keyword 令�
        this.vDentalProtectItem = new Vector();
        String keyword = jTextFieldSearch.getText().trim();
        
        this.vDentalProtectItem = this.theHosManage.theHosControl.theDentalProtectItemControl.searchDentalProtectItem(keyword);
        
        // �觢����ŷ����ҡ��ä��ҹ����ʴ��ѧ���ҧ
        setTableDentalProtectItem(this.vDentalProtectItem);
        
        this.theDentalProtectItem = null;
        clearGUI();
    }
    
    /**
     * �ʴ������ŷ����ҡ��ä���㹵��ҧ
     * @author Ojika
     * @Date 07/03/2549
     **/
    private void setTableDentalProtectItem(Vector vData)
    {       
        theTableModelGUI = new TableModelGUI(colName, 0);
        if(vData != null)
        {
            int size = vData.size();
            theTableModelGUI = new TableModelGUI(colName, size);
            theDentalProtectItem = null;
            for(int i = 0 ; i < size ;i++)
            {
                theDentalProtectItem = (DentalProtectItem)vData.get(i);
                theTableModelGUI.setValueAt(theDentalProtectItem.dental_protect_item_number,i, 0);
                theTableModelGUI.setValueAt(theDentalProtectItem.dental_protect_item_common_name,i, 1);
                
                theDentalProtectItem = null;
            }
            
        }
        
        jTableShowList.setModel(theTableModelGUI);
        
        jTableShowList.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTableShowList.getColumnModel().getColumn(1).setPreferredWidth(100);
    }    
    
    /**
     * ����Ѻ set �������Ѻ GUI
     * @Author Ojika
     * @Date 07/03/2549
     **/
    private void setLanguage()
    {
        colName = new String[] {Language.getTextBundle("Code",language),Language.getTextBundle("Description",language)};
        
        jLabelSetupName.setText(Language.getTextBundle(jLabelSetupName.getText(),language));
        
        jLabelSearch.setText(Language.getTextBundle(jLabelSearch.getText(),language));
        jButtonSearch.setText(Language.getTextBundle(jButtonSearch.getText(),language));
        
        jLabelCode.setText(Language.getTextBundle(jLabelCode.getText(),language));
        jLabelDescription.setText(Language.getTextBundle(jLabelDescription.getText(),language));
        jButtonAdd.setText(Language.getTextBundle(jButtonAdd.getText(),language));
        jButtonDelete.setText(Language.getTextBundle(jButtonDelete.getText(),language));
    }

    /**
     * �Ѻ Vector �ͧ Item ������͡���� save ����¡�÷ѹ�������ͧ�ѹ
     * @Author Ojika
     * @Date 08/03/2549
     **/
    public void notifySaveDentalProtectItem(Vector vItem)
    {
        if(vItem != null)
        {
            System.out.println(vItem.size());
            Item item = new Item();
            int size = vItem.size();
            for(int i =0;i<size;i++)
            {
                item = (Item)vItem.get(i);
                
                theDentalProtectItem = new DentalProtectItem();
                
                theDentalProtectItem.b_item_id = item.getObjectId();
                theDentalProtectItem.dental_protect_item_number = item.item_id;
                theDentalProtectItem.dental_protect_item_common_name = item.common_name;
                checkSameData(theDentalProtectItem);
          
                theDentalProtectItem = null;
            }
            item = null;
        }
        
        //���¡ Function ��ä�����������¹���������   
        searchDentalProtectItem();
    }
    
    private void checkSameData(DentalProtectItem theDPI)
    {
        if(this.vDentalProtectItem != null)
        {
            int size = this.vDentalProtectItem.size();
            if(size > 0)
            {
                for(int i =0;i<size;i++)
                {
                    if(!theDPI.dental_protect_item_number.equals(((DentalProtectItem)this.vDentalProtectItem.get(i)).dental_protect_item_number))
                    {
                        status = 1;
                    }
                    else
                    {
                        status = 0;
                        JOptionPane.showMessageDialog(this,Language.getTextBundle("Same_Item", language) + theDPI.dental_protect_item_common_name ,Language.getTextBundle("Warning", language),JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
                if(status != 0)
                {
                    // ����բ����ū����仺ѹ�֡
                    this.theHosManage.theHosControl.theDentalProtectItemControl.saveDentalProtectItem(theDPI);                  
                }
            }
        }
        else
        {
            // ����բ���������Ѻ��Ǩ�ͺ��仺ѹ�֡
            this.theHosManage.theHosControl.theDentalProtectItemControl.saveDentalProtectItem(theDPI);
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSetupName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JPanel jPanelShowList;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPaneShowList;
    private javax.swing.JTable jTableShowList;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldDescrpiton;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
    
}
