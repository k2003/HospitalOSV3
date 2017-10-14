package com.hospital_os.objdb;/** *  tong */import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class MapQueueVisitDB{    public ConnectionInf theConnectionInf;    public MapQueueVisit dbObj;    final public String idtable = "182";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public MapQueueVisitDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new MapQueueVisit();        initConfig();    }    public MapQueueVisitDB()    {        theConnectionInf=null;        dbObj = new MapQueueVisit();        initConfig();    }    public boolean initConfig()    {        dbObj.table="t_visit_queue_map";        dbObj.pk_field="t_visit_queue_map_id";        dbObj.visit_id  ="t_visit_id";        dbObj.queue   ="visit_queue_map_queue";        dbObj.queue_visit   ="b_visit_queue_setup_id";        dbObj.active ="visit_queue_map_active";        /*        this.dbObj.table = "map_queue_visit";        dbObj.pk_field = "map_queue_visit_id";        dbObj.visit_id = "visit_id";        dbObj.queue_visit = "queue_visit";        dbObj.queue = "queue";        dbObj.active = "active";         */                return true;    }    public int insert(MapQueueVisit o) throws Exception    {        String sql="";        MapQueueVisit p=o;        p.generateOID(idtable);        sql="insert into " + dbObj.table + " ("        + dbObj.pk_field        + " ,"	+ dbObj.visit_id        + " ,"	+ dbObj.queue_visit        + " ,"	+ dbObj.queue        + " ,"	+ dbObj.active                + " ) values ('"        + p.getObjectId()        + "','" + p.visit_id        + "','" + p.queue_visit        + "','" + p.queue        + "','" + p.active        + "')";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int update(MapQueueVisit o) throws Exception    {        String sql="update " + dbObj.table + " set ";        MapQueueVisit p=o;        String field =""        + "', " + dbObj.visit_id + "='" + p.visit_id        + "', " + dbObj.queue_visit + "='" + p.queue        + "', " + dbObj.queue + "='" + p.queue        + "', " + dbObj.active + "='" + p.active        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());                return theConnectionInf.eUpdate(sql);    }        public int delete(MapQueueVisit o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";        return theConnectionInf.eUpdate(sql);    }        public MapQueueVisit selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.pk_field        + " = '" + pk + "'";                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (MapQueueVisit)v.get(0);    }        public Vector selectAll() throws Exception    {        String sql="select * from " + dbObj.table;                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return v;    }        public MapQueueVisit selectByVisitID(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.visit_id        + " = '" + pk + "' and " + dbObj.active + " = '1' ";        Constant.println(sql);        Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (MapQueueVisit)v.get(0);    }        public Vector eQuery(String sql) throws Exception    {        MapQueueVisit p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new MapQueueVisit();            p.setObjectId(rs.getString(dbObj.pk_field));            p.visit_id = rs.getString(dbObj.visit_id);            p.queue_visit = rs.getString(dbObj.queue_visit);            p.queue = rs.getString(dbObj.queue);            p.active = rs.getString(dbObj.active);            list.add(p);        }        rs.close();        return list;    }    }