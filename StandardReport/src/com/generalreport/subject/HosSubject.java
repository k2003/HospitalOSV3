/*
 * HosSubject.java
 *
 * Created on 3 ���Ҥ� 2548, 18:33 �.
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.generalreport.subject;
/**
 *
 * @author tong(Padungrat)
 */
public class HosSubject {
    
    public ShowPanelSelectSubject theShowPanelSelectSubject;
    public GUISubject theGUISubject;
    public MainReportSubject theMainReportSubject;
    public AllPanelSubject theAllPanelSubject;
    public HosSubject() {
        theShowPanelSelectSubject = new ShowPanelSelectSubject();
        theGUISubject = new GUISubject();
        theMainReportSubject = new MainReportSubject();
        theAllPanelSubject = new AllPanelSubject();
    }
    
}