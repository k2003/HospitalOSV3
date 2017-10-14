/*
 * PanelTest.java
 *
 * Created on 28 ����Ҿѹ�� 2550, 14:22 �.
 */

package com.hospital_os.utility;

import java.awt.*;
/**
 *
 * @author  henbe
 */
public class PIDPanelGui extends javax.swing.JPanel {
    
    public static int COLUMNS = 13;
    /** Creates new form PanelTest */
    public PIDPanelGui() {
        initComponents();
        integerTextField1.setDigits(1);
        integerTextField2.setDigits(4);
        integerTextField3.setDigits(5);
        integerTextField4.setDigits(2);
        integerTextField5.setDigits(1);
    }
    public void setFont(Font f){
        if(integerTextField1!=null)
        {
            integerTextField1.setFont(f);
            integerTextField2.setFont(f);
            integerTextField3.setFont(f);
            integerTextField4.setFont(f);
            integerTextField5.setFont(f);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        integerTextField1 = new com.hospital_os.utility.IntegerTextField();
        integerTextField2 = new com.hospital_os.utility.IntegerTextField();
        integerTextField3 = new com.hospital_os.utility.IntegerTextField();
        integerTextField4 = new com.hospital_os.utility.IntegerTextField();
        integerTextField5 = new com.hospital_os.utility.IntegerTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        integerTextField1.setMinimumSize(new java.awt.Dimension(15, 19));
        integerTextField1.setPreferredSize(new java.awt.Dimension(15, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        add(integerTextField1, gridBagConstraints);

        integerTextField2.setPreferredSize(new java.awt.Dimension(39, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        add(integerTextField2, gridBagConstraints);

        integerTextField3.setPreferredSize(new java.awt.Dimension(49, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        add(integerTextField3, gridBagConstraints);

        integerTextField4.setPreferredSize(new java.awt.Dimension(26, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        add(integerTextField4, gridBagConstraints);

        integerTextField5.setMinimumSize(new java.awt.Dimension(15, 19));
        integerTextField5.setPreferredSize(new java.awt.Dimension(15, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        add(integerTextField5, gridBagConstraints);

        jLabel1.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        add(jLabel2, gridBagConstraints);

        jLabel3.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        add(jLabel4, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hospital_os.utility.IntegerTextField integerTextField1;
    private com.hospital_os.utility.IntegerTextField integerTextField2;
    private com.hospital_os.utility.IntegerTextField integerTextField3;
    private com.hospital_os.utility.IntegerTextField integerTextField4;
    private com.hospital_os.utility.IntegerTextField integerTextField5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
    public void requestFocus() {
        integerTextField5.requestFocus();
    }
    
    public void setText(String txt) {
        if(txt!=null && txt.length()==13) {
            integerTextField1.setText(txt.substring(0, 1));
            integerTextField2.setText(txt.substring(1, 5));
            integerTextField3.setText(txt.substring(5, 10));
            integerTextField4.setText(txt.substring(10, 12));
            integerTextField5.setText(txt.substring(12));
        } else {
            integerTextField1.setText("");
            integerTextField2.setText("");
            integerTextField3.setText("");
            integerTextField4.setText("");
            integerTextField5.setText("");
        }
    }
    public String getText() {
        StringBuffer buff = new StringBuffer(integerTextField1.getText());
        buff.append(integerTextField2.getText());
        buff.append(integerTextField3.getText());
        buff.append(integerTextField4.getText());
        buff.append(integerTextField5.getText());
        if(buff.length()!=COLUMNS)
            return "";
        return buff.toString();
    }
    public void setEditable(boolean editable) {
        integerTextField1.setEditable(editable);
        integerTextField2.setEditable(editable);
        integerTextField3.setEditable(editable);
        integerTextField4.setEditable(editable);
        integerTextField5.setEditable(editable);
    }
    public void setBackground(Color color) {
        try{
            integerTextField1.setBackground(color);
            integerTextField2.setBackground(color);
            integerTextField3.setBackground(color);
            integerTextField4.setBackground(color);
            integerTextField5.setBackground(color);
        }catch(Exception e){
            
        }
    }
}
