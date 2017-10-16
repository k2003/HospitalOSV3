/*
 * PanelReport506Surveil.java
 *
 * Created on 8 �ѹ��¹ 2548, 11:16 �.
 */

package com.standardReport.gui.panel;

import com.standardReport.subject.ManageAllPanel;
import com.standardReport.object.FileName;
import com.standardReport.subject.StandardGui;
import com.standardReport.control.HosControl;
import com.standardReport.object.RP506Surveil;
import com.standardReport.utility.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;
import com.standardReport.subject.TableModelGUI;;
/**
 *
 * @author  americus
 */
public class PanelReport506Surveil extends javax.swing.JPanel implements StandardGui,
        ManageAllPanel
{
    
    private HosControl theHosControl;
    private boolean isProcessRunning = false;
    DefaultTableCellRenderer rendererCenter;
    DefaultTableCellRenderer rendererRight;
    public String cur_path = System.getProperty("user.dir");
    private String select_path = "";
    private String fileType = "";
    private String startDate ="";
    private String endDate = "";
    private String treatStatus = "";
    
    public Vector vcRp506Surveil;
    public RP506Surveil theRP506Surveil;
    public FileName theFileName;
    private String cardName = "RP506Surveil";
    /*Vector �ͧ�����ŷ����ҡ��ä�����§ҹ**/
    Vector vcData;
    String[] headColumn;
    Vector vcDataQuery;
    TableModelGUI theTableModelGUI;
    /**
     * Creates new form PanelReport506Surveil
     */
    public PanelReport506Surveil(HosControl hcl)
    {
        this.theHosControl = hcl;
        theHosControl.theHosSubject.theAllPanelSubject.registerAllPanelManage(this);
        initComponents();
        setFileName();
        setLanguage();
    }
    public void setFileName()
    {
        theFileName = new FileName();
    }
    public void setProcessRunning(boolean isProcessRunning)
    {
        this.isProcessRunning = isProcessRunning;
    }

    public void chooseAll() {
        int[] rows = this.jTableReport506Followpatient.getSelectedRows();
        theHosControl.theRP506SurveilControl.printIReport(vcDataQuery,rows);
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

        jPanelDetail = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fixedColumnScrollPane1 = new com.hospital_os.utility.FixedColumnScrollPane();
        jTableReport506Followpatient = new com.hosv3.gui.component.HJTableSort();

        setLayout(new java.awt.GridBagLayout());

        jPanelDetail.setLayout(new java.awt.GridBagLayout());

        jPanelDetail.setBorder(new javax.swing.border.TitledBorder("ReportDetail"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jTableReport506Followpatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTableReport506Followpatient.setAutoResizeMode(com.hosv3.gui.component.HJTableSort.AUTO_RESIZE_OFF);
        fixedColumnScrollPane1.setViewportView(jTableReport506Followpatient);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(fixedColumnScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelDetail.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanelDetail, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
     public String getCardName()
    {
        return this.cardName;
    }
    
    public void setFileDescription(boolean isDbBackup)
    {
           // setEnableGUI(false);
            setProcessRunning(true);
            try
            {
                //theHosControl.setDataExportFile(this.getReportFileName(), startDate, endDate, select_path, fileType);
                if(theHosControl == null)
                {
                    System.out.println("----------HosControl --null-------------");
                    return;
                }
                this.vcRp506Surveil = theHosControl.theRP506SurveilControl.selectRP506SurveilByDate(this.startDate,this.endDate, this.treatStatus,isDbBackup);
                if(vcRp506Surveil != null)
                {
                    System.out.println("-----vcEmployee--------"+vcRp506Surveil.size());
                }
             //   this.setTableRp506FollowPatient();
                if(vcRp506Surveil != null)
                {
                    System.out.println("-----vcEmployee--------"+vcRp506Surveil.size());
                }
                headColumn = new String[] {""};
                Vector vcDataQuery = new Vector();
                if(vcRp506Surveil != null)
                {
                    headColumn = (String[])vcRp506Surveil.get(0);
                    vcDataQuery = (Vector)vcRp506Surveil.get(1);
                }
                
                showDataInTable(headColumn, vcDataQuery);
                //theHosControl.start();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    public void ExportFile()
    {
        setProcessRunning(true);
        try
        {
            //theHosControl.setDataExportFile(this.getReportFileName(), startDate, endDate, select_path, fileType);
            if(theHosControl == null)
            {
                System.out.println("----------HosControl --null-------------");
                return;
            }
            theHosControl.theExportControl.startExportSurviel(this.vcRp506Surveil,this.select_path,this.fileType,theFileName.getRP506Surveil());
            // theHosControl.setDataExportFile(this.vcRp504Droup,theFileName.getRP504Group(),this.startDate,this.endDate,this.select_path,this.fileType,this.reportType);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     *  ��㹡����ʶҹ�����ʴ� �����ѹ�֡������� �¨е�Ǩ�ͺ�ҡ size �ͧ���ҧ
     */
    private void sendDataToMainReport(int size)
    {
        theHosControl.theHosSubject.theMainReportSubject.notifyShowSaveToFile(false);
        if(size >0)
        {
            theHosControl.theHosSubject.theMainReportSubject.notifyShowSaveToFile(true);
        }
    }
    
    private void showDataInTable(String[] columnname,Vector vc)
    {
        
        String[] col = columnname;
        vcDataQuery = vc;
        int size = 0;
        if(vc != null)
        {
            theTableModelGUI = new TableModelGUI(col,vc.size());
            size = vc.size();
            // ǹ�ٻ ��� 1 ��
            for(int i=0 ;i<size; i++)
            {
                // ǹ�ٻ��ͧ column
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
        this.jTableReport506Followpatient.setModel(theTableModelGUI);
        if(rendererCenter == null )
        {
            rendererCenter = new DefaultTableCellRenderer();
        }
        if(col!= null && col.length!= 0)
        {
            fixedColumnScrollPane1.setFixedColumnScrollPane(jTableReport506Followpatient, 1,80);
            setTableListReportPattern(col);
        }
        else
        {
            fixedColumnScrollPane1.setFixedColumnScrollPane(jTableReport506Followpatient, 0, 210);
            setTableListReportPattern(new String[0]);
        }
        //setTableReportDefault();
        sendDataToMainReport(size);
    }
    
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
        int size = col_number.length;
        for(int i=0;i<size-1;i++)
        {
            if(i==0 || i==3 || i==4 || i==12)
            {
                jTableReport506Followpatient.getColumnModel().getColumn(i).setPreferredWidth(70);
            }
            else if ((i>=9 && i<12) || i==15)
            {
                 jTableReport506Followpatient.getColumnModel().getColumn(i).setCellRenderer(rendererCenter);
                 jTableReport506Followpatient.getColumnModel().getColumn(i).setPreferredWidth(70);
            }
            else if(i==5 || i==6 || i==8 || i==13 || i==14 || i==17 || i==20 || i==21)
            {
                jTableReport506Followpatient.getColumnModel().getColumn(i).setPreferredWidth(120);
            }
            else if(i==7)
            {
                jTableReport506Followpatient.getColumnModel().getColumn(i).setPreferredWidth(250);
            }
        }
    }
    
    private void setTableReportDefault()
    {
        this.jTableReport506Followpatient.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.jTableReport506Followpatient.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.jTableReport506Followpatient.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.jTableReport506Followpatient.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.jTableReport506Followpatient.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.jTableReport506Followpatient.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.jTableReport506Followpatient.getColumnModel().getColumn(6).setPreferredWidth(250);
    }
    
    public void setLanguage()
    {
        Gutil.JPanelLabler(jPanelDetail);
    }
    
    public void setExportFile(String fileType, String path)
    {
        this.fileType = fileType;
        this.select_path = path;
        ExportFile();
    }
    
    public void setQueryReport(String startDate, String endDate, boolean isDbBackup)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatStatus = "";
        setFileDescription(isDbBackup);
    }
    
    public void setQueryReport(String startDate, String endDate, String treatStatus, boolean isDbBackup)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatStatus = treatStatus;
        setFileDescription(isDbBackup);
    }
    
    public void notifySetInitAllGUI()
    {
        // setEnableRadioButton(false);
        vcRp506Surveil = null;
        //setTableRp506FollowPatient();
        showDataInTable(null, null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.utility.FixedColumnScrollPane fixedColumnScrollPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDetail;
    private com.hosv3.gui.component.HJTableSort jTableReport506Followpatient;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setQueryReport(String startDate, String endDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setQueryReport(String startDate, String endDate, String treatStatus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}