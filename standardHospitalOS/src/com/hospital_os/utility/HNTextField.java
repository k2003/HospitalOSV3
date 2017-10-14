package com.hospital_os.utility;import java.awt.event.*;import javax.swing.*;import java.text.*;import javax.swing.text.*;/** * <p>Title: GUI HospitalOS EE</p> * <p>Description: ???? GUI ?? HospitalOS Enterprise Edition</p> * <p>Copyright: Copyright (c) 2003</p> * <p>Company: Open Source Technology</p> * @author neng, Surachai Thowong * @version 1.0 */public class HNTextField extends JTextField implements KeyListener, ActionListener{  /** ?????????�??????? */    int columns = 9;   //int columns = 5;  /** ????h????? */  NumberFormat digit9Format = NumberFormat.getInstance();  public HNTextField()  {    setDocument(new DocumentHN());    addKeyListener(this);    addActionListener(this);    digit9Format.setMaximumIntegerDigits(columns);    digit9Format.setMinimumIntegerDigits(columns);  }  /** ???�????????? HN ??????????? ????? 9 ??? */  protected class DocumentHN extends PlainDocument  {    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException    {     if(str!=null)     {      char[] source = str.toCharArray();      char[] result = new char[source.length];      int j = 0;            for(int i = 0; i < result.length; i++)      {        if(Character.isDigit(source[i]))        {          result[j++] = source[i];          /*          if(offs==0)          {            space = "-";            //Constant.println("-");          }          else if(offs==5)          {            space = "-";            //Constant.println("-");          }          else if(offs==11)          {            space = "-";            //Constant.println("-");          }          else if(offs==14)          {            space = "-";            //Constant.println("-");          }          */        }        else        {                  }      }           if(offs<columns)        super.insertString(offs, new String(result, 0, j), a);      else                    ;     }    }    public void remove(int offs, int len) throws BadLocationException    {      super.remove(offs, len);    }  }  public void keyReleased(KeyEvent e)  {  }  public void keyPressed(KeyEvent e)  {  }  public void keyTyped(KeyEvent e)  {  }  public void actionPerformed(ActionEvent e)  {    format();  }  public void format()  {//    try//    {//      super.setText(digit9Format.format(Integer.parseInt(super.getText())));//    }//    catch(Exception ex)//    {//    //      reset();//    }  }  /** Override ????? ???????????? */  public void setText(String text)  {    super.setText(text);    //format();  }  public String getText()  {    format();    return super.getText();  }  public void reset()  {    super.setText("");  }  public static void main(String[] args)  {    HNTextField txt = new HNTextField();    JFrame frm = new JFrame("Test HNTextField");    frm.getContentPane().add(txt);    txt.setSize(100, 21);    frm.pack();    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    frm.setVisible(true);  }}