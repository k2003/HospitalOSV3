/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosv3.gui.panel.setup;

import com.hospital_os.object.Drug;
import com.hospital_os.object.Item;
import com.hospital_os.object.ItemPrice;
import com.hospital_os.object.LabGroup;
import com.hospital_os.object.LabResultItem;
import com.hospital_os.object.Patient;
import com.hospital_os.utility.ComboboxModel;
import com.hospital_os.utility.Gutil;
import com.hosv3.control.HosControl;
import com.hosv3.control.SetupControl;
import com.hosv3.utility.Config;
import com.hosv3.utility.Constant;
import com.hosv3.utility.DateUtil;
import com.hosv3.utility.connection.UpdateStatus;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author ekapop
 */
public class PanelConvertData extends javax.swing.JPanel {
    Patient thePatient;
    HosControl theHC;
    UpdateStatus theUS;
    SetupControl theSetupControl;
    Item theItem;
    ItemPrice theItemPrice;
    Drug theDrug = new Drug();
    LabResultItem theLabResultItem = new LabResultItem();
    LabGroup theLabGroup = new LabGroup();
    /**
     * Creates new form PanelConvertData
     */
    public PanelConvertData(HosControl hc,UpdateStatus us) {
        initComponents();
        theHC = hc;
        theUS = us;
        theSetupControl = hc.theSetupControl;
        initConfig();
    }
    private void initConfig(){
//        theSplash.setVisible(false);
        theItem = new Item();
        String[] aaa = {txtHostDBD.getText(),txtDatabaseD.getText(), txtUserDBD.getText(), txtPassDBD.getText()};
        Config config = new Config();
//        ConnectionInf con_inf = config.getConnectionInfFromFile(aaa);        
        
        txtHostDBS.setText("172.25.1.5");
        txtUserDBS.setText("sa");
        txtPassDBS.setText("Orawanhospital1*");
        txtPortDBS.setText("1433");
        txtHostDBD.setText("172.25.1.5");
        txtUserDBD.setText("postgres");
        txtPassDBD.setText("orawanhospital");
        txtPortDBD.setText("5432");
        txtDatabaseS.setText("bithis");
        txtDatabaseD.setText("hospital_os_orc1");
        jLabel11.setText("Source 60-10-18");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHostDBS = new javax.swing.JTextField();
        txtDatabaseS = new javax.swing.JTextField();
        txtUserDBS = new javax.swing.JTextField();
        txtPassDBS = new javax.swing.JTextField();
        txtPortDBS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHostDBD = new javax.swing.JTextField();
        txtDatabaseD = new javax.swing.JTextField();
        txtUserDBD = new javax.swing.JTextField();
        txtPassDBD = new javax.swing.JTextField();
        txtPortDBD = new javax.swing.JTextField();
        jButtonConvert = new javax.swing.JButton();
        jButtonOpenFile = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Host DB[source]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jLabel1, gridBagConstraints);

        jLabel9.setText("Database[source]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jLabel9, gridBagConstraints);

        jLabel2.setText("User DB[source]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jLabel2, gridBagConstraints);

        jLabel3.setText("Pass DB[source]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Port[Dest]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(jLabel4, gridBagConstraints);

        txtHostDBS.setText("jTextField1");
        txtHostDBS.setMinimumSize(new java.awt.Dimension(200, 24));
        txtHostDBS.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtHostDBS, gridBagConstraints);

        txtDatabaseS.setText("jTextField1");
        txtDatabaseS.setMinimumSize(new java.awt.Dimension(200, 24));
        txtDatabaseS.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtDatabaseS, gridBagConstraints);

        txtUserDBS.setText("jTextField2");
        txtUserDBS.setMinimumSize(new java.awt.Dimension(200, 24));
        txtUserDBS.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtUserDBS, gridBagConstraints);

