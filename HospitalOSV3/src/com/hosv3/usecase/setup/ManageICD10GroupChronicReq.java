/*
 * ManageMapICD10Req.java
 *
 * Created on 9 �ѹ��¹ 2551, 15:33 �.
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.hosv3.usecase.setup;

/**
 *
 * @author iPu
 */
public interface ManageICD10GroupChronicReq
{
    public void notifySetTableICD10GCGroup(String str, int status);
    public void notifySetTableICD10GCSpecifyCode(String str, int status);
}
