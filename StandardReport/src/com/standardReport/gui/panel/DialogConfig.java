/*
 * DialogConfig.java
 *
 * Created on 30 �á�Ҥ� 2548, 14:02 �.
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package com.standardReport.gui.panel;

import com.standardReport.utility.DatabaseType;
import javax.swing.JFrame;
import java.awt.Dialog;
import java.sql.Connection;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import com.standardReport.subject.EnableGUIInf;
import com.standardReport.utility.*;


/**
 *
 * @author  Administrator
 */
public class DialogConfig extends javax.swing.JDialog  implements EnableGUIInf{
    
    /** Creates new form DialogConfig */
    public boolean actionCommand = false;
    public boolean status = false;
    Properties settings = new Properties();
    String filename = "./.reportcenter.cfg";
    String url_1 = "jdbc:postgresql://";
    String url_2 = "jdbc:microsoft:sqlserver://";
    String url_3 = "jdbc:mysql://";
    
    DatabaseType  theDatabaseType = new DatabaseType();
    public DialogConfig(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        parent.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/reportcenter/images/Icon.gif")));
        
        initComponents();
        setLanguage("");
        setCombo();
        
        readDataFromFile();
        try {
            String config = IOStream.readInputDefault(filename);
            
            //�ʹ���ʵç���
            String conf = Secure.decode(config);
            
            String tmp = new String();
            String value = new String();
            
            tmp = conf.substring(0, conf.indexOf("\n"));
            conf = conf.substring(conf.indexOf("\n")+1);
            value = tmp.substring(tmp.indexOf("=")+1);
            settings.put("DONT_REMIND", value.trim());
            tmp = conf.substring(0, conf.indexOf("\n"));
            conf = conf.substring(conf.indexOf("\n")+1);
            value = tmp.substring(tmp.indexOf("=")+1);
            settings.put("SERVER", value.trim());
            tmp = conf.substring(0, conf.indexOf("\n"));
            conf = conf.substring(conf.indexOf("\n")+1);
            value = tmp.substring(tmp.indexOf("=")+1);
            settings.put("DATABASE", value.trim());
            tmp = conf.substring(0, conf.indexOf("\n"));
            conf = conf.substring(conf.indexOf("\n")+1);
            value = tmp.substring(tmp.indexOf("=")+1);
            settings.put("PORT", value.trim());
            tmp = conf.substring(0, conf.indexOf("\n"));
            conf = conf.substring(conf.indexOf("\n")+1);
            value = tmp.substring(tmp.indexOf("=")+1);
            settings.put("USERNAME", value.trim());
            tmp = conf.substring(0, conf.indexOf("\n"));
            conf = conf.substring(conf.indexOf("\n")+1);
            value = tmp.substring(tmp.indexOf("=")+1);
            settings.put("PASSWORD", value.trim());
            tmp = conf.substring(0, conf.indexOf("\n"));
            conf = conf.substring(conf.indexOf("\n")+1);
            value = tmp.substring(tmp.indexOf("=")+1);
            settings.put("DATABASETYPE", value.trim());
        }
        catch(Exception e) {
            //e.printStackTrace();
            //System.exit(-1);
            settings.put("DONT_REMIND", "0");
            settings.put("SERVER", "");
            settings.put("DATABASE", "");
            settings.put("PORT", "5432");
            settings.put("USERNAME", "");
            settings.put("PASSWORD", "");
        }
        
        // �ʴ���
        jTextFieldServer.setText(settings.getProperty("SERVER"));
        jTextFieldDatabase.setText(settings.getProperty("DATABASE"));
        jTextFieldPort.setText(settings.getProperty("PORT"));
        jTextFieldUserName.setText(settings.getProperty("USERNAME"));
        //jPasswordField.setText(settings.getProperty("PASSWORD"));
        if(settings.getProperty("DATABASETYPE") !=null)
            this.jComboBoxDatabaseType.setSelectedItem(settings.getProperty("DATABASETYPE"));
        else
            this.jComboBoxDatabaseType.setSelectedIndex(0);
        
        
        // �Ѻ��Ҩҡ Properties �����ʴ���ͤ�������ա���͡�˹������� Check box
        int dont_remind = 0;
        try {
            dont_remind = Integer.parseInt(settings.getProperty("DONT_REMIND"));
        }
        catch(Exception ex) {
            dont_remind = 0;
        }
        if(dont_remind==1) {
            this.jCheckBoxRemind.setSelected(true);
            jPanel1.remove(jCheckBoxRemind);
        }
        else {
            jCheckBoxRemind.setSelected(false);
        }
        // Set Button Login is default button
        // this.getRootPane().setDefaultButton(jButtonSave);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        
        jPanel1 = new javax.swing.JPanel();
        jLabelServer = new javax.swing.JLabel();
        jLabelDatabase = new javax.swing.JLabel();
        jLabelPort = new javax.swing.JLabel();
        jLabelDatabaseType = new javax.swing.JLabel();
        jTextFieldServer = new javax.swing.JTextField();
        jTextFieldDatabase = new javax.swing.JTextField();
        jTextFieldPort = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jLabelUserName = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JPasswordField();
        jComboBoxDatabaseType = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCabcel = new javax.swing.JButton();
        jCheckBoxRemind = new javax.swing.JCheckBox();
        
        getContentPane().setLayout(new java.awt.GridBagLayout());
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        
        jPanel1.setLayout(new java.awt.GridBagLayout());
        
        jPanel1.setBorder(new javax.swing.border.TitledBorder("Database Connection"));
        jPanel1.setMinimumSize(new java.awt.Dimension(231, 191));
        jPanel1.setPreferredSize(new java.awt.Dimension(231, 191));
        jLabelServer.setText("SERVER");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabelServer, gridBagConstraints);
        
