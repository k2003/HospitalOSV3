package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class ComCharacDB{    public ConnectionInf theConnectionInf;    public ComCharac dbObj;    final private String idtable = "132";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public ComCharacDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new ComCharac();        initConfig();    }    public boolean initConfig()    {        dbObj.table="f_health_home_community_charac";        dbObj.pk_field="f_health_home_community_charac_id";        dbObj.description ="health_home_community_charac_description";        /*        dbObj.table = "com_charac";        dbObj.pk_field = "com_charac_id";        dbObj.description = "description";         */        return true;    }            /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(ComCharac o) throws Exception    {        String sql="";        ComCharac p=o;        p.generateOID(idtable);        sql="insert into " + dbObj.table + " ("        + dbObj.pk_field        + " ,"	+ dbObj.description        + " ) values ('"        + p.getObjectId()        + "','" + p.description        + "')";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int update(ComCharac o) throws Exception    {        String sql="update " + dbObj.table + " set ";        ComCharac p=o;        String field =""        + "', " + dbObj.description + "='" + p.description        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }        public int delete(ComCharac o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";        return theConnectionInf.eUpdate(sql);    }        public ComCharac selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.pk_field        + " = '" + pk + "'";                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (ComCharac)v.get(0);    }        public Vector selectAll() throws Exception    {   Vector vc = new Vector();        String sql ="select * from " + dbObj.table + " order by "+        dbObj.description;        vc = veQuery(sql);        if(vc.size()==0)            return null;        else            return vc;            }                public Vector veQuery(String sql) throws Exception    {        ComboFix p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ComboFix();            p.code = rs.getString(dbObj.pk_field);            p.name = rs.getString(dbObj.description);            list.add(p);        }        rs.close();        return list;    }        public Vector eQuery(String sql) throws Exception    {        ComCharac p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ComCharac();            p.setObjectId(rs.getString(dbObj.pk_field));            p.description = rs.getString(dbObj.description);            list.add(p);        }        rs.close();        return list;    }    }