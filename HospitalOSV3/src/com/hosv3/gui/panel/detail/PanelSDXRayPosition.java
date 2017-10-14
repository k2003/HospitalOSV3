/*
 * PanelSDSetupXRayPosition.java
 *
 * Created on April 3, 2009, 11:16 AM
 */

package com.hosv3.gui.panel.detail;

import com.hospital_os.object.XRayPosition;
import com.hospital_os.usecase.connection.Persistent;
import com.hosv3.utility.Constant;
import com.hosv3.control.HosControl;
import com.hosv3.control.SetupControl;
import com.hosv3.gui.component.PanelSetupImp;
import com.hosv3.utility.GuiLang;
import com.hosv3.utility.connection.UpdateStatus;
import java.util.Vector;

/**
 *
 * @author  Administrator
 */
public class PanelSDXRayPosition extends javax.swing.JPanel implements PanelSetupImp{
     UpdateStatus theUS;
    SetupControl theSetupControl;
    private XRayPosition theXRayPosition;
    Vector XRayPosition = new Vector();
    int offset = 23;
    int next = 0;
    int prev = 0;
    int saved = 0; // 0 ��� �������ö insert�� 1 ��� insert ��
    String[] col = {"����","���ͷ��"};
    public PanelSDXRayPosition(HosControl hc,UpdateStatus us) {
        initComponents();
        setLanguage();
        setControl(hc,us);
    }
    public PanelSDXRayPosition() {
        initComponents();
        setLanguage();
    }
    
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
        jTextAreaName = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(300, 120));
        setPreferredSize(new java.awt.Dimension(300, 120));
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(350, 120));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 120));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(defaultFont1);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/hosv3/property/thai"); // NOI18N
        jLabel1.setText(bundle.getString("CODE")); // NOI18N
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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel2.add(jTextFieldCode, gridBagConstraints);

        jLabel2.setFont(defaultFont1);
        jLabel2.setText(bundle.getString("NAME")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jCheckBox1.setFont(defaultFont1);
        jCheckBox1.setText(bundle.getString("ACTIVE")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jCheckBox1, gridBagConstraints);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(150, 48));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(150, 48));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 48));

        jTextAreaName.setFont(defaultFont1);
        jTextAreaName.setLineWrap(true);
        jTextAreaName.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaName;
    private javax.swing.JTextField jTextFieldCode;
    // End of variables declaration//GEN-END:variables

    public void clearAll() {
        this.setTheXRayPosition(new XRayPosition());
    }

    public Persistent getXPer() {
        return this.getTheXRayPosition();
    }

    public void setXPer(Persistent x) {
        this.setTheXRayPosition((XRayPosition)x);
    }

    public void setLanguage() {
         
        GuiLang.setLanguage(jLabel1);        
        GuiLang.setLanguage(jLabel2); 
        GuiLang.setLanguage(jCheckBox1);   
        GuiLang.setLanguage(col);
    }

    public void setControl(HosControl hc, UpdateStatus us) {
        theUS = us;
        //jTable1.setGuiMode(true);
        theSetupControl = hc.theSetupControl;
        hc.theHS.theSetupSubject.addpanelrefrash(this);
        hc.theHS.theSetupSubject.addForLiftAttach(this);
        setupLookup();
        setEnabled(false);
    }

    public void setEnabled(boolean var)
    {   jTextFieldCode.setEditable(var);
        jTextAreaName.setEditable(var);
        //jButtonSave.setEnabled(var);
        jCheckBox1.setEnabled(var);
        //jButtonDel.setEnabled(var);
    }
    
    public void setupLookup() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteXPer(Persistent x) {
        return (this.theSetupControl.deleteXrayPosition((XRayPosition)x)>0);
    }

    public boolean saveXPer(Persistent x) {
       //return false;
      return (this.theSetupControl.saveXrayPosition((XRayPosition)x)>0);
    }

    public Vector listXPer(String key, String active, int offset) {
        return theSetupControl.listXrayPositionBySearch(key.toUpperCase(),active);
    }

    public boolean isActiveVisible() {
        return true;
    }

      public static String TITLE = Constant.getTextBundle("��� �ͧ��é�� X-Ray");
    public String getTitle() {
        return TITLE;
    }

    public XRayPosition getTheXRayPosition() {
         if(theXRayPosition==null)
            theXRayPosition = new XRayPosition();

        theXRayPosition.xray_position_id= jTextFieldCode.getText();
        theXRayPosition.description = jTextAreaName.getText();
        if(jCheckBox1.isSelected())
                theXRayPosition.active = "1";
        else    theXRayPosition.active = "0";    
        
        return theXRayPosition;
    }

    public void setTheXRayPosition(XRayPosition x) {
        theXRayPosition = x;
        jTextFieldCode.setText(theXRayPosition.xray_position_id);
        jTextAreaName.setText(theXRayPosition.description);
        
        if((theXRayPosition.active)!=null&&(theXRayPosition.active).equals("1"))
        jCheckBox1.setSelected(true);
        else
        jCheckBox1.setSelected(false);
    }

    public boolean isStartVisible() {
        return false;
    }
        

}
