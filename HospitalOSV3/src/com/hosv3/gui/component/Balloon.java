package com.hosv3.gui.component;import com.hosv3.utility.Constant;import java.awt.*;import javax.swing.*;public class Balloon extends JWindow {	//static final long serialVersionUID = 0;    JPanel jPanel1;    JFrame jf;    Component component;    BorderLayout borderLayout1 = new BorderLayout ();      /**    * @roseuid 3C328572015E    */    public Balloon(JFrame frame){                super(frame);            setJFrame(frame);        try{ Init();}        catch(Exception e){e.printStackTrace(Constant.getPrintStream());}    }    private void Init() throws Exception    {//        Constant.println("Init");        this.getContentPane().setLayout(borderLayout1);        jPanel1 = new javax.swing.JPanel();        jPanel1.setLayout(new java.awt.BorderLayout());                getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);          setBackground(java.awt.Color.WHITE);        jPanel1.setBackground(java.awt.Color.WHITE);//        setSize(400,200);        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();        Dimension frameSize = this.getSize();                if (frameSize.height > screenSize.height){            frameSize.height = screenSize.height;        }        if (frameSize.width > screenSize.width){            frameSize.width = screenSize.width;        }        setLocation((screenSize.width - frameSize.width) / 2            , (screenSize.height - frameSize.height) / 2);//        setVisible(true);        }        public JTable getTable()    {        JTable table = null;        if(component instanceof JPanel )        {           table = ((BalloonPanel) component).getTable();        }        return table;    }        public JFrame getJFrame()    {        return jf;    }        public void setJFrame(JFrame j)    {        this.jf = j;    }        public void setComponent(Component com)    {        if(com instanceof JPanel )        {            component = com;            jPanel1.add(com,java.awt.BorderLayout.CENTER);        }    }}