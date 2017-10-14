package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class Icd10GroupTypeDB{    public ConnectionInf theConnectionInf;    public Icd10GroupType dbObj;    final public String idtable = "171";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public Icd10GroupTypeDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new Icd10GroupType();        initConfig();    }    public boolean initConfig()    {        dbObj.table="b_icd10_group_type";        dbObj.pk_field="b_icd10_group_type_id";        dbObj.group_icd_name  ="icd10_group_type_name";        dbObj.description="icd10_group_type_description";        /*        dbObj.table = "icd10_group_type";        dbObj.pk_field = "key_id";        dbObj.group_icd_name = "group_icd_name";        dbObj.description="description";         **/                return true;    }            /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(Icd10GroupType o) throws Exception    {        String sql="";        Icd10GroupType p=o;        p.generateOID(idtable);        sql="insert into " + dbObj.table + " ("        + dbObj.pk_field        + " ,"	+ dbObj.group_icd_name        + " ,"  + dbObj.description        + " ) values ('"        + p.getObjectId()        + p.group_icd_name        + p.description        + "','" + p.description        + "')";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int update(Icd10GroupType o) throws Exception    {        String sql="update " + dbObj.table + " set ";        Icd10GroupType p=o;        String field =""        + "', " + dbObj.group_icd_name+ "='" + p.group_icd_name        + "', " + dbObj.description + "='" + p.description        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }        public int delete(WaterType o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";        return theConnectionInf.eUpdate(sql);    }        public WaterType selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.pk_field        + " = '" + pk + "'";                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (WaterType)v.get(0);    }        public Vector selectAll() throws Exception    {   Vector vc = new Vector();        String sql ="select * from " + dbObj.table + " order by "+        dbObj.group_icd_name;        vc = veQuery(sql);        if(vc.size()==0)            return null;        else            return vc;            }                /**     *@deprecated henbe unused     *     */    public Vector veQuery(String sql) throws Exception    {        ComboFix p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ComboFix();            p.code = rs.getString(dbObj.pk_field);            p.name = rs.getString(dbObj.group_icd_name);            list.add(p);        }        rs.close();        return list;    }        public Vector eQuery(String sql) throws Exception    {        Icd10GroupType p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new Icd10GroupType();            p.setObjectId(rs.getString(dbObj.pk_field));            p.group_icd_name = rs.getString(dbObj.group_icd_name);            p.description = rs.getString(dbObj.description);            list.add(p);        }        rs.close();        return list;    }    }