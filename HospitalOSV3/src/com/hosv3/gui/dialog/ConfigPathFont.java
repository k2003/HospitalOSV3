/* * ConfigPathFont.java * * Created on 20 ?????? 2547, 9:29 ?. */package com.hosv3.gui.dialog;import com.printing.utility.*;import com.hosv3.utility.*;/** * * @author  tong */public class ConfigPathFont extends javax.swing.JDialog{        /** Creates new form ConfigPathFont */    boolean actionCommand = false;    private String pathPrint;    public ConfigPathFont(java.awt.Frame parent, boolean modal)    {        super(parent, modal);        initComponents();        setLanguage("");            }        /** This method is called from within the constructor to     * initialize the form.     * WARNING: Do NOT modify this code. The content of this method is     * always regenerated by the Form Editor.     */    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents    private void initComponents() {        java.awt.GridBagConstraints gridBagConstraints;        jPanel1 = new javax.swing.JPanel();        jLabel1 = new javax.swing.JLabel();        jTextField1 = new javax.swing.JTextField();        jButton1 = new javax.swing.JButton();        jButton2 = new javax.swing.JButton();        getContentPane().setLayout(new java.awt.GridBagLayout());        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);        setResizable(false);        jPanel1.setLayout(new java.awt.GridBagLayout());        jLabel1.setText("\u0e01\u0e33\u0e2b\u0e19\u0e14\u0e15\u0e33\u0e41\u0e2b\u0e19\u0e48\u0e07\u0e17\u0e35\u0e48\u0e40\u0e01\u0e47\u0e1a\u0e44\u0e1f\u0e25\u0e4c\u0e23\u0e39\u0e1b\u0e41\u0e1a\u0e1a\u0e2d\u0e31\u0e01\u0e29\u0e23 (font path)");        gridBagConstraints = new java.awt.GridBagConstraints();        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);        jPanel1.add(jLabel1, gridBagConstraints);        jTextField1.setMinimumSize(new java.awt.Dimension(200, 21));        jTextField1.setPreferredSize(new java.awt.Dimension(200, 21));        gridBagConstraints = new java.awt.GridBagConstraints();        gridBagConstraints.gridx = 0;        gridBagConstraints.gridy = 1;        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;        gridBagConstraints.insets = new java.awt.Insets(5, 10, 11, 0);        jPanel1.add(jTextField1, gridBagConstraints);        jButton1.setText("...");        jButton1.setMaximumSize(new java.awt.Dimension(24, 24));        jButton1.setMinimumSize(new java.awt.Dimension(24, 24));        jButton1.setPreferredSize(new java.awt.Dimension(26, 24));        jButton1.addActionListener(new java.awt.event.ActionListener() {            public void actionPerformed(java.awt.event.ActionEvent evt) {                jButton1ActionPerformed(evt);            }        });        gridBagConstraints = new java.awt.GridBagConstraints();        gridBagConstraints.gridx = 1;        gridBagConstraints.gridy = 1;        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;        gridBagConstraints.insets = new java.awt.Insets(3, 5, 11, 0);        jPanel1.add(jButton1, gridBagConstraints);        jButton2.setText("\u0e15\u0e01\u0e25\u0e07");        jButton2.setMaximumSize(new java.awt.Dimension(61, 24));        jButton2.setMinimumSize(new java.awt.Dimension(61, 24));        jButton2.setPreferredSize(new java.awt.Dimension(61, 24));        jButton2.addActionListener(new java.awt.event.ActionListener() {            public void actionPerformed(java.awt.event.ActionEvent evt) {                jButton2ActionPerformed(evt);            }        });        gridBagConstraints = new java.awt.GridBagConstraints();        gridBagConstraints.gridx = 2;        gridBagConstraints.gridy = 1;        gridBagConstraints.gridwidth = 2;        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;        gridBagConstraints.weightx = 1.0;        gridBagConstraints.insets = new java.awt.Insets(3, 10, 11, 10);        jPanel1.add(jButton2, gridBagConstraints);        gridBagConstraints = new java.awt.GridBagConstraints();        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;        gridBagConstraints.weightx = 1.0;        gridBagConstraints.weighty = 1.0;        getContentPane().add(jPanel1, gridBagConstraints);        pack();    }// </editor-fold>//GEN-END:initComponents        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed            // TODO add your handling code here:            writeFile();            this.dispose();    }//GEN-LAST:event_jButton2ActionPerformed            private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed                // TODO add your handling code here:                showChooseFile();    }//GEN-LAST:event_jButton1ActionPerformed                        public void writeFile()            {                try                {                    Class.forName("com.hospital_os.utility.IOStream");                }                catch(ClassNotFoundException ex)                {                    javax.swing.JOptionPane.showMessageDialog(this,"��辺 Module HospitalOS ","Error",javax.swing.JOptionPane.OK_OPTION);                    return;                }                ReadWriteFileConfig.WriteFile(pathPrint, ".fontpath.cfg");            }                                    public void showChooseFile()            {                javax.swing.JFileChooser jcc = new javax.swing.JFileChooser();                java.io.File f;                                //???�??????? TextField ???????????????                if(this.jTextField1.getText().length() != 0)                {   //?????????? Dialog ??? Path ???????? TextField                    f = new java.io.File(this.jTextField1.getText());                    //?????????? Diractory ????????                    if(f.isDirectory())                    {   //?? ?? Set Path ????????w???????                        jcc.setCurrentDirectory(f);                    }                    jcc.showDialog(this,"Choose");                    f = jcc.getCurrentDirectory();                                        this.jTextField1.setText(f.getPath());                                    }                else                {   jcc.showDialog(this,"Choose");                    f = jcc.getCurrentDirectory();                    this.jTextField1.setText(f.getPath());                                    }                pathPrint = f.getPath()+ "/";                f = null;                jcc = null;                            }                        public static boolean showDialog(javax.swing.JFrame frm)            {   ConfigPathFont dlg;                if(frm == null)                {   javax.swing.JFrame frmm = new javax.swing.JFrame();                    dlg = new ConfigPathFont(frmm,true);                }                else                    dlg = new ConfigPathFont(frm,true);                                // dlg.setSize(300,130);                dlg.setTitle("���͡ Path");                                java.awt.Toolkit thekit = dlg.getToolkit();                java.awt.Dimension screenSize = thekit.getDefaultToolkit().getScreenSize();//thekit.getScreenSize();                //dlg.setBounds((screenSize.width +  50)/2,(screenSize.height +  50)/2, dlg.getSize().width,dlg.getSize().height);                dlg.setLocation((screenSize.width-dlg.getSize().width)/2, (screenSize.height-dlg.getSize().height)/2);                                dlg.setVisible(true);                if(dlg.actionCommand)                {                    return true;                }                dlg=null;                System.gc();                return false;            }    public void setLanguage(String msg)    {                GuiLang.setLanguage(jButton1);        GuiLang.setLanguage(jButton2);        GuiLang.setLanguage(jLabel1);        GuiLang.setTextBundle(jPanel1);    }                                                /**             * @param args the command line arguments             */            public static void main(String args[])            {                                new ConfigPathFont(new javax.swing.JFrame(), true).setVisible(true);            }                // Variables declaration - do not modify//GEN-BEGIN:variables    private javax.swing.JButton jButton1;    private javax.swing.JButton jButton2;    private javax.swing.JLabel jLabel1;    private javax.swing.JPanel jPanel1;    private javax.swing.JTextField jTextField1;    // End of variables declaration//GEN-END:variables}