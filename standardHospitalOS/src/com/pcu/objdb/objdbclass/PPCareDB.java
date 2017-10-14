/*
 * PPCareDB.java
 *
 * Created on 3 �ԧ�Ҥ� 2548, 17:13 �.
 */

package com.pcu.objdb.objdbclass;

import java.util.*;
import java.sql.*; 
import com.hospital_os.usecase.connection.*;
import com.hospital_os.utility.*;
import com.pcu.object.*;
/**
 *
 * @author amp
 */
public class PPCareDB
{
    
    /** Creates a new instance of PPCareDB */
    public PPCareDB()
    {
    }
    
    public ConnectionInf theConnectionInf;
    public PPCare dbObj;
    final private String idtable = "772";
    
    public PPCareDB(ConnectionInf db)
    {
        theConnectionInf=db;
        dbObj = new PPCare();
        initConfig();
    }
    
    public boolean initConfig()
    {
        dbObj.table = "t_health_pp_care";        
        dbObj.pk_field = "t_health_pp_care_id";
        dbObj.patient_id = "t_patient_id";
        dbObj.visit_id = "t_visit_id";	
        dbObj.pp_care_number = "pp_care_number";
        dbObj.pp_care_survey_place = "pp_care_survey_place";
        dbObj.pp_care_deliver_place = "pp_care_deliver_place";
        dbObj.pp_care_mom_age = "pp_care_mom_age";
        dbObj.pp_care_dermis = "pp_care_dermis";
        dbObj.pp_care_navel = "pp_care_navel";
        dbObj.pp_care_feces = "pp_care_feces";
        dbObj.pp_care_urine = "pp_care_urine";
        dbObj.pp_care_next_appointment = "pp_care_next_appointment";
        dbObj.pp_care_health = "pp_care_health";
        dbObj.pp_care_result = "pp_care_result";
        dbObj.pp_care_state = "pp_care_state";
        dbObj.pp_care_comment = "pp_care_comment";
        dbObj.pp_care_staff_record = "pp_care_staff_record";
        dbObj.pp_care_staff_modify = "pp_care_staff_modify";
        dbObj.pp_care_staff_cancel = "pp_care_staff_cancel";	
        dbObj.pp_care_record_date_time = "pp_care_record_date_time";
        dbObj.pp_care_modify_date_time = "pp_care_modify_date_time";	
        dbObj.pp_care_cancel_date_time = "pp_care_cancel_date_time";	
        dbObj.pp_care_active = "pp_care_active";
        dbObj.family_id = "t_health_family_id";
        dbObj.survey_date = "pp_care_survey_date";

        dbObj.pp_care_number2 = "pp_care_number2";
        dbObj.pp_care_survey_place2 = "pp_care_survey_place2";
        dbObj.pp_care_deliver_place2 = "pp_care_deliver_place2";
        dbObj.pp_care_mom_age2 = "pp_care_mom_age2";
        dbObj.pp_care_dermis2 = "pp_care_dermis2";
        dbObj.pp_care_navel2 = "pp_care_navel2";
        dbObj.pp_care_feces2 = "pp_care_feces2";
        dbObj.pp_care_urine2 = "pp_care_urine2";
        dbObj.pp_care_next_appointment2 = "pp_care_next_appointment2";
        dbObj.pp_care_health2 = "pp_care_health2";
        dbObj.pp_care_result2 = "pp_care_result2";
        dbObj.pp_care_state2 = "pp_care_state2";
//        dbObj.pp_care_comment2 = "pp_care_comment2";
        dbObj.pp_care_staff_record2 = "pp_care_staff_record2";
        dbObj.pp_care_staff_modify2 = "pp_care_staff_modify2";
        dbObj.pp_care_staff_cancel2 = "pp_care_staff_cancel2";
        dbObj.pp_care_record_date_time2 = "pp_care_record_date_time2";
        dbObj.pp_care_modify_date_time2 = "pp_care_modify_date_time2";
        dbObj.pp_care_cancel_date_time2 = "pp_care_cancel_date_time2";
        dbObj.pp_care_active2 = "pp_care_active2";
        dbObj.family_id2 = "t_health_family_id2";
        dbObj.survey_date2 = "pp_care_survey_date2";

        dbObj.pp_care_number3 = "pp_care_number3";
        dbObj.pp_care_survey_place3 = "pp_care_survey_place3";
        dbObj.pp_care_deliver_place3 = "pp_care_deliver_place3";
        dbObj.pp_care_mom_age3 = "pp_care_mom_age3";
        dbObj.pp_care_dermis3 = "pp_care_dermis3";
        dbObj.pp_care_navel3 = "pp_care_navel3";
        dbObj.pp_care_feces3 = "pp_care_feces3";
        dbObj.pp_care_urine3 = "pp_care_urine3";
        dbObj.pp_care_next_appointment3 = "pp_care_next_appointment3";
        dbObj.pp_care_health3 = "pp_care_health3";
        dbObj.pp_care_result3 = "pp_care_result3";
        dbObj.pp_care_state3 = "pp_care_state3";
//        dbObj.pp_care_comment3 = "pp_care_comment3";
        dbObj.pp_care_staff_record3 = "pp_care_staff_record3";
        dbObj.pp_care_staff_modify3 = "pp_care_staff_modify3";
        dbObj.pp_care_staff_cancel3 = "pp_care_staff_cancel3";
        dbObj.pp_care_record_date_time3 = "pp_care_record_date_time3";
        dbObj.pp_care_modify_date_time3 = "pp_care_modify_date_time3";
        dbObj.pp_care_cancel_date_time3 = "pp_care_cancel_date_time3";
        dbObj.pp_care_active3 = "pp_care_active3";
        dbObj.family_id3 = "t_health_family_id3";
        dbObj.survey_date3 = "pp_care_survey_date3";
        dbObj.t_health_pp_care_child_id = "t_health_pp_care_child_id";
        return true;
    }
    
