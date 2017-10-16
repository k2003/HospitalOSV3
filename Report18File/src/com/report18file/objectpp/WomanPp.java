package com.report18file.objectpp;

import com.linuxense.javadbf.DBFField;
import com.report18file.object.Woman;
import com.report18file.object.Rp18OI;
import com.report18file.utility.Report18FileData;
import java.io.BufferedReader;

import com.reportcenter.utility.IOStream;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
/*
 * AncNh.java
 *
 * Created on 11 �ѹ��¹ 2551, 15:17 �.
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author henbe
 */
public class WomanPp extends Woman implements Rp18OI{

    String person_name;
    /** Creates a new instance of AncNh */
    public WomanPp() {
    }
    public PreparedStatement getPreparedStatement(Connection con, String startDate, String endDate, int mode) throws Exception {
        
        String sql = IOStream.readInputDefault("config/rp_18file_pp/18file_pp_women.sql");
        PreparedStatement pm = con.prepareStatement(sql);
        pm.setString(1,startDate);
        pm.setString(2,endDate);
        return pm;
    }
    public boolean setValue(ResultSet rs) throws Exception {
        WomanPp p = this;
        p.pcucode = Report18FileData.getRsString(rs,1);
        p.pid = Report18FileData.getRsString(rs,2);
        p.fptype = Report18FileData.getRsString(rs,3);
        p.nofp = Report18FileData.getRsString(rs,4);
        p.numson = Report18FileData.getRsString(rs,5);
        p.update = Report18FileData.getRsString(rs,6);
        p.person_name = Report18FileData.getRsString(rs,7);
        return true;
    }
    public Rp18OI initInstant() {
        return new WomanPp();
    }
public String[] getValueArray() {
    return new String[]{
        pcucode	,
        pid	,
        fptype	,
        nofp	,
        numson	,
        update
    };
}
public String[] getHeaderArray() {
        return new String[]{

"pcucode",
"cid",
"fptype",
"nofp",
"numson",
"update"
};
    }

    public String[] getWarningArray() {
        return new String[]{
"ʶҹ��Һ��",
"�Ţ�ѵû�ЪҪ�",
"�Ըա�ä�����Դ�Ѩ�غѹ",
"���˵ط����������Դ",
"�ӹǹ�ص÷���ժ��Ե",
"�ѹ��͹�շ���Ѻ��ا"
        };
    }
    public DBFField[] getDBFField() throws Exception {
        String[] header = getHeaderArray();
        DBFField[] fields = new DBFField[header.length];
        Report18FileData.initDBFField(0,header,fields,DBFField.FIELD_TYPE_C,5);
        Report18FileData.initDBFField(1,header,fields,DBFField.FIELD_TYPE_C,13);
        Report18FileData.initDBFField(2,header,fields,DBFField.FIELD_TYPE_C,1);
        Report18FileData.initDBFField(3,header,fields,DBFField.FIELD_TYPE_C,1);
        Report18FileData.initDBFField(4,header,fields,DBFField.FIELD_TYPE_N,2);
        Report18FileData.initDBFField(5,header,fields,DBFField.FIELD_TYPE_C,8);
        return fields;
    }
    public Object[] getDBFValue() {
        Object[] rowData;
        Woman p = this;
        rowData = new Object[6];
        rowData[0] = p.pcucode;
        rowData[1] = p.pid;
        rowData[2] = p.fptype;
        rowData[3] = p.nofp;
        rowData[4] = Report18FileData.getDouble(p.numson);
        rowData[5] = p.update;
        return rowData;
    }
    public String getFileName() {
        return "WOMEN";
    }
    ///////////////////////////////////////////////////////addcheckData
    public boolean checkDatadict(StringBuffer sb,int[] error) 
    {
        BufferedReader in;
        WomanPp file = this;
        boolean ret = true;
        error[0]++;
        if(!Report18FileData.checkDataDict(	pcucode	,	5	,	true	)) { 	error[1	]++;    ret=false;}
        if(!Report18FileData.checkDataDict(	pid	,	13	,	true	)) { 	error[2	]++;    ret=false;}
        if(!Report18FileData.checkDataDict(	fptype	,	1	,	true,true,Report18FileData.VALID_07	)) { 	error[3	]++;    ret=false;}
        if(!Report18FileData.checkDataDict(	nofp	,	1	,	false,true,Report18FileData.VALID_13	)) { 	error[4	]++;    ret=false;}
        if(!Report18FileData.checkDataDict(	numson	,	2	,	false	)) { 	error[5	]++;    ret=false;}
        if(!Report18FileData.checkDataDict(	update	,	8	,	true	)) { 	error[6	]++;    ret=false;}
        
        if(!ret) {
            error[Report18FileData.MAX_COLUMN-1]++;
            if(error[Report18FileData.MAX_COLUMN-1]<Report18FileData.MAX_INCOMPLETE_ROW)
                sb.append("\n\t��¡�÷��Դ��Ҵ��� ��Ъҡê���:"+ file.person_name);
        }
         return ret;
    }
    
}