/*Source file: E:\\Job\\DrugReportSep\\code\\com\\hospital_os\\control\\PrescribeDB.java*/
package com.hospital_os.objdb;
import com.hospital_os.usecase.connection.*;
import java.util.*;
import java.sql.*;
import com.hospital_os.utility.*;
import com.hospital_os.object.*;
public class AppointmentDB
{
    public ConnectionInf theConnectionInf;
    public Appointment dbObj;
    final public String idtable = "110";
    /**
     * @param ConnectionInf db
     * @roseuid 3F65897F0326
     */
    public AppointmentDB(ConnectionInf db)
    {
        theConnectionInf=db;
        dbObj = new Appointment();
        initConfig();
    }
    public AppointmentDB()
    {
        theConnectionInf= null;
        dbObj = new Appointment();
        initConfig();
    }
    
    public boolean initConfig()
    {
        dbObj.table="t_patient_appointment";
        dbObj.pk_field="t_patient_appointment_id";
        dbObj.patient_id   ="t_patient_id";
        dbObj.date_serv   ="patient_appoint_date_time";
        dbObj.appoint_date   ="patient_appointment_date";
        dbObj.appoint_time   ="patient_appointment_time";
        dbObj.aptype   ="patient_appointment";
        dbObj.doctor_code   ="patient_appointment_doctor";
        dbObj.clinic_code   ="patient_appointment_clinic";
        dbObj.description   ="patient_appointment_notice";
        dbObj.appointmenter   ="patient_appointment_staff";
        dbObj.visit_id   ="t_visit_id";
        dbObj.auto_visit   ="patient_appointment_auto_visit";
        dbObj.queue_visit_id ="b_visit_queue_setup_id";
        dbObj.status = "patient_appointment_status";
        dbObj.vn = "patient_appointment_vn";
        dbObj.appoint_staff_record = "patient_appointment_staff_record";
        dbObj.appoint_record_date_time = "patient_appointment_record_date_time";
        dbObj.appoint_staff_update = "patient_appointment_staff_update";
        dbObj.appoint_update_date_time = "patient_appointment_update_date_time";
        dbObj.appoint_staff_cancel = "patient_appointment_staff_cancel";
        dbObj.appoint_cancel_date_time = "patient_appointment_cancel_date_time";
        dbObj.appoint_active = "patient_appointment_active";
        dbObj.count_appointment= "count_appointment";//amp:7/8/2549
        dbObj.aptype53= "r_rp1853_aptype_id";
        
        return true;
    }
    /*////////////////////////////////////////////////////////////////////////////////////*/
    public int updatePatientByPatient(String old_id,String new_id)throws Exception
    {   
        String sql = "Update " + dbObj.table + " set "
        + dbObj.patient_id + " = '" + new_id + "',"
        + dbObj.description + " = "+dbObj.appoint_staff_cancel+"||'-'||'" + old_id + "'"
        + " where " + dbObj.patient_id + " = '" + old_id +"'";
        return theConnectionInf.eUpdate(sql);
    }
    
