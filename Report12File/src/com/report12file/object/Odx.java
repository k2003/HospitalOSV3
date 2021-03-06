/*
 * Odx.java
 *
 * Created on 8 �ѹ��¹ 2548, 12:06 �.
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.report12file.object;
import com.linuxense.javadbf.DBFField;
import com.report12file.utility.Report12FileData;
import com.report12file.object.Rp12OI;
import com.reportcenter.utility.IOStream;
import com.reportcenter.utility.StringDate;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tong(Padungrat)
 */
public class Odx  implements Rp12OI{
    
    /** character width 9 */
    public String hn;
    /** date width 8 */
    public String datedx;
    /** character width 4 */
    public String clinic;
    /** character width 5 */
    public String diag;
    /** character width 1 */
    public String dxtype;
    /** character width 6 */
    public String drdx;
    public String pid;
    
    private int exp;

    public boolean add_digit;
    
    public Odx() {
    }
    public String[] getHeaderArray() {
        return new String[]{
            "hn",
            "datedx",
            "clinic",
            "diag",
            "dxtype",
            "drdx"
        };
    }
    public String[] getWarningArray() {
        return new String[]{
"�Ţ HCIS",
"�ѹ����ԹԨ����ä",
"���ʤ�Թԡ�������ԡ��",
"�ԹԨ����ä",
"��Դ�ͧ�ä",
"�Ţ���㺻�Сͺ�ԪҪվ"
        };
    }
    /**
     */
    public String[] getValueArray() {
        return new String[]{
            hn	,
            datedx	,
            clinic	,
            diag	,
            dxtype	,
            drdx
        };
    }
    
    ///////////////////////////////////////////////////////addcheckData
    public boolean checkDatadict(StringBuffer sb,int[] error) {
        BufferedReader in;
        Odx file = this;
        boolean ret = true;
        error[0]++;
        if(!Report12FileData.checkDataDict(	hn	,	9	,	true	)) { 	error[1	]++;    ret=false;}
        if(!Report12FileData.checkDataDict(	datedx	,	8	,	true	)) { 	error[2	]++;    ret=false;}
        if(!Report12FileData.checkDataDict(	clinic	,	4	,	true	)) { 	error[3	]++;    ret=false;}
        if(!Report12FileData.checkDataDict(	diag	,	5	,	true,false	)) { 	error[4	]++;    ret=false;}
        if(!Report12FileData.checkDataDict(	dxtype	,	1	,	true	)) { 	error[5	]++;    ret=false;}
        if(!Report12FileData.checkDataDict(	drdx	,	6	,	false	)) { 	error[6	]++;    ret=false;}
        if(!ret) {
            error[Report12FileData.MAX_COLUMN-1]++;
            if(error[Report12FileData.MAX_COLUMN-1]<Report12FileData.MAX_INCOMPLETE_ROW)
                sb.append("\r\n\t��¡�÷��Դ��Ҵ��� �Ţ HN:"+ file.hn + "  �ѹ���:"+datedx);
            if(add_digit)
                sb.append(" �ա�û�Ѻ��ѡ�ͧ HN/VN/AN");
        }
        return ret;
    }
    
    public boolean setValue(ResultSet rs) throws Exception {
        Odx p = this;
        p.	hn	 = Report12FileData.getRsString(rs,	1	);
        p.	datedx	 = Report12FileData.getRsString(rs,	2	);
        p.	clinic	 = Report12FileData.getRsString(rs,	3	);
        p.	diag	 = Report12FileData.getRsString(rs,	4	);
        p.	dxtype	 = Report12FileData.getRsString(rs,	5	);
        p.	drdx	 = Report12FileData.getRsString(rs,	6	);
        
        p.hn = Report12FileData.addDigit(p.hn,9); 
        if(Report12FileData.isAddDigit(p.hn,9) )
            add_digit = true;
        return true;
    }
    
    public Rp12OI initInstant() {
        return new Odx();
    }
    
    public PreparedStatement getPreparedStatement(Connection con, String startDate, String endDate, int mode) throws Exception {
        String sql = IOStream.readInputDefault("config/rp_12file/12file_odx.sql");
        PreparedStatement pm = con.prepareStatement(sql);
        pm.setString(1,startDate);
        pm.setString(2,endDate);
        return pm;
    }
    
    public String getFileName() {
        return "ODX";
    }
    
    
    public DBFField[] getDBFField() throws Exception {
        String[] header = getHeaderArray();
        DBFField[] fields = new DBFField[header.length];
        Report12FileData.initDBFField(0,header,fields,DBFField.FIELD_TYPE_C,9);
        Report12FileData.initDBFField(1,header,fields,DBFField.FIELD_TYPE_D,8);
        Report12FileData.initDBFField(2,header,fields,DBFField.FIELD_TYPE_C,4); 
        Report12FileData.initDBFField(3,header,fields,DBFField.FIELD_TYPE_C,5); 
        Report12FileData.initDBFField(4,header,fields,DBFField.FIELD_TYPE_C,1);
        Report12FileData.initDBFField(5,header,fields,DBFField.FIELD_TYPE_C,6);  
        
        
        return fields;
    }
    public Object[] getDBFValue() {
        Odx p = this;
        Object[] rowData;
        rowData = new Object[6];
        if(exp==1)
            rowData = new Object[7];
        
        rowData[0] = p.hn;
        // rowData[1] = p.datedx;
        if(!("").equals(p.datedx)){
            rowData[1] = StringDate.StringDateToDate(p.datedx);
        }else{
            rowData[1] = null;
        }
        rowData[2] = p.clinic;
        rowData[3] = p.diag;
        rowData[4] = p.dxtype;
        rowData[5] = p.drdx;
        return rowData;
    }
}
