package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class ContractDB{    public ConnectionInf theConnectionInf;    public Contract dbObj;    final private String idtable = "135";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public ContractDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new Contract();        initConfig();    }    public ContractDB()    {        theConnectionInf=null;        dbObj = new Contract();        initConfig();    }    public boolean initConfig()    {        dbObj.table="b_contract";        dbObj.pk_field="b_contract_id";        dbObj.contract_id   ="contract_number";        dbObj.description   ="contract_description";        dbObj.method ="contract_method";        /*        dbObj.table = "contract";        dbObj.pk_field = "key_id";        dbObj.contract_id = "contract_id";        dbObj.description = "description";        dbObj.method = "method";         */        return true;    }    /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(Contract o) throws Exception    {        String sql="";        Contract p=o;        if(p.getObjectId() == null)            p.generateOID(idtable);        sql="insert into " + dbObj.table + " ("        + dbObj.pk_field        + " ,"	+ dbObj.contract_id        + " ,"	+ dbObj.description        + " ,"	+ dbObj.method                + " ) values ('"        + p.getObjectId()        + "','" + p.contract_id        + "','" + p.description        + "','" + p.method        + "')";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }        public int update(Contract o) throws Exception    {        String sql="update " + dbObj.table + " set ";        Contract p=o;        String field =""        + "', " + dbObj.description + "='" + p.description        + "' , " + dbObj.contract_id + "='" + o.contract_id        + "' where " + dbObj.pk_field + "='" + o.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }        public int delete(Contract o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.contract_id + "='" + o.contract_id +"'";                return theConnectionInf.eUpdate(sql);    }        public Contract selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.pk_field        + " = '" + pk + "'";                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (Contract)v.get(0);    }        public Vector selectByNameId(String search) throws Exception    {        Vector vc = new Vector();        String sql="select * from " + dbObj.table;        sql = sql+ " where ( " + dbObj.contract_id + " like '%" + search + "%')"            + " or (" + dbObj.description + " like '%" + search + "%') order by "            + dbObj.contract_id;                vc = eQuery(sql);        if(vc.size()==0)            return null;        else            return vc;    }            public Contract selectByCode(String code) throws Exception    {        Vector vc = new Vector();        String sql ="select * from " + dbObj.table        + " where " + dbObj.contract_id        + " = '"+ code +"'";        vc = eQuery(sql);        if(vc.size()==0)            return null;        else            return (Contract)vc.get(0);    }    public Vector selectAll() throws Exception    {           String sql ="select * from " + dbObj.table + " order by "+ dbObj.description;        return eQuery(sql);    }        public Vector eQuery(String sql) throws Exception    {        Contract p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new Contract();            p.setObjectId(rs.getString(dbObj.pk_field));            p.contract_id = rs.getString(dbObj.contract_id);            p.description = rs.getString(dbObj.description);            p.method = rs.getString(dbObj.method);            list.add(p);        }        rs.close();        return list;    }}