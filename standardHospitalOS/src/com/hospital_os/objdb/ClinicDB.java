package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class ClinicDB{    public ConnectionInf theConnectionInf;    public Clinic dbObj;    final private String idtable = "131";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public ClinicDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new Clinic();        initConfig();    }    public ClinicDB()    {        theConnectionInf= null;        dbObj = new Clinic();        initConfig();    }    public boolean initConfig()    {        dbObj.table="b_visit_clinic";        dbObj.pk_field="b_visit_clinic_id";        dbObj.clinic_id   ="visit_clinic_number";        dbObj.name   ="visit_clinic_description";        dbObj.service_type="f_service_group_id";        dbObj.active ="visit_clinic_active";        /*        dbObj.table = "clinic";        dbObj.pk_field = "key_id";        dbObj.clinic_id = "clinic_id";        dbObj.name = "name";        dbObj.service_type = "service_type";        dbObj.active = "active";         */        return true;    }    /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(Clinic o) throws Exception    {        Clinic p=o;        p.generateOID(idtable);        StringBuffer sql = new StringBuffer("insert into " ).append( dbObj.table ).append( " ("        ).append( dbObj.pk_field        ).append( " ,"	).append( dbObj.clinic_id        ).append( " ,"	).append( dbObj.name        ).append( " ,"	).append( dbObj.service_type        ).append( " ,"	).append( dbObj.active        ).append( " ) values ('"        ).append( p.getObjectId()        ).append( "','" ).append( p.clinic_id        ).append( "','" ).append( p.name        ).append( "','" ).append( "7"        ).append( "','" ).append( p.active        ).append( "')");                return theConnectionInf.eUpdate(sql.toString());    }        public int update(Clinic o) throws Exception    {        Clinic p=o;        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "        ).append( dbObj.clinic_id ).append( "='" ).append( p.clinic_id        ).append( "', " ).append( dbObj.name ).append( "='" ).append( p.name        ).append( "', " ).append( dbObj.service_type ).append( "='" ).append( p.service_type        ).append( "', " ).append( dbObj.active ).append( "='" ).append( p.active        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");        return theConnectionInf.eUpdate(sql.toString());    }        public int delete(Clinic o) throws Exception    {        StringBuffer sql = new StringBuffer("delete from " ).append( dbObj.table        ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( o.getObjectId() ).append("'");        return theConnectionInf.eUpdate(sql.toString());    }        public Clinic selectByPK(String pk) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where " ).append( dbObj.pk_field        ).append( " = '" ).append( pk ).append( "'");        Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return (Clinic)v.get(0);    }        public Clinic selectByCode(String code) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where " ).append( dbObj.clinic_id        ).append( " = '" ).append( code ).append( "'");        Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return (Clinic)v.get(0);    }        public Vector selectAllByName(String pk,String active) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where ");        if(pk.trim().length() !=0)        {            sql.append("(" ).append(  dbObj.clinic_id            ).append( " like '%" ).append( pk ).append( "%'" ).append( " or "            ).append( dbObj.name ).append( " like '%" ).append( pk ).append( "%'" ).append( ") and ");        }                sql.append( dbObj.active ).append( " = '" ).append( active ).append( "'" ).append( "order by "        ).append( dbObj.clinic_id);                Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return v;    }            public Vector selectAll() throws Exception    {   Vector vc = new Vector();        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table ).append( " Where " ).append( dbObj.active ).append( "='" ).append( Active.isEnable() ).append( "'" );//        vc = veQuery(sql.toString());//        if(vc.size()==0)//            return null;//        else//            return vc;        vc=eQuery(sql.toString());        if(vc.size()==0)            return null;        else            return vc;    }        /**     *@deprecated henbe unused     *     */    public Vector veQuery(String sql) throws Exception    {        ComboFix p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql.toString());        while(rs.next())        {            p = new ComboFix();            p.code = rs.getString(dbObj.pk_field);            p.name = rs.getString(dbObj.name);            list.add(p);        }        rs.close();        return list;    }        public Vector eQuery(String sql) throws Exception    {        Clinic p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql.toString());        while(rs.next())        {            p = new Clinic();            p.setObjectId(rs.getString(dbObj.pk_field));            p.clinic_id = rs.getString(dbObj.clinic_id);            p.name = rs.getString(dbObj.name);            p.service_type = rs.getString(dbObj.service_type);            p.active = rs.getString(dbObj.active);            list.add(p);        }        rs.close();        return list;    }    }