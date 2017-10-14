/*
     * PanelSetupSQLTemplateParam.java
 *
 * Created on 20 �á�Ҥ� 2547, 12:16 �.
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
 * @author  tong
 */
public class PanelSetupSQLTemplateParam extends javax.swing.JPanel implements ManageOptionReq{
    UpdateStatus theUS;
    SetupControl theSetupControl;
    SQLTemplateParam theSQLTemplateParam = new SQLTemplateParam();
    Vector vSQLTemplateParam = new Vector();
    int offset = 22;
    int next = 0;
    int prev = 0;
    int saved = 0; // 0 ��� �������ö insert�� 1 ��� insert �� 
    String[] col = {"����","������§ҹ"};
    public PanelSetupSQLTemplateParam(HosControl hc,UpdateStatus us) {
        initComponents();
        setLanguage();
        setControl(hc,us);
		jTable1.setGuiMode(true);
    }
    public PanelSetupSQLTemplateParam() {
        initComponents();
        setLanguage();
    }
    public void setControl(HosControl hc,UpdateStatus us){
	theUS = us;
        theSetupControl = hc.theSetupControl;
        hc.theHS.theSetupSubject.addForLiftAttach(this);
      //hc.theHS.theSetupSubject.addpanelrefrash(this);
    }
    PanelReportSQLParam thePanelReportSQLParam;
    public void setDepPanel(PanelReportSQLParam psql){
        thePanelReportSQLParam = psql;
    }
        /**
     *@Author : amp
     *@date : 02/02/2549
     *@see : �Ѵ�������ǡѺ����    
     */
    private void setLanguage()
    {
        GuiLang.setLanguage(jLabel3);
        GuiLang.setLanguage(jLabelICD9code);
        GuiLang.setLanguage(jButtonSearch);
        GuiLang.setLanguage(jLabel1);        
        GuiLang.setLanguage(jLabel2);
        GuiLang.setLanguage(jLabel31);
        GuiLang.setLanguage(jCheckBoxS);
        GuiLang.setLanguage(jButtonSave);        
        GuiLang.setLanguage(jCheckBox1);        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fontFormatTitle1 = new com.hospital_os.gui.font.FontFormatTitle();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextFieldSQL = new javax.swing.JTextArea();
        jTextFieldDescription = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDel = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelICD9code = new javax.swing.JLabel();
        jTextFieldSCode = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new com.hosv3.gui.component.HJTableSort();
        jCheckBoxS = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jButtonPrev = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(350, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 240));
        jLabel3.setText("\u0e23\u0e32\u0e22\u0e25\u0e30\u0e40\u0e2d\u0e35\u0e22\u0e14");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 5);
        jPanel2.add(jLabel3, gridBagConstraints);

        jCheckBox1.setText("Active");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 5);
        jPanel2.add(jCheckBox1, gridBagConstraints);

        jLabel31.setText("\u0e23\u0e32\u0e22\u0e01\u0e32\u0e23\u0e04\u0e33\u0e2a\u0e31\u0e48\u0e07 SQL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 5);
        jPanel2.add(jLabel31, gridBagConstraints);

        jScrollPane21.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane21.setPreferredSize(new java.awt.Dimension(100, 100));
        jTextFieldSQL.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11));
        jTextFieldSQL.setLineWrap(true);
        jTextFieldSQL.setWrapStyleWord(true);
        jTextFieldSQL.setMinimumSize(new java.awt.Dimension(100, 200));
        jTextFieldSQL.setPreferredSize(new java.awt.Dimension(100, 200));
        jScrollPane21.setViewportView(jTextFieldSQL);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 5);
        jPanel2.add(jScrollPane21, gridBagConstraints);

        jTextFieldDescription.setMaximumSize(new java.awt.Dimension(100, 21));
        jTextFieldDescription.setMinimumSize(new java.awt.Dimension(100, 21));
        jTextFieldDescription.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 5);
        jPanel2.add(jTextFieldDescription, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("\u0e23\u0e2b\u0e31\u0e2a");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 12);
        jPanel4.add(jLabel1, gridBagConstraints);

        jTextFieldCode.setMaximumSize(new java.awt.Dimension(100, 21));
        jTextFieldCode.setMinimumSize(new java.awt.Dimension(100, 21));
        jTextFieldCode.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jPanel4.add(jTextFieldCode, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jButtonAdd, gridBagConstraints);

        jButtonDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hosv3/gui/images/minus16.gif")));
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jButtonDel, gridBagConstraints);

        jButtonSave.setText("\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01");
        jButtonSave.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSave.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonSave.setPreferredSize(new java.awt.Dimension(60, 24));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jButtonSave, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jPanel1, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(300, 25));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 404));
        jLabelICD9code.setText("\u0e04\u0e49\u0e19\u0e2b\u0e32");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 11);
        jPanel3.add(jLabelICD9code, gridBagConstraints);

        jTextFieldSCode.setMaximumSize(new java.awt.Dimension(100, 21));
        jTextFieldSCode.setMinimumSize(new java.awt.Dimension(100, 21));
        jTextFieldSCode.setPreferredSize(new java.awt.Dimension(100, 21));
        jTextFieldSCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSCodeActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(jTextFieldSCode, gridBagConstraints);

        jButtonSearch.setText("\u0e04\u0e49\u0e19\u0e2b\u0e32");
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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(jButtonSearch, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 22));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 80));
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jCheckBoxS.setSelected(true);
        jCheckBoxS.setText("Active");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel3.add(jCheckBoxS, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel6.add(jButtonPrev, gridBagConstraints);

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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel6.add(jButtonNext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(jPanel3, gridBagConstraints);

        jLabel2.setFont(fontFormatTitle1);
        jLabel2.setText("SQL \u0e04\u0e49\u0e19\u0e2b\u0e32\u0e15\u0e32\u0e21\u0e27\u0e31\u0e19\u0e17\u0e35\u0e48");
        jPanel5.add(jLabel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jPanel5, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    private void jButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelActionPerformed
        deleteSQLTemplateParam();
    }//GEN-LAST:event_jButtonDelActionPerformed
    private void jTextFieldDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescriptionKeyReleased
    }//GEN-LAST:event_jTextFieldDescriptionKeyReleased
    private void jTextFieldSCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSCodeActionPerformed
        searchSQLTemplateParam();   
    }//GEN-LAST:event_jTextFieldSCodeActionPerformed
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseReleased
    {//GEN-HEADEREND:event_jTable1MouseReleased
        selectSQLTemplateParam();
    }//GEN-LAST:event_jTable1MouseReleased
    private void jTable1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable1KeyReleased
    {//GEN-HEADEREND:event_jTable1KeyReleased
        selectSQLTemplateParam();
    }//GEN-LAST:event_jTable1KeyReleased
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSearchActionPerformed
    {//GEN-HEADEREND:event_jButtonSearchActionPerformed
        searchSQLTemplateParam();
    }//GEN-LAST:event_jButtonSearchActionPerformed
    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonNextActionPerformed
    {//GEN-HEADEREND:event_jButtonNextActionPerformed
        nextSQLTemplateParam();
    }//GEN-LAST:event_jButtonNextActionPerformed
    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonPrevActionPerformed
    {//GEN-HEADEREND:event_jButtonPrevActionPerformed
        prevSQLTemplateParam();
    }//GEN-LAST:event_jButtonPrevActionPerformed
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        saveSQLTemplateParam();
    }//GEN-LAST:event_jButtonSaveActionPerformed
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        insertSQLTemplateParam();
    }//GEN-LAST:event_jButtonAddActionPerformed
    private void nextSQLTemplateParam()
    {   
        setTable(vSQLTemplateParam,1);
    }
    private void prevSQLTemplateParam()
    {   
        setTable(vSQLTemplateParam,0);
    }
    private void insertSQLTemplateParam()
    {   
        saved = 1;
        theSQLTemplateParam = new SQLTemplateParam();
        clearAll();
    }
    private void deleteSQLTemplateParam()
    {   
        theSetupControl.deleteSQLTemplateParam(theSQLTemplateParam);
        clearAll();
        searchSQLTemplateParam();
        if(thePanelReportSQLParam!=null){
            thePanelReportSQLParam.setupLookup();
        }        
    }
    private void clearAll()
    {   
        jTextFieldCode.setText("");
        jTextFieldDescription.setText("");
        jTextFieldSQL.setText("");
        jCheckBox1.setSelected(true);
    }
    private void setEnableAll(boolean var)
    {   
        jTextFieldCode.setEditable(var);
        jTextFieldDescription.setEnabled(var);
        jTextFieldSQL.setEditable(var);
        jButtonSave.setEnabled(var);
        jButtonDel.setEnabled(var);  
    }
    private void selectSQLTemplateParam()
    {   
        saved = 0;
        int row = jTable1.getSelectedRow();
        String of = (String)jTable1.getValueAt(row, 0);
        jTextFieldCode.setText(of);
        jTextFieldDescription.setText((String)jTable1.getValueAt(row, 1));
  
        SQLTemplateParam bgi = new SQLTemplateParam();
        for(int i =0 ; i< vSQLTemplateParam.size() ; i++)
        {           
             if(of == ((SQLTemplateParam)vSQLTemplateParam.get(i)).code)
                bgi = (SQLTemplateParam)vSQLTemplateParam.get(i);
        }
        theSQLTemplateParam = bgi;  
       // jTextFieldGenCode.setText(bgi.generate_code);
        jTextFieldDescription.setText(bgi.description);
        jTextFieldSQL.setText(bgi.sql);
        jCheckBox1.setSelected(Gutil.isSelected(bgi.active));
    }
    private void searchSQLTemplateParam()
    {   
        next = 0;
        prev = 0;
        String search = jTextFieldSCode.getText();
        search = search.toUpperCase();
        String active = Gutil.isSelected(jCheckBoxS);
        vSQLTemplateParam = new Vector();
        vSQLTemplateParam =  theSetupControl.listSQLTemplateParamBySearch(search,active);
        setTable(vSQLTemplateParam,1);
    }
    private void setTable(Vector voffice,int off)
    {   
        String[] col = {"����","������§ҹ"};
        SQLTemplateParam of = new SQLTemplateParam();
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
                if(next >= vSQLTemplateParam.size())
                {   next = vSQLTemplateParam.size();
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
                if(next >= vSQLTemplateParam.size())
                {   next= vSQLTemplateParam.size();
                    count = next;
                }
            }
            TaBleModel tm = new TaBleModel(col,count);
            for(int i=0 ;i<count;i++)
            {  
                of = (SQLTemplateParam)voffice.get(i+prev);
                tm.setValueAt(of.code,i,0);
                tm.setValueAt(of.description,i,1);
            }
            jTable1.setModel(tm);
        }
        else
        {   TaBleModel tm = new TaBleModel(col,0);
            jTable1.setModel(tm);
        }
        setTableListDefault();
    }  
     private void setTableListDefault()
    {      
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60); // �������ѭ����Ѻ þ.�����, ���͡�ä�� ����Ѻ�ٹ���ä��
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(300); // �ӹǹ
    }
    private void saveSQLTemplateParam()
    {   
        theSQLTemplateParam.code = jTextFieldCode.getText();
        theSQLTemplateParam.description = jTextFieldDescription.getText();
        theSQLTemplateParam.sql = jTextFieldSQL.getText();
        theSQLTemplateParam.active = Gutil.isSelected(jCheckBox1);
        boolean result = false;
          if((!theSQLTemplateParam.code.equals(""))&&(!theSQLTemplateParam.description.equals(""))&&(!theSQLTemplateParam.sql.equals("")))
            {
                SQLTemplateParam SQLTemplateParam = theSetupControl.listSQLTemplateParamByCode(theSQLTemplateParam.code);
                if(SQLTemplateParam==null)
                {   if(checkSQL(theSQLTemplateParam.sql))
                    {
                         theSetupControl.saveSQLTemplateParam(theSQLTemplateParam);
                         saved =0;
                        result = true;
                    }
                    else
                    {
                        theUS.setStatus("SQL Statement  Error",UpdateStatus.WARNING);
                    }
                }
                else
                {
                    if(theSQLTemplateParam.getObjectId()==null)
                      {
                          theUS.setStatus("�������ö�ѹ�֡���ʫ����",UpdateStatus.WARNING);
                      }
                      else
                      {
                          if(theSQLTemplateParam.getObjectId().equals(SQLTemplateParam.getObjectId()))
                          {   if(checkSQL(theSQLTemplateParam.sql))
                                {  
                                theSetupControl.saveSQLTemplateParam(theSQLTemplateParam);
                                result = true;
                              }
                              else
                                {
                                   // theUS.setStatus("SQL Statement  Error",UpdateStatus.WARNING);     
                                    theUS.setStatus("���͹�㹤���� sql ���١��ͧ",UpdateStatus.WARNING);     
                                }
                          }
                          else
                          {
                              theUS.setStatus("�������ö�ѹ�֡���ʫ����",UpdateStatus.WARNING);
                          }
                      }
                      SQLTemplateParam = null;
                }
                if(result)
                {
                    searchSQLTemplateParam();
                }
            }
            else
            {
                theUS.setStatus("�������ö�ѹ�֡�������繤����ҧ��",UpdateStatus.WARNING);
            }
            if(thePanelReportSQLParam!=null){
                thePanelReportSQLParam.setupLookup();
            }
    }
    public boolean checkSQL(String sql)
    {   int cur_index = 0;
        int num_qt = 0;
        //��Ǩ�ͺ�ӹǹ�ͧ ?
           while(cur_index != -1)
           {
                cur_index++;
                cur_index = sql.indexOf("?",cur_index);
                num_qt = num_qt +1;
           }
           num_qt = num_qt-1;     //�ٻ�Թ�� 1 �ͺ
           if((num_qt<2)||((num_qt%2) != 0))
           {
              // theUS.setStatus("���͹�㹤���� sql ���١��ͧ",UpdateStatus.WARNING);
               jTextFieldSQL.requestFocus();
               return false;
           }
           else
           {
                   return true;//theSetupControl.checkSQLParam(sql.trim());
           }
    }
    public void notifyreFrashPanel() {
    }  
    public void notifysetEnableForLift(boolean b) {
    }
    public int editOption(Option option) {
        Constant.println("PanelSetupSQLTemplateParam function is not use.");
        return -1;
    }
    public Vector listOptionAll() {
        Constant.println("PanelSetupSQLTemplateParam function is not use.");
        return null;
    }
    public void reFrashPanel() {
    }
    public Option readOption() {
        Constant.println("PanelSetupSQLTemplateParam function is not use.");
        return null;
    }
    public int saveOption(Option option) {
        Constant.println("PanelSetupSQLTemplateParam function is not use.");
        return -1;
    }
    public void setEnableForLift(boolean b) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.FontFormatTitle fontFormatTitle1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDel;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabelICD9code;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane21;
    private com.hosv3.gui.component.HJTableSort jTable1;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldSCode;
    private javax.swing.JTextArea jTextFieldSQL;
    // End of variables declaration//GEN-END:variables
}