    public int insert(PPCare o) throws Exception
    {
        String sql="";
        PPCare p=o;
        p.generateOID(idtable);
        sql="insert into " + dbObj.table + " ("
        + dbObj.pk_field  
        + " ," + dbObj.patient_id
        + " ," + dbObj.visit_id	
        + " ," + dbObj.pp_care_number
        + " ," + dbObj.pp_care_survey_place
        + " ," + dbObj.pp_care_deliver_place
        + " ," + dbObj.pp_care_mom_age
        + " ," + dbObj.pp_care_dermis
        + " ," + dbObj.pp_care_navel
        + " ," + dbObj.pp_care_feces
        + " ," + dbObj.pp_care_urine
        + " ," + dbObj.pp_care_next_appointment
        + " ," + dbObj.pp_care_health
        + " ," + dbObj.pp_care_result
        + " ," + dbObj.pp_care_state
        + " ," + dbObj.pp_care_comment
        + " ," + dbObj.pp_care_staff_record
        + " ," + dbObj.pp_care_staff_modify
        + " ," + dbObj.pp_care_staff_cancel	
        + " ," + dbObj.pp_care_record_date_time
        + " ," + dbObj.pp_care_modify_date_time	
        + " ," + dbObj.pp_care_cancel_date_time	
        + " ," + dbObj.pp_care_active
        + " ," + dbObj.family_id
        + " ," + dbObj.survey_date
        + " ) values ('"
        + p.getObjectId()  
        + "','" + p.patient_id
        + "','" + p.visit_id	
        + "','" + p.pp_care_number
        + "','" + p.pp_care_survey_place
        + "','" + p.pp_care_deliver_place
        + "','" + p.pp_care_mom_age
        + "','" + p.pp_care_dermis
        + "','" + p.pp_care_navel
        + "','" + p.pp_care_feces
        + "','" + p.pp_care_urine
        + "','" + p.pp_care_next_appointment
        + "','" + p.pp_care_health
        + "','" + p.pp_care_result
        + "','" + p.pp_care_state
        + "','" + p.pp_care_comment
        + "','" + p.pp_care_staff_record
        + "','" + p.pp_care_staff_modify
        + "','" + p.pp_care_staff_cancel	
        + "','" + p.pp_care_record_date_time
        + "','" + p.pp_care_modify_date_time	
        + "','" + p.pp_care_cancel_date_time	
        + "','" + p.pp_care_active
        + "','" + p.family_id
        + "','" + p.survey_date
        + "')";
        
        return theConnectionInf.eUpdate(sql);
    }
    public int insertN(PPCare o) throws Exception
    {
        String sql="";
        PPCare p=o;
        p.generateOID(idtable);
        sql="insert into " + dbObj.table + " ("
        + dbObj.pk_field
        + " ," + dbObj.patient_id
        + " ," + dbObj.visit_id
        + " ," + dbObj.pp_care_number
        + " ," + dbObj.pp_care_survey_place
        + " ," + dbObj.pp_care_deliver_place
        + " ," + dbObj.pp_care_mom_age
        + " ," + dbObj.pp_care_dermis
        + " ," + dbObj.pp_care_navel
        + " ," + dbObj.pp_care_feces
        + " ," + dbObj.pp_care_urine
        + " ," + dbObj.pp_care_next_appointment
        + " ," + dbObj.pp_care_health
        + " ," + dbObj.pp_care_result
        + " ," + dbObj.pp_care_state
        + " ," + dbObj.pp_care_comment
        + " ," + dbObj.pp_care_staff_record
        + " ," + dbObj.pp_care_staff_modify
        + " ," + dbObj.pp_care_staff_cancel
        + " ," + dbObj.pp_care_record_date_time
        + " ," + dbObj.pp_care_modify_date_time
        + " ," + dbObj.pp_care_cancel_date_time
        + " ," + dbObj.pp_care_active
        + " ," + dbObj.family_id
        + " ," + dbObj.survey_date

        + " ," + dbObj.pp_care_number2
        + " ," + dbObj.pp_care_survey_place2
        + " ," + dbObj.pp_care_deliver_place2
        + " ," + dbObj.pp_care_mom_age2
        + " ," + dbObj.pp_care_dermis2
        + " ," + dbObj.pp_care_navel2
        + " ," + dbObj.pp_care_feces2
        + " ," + dbObj.pp_care_urine2
        + " ," + dbObj.pp_care_next_appointment2
        + " ," + dbObj.pp_care_health2
        + " ," + dbObj.pp_care_result2
        + " ," + dbObj.pp_care_state2
//        + " ," + dbObj.pp_care_comment2
        + " ," + dbObj.pp_care_staff_record2
        + " ," + dbObj.pp_care_staff_modify2
        + " ," + dbObj.pp_care_staff_cancel2
        + " ," + dbObj.pp_care_record_date_time2
        + " ," + dbObj.pp_care_modify_date_time2
        + " ," + dbObj.pp_care_cancel_date_time2
        + " ," + dbObj.pp_care_active2
        + " ," + dbObj.family_id2
        + " ," + dbObj.survey_date2

        + " ," + dbObj.pp_care_number3
        + " ," + dbObj.pp_care_survey_place3
        + " ," + dbObj.pp_care_deliver_place3
        + " ," + dbObj.pp_care_mom_age3
        + " ," + dbObj.pp_care_dermis3
        + " ," + dbObj.pp_care_navel3
        + " ," + dbObj.pp_care_feces3
        + " ," + dbObj.pp_care_urine3
        + " ," + dbObj.pp_care_next_appointment3
        + " ," + dbObj.pp_care_health3
        + " ," + dbObj.pp_care_result3
        + " ," + dbObj.pp_care_state3
//        + " ," + dbObj.pp_care_comment3
        + " ," + dbObj.pp_care_staff_record3
        + " ," + dbObj.pp_care_staff_modify3
        + " ," + dbObj.pp_care_staff_cancel3
        + " ," + dbObj.pp_care_record_date_time3
        + " ," + dbObj.pp_care_modify_date_time3
        + " ," + dbObj.pp_care_cancel_date_time3
        + " ," + dbObj.pp_care_active3
        + " ," + dbObj.family_id3
        + " ," + dbObj.survey_date3
        + " ," + dbObj.t_health_pp_care_child_id

        + " ) values ('"
        + p.getObjectId()
        + "','" + p.patient_id
        + "','" + p.visit_id
        + "','" + p.pp_care_number
        + "','" + p.pp_care_survey_place
        + "','" + p.pp_care_deliver_place
        + "','" + p.pp_care_mom_age
        + "','" + p.pp_care_dermis
        + "','" + p.pp_care_navel
        + "','" + p.pp_care_feces
        + "','" + p.pp_care_urine
        + "','" + p.pp_care_next_appointment
        + "','" + p.pp_care_health
        + "','" + p.pp_care_result
        + "','" + p.pp_care_state
        + "','" + p.pp_care_comment
        + "','" + p.pp_care_staff_record
        + "','" + p.pp_care_staff_modify
        + "','" + p.pp_care_staff_cancel
        + "','" + p.pp_care_record_date_time
        + "','" + p.pp_care_modify_date_time
        + "','" + p.pp_care_cancel_date_time
        + "','" + p.pp_care_active
        + "','" + p.family_id
        + "','" + p.survey_date

        + "','" + p.pp_care_number2
        + "','" + p.pp_care_survey_place2
        + "','" + p.pp_care_deliver_place2
        + "','" + p.pp_care_mom_age2
        + "','" + p.pp_care_dermis2
        + "','" + p.pp_care_navel2
        + "','" + p.pp_care_feces2
        + "','" + p.pp_care_urine2
        + "','" + p.pp_care_next_appointment2
        + "','" + p.pp_care_health2
        + "','" + p.pp_care_result2
        + "','" + p.pp_care_state2
//        + "','" + p.pp_care_comment2
        + "','" + p.pp_care_staff_record2
        + "','" + p.pp_care_staff_modify2
        + "','" + p.pp_care_staff_cancel2
        + "','" + p.pp_care_record_date_time2
        + "','" + p.pp_care_modify_date_time2
        + "','" + p.pp_care_cancel_date_time2
        + "','" + p.pp_care_active2
        + "','" + p.family_id2
        + "','" + p.survey_date2

        + "','" + p.pp_care_number3
        + "','" + p.pp_care_survey_place3
        + "','" + p.pp_care_deliver_place3
        + "','" + p.pp_care_mom_age3
        + "','" + p.pp_care_dermis3
        + "','" + p.pp_care_navel3
        + "','" + p.pp_care_feces3
        + "','" + p.pp_care_urine3
        + "','" + p.pp_care_next_appointment3
        + "','" + p.pp_care_health3
        + "','" + p.pp_care_result3
        + "','" + p.pp_care_state3
//        + "','" + p.pp_care_comment3
        + "','" + p.pp_care_staff_record3
        + "','" + p.pp_care_staff_modify3
        + "','" + p.pp_care_staff_cancel3
        + "','" + p.pp_care_record_date_time3
        + "','" + p.pp_care_modify_date_time3
        + "','" + p.pp_care_cancel_date_time3
        + "','" + p.pp_care_active3
        + "','" + p.family_id3
        + "','" + p.survey_date3
        + "','" + p.t_health_pp_care_child_id

        + "')";

        return theConnectionInf.eUpdate(sql);
    }
    
