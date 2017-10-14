package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;/** * * @deprecated henbe �� AfterMchMother ᷹ */public class AfterMchDB{    public ConnectionInf theConnectionInf;    public AfterMch dbObj;    final private String idtable = "106";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public AfterMchDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new AfterMch();        initConfig();    }    public boolean initConfig()    {        this.dbObj.table = "t_health_postpartum";        this.dbObj.pk_field = "t_health_postpartum_id";                this.dbObj.visit_id = "t_visit_id";        this.dbObj.patient_id = "t_patient_id";        this.dbObj.update = "record_date_time";        this.dbObj.note = "health_postpartum_notice";        this.dbObj.active = "health_postpartum_active";        this.dbObj.user_record = "health_postpartum_staff_record";        this.dbObj.user_modify = "health_postpartum_staff_modify";        this.dbObj.user_cancel = "health_postpartum_staff_cancel";        this.dbObj.uterus_level = "health_postpartum_fundus_height";        this.dbObj.milk_seep  = "health_postpartum_lactation";        this.dbObj.sugar_level  = "health_postpartum_sugar_level";        this.dbObj.lochia  = "health_postpartum_lochia";        this.dbObj.menses  = "health_postpartum_menstruation";        this.dbObj.sew   = "health_postpartum_episiotomy";        this.dbObj.cream  = "health_postpartum_nipple";        this.dbObj.albumin  = "health_postpartum_albumin";        this.dbObj.result_verify  = "health_postpartum_summary_verify";        this.dbObj.pcare   = "health_postpartum_visit";        this.dbObj.mch_id   = "t_health_delivery_id";        this.dbObj.asphyxia  = "health_postpartum_asphyxia";        this.dbObj.vit_k   = "health_postpartum_vit_k";        this.dbObj.bcres   = "health_postpartum_bcres";       /*       this.dbObj.table = "after_mch";       this.dbObj.pk_field = "after_mch_id";                this.dbObj.visit_id = "visit_id";        this.dbObj.patient_id = "patient_id";        this.dbObj.update = "update_time";        this.dbObj.note = "note";        this.dbObj.active = "active";        this.dbObj.user_record = "user_record";        this.dbObj.user_modify = "user_modify";        this.dbObj.user_cancel = "user_cancel";        this.dbObj.uterus_level = "uterus_level";        this.dbObj.milk_seep  = "milk_seep";        this.dbObj.sugar_level  = "sugar_level";        this.dbObj.lochia  = "lochia";        this.dbObj.menses  = "menses";        this.dbObj.sew   = "sew";        this.dbObj.cream  = "cream";        this.dbObj.albumin  = "albumin";        this.dbObj.result_verify  = "result_verify";        this.dbObj.pcare   = "pcare";        this.dbObj.mch_id   = "mch_id";        */        return true;    }    /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(AfterMch o) throws Exception    {        String sql="";        AfterMch p=o;        p.generateOID(idtable);        sql="insert into " + dbObj.table + " ("        + dbObj.pk_field                        + " ,"	+ dbObj.visit_id        + " ,"	+ dbObj.patient_id        + " ,"	+ dbObj.update        + " ,"	+ dbObj.note        + " ,"	+ dbObj.active        + " ,"	+ dbObj.user_record        + " ,"	+ dbObj.user_modify        + " ,"	+ dbObj.user_cancel        + " ,"	+ dbObj.uterus_level        + " ,"	+ dbObj.milk_seep        + " ,"	+ dbObj.sugar_level        + " ,"	+ dbObj.lochia        + " ,"	+ dbObj.menses        + " ,"	+ dbObj.sew        + " ,"	+ dbObj.cream        + " ,"	+ dbObj.albumin        + " ,"	+ dbObj.result_verify        + " ,"	+ dbObj.pcare        + " ,"	+ dbObj.mch_id        + " ,"	+ dbObj.asphyxia        + " ,"	+ dbObj.vit_k        + " ,"	+ dbObj.bcres        + " ) values ('"        + p.getObjectId()                + "','" + p.visit_id        + "','" + p.patient_id        + "','" + p.update        + "','" + p.note        + "','" + p.active        + "','" + p.user_record        + "','" + p.user_modify        + "','" + p.user_cancel        + "','" + p.uterus_level        + "','" + p.milk_seep        + "','" + p.sugar_level        + "','" + p.lochia        + "','" + p.menses        + "','" + p.sew        + "','" + p.cream        + "','" + p.albumin        + "','" + p.result_verify        + "','" + p.pcare        + "','" + p.mch_id        + "','" + p.asphyxia        + "','" + p.vit_k        + "','" + p.bcres        + "')";                sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int update(AfterMch o) throws Exception    {        String sql="update " + dbObj.table + " set ";        AfterMch p=o;        String field =""                + "', "	+ dbObj.visit_id  + "='" + p.visit_id        + "', "	+ dbObj.patient_id  + "='" + p.patient_id        + "', "	+ dbObj.update   + "='" + p.update        + "', "	+ dbObj.note   + "='" + p.note        + "', "	+ dbObj.active  + "='" + p.active        + "', "	+ dbObj.user_record   + "='" + p.user_record        + "', "	+ dbObj.user_modify    + "='" + p.user_modify        + "', "	+ dbObj.user_cancel    + "='" + p.user_cancel        + "', "	+ dbObj.uterus_level    + "='" + p.uterus_level        + "', "	+ dbObj.milk_seep    + "='" + p.milk_seep        + "', "	+ dbObj.sugar_level    + "='" + p.sugar_level        + "', "	+ dbObj.lochia   + "='" + p.lochia        + "', "	+ dbObj.menses    + "='" + p.menses        + "', "	+ dbObj.sew    + "='" + p.sew        + "', "	+ dbObj.cream   + "='" + p.cream        + "', "	+ dbObj.albumin   + "='" + p.albumin        + "', "	+ dbObj.result_verify   + "='" + p.result_verify        + "', "	+ dbObj.pcare  + "='" + p.pcare        + "', "	+ dbObj.mch_id  + "='" + p.mch_id        + "', "	+ dbObj.asphyxia   + "='" + p.asphyxia        + "', "	+ dbObj.vit_k  + "='" + p.vit_k        + "', "	+ dbObj.bcres  + "='" + p.bcres        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }        public int delete(AfterMch o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";        return theConnectionInf.eUpdate(sql);    }        public AfterMch selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.pk_field        + " = '" + pk + "'"        + " AND " + dbObj.active + " = '1'";        Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (AfterMch)v.get(0);    }    /**     * @deprecated     */    public Vector selectByHN(String pk) throws Exception    {        return selectByPtid(pk);    }    public Vector selectByPtid(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.patient_id        + " = '" + pk + "'"        + " AND " + dbObj.active + " = '1' "        + " Order By  " + dbObj.pcare;        Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return v;    }        public Vector selectByMchID(String mch_id) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.mch_id        + " = '" + mch_id + "'"        + " AND " + dbObj.active + " = '1' "        + " Order By  " + dbObj.pcare;                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return v;    }        public Vector selectAll() throws Exception    {        String sql="select * from " + dbObj.table;        Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return v;    }            public Vector eQuery(String sql) throws Exception    {        AfterMch p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new AfterMch();            p.setObjectId(rs.getString(dbObj.pk_field));                                    p.visit_id = rs.getString(dbObj.visit_id);            p.patient_id  = rs.getString(dbObj.patient_id);            p.update   = rs.getString(dbObj.update);            p.note   = rs.getString(dbObj.note);            p.active  = rs.getString(dbObj.active);            p.user_record   = rs.getString(dbObj.user_record);            p.user_modify    = rs.getString(dbObj.user_modify);            p.user_cancel    = rs.getString(dbObj.user_cancel);            p.uterus_level    = rs.getString(dbObj.uterus_level);            p.milk_seep    = rs.getString(dbObj.milk_seep);            p.sugar_level    = rs.getString(dbObj.sugar_level);            p.lochia   = rs.getString(dbObj.lochia);            p.menses    = rs.getString(dbObj.menses);            p.sew    = rs.getString(dbObj.sew);            p.cream   = rs.getString(dbObj.cream);            p.albumin   = rs.getString(dbObj.albumin);            p.result_verify   = rs.getString(dbObj.result_verify);            p.pcare  = rs.getString(dbObj.pcare);            p.mch_id  = rs.getString(dbObj.mch_id);            p.asphyxia   = rs.getString(dbObj.asphyxia);            p.vit_k  = rs.getString(dbObj.vit_k);            p.bcres  = rs.getString(dbObj.bcres);            list.add(p);        }        rs.close();        return list;    }    }