        jLabelDatabase.setText("DATABASE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabelDatabase, gridBagConstraints);
        
        jLabelPort.setText("PORT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabelPort, gridBagConstraints);
        
        jLabelDatabaseType.setText("DATABASE_TYPE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabelDatabaseType, gridBagConstraints);
        
        jTextFieldServer.setText(" ");
        jTextFieldServer.setMinimumSize(new java.awt.Dimension(30, 21));
        jTextFieldServer.setPreferredSize(new java.awt.Dimension(30, 21));
        jTextFieldServer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldServerKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldServerKeyReleased(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jTextFieldServer, gridBagConstraints);
        
        jTextFieldDatabase.setText(" ");
        jTextFieldDatabase.setMinimumSize(new java.awt.Dimension(30, 21));
        jTextFieldDatabase.setPreferredSize(new java.awt.Dimension(30, 21));
        jTextFieldDatabase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDatabaseKeyPressed(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel1.add(jTextFieldDatabase, gridBagConstraints);
        
        jTextFieldPort.setText(" ");
        jTextFieldPort.setMinimumSize(new java.awt.Dimension(30, 21));
        jTextFieldPort.setPreferredSize(new java.awt.Dimension(30, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jTextFieldPort, gridBagConstraints);
        
        jLabelPassword.setText("PASSWORD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabelPassword, gridBagConstraints);
        
        jLabelUserName.setText("USER_NAME");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel1.add(jLabelUserName, gridBagConstraints);
        
        jTextFieldUserName.setMinimumSize(new java.awt.Dimension(30, 1));
        jTextFieldUserName.setPreferredSize(new java.awt.Dimension(30, 21));
        jTextFieldUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUserNameKeyPressed(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel1.add(jTextFieldUserName, gridBagConstraints);
        
        jTextFieldPassword.setMinimumSize(new java.awt.Dimension(30, 21));
        jTextFieldPassword.setPreferredSize(new java.awt.Dimension(30, 21));
        jTextFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPasswordKeyPressed(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel1.add(jTextFieldPassword, gridBagConstraints);
        
        jComboBoxDatabaseType.setMinimumSize(new java.awt.Dimension(30, 21));
        jComboBoxDatabaseType.setPreferredSize(new java.awt.Dimension(30, 21));
        jComboBoxDatabaseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDatabaseTypeActionPerformed(evt);
            }
        });
        jComboBoxDatabaseType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDatabaseTypeItemStateChanged(evt);
            }
        });
        jComboBoxDatabaseType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxDatabaseTypeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxDatabaseTypeMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBoxDatabaseTypeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBoxDatabaseTypeMouseReleased(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jComboBoxDatabaseType, gridBagConstraints);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);
        
        jPanel3.setLayout(new java.awt.GridBagLayout());
        
        jPanel2.setLayout(new java.awt.GridBagLayout());
        
        jButtonOK.setText("OK");
        jButtonOK.setMaximumSize(new java.awt.Dimension(75, 25));
        jButtonOK.setMinimumSize(new java.awt.Dimension(75, 25));
        jButtonOK.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        
        jPanel2.add(jButtonOK, new java.awt.GridBagConstraints());
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel3.add(jPanel2, gridBagConstraints);
        
        jButtonCabcel.setText("CANCEL");
        jButtonCabcel.setMaximumSize(new java.awt.Dimension(75, 25));
        jButtonCabcel.setMinimumSize(new java.awt.Dimension(75, 25));
        jButtonCabcel.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonCabcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCabcelActionPerformed(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel3.add(jButtonCabcel, gridBagConstraints);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel3, gridBagConstraints);
        
        jCheckBoxRemind.setSelected(true);
        jCheckBoxRemind.setText("Conferm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        
        //comment by noom
        //getContentPane().add(jCheckBoxRemind, gridBagConstraints);
        
        pack();
    }
    private void jButtonCabcelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        
        // Add your handling code here:
        
        dispose();
        if(status)
            closeDialog();
        //  System.exit(0);
    }
    private void jTextFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if(evt != null)
        {   int keyEnter = evt.getKeyCode();
            if(keyEnter == java.awt.event.KeyEvent.VK_ENTER) {
                jButtonOKActionPerformed(null);
            }
        }
    }
    private void jTextFieldUserNameKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if(evt != null)
        {   int keyEnter = evt.getKeyCode();
            if(keyEnter == java.awt.event.KeyEvent.VK_ENTER) {
                jButtonOKActionPerformed(null);
            }
        }
    }
    private void jTextFieldDatabaseKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if(evt != null)
        {   int keyEnter = evt.getKeyCode();
            if(keyEnter == java.awt.event.KeyEvent.VK_ENTER) {
                jButtonOKActionPerformed(null);
            }
        }
    }
    private void jTextFieldServerKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if(evt != null)
        {   int keyEnter = evt.getKeyCode();
            if(keyEnter == java.awt.event.KeyEvent.VK_ENTER) {
                jButtonOKActionPerformed(null);
            }
        }
    }
    private void jTextFieldServerKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }
    private void jComboBoxDatabaseTypeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        
        
        String type = ((String)this.jComboBoxDatabaseType.getSelectedItem()).trim();
        CheckDataBaseType theCheckDataBaseType = new CheckDataBaseType();
        int typedata = theCheckDataBaseType.getDataBaseType(type);
        switch(typedata)
        {     case 0 :  this.jTextFieldPort.setText("5432");
              break;
            case 1 :  this.jTextFieldPort.setText("1433");
            break;
            case 2 :  this.jTextFieldPort.setText("3306");
            break;
        }
    }
    private void jComboBoxDatabaseTypeMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        
    }
    private void jComboBoxDatabaseTypeMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        
    }
    private void jComboBoxDatabaseTypeMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        
    }
    private void jComboBoxDatabaseTypeMouseReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        
    }
    private void jComboBoxDatabaseTypeItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        
    }
    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your handling code here:
        String server = jTextFieldServer.getText().trim();
        String database = jTextFieldDatabase.getText().trim();
        String port = jTextFieldPort.getText().trim();
        String username = jTextFieldUserName.getText().trim();
        String password = new String(jTextFieldPassword.getPassword());
        String databasetype = ((String)this.jComboBoxDatabaseType.getSelectedItem()).trim();
        
        
        CheckDataBaseType theCheckDataBaseType = new CheckDataBaseType();
        int typedata = theCheckDataBaseType.getDataBaseType(databasetype);
        String url = new String();
        switch(typedata)
        {     case 0 :  url = url_1;
              if(port!=null && !port.equals(""))
                  url = url+server+":"+port+"/"+database;
              else
                  url = url+server+"/"+database;
              break;
            case 1 :  url = url_2;
            url = url + server + ":" + port + ";User=" + username + ";Password=" + password + ";DatabaseName=" + database;
            
            break;
            case 2 :  url = url_3;
            url = url + server + "/" + database;
            break;
        }
        
        
        if(!server.equals("") &&
        !database.equals("") &&
        !username.equals("") &&
        !password.equals("") &&
        ConnectionDBMgr.checkConnection(url, username, password, typedata)
        ) {
            settings.setProperty("SERVER", server);
            settings.setProperty("DATABASE", database);
            settings.setProperty("PORT", port);
            settings.setProperty("USERNAME", username);
            settings.setProperty("PASSWORD", password);
            settings.setProperty("DATABASETYPE",  databasetype);
            
            if(jCheckBoxRemind.isSelected())
                settings.setProperty("DONT_REMIND", "1");
            else
                settings.setProperty("DONT_REMIND", "0");
            try {
                StringBuffer conf = new StringBuffer();
                conf.append("DONT_REMIND=" + settings.getProperty("DONT_REMIND") + "\n");
                conf.append("SERVER=" + settings.getProperty("SERVER") + "\n");
                conf.append("DATABASE=" + settings.getProperty("DATABASE") + "\n");
                conf.append("PORT=" + settings.getProperty("PORT") + "\n");
                conf.append("USERNAME=" + settings.getProperty("USERNAME") + "\n");
                conf.append("PASSWORD=" + settings.getProperty("PASSWORD") + "\n");
                conf.append("DATABASETYPE=" + settings.getProperty("DATABASETYPE") + "\n");
                // ������ʵç���
                String config = Secure.encode(conf.toString());
                
                IOStream.writeOutputDefault(config, filename);
                //IOStream.writeOutputDefault(conf.toString(), filename);
                
            }
            catch (Exception e) {
                //e.printStackTrace();
                //System.exit(-1);
            }
            actionCommand = true;
            
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "�������ö�Դ�������ͧ�������� !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {
        setVisible(false);
        dispose();
        if(status){   
            closeDialog();
            
        }
    }
    
    private void closeDialog()
    {   
        //commend by noom not want close program of dataware house
        //JOptionPane.showMessageDialog(this,"������зӡ�ûԴ����ͧ","��͹",JOptionPane.YES_OPTION);
        //System.exit(0);
    }
    private void readDataFromFile() {
        try {
            String config = IOStream.readInputDefault(filename);
        }
        catch(Exception e) {
            IOStream.writeOutputDefault("", filename);
            
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //   new DialogConfig(new javax.swing.JFrame(), true).show();
        //DialogConfig theDialogConfig = new DialogConfig(new JFrame(),true);
        DialogConfig.showDialog(new JFrame(),true);
        
    }
    
    
    
    
    // Variables declaration - do not modify
    private javax.swing.JButton jButtonCabcel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JCheckBox jCheckBoxRemind;
    private javax.swing.JComboBox jComboBoxDatabaseType;
    private javax.swing.JLabel jLabelDatabase;
    private javax.swing.JLabel jLabelDatabaseType;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPort;
    private javax.swing.JLabel jLabelServer;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldDatabase;
    private javax.swing.JPasswordField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldServer;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration
    
    private void setCombo() {
        for(int i=0; i < theDatabaseType.databasetype.length ; i++)
            this.jComboBoxDatabaseType.addItem(theDatabaseType.databasetype[i]);
        
        
    }
    
    
    
    public static boolean showDialog(JFrame frm,boolean status ) {
        DialogConfig dlg = new DialogConfig(frm, true);
        dlg.setSize(260,290);//250,300
        
        dlg.setTitle("Connection");
        //   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //   dlg.setLocation((screenSize.width)/2, (screenSize.height)/2);//-(28+dlg.getSize().height/2));
        //   Toolkit thekit = dlg.getToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//thekit.getScreenSize();
        // dlg.setBounds((screenSize.width + dlg.getSize().width + 200 )/4,(screenSize.height + dlg.getSize().height + 50)/4, dlg.getSize().width,dlg.getSize().height);
        dlg.setLocation((screenSize.width-dlg.getSize().width)/2, (screenSize.height-dlg.getSize().height)/2);
        dlg.EnableGUIInf(status);
        
        dlg.setVisible(true);
        if(dlg.actionCommand) { 
            return true;
        }
        dlg=null;
        System.gc();
        return false;
    }
    
    
    public void setLanguage(String msg) {
        this.jLabelDatabase.setText(Gutil.getTextBundle(jLabelDatabase.getText()));
        jButtonCabcel.setText(Gutil.getTextBundle(jButtonCabcel.getText()));
        jButtonOK.setText(Gutil.getTextBundle(jButtonOK.getText()));
        jCheckBoxRemind.setText(Gutil.getTextBundle(jCheckBoxRemind.getText()));
        jLabelDatabase.setText(Gutil.getTextBundle(jLabelDatabase.getText()));
        jLabelDatabaseType.setText(Gutil.getTextBundle(jLabelDatabaseType.getText()));
        jLabelPassword.setText(Gutil.getTextBundle(jLabelPassword.getText()));
        jLabelPort.setText(Gutil.getTextBundle(jLabelPort.getText()));
        jLabelServer.setText(Gutil.getTextBundle(jLabelServer.getText()));
        jLabelUserName.setText(Gutil.getTextBundle(jLabelUserName.getText()));
        filename = Gutil.getTextBundleConfig(filename);
    }
    
    public void EnableGUIInf(boolean b) {
        jTextFieldDatabase.setEnabled(b);
        jTextFieldPassword.setEnabled(b);
        jTextFieldPort.setEnabled(b);
        jTextFieldServer.setEnabled(b);
        jTextFieldUserName.setEnabled(b);
        //jButtonCabcel.setEnabled(b);
        jButtonOK.setEnabled(b);
        jCheckBoxRemind.setEnabled(b);
        jComboBoxDatabaseType.setEnabled(b);
        status = b;
    }
    
}