    public int update(PPCare o) throws Exception
    {
        String sql="update " + dbObj.table + " set ";
        PPCare p=o;
        String field =""    
        + "', " + dbObj.patient_id + "='" + p.patient_id
        + "', " + dbObj.visit_id + "='" + p.visit_id	
        + "', " + dbObj.pp_care_number + "='" + p.pp_care_number
        + "', " + dbObj.pp_care_survey_place + "='" + p.pp_care_survey_place
        + "', " + dbObj.pp_care_deliver_place + "='" + p.pp_care_deliver_place
        + "', " + dbObj.pp_care_mom_age + "='" + p.pp_care_mom_age
        + "', " + dbObj.pp_care_dermis + "='" + p.pp_care_dermis
        + "', " + dbObj.pp_care_navel + "='" + p.pp_care_navel
        + "', " + dbObj.pp_care_feces + "='" + p.pp_care_feces
        + "', " + dbObj.pp_care_urine + "='" + p.pp_care_urine
        + "', " + dbObj.pp_care_next_appointment + "='" + p.pp_care_next_appointment
        + "', " + dbObj.pp_care_health + "='" + p.pp_care_health
        + "', " + dbObj.pp_care_result + "='" + p.pp_care_result
        + "', " + dbObj.pp_care_state + "='" + p.pp_care_state
        + "', " + dbObj.pp_care_comment + "='" + p.pp_care_comment
        + "', " + dbObj.pp_care_staff_record + "='" + p.pp_care_staff_record
        + "', " + dbObj.pp_care_staff_modify + "='" + p.pp_care_staff_modify
        + "', " + dbObj.pp_care_staff_cancel + "='" + p.pp_care_staff_cancel	
        + "', " + dbObj.pp_care_record_date_time + "='" + p.pp_care_record_date_time
        + "', " + dbObj.pp_care_modify_date_time + "='" + p.pp_care_modify_date_time	
        + "', " + dbObj.pp_care_cancel_date_time + "='" + p.pp_care_cancel_date_time	
        + "', " + dbObj.pp_care_active + "='" + p.pp_care_active  
        + "', " + dbObj.family_id + "='" + p.family_id
        + "', " + dbObj.survey_date+ "='" + p.survey_date

        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";
        sql = sql+field.substring(2);
        
        return theConnectionInf.eUpdate(sql);
    }
    public int updateN(PPCare o) throws Exception
    {
        String sql="update " + dbObj.table + " set ";
        PPCare p=o;
        String field =""
        + "', " + dbObj.patient_id + "='" + p.patient_id
        + "', " + dbObj.visit_id + "='" + p.visit_id
        + "', " + dbObj.pp_care_number + "='" + p.pp_care_number
        + "', " + dbObj.pp_care_survey_place + "='" + p.pp_care_survey_place
        + "', " + dbObj.pp_care_deliver_place + "='" + p.pp_care_deliver_place
        + "', " + dbObj.pp_care_mom_age + "='" + p.pp_care_mom_age
        + "', " + dbObj.pp_care_dermis + "='" + p.pp_care_dermis
        + "', " + dbObj.pp_care_navel + "='" + p.pp_care_navel
        + "', " + dbObj.pp_care_feces + "='" + p.pp_care_feces
        + "', " + dbObj.pp_care_urine + "='" + p.pp_care_urine
        + "', " + dbObj.pp_care_next_appointment + "='" + p.pp_care_next_appointment
        + "', " + dbObj.pp_care_health + "='" + p.pp_care_health
        + "', " + dbObj.pp_care_result + "='" + p.pp_care_result
        + "', " + dbObj.pp_care_state + "='" + p.pp_care_state
        + "', " + dbObj.pp_care_comment + "='" + p.pp_care_comment
        + "', " + dbObj.pp_care_staff_record + "='" + p.pp_care_staff_record
        + "', " + dbObj.pp_care_staff_modify + "='" + p.pp_care_staff_modify
        + "', " + dbObj.pp_care_staff_cancel + "='" + p.pp_care_staff_cancel
        + "', " + dbObj.pp_care_record_date_time + "='" + p.pp_care_record_date_time
        + "', " + dbObj.pp_care_modify_date_time + "='" + p.pp_care_modify_date_time
        + "', " + dbObj.pp_care_cancel_date_time + "='" + p.pp_care_cancel_date_time
        + "', " + dbObj.pp_care_active + "='" + p.pp_care_active
        + "', " + dbObj.family_id + "='" + p.family_id
        + "', " + dbObj.survey_date+ "='" + p.survey_date

        + "', " + dbObj.pp_care_number2 + "='" + p.pp_care_number2
        + "', " + dbObj.pp_care_survey_place2 + "='" + p.pp_care_survey_place2
        + "', " + dbObj.pp_care_deliver_place2 + "='" + p.pp_care_deliver_place2
        + "', " + dbObj.pp_care_mom_age2 + "='" + p.pp_care_mom_age2
        + "', " + dbObj.pp_care_dermis2 + "='" + p.pp_care_dermis2
        + "', " + dbObj.pp_care_navel2 + "='" + p.pp_care_navel2
        + "', " + dbObj.pp_care_feces2 + "='" + p.pp_care_feces2
        + "', " + dbObj.pp_care_urine2 + "='" + p.pp_care_urine2
        + "', " + dbObj.pp_care_next_appointment2 + "='" + p.pp_care_next_appointment2
        + "', " + dbObj.pp_care_health2 + "='" + p.pp_care_health2
        + "', " + dbObj.pp_care_result2 + "='" + p.pp_care_result2
        + "', " + dbObj.pp_care_state2 + "='" + p.pp_care_state2
//        + "', " + dbObj.pp_care_comment2 + "='" + p.pp_care_comment2
        + "', " + dbObj.pp_care_staff_record2 + "='" + p.pp_care_staff_record2
        + "', " + dbObj.pp_care_staff_modify2 + "='" + p.pp_care_staff_modify2
        + "', " + dbObj.pp_care_staff_cancel2 + "='" + p.pp_care_staff_cancel2
        + "', " + dbObj.pp_care_record_date_time2 + "='" + p.pp_care_record_date_time2
        + "', " + dbObj.pp_care_modify_date_time2 + "='" + p.pp_care_modify_date_time2
        + "', " + dbObj.pp_care_cancel_date_time2 + "='" + p.pp_care_cancel_date_time2
        + "', " + dbObj.pp_care_active2 + "='" + p.pp_care_active2
        + "', " + dbObj.family_id2 + "='" + p.family_id2
        + "', " + dbObj.survey_date2+ "='" + p.survey_date2

        + "', " + dbObj.pp_care_number3 + "='" + p.pp_care_number3
        + "', " + dbObj.pp_care_survey_place3 + "='" + p.pp_care_survey_place3
        + "', " + dbObj.pp_care_deliver_place3 + "='" + p.pp_care_deliver_place3
        + "', " + dbObj.pp_care_mom_age3 + "='" + p.pp_care_mom_age3
        + "', " + dbObj.pp_care_dermis3 + "='" + p.pp_care_dermis3
        + "', " + dbObj.pp_care_navel3 + "='" + p.pp_care_navel3
        + "', " + dbObj.pp_care_feces3 + "='" + p.pp_care_feces3
        + "', " + dbObj.pp_care_urine3 + "='" + p.pp_care_urine3
        + "', " + dbObj.pp_care_next_appointment3 + "='" + p.pp_care_next_appointment3
        + "', " + dbObj.pp_care_health3 + "='" + p.pp_care_health3
        + "', " + dbObj.pp_care_result3 + "='" + p.pp_care_result3
        + "', " + dbObj.pp_care_state3 + "='" + p.pp_care_state3
//        + "', " + dbObj.pp_care_comment3 + "='" + p.pp_care_comment3
        + "', " + dbObj.pp_care_staff_record3 + "='" + p.pp_care_staff_record3
        + "', " + dbObj.pp_care_staff_modify3 + "='" + p.pp_care_staff_modify3
        + "', " + dbObj.pp_care_staff_cancel3 + "='" + p.pp_care_staff_cancel3
        + "', " + dbObj.pp_care_record_date_time3 + "='" + p.pp_care_record_date_time3
        + "', " + dbObj.pp_care_modify_date_time3 + "='" + p.pp_care_modify_date_time3
        + "', " + dbObj.pp_care_cancel_date_time3 + "='" + p.pp_care_cancel_date_time3
        + "', " + dbObj.pp_care_active3 + "='" + p.pp_care_active3
        + "', " + dbObj.family_id3 + "='" + p.family_id3
        + "', " + dbObj.survey_date3+ "='" + p.survey_date3
        + "', " + dbObj.t_health_pp_care_child_id+ "='" + p.t_health_pp_care_child_id

        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";
        sql = sql+field.substring(2);

        return theConnectionInf.eUpdate(sql);
    }
    
