/*
 * PanelReport115Group3_2549.java
 *
 * Created on 16 �չҤ� 2549, 17:31 �.
 */

package com.standardReport.gui.panel;

import com.standardReport.object.RP115Group3DentalProtect_2549;
import com.standardReport.object.RP115Group3Epi_2549;
import com.standardReport.object.RP115Group3Healthy_2549;
import com.standardReport.object.RP115Group3MMR_2549;
import com.standardReport.object.RP115Group3Nutrition_2549;
import com.standardReport.subject.ManageAllPanel;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;

import com.standardReport.control.HosControl;
import com.standardReport.subject.StandardGui;
import com.standardReport.utility.*;

import com.standardReport.object.FileName;

/**
 *
 * @author  Ojika
 */
public class PanelReport115Group3_2549 extends javax.swing.JPanel implements StandardGui,
ManageAllPanel 
{
    
    /** Creates new form PanelReport115Group3_2549 */
    HosControl theHosControl;
    
    private Vector vGroup3Healthy;
    private Vector vGroup3Epi;
    private Vector vGroup3DentalProtect;
    private Vector vGroup3MMR;
    private Vector vGroup3Nutrition;
    private Vector vGroup3;
    
    private RP115Group3Healthy_2549 theRP115Group3Healthy_2549;
    private RP115Group3Epi_2549 theRP115Group3Epi_2549;
    private RP115Group3DentalProtect_2549 theRP115Group3DentalProtect_2549;
    private RP115Group3MMR_2549 theRP115Group3MMR_2549;
    private RP115Group3Nutrition_2549 theRP115Group3Nutrition_2549;
    
    private boolean isProcessRunning = false;
    
    private String select_path = ""; 
    private String fileType = "";
    public String startDate ="";
    public String endDate = "";
    private String cardName = "Report115Group3_2549";  
    public FileName theFileName; 
    private int currentPart;
    DefaultTableCellRenderer rendererRight;
    private boolean isDbBackup;
    
    public PanelReport115Group3_2549(HosControl hcl)
    {
        initComponents();
        theFileName = new FileName();
        theHosControl = hcl;
        theHosControl.theHosSubject.theAllPanelSubject.registerAllPanelManage(this);
        currentPart =1;
        setLanguage();
    }

    public String getCardName()
    {
        return this.cardName;
    }

    public void notifySetInitAllGUI()
    {
    }

    public void setExportFile(String fileType, String path)
    {
        // ��觺ѹ�֡ File
        if(path != null && fileType != null)
        {
            this.fileType = fileType;
            this.select_path = path;
            setVectorAllGroup3();
            ExportFile();
        }
        else
        {
            System.out.println("++++++++++++++++++++++ select_path is null ");
        }
    }

    public void setQueryReport(String startDate, String endDate, boolean dbBackup)
    {
        // ��觴֧��§ҹ ���֧价���� Default ��� Healthy
        this.startDate = startDate;
        this.endDate = endDate;
        setEnableRadioButton(true);
        isDbBackup = dbBackup;
        setDefaultPreReport(isDbBackup);
    }

    public void setQueryReport(String startDate, String endDate, String treatStatus)
    {
        // �����ҹ�����������ǹ�ͧ �ä�����ʶҹ����Ҥ�� �ä������ѧ
        // ����Ѻ��§ҹ 506 ��ҹ��
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonHealthy = new javax.swing.JRadioButton();
        jRadioButtonEpi = new javax.swing.JRadioButton();
        jRadioButtonDentalProtect = new javax.swing.JRadioButton();
        jRadioButtonMMR = new javax.swing.JRadioButton();
        jRadioButtonNutrition = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReport115Group3 = new com.hosv3.gui.component.HJTableSort();
        jPanel4 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(jRadioButtonHealthy);
        jRadioButtonHealthy.setSelected(true);
        jRadioButtonHealthy.setText("Healthy");
        jRadioButtonHealthy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonHealthyActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 0);
        jPanel2.add(jRadioButtonHealthy, gridBagConstraints);

        buttonGroup1.add(jRadioButtonEpi);
        jRadioButtonEpi.setText("EpiBaby");
        jRadioButtonEpi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonEpiActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 0);
        jPanel2.add(jRadioButtonEpi, gridBagConstraints);

        buttonGroup1.add(jRadioButtonDentalProtect);
        jRadioButtonDentalProtect.setText("DentalProtect");
        jRadioButtonDentalProtect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonDentalProtectActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 0);
        jPanel2.add(jRadioButtonDentalProtect, gridBagConstraints);

        buttonGroup1.add(jRadioButtonMMR);
        jRadioButtonMMR.setText("MMR_Child");
        jRadioButtonMMR.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonMMRActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 0);
        jPanel2.add(jRadioButtonMMR, gridBagConstraints);

        buttonGroup1.add(jRadioButtonNutrition);
        jRadioButtonNutrition.setText("NutritionFail");
        jRadioButtonNutrition.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonNutritionActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        jPanel2.add(jRadioButtonNutrition, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(new javax.swing.border.TitledBorder("ReportDetail"));
        jScrollPane1.setBorder(null);
        jTableReport115Group3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(jTableReport115Group3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 12));
        jTextArea1.setLineWrap(true);
        jTextArea1.setText("\u0e2b\u0e21\u0e32\u0e22\u0e40\u0e2b\u0e15\u0e38 : \u0e40\u0e19\u0e37\u0e48\u0e2d\u0e07\u0e08\u0e32\u0e01\u0e01\u0e32\u0e23\u0e41\u0e2a\u0e14\u0e07\u0e1c\u0e25\u0e1a\u0e19\u0e2b\u0e19\u0e49\u0e32\u0e08\u0e2d\u0e44\u0e21\u0e48\u0e40\u0e1e\u0e35\u0e22\u0e07\u0e1e\u0e2d \u0e08\u0e36\u0e07\u0e41\u0e1a\u0e48\u0e07\u0e01\u0e32\u0e23\u0e41\u0e2a\u0e14\u0e07\u0e1c\u0e25\u0e2d\u0e2d\u0e01\u0e40\u0e1b\u0e47\u0e19\u0e2a\u0e48\u0e27\u0e19 \u0e46  \n                  \u0e40\u0e21\u0e37\u0e48\u0e2d\u0e17\u0e33\u0e01\u0e32\u0e23\u0e1a\u0e31\u0e19\u0e17\u0e36\u0e01\u0e08\u0e30\u0e19\u0e33\u0e17\u0e31\u0e49\u0e07 5 \u0e2a\u0e48\u0e27\u0e19\u0e23\u0e27\u0e21\u0e40\u0e1b\u0e47\u0e19 File \u0e40\u0e14\u0e35\u0e22\u0e27\u0e01\u0e31\u0e19");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jTextArea1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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

    public void chooseAll(String df,String dt){
        startDate = df;
        endDate = dt;
        manageHealthyReport();
        this.setTableGroup3Healthy();
        manageNutritionReport();
        this.setTableGroup3Nutrition();
        manageMMRReport();
        this.setTableGroup3MMR();
        manageDentalProtectReport();
        this.setTableGroup3DentalProtect();
        manageEpiReport();
        this.setTableGroup3Epi();
        this.setEnableRadioButton(true);
        theHosControl.theExportControl.print115_3(
                vGroup3Healthy,vGroup3Nutrition,vGroup3MMR,vGroup3DentalProtect,vGroup3Epi,this.startDate,this.endDate);
    }
    private void jRadioButtonHealthyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonHealthyActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonHealthyActionPerformed
        // �֧�����š����������آ�Ҿ (Healthy)
        currentPart = 1;
        manageHealthyReport();
        showCurrentDate();
        this.setTableGroup3Healthy();
    }//GEN-LAST:event_jRadioButtonHealthyActionPerformed

    private void jRadioButtonNutritionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonNutritionActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonNutritionActionPerformed
        // �֧����������ҡ�� (Nutrition)
        currentPart =5;
        manageNutritionReport();
        showCurrentDate();
        this.setTableGroup3Nutrition();
    }//GEN-LAST:event_jRadioButtonNutritionActionPerformed

    private void jRadioButtonMMRActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonMMRActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonMMRActionPerformed
        // �֧������ �Ѵ�����ѹ (MMR)
        currentPart =4;
        manageMMRReport();
        showCurrentDate();
        this.setTableGroup3MMR();
    }//GEN-LAST:event_jRadioButtonMMRActionPerformed

    private void jRadioButtonDentalProtectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonDentalProtectActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonDentalProtectActionPerformed
        // �֧������ �ѹ�������ͧ�ѹ (Dental Protect)
        currentPart = 3;
        manageDentalProtectReport();
        showCurrentDate();
        this.setTableGroup3DentalProtect();
    }//GEN-LAST:event_jRadioButtonDentalProtectActionPerformed

    private void jRadioButtonEpiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonEpiActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonEpiActionPerformed
        // �֧������ �Ѥ�չ(Epi)
        currentPart = 2;
        manageEpiReport();
        showCurrentDate();
        this.setTableGroup3Epi();
    }//GEN-LAST:event_jRadioButtonEpiActionPerformed
    /**
     * �觢��������ͺѹ�֡ File 
     * @Author Ojika
     * @Date 17/03/2549
     **/
    public void ExportFile()
    {
        setProcessRunning(true);
        try
        {
            if(theHosControl == null)
            {
                System.out.println("----------HosControl --null-------------");
                return;
            }
            
            if(this.vGroup3 != null)
            {
                theHosControl.theExportControl.startExportByVector(this.vGroup3,this.select_path,this.fileType,theFileName.getRP115Group3_2549());
            }
            else
            {
                System.out.println("----*******------vGroup3 --null------********------");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     *  �� Function ����Ѻ��� Vector ��� 5 ��ǹ�ͧ��ǹ��� 3 ���͹�� Save �� File ���ǡѹ
     *  �����ŷ���ͧ���  vGroup3Healthy, vGroup3Epi, vGroup3DentalProtect, vGroup3MMR, vGroup3Nutrition;
     *  ��� 5 �е�ͧ�դ�ҹ�鹤�� Record ����� 0 
     *  �ҡ Record �ͧ Vector �� 0 ���֧�����Ţͧ Vector ������� 
     **/
    private void setVectorAllGroup3() 
    {
        // ��Ǩ�ͺ Vector
        this.manageHealthyReport();
        this.manageEpiReport();
        this.manageDentalProtectReport();
        this.manageMMRReport();
        this.manageNutritionReport();
        
        this.vGroup3 = theHosControl.theRP115Group3_2549Control.setVectorAllGroup3(this.vGroup3Healthy, this.vGroup3Epi, this.vGroup3DentalProtect, this.vGroup3MMR, this.vGroup3Nutrition); 
    }
    
    /**
     *  ��㹡���觤�Ңͧ�ѹ���Ѩ�غѹ�����ѧ query �����Ѻ��ѧ panel ��ѡ �ҡ panel ��ѡ
     *  �ա������¹�ѹ���
     */
    private void showCurrentDate()
    {
        this.theHosControl.theHosSubject.theMainReportSubject.notifyReturnStartAndFinishDate(startDate, endDate);
    }
    
    /**
     * ����Ѻ��Ǩ�ͺ����ա�ô֧������ Nutrition �����ѧ
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void manageNutritionReport()
    {
            this.vGroup3Nutrition = new Vector();    
            this.vGroup3Nutrition = theHosControl.theRP115Group3_2549Control.selectGroup3NutritionByDate(this.startDate,this.endDate,isDbBackup);
    }
    
    /**
     * ����Ѻ��Ǩ�ͺ����ա�ô֧������ MMR �����ѧ
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void manageMMRReport()
    {
            this.vGroup3MMR = new Vector();    
            this.vGroup3MMR = theHosControl.theRP115Group3_2549Control.selectGroup3MMRByDate(this.startDate,this.endDate,isDbBackup);
    }
    
    /**
     * ����Ѻ��Ǩ�ͺ����ա�ô֧������ Dental Protect �����ѧ
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void manageDentalProtectReport()
    {
            this.vGroup3DentalProtect = new Vector();    
            this.vGroup3DentalProtect = theHosControl.theRP115Group3_2549Control.selectGroup3DentalProtectByDate(this.startDate,this.endDate,isDbBackup);
    }
    
    /**
     * ����Ѻ��Ǩ�ͺ����ա�ô֧������ Epi �����ѧ
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void manageEpiReport()
    {
            this.vGroup3Epi = new Vector();    
            this.vGroup3Epi = theHosControl.theRP115Group3_2549Control.selectGroup3EpiByDate(this.startDate,this.endDate,isDbBackup);
     }
    
    /**
     * ����Ѻ��Ǩ�ͺ����ա�ô֧������ Healthy �����ѧ
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void manageHealthyReport()
    {
            this.vGroup3Healthy = new Vector();    
            this.vGroup3Healthy = theHosControl.theRP115Group3_2549Control.selectGroup3HealthyByDate(this.startDate,this.endDate,isDbBackup);
    }
    
    /**
     *  ��㹡�á�˹� ��� RadioButton ����ö�ӧҹ enable ���������
     *  @param enabled �� boolean ����� true �� enable ����� false �� disable
     *  @Author Ojika
     *  @Date 16/03/2549
     */
    private void setEnableRadioButton(boolean enabled)
    {
        this.jRadioButtonHealthy.setEnabled(enabled);
        this.jRadioButtonEpi.setEnabled(enabled);
        this.jRadioButtonDentalProtect.setEnabled(enabled);
        this.jRadioButtonMMR.setEnabled(enabled);
        this.jRadioButtonNutrition.setEnabled(enabled);
    }
    
    public void setDefaultPreReport(boolean isDbBackup)
    {
        setProcessRunning(true);
       // jRadioButtonHealthy.setSelected(true);
        try
        {
            if(theHosControl == null)
            {
                System.out.println("----------HosControl --null-------------");
                return;
            }
            
            // Clear data Report
            setNewVectorReport();
            
            // Default Healthy
            if(currentPart == 1)
            {
                this.vGroup3Healthy = theHosControl.theRP115Group3_2549Control.selectGroup3HealthyByDate(this.startDate,this.endDate,isDbBackup);
                 showCurrentDate();
                this.setTableGroup3Healthy();
            }
            else if(currentPart == 2)
            {
                this.vGroup3Epi = theHosControl.theRP115Group3_2549Control.selectGroup3EpiByDate(this.startDate,this.endDate,isDbBackup);
                showCurrentDate();
                this.setTableGroup3Epi();
            }
            else if(currentPart == 3)
            {
                this.vGroup3DentalProtect = theHosControl.theRP115Group3_2549Control.selectGroup3DentalProtectByDate(this.startDate,this.endDate,isDbBackup);
                showCurrentDate();
                this.setTableGroup3DentalProtect();
            }
            else if(currentPart == 4)
            {
                this.vGroup3MMR = theHosControl.theRP115Group3_2549Control.selectGroup3MMRByDate(this.startDate,this.endDate,isDbBackup);
                showCurrentDate();
                this.setTableGroup3MMR();
            }
            else if(currentPart == 5)
            {
                this.vGroup3Nutrition = theHosControl.theRP115Group3_2549Control.selectGroup3NutritionByDate(this.startDate,this.endDate,isDbBackup);
                showCurrentDate();
                this.setTableGroup3Nutrition();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * ����Ѻ set ���ҧ�ͧ Nutrition
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void setTableGroup3Nutrition()
    {
        //String[] col = {"�������Է��","MMR","","","","",""};
        String[] col = {    Gutil.getTextBundle("TypePlan"),
                Gutil.getTextBundle("baby_fail"),
                Gutil.getTextBundle("baby_exceed"),
                Gutil.getTextBundle("child_fail"),
                Gutil.getTextBundle("child_exceed"),
                Gutil.getTextBundle("man_fail"),
                Gutil.getTextBundle("man_exceed")
        };
        TableModel tm;
        int size = 0;
        if(this.vGroup3Nutrition != null && this.vGroup3Nutrition.size() > 0)
        {
            size = vGroup3Nutrition.size();
            tm= new TableModel(col,size);
            
            for(int i=0;i<size; i++)
            {
                theRP115Group3Nutrition_2549 = new RP115Group3Nutrition_2549();
                theRP115Group3Nutrition_2549 = (RP115Group3Nutrition_2549)this.vGroup3Nutrition.get(i);
                
                tm.setValueAt(theRP115Group3Nutrition_2549.plan_type,i,0);
                tm.setValueAt(Integer.valueOf(theRP115Group3Nutrition_2549.baby_fail),i,1);
                tm.setValueAt(Integer.valueOf(theRP115Group3Nutrition_2549.baby_exceed),i,2);
                tm.setValueAt(Integer.valueOf(theRP115Group3Nutrition_2549.child_fail),i,3);
                tm.setValueAt(Integer.valueOf(theRP115Group3Nutrition_2549.child_exceed),i,4);
                tm.setValueAt(Integer.valueOf(theRP115Group3Nutrition_2549.man_fail),i,5);
                tm.setValueAt(Integer.valueOf(theRP115Group3Nutrition_2549.man_exceed),i,6);
                
                theRP115Group3Nutrition_2549 = null;
            }
        }
        else
        {
            tm= new TableModel(col,0);
        }
        this.jTableReport115Group3.setModel(tm);
        setTableGroup3NutritionDefault();
        sendDataToMainReport(size);
        
    }
    
    private void setTableGroup3NutritionDefault()
    {
        if(rendererRight == null)
        {
            rendererRight = new DefaultTableCellRenderer();
        }
        //��˹����Ѵ Column �������ҧ���
        rendererRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        
        this.jTableReport115Group3.getColumnModel().getColumn(1).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(2).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(3).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(4).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(5).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(6).setCellRenderer(rendererRight);
        
        this.jTableReport115Group3.getColumnModel().getColumn(0).setPreferredWidth(100);
    }
    
    /**
     * ����Ѻ set ���ҧ�ͧ MMR
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void setTableGroup3MMR()
    {
        //String[] col = {"�������Է��","MMR"};
        String[] col = {    Gutil.getTextBundle("TypePlan"),
                Gutil.getTextBundle("MMR")
        };
        TableModel tm;
        int size = 0;
        if(this.vGroup3MMR != null && this.vGroup3MMR.size() > 0)
        {
            size = vGroup3MMR.size();
            tm= new TableModel(col,size);
            
            for(int i=0;i<size; i++)
            {
                theRP115Group3MMR_2549 = new RP115Group3MMR_2549();
                theRP115Group3MMR_2549 = (RP115Group3MMR_2549)this.vGroup3MMR.get(i);
                
                tm.setValueAt(theRP115Group3MMR_2549.plan_type,i,0);
                tm.setValueAt(Integer.valueOf(theRP115Group3MMR_2549.MMR614),i,1);
                
                theRP115Group3MMR_2549 = null;
            }
        }
        else
        {
            tm= new TableModel(col,0);
        }
        this.jTableReport115Group3.setModel(tm);
        setTableGroup3MMRDefault();
        sendDataToMainReport(size);
        
    }
    
    private void setTableGroup3MMRDefault()
    {
        if(rendererRight == null)
        {
            rendererRight = new DefaultTableCellRenderer();
        }
        //��˹����Ѵ Column �������ҧ���
        rendererRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        
        this.jTableReport115Group3.getColumnModel().getColumn(1).setCellRenderer(rendererRight);
        
        this.jTableReport115Group3.getColumnModel().getColumn(0).setPreferredWidth(100);
    }
    
    /**
     * ����Ѻ set ���ҧ�ͧ Dental Protect
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void setTableGroup3DentalProtect()
    {
        //String[] col = {"�������Է��","���������ͧ�ѹ�ҧ�ѹ����� (0-5 ��)","���������ͧ�ѹ�ҧ�ѹ����� (6-14 ��)"};
        String[] col = {    Gutil.getTextBundle("TypePlan"),
                Gutil.getTextBundle("dentalProtect_baby"),
                Gutil.getTextBundle("dentalProtect_child")
        };
        TableModel tm;
        int size = 0;
        if(this.vGroup3DentalProtect != null && this.vGroup3DentalProtect.size() > 0)
        {
            size = vGroup3DentalProtect.size();
            tm= new TableModel(col,size);
            
            for(int i=0;i<size; i++)
            {
                theRP115Group3DentalProtect_2549 = new RP115Group3DentalProtect_2549();
                theRP115Group3DentalProtect_2549 = (RP115Group3DentalProtect_2549)this.vGroup3DentalProtect.get(i);
                
                tm.setValueAt(theRP115Group3DentalProtect_2549.plan_type,i,0);
                tm.setValueAt(Integer.valueOf(theRP115Group3DentalProtect_2549.dentalProtect_baby),i,1);
                tm.setValueAt(Integer.valueOf(theRP115Group3DentalProtect_2549.dentalProtect_child),i,2);
                
                theRP115Group3DentalProtect_2549 = null;
            }
        }
        else
        {
            tm= new TableModel(col,0);
        }
        this.jTableReport115Group3.setModel(tm);
        setTableGroup3DentalProtectDefault();
        sendDataToMainReport(size);
        
    }
    
    private void setTableGroup3DentalProtectDefault()
    {
        if(rendererRight == null)
        {
            rendererRight = new DefaultTableCellRenderer();
        }
        //��˹����Ѵ Column �������ҧ���
        rendererRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        
        this.jTableReport115Group3.getColumnModel().getColumn(1).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(2).setCellRenderer(rendererRight);
        
        this.jTableReport115Group3.getColumnModel().getColumn(0).setPreferredWidth(100);
    }
    
    /**
     * ����Ѻ set ���ҧ�ͧ Epi
     * @Author Ojika
     * @Date 17/03/2549
     **/
    private void setTableGroup3Epi()
    {
        //String[] col = {"�������Է��","DPT","BCG","MMR","Hep"};
        String[] col = {    Gutil.getTextBundle("TypePlan"),
                Gutil.getTextBundle("DPT"),
                Gutil.getTextBundle("BCG"),
                Gutil.getTextBundle("MMR"),
                Gutil.getTextBundle("Hep")
        };
        TableModel tm;
        int size = 0;
        if(this.vGroup3Epi != null && this.vGroup3Epi.size() > 0)
        {
            size = vGroup3Epi.size();
            tm= new TableModel(col,size);
            
            for(int i=0;i<size; i++)
            {
                theRP115Group3Epi_2549 = new RP115Group3Epi_2549();
                theRP115Group3Epi_2549 = (RP115Group3Epi_2549)this.vGroup3Epi.get(i);
                
                tm.setValueAt(theRP115Group3Epi_2549.plan_type,i,0);
                tm.setValueAt(Integer.valueOf(theRP115Group3Epi_2549.DPT),i,1);
                tm.setValueAt(Integer.valueOf(theRP115Group3Epi_2549.BCG),i,2);
                tm.setValueAt(Integer.valueOf(theRP115Group3Epi_2549.MMR),i,3);
                tm.setValueAt(Integer.valueOf(theRP115Group3Epi_2549.Hep),i,4);
                
                theRP115Group3Healthy_2549 = null;
            }
        }
        else
        {
            tm= new TableModel(col,0);
        }
        this.jTableReport115Group3.setModel(tm);
        setTableGroup3EpiDefault();
        sendDataToMainReport(size);
        
    }
    
    private void setTableGroup3EpiDefault()
    {
        if(rendererRight == null)
        {
            rendererRight = new DefaultTableCellRenderer();
        }
        //��˹����Ѵ Column �������ҧ���
        rendererRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        
        this.jTableReport115Group3.getColumnModel().getColumn(1).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(2).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(3).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(4).setCellRenderer(rendererRight);
        
        this.jTableReport115Group3.getColumnModel().getColumn(0).setPreferredWidth(100);
    }
    
    /**
     * ����Ѻ set ���ҧ�ͧ�������آ�Ҿ Healthy
     * @Author Ojika
     * @Date 16/03/2549
     **/
    private void setTableGroup3Healthy()
    {
        //String[] col = {"�������Է��","��Թԡ�آ�Ҿ�硴� (������㹻�)","���Ѻ��õ�Ǩ�����Թ�آ�Ҿ 6-14 �� (������㹻�)",���Ѻ��õ�Ǩ�����Թ�آ�Ҿ 15 �բ��� (������㹻�)"};
        String[] col = {    Gutil.getTextBundle("TypePlan"),
                Gutil.getTextBundle("WellBaby"),
                Gutil.getTextBundle("Healthy614"),
                Gutil.getTextBundle("Healthy15Up")
        };
        TableModel tm;
        int size = 0;
        if(this.vGroup3Healthy != null && this.vGroup3Healthy.size() > 0)
        {
            size = vGroup3Healthy.size();
            tm= new TableModel(col,size);
            
            for(int i=0;i<size; i++)
            {
                theRP115Group3Healthy_2549 = new RP115Group3Healthy_2549();
                theRP115Group3Healthy_2549 = (RP115Group3Healthy_2549)this.vGroup3Healthy.get(i);
                
                tm.setValueAt(theRP115Group3Healthy_2549.plan_type,i,0);
                tm.setValueAt(Integer.valueOf(theRP115Group3Healthy_2549.wellbaby),i,1);
                tm.setValueAt(Integer.valueOf(theRP115Group3Healthy_2549.healthy614),i,2);
                tm.setValueAt(Integer.valueOf(theRP115Group3Healthy_2549.healthy15Up),i,3);
                
                theRP115Group3Healthy_2549 = null;
            }
        }
        else
        {
            tm= new TableModel(col,0);
        }
        this.jTableReport115Group3.setModel(tm);
        setTableGroup3HealthyDefault();
        sendDataToMainReport(size);
        
    }
    
    private void setTableGroup3HealthyDefault()
    {
        if(rendererRight == null)
        {
            rendererRight = new DefaultTableCellRenderer();
        }
        //��˹����Ѵ Column �������ҧ���
        rendererRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        
        this.jTableReport115Group3.getColumnModel().getColumn(1).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(2).setCellRenderer(rendererRight);
        this.jTableReport115Group3.getColumnModel().getColumn(3).setCellRenderer(rendererRight);
        
        this.jTableReport115Group3.getColumnModel().getColumn(0).setPreferredWidth(100);
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

    
    private void setNewVectorReport()
    {
        this.vGroup3Healthy = new Vector();
        this.vGroup3Epi = new Vector();
        this.vGroup3DentalProtect = new Vector();
        this.vGroup3MMR = new Vector();
        this.vGroup3Nutrition = new Vector();
        
        this.vGroup3 = new Vector();
    }
    
    public void setProcessRunning(boolean isProcessRunning)
    {
        this.isProcessRunning = isProcessRunning;
    }
    
    public void setLanguage()
    {
        jRadioButtonHealthy.setText(Gutil.getTextBundle(jRadioButtonHealthy.getText()));
        jRadioButtonEpi.setText(Gutil.getTextBundle(jRadioButtonEpi.getText()));
        jRadioButtonDentalProtect.setText(Gutil.getTextBundle(jRadioButtonDentalProtect.getText()));
        jRadioButtonMMR.setText(Gutil.getTextBundle(jRadioButtonMMR.getText()));
        jRadioButtonNutrition.setText(Gutil.getTextBundle(jRadioButtonNutrition.getText()));
        Gutil.JPanelLabler(jPanel3);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonDentalProtect;
    private javax.swing.JRadioButton jRadioButtonEpi;
    private javax.swing.JRadioButton jRadioButtonHealthy;
    private javax.swing.JRadioButton jRadioButtonMMR;
    private javax.swing.JRadioButton jRadioButtonNutrition;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hosv3.gui.component.HJTableSort jTableReport115Group3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setQueryReport(String startDate, String endDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}