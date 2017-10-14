/*
 * PanelSDSetupDrugDosePrint.java
 *
 * Created on March 31, 2009, 3:45 PM
 */

package com.hosv3.gui.panel.detail;

import com.hospital_os.object.DrugDosePrint;
import com.hospital_os.usecase.connection.Persistent;
import com.hosv3.utility.Constant;
import com.hosv3.control.HosControl;
import com.hosv3.control.LookupControl;
import com.hosv3.control.SetupControl;
import com.hosv3.gui.component.PanelSetupImp;
import com.hosv3.utility.GuiLang;
import com.hosv3.utility.connection.UpdateStatus;
import java.util.Vector;

/**
 *
 * @author  Administrator
 */
public class PanelSDDrugDosePrint extends javax.swing.JPanel implements PanelSetupImp{
     UpdateStatus theUS;
    SetupControl theSetupControl;
    LookupControl theLookupControl;
    private DrugDosePrint theDrugDosePrint;
    Vector vDrugDosePrint = new Vector();
    int offset = 23;
    int next = 0;
    int prev = 0;
    int saved = 0; // 0 ��� �������ö insert�� 1 ��� insert ��
    /** pu : 25/08/2549 : �� Index �ͧ frequency �����ҧ�ش�ͧ˹�һѨ�غѹ*/
    int curNext = 0;
    /** pu : 25/08/2549 : �� Index �ͧ frequency �����ҧ�ش�ͧ˹�ҡ�͹˹�һѨ�غѹ*/
    int curPrev = 0;
    String[] col = {"����Ţ","��ͤ���"};
    /** Creates new form PanelSDSetupDrugDosePrint */
    public PanelSDDrugDosePrint() {
        initComponents();
        setLanguage();
    }
    
    public PanelSDDrugDosePrint(HosControl hc, UpdateStatus us)
    {
        initComponents();
        setLanguage();
        setControl(hc,us);
        
    }    /////////////////////Use this for decrease memory usage
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        defaultFont1 = new com.hospital_os.gui.font.DefaultFont();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextFieldDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(300, 140));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 140));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(defaultFont1);
        jLabel1.setText("�ӹǹ����Ţ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel1, gridBagConstraints);

        jTextFieldCode.setColumns(10);
        jTextFieldCode.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel2.add(jTextFieldCode, gridBagConstraints);

        jLabel2.setFont(defaultFont1);
        jLabel2.setText("��ͤ����������");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jCheckBox1.setFont(defaultFont1);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/hosv3/property/thai"); // NOI18N
        jCheckBox1.setText(bundle.getString("ACTIVE")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jCheckBox1, gridBagConstraints);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(150, 48));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(150, 48));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 48));

        jTextFieldDescription.setColumns(10);
        jTextFieldDescription.setFont(defaultFont1);
        jTextFieldDescription.setLineWrap(true);
        jTextFieldDescription.setRows(2);
        jTextFieldDescription.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextFieldDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jLabel4.setFont(defaultFont1);
        jLabel4.setText("����кص���Ţ�������Թ 1 ����������Фӹǹ���");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextArea jTextFieldDescription;
    // End of variables declaration//GEN-END:variables

    public void setEnabled(boolean var)
    {
        jTextFieldCode.setEnabled(var);
        jTextFieldDescription.setEnabled(var);
        //jButtonSave.setEnabled(var);
        jCheckBox1.setEnabled(var);
        //jButtonDel.setEnabled(var);
    }
    
    public void clearAll() {
        this.setTheDrugDosePrint(new DrugDosePrint());
    }

    public Persistent getXPer() {
        return this.getTheDrugDosePrint();
    }

    public void setXPer(Persistent x) {
        this.setTheDrugDosePrint((DrugDosePrint)x);
    }

    public void setLanguage() {
        GuiLang.setLanguage(jLabel1);
        GuiLang.setLanguage(jLabel2);
        GuiLang.setLanguage(jCheckBox1);
        GuiLang.setLanguage(col);
    }

    public void setControl(HosControl hc, UpdateStatus us) {
          theUS = us;
        theSetupControl = hc.theSetupControl;
        theLookupControl = hc.theLookupControl;
        hc.theHS.theSetupSubject.addpanelrefrash(this);
        hc.theHS.theSetupSubject.addForLiftAttach(this);
    }

    public void setupLookup() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteXPer(Persistent x) {
        return (this.theSetupControl.deleteDrugDosePrint((DrugDosePrint)x)>0);
    }

    public boolean saveXPer(Persistent x) {
        return (this.theSetupControl.saveDrugDosePrint((DrugDosePrint)x)>0);
    }

    public Vector listXPer(String key, String active, int offset) {
        return theLookupControl.listDrugDosePrint(key,active);
    }

    public boolean isActiveVisible() {
        return true;
    }
    
     public static String TITLE = Constant.getTextBundle("�ӹǹ�ҷ���� ����Ѻ��þ����");
    public String getTitle() {
        return TITLE;
    }

    public DrugDosePrint getTheDrugDosePrint() {
        theDrugDosePrint.item_drug_dose_value = jTextFieldCode.getText();
        theDrugDosePrint.item_drug_dose_description = jTextFieldDescription.getText();
        String active = "0";
        if(jCheckBox1.isSelected())
            active = "1";
        theDrugDosePrint.item_drug_dose_active=active;
        return theDrugDosePrint;
    }

    public void setTheDrugDosePrint(DrugDosePrint Item) {
        theDrugDosePrint =  Item;
        jTextFieldCode.setText(theDrugDosePrint.item_drug_dose_value);
        jTextFieldDescription.setText(theDrugDosePrint.item_drug_dose_description);
        
        if((theDrugDosePrint.item_drug_dose_active)!=null&&(theDrugDosePrint.item_drug_dose_active).equals("1"))
        jCheckBox1.setSelected(true);
        else
        jCheckBox1.setSelected(false);
    }
    
    public boolean isStartVisible() {
        return false;
    }
        

}
