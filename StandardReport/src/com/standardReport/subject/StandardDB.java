/*
 * StandardDB.java
 *
 * Created on 3 �Զع�¹ 2548, 15:51 �.
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.standardReport.subject;

/**
 *
 * @author Administrator
 */
public interface StandardDB {
    
    /** Creates a new instance of StandardDB */
    public Object selectByKeyID(String key_id);
    public int deleteByKeyID(String key_id);
    public int updateByKeyID(String key_id);
    public int insertData(Object object);
    
}