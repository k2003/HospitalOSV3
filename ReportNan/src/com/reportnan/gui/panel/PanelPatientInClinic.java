/*
 * PanelPatientInClinic.java
 *
 * Created on 6 �Զع�¹ 2549, 14:46 �.
 */

package com.reportnan.gui.panel;
import com.hospital_os.usecase.connection.ConnectionInf;
import com.hospital_os.utility.ConnectionDBMgr;
import com.reportnan.subject.ManageControlSubject;
import com.reportnan.usecase.CardNameControl;
import com.reportnan.usecase.GUIResp;
import com.reportnan.usecase.AllPanelResp;
import com.reportnan.utility.Report;
import com.reportnan.utility.Constant;
import com.reportnan.utility.ComboboxModel;
import com.reportnan.utility.ComboFix;
import com.reportnan.utility.Language;
import com.reportnan.utility.TableModelGUI;
import com.reportnan.gui.panel.DialogShowStatus;
import java.util.Vector;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JOptionPane;
/**
 *
 * @author  pu
 */
public class PanelPatientInClinic extends javax.swing.JPanel implements 
        GUIResp,AllPanelResp,Runnable,CardNameControl
{
    JFrame theJFrame;
    DialogShowStatus theDialogShowStatus;
    ComboboxModel theComboboxModel;
    private ManageControlSubject theMCS;
    private String cardName;
    private String startDate;
    private String endDate;
    TableModelGUI theTableModelGUI;
    DefaultTableCellRenderer rendererCenter;
    DefaultTableCellRenderer rendererRight;
    Thread theThread;
    private String[] headColumn;
    Vector vcData;
    Vector vcDataQuery;
    
    /** Creates new form PanelPatientInClinic */
    public PanelPatientInClinic(ManageControlSubject mcs)
    {
        theMCS = mcs;
        theMCS.theManageSubject.theGUISubject.registerGUIManage(this);
        theMCS.theManageSubject.theAllPanelSubject.registerAllPanelManage(this);
        initComponents();
        cardName = ((Report)Constant.Report.get("2")).ENG_NAME;
        theDialogShowStatus = new DialogShowStatus(new javax.swing.JFrame(),false,theMCS);
        theComboboxModel = new ComboboxModel();
        //setLanguage();
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

        jPanel1 = new javax.swing.JPanel();
        fixedColumnScrollPane1 = new com.hospital_os.utility.FixedColumnScrollPane();
        jTablePatientInClinic = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTablePatientInClinic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePatientInClinic.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        fixedColumnScrollPane1.setViewportView(jTablePatientInClinic);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(fixedColumnScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
       /**
     *  ��㹡���Ѻ�����Ũҡ ��ä��� ����觤������� panel ���
     *  �������ӡ�� Query ��Ф�����¡�õ����͡�˹��ͧ panel
     *  @param startDate �� String ���ѹ���������� ������ٻẺ yyyy-mm-dd
     *  @param endDate �� String ���ѹ�������ش ������ٻẺ yyyy-mm-dd
     **/
    public void setQueryReport(String startDate, String endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        startQuery();
    }
    private void startQuery()
    {
        theThread = new Thread(this);
        theThread.start();
    }
    
    public Vector getPatientInClinic()
    {
        return this.vcData;
    }
        
    public String getCardName()
    {
        return this.cardName;
    }

    public void notifySetInitAllGUI()
    {
        clearDataGUI();
    }
    /**��㹡�� Clear �����ŷ�����躹���ҧ*/
    private void clearDataGUI()
    { 
        vcData = null;
        showDataInTable(null,null);
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
            System.out.println("In stop in PanelPatientInClinic");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void run()
    {
        queryPatientInClinic();
    }
    
    private void queryPatientInClinic()
    {  
        if(this.theMCS.theManageControl.theReportNanControl.setDateForQuery(this.startDate, this.endDate))
        {
            theDialogShowStatus.setVisible(true);
            theDialogShowStatus.showDialog(Language.getTextBundle("PleaseWait"),false);
            
            this.vcData = this.theMCS.theManageControl.theReportNanControl.queryPatientInClinic();            
            headColumn = new String[] {""};
            vcDataQuery = null;
            if(vcData != null)
            {
                headColumn = (String[])vcData.get(0);
                vcDataQuery = (Vector)vcData.get(1);
            }
            showDataInTable(headColumn, vcDataQuery);
            theDialogShowStatus.setVisible(false);
        }
        else
        {
            showMessageStartYearOver();
        }
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
                    theTableModelGUI.setValueAt(Language.getTextBundle(rowdata[j]),i,j);
                }
                theTableModelGUI.setEditingCol(rowdata.length+1);
                rowdata = null;
            }
        }
        else
        {   theTableModelGUI= new TableModelGUI(col,0);
        }
        this.jTablePatientInClinic.setModel(theTableModelGUI);
        if(col!= null && col.length!= 0)
        {
            fixedColumnScrollPane1.setFixedColumnScrollPane(jTablePatientInClinic, 1, 200);
            setTableListReportPattern(col);
        }
        else
        {
            fixedColumnScrollPane1.setFixedColumnScrollPane(jTablePatientInClinic, 0, 200);
            setTableListReportPattern(new String[0]);
        }
        sendDataToMainReport(size);
    }
    /**��㹡���ʴ��������ҧ�ͧ�������
     *@param col �� Array �ͧ String �������� column ����Ѻ���ҹѺ�ӹǹ Column ����ͧ���ҧ㹵��ҧ
     */
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
                jTablePatientInClinic.getColumnModel().getColumn(i).setCellRenderer(rendererCenter);
        }
    }
    /**
     *  ��㹡����ʶҹ�����ʴ� �����ѹ�֡������� �¨е�Ǩ�ͺ�ҡ size �ͧ���ҧ
     */
    private void sendDataToMainReport(int size)
    {
        theMCS.theManageSubject.theMainReportSubject.notifyShowSaveToFile(false);
        if(size >0)
        {
            theMCS.theManageSubject.theMainReportSubject.notifyShowSaveToFile(true);
        }
    }
    /**�ʴ���ͤ��� �ѹ�������� ����ѹ�������ش ��ͧ �ջ� ���ǡѹ*/
    private void showMessageStartYearOver()
    {
        JOptionPane.showMessageDialog(this, Language.getTextBundle("StartYearNotSameEndYear"),Language.getTextBundle("Warning"),JOptionPane.OK_OPTION);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.utility.FixedColumnScrollPane fixedColumnScrollPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTablePatientInClinic;
    // End of variables declaration//GEN-END:variables
    
}
