package com.report18file.gui;
/*
 * PanelReport18File.java
 *
 * Created on 16 �ԧ�Ҥ� 2548, 15:40 �.
 */

import com.hospital_os.usecase.connection.ConnectionInf;

import com.report18file.control.Rp18Control;
import com.report18file.help.ShowHelp18File;
import com.report18file.utility.Report18FileName;
import com.report18file.subject.ManageReport18File;
import com.report18file.utility.CellRendererReport;
import com.report18file.utility.Constant;
import com.report18file.utility.Language;
import com.report18file.utility.Report18FileData;
import com.report18file.utility.ShowCommonLine;
import com.reportcenter.utility.TableModelGUI;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
//import com.reportcenter.usecase.connection.*;
import com.hospital_os.object.*;
import com.hosv3.utility.connection.UpdateStatus;
import com.report18file.control.DBSuit;

/**
 *
 * @author  tong(padungrat)
 */
public class PanelReport extends javax.swing.JPanel implements ManageReport18File {

    public String cur_path = System.getProperty("user.dir");
    private boolean isSelectBetweenDate = false;
    private boolean isProcessRunning = false;
    /**��㹡�èѴ��áѺ cell 㹵��ҧ�������ç��ҧ*/
    private DefaultTableCellRenderer rendererCenter = new DefaultTableCellRenderer();
    /**��㹡�èѴ��áѺ cell 㹵��ҧ������ٻ Report*/
    private CellRendererReport cellRendererReport = new CellRendererReport();
    /**�� Object �ͧ 12 ��� ����к���ҵ�ͧ��èҡ��� save ������˹��ҧ*/
    private Report18FileName theReport18FileName;
    /**�繵�ǡ�˹� path �ͧ���*/
    private String select_path = "";
    /**�繵�ǡ�˹� ��� save �͡������쪹Դ�˹*/
    /**�繵�ǡ�˹� �ѹ������������*/
    private String startDate = "";
    /**�繵�ǡ�˹� �ѹ�������ش�ͧ��ä���*/
    private String endDate = "";
    /**�繵�ǡ�˹� Path�������*/
    private String oldPath = ".";
    /**�繡���ʴ� Dialog ���͡������ͧ��è� �ѹ�֡*/
    private JFileChooser chooser;
    private String[] col;
    /**�繵�ǡ�˹�����*/
    private int language = 1;
    /**�繵��������Ѻ��Ǩ�ͺ����͡�������͡�������� 0 ��� NHSO , 1 ��� DRG*/
    private int exportFor = 0;
    private ShowHelp18File theShowHelp18File;
    //private Rp18Control theHosControl;
    private Rp18Control theHosControl;
    private UpdateStatus theUS;
    private javax.swing.JMenuItem jMenuMapClinic = new javax.swing.JMenuItem();
    private ConnectionInf theConnectionInf;

    public PanelReport() {
        initComponents();
        setLanguage();
        initComboBox();
        setTableListReport();
        setNhsoMode(false);///////////////////////////////////////////////////////
        this.setEnabled(true);
    }

    public void setNhsoMode(boolean b) {
    }

    /**��㹡�� �� Dialog Help ���Ѻ Frame ��ѡ  */
    public Vector getMenuItem() {
        Vector vc = new Vector();
        javax.swing.JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
        theShowHelp18File = new ShowHelp18File();
        theShowHelp18File.addID(jMenuItem1);

        jMenuItem1.setText(Language.getTextBundle("Report18FileHelp", language));
        MenuItemPlugIn theMenuItemPlugIn = new MenuItemPlugIn();
        theMenuItemPlugIn.authen = true;
        theMenuItemPlugIn.theJMenuItem = jMenuItem1;
        vc.add(theMenuItemPlugIn);
        return vc;
    }

    /**
     *  ��㹡�á�˹� HosManage ���Ѻ Panel ��� ��ѧ�ҡ panel ����ա�� new Instance
     *  ��������� ����ա�����Ҩ� Enable panel ������ӧҹ
     *  @param theHosManage �� Object �ͧ HosManage
     */
    public void setConnection(Rp18Control rc, UpdateStatus us) {
        this.theHosControl = rc;
        theConnectionInf = rc.theConnectionInf;
        this.theHosControl.theGUISubject.registerGUI(this);
        ShowCommonLine.show("--- Pass set connection in report 12 files", false);
        this.setEnabled(true);
        theUS = us;
    }

