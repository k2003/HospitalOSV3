/*
 * DialogSearchSurvey.java
 *
 * Created on 9 �չҤ� 2549, 15:22 �.
 */

package com.setupreport.gui.dialog;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import com.setupreport.manage.HosManage;
import com.setupreport.utility.TableModelGUI;
import com.setupreport.utility.Language;
import com.setupreport.object.HealthySurvey;

import com.hospital_os.usecase.connection.ConnectionInf;
import com.hospital_os.utility.ConnectionDBMgr;
/**
 *
 * @author  Ojika
 */
public class DialogSearchSurvey extends javax.swing.JDialog {
    
    Vector vHealthySurvey,vData;
    HosManage theHosManage;
    TableModelGUI theTableModelGUI;
    HealthySurvey theHealthySurvey,theHealthySurveyTemp;
    String[] colName;
    int language = 1;
    
    public DialogSearchSurvey(java.awt.Frame parent, boolean modal,HosManage hosmanage) {
        super(parent, modal);
        theHosManage = hosmanage;
        initComponents();
        parent.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/setupreport/images/Icon.gif")));    
        this.setTitle(Language.getTextBundle("SearchSurvey",language));
        setLanguage();
        colName = new String[] {Language.getTextBundle("Common_name", language)};
        //showDataToTable(null);
        searchData();
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
        jPanelSearch = new javax.swing.JPanel();
        jPanelSearchItem = new javax.swing.JPanel();
        jLabelSearch = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jPanelControl = new javax.swing.JPanel();
        jButtonPre = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jPanelShow = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableShowList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanelSearch.setLayout(new java.awt.GridBagLayout());

        jPanelSearchItem.setLayout(new java.awt.GridBagLayout());

        jLabelSearch.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanelSearchItem.add(jLabelSearch, gridBagConstraints);

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 0);
        jPanelSearchItem.add(jTextFieldSearch, gridBagConstraints);

        jButtonSearch.setText("Search");
        jButtonSearch.setMaximumSize(new java.awt.Dimension(69, 24));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(69, 24));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(75, 24));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 5);
        jPanelSearchItem.add(jButtonSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelSearch.add(jPanelSearchItem, gridBagConstraints);

        jPanelControl.setLayout(new java.awt.GridBagLayout());

        jButtonPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/setupreport/images/Back16.gif")));
        jButtonPre.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonPre.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonPre.setPreferredSize(new java.awt.Dimension(24, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanelControl.add(jButtonPre, gridBagConstraints);

        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/setupreport/images/Forward16.gif")));
        jButtonNext.setMaximumSize(new java.awt.Dimension(24, 24));
        jButtonNext.setMinimumSize(new java.awt.Dimension(24, 24));
        jButtonNext.setPreferredSize(new java.awt.Dimension(24, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanelControl.add(jButtonNext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelSearch.add(jPanelControl, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jPanelSearch, gridBagConstraints);

        jPanelShow.setLayout(new java.awt.GridBagLayout());

        jTableShowList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableShowList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelShow.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanelShow, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jButtonAdd, gridBagConstraints);

        jButtonClose.setText("Close");
        jButtonClose.setMaximumSize(new java.awt.Dimension(75, 24));
        jButtonClose.setMinimumSize(new java.awt.Dimension(75, 24));
        jButtonClose.setPreferredSize(new java.awt.Dimension(75, 24));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jButtonClose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-501)/2, 416, 501);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldSearchActionPerformed
    {//GEN-HEADEREND:event_jTextFieldSearchActionPerformed
        searchData();
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        setSelectInRow(jTableShowList.getSelectedRows());
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        searchData();
    }//GEN-LAST:event_jButtonSearchActionPerformed
    
    
    public void setSelectInRow(int[] rows)
    {   
        vData = new Vector();
        if(rows.length !=0)
        {   
            int size = rows.length;
            for(int i = 0 ; i < size ; i++)
            {
                theHealthySurveyTemp = (HealthySurvey)vHealthySurvey.get(rows[i]);
                vData.add(theHealthySurveyTemp);
                theHealthySurveyTemp = null;
            }
        }
        
        // �觤����ѧ panelHealthyGroupSurvey
        theHosManage.theHosControl.theHosSubject.theHealthyGroupSurveySubject.notifySaveHealthyGroupSurvey(vData);
       
    }    
    
    public void searchData()
    {
        String keyword = this.jTextFieldSearch.getText().trim();
        vHealthySurvey = theHosManage.theHosControl.theHealthyGroupSurveyControl.selectHealthySurveyByKeyword(keyword);
        showDataToTable(vHealthySurvey);
        
        keyword = null;
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
            theHealthySurveyTemp = null;
            for(int i = 0 ; i < size ;i++)
            {   
                theHealthySurveyTemp = (HealthySurvey)vc.get(i);
                theTableModelGUI.setValueAt(theHealthySurveyTemp.health_survey_desceiption,i, 0);
                
                theHealthySurveyTemp = null;
            }            
        }        
        jTableShowList.setModel(theTableModelGUI);
        jTableShowList.getColumnModel().getColumn(0).setPreferredWidth(100);
    }
    
    private void setLanguage()
    {
        jButtonAdd.setText(Language.getTextBundle(jButtonAdd.getText(), language));
        jButtonClose.setText(Language.getTextBundle(jButtonClose.getText(), language));
        jButtonSearch.setText(Language.getTextBundle(jButtonSearch.getText(), language));
        jLabelSearch.setText(Language.getTextBundle(jLabelSearch.getText(), language));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                
                
                String server = "192.168.1.6";
                String database = "develop_aoluk_test";
                String port = "5432";
                String username = "postgres";
                String password = "postgres";
                String url_1 = "jdbc:postgresql://"+ server +":" +port +"/" + database;
               
                ConnectionInf theConnectionInf = new ConnectionDBMgr("org.postgresql.Driver",url_1,username,password,"0");
                HosManage theHosManage;
                theHosManage = new HosManage(theConnectionInf,null);
                new DialogSearchSurvey(new javax.swing.JFrame(), true,theHosManage).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPre;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JPanel jPanelSearchItem;
    private javax.swing.JPanel jPanelShow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableShowList;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
    
}
