/*
 * PanelReportARIC.java
 *
 * Created on 11 ���Ҥ� 2548, 11:31 �.
 */

package com.generalreport.gui.panel.report;
import com.generalreport.gui_component.TableModelGUI;
import com.generalreport.subject.ManageAllPanel;
import com.generalreport.subject.ManageGUI;
import com.generalreport.utility.GUIControl;
import com.generalreport.utility.Constant;
import com.generalreport.utility.Report;
import java.util.Vector;
import javax.swing.*;

import com.generalreport.control.HosManage;
import com.generalreport.gui_component.DialogShowStatus;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author  tong(Padungrat)
 */
public class PanelReportARIC  extends javax.swing.JPanel implements 
GUIControl,ManageGUI,Runnable,ManageAllPanel {
    
    HosManage theHosManage;
    Thread theThread;
    private String startDate;
    private String endDate;
    final private String cardName;// = "TestReport";
    private DefaultTableCellRenderer rendererCenter;
    Vector vcData;
    String[] headColumn;
    Vector vcDataQuery;
    TableModelGUI theTableModelGUI;
    DialogShowStatus theDialogShowStatus;
    private boolean isDbBackup;
    public PanelReportARIC(HosManage hosmanage)
    {
        theHosManage = hosmanage;
        theHosManage.theHosControl.theHosSubject.theGUISubject.registerGUIManage(this);
        theHosManage.theHosControl.theHosSubject.theAllPanelSubject.registerAllPanelManage(this);
        
        cardName = ((Report)Constant.Report.get("9")).ENG_NAME;
        initComponents();
        
        theDialogShowStatus = new DialogShowStatus(theHosManage.theUS.getJFrame(),false,theHosManage);
    
    }
    /**run thread*/
    public void run()
    {
       // ��Ǩ�ͺ����ա�� setup �����������ѧ �������� return ��Ѻ���� true
       if(checkDataSetup())
       {
            queryDataByDate(startDate,endDate);
       }
       else
       {
           // ����͹��� Setup ������
           JOptionPane.showMessageDialog(this,"�ѧ����բ�������¡���� Antibiotic ��س�������¡�����ǹ�ͧ Setup ��͹","��͹",JOptionPane.YES_OPTION);
       }
    }    
    
    /**
     * ����Ѻ ��Ǩ�ͺ����ա�� setup �����������ѧ �������� return ��Ѻ���� true
     **/ 
    public boolean checkDataSetup()
    {
        Vector checkData = new Vector();
        boolean resultCheck = false;
        
        // ��Ǩ�ͺ������ Setup ��¡���� Antibiotic
       checkData = theHosManage.theHosControl.theRPReportARICControl.checkDataSetup();
       
       if(checkData != null && checkData.size() > 0)
       {
           resultCheck = true;
       }
       else
       {
           resultCheck = false;
       }
        
        return resultCheck;
    }
    
    /**
     *  �觪��ͧ͢ panel ���� Frame ��ѧ������㹡�÷� card Layout
     *  @return string �� ���� �ͧ panel ���ѧ���
     */ 
    public String getCardName()
    {
        return cardName;
    }
    /**
     *  ��㹡���Ѻ notify ������ա�� stop service 
     */
    public void notifyStopProcess()
    {
         try
        {
              if(theThread != null)
              {
                  theThread.stop();
              }
              theThread = null;
              System.out.println("In stop in PanelReportARIC");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
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

        jPanelARIC = new javax.swing.JPanel();
        jScrollPanelARIC = new javax.swing.JScrollPane();
        jTableShow = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanelARIC.setLayout(new java.awt.GridBagLayout());

        jTableShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPanelARIC.setViewportView(jTableShow);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelARIC.add(jScrollPanelARIC, gridBagConstraints);

        add(jPanelARIC, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:initComponents
    /**��㹡���Ѻ�����Ũҡ ��ä��� ����觤������� panel ���
     *  �������ӡ�� Query ��Ф�����¡�õ����͡�˹��ͧ panel
     *  @param startDate �� String ���ѹ���������� ������ٻẺ yyyy-mm-dd
     *  @param endDate �� String ���ѹ�������ش ������ٻẺ yyyy-mm-dd
     */
    public void setQueryReport(String startDate, String endDate, boolean dbBackup)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        isDbBackup = dbBackup;
        startQuery();
    }
    
    /**
     *  ��㹡���������� thread ������ӧҹ �е�ͧ�����¡ method ���ء����
     * 
     */
    private void startQuery()
    {
        theThread = new Thread(this);
        theThread.start();
    }
    /**
     *  �觤�Ң����š�Ѻ��ѧ Frame ��ѡ������ա�úѹ�֡�͡�������
     *  @return Vector �ͧ �����ŷ�� Query �͡����
     */
    public Vector getData()
    {
        return this.vcData;
    }
    
    /***/
    private void queryDataByDate(String startDate, String endDate)
    {
       
        theDialogShowStatus.setVisible(false);
        theDialogShowStatus.showDialog("��س����ѡ����",false);
    
        vcData = theHosManage.theHosControl.theRPReportARICControl.selectARICByDate(startDate,endDate,isDbBackup);
        headColumn = new String[] {""};
        vcDataQuery = null;
        if(vcData != null)
        {
           
            headColumn = (String[])vcData.get(0);
            vcDataQuery = (Vector)vcData.get(1);
        }
        
        showDataInTable(headColumn, vcDataQuery);
       // theHosManage.theHosControl.theTestReportControl.stop();
      //  theDialogShowStatus.showDialog("��س����ѡ����",true);
        theDialogShowStatus.setVisible(false);       
    }
    
    private void showDataInTable(String[] columnname,Vector vc)
    {
             
        String[] col = columnname;      
        
        int size = 0;
        if(vc != null)
        {   theTableModelGUI= new TableModelGUI(col,vc.size());
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
                
                //    tm.setValueAt(((OrderItem)this.theOrderControl.listOrderItemByItem(p.getObjectId(),this.vn)).refer_out,i,2);
            }                
                       
        }
        else
        {   theTableModelGUI= new TableModelGUI(col,0);            
        }
        this.jTableShow.setModel(theTableModelGUI);
        if(col!= null && col.length!= 0)
        {
            setTableListReportPattern(col);
        }
        sendDataToMainReport(size);
    }
    /**��㹡���ʴ��������ҧ�ͧ�������
     *@param col �� Array �ͧ String �������� column ����Ѻ���ҹѺ�ӹǹ Column ����ͧ���ҧ㹵��ҧ
     *
     */
    private void setTableListReportPattern(String [] col)
    {
        if(rendererCenter == null )
        {
            rendererCenter = new DefaultTableCellRenderer();
        }
        rendererCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        
        String[] col_number = col;
        for(int i=0;i<col_number.length;i++)
        {
            if(i == 0)
            {
                jTableShow.getColumnModel().getColumn(i).setPreferredWidth(100);
            }
            else
            {
                jTableShow.getColumnModel().getColumn(i).setCellRenderer(rendererCenter);
            }
        }
    }
    
    /**
     *  ��㹡����ʶҹ�����ʴ� �����ѹ�֡������� �¨е�Ǩ�ͺ�ҡ size �ͧ���ҧ
     */
    private void sendDataToMainReport(int size)
    {
        theHosManage.theHosControl.theHosSubject.theMainReportSubject.notifyShowSaveToFile(false);
        if(size >0)
        {
            theHosManage.theHosControl.theHosSubject.theMainReportSubject.notifyShowSaveToFile(true);
        }
    }
    
    /**��㹡�� Clear �����ŷ�����躹���ҧ*/
    private void clearDataGUI()
    {
        showDataInTable(new String[] {""}, null);
        System.out.println("Clear Data in GUI");
    }
    public void notifySetInitAllGUI()
    {
        clearDataGUI();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelARIC;
    private javax.swing.JScrollPane jScrollPanelARIC;
    private javax.swing.JTable jTableShow;
    // End of variables declaration//GEN-END:variables
    
}