    /**��㹡�� init ComboBox ����ա����ҹ*/
    public void initComboBox() {
//        for(int j=0;j<Constant.REPORT_TYPE.length;j++){
//
//            jComboBoxType.addItem(Constant.REPORT_TYPE[j]);
//
//        }
//
//        
//
//        jComboBoxType.setSelectedItem(Constant.REPORT_TYPE[2]);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelControl = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        dateComboBoxStartDate = new com.reportcenter.utility.DateComboBox();
        jLabelEndDate = new javax.swing.JLabel();
        dateComboBoxEndDate = new com.reportcenter.utility.DateComboBox();
        jCheckBoxSelectAll = new javax.swing.JCheckBox();
        jLabelStartDate = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanelButtonControl = new javax.swing.JPanel();
        jRadioButtonG1 = new javax.swing.JRadioButton();
        jRadioButtonG2 = new javax.swing.JRadioButton();
        jRadioButtonGpp = new javax.swing.JRadioButton();
        jRadioButtonG53 = new javax.swing.JRadioButton();
        jRadioButtonGpp1 = new javax.swing.JRadioButton();
        jRadioButtonG531 = new javax.swing.JRadioButton();
        jToggleButtonExportFail = new javax.swing.JCheckBox();
        jToggleButtonCheckDD = new javax.swing.JCheckBox();
        jToggleButtonAll = new javax.swing.JCheckBox();
        jLabelReport = new javax.swing.JLabel();
        printShowReportLogControl2 = new com.reportcenter.utility.PrintShowReportLogControl();
        jCheckBoxDBBackup = new javax.swing.JCheckBox();
        jPanelDetail = new javax.swing.JPanel();
        jScrollPaneReport = new javax.swing.JScrollPane();
        jTableReport = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        jPanelControl.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        dateComboBoxStartDate.setMinimumSize(new java.awt.Dimension(119, 28));
        dateComboBoxStartDate.setPreferredSize(new java.awt.Dimension(119, 28));
        dateComboBoxStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateComboBoxStartDateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(dateComboBoxStartDate, gridBagConstraints);

        jLabelEndDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEndDate.setText("�֧�ѹ���");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        jPanel1.add(jLabelEndDate, gridBagConstraints);

        dateComboBoxEndDate.setMinimumSize(new java.awt.Dimension(119, 28));
        dateComboBoxEndDate.setPreferredSize(new java.awt.Dimension(119, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(dateComboBoxEndDate, gridBagConstraints);

        jCheckBoxSelectAll.setText("���͡������");
        jCheckBoxSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSelectAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jCheckBoxSelectAll, gridBagConstraints);

        jLabelStartDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportcenter/images/process.gif"))); // NOI18N
        jLabelStartDate.setText("�ҡ�ѹ���");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(jLabelStartDate, gridBagConstraints);

        jLabelType.setText("��Դ�ͧ���");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        jPanel1.add(jLabelType, gridBagConstraints);

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dbf ���", "text ���" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(jComboBoxType, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanelControl.add(jPanel1, gridBagConstraints);

        jButtonOK.setFont(new java.awt.Font("Dialog", 0, 18));
        jButtonOK.setText("��ŧ");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanelControl.add(jButtonOK, gridBagConstraints);

        jButtonCancel.setFont(new java.awt.Font("Dialog", 0, 18));
        jButtonCancel.setText("¡��ԡ");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        jPanelControl.add(jButtonCancel, gridBagConstraints);

        jPanelButtonControl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelButtonControl.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(jRadioButtonG1);
        jRadioButtonG1.setText("ʹ�. ( 25 �.�. 51)");
        jRadioButtonG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonG1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelButtonControl.add(jRadioButtonG1, gridBagConstraints);

        buttonGroup1.add(jRadioButtonG2);
        jRadioButtonG2.setText("ʻʪ. (25 �.�. 51)");
        jRadioButtonG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonG2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelButtonControl.add(jRadioButtonG2, gridBagConstraints);

        buttonGroup1.add(jRadioButtonGpp);
        jRadioButtonGpp.setText("PP ��� ( 25 �.�. 51)");
        jRadioButtonGpp.setToolTipText("���������ͧ�ѹ�ҵðҹ�� 51");
        jRadioButtonGpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGppActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanelButtonControl.add(jRadioButtonGpp, gridBagConstraints);

        buttonGroup1.add(jRadioButtonG53);
        jRadioButtonG53.setText("ʻʪ.53 ( �.�. 53)");
        jRadioButtonG53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonG53ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanelButtonControl.add(jRadioButtonG53, gridBagConstraints);

        buttonGroup1.add(jRadioButtonGpp1);
        jRadioButtonGpp1.setText("PP ��� 53( �.�. 53)");
        jRadioButtonGpp1.setToolTipText("���������ͧ�ѹ�ҵðҹ�� 53");
        jRadioButtonGpp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGpp1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanelButtonControl.add(jRadioButtonGpp1, gridBagConstraints);

        buttonGroup1.add(jRadioButtonG531);
        jRadioButtonG531.setSelected(true);
        jRadioButtonG531.setText("ʹ�.53 ( �.�. 53)");
        jRadioButtonG531.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonG531ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelButtonControl.add(jRadioButtonG531, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 0, 0);
        jPanelControl.add(jPanelButtonControl, gridBagConstraints);

        buttonGroup2.add(jToggleButtonExportFail);
        jToggleButtonExportFail.setText("���͡��¡�÷������ҹ");
        jToggleButtonExportFail.setToolTipText("�ҡ������͡�����͡੾�з������ҹ");
        jToggleButtonExportFail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonExportFailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelControl.add(jToggleButtonExportFail, gridBagConstraints);

        buttonGroup2.add(jToggleButtonCheckDD);
        jToggleButtonCheckDD.setSelected(true);
        jToggleButtonCheckDD.setText("���͡��� Datadict");
        jToggleButtonCheckDD.setToolTipText("�ҡ������͡�����͡੾�з������ҹ");
        jToggleButtonCheckDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCheckDDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelControl.add(jToggleButtonCheckDD, gridBagConstraints);

        buttonGroup2.add(jToggleButtonAll);
        jToggleButtonAll.setText("���͡������");
        jToggleButtonAll.setToolTipText("�ҡ������͡�����͡੾�з������ҹ");
        jToggleButtonAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelControl.add(jToggleButtonAll, gridBagConstraints);

        jLabelReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportcenter/images/report.gif"))); // NOI18N
        jLabelReport.setText("�ҵðҹ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelControl.add(jLabelReport, gridBagConstraints);

        printShowReportLogControl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printShowReportLogControl2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 10);
        jPanelControl.add(printShowReportLogControl2, gridBagConstraints);

        jCheckBoxDBBackup.setText("��ͧ��ô֧��§ҹ�ҡ�ҹ���ͧ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelControl.add(jCheckBoxDBBackup, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 11, 0, 11);
        add(jPanelControl, gridBagConstraints);

        jPanelDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("��������´�ͧ��§ҹ"));
        jPanelDetail.setLayout(new java.awt.GridBagLayout());

        jTableReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableReportMouseReleased(evt);
            }
        });
        jScrollPaneReport.setViewportView(jTableReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelDetail.add(jScrollPaneReport, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 11, 11, 11);
        add(jPanelDetail, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonGppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGppActionPerformed
        jCheckBoxDBBackup.setEnabled(false);
        jCheckBoxDBBackup.setSelected(false);
        setTableListReport51();
        if(jCheckBoxSelectAll.isSelected()){
            jCheckBoxSelectAllActionPerformed(null);
        }
    }//GEN-LAST:event_jRadioButtonGppActionPerformed

    private void jRadioButtonG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonG2ActionPerformed
        jCheckBoxDBBackup.setEnabled(false);
        jCheckBoxDBBackup.setSelected(false);
        setTableListReport51();
        if(jCheckBoxSelectAll.isSelected()){
            jCheckBoxSelectAllActionPerformed(null);
        }
    }//GEN-LAST:event_jRadioButtonG2ActionPerformed

    private void jRadioButtonG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonG1ActionPerformed
        jCheckBoxDBBackup.setEnabled(false);
        jCheckBoxDBBackup.setSelected(false);
        setTableListReport51();
        if(jCheckBoxSelectAll.isSelected()){
            jCheckBoxSelectAllActionPerformed(null);
        }
    }//GEN-LAST:event_jRadioButtonG1ActionPerformed

    private void jCheckBoxSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSelectAllActionPerformed
        int length = this.jTableReport.getRowCount();
        if (jCheckBoxSelectAll.isSelected()) {
            this.jTableReport.setRowSelectionInterval(0, length - 1);
        } else {
            this.jTableReport.clearSelection();
        }
    }//GEN-LAST:event_jCheckBoxSelectAllActionPerformed

    private void dateComboBoxStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateComboBoxStartDateActionPerformed
