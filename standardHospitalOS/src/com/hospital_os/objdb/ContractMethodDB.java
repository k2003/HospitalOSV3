package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;/**����������� ��ź�͡����  Date: 30/08/47  By: tong*/public class ContractMethodDB{    public ConnectionInf theConnectionInf;    public ContractMethod dbObj;    final private String idtable = "136";        /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public ContractMethodDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new ContractMethod();        initConfig();    }    public ContractMethodDB()    {        theConnectionInf= null;        dbObj = new ContractMethod();        initConfig();    }    public boolean initConfig()    {        dbObj.table = "contract_method";        dbObj.id = "id";        dbObj.desctription = "description";        dbObj.refer_to = "refer_to";                return true;    }                public Vector selectAll() throws Exception    {   Vector vc = new Vector();        String sql ="select * from " + dbObj.table + " order by "+        dbObj.desctription;        vc = veQuery(sql);        if(vc.size()==0)            return null;        else            return vc;            }            /**     *@deprecated henbe unused     *     */        public Vector veQuery(String sql) throws Exception    {        ComboFix p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ComboFix();            p.code = rs.getString(dbObj.id);            p.name = rs.getString(dbObj.desctription);            list.add(p);        }        rs.close();        return list;    }            public Vector eQuery(String sql) throws Exception    {        ContractMethod p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ContractMethod();                        p.id = rs.getString(dbObj.id);            p.desctription = rs.getString(dbObj.desctription);            p.refer_to = rs.getString(dbObj.refer_to);                        list.add(p);        }        rs.close();        return list;    }    }