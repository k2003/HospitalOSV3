/*
 * Balloon2.java
 *
 * Created on 25 ����¹ 2551, 0:03 �.
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.hosv3.gui.component;

import com.hospital_os.usecase.connection.*;
import com.hospital_os.utility.TaBleModel;
import com.hosv3.utility.connection.ExecuteControlInf;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;
import java.util.Vector;
import com.hosv3.utility.Constant;
import javax.swing.JWindow;
import javax.swing.text.JTextComponent;


/**
 *
 * @author henbe
 */
public class Balloon3  extends JWindow 
    {
            //static final long serialVersionUID = 0;
        private javax.swing.JScrollPane jScrollPane1;
        protected com.hosv3.gui.component.HJTableSort jTable1;
        Vector vDataList;
        String after_select = "";
        String before_select = "";
        int search_index;
        JTextComponent component;
        ExecuteControlInf theEC;
        String[] title = {""};

        private long firstClickTime;

        private boolean is_table_select;
       /**
        * @roseuid 3C328572015E
        */
        public Balloon3(JFrame frame){

            super(frame);
            try{ Init();}
            catch(Exception e){e.printStackTrace(Constant.getPrintStream());}
            this.initComponents();
            setSize(300,100);
        }
        
        private void Init() throws Exception
        {
            setBackground(java.awt.Color.WHITE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = this.getSize();

            if (frameSize.height > screenSize.height){
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width){
                frameSize.width = screenSize.width;
            }
            setLocation((screenSize.width - frameSize.width) / 2
                , (screenSize.height - frameSize.height) / 2);
        }

        void setControl(ExecuteControlInf theEC, String before_select, String after_select
                , boolean checkrepeate,JTextComponent com) 
        {
            this.theEC = theEC;
            this.after_select = after_select;
            this.before_select = before_select;
            component = com;
            setBalloonLocation(component.getLocationOnScreen());
        }
        void setTable(Vector itemSearch,int index) {
            search_index = index;
            setTable(itemSearch);
        }

        /** This method is called from within the constructor to
         * initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
        private void initComponents() {
            jScrollPane1 = new javax.swing.JScrollPane();
            jTable1 = new com.hosv3.gui.component.HJTableSort();
            jScrollPane1.setBorder(null);
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {}
            ));
            jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTable1KeyReleased(evt);
                }
            });
            jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    jTable1FocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    jTable1FocusLost(evt);
                }
            });
            jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jTable1MouseReleased(evt);
                }
            });
            jScrollPane1.setViewportView(jTable1);
            getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        }// </editor-fold>                        
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt)
    {
        try{
            long clickTime = System.currentTimeMillis();
            long clickInterval = clickTime - firstClickTime;
            if(clickInterval < 400)
            {
                int select = jTable1.getSelectedRow();
                selectItem(select);
            }
            else
            {
              firstClickTime = clickTime;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace(Constant.getPrintStream());
        }
    }
    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {
        Constant.println("focus table gain");
        this.is_table_select = true;
    }  
    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {
        Constant.println("focus table lost");
        this.is_table_select = false;
    }
        private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {                                    
           if(evt.getKeyCode() == KeyEvent.VK_ENTER){
               Constant.println("if(evt.getKeyCode() == KeyEvent.VK_ENTER){");
               if(jTable1.getSelectedRow() == -1)
                   jTable1.setRowSelectionInterval(jTable1.getRowCount()-1, jTable1.getRowCount()-1);
               else
                   jTable1.setRowSelectionInterval(jTable1.getSelectedRow()-1, jTable1.getSelectedRow()-1);
                int select = jTable1.getSelectedRow();
                selectItem(select);
                Constant.println("this.component.requestFocus();");
                this.component.requestFocus();
            }
            else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
               Constant.println("else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){");
                dispose();
                Constant.println("this.component.requestFocus();");
                this.component.requestFocus();
            }
        }
        public void setTable(Vector v){
            this.vDataList = v;
            TaBleModel tm;
            int vsize = 0;
            if(v != null)
                vsize = v.size();
            if(v == null || vsize == 0){
                tm = new TaBleModel(title,vsize);
            }
            else{
                tm = new TaBleModel(title,vsize);
                for(int i=0;i<vsize;i++){
                    tm.setValueAt(((CommonInf)v.get(i)).getName(),i,0);
                }
            }
            jTable1.setModel(tm);
        }
        private void setBalloonLocation(Point p){        
            int x = p.x;
            int y = (p.y) - (getBounds().height);
            int bwidth = x + getBounds().width;
            int framewidth = getBounds().x + getBounds().width;
            if(bwidth > framewidth ){
                int sub = bwidth - framewidth;
                x = x - sub;
                setLocation(x, y);
            }
            else{
                setLocation(x, y);
            }

        }
        public void requestFocus(){
            jTable1.setRowSelectionInterval(0,0);
            jTable1.requestFocus();
        }
        private void selectItem(int select)
        {
            Constant.println("private void selectItem(int select)");
            String str = component.getText().substring(0,search_index);
            String value = (String) jTable1.getValueAt(select, 0);
            component.setText(str + before_select + value + after_select);

            if(theEC!=null)
                theEC.execute(vDataList.get(select));

            dispose();
        }
    }    