    /**
     * @param cmd
     * @param o
     * @return int
     * @roseuid 3F6574DE0394
     */
    public int insert(Appointment p) throws Exception
    {
        p.aptype = Gutil.CheckReservedWords(p.aptype);
        p.description = Gutil.CheckReservedWords(p.description);
        p.generateOID(idtable);
        StringBuffer sql = new StringBuffer("insert into " ).append( dbObj.table ).append( " ("
                ).append( dbObj.pk_field
        ).append( " ,"	).append( dbObj.patient_id
        ).append( " ,"	).append( dbObj.visit_id
        ).append( " ,"	).append( dbObj.date_serv
        ).append( " ,"	).append( dbObj.appoint_date
        ).append( " ,"	).append( dbObj.appoint_time
        ).append( " ,"	).append( dbObj.aptype
        ).append( " ,"	).append( dbObj.doctor_code
        ).append( " ,"	).append( dbObj.clinic_code
        ).append( " ,"	).append( dbObj.description
        ).append( " ,"	).append( dbObj.appointmenter
        ).append( " ,"	).append( dbObj.auto_visit
        ).append( " ,"	).append( dbObj.queue_visit_id
        ).append( " ,"	).append( dbObj.status
        ).append( " ,"	).append( dbObj.vn
        ).append( " ,"	).append( dbObj.appoint_staff_record
        ).append( " ,"	).append( dbObj.appoint_record_date_time
        ).append( " ,"	).append( dbObj.appoint_staff_update
        ).append( " ,"	).append( dbObj.appoint_update_date_time
        ).append( " ,"	).append( dbObj.appoint_staff_cancel
        ).append( " ,"	).append( dbObj.appoint_cancel_date_time
        ).append( " ,"	).append( dbObj.appoint_active
        ).append( " ,"	).append( dbObj.aptype53
        ).append( " ) values ('"
        ).append( p.getObjectId()
        ).append( "','" ).append( p.patient_id
        ).append( "','" ).append( p.visit_id
        ).append( "','" ).append( p.date_serv
        ).append( "','" ).append( p.appoint_date
        ).append( "','" ).append( p.appoint_time
        ).append( "','" ).append( p.aptype
        ).append( "','" ).append( p.doctor_code
        ).append( "','" ).append( p.clinic_code
        ).append( "','" ).append( p.description
        ).append( "','" ).append( p.appointmenter
        ).append( "','" ).append( p.auto_visit
        ).append( "','" ).append( p.queue_visit_id
        ).append( "','" ).append( p.status
        ).append( "','" ).append( p.vn
        ).append( "','"	).append( p.appoint_staff_record
        ).append( "','"	).append( p.appoint_record_date_time
        ).append( "','"	).append( p.appoint_staff_update
        ).append( "','"	).append( p.appoint_update_date_time
        ).append( "','"	).append( p.appoint_staff_cancel
        ).append( "','"	).append( p.appoint_cancel_date_time
        ).append( "','" ).append( p.appoint_active
        ).append( "','" ).append( p.aptype53
        ).append( "')");
        return theConnectionInf.eUpdate(sql.toString());
    }
    public int update(Appointment p) throws Exception
    {
        p.aptype = Gutil.CheckReservedWords(p.aptype);
        p.description = Gutil.CheckReservedWords(p.description);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( dbObj.patient_id ).append( "='" ).append( p.patient_id
        ).append( "', " ).append( dbObj.visit_id ).append( "='" ).append( p.visit_id
        ).append( "', " ).append( dbObj.date_serv ).append( "='" ).append( p.date_serv
        ).append( "', " ).append( dbObj.appoint_date ).append( "='" ).append( p.appoint_date
        ).append( "', " ).append( dbObj.appoint_time ).append( "='" ).append( p.appoint_time
        ).append( "', " ).append( dbObj.aptype ).append( "='" ).append( p.aptype
        ).append( "', " ).append( dbObj.doctor_code ).append( "='" ).append( p.doctor_code
        ).append( "', " ).append( dbObj.clinic_code ).append( "='" ).append( p.clinic_code
        ).append( "', " ).append( dbObj.description ).append( "='" ).append( p.description
        ).append( "', " ).append( dbObj.appointmenter ).append( "='" ).append( p.appointmenter
        ).append( "', " ).append( dbObj.auto_visit ).append( "='" ).append( p.auto_visit
        ).append( "', " ).append( dbObj.queue_visit_id ).append( "='" ).append( p.queue_visit_id
        ).append( "', " ).append( dbObj.status ).append( "='" ).append( p.status
        ).append( "', " ).append( dbObj.vn ).append( "='" ).append( p.vn
        ).append( "', " ).append( dbObj.appoint_staff_record ).append( "='" ).append( p.appoint_staff_record
        ).append( "', " ).append( dbObj.appoint_record_date_time ).append( "='" ).append( p.appoint_record_date_time
        ).append( "', " ).append( dbObj.appoint_staff_update ).append( "='" ).append( p.appoint_staff_update
        ).append( "', " ).append( dbObj.appoint_update_date_time ).append( "='" ).append( p.appoint_update_date_time
        ).append( "', " ).append( dbObj.appoint_staff_cancel ).append( "='" ).append( p.appoint_staff_cancel
        ).append( "', " ).append( dbObj.appoint_cancel_date_time ).append( "='" ).append( p.appoint_cancel_date_time
        ).append( "', " ).append( dbObj.appoint_active ).append( "='" ).append( p.appoint_active
        ).append( "', " ).append( dbObj.aptype53 ).append( "='" ).append( p.aptype53
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public int delete(Appointment o) throws Exception
    {
        StringBuffer sql = new StringBuffer("delete from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( o.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectAll() throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
                ).append(  " order by ").append( dbObj.appoint_date
        ).append( " , " ).append( dbObj.clinic_code);
        
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    public Vector selectFinalDate(String pat_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
                ).append(  " where t_patient_id = '").append( pat_id
        ).append( "' and patient_appointment_status <> '1' and patient_appointment_active = '1' "
                + "order by patient_appointment_date limit 1" );

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    public Vector selectFinalDate2(String pat_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
                ).append(  " where t_patient_id = '").append( pat_id
        ).append( "' and patient_appointment_status <> '1' and patient_appointment_active = '1' "
                + "order by patient_appointment_date desc limit 1" );

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*///////////////////////////////////////////////////////////////////////////////*/
    public Vector selectByDate(String datefrom, String dateto, String patientID) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.appoint_date
        ).append( " >= '" ).append( datefrom ).append( "' and " ).append( dbObj.appoint_date
        ).append( " <= '" ).append( dateto ).append( "' and " ).append( dbObj.patient_id
        ).append( " = '" ).append( patientID ).append( "'"
        ).append( " order by " ).append( dbObj.appoint_date);
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectByDateSP(String datefrom, String dateto, String SP) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.appoint_date
        ).append( " >= '" ).append( datefrom ).append( "' and " ).append( dbObj.appoint_date
        ).append( " <= '" ).append( dateto ).append( "'and " ).append( dbObj.clinic_code
        ).append( " = '" ).append( SP ).append( "'"
        ).append( " order by " ).append( dbObj.appoint_date);
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectByDateNoSp(String datefrom, String dateto) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.appoint_date
        ).append( " >= '" ).append( datefrom ).append( "' and " ).append( dbObj.appoint_date
        ).append( " <= '" ).append( dateto ).append( "' order by "
        ).append( dbObj.appoint_date
        ).append( " , " ).append( dbObj.clinic_code);
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectBySP(String SP) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.clinic_code
        ).append( " = '" ).append( SP ).append( "'"
        ).append( " order by " ).append( dbObj.appoint_date);
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectByPtId(String ptid) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.patient_id
        ).append( " = '" ).append( ptid ).append( "'"
        ).append( " order by " ).append( dbObj.appoint_date);
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Appointment selectByPK(String pk) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field
        ).append( " = '" ).append( pk ).append( "'");
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return (Appointment)v.get(0);
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Appointment select2ByPK(String pk) throws Exception 
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field
        ).append( " = '" ).append( pk ).append( "'");
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
                return null;
        else    return (Appointment)v.get(0);
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectByDatePid(String date,String pid) throws Exception 
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.appoint_date ).append( " = '" ).append( date ).append( "'"
        ).append( " and " ).append( dbObj.patient_id ).append( " = '" ).append( pid ).append( "'");
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectByVid(String vid) throws Exception 
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( vid ).append( "'");
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectByVN(String vn) throws Exception 
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.vn ).append( " = '" ).append( vn ).append( "'");
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector selectWait(String patient_id) throws Exception 
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.patient_id ).append( " = '" ).append( patient_id ).append( "'"
        ).append( " and " ).append( dbObj.status ).append( " = '0'"
        ).append( " and " ).append( dbObj.appoint_active ).append( " = '1'");
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;        
    }
    
    /**
     *@Author amp
     *@date 20/06/2549
     *@see �֧�Ѵ���ç�Ѻ�ѹ��� visit
     */
    public Vector selectByRecordDate(String visit, String date) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit ).append( "' and substring(" ).append( dbObj.date_serv
        ).append( ",0,11) = '" ).append( date.substring(0,10)
        ).append( "' order by " ).append( dbObj.appoint_date);
        
        Vector v = eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
        
    /**
     *@Author: amp
     *@date: 7/8/2549
     *@see: �ӹǳ�ӹǹ�ͧ��ùѴ������ѹ
     *@param: �ѹ���Ѵ
     *@return: �ӹǹ��ùѴ�ͧ�ѹ���
     *@note: �� method �����Ѻ countAppointmentByDateAndDoctor ���ͧ�ҡ�պҧ record ���ᾷ����Ѵ�繪�ͧ��ҧ ���� databse develop_hosv3
     */
    public String countAppointmentByDate(String date_appointment) throws Exception
    {
        StringBuffer sql = new StringBuffer("SELECT Count(" ).append( dbObj.pk_field ).append( ") AS count_appointment " ).append(
                " FROM " ).append( dbObj.table ).append(
                " WHERE " ).append( dbObj.appoint_date ).append( " = '" ).append( date_appointment ).append( "'" ).append(
                " AND " ).append( dbObj.appoint_active ).append( " = '1'" ).append(
                " GROUP BY " ).append( dbObj.appoint_date);
        
        Vector v = countAppointmentQuery(sql.toString());
        if(v.size()==0)
            return "0";
        else
            return ((Appointment)v.get(0)).count_appointment;
    }
    
    public int countByDateDoctor(String date_appointment, String doctor_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("SELECT Count(" ).append( dbObj.pk_field ).append( ") AS count_appointment " ).append(
                " FROM " ).append( dbObj.table ).append(
                " WHERE " ).append( dbObj.appoint_date ).append( " = '" ).append( date_appointment ).append( "'" ).append(
                " AND " ).append( dbObj.doctor_code ).append( " = '" ).append( doctor_id ).append( "'" ).append(
                " AND " ).append( dbObj.appoint_active ).append( " = '1'");

        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        int count = 0;
        while(rs.next())
            count = rs.getInt("count_appointment");
        rs.close();
        return count;
    }
    /**
     *@Author: amp
     *@date: 7/8/2549
     *@see: �ӹǳ�ӹǹ�ͧ��ùѴ������ѹ�ͧ����ᾷ�� 
     *@param: �ѹ���Ѵ,Key_id �ͧ employee �ͧᾷ�������͡
     *@return: �ӹǹ��ùѴ�ͧ�ѹ���ᾷ�����к�     
     */
    public String countAppointmentByDateAndDoctor(String date_appointment, String doctor_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("SELECT Count(" ).append( dbObj.pk_field ).append( ") AS count_appointment " ).append(
                " FROM " ).append( dbObj.table ).append(
                " WHERE " ).append( dbObj.appoint_date ).append( " = '" ).append( date_appointment ).append( "'" ).append(
                " AND " ).append( dbObj.doctor_code ).append( " = '" ).append( doctor_id ).append( "'" ).append(
                " AND " ).append( dbObj.appoint_active ).append( " = '1'");

        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        String count = "";
        while(rs.next())
            count = rs.getString("count_appointment");
        rs.close();
        return count;
    }
    
    /**
     *@Author: henbe
     *@date: 7/7/2550
     *@see: �ӹǳ�ӹǹ�ͧ��ùѴ������ѹ�ͧ���Шش��ԡ��
     *@param: �ѹ���Ѵ,Key_id �ͧ employee �ͧᾷ�������͡
     *@return: �ӹǹ��ùѴ�ͧ�ѹ��Шش��ԡ�÷���к�
     */
    public String countAppointmentByDateSpid(String date_appointment, String spid) throws Exception
    {
        StringBuffer sql = new StringBuffer("SELECT Count(" ).append( dbObj.pk_field ).append( ") AS count_appointment " ).append(
                " FROM " ).append( dbObj.table ).append(
                " WHERE " ).append( dbObj.appoint_date ).append( " = '" ).append( date_appointment ).append( "'" ).append(
                " AND " ).append( dbObj.clinic_code ).append( " = '" ).append( spid ).append( "'" ).append(
                " AND " ).append( dbObj.appoint_active ).append( " = '1'");

        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        String count = "";
        while(rs.next())
            count = rs.getString("count_appointment");
        rs.close();
        return count;
    }

    /**
     *@Author: amp
     *@date: 7/8/2549
     *@see: �ӹǳ�ӹǹ�ͧ��ùѴ������ѹ     
     * @deprecated henbe unused
     */
    public Vector countAppointmentQuery(String sql) throws Exception
    {
        Appointment p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        while(rs.next())
        {
            p = new Appointment();
            p.count_appointment = rs.getString(dbObj.count_appointment);
            list.add(p);
        }
        rs.close();
        return list;
    }
    
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector eQuery(String sql) throws Exception
    {
        Appointment p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        while(rs.next())
        {
            p = new Appointment();
            p.setObjectId(rs.getString(dbObj.pk_field));
            p.patient_id = rs.getString(dbObj.patient_id);
            p.visit_id = rs.getString(dbObj.visit_id);
            p.date_serv = rs.getString(dbObj.date_serv);
            p.appoint_date = rs.getString(dbObj.appoint_date);
            p.appoint_time = rs.getString(dbObj.appoint_time);
            p.aptype = rs.getString(dbObj.aptype);
            p.doctor_code = rs.getString(dbObj.doctor_code);
            p.clinic_code = rs.getString(dbObj.clinic_code);
            p.description = rs.getString(dbObj.description);
            p.appointmenter = rs.getString(dbObj.appointmenter);
            p.auto_visit = rs.getString(dbObj.auto_visit);
            p.queue_visit_id = rs.getString(dbObj.queue_visit_id);
            p.status = rs.getString(dbObj.status);
            p.vn = rs.getString(dbObj.vn);
            p.appoint_staff_record = rs.getString(dbObj.appoint_staff_record);
            p.appoint_record_date_time = rs.getString(dbObj.appoint_record_date_time);
            p.appoint_staff_update = rs.getString(dbObj.appoint_staff_update);
            p.appoint_update_date_time = rs.getString(dbObj.appoint_update_date_time);
            p.appoint_staff_cancel = rs.getString(dbObj.appoint_staff_cancel);
            p.appoint_cancel_date_time = rs.getString(dbObj.appoint_cancel_date_time);
            p.appoint_active = rs.getString(dbObj.appoint_active);
            p.aptype53 = rs.getString(dbObj.aptype53);
            list.add(p);
        }
        rs.close();
        return list;
    }
    /*////////////////////////////////////////////////////////////////////////////*/
}