        txtPassDBS.setText("jTextField3");
        txtPassDBS.setMinimumSize(new java.awt.Dimension(200, 24));
        txtPassDBS.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtPassDBS, gridBagConstraints);

        txtPortDBS.setText("jTextField4");
        txtPortDBS.setMinimumSize(new java.awt.Dimension(200, 24));
        txtPortDBS.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtPortDBS, gridBagConstraints);

        jLabel5.setText("Host DB[Dest]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        add(jLabel5, gridBagConstraints);

        jLabel10.setText("Database[Dest]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        add(jLabel10, gridBagConstraints);

        jLabel6.setText("User DB[Dest]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        add(jLabel6, gridBagConstraints);

        jLabel7.setText("Pass DB[Dest]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        add(jLabel7, gridBagConstraints);

        jLabel8.setText("Port [Dest]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        add(jLabel8, gridBagConstraints);

        txtHostDBD.setText("jTextField5");
        txtHostDBD.setMinimumSize(new java.awt.Dimension(200, 24));
        txtHostDBD.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtHostDBD, gridBagConstraints);

        txtDatabaseD.setText("jTextField2");
        txtDatabaseD.setMinimumSize(new java.awt.Dimension(200, 24));
        txtDatabaseD.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtDatabaseD, gridBagConstraints);

        txtUserDBD.setText("jTextField6");
        txtUserDBD.setMinimumSize(new java.awt.Dimension(200, 24));
        txtUserDBD.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtUserDBD, gridBagConstraints);

        txtPassDBD.setText("jTextField7");
        txtPassDBD.setMinimumSize(new java.awt.Dimension(200, 24));
        txtPassDBD.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtPassDBD, gridBagConstraints);

        txtPortDBD.setText("jTextField8");
        txtPortDBD.setMinimumSize(new java.awt.Dimension(200, 24));
        txtPortDBD.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(txtPortDBD, gridBagConstraints);

        jButtonConvert.setText("Convert Patient");
        jButtonConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConvertActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jButtonConvert, gridBagConstraints);

        jButtonOpenFile.setText("Convert drug");
        jButtonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jButtonOpenFile, gridBagConstraints);

        jLabel11.setText("Source");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(jLabel11, gridBagConstraints);

        jLabel12.setText("Destination");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(jLabel12, gridBagConstraints);

        jLabel13.setText("jLabel13");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        add(jLabel13, gridBagConstraints);

        jLabel14.setText("jLabel14");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(jLabel14, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConvertActionPerformed
        Vector vNCD = new Vector();
        Integer i=0, cnt=0;
        try {
            // TODO add your handling code here:
            String userDB="sa",passDB="Ekartc2c5", hostDB="DESKTOP-H18GJTN", portDB="", database="";
            String sql = "Select * FROM Pbsinf";
            userDB = txtUserDBS.getText();
            hostDB = txtHostDBS.getText();
            passDB = txtPassDBS.getText();
            portDB = txtPortDBS.getText();
            database = txtDatabaseS.getText();

            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
            Connection con = DriverManager.getConnection( "jdbc:sqlserver://"+hostDB+":"+portDB+";databasename="+database, userDB, passDB );
            //Connection con = DriverManager.getConnection( "jdbc:sqlserver://"+hostDB+";databasename="+database, userDB, passDB );
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            rs.last();
            jLabel14.setText(String.valueOf(rs.getRow()));
//            rs.beforeFirst();
//            while(rs.next()){
//                cnt++;
//            }
//            jLabel14.setText(String.valueOf(cnt));
            rs.beforeFirst();
            while (rs.next()) {
                Integer aa=0;
                String addr=rs.getString("pbsdtladr").trim();
                String addr1=addr;
                String tambon="", hn="";
                aa = addr.indexOf("�.");
                if(aa>0){
                    tambon = rs.getString("pbsdtladr").trim().substring(aa);
                    addr1 = rs.getString("pbsdtladr").trim().substring(0,aa);
                }
                if(rs.getString("pbschtnum").trim().length()>=2){
                    hn = rs.getString("pbschtnum").trim().substring(0,2)+ rs.getString("pbschtnum").trim().substring(2).trim();
                    //String[] bb = hn.split(" ");
                }else{
                    hn = rs.getString("pbschtnum").trim();
                }
                //                dbtime = rs.getString(1);
                i++;
                jLabel13.setText(String.valueOf(i));
                Patient pat = new Patient();
                pat.hn = hn;
                pat.couple_id = "";
                pat.father_pid = "";
                pat.mother_pid = "";
                pat.patient_birthday = "";
                if(rs.getString("pbsbirdte").trim().length()>=8){
                    pat.patient_birthday = (Integer.parseInt(rs.getString("pbsbirdte").trim().substring(0, 4))+543)+"-"+rs.getString("pbsbirdte").trim().substring(4, 6)+"-"+rs.getString("pbsbirdte").trim().substring(6, 8);
                }
                pat.ampur = "";
                
                pat.changwat = getChangwat(rs.getString("pbsadrpro").trim());
                pat.tambon =  "";
                pat.blood_group_id = "1";
                pat.education_type_id = "11";
                pat.status_id =  "2";
                if (rs.getString("pbssextyp").trim().equals("M")){
                    pat.f_sex_id =  "1";
                }else if (rs.getString("pbssextyp").trim().equals("F")){
                    pat.f_sex_id =  "2";
                }else{
                    pat.f_sex_id =  "3";
                }
                pat.labor =  "1";
                pat.marriage_status_id = "1";
                pat.nation_id =  "99";
                pat.occupation_id =  "000";
                pat.f_prefix_id =  "000";
                if (rs.getString("pbstitcod").trim().equals("01")){
                    pat.f_prefix_id =  "003";
                }else if (rs.getString("pbstitcod").trim().equals("02")){
                    pat.f_prefix_id =  "004";
                }else if (rs.getString("pbstitcod").trim().equals("03")){
                    pat.f_prefix_id =  "005";
                }else if (rs.getString("pbstitcod").trim().equals("10")){
                    pat.f_prefix_id =  "002";
                }else if (rs.getString("pbstitcod").trim().equals("11")){
                    pat.f_prefix_id =  "001";
                }else if (rs.getString("pbstitcod").trim().equals("124")){
                    pat.f_prefix_id =  "845";
                }else if (rs.getString("pbstitcod").trim().equals("139")){
                    pat.f_prefix_id =  "848";
                }else if (rs.getString("pbstitcod").trim().equals("176")){
                    pat.f_prefix_id =  "846";
                }else if (rs.getString("pbstitcod").trim().equals("212")){
                    pat.f_prefix_id =  "217";
                }else if (rs.getString("pbstitcod").trim().equals("322")){
                    pat.f_prefix_id =  "847";
                }else if (rs.getString("pbstitcod").trim().equals("329")){
                    pat.f_prefix_id =  "849";
                }else{
                    pat.f_prefix_id =  "000";
                }
                pat.race_id =  "99";
                pat.religion_id =  "1";
                //        pat.typearea =  "1";
                pat.couple_firstname =  "";
                pat.couple_lastname =  "";
                pat.father_firstname =  "";
                pat.father_lastname =  "";
                pat.patient_name =  rs.getString("pbspatnam").trim();
                pat.house =  "";
                pat.patient_last_name =  rs.getString("pbssurnam").trim();
                pat.mother_firstname =  "";
                pat.mother_lastname =  "";
                pat.private_doc =  "";
                pat.p_type =  "";
                pat.road =  addr1.trim();
                pat.village =  "";
                pat.pid =  rs.getString("pbsresnum").trim();
                pat.phone =  rs.getString("pbsphnnum").trim();
                pat.relation =  "00";
                pat.sex_contact =  "1";
                pat.house_contact =  "";
                pat.village_contact =  "";
                pat.road_contact =  "";
                pat.phone_contact =  "";
                pat.ampur_contact = "";
                pat.changwat_contact = "";
                pat.tambon_contact =  "";
                pat.xn =  "";
                pat.contact_fname =  "";
                pat.contact_lname =  "";
                pat.patient_birthday_true = "0";
                pat.record_date_time =  "";
                pat.staff_record = "";
                int ret=theHC.thePatientControl.savePatient(pat,null,"",vNCD);
                sql = "";
                //                System.out.println(dbtime);

            } //end while

            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelConvertData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PanelConvertData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonConvertActionPerformed

    private String getChangwat(String changwat){
        String id="";
        if(changwat.equals("�������")){
            id="450000";
        }else if(changwat.equals("���������")){
            id="310000";
        }else if(changwat.equals("��й�������ظ��")){
            id="140000";
        }else if(changwat.equals("�����ä��")){
            id="440000";
        }else if(changwat.equals("��к���")){
            id="190000";
        }else if(changwat.equals("������ä�")){
            id="600000";
        }else if(changwat.equals("����Ҫ����")){
            id="300000";
        }else if(changwat.equals("����Թ���")){
            id="460000";
        }else if(changwat.equals("�ѷ�ا")){
            id="930000";
        }else if(changwat.equals("�ӹҨ��ԭ")){
            id="370000";
        }else if(changwat.equals("��ɳ��š")){
            id="650000";
        }else if(changwat.equals("������")){
            id="270000";
        }else if(changwat.equals("��ù�¡")){
            id="260000";
        }else if(changwat.equals("���ԧ���")){
            id="240000";
        }else if(changwat.equals("��ᾧྪ�")){
            id="620000";
        }else if(changwat.equals("�������")){
            id="120000";
        }else if(changwat.equals("��ا෾ �")){
            id="100000";
        }else if(changwat.equals("��طû�ҡ��")){
            id="110000";
        }else if(changwat.equals("�ԨԵ�")){
            id="660000";
        }else if(changwat.equals("��ا෾��ҹ��")){
            id="100000";
        }else if(changwat.equals("��ʸ�")){
            id="350000";
        }else if(changwat.equals("��þ��")){
            id="480000";
        }else if(changwat.equals("���Թ���")){
            id="320000";
        }else if(changwat.equals("�شøҹ�")){
            id="410000";
        }else if(changwat.equals("ྪú�ó�")){
            id="670000";
        }else if(changwat.equals("ʡŹ��")){
            id="470000";
        }else if(changwat.equals("Phuket")){
            id="830000";
        }else if(changwat.equals("���")){
            id="420000";
        }else if(changwat.equals("�������")){
            id="330000";
//        }else if(changwat.equals("���������")){
//            
//        }else if(changwat.equals("���������")){
            
        }
        return id;
    }
    private Item getItem() {
        // set Item
//        theItem.item_id = Gutil.CheckReservedWords(jTextFieldCode.getText());
////        theItem.item_id = theItem.item_id.replace("'", "\\'");
//        theItem.common_name = Gutil.CheckReservedWords(jTextAreaCommonName.getText());
////        theItem.common_name = theItem.item_id.replace("'", "\\'");
//        theItem.nick_name = Gutil.CheckReservedWords(jTextAreaNickName.getText());
////        theItem.nick_name = theItem.nick_name.replace("\\\'", "\'");
////        theItem.nick_name = theItem.nick_name.replace("\'", "\\\'");
////        theItem.nick_name = theItem.item_id.replace("'", "\\'");
//        theItem.trade_name = Gutil.CheckReservedWords(jTextAreaTradeName.getText());
////        theItem.trade_name = theItem.trade_name.replace("\\", "");
////        theItem.trade_name = theItem.trade_name.replace("\'", "\\\'");
////        theItem.trade_name = theItem.item_id.replace("'", "\\'");
//        theItem.item_group_code_billing = ComboboxModel.getCodeComboBox(jComboBoxReceiptList);
//        theItem.item_group_code_category = ComboboxModel.getCodeComboBox(jComboBoxOrderList);
//        theItem.item_16_group = ComboboxModel.getCodeComboBox(jComboBoxStandardGroup);
//        theItem.setSecret(jCheckBoxSecret.isSelected());
//        theItem.setActive(jCheckBox1.isSelected());
//        theItem.unit_pack53 = jPanelDrugDescription.getUnitPack();
//        theItem.rp_lab_type = String.valueOf(jComboBoxLabRpGroup.getSelectedIndex() + 1);
//        theItem.specified = Gutil.getGuiData(jComboBoxSpecified);
        return theItem;
    }
    private ItemPrice getItemPrice() {
        //pu:25/08/2549 : ������㹡�úѹ�֡��ҹ�Ҥ� Item ���� ������� sort ��١��ͧ�͹�ʴ�㹵��ҧ
//        if (jTextFieldPrice.getText().equals("")) {
//            return null;
//        }
//        theItemPrice = new ItemPrice();
//        if (this.jCheckBoxPlan.isSelected()) {
//            theItemPrice.item_price_id = jComboBoxPlan.getText();
//        }
//
//        theItemPrice.active_date = dateTextField.getText() + "," + DateUtil.getTextCurrentTime(this.theHC.theConnectionInf);
//        theItemPrice.price = Constant.dicimalMoney(jTextFieldPrice.getText());
//        theItemPrice.price_cost = Constant.dicimalMoney(doubleTextFieldPriceCost.getText());
//
        return theItemPrice;
    }
    private void jButtonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenFileActionPerformed
        // TODO add your handling code here:
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = fileChooser.getSelectedFile();
//            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//        }
        String userDB="sa",passDB="Ekartc2c5", hostDB="DESKTOP-H18GJTN", portDB="", database="";
        String sql = "select * from GrpMst where GrpTrnDep = 'PHA' ";
        sql = "select * from SeeMst Where SeeTrnDep = 'PHA' ";
        userDB = txtUserDBS.getText();
        hostDB = txtHostDBS.getText();
        passDB = txtPassDBS.getText();
        portDB = txtPortDBS.getText();
        database = txtDatabaseS.getText();

        try {
            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
            Connection con = DriverManager.getConnection( "jdbc:sqlserver://"+hostDB+":"+portDB+";databasename="+database, userDB, passDB );
            //Connection con = DriverManager.getConnection( "jdbc:sqlserver://"+hostDB+";databasename="+database, userDB, passDB );
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            rs.last();
            jLabel14.setText(String.valueOf(rs.getRow()));
    //            rs.beforeFirst();
    //            while(rs.next()){
    //                cnt++;
    //            }
    //            jLabel14.setText(String.valueOf(cnt));
            rs.beforeFirst();
            while (rs.next()) {
                theItem = new Item();
                theItem.item_id = Gutil.CheckReservedWords(rs.getString("SeeOdrCod").trim());
    //        theItem.item_id = theItem.item_id.replace("'", "\\'");
                theItem.common_name = Gutil.CheckReservedWords(rs.getString("SeeKorNam").trim());
                theItem.nick_name = Gutil.CheckReservedWords(rs.getString("SeeEngNam").trim());
                theItem.trade_name = Gutil.CheckReservedWords(rs.getString("SeeEngNam").trim());
                theItem.item_group_code_billing = "";
                theItem.item_group_code_category = "";
                theItem.item_16_group = "";
                theItem.setSecret(false);
                theItem.setActive(true);
                theItem.unit_pack53 = "";
                theItem.rp_lab_type = "";
                theItem.specified = "";
                
                Statement stmtP = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                sql = "Select FeeAmt from FeeMst Where FeeLvl = 'O' and FeeAdpDte and FeeElcCod = '"+rs.getString("SeeOdrCod").trim();
                ResultSet rsP = stmt.executeQuery(sql);
                theItemPrice = new ItemPrice();
                theItemPrice.active_date = "2017-01-01," + DateUtil.getTextCurrentTime(this.theHC.theConnectionInf);
//                theItemPrice.price = Constant.dicimalMoney(jTextFieldPrice.getText());
//                theItemPrice.price_cost = Constant.dicimalMoney(doubleTextFieldPriceCost.getText());
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelConvertData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PanelConvertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        

//        int ret = theSetupControl.saveItem(getItem(), getItemPrice(), jPanelDrugDescription.getDrug(), getLabResultItem(), getLabGroup(), getLabSetV(), jRadioButtonLabGroup.isSelected(), getItemService());
    }//GEN-LAST:event_jButtonOpenFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConvert;
    private javax.swing.JButton jButtonOpenFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDatabaseD;
    private javax.swing.JTextField txtDatabaseS;
    private javax.swing.JTextField txtHostDBD;
    private javax.swing.JTextField txtHostDBS;
    private javax.swing.JTextField txtPassDBD;
    private javax.swing.JTextField txtPassDBS;
    private javax.swing.JTextField txtPortDBD;
    private javax.swing.JTextField txtPortDBS;
    private javax.swing.JTextField txtUserDBD;
    private javax.swing.JTextField txtUserDBS;
    // End of variables declaration//GEN-END:variables
}
