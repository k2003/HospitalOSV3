/*
 * PanelSetupOrder.java
 *
 * Created on 13 ���Ҥ� 2546, 17:10 �.
 */
package com.hosv3.gui.panel.setup;
import java.util.Vector;

import com.hosv3.usecase.setup.*;
import com.hosv3.control.*;
import com.hosv3.utility.connection.*;
import com.hosv3.utility.GuiLang;
import com.hospital_os.utility.*;
import com.hospital_os.object.*;
/**
 *
 * @panel author : amp
 * @panel update : amp
 * 
 */
public class PanelSetupOrderGroup extends javax.swing.JPanel   implements 
ManageOptionReq
{
    LookupControl theLookupControl;
    ComboboxModel theComboboxModel;
    UpdateStatus theUS;
    SetupControl theSetupControl;
    Vector categorygroup = new Vector();
    Vector category = new Vector();
    Vector depPanelV = new Vector();
    CategoryGroupItem theCategoryGroupItem;
    int offset = 23;
    int next = 0;
    int prev = 0;
    int saved = 0; // 0 ��� �������ö insert�� 1 ��� insert ��
    String[] col = {"����","����"};

    private PanelSetupItem thePanelSetupItem;
    public PanelSetupOrderGroup() 
    {
        initComponents();
        setLanguage();
        jTable1.setGuiMode(true);
    }
    public PanelSetupOrderGroup(HosControl hc,UpdateStatus us)
    {
        initComponents();
        setLanguage();      
        jTable1.setGuiMode(true);  
        setControl(hc,us);
    }    /////////////////////Use this for decrease memory usage
    public void setControl(HosControl hc,UpdateStatus us)
    {
//        setLanguage("");
        theUS = us;
        theLookupControl = hc.theLookupControl;
        theSetupControl = hc.theSetupControl;
        hc.theHS.theSetupSubject.addpanelrefrash(this);
        hc.theHS.theSetupSubject.addForLiftAttach(this);
        setLookup();
        setEnableAll(false);
      //  initData();
    }
    public void addDepPanel(ManageOptionReq panel) {
        if(panel!=null)
            depPanelV.add(panel);
    }
    
    public void refreshDepPanel() {
        for(int i=0;i<depPanelV.size();i++) {
            ((ManageOptionReq)depPanelV.get(i)).notifyreFrashPanel();
        }
    }
    
   /**
     *@Author : amp
     *@date : 29/02/2549
     *@see : �Ѵ�������ǡѺ����    
     */
    private void setLanguage()
    {
        GuiLang.setLanguage(jLabel3);
        GuiLang.setLanguage(jLabelICD9code);
        GuiLang.setLanguage(jButtonSearch);
        GuiLang.setLanguage(jLabel1);        
        GuiLang.setLanguage(jLabel2);
        GuiLang.setLanguage(jLabel4);
        GuiLang.setLanguage(jCheckBoxS);
        GuiLang.setLanguage(jButtonSave);        
        GuiLang.setLanguage(jCheckBox1);  
        GuiLang.setLanguage(col);
    }    
    /////////////////////Use this for decrease memory usage    
    private void setLookup()
    {   
        setComboBox();
    }
    private void setComboBox()
    {   categorygroup = theLookupControl.listCategoryGroup();
        ComboboxModel.initComboBox(jComboBoxCategoryGroup,categorygroup);
    }
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
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelICD9code = new javax.swing.JLabel();
        jTextFieldSCode = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new com.hosv3.gui.component.HJTableSort();
        jCheckBoxS = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jButtonPrev = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCategoryGroup = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDel = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(fontFormatTitle1);
        jLabel4.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("LIST_ORDER"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        jPanel4.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jPanel4, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(300, 25));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 404));
        jLabelICD9code.setFont(defaultFont1);
        jLabelICD9code.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SEARCH"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 11);
        jPanel3.add(jLabelICD9code, gridBagConstraints);

        jTextFieldSCode.setFont(defaultFont1);
        jTextFieldSCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSCodeActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(jTextFieldSCode, gridBagConstraints);

        jButtonSearch.setFont(defaultFont1);
        jButtonSearch.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SEARCH"));
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
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(jButtonSearch, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 22));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 80));
        jTable1.setFont(defaultFont1);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jCheckBoxS.setFont(defaultFont1);
        jCheckBoxS.setSelected(true);
        jCheckBoxS.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("ACTIVE"));
        jCheckBoxS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel3.add(jCheckBoxS, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jButtonPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hospital_os/images/Back16.gif")));
        jButtonPrev.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonPrev.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonPrev.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel5.add(jButtonPrev, gridBagConstraints);

        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hospital_os/images/Forward16.gif")));
        jButtonNext.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonNext.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonNext.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel5.add(jButtonNext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(jPanel3, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(350, 120));
        jPanel2.setMinimumSize(new java.awt.Dimension(350, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 120));
        jLabel1.setFont(defaultFont1);
        jLabel1.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("CODE"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel1, gridBagConstraints);

        jTextFieldCode.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel2.add(jTextFieldCode, gridBagConstraints);

        jLabel2.setFont(defaultFont1);
        jLabel2.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("NAME"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jTextFieldName.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jTextFieldName, gridBagConstraints);

        jLabel3.setFont(defaultFont1);
        jLabel3.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("GROUP"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(jLabel3, gridBagConstraints);

        jComboBoxCategoryGroup.setFont(defaultFont1);
        jComboBoxCategoryGroup.setMaximumSize(new java.awt.Dimension(150, 24));
        jComboBoxCategoryGroup.setMinimumSize(new java.awt.Dimension(150, 24));
        jComboBoxCategoryGroup.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jComboBoxCategoryGroup, gridBagConstraints);

        jCheckBox1.setFont(defaultFont1);
        jCheckBox1.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("ACTIVE"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jCheckBox1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jPanel2, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel1.add(jButtonAdd, gridBagConstraints);

        jButtonDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/minus16.gif")));
        jButtonDel.setEnabled(false);
        jButtonDel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonDel.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonDel.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonDel.setPreferredSize(new java.awt.Dimension(24, 24));
        jButtonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(jButtonDel, gridBagConstraints);

        jButtonSave.setFont(defaultFont1);
        jButtonSave.setText(java.util.ResourceBundle.getBundle("com/hosv3/property/thai").getString("SAVE"));
        jButtonSave.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSave.setMaximumSize(new java.awt.Dimension(60, 24));
        jButtonSave.setMinimumSize(new java.awt.Dimension(60, 24));
        jButtonSave.setPreferredSize(new java.awt.Dimension(60, 24));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jPanel1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSActionPerformed
        searchItem();
    }//GEN-LAST:event_jCheckBoxSActionPerformed
    private void jButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelActionPerformed
       deleteCategoryGroupItem();
    }//GEN-LAST:event_jButtonDelActionPerformed
    private void jTextFieldSCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSCodeActionPerformed
       searchItem();       
    }//GEN-LAST:event_jTextFieldSCodeActionPerformed
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
      saveCategoryGroupItem();
    }//GEN-LAST:event_jButtonSaveActionPerformed
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        theCategoryGroupItem = null;
        setEnableAll(true);
        clearAll();
        jTextFieldCode.requestFocus();
    }//GEN-LAST:event_jButtonAddActionPerformed
    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
       nextItem();
    }//GEN-LAST:event_jButtonNextActionPerformed
    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevActionPerformed
       prevItem();
    }//GEN-LAST:event_jButtonPrevActionPerformed
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
       searchItem();
    }//GEN-LAST:event_jButtonSearchActionPerformed
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        selectItem();
    }//GEN-LAST:event_jTable1MouseReleased
    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        selectItem();
	}//GEN-LAST:event_jTable1KeyReleased
      
    private void nextItem()
    {   
        setTable(category,1);
    }
    private void prevItem()
    {   
        setTable(category,0);
    }
    private void deleteCategoryGroupItem()
    {   
  
        theSetupControl.deleteCategoryGroupItem(theCategoryGroupItem);
        setEnableAll(false);
        clearAll();
        searchItem();
        refreshDepPanel();
    }
    private void clearAll()
    {   
        jTextFieldCode.setText("");
        jTextFieldName.setText("");
        jCheckBox1.setSelected(true);
    }
    private void setEnableAll(boolean var)
    {   
        jTextFieldCode.setEditable(var);
        jTextFieldName.setEnabled(var);
        jButtonSave.setEnabled(var);
        jCheckBox1.setEnabled(var);
        jComboBoxCategoryGroup.setEnabled(var);
        jButtonDel.setEnabled(var);
    /*    if(!var)
        {   jComboBoxCategoryGroup.setBackground(new Color(255,255,255));
            jComboBoxCategoryGroup.setForeground(new Color(0,0,0));
        }    
     */
    }
    private void selectItem()
    {   
        setEnableAll(true);
        saved = 0;
        int row = jTable1.getSelectedRow();
        String of = (String)jTable1.getValueAt(row, 0);
        jTextFieldCode.setText(of);
        jTextFieldName.setText((String)jTable1.getValueAt(row, 1));
        CategoryGroupItem bgi = new CategoryGroupItem();
        for(int i =0 ; i< category.size() ; i++)
        {           
             if(of == ((CategoryGroupItem)category.get(i)).category_group_item_id)
                bgi = (CategoryGroupItem)category.get(i);
        }
        theCategoryGroupItem = bgi;
        ComboboxModel.setCodeComboBox(jComboBoxCategoryGroup, bgi.category_group_code);
        if(theCategoryGroupItem.active.equals("1"))
            jCheckBox1.setSelected(true);
        else
            jCheckBox1.setSelected(false);
    }
    private void searchItem()
    {   
        next = 0;
        prev = 0;
        String search = jTextFieldSCode.getText();
        String active = "0";
        if(jCheckBoxS.isSelected())
            active = "1";
       //henbe / category =  theSetupControl.listItemByName(search, active);
        category =  theSetupControl.listCategoryGroupItemByName(search, active);
            setTable(category,1);
    }
     private void setTable(Vector voffice,int off)
    {   
        CategoryGroupItem of = new CategoryGroupItem();
        int count = offset;
        int p =0;
        int n =0;
        int c =0;
        if(voffice != null)
        {
            if(off == 1)
            {   p = prev;
                n = next;
                prev = next;
                next = next + offset;
                if(next >= category.size())
                {   next = category.size();
                    count = next - prev;
                }
                if(count == 0)
                {   prev = p;
                    next = n;
                    count = n - p;
                }
            }
            else
            {   next = prev;
                prev = prev - offset;
                if(prev <=0)
                {    prev = 0;
                    next = offset;
                }
                if(next >= category.size())
                {   next= category.size();
                    count = next;
                }
            }
            TaBleModel tm = new TaBleModel(col,count);
            for(int i=0 ;i<count;i++)
            {  
                of = (CategoryGroupItem)voffice.get(i+prev);
                tm.setValueAt(of.category_group_item_id,i,0);
                tm.setValueAt(of.description,i,1);
            }
            jTable1.setModel(tm);
        }
        else
        {   TaBleModel tm = new TaBleModel(col,0);
            jTable1.setModel(tm);
        }
         setTableOrderListDefault();
    }
     
    private void saveCategoryGroupItem()
    {   
        String old_cat = "";
        if(theCategoryGroupItem!=null)
            old_cat = this.theCategoryGroupItem.category_group_code;
        UpdateGOBillingGroupItem();
        theSetupControl.saveCategoryGroupItem(theCategoryGroupItem,old_cat); 
        setEnableAll(false);
        searchItem();
        refreshDepPanel();
    }
    
    private void setTableOrderListDefault()
    {      
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60); // �������ѭ����Ѻ þ.�����, ���͡�ä�� ����Ѻ�ٹ���ä��
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(300); // �ӹǹ
    }
    public void notifyreFrashPanel() {
        setLookup();
    }
    public void notifysetEnableForLift(boolean b) {
        jButtonDel.setVisible(b);
    }
    public int editOption(Option option) {
        Constant.println("PanelSetupOrderGroup function is not use.");
        return -1;
    }
    public Vector listOptionAll() {
        Constant.println("PanelSetupOrderGroup function is not use.");
        return null;
    }
    public void reFrashPanel() {
    }
    public Option readOption() {
        Constant.println("PanelSetupOrderGroup function is not use.");
        return null;
    }
    public int saveOption(Option option) {
        Constant.println("PanelSetupOrderGroup function is not use.");
        return -1;
    }
    public void setEnableForLift(boolean b) {
    }
    public void UpdateGOBillingGroupItem()
    {
        if(theCategoryGroupItem == null)
            theCategoryGroupItem = new CategoryGroupItem();
        theCategoryGroupItem.category_group_item_id = jTextFieldCode.getText();
        theCategoryGroupItem.description = jTextFieldName.getText();
        theCategoryGroupItem.category_group_code = ComboboxModel.getCodeComboBox(jComboBoxCategoryGroup);
        if(jCheckBox1.isSelected())
            theCategoryGroupItem.active = "1";
        else
            theCategoryGroupItem.active = "0";  
    }
    
//    public void setLanguage(String msg)
//    {
//        GuiLang.setLanguage(jLabel5);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private com.hospital_os.gui.font.FontFormatTitle fontFormatTitle1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDel;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxS;
    private javax.swing.JComboBox jComboBoxCategoryGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelICD9code;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hosv3.gui.component.HJTableSort jTable1;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSCode;
    // End of variables declaration//GEN-END:variables
}
