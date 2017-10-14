/*
 * showHelpEMR.java
 *
 * Created on 4 �ѹ��¹ 2548, 13:08 �.
 */
package com.reportcenter.help;

import java.net.*;
import javax.help.*;
/**
 *
 * @author  tong(Padungrat)
 */
public class ShowHelpReportCenter {
    
    /** Creates a new instance of showHelpEMR */
    javax.swing.JMenuItem jMenuItem1;
    static final String file = "com/reportcenter/help/Config";
    
    final HelpSet  hs = getHelpSet(java.util.ResourceBundle.getBundle(file).getString("filemap"));//("helpemr/Sample.hs");
    HelpBroker hb;
    public ShowHelpReportCenter() {
        
         hb = hs.createHelpBroker();

         // 2. assign help to components
         
    }
    
    public void addID(javax.swing.JMenuItem MenuItem )
    {   jMenuItem1 = MenuItem;
        CSH.setHelpIDString(MenuItem, "top");
        MenuItem.addActionListener(new CSH.DisplayHelpFromSource(hb));
    }
      /**
    * find the helpset file and create a HelpSet object
    */
   public HelpSet getHelpSet(String helpsetfile) {
      HelpSet hs = null;
   
      ClassLoader cl = this.getClass().getClassLoader();
      try {
        URL hsURL = HelpSet.findHelpSet(cl, helpsetfile);
        hs = new HelpSet(null, hsURL);
      } catch(Exception ee) {
        System.out.println("HelpSet: "+ee.getMessage());
        System.out.println("HelpSet: "+ helpsetfile + " not found");
      }
      return hs;
   }
}
