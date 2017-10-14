package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class PayerDB{    public ConnectionInf theConnectionInf;    public Payer dbObj;    final public String idtable = "209";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public PayerDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new Payer();        initConfig();    }    public PayerDB()    {        theConnectionInf=null;        dbObj = new Payer();        initConfig();    }    public boolean initConfig()    {        dbObj.table="b_contract_payer";        dbObj.pk_field="b_contract_payer_id";        dbObj.payer_id   ="contract_payer_number";        dbObj.description   ="contract_payer_description";        dbObj.active ="contract_payer_active";        /*        dbObj.table = "payer";        dbObj.pk_field = "key_id";        dbObj.payer_id = "payer_id";        dbObj.description = "description";        dbObj.active = "active";         */        return true;    }    /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(Payer o) throws Exception    {        Payer p=o;        if(p.getObjectId() == null)            p.generateOID(idtable);        StringBuffer sql = new StringBuffer("insert into " ).append( dbObj.table ).append( " ("        ).append( dbObj.pk_field        ).append( " ,"	).append( dbObj.payer_id        ).append( " ,"	).append( dbObj.description        ).append( " ,"	).append( dbObj.active        ).append( " ) values ('"        ).append( p.getObjectId()        ).append( "','" ).append( p.payer_id        ).append( "','" ).append( p.description        ).append( "','" ).append( p.active        ).append( "')");        return theConnectionInf.eUpdate(sql.toString());    }    public int update(Payer o) throws Exception    {        Payer p=o;        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "        ).append( dbObj.payer_id ).append( "='" ).append( p.payer_id        ).append( "', " ).append( dbObj.description ).append( "='" ).append( p.description        ).append( "', " ).append( dbObj.active ).append( "='" ).append( p.active        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");        return theConnectionInf.eUpdate(sql.toString());    }        public int delete(Payer o) throws Exception    {        StringBuffer sql = new StringBuffer("delete from " ).append( dbObj.table        ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( o.getObjectId() ).append("'");        return theConnectionInf.eUpdate(sql.toString());    }        public Payer selectByPK(String pk) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where " ).append( dbObj.pk_field        ).append( " = '" ).append( pk ).append( "'");        Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return (Payer)v.get(0);    }        public Payer selectByCode(String code) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where " ).append( dbObj.payer_id        ).append( " = '" ).append( code ).append( "'");        Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return (Payer)v.get(0);    }        public Vector selectAllByName(String pk,String active) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where ");        if(pk.trim().length() !=0)        {            sql.append("(" ).append(  dbObj.payer_id            ).append( " like '%" ).append( pk ).append( "%'" ).append( " or "            ).append( dbObj.description  ).append( " like '%" ).append( pk ).append( "%'" ).append( ") and ");        }                sql.append( dbObj.active ).append( " = '" ).append( active ).append( "'" ).append( " order by "        ).append( dbObj.payer_id);        Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return v;    }            public Vector selectAll() throws Exception    {        Vector vc = new Vector();        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table ).append( " order by ").append(        dbObj.description);        vc = veQuery(sql.toString());        if(vc.size()==0)            return null;        else            return vc;    }        /**     *@deprecated henbe unused     *     */    public Vector veQuery(String sql) throws Exception    {        ComboFix p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql.toString());        while(rs.next())        {            p = new ComboFix();            p.code = rs.getString(dbObj.pk_field);            p.name = rs.getString(dbObj.description);            list.add(p);        }        rs.close();        return list;    }        public Vector eQuery(String sql) throws Exception    {        Payer p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql.toString());        while(rs.next())        {            p = new Payer();            p.setObjectId(rs.getString(dbObj.pk_field));            p.payer_id = rs.getString(dbObj.payer_id);            p.description = rs.getString(dbObj.description);            p.active = rs.getString(dbObj.active);            list.add(p);        }        rs.close();        return list;    }    }