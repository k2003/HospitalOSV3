/*
 * PanelEpiPCU.java
 *
 * Created on 30 �չҤ� 2549, 17:08 �.
 */

package com.generalpcu.gui.panel;

import com.generalpcu.utility.ComboboxModel;
import com.generalpcu.utility.Constant;
import com.generalpcu.utility.Report;
import com.generalpcu.utility.TableModelGUI;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;
import com.generalpcu.control.ManageControlSubject;
import com.generalpcu.gui.panel.DialogShowStatus;
import com.generalpcu.utility.Language;
import com.generalpcu.usecase.AllPanelResp;
import com.generalpcu.usecase.GUIResp;
import com.generalpcu.usecase.CardNameControl;
/**
 *
 * @author  Ojika
 */
public class PanelEpiPCU extends javax.swing.JPanel implements 
AllPanelResp,GUIResp,CardNameControl,Runnable
{
    
    /** Creates new form PanelEpiPCU */
    public ManageControlSubject theMCS;
    private ComboboxModel theComboboxModel;
    DefaultTableCellRenderer rendererCenter;
    DefaultTableCellRenderer rendererRight;
    
    final private String cardName;
    private String startDate;
    private String endDate;
    Thread theThread;
    DialogShowStatus theDialogShowStatus;
    
    /*Vector �ͧ�����ŷ����ҡ��ä�����§ҹ**/
    Vector vcData;
    String[] headColumn;
    Vector vcDataQuery;
    TableModelGUI theTableModelGUI;
    
    /**���ͺ͡��ҡ��ѧ���͡��§ҹ�������� 1 ��� ��ª��� , 2 ��� �ӹǹ�ҡ��Թԡ�آ�Ҿ�硴� , 3 ��� �ӹǹ�Ҵ���ѡ*/
    int selectReport = 1;
    private boolean isDbBackup;
            
    public PanelEpiPCU(ManageControlSubject manageControlSubject)
    {
        initComponents();
        
        theMCS = manageControlSubject;
        theMCS.theManageSubject.theGUISubject.registerGUIManage(this);
        theMCS.theManageSubject.theAllPanelSubject.registerAllPanelManage(this);
        cardName = ((Report)Constant.Report.get("7")).ENG_NAME;
        initComboboxVillage();
        setLanguage();
        setEnabledGuiSubReport(false);
        theDialogShowStatus = new DialogShowStatus(theMCS.theUS.getJFrame(),false,this.theMCS);
    }
    /*
     * �ʴ����� card �ͧ panel
     **/
    public String getCardName()
    {
        return this.cardName;
    }
    
    /**
     * �絤������������Ѻ ComboBox �ͧ�����ҹ
     * @Author Ojika
     * @Date 31/03/2549
     */
    private void initComboboxVillage()
    {
        this.theComboboxModel.initComboBox(this.jComboBoxVillage,this.theMCS.theManageControl.theComboBoxControl.listVillage());
        this.theComboboxModel.setCodeComboBox(this.jComboBoxVillage, "0");
        
        this.theComboboxModel.initComboBox(this.jComboBoxEpiAgeGroup,this.theMCS.theManageControl.theComboBoxControl.listEpiAgeGroup());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonCountOfEpiReport = new javax.swing.JRadioButton();
        jRadioButtonNameOfEpiReport = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxVillage = new javax.swing.JComboBox();
        jRadioButtonWellBabyClinic = new javax.swing.JRadioButton();
        jRadioButtonTTClinic = new javax.swing.JRadioButton();
        jComboBoxEpiAgeGroup = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        fixedColumnScrollPane1 = new com.hospital_os.utility.FixedColumnScrollPane();
        jTableShowReport = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("SelectReportForQuery");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        buttonGroup1.add(jRadioButtonCountOfEpiReport);
        jRadioButtonCountOfEpiReport.setText("CountOfEpi");
        jRadioButtonCountOfEpiReport.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonCountOfEpiReportActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jRadioButtonCountOfEpiReport, gridBagConstraints);

        buttonGroup1.add(jRadioButtonNameOfEpiReport);
        jRadioButtonNameOfEpiReport.setSelected(true);
        jRadioButtonNameOfEpiReport.setText("NameOfEpi");
        jRadioButtonNameOfEpiReport.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonNameOfEpiReportActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jRadioButtonNameOfEpiReport, gridBagConstraints);

        jLabel2.setText("SelectVillage");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jComboBoxVillage, gridBagConstraints);

        buttonGroup2.add(jRadioButtonWellBabyClinic);
        jRadioButtonWellBabyClinic.setSelected(true);
        jRadioButtonWellBabyClinic.setText("WellBabyClinic");
        jRadioButtonWellBabyClinic.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonWellBabyClinicActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jRadioButtonWellBabyClinic, gridBagConstraints);

        buttonGroup2.add(jRadioButtonTTClinic);
        jRadioButtonTTClinic.setText("TTClinic");
        jRadioButtonTTClinic.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonTTClinicActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jRadioButtonTTClinic, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jComboBoxEpiAgeGroup, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jTableShowReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTableShowReport.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        fixedColumnScrollPane1.setViewportView(jTableShowReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(fixedColumnScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jTextArea1.setRows(3);
        jTextArea1.setText("\u0e23\u0e32\u0e22\u0e07\u0e32\u0e19\u0e27\u0e31\u0e04\u0e0b\u0e35\u0e19 \u0e41\u0e1a\u0e48\u0e07\u0e2d\u0e2d\u0e01\u0e40\u0e1b\u0e47\u0e19 2 \u0e2a\u0e48\u0e27\u0e19 \n - \u0e23\u0e32\u0e22\u0e0a\u0e37\u0e48\u0e2d\u0e40\u0e14\u0e47\u0e01\u0e17\u0e35\u0e48\u0e44\u0e14\u0e49\u0e23\u0e31\u0e1a\u0e27\u0e31\u0e04\u0e0b\u0e35\u0e19 \u0e08\u0e30\u0e15\u0e23\u0e27\u0e08\u0e2a\u0e2d\u0e1a\u0e2d\u0e32\u0e22\u0e38\u0e08\u0e32\u0e01 \u0e27\u0e31\u0e19\u0e17\u0e35\u0e48\u0e2a\u0e34\u0e49\u0e19\u0e2a\u0e38\u0e14\u0e01\u0e32\u0e23\u0e14\u0e36\u0e07\u0e02\u0e49\u0e2d\u0e21\u0e39\u0e25\u0e27\u0e48\u0e32 \u0e21\u0e35\u0e2d\u0e32\u0e22\u0e38 \u0e44\u0e21\u0e48\u0e40\u0e01\u0e34\u0e19 5 \u0e1b\u0e35 \u0e1a\u0e23\u0e34\u0e1a\u0e39\u0e23\u0e13\u0e4c\n - \u0e08\u0e33\u0e19\u0e27\u0e19\u0e1c\u0e39\u0e49\u0e17\u0e35\u0e48\u0e44\u0e14\u0e49\u0e23\u0e31\u0e1a\u0e27\u0e31\u0e04\u0e0b\u0e35\u0e19 \u0e41\u0e1a\u0e48\u0e07\u0e2d\u0e2d\u0e01\u0e40\u0e1b\u0e47\u0e19 2 \u0e04\u0e25\u0e34\u0e19\u0e34\u0e01 \u0e44\u0e14\u0e49\u0e41\u0e01\u0e48 \u0e04\u0e25\u0e34\u0e19\u0e34\u0e01\u0e2a\u0e38\u0e02\u0e20\u0e32\u0e1e\u0e40\u0e14\u0e47\u0e01\u0e14\u0e35 \u0e41\u0e25\u0e30 \u0e04\u0e25\u0e34\u0e19\u0e34\u0e01\u0e01\u0e32\u0e23\u0e23\u0e31\u0e1a\u0e27\u0e31\u0e04\u0e0b\u0e35\u0e19\u0e1a\u0e32\u0e14\u0e17\u0e30\u0e22\u0e31\u0e01 (TT)");
        jTextArea1.setMinimumSize(new java.awt.Dimension(0, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jTextArea1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents

    private void jRadioButtonTTClinicActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonTTClinicActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonTTClinicActionPerformed
        // ���͡��§ҹ������ �Ҵ���ѡ
        this.jComboBoxEpiAgeGroup.setEnabled(false);
        this.selectReport = 3;
    }//GEN-LAST:event_jRadioButtonTTClinicActionPerformed

    private void jRadioButtonWellBabyClinicActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonWellBabyClinicActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonWellBabyClinicActionPerformed
        // ���͡��§ҹ������ ��Թԡ�آ�Ҿ�硴�
        this.jComboBoxEpiAgeGroup.setEnabled(true);
        this.selectReport = 2;
    }//GEN-LAST:event_jRadioButtonWellBabyClinicActionPerformed

    private void jRadioButtonNameOfEpiReportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonNameOfEpiReportActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonNameOfEpiReportActionPerformed
        // ���͡��§ҹ��ª���
        setEnabledGuiSubReport(false);
        this.selectReport = 1;
    }//GEN-LAST:event_jRadioButtonNameOfEpiReportActionPerformed

    private void jRadioButtonCountOfEpiReportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonCountOfEpiReportActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonCountOfEpiReportActionPerformed
        // ���͡�ӹǹ
        setEnabledGuiSubReport(true);
        this.jRadioButtonWellBabyClinic.setSelected(true);
        jRadioButtonWellBabyClinicActionPerformed(evt);
        this.selectReport = 2;
    }//GEN-LAST:event_jRadioButtonCountOfEpiReportActionPerformed
    /*
     * �觪��� File �����������´������͡������§ҹ
     * @Author Ojika
     * @Date 31/03/2549
     **/
    public String getNameReport()
    {
        if(this.selectReport == 1)
        {
            return "_listPatient";
        }
        else if(this.selectReport == 2)
        {
            return "_amountWellbaby";
        }
        else if(this.selectReport == 3)
        {
            return "_amountTT";
        }
        else
        {
            return "";
        }
    }
    
    /**��㹡�� Clear �����ŷ�����躹���ҧ*/
    private void clearDataGUI()
    {
        vcData = null;
        showDataInTable(null,null);
        System.out.println("Clear Data in GUI");
    }
    /*
     * �觤�� Vector ����Ѻ Save
     * @Author Ojika
     * @Date 31/03/2549
     **/
    public Vector getEpiPCU()
    {
        return this.vcData;
    }
    
    private void startQuery()
    {
        theThread = new Thread(this);
        theThread.start();
    }
    
    /*
     *  ��㹡���Ѻ�����Ũҡ ��ä��� ����觤������� panel ���
     *  �������ӡ�� Query ��Ф�����¡�õ����͡�˹��ͧ panel
     *  @param startDate �� String ���ѹ���������� ������ٻẺ yyyy-mm-dd
     *  @param endDate �� String ���ѹ�������ش ������ٻẺ yyyy-mm-dd
     **/
    public void setQueryReport(String startDate, String endDate, boolean dbBackup)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        isDbBackup = dbBackup;
        startQuery();
    }
    
    /**
     * �� GUI ���͡���ʴ������ǹ�ͧ��§ҹ����
     * @Author Ojika
     * @Date 31/03/2549
     **/
    private void setEnabledGuiSubReport(boolean b)
    {
        this.jRadioButtonWellBabyClinic.setEnabled(b);
        this.jRadioButtonTTClinic.setEnabled(b);
        this.jComboBoxEpiAgeGroup.setEnabled(b);
    }
    
    private void showDataInTable(String[] columnname,Vector vc)
    {
        
        String[] col = columnname;
        
        int size = 0;
        if(vc != null)
        {
            theTableModelGUI = new TableModelGUI(col,vc.size());
            size = vc.size();
            //ǹ�ٻ ��� 1 ��
            for(int i=0 ;i<size; i++)
            {    //ǹ�ٻ��ͧ column
                String[] rowdata = (String[])vc.get(i);
                
                for(int j = 0 ; j < rowdata.length ;j++)
                {
                    theTableModelGUI.setValueAt(rowdata[j],i,j);
                }
                theTableModelGUI.setEditingCol(rowdata.length+1);
                
                rowdata = null;
            }
        }
        else
        {
            theTableModelGUI= new TableModelGUI(col,0);
        }
        this.jTableShowReport.setModel(theTableModelGUI);
        if(this.selectReport == 1)
        {
            jTableShowReport.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            fixedColumnScrollPane1.setViewportView(jTableShowReport);
            if(col!= null && col.length!= 0)
            {
                fixedColumnScrollPane1.setFixedColumnScrollPane(jTableShowReport, 1, 100);
                setTableListReportPattern(col);
            }
            else
            {
                fixedColumnScrollPane1.setFixedColumnScrollPane(jTableShowReport, 0, 100);
                setTableListReportPattern(new String[0]);
            }
        }
        else
        {
            jTableShowReport.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
            fixedColumnScrollPane1.setViewportView(jTableShowReport);
            fixedColumnScrollPane1.setFixedColumnScrollPane(jTableShowReport,0, 0);
            // ��Ǩ�ͺ��� null ��͹��ҿѧ��ѹ setTableListReportPattern sumo 21/10/2549
            if(col!= null && col.length!= 0)
            {
                setTableListReportPattern(col);
            }
            else
            {
                setTableListReportPattern(new String[0]);
            }          
        }
        sendDataToMainReport(size);
    }
    
    /**
     * �Ѵ����ʴ��ź����ҧ
     * @Para col �� column �ͧ�����ŷ���ʴ�㹵��ҧ
     * @Author Ojika
     * @Date 08/04/2549
     **/
    private void setTableListReportPattern(String [] col)
    {
        if(rendererCenter == null )
        {
            rendererCenter = new DefaultTableCellRenderer();
        }
        if(rendererRight == null)
        {
            rendererRight = new DefaultTableCellRenderer();
        }
        rendererCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        rendererRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        String[] col_number = col;
        int size = 0;
        if(col_number != null)
            size = col_number.length;
        else
            size = 0;
        
        // 1 ��� ��ª��� , 2 ��� �ӹǹ�ҡ��Թԡ�آ�Ҿ�硴� , 3 ��� �ӹǹ�Ҵ���ѡ
        if(this.selectReport == 1)
        {
            for(int i=0;i<size-1;i++)
            {
                if(i == 0)
                {
                    jTableShowReport.getColumnModel().getColumn(i).setPreferredWidth(150);
                }
                else if(i==1)
                {
                    jTableShowReport.getColumnModel().getColumn(i).setPreferredWidth(60);
                }
                else if(i==1 || i==2 || i==3)
                {
                    jTableShowReport.getColumnModel().getColumn(i).setPreferredWidth(100);
                }
                else if(i >= 4 && i <= 7)
                {
                    jTableShowReport.getColumnModel().getColumn(i).setCellRenderer(rendererRight);
                    jTableShowReport.getColumnModel().getColumn(i).setPreferredWidth(80);
                }
                else if(i==8 || i==9)
                {
                    jTableShowReport.getColumnModel().getColumn(i).setPreferredWidth(80);
                }
                else
                {
                    jTableShowReport.getColumnModel().getColumn(i).setPreferredWidth(130);
                }
            }
        }
        else// if(this.selectReport == 2 || this.selectReport == 3 )
        {
            for(int i=0;i<size;i++)
            {
                if(i == 1)
                {
                    jTableShowReport.getColumnModel().getColumn(i).setCellRenderer(rendererCenter);
                    jTableShowReport.getColumnModel().getColumn(i).setPreferredWidth(50);
                }
            }
        }
    }
    
    /**
     *  ��㹡����ʶҹ�����ʴ� �����ѹ�֡������� �¨е�Ǩ�ͺ�ҡ size �ͧ���ҧ
     */
    private void sendDataToMainReport(int size)
    {
        theMCS.theManageSubject.theMainReportSubject.notifyShowSaveToFile(false);
        if(size > 0)
        {
            theMCS.theManageSubject.theMainReportSubject.notifyShowSaveToFile(true);
        }
    }
    
    /**
     * Query �����ŵ����ǧ�ѹ������˹� ����Ѻ�ʴ�㹵��ҧ
     * @Author Ojika
     * @Date 31/03/2549
     */
    private void queryDataByDate()
    {
        theDialogShowStatus.setVisible(false);
        theDialogShowStatus.showDialog("��س����ѡ����",false);
        
        String EpiAgeGroupId = "";
        if(this.selectReport == 2)
        {
            EpiAgeGroupId = this.theComboboxModel.getCodeComboBox(this.jComboBoxEpiAgeGroup);
        }
        
        String selectVillage = this.theComboboxModel.getCodeComboBox(this.jComboBoxVillage);
        
        vcData = this.theMCS.theManageControl.theGeneralPCUControl.selectEpiPcu(this.selectReport
                , selectVillage
                , EpiAgeGroupId
                ,this.startDate
                , this.endDate
                ,isDbBackup);
        
        headColumn = new String[] {""};
        vcDataQuery = new Vector();
        if(vcData != null)
        {
            headColumn = (String[])vcData.get(0);
            vcDataQuery = (Vector)vcData.get(1);
        }
        
        showDataInTable(headColumn, vcDataQuery);
        theDialogShowStatus.setVisible(false);
    }
    
    public void setLanguage()
    {
        jLabel1.setText(Language.getTextBundle(jLabel1.getText()));
        jRadioButtonNameOfEpiReport.setText(Language.getTextBundle(jRadioButtonNameOfEpiReport.getText()));
        jRadioButtonCountOfEpiReport.setText(Language.getTextBundle(jRadioButtonCountOfEpiReport.getText()));
        jRadioButtonWellBabyClinic.setText(Language.getTextBundle(jRadioButtonWellBabyClinic.getText()));
        jRadioButtonTTClinic.setText(Language.getTextBundle(jRadioButtonTTClinic.getText()));
        jLabel2.setText(Language.getTextBundle(jLabel2.getText()));
        
        //jPanel3.setBorder(new javax.swing.border.TitledBorder(Language.getTextBundle("Description")));
        
        jLabel3.setText(Language.getTextBundle(jLabel3.getText()));
    }
    
    public void run()
    {
        this.queryDataByDate();
    }
    
    public void notifySetInitAllGUI()
    {
        clearDataGUI();
    }
    public void notifyStopProcess()
    {
        try
        {
            if(theThread != null)
            {
                theThread.stop();
            }
            theThread = null;
            System.out.println("In stop in PanelPregnancePCU");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.hospital_os.utility.FixedColumnScrollPane fixedColumnScrollPane1;
    private javax.swing.JComboBox jComboBoxEpiAgeGroup;
    private javax.swing.JComboBox jComboBoxVillage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonCountOfEpiReport;
    private javax.swing.JRadioButton jRadioButtonNameOfEpiReport;
    private javax.swing.JRadioButton jRadioButtonTTClinic;
    private javax.swing.JRadioButton jRadioButtonWellBabyClinic;
    private javax.swing.JTable jTableShowReport;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
}