    public int delete(PPCare o) throws Exception
    {
        String sql="delete from " + dbObj.table
        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";
        return theConnectionInf.eUpdate(sql);
    }
    
    public Vector listPPCareByPatientId(String search) throws Exception
    {
        String sql="select * from " + dbObj.table + " where " 
            + dbObj.patient_id + " = '" + search + "' and "
            + dbObj.pp_care_active + " = '1' order by " + dbObj.pp_care_number; // + " desc";
            
        return eQuery(sql);
    }
    public Vector listPPCareByFamilyID(String family_id) throws Exception
    {
        String sql="select * from " + dbObj.table + " where " 
            + dbObj.family_id + " = '" + family_id + "' and "
            + dbObj.pp_care_active + " = '1' order by " + dbObj.pp_care_number; // + " desc";
            
        return eQuery(sql);
    }
    public PPCare readPPCareByFamilyIDAndGravida(String family_id,String gravida) throws Exception
    {
        String sql="select * from " + dbObj.table + " where "
            + dbObj.family_id + " = '" + family_id + "' and "
            + dbObj.pp_care_number + "='" + gravida + "' and "
            + dbObj.pp_care_active + " = '1' order by " + dbObj.pp_care_number; // + " desc";

        Vector v = eQuery(sql);
        if(v.isEmpty())
            return null;
        else
            return (PPCare)v.get(0);
    }
    public PPCare readByVidN(String visit_id)  throws Exception {
        String sql="select * from " + dbObj.table + " where "
                + dbObj.visit_id + " = '" + visit_id + "' and "
                + dbObj.pp_care_active + " = '1'";

        Vector v = eQueryN(sql);
        if(v.isEmpty())
            return null;
        else
            return (PPCare)v.get(0);
    }
    public PPCare readByPPChildId(String ppchild_id)  throws Exception {
        String sql="select * from " + dbObj.table + " where "
                + dbObj.t_health_pp_care_child_id + " = '" + ppchild_id + "' and "
                + dbObj.pp_care_active + " = '1'";

        Vector v = eQueryN(sql);
        if(v.isEmpty())
            return null;
        else
            return (PPCare)v.get(0);
    }
    public PPCare readByFid(String f_id)  throws Exception {
        String sql="select * from " + dbObj.table + " where "
                + dbObj.family_id + " = '" + f_id + "' and "
                + dbObj.pp_care_active + " = '1'";

        Vector v = eQueryN(sql);
        if(v.isEmpty())
            return null;
        else
            return (PPCare)v.get(0);
    }
    public Vector eQuery(String sql) throws Exception
    {
        PPCare p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            p = new PPCare();
            p.setObjectId(rs.getString(dbObj.pk_field));            
            p.patient_id = rs.getString(dbObj.patient_id);
            p.visit_id = rs.getString(dbObj.visit_id);	
            p.pp_care_number = rs.getString(dbObj.pp_care_number);
            p.pp_care_survey_place = rs.getString(dbObj.pp_care_survey_place);
            p.pp_care_deliver_place = rs.getString(dbObj.pp_care_deliver_place);
            p.pp_care_mom_age = rs.getString(dbObj.pp_care_mom_age);
            p.pp_care_dermis = rs.getString(dbObj.pp_care_dermis);
            p.pp_care_navel = rs.getString(dbObj.pp_care_navel);
            p.pp_care_feces = rs.getString(dbObj.pp_care_feces);
            p.pp_care_urine = rs.getString(dbObj.pp_care_urine);
            p.pp_care_next_appointment = rs.getString(dbObj.pp_care_next_appointment);
            p.pp_care_health = rs.getString(dbObj.pp_care_health);
            p.pp_care_result = rs.getString(dbObj.pp_care_result);
            p.pp_care_state = rs.getString(dbObj.pp_care_state);
            p.pp_care_comment = rs.getString(dbObj.pp_care_comment);
            p.pp_care_staff_record = rs.getString(dbObj.pp_care_staff_record);
            p.pp_care_staff_modify = rs.getString(dbObj.pp_care_staff_modify);
            p.pp_care_staff_cancel = rs.getString(dbObj.pp_care_staff_cancel);	
            p.pp_care_record_date_time = rs.getString(dbObj.pp_care_record_date_time);
            p.pp_care_modify_date_time = rs.getString(dbObj.pp_care_modify_date_time);	
            p.pp_care_cancel_date_time = rs.getString(dbObj.pp_care_cancel_date_time);	
            p.pp_care_active = rs.getString(dbObj.pp_care_active);            
            p.family_id = rs.getString(dbObj.family_id);            
            p.survey_date = rs.getString(dbObj.survey_date);
            list.add(p);
        }
        rs.close();
        return list;
    }
    public Vector eQueryN(String sql) throws Exception
    {
        PPCare p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            p = new PPCare();
            p.setObjectId(rs.getString(dbObj.pk_field));
            p.patient_id = rs.getString(dbObj.patient_id);
            p.visit_id = rs.getString(dbObj.visit_id);
            p.pp_care_number = rs.getString(dbObj.pp_care_number);
            p.pp_care_survey_place = rs.getString(dbObj.pp_care_survey_place);
            p.pp_care_deliver_place = rs.getString(dbObj.pp_care_deliver_place);
            p.pp_care_mom_age = rs.getString(dbObj.pp_care_mom_age);
            p.pp_care_dermis = rs.getString(dbObj.pp_care_dermis);
            p.pp_care_navel = rs.getString(dbObj.pp_care_navel);
            p.pp_care_feces = rs.getString(dbObj.pp_care_feces);
            p.pp_care_urine = rs.getString(dbObj.pp_care_urine);
            p.pp_care_next_appointment = rs.getString(dbObj.pp_care_next_appointment);
            p.pp_care_health = rs.getString(dbObj.pp_care_health);
            p.pp_care_result = rs.getString(dbObj.pp_care_result);
            p.pp_care_state = rs.getString(dbObj.pp_care_state);
            p.pp_care_comment = rs.getString(dbObj.pp_care_comment);
            p.pp_care_staff_record = rs.getString(dbObj.pp_care_staff_record);
            p.pp_care_staff_modify = rs.getString(dbObj.pp_care_staff_modify);
            p.pp_care_staff_cancel = rs.getString(dbObj.pp_care_staff_cancel);
            p.pp_care_record_date_time = rs.getString(dbObj.pp_care_record_date_time);
            p.pp_care_modify_date_time = rs.getString(dbObj.pp_care_modify_date_time);
            p.pp_care_cancel_date_time = rs.getString(dbObj.pp_care_cancel_date_time);
            p.pp_care_active = rs.getString(dbObj.pp_care_active);
            p.family_id = rs.getString(dbObj.family_id);
            p.survey_date = rs.getString(dbObj.survey_date);

            p.pp_care_number2 = rs.getString(dbObj.pp_care_number2);
            p.pp_care_survey_place2 = rs.getString(dbObj.pp_care_survey_place2);
            p.pp_care_deliver_place2 = rs.getString(dbObj.pp_care_deliver_place2);
            p.pp_care_mom_age2 = rs.getString(dbObj.pp_care_mom_age2);
            p.pp_care_dermis2 = rs.getString(dbObj.pp_care_dermis2);
            p.pp_care_navel2 = rs.getString(dbObj.pp_care_navel2);
            p.pp_care_feces2 = rs.getString(dbObj.pp_care_feces2);
            p.pp_care_urine2 = rs.getString(dbObj.pp_care_urine2);
            p.pp_care_next_appointment2 = rs.getString(dbObj.pp_care_next_appointment2);
            p.pp_care_health2 = rs.getString(dbObj.pp_care_health2);
            p.pp_care_result2 = rs.getString(dbObj.pp_care_result2);
            p.pp_care_state2 = rs.getString(dbObj.pp_care_state2);
//            p.pp_care_comment2 = rs.getString(dbObj.pp_care_comment2);
            p.pp_care_staff_record2 = rs.getString(dbObj.pp_care_staff_record2);
            p.pp_care_staff_modify2 = rs.getString(dbObj.pp_care_staff_modify2);
            p.pp_care_staff_cancel2 = rs.getString(dbObj.pp_care_staff_cancel2);
            p.pp_care_record_date_time2 = rs.getString(dbObj.pp_care_record_date_time2);
            p.pp_care_modify_date_time2 = rs.getString(dbObj.pp_care_modify_date_time2);
            p.pp_care_cancel_date_time2 = rs.getString(dbObj.pp_care_cancel_date_time2);
            p.pp_care_active2 = rs.getString(dbObj.pp_care_active2);
            p.family_id2 = rs.getString(dbObj.family_id2);
            p.survey_date2 = rs.getString(dbObj.survey_date2);

            p.pp_care_number3 = rs.getString(dbObj.pp_care_number3);
            p.pp_care_survey_place3 = rs.getString(dbObj.pp_care_survey_place3);
            p.pp_care_deliver_place3 = rs.getString(dbObj.pp_care_deliver_place3);
            p.pp_care_mom_age3 = rs.getString(dbObj.pp_care_mom_age3);
            p.pp_care_dermis3 = rs.getString(dbObj.pp_care_dermis3);
            p.pp_care_navel3 = rs.getString(dbObj.pp_care_navel3);
            p.pp_care_feces3 = rs.getString(dbObj.pp_care_feces3);
            p.pp_care_urine3 = rs.getString(dbObj.pp_care_urine3);
            p.pp_care_next_appointment3 = rs.getString(dbObj.pp_care_next_appointment3);
            p.pp_care_health3 = rs.getString(dbObj.pp_care_health3);
            p.pp_care_result3 = rs.getString(dbObj.pp_care_result3);
            p.pp_care_state3 = rs.getString(dbObj.pp_care_state3);
//            p.pp_care_comment3 = rs.getString(dbObj.pp_care_comment3);
            p.pp_care_staff_record3 = rs.getString(dbObj.pp_care_staff_record3);
            p.pp_care_staff_modify3 = rs.getString(dbObj.pp_care_staff_modify3);
            p.pp_care_staff_cancel3 = rs.getString(dbObj.pp_care_staff_cancel3);
            p.pp_care_record_date_time3 = rs.getString(dbObj.pp_care_record_date_time3);
            p.pp_care_modify_date_time3 = rs.getString(dbObj.pp_care_modify_date_time3);
            p.pp_care_cancel_date_time3 = rs.getString(dbObj.pp_care_cancel_date_time3);
            p.pp_care_active3 = rs.getString(dbObj.pp_care_active3);
            p.family_id3 = rs.getString(dbObj.family_id3);
            p.survey_date3 = rs.getString(dbObj.survey_date3);
            p.t_health_pp_care_child_id = rs.getString(dbObj.t_health_pp_care_child_id);

            list.add(p);
        }
        rs.close();
        return list;
    }
/////////////////////////////////////////////////////////////////////////////    
    public int updateFidByFid(String family_id,String family_from) throws Exception
    {
        String sql="update " + dbObj.table + " set " 
                + dbObj.family_id + "='" + family_id + "',"
                + dbObj.pp_care_staff_cancel + "="+ dbObj.pp_care_staff_cancel + "||'-'||'" + family_from + "'"
                + " where " + dbObj.family_id + "='" + family_from +"'";
        return theConnectionInf.eUpdate(sql);
    }  
/////////////////////////////////////////////////////////////////////////////    
    public int updateFidByPtid(String family_id,String patient_id) throws Exception
    {
        String sql="update " + dbObj.table + " set " 
                + dbObj.family_id + "='" + family_id
                + "' where " + dbObj.patient_id + "='" + patient_id +"'";
        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());
        return theConnectionInf.eUpdate(sql);
    }     


    public int selectCount() throws Exception {
             String sql="select count(*) as count from " + dbObj.table;
             ResultSet rs = theConnectionInf.eQuery(sql);
             if(rs.next()){
                 return rs.getInt("count");
             }
             return 0;
    }
    
}
