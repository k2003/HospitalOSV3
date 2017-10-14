/*
 * PanelSDSetupGuide.java
 *
 * Created on April 2, 2009, 10:02 AM
 */

package com.hosv3.gui.panel.detail;

import com.hospital_os.object.Guide;
import com.hospital_os.usecase.connection.Persistent;
import com.hosv3.utility.Constant;
import com.hospital_os.utility.Gutil;
import com.hosv3.control.HosControl;
import com.hosv3.control.LookupControl;
import com.hosv3.control.SetupControl;
import com.hosv3.gui.component.PanelSetupImp;
import com.hosv3.utility.connection.UpdateStatus;
import java.util.Vector;

/**
 *
 * @author  Administrator
 */
public class PanelSDGuide extends javax.swing.JPanel  implements PanelSetupImp{
    UpdateStatus theUS;
    SetupControl theSetupControl;
    LookupControl theLookupControl;
    //Object
    private Guide  theGuide;
    //Vector
    Vector vGuide = new Vector();
    //Other
    String[] col = {"����","���й�"};      
    int offset = 20;
    int next = 0;
    int prev = 0;
    int saved = 0; // 0 ��� �������ö insert�� 1 ��� insert ��
    /** Creates new form PanelSDSetupGuide */
    public PanelSDGuide() {
        initComponents();
        //setLanguage();
    }
    
    public PanelSDGuide(HosControl hc,UpdateStatus us) {
        initComponents();
        setControl(hc,us);
        //setLanguage();
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
        jTextCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextAreaGuideAfterDx = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(300, 120));
        setPreferredSize(new java.awt.Dimension(300, 120));
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(350, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 120));
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

        jTextCode.setFont(defaultFont1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel2.add(jTextCode, gridBagConstraints);

        jLabel2.setFont(defaultFont1);
        jLabel2.setText("���й�");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jScrollPane21.setMaximumSize(new java.awt.Dimension(150, 100));
        jScrollPane21.setMinimumSize(new java.awt.Dimension(150, 100));
        jScrollPane21.setPreferredSize(new java.awt.Dimension(150, 100));

        jTextAreaGuideAfterDx.setFont(defaultFont1);
        jTextAreaGuideAfterDx.setLineWrap(true);
        jTextAreaGuideAfterDx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextAreaGuideAfterDxKeyReleased(evt);
            }
        });
        jScrollPane21.setViewportView(jTextAreaGuideAfterDx);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel2.add(jScrollPane21, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextAreaGuideAfterDxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaGuideAfterDxKeyReleased
        
    }//GEN-LAST:event_jTextAreaGuideAfterDxKeyReleased
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.gui.font.DefaultFont defaultFont1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JTextArea jTextAreaGuideAfterDx;
    private javax.swing.JTextField jTextCode;
    // End of variables declaration//GEN-END:variables

    public void clearAll() {
        this.setTheGuide(new Guide());
    }

    public Persistent getXPer() {
        return this.getTheGuide();
    }

    public void setXPer(Persistent x) {
        this.setTheGuide((Guide)x);
    }

    public void setLanguage() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setControl(HosControl hc, UpdateStatus us) {
        theUS = us;
        theSetupControl = hc.theSetupControl;
        theLookupControl = hc.theLookupControl;
        hc.theHS.theSetupSubject.addpanelrefrash(this);
        hc.theHS.theSetupSubject.addForLiftAttach(this);
        setEnabled(false);      
    }

    public void setupLookup() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteXPer(Persistent x) {
      
        return (this.theSetupControl.deleteGuide((Guide)x)>0);
    }

    public boolean saveXPer(Persistent x) {
        return (this.theSetupControl.saveGuide((Guide)x)>0);
    }

    public Vector listXPer(String key, String active, int offset) {
        return theLookupControl.listGuideNCF(key);
    }

    public boolean isActiveVisible() {
        return false;
    }

    public static String TITLE = Constant.getTextBundle("���й���ѧ��Ǩ");
    public String getTitle() {
        return TITLE;
    }

    public //Object
    Guide getTheGuide() {
       theGuide.number = Gutil.CheckReservedWords(jTextCode.getText());
       theGuide.description = Gutil.CheckReservedWords(jTextAreaGuideAfterDx.getText());
        return theGuide;
    }

    public void setTheGuide(Guide item) {
        theGuide = item;
        jTextCode.setText(theGuide.number);
        jTextAreaGuideAfterDx.setText(theGuide.description);
    }

    public boolean isStartVisible() {
        return false;
    }
        

}
