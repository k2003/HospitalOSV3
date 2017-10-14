package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;//////////////////////////////////////////////////////////////////////////////////////////////public class RuleDB{    public ConnectionInf theConnectionInf;    public Rule dbObj;    final public String idtable = "236";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public RuleDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new Rule();        initConfig();    }    public boolean initConfig()    {        dbObj.table="f_employee_rule";        dbObj.pk_field="f_employee_rule_id";        dbObj.description="employee_rule_description";        /*        dbObj.table = "rule";        dbObj.pk_field = "rule_id";        dbObj.description = "description";         */        return true;    }            /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(Rule o) throws Exception    {        String sql="";        Rule p=o;        p.generateOID(idtable);        sql="insert into " + dbObj.table + " ("        + dbObj.pk_field        + " ,"	+ dbObj.description        + " ) values ('"        + p.getObjectId()        + "','" + p.description        + "')";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int update(Rule o) throws Exception    {        String sql="update " + dbObj.table + " set ";        Rule p=o;        String field =""        + "', " + dbObj.description + "='" + p.description        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }        public int delete(Rule o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";        return theConnectionInf.eUpdate(sql);    }        public Rule selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.pk_field        + " = '" + pk + "'";                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (Rule)v.get(0);    }        public Vector selectAll() throws Exception    {   Vector vc = new Vector();        String sql ="select * from " + dbObj.table + " order by "+        dbObj.description;        vc = veQuery(sql);        if(vc.size()==0)            return null;        else            return vc;            }                public Vector veQuery(String sql) throws Exception    {        ComboFix p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ComboFix();            p.code = rs.getString(dbObj.pk_field);            p.name = rs.getString(dbObj.description);            list.add(p);        }        rs.close();        return list;    }            public Vector eQuery(String sql) throws Exception    {        Rule p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new Rule();            p.setObjectId(rs.getString(dbObj.pk_field));            p.description = rs.getString(dbObj.description);            list.add(p);        }        rs.close();        return list;    }    }