//        Calendar c = Calendar.getInstance();
//        c.setTime(DateUtil.getDateFromText(dateComboBoxStartDate.getText()));
//        int month = c.get(Calendar.MONTH) + 1;
//        c.set(Calendar.MONTH,month);
//        String date_str = DateUtil.getTextDB(c.getTime(),false);
//        this.dateComboBoxEndDate.setText(DateUtil.getGuiDateTime(date_str));
    }//GEN-LAST:event_dateComboBoxStartDateActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        cancelProcess();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        queryReport();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jToggleButtonExportFailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonExportFailActionPerformed
        jToggleButtonCheckDDActionPerformed(null);
}//GEN-LAST:event_jToggleButtonExportFailActionPerformed

    private void jTableReportMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReportMouseReleased
    }//GEN-LAST:event_jTableReportMouseReleased

    private void jToggleButtonCheckDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCheckDDActionPerformed
        this.jComboBoxType.setEnabled(true);
        if (!jToggleButtonCheckDD.isSelected()) {
            this.jComboBoxType.setEnabled(false);
            this.jComboBoxType.setSelectedIndex(1);
            theUS.setStatus("����͡��§ҹ�������ҹ���͹� Datadict ���������ö���͡��ٻẺ DBF ��", UpdateStatus.WARNING);
        }
    }//GEN-LAST:event_jToggleButtonCheckDDActionPerformed

    private void jToggleButtonAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAllActionPerformed
        jToggleButtonCheckDDActionPerformed(null);
    }//GEN-LAST:event_jToggleButtonAllActionPerformed

    private void jRadioButtonG53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonG53ActionPerformed
        jCheckBoxDBBackup.setEnabled(true);
        setTableListReport();
        if(jCheckBoxSelectAll.isSelected()){
            jCheckBoxSelectAllActionPerformed(null);
        }
    }//GEN-LAST:event_jRadioButtonG53ActionPerformed

    private void jRadioButtonGpp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGpp1ActionPerformed
        jCheckBoxDBBackup.setEnabled(true);
        setTableListReportPP();
        if(jCheckBoxSelectAll.isSelected()){
            jCheckBoxSelectAllActionPerformed(null);
        }
    }//GEN-LAST:event_jRadioButtonGpp1ActionPerformed

    private void printShowReportLogControl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printShowReportLogControl2ActionPerformed
        try {
            printShowReportLogControl2.selectReportLog(theHosControl.theConnectionInf);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_printShowReportLogControl2ActionPerformed

    private void jRadioButtonG531ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonG531ActionPerformed
        jCheckBoxDBBackup.setEnabled(true);
        setTableListReport();
        if(jCheckBoxSelectAll.isSelected()){
            jCheckBoxSelectAllActionPerformed(null);
        }
    }//GEN-LAST:event_jRadioButtonG531ActionPerformed

    private void setTableListReport51() {
        TableModelGUI tm = new TableModelGUI(col, Report18FileData.reportName51.length);
        for (int i = 0; i < Report18FileData.reportName51.length; i++) {
            tm.setValueAt(String.valueOf(i + 1), i, 0);
            tm.setValueAt(Report18FileData.reportName51[i], i, 1);
            tm.setValueAt(Report18FileData.reportExplain51[i], i, 2);
        }
        jTableReport.setModel(tm);
        rendererCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTableReport.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableReport.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);
        jTableReport.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableReport.getColumnModel().getColumn(2).setPreferredWidth(750);
    }
    private void setTableListReport() {
        TableModelGUI tm = new TableModelGUI(col, Report18FileData.reportName.length);
        for (int i = 0; i < Report18FileData.reportName.length; i++) {
            tm.setValueAt(String.valueOf(i + 1), i, 0);
            tm.setValueAt(Report18FileData.reportName[i], i, 1);
            tm.setValueAt(Report18FileData.reportExplain[i], i, 2);
        }
        jTableReport.setModel(tm);
        rendererCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTableReport.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableReport.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);
        jTableReport.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableReport.getColumnModel().getColumn(2).setPreferredWidth(750);
    }

    private void setTableListReportPP() {
        TableModelGUI tm = new TableModelGUI(col, Report18FileData.reportNamePP.length);
        for (int i = 0; i < Report18FileData.reportNamePP.length; i++) {
            tm.setValueAt(String.valueOf(i + 1), i, 0);
            tm.setValueAt(Report18FileData.reportNamePP[i], i, 1);
            tm.setValueAt(Report18FileData.reportExplainPP[i], i, 2);
        }
        jTableReport.setModel(tm);
        rendererCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTableReport.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableReport.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);
        jTableReport.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableReport.getColumnModel().getColumn(2).setPreferredWidth(750);
    }

    /**
     *  ��㹡�� �������㹡�ä�����§ҹ��кѹ�֡ŧ������к�
     */
    public void queryReport() {
        System.out.println("public void queryReport()");
        /**��Ǩ�ͺ�ѹ�������㹪�ǧ��ԧ�������*/
        if (!isBetweenDateFormat()) {
            //��سҵ�Ǩ�ͺ�ѹ����͡��§ҹ�ա����
            JOptionPane.showMessageDialog(this, Language.getTextBundle("CheckDateForReport", language), Language.getTextBundle("Warning", language), JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (this.jTableReport.getSelectedRows().length == 0) {
            theUS.setStatus("��س����͡��§ҹ����ͧ����͡", UpdateStatus.WARNING);
            return;
        }
        ShowCommonLine.show("in isBetweenDateFormat()", false);
        if (!setPathFileToSave()) {
            theUS.setStatus("��سҡ�˹����˹觷���������§ҹ", UpdateStatus.WARNING);
            return;
        }
        setEnabled(false);
        jButtonCancel.setEnabled(true);
        isProcessRunning = true;
        ShowCommonLine.show("----- in setPathFileToSave()", false);
        /**������鹢ͧ��ä��Ң����� ��кѹ�֡ŧ���*/
        int index = 1;
        DBSuit dbs = null;
        if (this.jRadioButtonG1.isSelected()) {
            index = Rp18Control.STD_GOV;
            dbs = DBSuitS.getDBSuit(theUS, theConnectionInf);
        } else if (this.jRadioButtonG2.isSelected()) {
            index = Rp18Control.STD_NHSO;
            dbs = DBSuitNh.getDBSuit(theUS, theConnectionInf);
        } else if (this.jRadioButtonGpp.isSelected()) {
            index = Rp18Control.STD_PP;
            dbs = DBSuitPp.getDBSuit(theUS, theConnectionInf);
        }
        if(jCheckBoxDBBackup.isSelected()){
            ConnectionInf theConnectionInfDBBackup = com.hosv3.utility.Config.getConnectionInfDBBackupFromFile(theUS.getJFrame());
            if (this.jRadioButtonGpp1.isSelected()) {
                index = Rp18Control.STD_PP53;
                dbs = DBSuitPp53.getDBSuit(theUS, theConnectionInfDBBackup);
            } else if (this.jRadioButtonG53.isSelected()) {
                index = Rp18Control.STD_NHSO53;
                dbs = DBSuitNh53.getDBSuit(theUS, theConnectionInfDBBackup,theHosControl.theHO.date_time);
            } else if (this.jRadioButtonG531.isSelected()) {
                index = Rp18Control.STD_GOV;
                dbs = DBSuitNh53.getDBSuit(theUS, theConnectionInfDBBackup,theHosControl.theHO.date_time);
            }
        }else{
            if (this.jRadioButtonGpp1.isSelected()) {
                index = Rp18Control.STD_PP53;
                dbs = DBSuitPp53.getDBSuit(theUS, theConnectionInf);
            } else if (this.jRadioButtonG53.isSelected()) {
                index = Rp18Control.STD_NHSO53;
                dbs = DBSuitNh53.getDBSuit(theUS, theConnectionInf,theHosControl.theHO.date_time);
            } else if (this.jRadioButtonG531.isSelected()) {
                index = Rp18Control.STD_GOV;
                dbs = DBSuitNh53.getDBSuit(theUS, theConnectionInf,theHosControl.theHO.date_time);
            }
        }
        int export = 1;

        if (this.jToggleButtonAll.isSelected()) {
            export = Rp18Control.EXP_ALL;
        } else if (this.jToggleButtonCheckDD.isSelected()) {
            export = Rp18Control.EXP_PASS;
        } else if (this.jToggleButtonExportFail.isSelected()) {
            export = Rp18Control.EXP_FAIL;
        }


        try {
            if (this.jRadioButtonGpp1.isSelected()) {
                theHosControl.setDataExport18File(getReportPPFileName(), dateComboBoxStartDate.getText(), dateComboBoxEndDate.getText(), select_path, String.valueOf(jComboBoxType.getSelectedIndex()), export, index, dbs);
            } else {
                theHosControl.setDataExport18File(getReport18FileName(), dateComboBoxStartDate.getText(), dateComboBoxEndDate.getText(), select_path, String.valueOf(jComboBoxType.getSelectedIndex()), export, index, dbs);
            }
            this.theHosControl.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**��㹡�� ��ش��÷ӧҹ�ͧ ����� ��������ӧҹ㹢�й�� ���ʴ� Dialog ��͹
     *
     */
    public void cancelProcess() {
        /**��Ǩ�ͺʶҹТͧ��÷ӧҹ*/
        if (isProcessRunning) {
            /**��������׹�ѹ*/
            int choose = JOptionPane.showConfirmDialog(this, Language.getTextBundle("ConformStopProcess", language), Language.getTextBundle("Warning", language), JOptionPane.OK_CANCEL_OPTION);
            /**��Ǩ�ͺ����׹�ѹ*/
            if (choose == JOptionPane.OK_OPTION && this.theHosControl != null) {
                /**��ش��÷ӧҹ�ͧ�����*/
                this.theHosControl.stop();
                this.setEnabled(true);
            }
        }

    }

    /**
     *  ��㹡�á�˹���� Panel �������ö�ӧҹ���������
     *  @param isEnable �� boolean ����� true �к��������ö�ӧҹ��
     * , false �к�����������ö�ӧҹ��
     */
    public void setEnabled(boolean isEnable) {
        //jComboBoxReport.setEnabled(isEnable);
        this.jRadioButtonG1.setEnabled(isEnable);
        this.jRadioButtonG2.setEnabled(isEnable);
        jComboBoxType.setEnabled(isEnable);
        dateComboBoxStartDate.setEnabled(isEnable);
        dateComboBoxEndDate.setEnabled(isEnable);
        jCheckBoxSelectAll.setEnabled(isEnable);
        jButtonOK.setEnabled(isEnable);
        jToggleButtonExportFail.setEnabled(isEnable);
        jToggleButtonAll.setEnabled(isEnable);
        jToggleButtonCheckDD.setEnabled(isEnable);
        //  jButtonCancel.setEnabled(isEnable);
        jTableReport.setEnabled(isEnable);
        jScrollPaneReport.setEnabled(isEnable);
        jRadioButtonG53.setEnabled(isEnable);
        jRadioButtonG531.setEnabled(isEnable);
        jRadioButtonGpp.setEnabled(isEnable);
        this.jRadioButtonGpp1.setEnabled(isEnable);
        this.printShowReportLogControl2.setEnabled(isEnable);
    }

    /**��㹡������ҷ�����͡�����ҧ ������͡��§ҹ���ú�ҧ ੾�� PP53
     *  @return �� Report18FileName ��觨��� �����ŷ��͡�����§ҹ���е�ǵ�ͧ� query �������
     */
    private Report18FileName getReportPPFileName() {
        System.out.println("private Report18FileName getReport18FileName(){");
        theReport18FileName = new Report18FileName();
        int[] rows = jTableReport.getSelectedRows();
//        System.out.println("row[i] = " + rows.length);

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 0) {
                theReport18FileName.Chronic = Constant.SELECTED;
            } else if (rows[i] == 1) {
                theReport18FileName.Serveil = Constant.SELECTED;
            } else if (rows[i] == 2) {
                theReport18FileName.Woman = Constant.SELECTED;
            } else if (rows[i] == 3) {
                theReport18FileName.Fp = Constant.SELECTED;
            } else if (rows[i] == 4) {
                theReport18FileName.Epi = Constant.SELECTED;
            } else if (rows[i] == 5) {
                theReport18FileName.Nutrition = Constant.SELECTED;
            } else if (rows[i] == 6) {
                theReport18FileName.Anc = Constant.SELECTED;
            } else if (rows[i] == 7) {
                theReport18FileName.Pp = Constant.SELECTED;
            } else if (rows[i] == 8) {
                theReport18FileName.Mch = Constant.SELECTED;
            }
        }
        return theReport18FileName;
    }

    /**��㹡������ҷ�����͡�����ҧ ������͡��§ҹ���ú�ҧ
     *  @return �� Report18FileName ��觨��� �����ŷ��͡�����§ҹ���е�ǵ�ͧ� query �������
     */
    private Report18FileName getReport18FileName() {
        System.out.println("private Report18FileName getReport18FileName(){");
        theReport18FileName = new Report18FileName();
        int[] rows = jTableReport.getSelectedRows();
//        System.out.println("row[i] = " + rows.length);

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 0) {
                theReport18FileName.Person = Constant.SELECTED;
            } else if (rows[i] == 1) {
                theReport18FileName.Death = Constant.SELECTED;
            } else if (rows[i] == 2) {
                theReport18FileName.Chronic = Constant.SELECTED;
            } else if (rows[i] == 3) {
                theReport18FileName.Card = Constant.SELECTED;
            } else if (rows[i] == 4) {
                theReport18FileName.Service = Constant.SELECTED;
            } else if (rows[i] == 5) {
                theReport18FileName.Diag = Constant.SELECTED;
            } else if (rows[i] == 6) {
                theReport18FileName.Appoint = Constant.SELECTED;
            } else if (rows[i] == 7) {
                theReport18FileName.Serveil = Constant.SELECTED;
            } else if (rows[i] == 8) {
                theReport18FileName.Drug = Constant.SELECTED;
            } else if (rows[i] == 9) {
                theReport18FileName.Proced = Constant.SELECTED;
            } else if (rows[i] == 10) {
                theReport18FileName.Woman = Constant.SELECTED;
            } else if (rows[i] == 11) {
                theReport18FileName.Fp = Constant.SELECTED;
            } else if (rows[i] == 12) {
                theReport18FileName.Epi = Constant.SELECTED;
            } else if (rows[i] == 13) {
                theReport18FileName.Nutrition = Constant.SELECTED;
            } else if (rows[i] == 14) {
                theReport18FileName.Anc = Constant.SELECTED;
            } else if (rows[i] == 15) {
                theReport18FileName.Pp = Constant.SELECTED;
            } else if (rows[i] == 16) {
                theReport18FileName.Mch = Constant.SELECTED;
            } else if (rows[i] == 17) {
                theReport18FileName.Home = Constant.SELECTED;
            }
        }
        return theReport18FileName;
    }

    /**
     *  ��㹡�õ�Ǩ�ͺ �ѹ���������� �Ѻ�ѹ�������ش���ѹ���ǡѹ������� ������ѹ���ǡѹ
     *  ��� return �� false ����������� return �� true
     *  @return boolean true ����� false ���
     */
    private boolean isBetweenDateFormat() {
        /**��˹�����ѹ���*/
        System.out.print("check gettext1");
        this.startDate = dateComboBoxStartDate.getText();
        this.endDate = dateComboBoxEndDate.getText();
        System.out.print("check gettext2");

        /**��Ǩ�ͺ�ѹ�������������ѹ���ǡѹ�Ѻ�ѹ�������ش�������*/
        if (startDate.compareTo(endDate) <= 0) {
            isSelectBetweenDate = true;
        } else {
            isSelectBetweenDate = false;
        }
        return isSelectBetweenDate;
    }

    /**��㹡�����͡ Folder ����ͧ��èкѹ�֡���
     *@return �� boolean
     */
    public boolean setPathFileToSave() {
        boolean isSetPathFileDone = false;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(oldPath));


        //��س����͡ path ������ͧ��úѹ�֡
        chooser.setDialogTitle(Language.getTextBundle("ChoosePathToSave", language));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setApproveButtonText("Save");

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ShowCommonLine.show("getCurrentDirectory(): " + chooser.getCurrentDirectory(), false);

            /**�� path ���������*/
            oldPath = chooser.getSelectedFile().toString();
            /**���� path ��������*/
            select_path = chooser.getSelectedFile().toString() + "/";
            isSetPathFileDone = true;
        } else {
            isSetPathFileDone = false;
        }
        return isSetPathFileDone;
    }

    /**
     *  ��㹡���ʴ������ź����ҧ
     *  @param isShowList
     *  @param isSelectAll
     *
     */
    public static void main(String args[]) {
        try {
            //      UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        PanelReport thePanelReport12File = new PanelReport();
        JFrame frm = new JFrame("PanelReport12File");

        frm.getContentPane().add(thePanelReport12File);
        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

    /**��㹡���ʴ�����*/
    private void setLanguage() {

        jLabelReport.setText(Language.getTextBundle("ReportType", language));
        jLabelType.setText(Language.getTextBundle("SaveType", language));
        jLabelStartDate.setText(Language.getTextBundle("StartDate", language));
        jLabelEndDate.setText(Language.getTextBundle("FinishDate", language));
        jCheckBoxSelectAll.setText(Language.getTextBundle("SelectAll", language));

        jPanelDetail.setBorder(new javax.swing.border.TitledBorder(Language.getTextBundle("DetailReport", language)));

        jButtonOK.setText(Language.getTextBundle("OK", language));
        jButtonCancel.setText(Language.getTextBundle("Cancel", language));

        col = new String[3];
        col[0] = "no";//Language.getTextBundle("Sequence",language);
        col[1] = "name";//Language.getTextBundle("ReportName",language);
        col[2] = Language.getTextBundle("Description", language);


    }

    public void onShowStatus(String str, java.awt.Color color) {
        onShowStatus(str, color, false);
    }

    public void onShowStatus(String str, java.awt.Color color, boolean isFinish) {
        if (isFinish) {
            theUS.setStatus(str, UpdateStatus.COMPLETE);
        } else {
            if (color.equals(Color.RED)) {
                theUS.setStatus(str, UpdateStatus.ERROR);
            } else {
                theUS.setStatus(str, UpdateStatus.WARNING);
            }
        }
    }

    public void onShowPicture(String pic, boolean isVisible) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.reportcenter.utility.DateComboBox dateComboBoxEndDate;
    private com.reportcenter.utility.DateComboBox dateComboBoxStartDate;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JCheckBox jCheckBoxDBBackup;
    private javax.swing.JCheckBox jCheckBoxSelectAll;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JLabel jLabelEndDate;
    private javax.swing.JLabel jLabelReport;
    private javax.swing.JLabel jLabelStartDate;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelButtonControl;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JRadioButton jRadioButtonG1;
    private javax.swing.JRadioButton jRadioButtonG2;
    private javax.swing.JRadioButton jRadioButtonG53;
    private javax.swing.JRadioButton jRadioButtonG531;
    private javax.swing.JRadioButton jRadioButtonGpp;
    private javax.swing.JRadioButton jRadioButtonGpp1;
    private javax.swing.JScrollPane jScrollPaneReport;
    private javax.swing.JTable jTableReport;
    private javax.swing.JCheckBox jToggleButtonAll;
    private javax.swing.JCheckBox jToggleButtonCheckDD;
    private javax.swing.JCheckBox jToggleButtonExportFail;
    private com.reportcenter.utility.PrintShowReportLogControl printShowReportLogControl2;
    // End of variables declaration//GEN-END:variables
}