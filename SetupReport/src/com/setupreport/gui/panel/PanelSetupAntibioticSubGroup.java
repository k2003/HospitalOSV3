/*
 * PanelSetupAntibiotic.java
 *
 * Created on 22 ���Ҥ� 2548, 11:09 �.
 */

package com.setupreport.gui.panel;
import com.setupreport.utility.ComboFix;
import com.setupreport.utility.ComboboxModel;
import java.util.Vector;
import javax.swing.*;
import com.setupreport.manage.HosManage;
import com.setupreport.utility.TableModelGUI;
import com.setupreport.object.AricSubGroup;
import com.setupreport.utility.Language;
import com.setupreport.usecase.connection.ManageGUI;
/**
 *
 * @author  tong(Padungrat)
 */
public class PanelSetupAntibioticSubGroup extends javax.swing.JPanel implements 
ManageGUI{
    final String panelname = "AntibioticSubGroup";
    HosManage theHosManage;
    int language =1;
    ComboFix theComboFix;
    AricSubGroup theAricSubGroup, theAricSubGroupTemp;
    Vector vAricSubGroup,vAricGroup;
    String[] colName;
    TableModelGUI theTableModelGUI;
    
    public PanelSetupAntibioticSubGroup(HosManage hosManage) {
        this.theHosManage = hosManage;
        initComponents();    
        
        //ojika 28 Feb 2007
        jButtonAdd.setVisible(false);
        jButtonDelete.setVisible(false);
        jButtonSave.setVisible(false);
        
        setLanguage();
        Language.getTextBundle(panelname, language);
        initComboBox();
        showDataToTable(null);
        searchDataAndShowDataToTable(); //ojika 28 Feb 2007
    }
    
    
    private void initComboBox()
    {
        
        vAricGroup = theHosManage.theHosControl.theAricGroupControl.selectAricGroupShowComboBox();
        if(vAricGroup == null)
        {
            vAricGroup = new Vector();
            vAricGroup.add(theComboFix);
        }
        //jComboBoxAricGroup
        ComboboxModel.initComboBox(jComboBoxAricGroup, vAricGroup);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        jPanel1 = new javax.swing.JPanel();
        jLabelCode = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jTextFieldDescrpiton = new javax.swing.JTextField();
        jLabelAricGroup = new javax.swing.JLabel();
        jComboBoxAricGroup = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabelSetupName.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelSetupName.setText("AntibioticSubGroup");
        jPanelTop.add(jLabelSetupName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(jPanelTop, gridBagConstraints);

        jPanelLeft.setLayout(new java.awt.GridBagLayout());

        jPanelLeft.setMinimumSize(new java.awt.Dimension(200, 53));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(200, 433));
        jPanelSearch.setLayout(new java.awt.GridBagLayout());

        jLabelSearch.setText("Search");
        jPanelSearch.add(jLabelSearch, new java.awt.GridBagConstraints());

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

            },
            new String [] {

            }
        ));
        jTableShowList.addMouseListener(new java.awt.event.MouseAdapter() {
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
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 3, 0);
        jPanelLeft.add(jPanelShowList, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        add(jPanelLeft, gridBagConstraints);

        jPanelRight.setLayout(new java.awt.GridBagLayout());

        jPanelRight.setMinimumSize(new java.awt.Dimension(350, 24));
        jPanelRight.setPreferredSize(new java.awt.Dimension(350, 24));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelCode.setText("Code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel1.add(jLabelCode, gridBagConstraints);

        jLabelDescription.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(jLabelDescription, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        jPanel1.add(jTextFieldCode, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 0);
        jPanel1.add(jTextFieldDescrpiton, gridBagConstraints);

        jLabelAricGroup.setText("AntibioticGroup");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(jLabelAricGroup, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 0);
        jPanel1.add(jComboBoxAricGroup, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelRight.add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/plus16.gif")));
        jButtonAdd.setEnabled(false);
        jButtonAdd.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAdd.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jPanel2.add(jButtonAdd, new java.awt.GridBagConstraints());

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/minus16.gif")));
        jButtonDelete.setEnabled(false);
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel2.add(jButtonDelete, gridBagConstraints);

        jButtonSave.setText("Save");
        jButtonSave.setMaximumSize(new java.awt.Dimension(75, 24));
        jButtonSave.setMinimumSize(new java.awt.Dimension(75, 24));
        jButtonSave.setPreferredSize(new java.awt.Dimension(75, 24));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel2.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jPanelRight.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 3);
        add(jPanelRight, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        deleteData();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        addData();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        saveData();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTableShowListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableShowListMouseReleased
        selectShowData(jTableShowList.getSelectedRow());
    }//GEN-LAST:event_jTableShowListMouseReleased

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        searchDataAndShowDataToTable();
    }//GEN-LAST:event_jButtonSearchActionPerformed
    
    /**��㹡��ź�����Ţͧ�������͹�ͧ��¡�� ARIC*/
    public void deleteData()
    {
        //ź�������͡
        deleteDataToDB();
        //clear GUI
        //clear Object
        addData();
        searchDataAndShowDataToTable();
    }
    
    /**��㹡��ź�������͡�Ұҹ������*/
    private void deleteDataToDB()
    {
        if(theAricSubGroup != null)
        {
            this.theHosManage.theHosControl.theAricSubGroupControl.deleteAricSubGroup(theAricSubGroup);
        }
    }
    /**��㹡�����������Ţͧ��������¢ͧ��¡�� ARIC*/
    public void addData()
    {
        //clear GUI
        clearGUI();
        //clear Object
        clearObject();
        setEnableGUI(true);
        jTextFieldCode.requestFocus();
        
    }
    
    /**
     *  ��㹡�úѹ�֡������
     */
    public void saveData()
    {
        if(setGUIToDataObject())
        {
            if(checkDataSameInDB())
            {
                saveDataToDB();
                searchDataAndShowDataToTable();
                setSelectDataInTable();
            }
        }
    }
    /**
     *  ��㹡�õ�Ǩ�ͺ��� code ��� ��͸Ժ�� ��ӡѹ�Ѻ���������㹰ҹ������������� ����Դ��ë�ӡѹ
     *  ��������� false �������ӡѹ��������� true
     *  @return boolean ����� true ������ӡѹ ����� false �ӫ�ӡѹ
     */
    private boolean checkDataSameInDB()
    {
        boolean result = true;
        
        //��Ǩ�ͺ��� code ��ӡѹ�������
        
       
        if(theAricSubGroup != null)
        { // ����� Object �����������
            if(theAricSubGroup.getObjectId() == null)
            {
              // �� Object ���� 
                // ����Ǩ�ͺ�������������㹰ҹ������
                result = this.theHosManage.theHosControl.theAricSubGroupControl.checkSameAricSubGroupCode(theAricSubGroup.number);
                   // ��ҫ�ӡѹ��� �� false
                   // ����ӡѹ ����÷ӧҹ
              
            }
            else
            {
                // �� Object ���
                int size = this.vAricGroup.size();
                for(int i = 0 ; i < size ; i++)
                {
                    theAricSubGroupTemp = (AricSubGroup)vAricSubGroup.get(i);
                    if(theAricSubGroupTemp.getObjectId().equalsIgnoreCase(theAricSubGroup.getObjectId()))
                    {    //��Ǩ�ͺ����ա������¹�ŧ code �������
                        if(!theAricSubGroupTemp.number.toUpperCase().equalsIgnoreCase(theAricSubGroup.number.trim().toUpperCase()))
                        {
                             // ����¹�ŧ
                             result = this.theHosManage.theHosControl.theAricSubGroupControl.checkSameAricSubGroupCode(theAricSubGroup.number);
                
                          
                               //����Ǩ�ͺ�������������㹰ҹ������
                               // ��ҫ�ӡѹ��� �� false
                           // �������¹�ŧ
                               //����÷ӧҹ
                        }
                    }
                    theAricSubGroupTemp = null;
                }
            }
        
            if(!result)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"SameCode");
                setFocusAricSubGroupCode();
            }
            else
            {
                //��Ǩ�ͺ��� ���ͫ�ӡѹ�������
                // ����� Object �����������
                if(theAricSubGroup.getObjectId() == null)
                {
                  // �� Object ���� 
                    // ����Ǩ�ͺ�������������㹰ҹ������
                    result = this.theHosManage.theHosControl.theAricSubGroupControl.checkSameAricSubGroupDescription(theAricSubGroup.description);
                       // ��ҫ�ӡѹ��� �� false
                       // ����ӡѹ ����÷ӧҹ

                }
                else
                {
                    // �� Object ���
                    int size = this.vAricGroup.size();
                    for(int i = 0 ; i < size ; i++)
                    {
                        theAricSubGroupTemp = (AricSubGroup)vAricSubGroup.get(i);
                        if(theAricSubGroupTemp.getObjectId().equalsIgnoreCase(theAricSubGroup.getObjectId()))
                        {    //��Ǩ�ͺ����ա������¹�ŧ ��͸Ժ�� �������
                            if(!theAricSubGroupTemp.description.toUpperCase().equalsIgnoreCase(theAricSubGroup.description.trim().toUpperCase()))
                            {
                                 // ����¹�ŧ
                                 result = this.theHosManage.theHosControl.theAricSubGroupControl.checkSameAricSubGroupDescription(theAricSubGroup.description);


                                   //����Ǩ�ͺ�������������㹰ҹ������
                                   // ��ҫ�ӡѹ��� �� false
                               // �������¹�ŧ
                                   //����÷ӧҹ
                            }
                        }
                        theAricSubGroupTemp = null;
                    }
                }

                
                
                if(!result)
                {
                    javax.swing.JOptionPane.showMessageDialog(this,"SameDescription");
                    setFocusAricSubGroupDescription();
                }
            }
        
        }
        else
        {
            result = false;
        }
        return result;
        
    }
    /**��㹡�����͡������㹵��ҧ*/
    public void setSelectDataInTable()
    {
        int row = -1;
        jTableShowList.clearSelection();
        if(vAricSubGroup !=null)
        {
            int size = vAricSubGroup.size();
            for(int i =0; i < size;i++)
            {
                theAricSubGroupTemp = (AricSubGroup)vAricSubGroup.get(i);
                if(theAricSubGroupTemp.getObjectId().equalsIgnoreCase(theAricSubGroup.getObjectId()))
                {
                    row = i ;
                    break;
                }
            }
        }
        
        if(row >-1)
        {
            jTableShowList.setRowSelectionInterval(row,row);
            selectShowData(row);
        }
   
    }
    
    /**�ѹ�֡ŧ�ҹ������*/
     private void saveDataToDB()
    {
        this.theHosManage.theHosControl.theAricSubGroupControl.saveAricSubGroup(theAricSubGroup);
    }
    /**��㹡�� Clear �����ŷ�����躹 GUI*/
    private void clearGUI()
    {
        jTextFieldCode.setText("");
        jTextFieldDescrpiton.setText("");
    }
    /**��㹡�� Clear ��ҷ�� Object ����ͧ�������������� null ������ ��ͧ��ҧ ������ 0*/
    private void clearObject()
    {
        theAricSubGroup = null;
    }
    
    /**��㹡�� ��˹������� �ǡ, ź ��кѹ�֡ ����ö�ӧҹ���������*/
    private void setEnableButton()
    {
    }
    
    /**
     *��˹���� Gui �������ö����� 㹡óշ�����͡��¡�� AricSubGroup �����
     *key id 13 ��ѡ
     *@param enabled �� boolean ���͡�˹�ʶҹС�� Enable
     *       ��� enabled �� true ��� enable
     *       ��� enabled �� false ��� disable
     */
    private void setEnableGUI(boolean enabled)
    {
        jTextFieldCode.setEnabled(enabled);
        jButtonDelete.setEnabled(enabled);
    }
    
    /**��㹡�á�˹��ŷ�����͡�����ҧ ��е�ͧ��è�����ʴ��� GUI*/
    public void selectShowData(int row)
    {
        if(row > -1)
        {
            if(vAricSubGroup != null)
            {
                theAricSubGroup = (AricSubGroup)vAricSubGroup.get(row);
                if(isKeyIDLength13(theAricSubGroup.getObjectId()))
                {
                    setEnableGUI(false);
                }
                else
                {
                    setEnableGUI(true);
                }
                setDataObjectToGUI();
            }
        }
    }
    /**��㹡���ʴ��ŷ���� Object ŧ�� GUI*/
    private void setDataObjectToGUI()
    {
        if(theAricSubGroup != null)
        {
            jTextFieldCode.setText(theAricSubGroup.number);
            jTextFieldDescrpiton.setText(theAricSubGroup.description);
            ComboboxModel.setCodeComboBox(jComboBoxAricGroup, theAricSubGroup.aricgroupid);
        }
        else
        {
            clearGUI();
        }
    }
    
    /**
     *����Ѻ��Ǩ�ͺ key id �ͧ object ����� 13 ��ѡ �������
     *����� 13 ��ѡ ���������ö��� ���� ź ��
     *@param keyid �� key id �ͧ AricGroup ������͡�ҡ���ҧ
     *@return boolean ��� key id �� 13 ��ѡ �� false �������� 13 ��ѡ �� true
     */
    private boolean isKeyIDLength13(String keyid)
    {
        boolean result = true;
        if(keyid.length() == 13)
        {
            result = true;
        }
        else
        {
            result = false;
        }
        return result;
    }
    
    /**��㹡���Ѻ�����Ũҡ GUI ŧ Object*/
    private boolean setGUIToDataObject()
    {   boolean result = true;
        if(theAricSubGroup == null)
        {
            theAricSubGroup = new AricSubGroup();
        }
        
        theAricSubGroup.number = jTextFieldCode.getText().trim();
        theAricSubGroup.description = jTextFieldDescrpiton.getText().trim();
        theAricSubGroup.aricgroupid = ComboboxModel.getCodeComboBox(jComboBoxAricGroup);
        
        if(theAricSubGroup.number.length() == 0 )
        {
            JOptionPane.showMessageDialog(this,Language.getTextBundle("CodeSubAricNotNULL", language),Language.getTextBundle("Warning", language),JOptionPane.OK_OPTION);
            setFocusAricSubGroupCode();
            result = false;
        }
        else
        {
            if(theAricSubGroup.description.length()  == 0 )
            {
                JOptionPane.showMessageDialog(this,Language.getTextBundle("DescriptionSubAricNotNULL", language),Language.getTextBundle("Warning", language),JOptionPane.OK_OPTION);
                setFocusAricSubGroupDescription();
                result = false;
            }
        }
        
        return result ;
    }
    /**��㹡�á�˹�����ա�ù� curor ��������ǹ�˹�ͧ GUI*/
    private void setFocusAricSubGroupCode()
    {
        jTextFieldCode.requestFocus();
    }
    /**��㹡�á�˹�����ա�ù� curor ��������ǹ�˹�ͧ GUI*/
    private void setFocusAricSubGroupDescription()
    {
        jTextFieldDescrpiton.requestFocus();
    }
    
    /**
     *  ��㹡�ä��Ң����� ��зӡ���ʴ�������ŧ�����ҧ����˹�
     */
    public void searchDataAndShowDataToTable()
    {
        vAricSubGroup = searchData();
        showDataToTable(vAricSubGroup);
    }
    /**
     * ��㹡�� search �����ŵ�������ŷ���˹�
     * @return �� Vector �ͧ Object ����˹�
     */
    private Vector searchData()
    {
        String search = this.jTextFieldSearch.getText();
        search = search.trim();
        vAricSubGroup = this.theHosManage.theHosControl.theAricSubGroupControl.selectAricSubGroupByCodeOrDescription(search);
        return vAricSubGroup;
    }
    
    /**
     * ��㹡�� �ʴ������š�ä���ŧ�����ҧ����˹�
     * @param vc �� Vector �ͧ�����ŷ��ӡ�����������е�ͧ��á�˹�����ʴ������ҧ
     */
    private void showDataToTable(Vector vc)
    {
        theTableModelGUI = new TableModelGUI(colName, 0);
        if(vc != null)
        {
            int size = vc.size();
            theTableModelGUI = new TableModelGUI(colName, size);
            theAricSubGroupTemp = null;
            for(int i = 0 ; i < size ;i++)
            {
                theAricSubGroupTemp = (AricSubGroup)vc.get(i);
                theTableModelGUI.setValueAt(theAricSubGroupTemp.number,i, 0);
                theTableModelGUI.setValueAt(theAricSubGroupTemp.description,i, 1);
                
                theAricSubGroupTemp = null;
            }
            
        }
        
        jTableShowList.setModel(theTableModelGUI);
        jTableShowList.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTableShowList.getColumnModel().getColumn(1).setPreferredWidth(100);
    }
    /**
     *  ��㹡�á�˹��������Ѻ GUI
     */
    private void setLanguage()
    {
        colName = new String[] {Language.getTextBundle("Code",language),Language.getTextBundle("Description",language)};
        theComboFix = new ComboFix();
        theComboFix.code = "000";
        theComboFix.name = Language.getTextBundle("NoSpec",language);
        
        jButtonAdd.setText(Language.getTextBundle(jButtonAdd.getText(),language));
        jButtonDelete.setText(Language.getTextBundle(jButtonDelete.getText(),language));
        jButtonSave.setText(Language.getTextBundle(jButtonSave.getText(),language));
        jButtonSearch.setText(Language.getTextBundle(jButtonSearch.getText(),language));
        jLabelAricGroup.setText(Language.getTextBundle(jLabelAricGroup.getText(),language));
        jLabelCode.setText(Language.getTextBundle(jLabelCode.getText(),language));
        jLabelDescription.setText(Language.getTextBundle(jLabelDescription.getText(),language));
        jLabelSearch.setText(Language.getTextBundle(jLabelSearch.getText(),language));
        jLabelSetupName.setText(Language.getTextBundle(jLabelSetupName.getText(),language));
    }
    
    public String getPanelName()
    {
        return panelname;
    }
    
    public void setEnableButtonSetupPanel(boolean enabled)
    {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxAricGroup;
    private javax.swing.JLabel jLabelAricGroup;
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSetupName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
