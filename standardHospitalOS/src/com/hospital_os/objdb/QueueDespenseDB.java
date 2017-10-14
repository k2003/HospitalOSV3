/* * QueueDespenseDB.java * * Created on 27 ���Ҥ� 2546, 22:54 �. */package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;/** * * @author  Administrator */public class QueueDespenseDB{        public ConnectionInf theConnectionInf;    public QueueDespense dbObj;    final public String idtable = "219";    /** Creates a new instance of QueueDespenseDB */    public QueueDespenseDB(ConnectionInf db)    {        theConnectionInf = db;        dbObj = new QueueDespense();        initConfig();    }    public boolean initConfig()    {        dbObj.table="t_visit_queue_despense";        dbObj.pk_field="t_visit_queue_despense_id";        dbObj.visit_id   ="t_visit_id";        dbObj.number_order   ="visit_queue_despense_number_order";        dbObj.last_service   ="b_service_point_id";        dbObj.assign_time   ="assign_date_time";        dbObj.patient_id   ="t_patient_id";        dbObj.active="visit_queue_despense_active";        /*        this.dbObj.table = "queue_despense";        this.dbObj.pk_field = "queue_despense_id";                 this.dbObj.visit_id = "visit_id";        this.dbObj.number_order = "number_order";        this.dbObj.last_service = "last_service";        this.dbObj.assign_time = "assign_time";        this.dbObj.patient_id = "patient_id";        this.dbObj.active = "active";         */        return true;    }        public int insert(QueueDespense o) throws Exception    {        QueueDespense p=o;        p.generateOID(idtable);        StringBuffer sql = new StringBuffer("insert into " ).append( dbObj.table ).append( " ("        ).append( dbObj.pk_field  ).append( " ,"        ).append( dbObj.visit_id ).append( " ,"        ).append( dbObj.number_order ).append( " ,"        ).append( dbObj.last_service ).append( " ,"        ).append( dbObj.assign_time  ).append( " ,"        ).append( dbObj.active  ).append( " ,"        ).append( dbObj.patient_id  ).append( " "                        ).append( " ) values ('"        ).append( p.getObjectId() ).append( "','"        ).append( p.visit_id ).append( "' ,'"        ).append( p.number_order ).append( "' ,'"        ).append( p.last_service ).append( "' ,'"        ).append( p.assign_time  ).append( "' ,'"        ).append( p.active  ).append( "' ,'"                ).append( p.patient_id        ).append( "')");        return theConnectionInf.eUpdate(sql.toString());    }    public int updateByVisitID(String visit_id ) throws Exception    {        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "        ).append( dbObj.active ).append( " = '1' "        ).append( " where " ).append( dbObj.visit_id ).append( " ='" ).append(visit_id ).append( "'");                return theConnectionInf.eUpdate(sql.toString());    }        public int updateDespenseToZero(String visit_id ) throws Exception    {        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "        ).append( dbObj.active ).append( " = '0' "        ).append( " where " ).append( dbObj.visit_id ).append( " ='" ).append(visit_id ).append( "'");        return theConnectionInf.eUpdate(sql.toString());    }            public int update(QueueDespense o) throws Exception    {        QueueDespense p=o;                StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "        ).append( dbObj.visit_id ).append( "='" ).append( p.visit_id ).append( "', "        ).append( dbObj.number_order ).append( "='" ).append( p.number_order ).append( "', "        ).append( dbObj.last_service ).append( "='" ).append( p.last_service ).append( "', "        ).append( dbObj.assign_time  ).append( "='" ).append( p.assign_time ).append( "', "        ).append( dbObj.active  ).append( "='" ).append( p.active ).append( "', "        ).append( dbObj.patient_id  ).append( "='" ).append( p.patient_id ).append( "' "                ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");         return theConnectionInf.eUpdate(sql.toString());    }        public int delete(QueueDespense o) throws Exception    {        StringBuffer sql = new StringBuffer("delete from " ).append( dbObj.table        ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( o.getObjectId() ).append("'");                return theConnectionInf.eUpdate(sql.toString());    }        public int deleteByVisitID(String visit_id) throws Exception    {        StringBuffer sql = new StringBuffer("delete from " ).append( dbObj.table        ).append( " where " ).append( dbObj.visit_id ).append( "='" ).append( visit_id ).append("'");        return theConnectionInf.eUpdate(sql.toString());    }        public QueueDespense selectByPK(String pk) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where " ).append( dbObj.pk_field        ).append( " = '" ).append( pk ).append( "'");                Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return (QueueDespense)v.get(0);    }        public QueueDespense selectByVisitID(String pk) throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where " ).append( dbObj.visit_id        ).append( " = '" ).append( pk ).append( "'");                Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return (QueueDespense)v.get(0);    }        public Vector selectAll() throws Exception    {        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table        ).append( " where " ).append( dbObj.active ).append( " = '1'");                Vector v=eQuery(sql.toString());        if(v.size()==0)            return null;        else            return v;    }        public Vector eQuery(String sql) throws Exception    {        QueueDespense p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql.toString());        while(rs.next())        {            p = new QueueDespense();            p.setObjectId(rs.getString(dbObj.pk_field));            p.visit_id = rs.getString(dbObj.visit_id);            p.number_order = rs.getString(dbObj.number_order);            p.last_service = rs.getString(dbObj.last_service);            p.assign_time = rs.getString(dbObj.assign_time);            p.patient_id = rs.getString(dbObj.patient_id);            p.active = rs.getString(dbObj.active);            list.add(p);        }        rs.close();        return list;    }        /**     *@deprecated henbe unused     *     */    public Vector veQuery(String sql) throws Exception    {        ComboFix p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql.toString());        while(rs.next())        {            p = new ComboFix();            p.code = rs.getString(dbObj.pk_field);            p.name = rs.getString(dbObj.visit_id);            list.add(p);        }        rs.close();        return list;    }    }