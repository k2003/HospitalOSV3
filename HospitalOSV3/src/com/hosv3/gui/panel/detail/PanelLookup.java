/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJPanel1.java
 *
 * Created on 30 �.�. 2552, 17:01:34
 */

package com.hosv3.gui.panel.detail;

import com.hospital_os.usecase.connection.ConnectionInf;
import com.hosv3.control.MapCon;
import com.hosv3.gui.component.TTableCellRenderer;
import com.hosv3.utility.ConnectionDBMgr;
import com.hosv3.utility.connection.UpdateStatus;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henbe
 */
public class PanelLookup extends javax.swing.JDialog {

    String[] colLookup = new String[]{"�š�ä�"};
    private Vector vLookup;
    TTableCellRenderer tt = new TTableCellRenderer();
    private MapCon theMC;
    private long firstClickTime;
    private String dataret;
    /** Creates new form NewJPanel1 */
    public PanelLookup(JFrame jf,MapCon con) {
        super(jf,true);
        initComponents();
        theMC = con;
        this.setSize(300,300);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-getSize().width)/2, (screenSize.height-getSize().height)/2);
    }

    public String[] getLookup(){
        int index = this.jTableLookup.getSelectedRow();
        if(index==-1)
            return null;
        String[] data = (String[])vLookup.get(index);
        return data;
    }
    private JLabel initJLabel(String[] data) {
        JLabel jl = new JLabel();
            jl.setText(data[1]);
            jl.setOpaque(true);
            String[] datas = data[2].split(",");
            StringBuffer datass = new StringBuffer();
            datass.append("<html><body>");
            for(int j=0;j<datas.length;j++){
                if(j!=0)
                    datass.append("<br>");
                datass.append(datas[j]);
            }
            datass.append("</body></html>");
            jl.setToolTipText(datass.toString());
            return jl;
    }
    private void setLookupV(Vector listData) {
        vLookup = listData;
        if(vLookup==null)
            vLookup = new Vector();
        DefaultTableModel dlm = new DefaultTableModel(colLookup,vLookup.size());
        for(int i=0;i<vLookup.size();i++){
            String[] data = (String[])vLookup.get(i);
            JLabel jl = this.initJLabel(data);
            dlm.setValueAt(jl,i,0);
        }
        this.jTableLookup.setModel(dlm);
//         TableRowSorter sorter = new TableRowSorter(dlm);
//         jTableLookup.setRowSorter(sorter);
        this.jTableLookup.getColumnModel().getColumn(0).setCellRenderer(tt);
        this.jTableLookup.getColumnModel().getColumn(0).setCellEditor(tt);

    }
    public static String showDialog(JFrame jf,MapCon con,String search){
        PanelLookup pl = new PanelLookup(jf,con);
        pl.setTitle("���Ң�����");
        pl.jTextFieldLookup1.setText(search);
        pl.jTextFieldLookup1ActionPerformed(null);
        pl.setVisible(true);
        return pl.dataret;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextFieldLookup1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableLookup = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        jTextFieldLookup1.setText("��͡�Ӥ�");
        jTextFieldLookup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLookup1ActionPerformed(evt);
            }
        });
        jTextFieldLookup1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldLookup1KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jTextFieldLookup1, gridBagConstraints);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(250, 100));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(250, 100));

        jTableLookup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableLookupMouseReleased(evt);
            }
        });
        jTableLookup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableLookupKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableLookupKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableLookup);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jScrollPane3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLookup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLookup1ActionPerformed
        setLookupV(theMC.listParent(this.jTextFieldLookup1.getText()));
}//GEN-LAST:event_jTextFieldLookup1ActionPerformed

    private void jTableLookupMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLookupMouseReleased
        dbclick();
}//GEN-LAST:event_jTableLookupMouseReleased

    private void jTableLookupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableLookupKeyReleased
        
}//GEN-LAST:event_jTableLookupKeyReleased

    private void jTextFieldLookup1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLookup1KeyReleased
        if(evt.getKeyCode()!=KeyEvent.VK_DOWN)
            return;
        this.jTableLookup.requestFocus();
        if(this.jTableLookup.getRowCount()==0)
            return;
        jTableLookup.setRowSelectionInterval(0,0);
    }//GEN-LAST:event_jTextFieldLookup1KeyReleased

    private void jTableLookupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableLookupKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            dataret = getLookup()[0];
            this.setVisible(false);
        }
    }//GEN-LAST:event_jTableLookupKeyPressed
    private void dbclick() {
        long clickTime = System.currentTimeMillis();
        long clickInterval = clickTime - firstClickTime;
        if(clickInterval < 400) {
            dataret = getLookup()[0];
            this.setVisible(false);
            firstClickTime = 0;
        }
        else
            firstClickTime = clickTime;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableLookup;
    private javax.swing.JTextField jTextFieldLookup1;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] argc){
        ConnectionInf con = new ConnectionDBMgr();
        MapCon mc = new MapCon(MapCon.LOOK_PERSON,null,con);
        System.out.println(PanelLookup.showDialog(null,mc,"����� �"));
    }
}
