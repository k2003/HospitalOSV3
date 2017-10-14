/*Source file: E:\\Job\\DrugReportSep\\code\\com\\hospital_os\\control\\PrescribeDB.java
*/
package com.hospital_os.objdb;
import com.hospital_os.usecase.connection.*;
import com.hospital_os.utility.*;
import com.hospital_os.object.*;

import com.pcu.objdb.objdbclass.FamilyDB;
import com.pcu.object.Family;
import java.util.*;
import java.sql.*;
import java.text.*; 

public class PatientDB
{
    public ConnectionInf theConnectionInf;
    public Patient dbObj;
    final public String idtable = "206";/*"183";*/
    protected String sqlcon ="";
    protected ResultSet rs;
    protected int icount;
    protected boolean bresult = false;
    protected Vector vHN;

    private FamilyDB theFamilyDB;
    /**
     * @param ConnectionInf db
     * @roseuid 3F65897F0326
     */
    public PatientDB(ConnectionInf db)
    {
        theConnectionInf=db;
        initConfig();
    }
    /**
     */
    public PatientDB(ConnectionInf db,FamilyDB fdb)
    {
        theConnectionInf=db;
        initConfig();
        theFamilyDB = fdb;
    }
    public boolean initConfig()
    {
        dbObj = getMapObject();
        return true;
    }
    public static Patient getMapObject()
    {
        Patient dbObj = new Patient();
        dbObj.table="t_patient";
        dbObj.pk_field="t_patient_id";
        dbObj.hn   ="patient_hn";
        dbObj.prefix_id   ="f_patient_prefix_id";
        dbObj.fname   ="patient_firstname";
        dbObj.lname   ="patient_lastname";
        dbObj.xn   ="patient_xn";
        dbObj.sex   ="f_sex_id";
        dbObj.birthday   ="patient_birthday";
        dbObj.house   ="patient_house";
        dbObj.road   ="patient_road";
        dbObj.village   ="patient_moo";
        dbObj.tambon   ="patient_tambon";
        dbObj.ampur   ="patient_amphur";
        dbObj.changwat   ="patient_changwat";
        dbObj.mstatus   ="f_patient_marriage_status_id";
        dbObj.occupa   ="f_patient_occupation_id";
        dbObj.race   ="f_patient_race_id";
        dbObj.nation   ="f_patient_nation_id";
        dbObj.religion   ="f_patient_religion_id";
        dbObj.education   ="f_patient_education_type_id";
        dbObj.fstatus   ="f_patient_family_status_id";
        dbObj.father_fname   ="patient_father_firstname";
        dbObj.mother_fname   ="patient_mother_firstname";
        dbObj.couple_fname   ="patient_couple_firstname";
        dbObj.move_in   ="patient_move_in_date_time";
        dbObj.dischar   ="f_patient_discharge_status_id";
        dbObj.ddisch   ="patient_discharge_date_time";
        dbObj.bgroup   ="f_patient_blood_group_id";
        dbObj.labor   ="f_patient_foreigner_id";
        dbObj.typearea   ="f_patient_area_status_id";
        dbObj.cid_f   ="patient_father_pid";
        dbObj.cif_m   ="patient_mather_pid";
        dbObj.cid_couple   ="patient_couple_pid";
        dbObj.p_type   ="patient_community_status";
        dbObj.private_doc   ="patient_private_doctor";
        dbObj.pid   ="patient_pid";
        dbObj.mother_lname   ="patient_mother_lastname";
        dbObj.father_lname   ="patient_father_lastname";
        dbObj.couple_lname   ="patient_couple_lastname";
        dbObj.phone   ="patient_phone_number";
        dbObj.relation   ="f_patient_relation_id";
        dbObj.phone_contact   ="patient_contact_phone_number";
        dbObj.sex_contact   ="patient_contact_sex_id";
        dbObj.house_contact   ="patient_contact_house";
        dbObj.village_contact   ="patient_contact_moo";
        dbObj.changwat_contact   ="patient_contact_changwat";
        dbObj.ampur_contact   ="patient_contact_amphur";
        dbObj.tambon_contact   ="patient_contact_tambon";
        dbObj.road_contact   ="patient_contact_road";
        dbObj.contact_fname   ="patient_contact_firstname";
        dbObj.contact_lname   ="patient_contact_lastname";
        dbObj.true_birthday ="patient_birthday_true";
        
        dbObj.record_date_time = "patient_record_date_time";
        dbObj.update_date_time = "patient_update_date_time";
        dbObj.staff_record = "patient_staff_record";
        dbObj.staff_modify = "patient_staff_modify";
        dbObj.staff_cancel = "patient_staff_cancel";
        dbObj.patient_drugallergy = "patient_drugallergy";
        dbObj.active = "patient_active";
        //dbObj.has_health_home = "patient_has_home_in_pcu";
        dbObj.family_id = "t_health_family_id";
        
        dbObj.mobile_phone = "patient_patient_mobile_phone";
        dbObj.contact_mobile_phone = "patient_contact_mobile_phone";
        dbObj.other_address = "patient_other_country_address";
        dbObj.is_other_country = "patient_is_other_country";
        return dbObj;
    }
    
    
/////////////////////////////////////////////////////////////////////////////    
    public int updateFidByFid(String family_id,String family_from) throws Exception
    {
        String sql = "update " + dbObj.table + " set "
                + dbObj.family_id + "='" + family_id + "','"
                + dbObj.staff_cancel + "="+ dbObj.staff_cancel + "||-||'" + family_from + "'"
                + " where "
                + dbObj.family_id + "='" + family_from +"'";
        return theConnectionInf.eUpdate(sql);
    }  
    public int updateFidByPtid(String family_id,String patient_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                ).append( dbObj.family_id ).append( "='" ).append( family_id
                ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( patient_id ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    } 

    public int insert(Patient p) throws Exception            
    {
        p.updateF2P();
         p.generateOID(idtable);
         StringBuffer sql = new StringBuffer("insert into " ).append( dbObj.table ).append( " ("
         ).append( dbObj.pk_field
         ).append( " ,"	).append( dbObj.hn
         ).append( " ,"	).append( dbObj.prefix_id
         ).append( " ,"	).append( dbObj.fname
         ).append( " ,"	).append( dbObj.lname
         ).append( " ,"	).append( dbObj.xn
         ).append( " ,"	).append( dbObj.sex
         ).append( " ,"	).append( dbObj.birthday
         ).append( " ,"	).append( dbObj.house
         ).append( " ,"	).append( dbObj.road
         ).append( " ,"	).append( dbObj.village
         ).append( " ,"	).append( dbObj.tambon
         ).append( " ,"	).append( dbObj.ampur
         ).append( " ,"	).append( dbObj.changwat
         ).append( " ,"	).append( dbObj.mstatus
         ).append( " ,"	).append( dbObj.occupa
         ).append( " ,"	).append( dbObj.race
         ).append( " ,"	).append( dbObj.pid
         ).append( " ,"	).append( dbObj.nation
         ).append( " ,"	).append( dbObj.religion
         ).append( " ,"	).append( dbObj.education
         ).append( " ,"	).append( dbObj.fstatus
         ).append( " ,"	).append( dbObj.father_fname
         ).append( " ,"	).append( dbObj.mother_fname
         ).append( " ,"	).append( dbObj.father_lname
         ).append( " ,"	).append( dbObj.mother_lname
         ).append( " ,"	).append( dbObj.couple_fname
         ).append( " ,"	).append( dbObj.couple_lname
         ).append( " ,"	).append( dbObj.move_in
         ).append( " ,"	).append( dbObj.dischar
         ).append( " ,"	).append( dbObj.ddisch
         ).append( " ,"	).append( dbObj.bgroup
         ).append( " ,"	).append( dbObj.labor
         ).append( " ,"	).append( dbObj.typearea
         ).append( " ,"	).append( dbObj.cid_f
         ).append( " ,"	).append( dbObj.cif_m
         ).append( " ,"	).append( dbObj.cid_couple
         ).append( " ,"	).append( dbObj.p_type
         ).append( " ,"	).append( dbObj.private_doc
         ).append( " ,"	).append( dbObj.phone
         ).append( " ,"	).append( dbObj.relation
         ).append( " ,"	).append( dbObj.sex_contact
         ).append( " ,"	).append( dbObj.house_contact
         ).append( " ,"	).append( dbObj.village_contact
         ).append( " ,"	).append( dbObj.road_contact
         ).append( " ,"	).append( dbObj.phone_contact
         ).append( " ,"	).append( dbObj.changwat_contact
         ).append( " ,"	).append( dbObj.ampur_contact
         ).append( " ,"	).append( dbObj.tambon_contact
         ).append( " ,"	).append( dbObj.contact_fname
         ).append( " ,"	).append( dbObj.contact_lname
         ).append( " ,"	).append( dbObj.patient_drugallergy
         ).append( " ,"	).append( dbObj.true_birthday
         ).append( " ,"	).append( dbObj.record_date_time
         ).append( " ,"	).append( dbObj.update_date_time
         ).append( " ,"	).append( dbObj.staff_record
         ).append( " ,"	).append( dbObj.staff_modify
         ).append( " ,"	).append( dbObj.staff_cancel
         ).append( " ,"	).append( dbObj.active
         //).append( " ,"	).append( dbObj.has_health_home
         ).append( " ,"	).append( dbObj.family_id
         //).append( " ,"	).append( dbObj.age
         //).append( " ,"	).append( dbObj.main_hospital
         ).append( " ,"	).append( dbObj.mobile_phone
         ).append( " ,"	).append( dbObj.contact_mobile_phone
         ).append( " ,"	).append( dbObj.other_address
         ).append( " ,"	).append( dbObj.is_other_country
         ).append( " ) values ('"
         ).append( p.getObjectId()
         ).append( "','" ).append( p.hn
         ).append( "','" ).append( p.prefix_id
         ).append( "','" ).append( p.fname
         ).append( "','" ).append( p.lname
         ).append( "','" ).append( p.xn
         ).append( "','" ).append( p.sex
         ).append( "','" ).append( p.birthday
         ).append( "','" ).append( p.house
         ).append( "','" ).append( p.road
         ).append( "','" ).append( p.village
         ).append( "','" ).append( p.tambon
         ).append( "','" ).append( p.ampur
         ).append( "','" ).append( p.changwat
         ).append( "','" ).append( p.mstatus
         ).append( "','" ).append( p.occupa
         ).append( "','" ).append( p.race
         ).append( "','" ).append( p.pid.trim()
         ).append( "','" ).append( p.nation
         ).append( "','" ).append( p.religion
         ).append( "','" ).append( p.education
         ).append( "','" ).append( p.fstatus
         ).append( "','" ).append( p.father_fname
         ).append( "','" ).append( p.mother_fname
         ).append( "','" ).append( p.father_lname
         ).append( "','" ).append( p.mother_lname
         ).append( "','" ).append( p.couple_fname
         ).append( "','" ).append( p.couple_lname
         ).append( "','" ).append( p.move_in
         ).append( "','" ).append( p.dischar
         ).append( "','" ).append( p.ddisch
         ).append( "','" ).append( p.bgroup
         ).append( "','" ).append( p.labor
         ).append( "','" ).append( p.typearea
         ).append( "','" ).append( p.cid_f
         ).append( "','" ).append( p.cif_m
         ).append( "','" ).append( p.cid_couple
         ).append( "','" ).append( p.p_type
         ).append( "','" ).append( p.private_doc
         ).append( "','" ).append( p.phone
         ).append( "','" ).append( p.relation
         ).append( "','" ).append( p.sex_contact
         ).append( "','" ).append( p.house_contact
         ).append( "','" ).append( p.village_contact
         ).append( "','" ).append( p.road_contact
         ).append( "','" ).append( p.phone_contact
         ).append( "','" ).append( p.changwat_contact
         ).append( "','" ).append( p.ampur_contact
         ).append( "','" ).append( p.tambon_contact
         ).append( "','" ).append( p.contact_fname
         ).append( "','" ).append( p.contact_lname
         ).append( "','"	).append( p.patient_drugallergy
         ).append( "','" ).append( p.true_birthday
         ).append( "','"	).append( p.record_date_time
         ).append( "','"	).append( p.update_date_time
         ).append( "','"	).append( p.staff_record
         ).append( "','"	).append( p.staff_modify
         ).append( "','"	).append( p.staff_cancel
         ).append( "','"	).append( p.active
         //).append( "','"	).append( p.has_health_home
         ).append( "','"	).append( p.family_id
         //).append( "','"	).append( p.age
         //).append( "','"	).append( p.main_hospital
         ).append( "','"	).append( p.mobile_phone
         ).append( "','"	).append( p.contact_mobile_phone
        ).append( "','"	).append( p.other_address
        ).append( "','"	).append( p.is_other_country
         ).append( "')");
         return theConnectionInf.eUpdate(sql.toString());
    }
    /*///////////////////////////////////////////////////////////////////////////////////
*/
    public int updateParent(Patient o) throws Exception
    {
        update(o);
        if(o.getFamily()==null)
            return 0;
        return theFamilyDB.update(o.getFamily());
    }
    public int update(Patient p) throws Exception
    {
        p.updateF2P();
         StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                 ).append( dbObj.hn ).append( "='" ).append( p.hn
         ).append( "', " ).append( dbObj.prefix_id ).append( "='" ).append( p.prefix_id
         ).append( "', " ).append( dbObj.fname ).append( "='" ).append( p.fname
         ).append( "', " ).append( dbObj.lname ).append( "='" ).append( p.lname
         ).append( "', " ).append( dbObj.xn ).append( "='" ).append( p.xn
         ).append( "', " ).append( dbObj.sex ).append( "='" ).append( p.sex
         ).append( "', " ).append( dbObj.birthday ).append( "='" ).append( p.birthday
         ).append( "', " ).append( dbObj.house ).append( "='" ).append( p.house
         ).append( "', " ).append( dbObj.road ).append( "='" ).append( p.road
         ).append( "', " ).append( dbObj.village ).append( "='" ).append( p.village
         ).append( "', " ).append( dbObj.tambon ).append( "='" ).append( p.tambon
         ).append( "', " ).append( dbObj.ampur ).append( "='" ).append( p.ampur
         ).append( "', " ).append( dbObj.changwat ).append( "='" ).append( p.changwat
         ).append( "', " ).append( dbObj.mstatus ).append( "='" ).append( p.mstatus
         ).append( "', " ).append( dbObj.occupa ).append( "='" ).append( p.occupa
         ).append( "', " ).append( dbObj.race ).append( "='" ).append( p.race
         ).append( "', " ).append( dbObj.pid ).append( "='" ).append( p.pid.trim()
         ).append( "', " ).append( dbObj.nation ).append( "='" ).append( p.nation
         ).append( "', " ).append( dbObj.religion ).append( "='" ).append( p.religion
         ).append( "', " ).append( dbObj.education ).append( "='" ).append( p.education
         ).append( "', " ).append( dbObj.fstatus ).append( "='" ).append( p.fstatus
         ).append( "', " ).append( dbObj.father_fname ).append( "='" ).append( p.father_fname
         ).append( "', " ).append( dbObj.mother_fname ).append( "='" ).append( p.mother_fname
         ).append( "', " ).append( dbObj.father_lname ).append( "='" ).append( p.father_lname
         ).append( "', " ).append( dbObj.mother_lname ).append( "='" ).append( p.mother_lname
         ).append( "', " ).append( dbObj.couple_fname ).append( "='" ).append( p.couple_fname
         ).append( "', " ).append( dbObj.couple_lname ).append( "='" ).append( p.couple_lname
         ).append( "', " ).append( dbObj.move_in ).append( "='" ).append( p.move_in
         ).append( "', " ).append( dbObj.dischar ).append( "='" ).append( p.dischar
         ).append( "', " ).append( dbObj.ddisch ).append( "='" ).append( p.ddisch
         ).append( "', " ).append( dbObj.bgroup ).append( "='" ).append( p.bgroup
         ).append( "', " ).append( dbObj.labor ).append( "='" ).append( p.labor
         ).append( "', " ).append( dbObj.typearea ).append( "='" ).append( p.typearea
         ).append( "', " ).append( dbObj.cid_f ).append( "='" ).append( p.cid_f
         ).append( "', " ).append( dbObj.cif_m ).append( "='" ).append( p.cif_m
         ).append( "', " ).append( dbObj.cid_couple ).append( "='" ).append( p.cid_couple
         ).append( "', " ).append( dbObj.p_type ).append( "='" ).append( p.p_type
         ).append( "', " ).append( dbObj.private_doc ).append( "='" ).append( p.private_doc
         ).append( "', " ).append( dbObj.phone ).append( "='" ).append( p.phone
         ).append( "', " ).append( dbObj.relation ).append( "='" ).append( p.relation
         ).append( "', " ).append( dbObj.sex_contact ).append( "='" ).append( p.sex_contact
         ).append( "', " ).append( dbObj.house_contact ).append( "='" ).append( p.house_contact
         ).append( "', " ).append( dbObj.village_contact ).append( "='" ).append( p.village_contact
         ).append( "', " ).append( dbObj.road_contact ).append( "='" ).append( p.road_contact
         ).append( "', " ).append( dbObj.phone_contact ).append( "='" ).append( p.phone_contact
         ).append( "', " ).append( dbObj.changwat_contact ).append( "='" ).append( p.changwat_contact
         ).append( "', " ).append( dbObj.ampur_contact ).append( "='" ).append( p.ampur_contact
         ).append( "', " ).append( dbObj.tambon_contact ).append( "='" ).append( p.tambon_contact
         ).append( "', " ).append( dbObj.contact_fname ).append( "='" ).append( p.contact_fname
         ).append( "', " ).append( dbObj.contact_lname ).append( "='" ).append( p.contact_lname
         ).append( "', " ).append( dbObj.patient_drugallergy ).append( "='" ).append( p.patient_drugallergy
         ).append( "', " ).append( dbObj.true_birthday ).append( "='" ).append( p.true_birthday
         ).append( "', " ).append( dbObj.record_date_time ).append( "='" ).append( p.record_date_time
         ).append( "', " ).append( dbObj.update_date_time ).append( "='" ).append( p.update_date_time
         ).append( "', " ).append( dbObj.staff_record ).append( "='" ).append( p.staff_record
         ).append( "', " ).append( dbObj.staff_modify ).append( "='" ).append( p.staff_modify
         ).append( "', " ).append( dbObj.staff_cancel ).append( "='" ).append( p.staff_cancel
         ).append( "', " ).append( dbObj.active ).append( "='" ).append( p.active
         //).append( "', " ).append( dbObj.has_health_home ).append( "='" ).append( p.has_health_home
         ).append( "', " ).append( dbObj.family_id ).append( "='" ).append( p.family_id
         //).append( "', " ).append( dbObj.age ).append( "='" ).append( p.age
         //).append( "', " ).append( dbObj.main_hospital ).append( "='" ).append( p.main_hospital
         ).append( "', " ).append( dbObj.mobile_phone ).append( "='" ).append( p.mobile_phone
         ).append( "', " ).append( dbObj.contact_mobile_phone ).append( "='" ).append( p.contact_mobile_phone
         ).append( "', " ).append( dbObj.other_address ).append( "='" ).append( p.other_address
         ).append( "', " ).append( dbObj.is_other_country ).append( "='" ).append( p.is_other_country
         ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
         
         return theConnectionInf.eUpdate(sql.toString());
    }
    public int updateXN(String xn) throws Exception
    {  
         StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                 ).append( dbObj.xn ).append( "='" ).append( xn  ).append( "'");
         return theConnectionInf.eUpdate(sql.toString());
    }
    public int updateXN(Patient pat) throws Exception
    {    
         StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                 ).append( dbObj.xn ).append( "='" ).append( pat.xn  ).append( "'"
                 ).append( " where " ).append( dbObj.pk_field ).append( "= '" ).append( pat.getObjectId() ).append( "'");
         return theConnectionInf.eUpdate(sql.toString());
    }    
    /*////////////////////////////////////////////////////////////////////////////
*/
    public int updateFamilyHome(Patient p) throws Exception
    {    
         StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
         ).append( dbObj.family_id ).append( "='" ).append( p.family_id
         //).append( "', " ).append( dbObj.has_health_home ).append( "='" ).append( p.has_health_home
         ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
         
         return theConnectionInf.eUpdate(sql.toString());
    }    
    /*////////////////////////////////////////////////////////////////////////////
*/
    public int updatePatientDischar(Patient o) throws Exception
    {
        o.updateF2P();
         StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                 ).append( dbObj.dischar ).append( " = '" ).append( o.dischar ).append( "'"
                 ).append(",").append( dbObj.ddisch ).append( " = '" ).append( o.ddisch ).append( "'"
                 ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( o.getObjectId()).append("'");
         return theConnectionInf.eUpdate(sql.toString());
    }
    public int updateFamilyID(Patient o) throws Exception
    {
         StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append(
                 " set " ).append( dbObj.family_id ).append( " = '" ).append( o.family_id ).append( "'" ).append(
                 " where " ).append( dbObj.pk_field ).append( "='").append( o.getObjectId()).append("'");
         return theConnectionInf.eUpdate(sql.toString());
    }
    public String selectPatientSexByPatientID(String patient_id) throws Exception
    {
        StringBuffer sql = new StringBuffer( "Select ").append( dbObj.sex ).append( " From " ).append( dbObj.table ).append( "" ).append(
        " Where " ).append(dbObj.pk_field).append( "='" ).append( patient_id ).append("'");
        Vector vc = eQuerySex(sql.toString());
        
        if(vc.size() ==0)
        {    vc = null;
             return "1";
        }
        else
        {    String sex = ((Patient)vc.get(0)).sex;
             return sex;
        }
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public int delete(Patient o) throws Exception
    {   
        StringBuffer sql = new StringBuffer("delete from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( o.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    public int updateAllergy(String patient_id, String allergy) throws Exception
    {
        StringBuffer sql = new StringBuffer( "UPDATE " ).append( dbObj.table ).append( " SET " ).append(
        " " ).append( dbObj.patient_drugallergy ).append( " = '").append( allergy ).append( "'" ).append(
        " WHERE " ).append( dbObj.pk_field ).append( "= '" ).append( patient_id ).append( "'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    /**
     *@deprecated henbe unused
     */
    public int setPatientAllergyByPatientID(String patient_id, String allergy) throws Exception
    {
        StringBuffer sql = new StringBuffer( "UPDATE " ).append( dbObj.table ).append( " SET " ).append(
        " " ).append( dbObj.patient_drugallergy ).append( " = '").append( allergy ).append( "'" ).append(
        " WHERE " ).append( dbObj.pk_field ).append( "= '" ).append( patient_id ).append( "'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public ResultSet selectData() throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table ).append( " where " ).append( dbObj.active ).append( " ='1'");
        
        return theConnectionInf.eQuery(sql.toString());
        
    }
    

    /**
     * 
     * �鹼����¨ҡ�Ţ��Ъҡ�
     */
    public Patient selectByFid(String family_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.family_id ).append( " = '" ).append( family_id
                ).append( "' and ").append( dbObj.active ).append( " = '1'");
        
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Patient selectByPatientID(String patientid) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field
        ).append( " = '" ).append( patientid ).append( "'");
        
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;
    }
    /*////////////////////////////////////////////////////////////////////////////////////*/
    public String selectMaxHN() throws Exception
    {
        StringBuffer sql = new StringBuffer( "Select MAX(" ).append(dbObj.hn ).append( ") as max From " ).append( dbObj.table);
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        if(rs.next())
           return rs.getString(1);
        return "0";
    }    
    /*////////////////////////////////////////////////////////////////////////////
     *@deprecated henbe unused ��������� �Թ˹��¤������٧�ҡ�ѧ�ѹ���
*/
    public Vector select() throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table ).append( " where " ).append( dbObj.active ).append( " ='1'");
        
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    public int updateActiveByPatientID(Patient patient) throws Exception
    {
        StringBuffer sql = new StringBuffer( "UPDATE " ).append( dbObj.table ).append( " Set "
                ).append( dbObj.active ).append( "='" ).append(patient. active ).append("'" ).append(
        "," ).append( dbObj.update_date_time ).append( "='" ).append( patient.update_date_time ).append( "'" ).append(
        "," ).append( dbObj.staff_cancel  ).append( "='" ).append( patient.staff_cancel ).append( "'" ).append(
        "," ).append( dbObj.p_type  ).append( "='" ).append( patient.p_type ).append( "'" ).append(
        " WHERE " ).append( dbObj.pk_field ).append( "='" ).append( patient.getObjectId() ).append( "'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectByPKV(String pk) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field
        ).append( " = '" ).append( pk ).append( "'" ).append(
        " and " ).append( dbObj.active ).append( " ='1'");
        
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    
 
    /*////////////////////////////////////////////////////////////////////////////*/
    // ��Ѻ�����Ҵ��� %hn sumo 18/7/2549
    public Vector queryByHn(String hn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.hn
        ).append( " like '%" ).append( hn ).append( "'" ).append(
        " and " ).append(  dbObj.active ).append( " ='1'");
        
        return eQuery(sql.toString());
    }
    /**
     *@deprecated henbe used public Vector selectLikeHN(String hn,String active) throws Exception
     **/
    public Vector selectLikeHN(String hn) throws Exception
    {
        return selectLikeHN(hn,"1");
    }
    public Vector selectLikeHN(String hn,String active) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.hn ).append( " like '" ).append( hn ).append( "'");
        if(!active.equals(""))
            sql.append(" and " ).append(  dbObj.active ).append( " ='").append(active).append("'");
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector queryByName(String pname,String fname,String lname) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.prefix_id ).append( " like '" ).append( pname ).append( "' and "
        ).append( dbObj.fname ).append( " like '" ).append( fname ).append( "' and "
        ).append( dbObj.lname ).append( " like '" ).append( lname ).append( "' " ).append(
        " and " ).append( dbObj.active ).append( " ='1' " ).append(
                "order by " ).append(  dbObj.fname);
        
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector queryByFName(String fname) throws Exception
    {
        StringBuffer sql = new StringBuffer("select "
        ).append( dbObj.hn ).append( ","
        ).append( dbObj.fname ).append( ","
        ).append( dbObj.lname ).append( ","
        ).append( dbObj.mother_fname
        ).append( " from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.fname ).append( " like '" ).append( fname ).append( "' " ).append(
        " and " ).append(  dbObj.active ).append( " ='1' " )
                .append( "order by " ).append(  dbObj.fname);
        
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////*/
    public Vector queryBySName(String lname) throws Exception
    {
        StringBuffer sql = new StringBuffer("select "
        ).append( dbObj.hn ).append( ","
        ).append( dbObj.fname ).append( ","
        ).append( dbObj.lname ).append( ","
        ).append( dbObj.mother_fname
        ).append( " from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.lname ).append( " like '" ).append( lname ).append( "' ").append(
        " and " ).append(  dbObj.active ).append( " ='1' " );
        
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector eQuerySex(String sql) throws Exception
    {
        Patient p;
        Vector list = new Vector();
        rs = theConnectionInf.eQuery(sql.toString());
        int i = 0;
        while(rs.next())
        {
            p = new Patient();
            p.sex = rs.getString(dbObj.sex);
            
            list.add(p);
            i=i+1;
            if(i == 100)
                break;
        }
        rs.close();
        return list;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public String selectNamePatientbyPatintID(String patient_id) throws Exception
    {
        StringBuffer sql = new StringBuffer( "Select ").append( dbObj.fname ).append( "," ).append( dbObj.lname ).append( " FROM " ).append(
        "" ).append( dbObj.table ).append( " WHERE ").append( dbObj.pk_field ).append( " ='" ).append( patient_id ).append( "'");
        
        return eQueryNamePatient(sql.toString());
        
    }
    
    public String selectHNPatientbyPatintID(String patient_id) throws Exception
    {
        StringBuffer sql = new StringBuffer( "Select ").append( dbObj.hn ).append( " FROM " ).append(
        "" ).append( dbObj.table ).append( " WHERE ").append( dbObj.pk_field ).append( " ='" ).append( patient_id ).append( "'");
        
        return eQueryHNPatient(sql.toString());
        
    }
    
    public String eQueryNamePatient(String sql) throws Exception
    {
        Patient p = null;
        
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            p = new Patient();
            
            p.fname = rs.getString(dbObj.fname);
            p.lname = rs.getString(dbObj.lname);
            
        }
        if(p != null)
            return p.fname + " " + p.lname;
        else
            return null;
    }
    public String eQueryHNPatient(String sql) throws Exception
    {
        Patient p = null;
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        int i = 0;
        while(rs.next())
        {
            p = new Patient();
            p.hn = rs.getString(dbObj.hn);
        }
        if(p != null)
            return p.hn;
        else
            return null;
    }
    public static String getStringFromRS(ResultSet rs,String field_name) throws Exception
    {
        String str = rs.getString(field_name);
        if(str!=null)
            return str;
        else
            return "";
    }
    
    /*///////////////////////////////////////////////////////*/
    public Vector eQuery(String sql) throws Exception
    {
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        int i=0;
        while(rs.next())
        {
            Patient p = new Patient();
            getObject(dbObj, p, rs);
            list.add(p);
            i=i+1;
            if(i == 100)
                break;
        }
        rs.close();
        return list;
    }
    public Vector eQueryNolimit(String sql) throws Exception
    {
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        while(rs.next())
        {
            Patient p = new Patient();
            getObject(dbObj, p, rs);
            Family fm = theFamilyDB.selectByPK(p.family_id);
            p.setFamily(fm);
            list.add(p);
        }
        rs.close();
        return list;
    }
    public boolean getPatient(Patient p,ResultSet rs)throws Exception
    {
        return getObject(dbObj,p,rs);
    }
    public static boolean getObject(Patient dbObj,Patient p,ResultSet rs)throws Exception
    {
            p.setObjectId(getStringFromRS(rs,dbObj.pk_field));
            p.hn = getStringFromRS(rs,dbObj.hn);
            p.prefix_id = getStringFromRS(rs,dbObj.prefix_id);
            p.fname = getStringFromRS(rs,dbObj.fname);
            p.patient_name = getStringFromRS(rs,dbObj.fname);
            p.lname = getStringFromRS(rs,dbObj.lname);
            p.patient_last_name = getStringFromRS(rs,dbObj.lname);
            p.xn = getStringFromRS(rs,dbObj.xn);
            p.sex = getStringFromRS(rs,dbObj.sex);
            p.birthday = getStringFromRS(rs,dbObj.birthday);
            p.patient_birthday = getStringFromRS(rs,dbObj.birthday);
            p.mother_firstname = getStringFromRS(rs,dbObj.mother_fname);
            p.house = getStringFromRS(rs,dbObj.house);
            p.road = getStringFromRS(rs,dbObj.road);
            p.village = getStringFromRS(rs,dbObj.village);
            p.tambon = getStringFromRS(rs,dbObj.tambon);
            p.ampur = getStringFromRS(rs,dbObj.ampur);
            p.changwat = getStringFromRS(rs,dbObj.changwat);
            p.mstatus = getStringFromRS(rs,dbObj.mstatus);
            p.occupa = getStringFromRS(rs,dbObj.occupa);
            p.race = getStringFromRS(rs,dbObj.race);
            p.pid = getStringFromRS(rs,dbObj.pid).trim();
            p.nation = getStringFromRS(rs,dbObj.nation);
            p.religion = getStringFromRS(rs,dbObj.religion);
            p.education = getStringFromRS(rs,dbObj.education);
            p.fstatus = getStringFromRS(rs,dbObj.fstatus);
            p.father_fname = getStringFromRS(rs,dbObj.father_fname);
            p.mother_fname = getStringFromRS(rs,dbObj.mother_fname);
            p.father_lname = getStringFromRS(rs,dbObj.father_lname);
            p.mother_lname = getStringFromRS(rs,dbObj.mother_lname);
            p.couple_fname = getStringFromRS(rs,dbObj.couple_fname);
            p.couple_lname = getStringFromRS(rs,dbObj.couple_lname);
            p.move_in = getStringFromRS(rs,dbObj.move_in);
            p.dischar = getStringFromRS(rs,dbObj.dischar);
            p.ddisch = getStringFromRS(rs,dbObj.ddisch);
            p.bgroup = getStringFromRS(rs,dbObj.bgroup);
            p.labor = getStringFromRS(rs,dbObj.labor);
            p.typearea = getStringFromRS(rs,dbObj.typearea);
            p.cid_f = getStringFromRS(rs,dbObj.cid_f);
            p.cif_m = getStringFromRS(rs,dbObj.cif_m);
            p.cid_couple = getStringFromRS(rs,dbObj.cid_couple);
            p.p_type = getStringFromRS(rs,dbObj.p_type);
            p.private_doc = getStringFromRS(rs,dbObj.private_doc);
            p.phone = getStringFromRS(rs,dbObj.phone);
            p.relation = getStringFromRS(rs,dbObj.relation);
            p.sex_contact = getStringFromRS(rs,dbObj.sex_contact);
            p.house_contact = getStringFromRS(rs,dbObj.house_contact);
            p.village_contact = getStringFromRS(rs,dbObj.village_contact);
            p.road_contact = getStringFromRS(rs,dbObj.road_contact);
            p.phone_contact = getStringFromRS(rs,dbObj.phone_contact);
            p.changwat_contact = getStringFromRS(rs,dbObj.changwat_contact);
            p.ampur_contact = getStringFromRS(rs,dbObj.ampur_contact);
            p.tambon_contact = getStringFromRS(rs,dbObj.tambon_contact);
            p.contact_fname = getStringFromRS(rs,dbObj.contact_fname);
            p.contact_lname = getStringFromRS(rs,dbObj.contact_lname);
            p.true_birthday = getStringFromRS(rs,dbObj.true_birthday);
            p.patient_drugallergy = getStringFromRS(rs,dbObj.patient_drugallergy);
            p.record_date_time = getStringFromRS(rs,dbObj.record_date_time);
            p.update_date_time = getStringFromRS(rs,dbObj.update_date_time);
            p.staff_record = getStringFromRS(rs,dbObj.staff_record);
            p.staff_modify = getStringFromRS(rs,dbObj.staff_modify);
            p.staff_cancel = getStringFromRS(rs,dbObj.staff_cancel);
            p.active = getStringFromRS(rs,dbObj.active);
            //p.has_health_home = getStringFromRS(rs,dbObj.has_health_home);
            p.family_id = getStringFromRS(rs,dbObj.family_id);
            //p.age = getStringFromRS(rs,dbObj.age);
            //p.main_hospital = getStringFromRS(rs,dbObj.main_hospital);
            p.mobile_phone = getStringFromRS(rs,dbObj.mobile_phone);
            p.contact_mobile_phone = getStringFromRS(rs,dbObj.contact_mobile_phone);
            p.other_address = getStringFromRS(rs,dbObj.other_address);
            p.is_other_country = getStringFromRS(rs,dbObj.is_other_country);
            return true;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector queryByFLName(String fname,String lname) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.fname ).append( " like '" ).append( fname ).append( "' and "
        ).append( dbObj.lname ).append( " like '" ).append( lname ).append( "' " ).append(
        " and " ).append(  dbObj.active ).append( " ='1' " );
        
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector queryPid(String pid) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.pid ).append( " = '" ).append( pid ).append( "'").append(
        " and " ).append(  dbObj.active ).append( " ='1' " );
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector queryFPid(String fpid) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.pid ).append( " = '" ).append( fpid ).append( "'").append(
        " and " ).append(  dbObj.active ).append( " ='1' " );
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector queryMPid(String mpid) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.pid ).append( " = '" ).append( mpid ).append( "'").append(
        " and " ).append(  dbObj.active ).append( " ='1' " );
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector queryCPid(String cpid) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where "
        ).append( dbObj.pid ).append( " = '" ).append( cpid ).append( "'").append(
        " and " ).append(  dbObj.active ).append( " ='1' " );
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    
    public int countPatientByHN(String HN) throws Exception
    {
        StringBuffer sql = new StringBuffer( "SELECT COUNT(").append(dbObj.hn ).append(") as count" ).append(
                    " FROM " ).append( dbObj.table ).append( "" ).append(
                    " WHERE " ).append( dbObj.hn ).append( " LIKE '%" ).append( HN ).append("'");
        /*Constant.println(sql.toString());
*/
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        int count =0;
       
        while(rs.next())
        {
            count = rs.getInt("count");
        }
        rs.close();
        rs = null;
        return count;
        
    }
   //////////////////////////////////////////////////////////////////////////////
    public int selectCountHN(String hn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select count(*) as cnt from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.hn ).append( " = '" ).append( hn ).append( "'"
        ).append( " and " ).append( dbObj.active ).append( " = '1'");
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        if(rs.next())
            return rs.getInt("cnt");
        return 0;
    }
   //////////////////////////////////////////////////////////////////////////////
    public int selectCountPID(String pid) throws Exception
    {
        StringBuffer sql = new StringBuffer("select count(*) as cnt from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pid ).append( " = '" ).append( pid ).append( "'"
        ).append( " and " ).append( dbObj.active ).append( " = '1'");
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        if(rs.next())
            return rs.getInt("cnt");
        return 0;
    }
   //////////////////////////////////////////////////////////////////////////////
    public Patient selectByHnEqual(String hn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.hn ).append( " = '" ).append( hn ).append( "'");
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;
    }
    //////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////
    // ��Ѻ�����Ҵ��� %hn sumo 18/7/2549
    public Patient selectByHn(String hn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.hn
        ).append( " like '%" ).append( hn ).append( "'" ).append(
        " and " ).append(  dbObj.active ).append( " ='1'");
        
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;
    }  
  //////////////////////////////////////////////////////////////////////////////
    public Vector selectByXN(String xn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.xn
        ).append( " = '" ).append( xn ).append( "' and " ).append(  dbObj.active ).append( " ='1'");
        return eQuery(sql.toString());
    }      
  //////////////////////////////////////////////////////////////////////////////
    public Patient selectByPK(String pk) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field
        ).append( " = '" ).append( pk ).append( "'");
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;

    }
    public Patient selectByFamilyID(String fid) throws Exception
    {
        String sql = "select * from " + dbObj.table + " where " + dbObj.family_id + " = '"+fid+"'";
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;
    }
    /**
     * @deprecated henbe unused
     * @param pk
     * @return
     * @throws Exception
     */
    public Patient selectParentByPK(String pk) throws Exception
    {
        Patient pt = selectByPK(pk);    
        Family fm = null;
        if(!pt.family_id.equals(""))
            fm = theFamilyDB.selectByPK(pt.family_id);
        pt.setFamily(fm);
        return pt;
    }

    /**
     * ��㹡������� xn �������������������ի�ӡѺ�ͧ��������������ѧ ��ҫ�����ǡ���� return �� false
     * ����ѧ��� ��ӡ���� return �� true
     * @param xn �� String �ͧ�Ţ xn ������ 
     * @return �� boolean ��ҫ�����ǡ���� return �� false
     * ����ѧ��� ��ӡ���� return �� true
     * @author padungrat(tong)
     * @date 21/04/2549,11:22
     */
    public Vector checkSamePatientXn(String xn,String patient_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("SELECT " ).append( dbObj.hn ).append( " as count FROM " ).append( dbObj.table
                ).append( " WHERE UPPER(" ).append( dbObj.xn ).append( ") LIKE UPPER('" ).append( xn ).append( "') "
                ).append( " AND " ).append( dbObj.active ).append( " = '" ).append( Active.isEnable() ).append( "'"
                ).append( " AND " ).append( dbObj.pk_field ).append( " <> '" ).append( patient_id ).append( "'");
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
       
        bresult = false;
        vHN = new Vector();
        String hn = new String();
        while(rs.next())
        {
            hn = rs.getString(1);
            vHN.add(hn);
            hn = null;
            
        }
        hn = null;
        rs.close();
        
        return vHN;
    }
//////////////////////////////////////////////////////////////////////////////
    public Vector selectLikeXn(String pk) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.xn
        ).append( " like '" ).append( pk ).append( "'"
        ).append( " and " ).append( dbObj.active ).append( " ='1' ");
//        StringBuffer sql = new StringBuffer( "select * from t_patient where patient_xn like '%").append(pk).append("%'");
        return eQuery(sql.toString());
    } 
//////////////////////////////////////////////////////////////////////////////
    public Patient selectByHnToBorrowFilm(String hn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.hn
        ).append( " like '%" ).append( hn ).append( "'" ).append(
        " and " ).append(  dbObj.active ).append( " ='1'" ).append(
        " and " ).append(  dbObj.xn ).append( " !=''");
        
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;
    }
  //////////////////////////////////////////////////////////////////////////////
    public Patient selectByXnToBorrowFilm(String xn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.xn
        ).append( " = '" ).append( xn ).append( "'" ).append( " and " ).append(  dbObj.active ).append( " ='1'");
        Vector v=eQuery(sql.toString());
        if(v.isEmpty())
            return null;
        Patient p = (Patient)v.get(0);
        Family fm = theFamilyDB.selectByPK(p.family_id);
        p.setFamily(fm,true);
        return p;
    }     
        
    public Vector selectLocking(String str1,String str2) throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from t_patient" ).append(
                " left join t_visit on t_patient.t_patient_id = t_visit.t_patient_id" ).append(
        " where (f_visit_status_id like '" ).append( str1 ).append( "'" ).append(
        " or f_visit_status_id like '" ).append( str2 ).append( "')" ).append(
        " and visit_locking = '1' " ).append(
        " order by visit_begin_visit_time desc  limit 500");
        
        return eQuery(sql.toString());
    }   
    
    public Vector selectLockingByHN(String hn) throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from t_patient" ).append(
                " left join t_visit on t_patient.t_patient_id = t_visit.t_patient_id" ).append(
                " where visit_locking = '1' " ).append(
                " and t_visit.visit_hn like '" ).append( hn ).append( "'").append(
                " order by t_visit.visit_vn desc ");
        
        return eQuery(sql.toString());
    }
    
    /**
     * @author henbe
     * css �ͧ���
     */
    public Vector selectByHnXnFnameLnamePid(String name) throws Exception
    {
        boolean is_number=false;
        boolean is_pid=false;
        boolean is_xray=false;
        long value=0;
        try{
            value = Integer.parseInt(name);
            is_number=true;
        }catch(Exception e){
            Constant.println(e.getMessage());
        }
        if(name.length()==13)
            is_pid=true;
        if(name.startsWith("X") || name.startsWith("x"))
            is_xray = true;
        
        DecimalFormat d = new DecimalFormat();
        d.applyPattern("000000000");
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table ).append( " where (");
        if(is_number)
            sql.append(dbObj.hn ).append( " = '" ).append( d.format(value) ).append( "'");
        else if(is_pid)
            sql.append(dbObj.pid ).append( " = '" ).append( name ).append( "'");
        else if(is_xray)
            sql.append(dbObj.xn ).append( " = '" ).append( name ).append( "'");
        else
        {
            sql.append(dbObj.fname ).append( " like '" ).append( name ).append( "%'" ).append(
                   " or " ).append( dbObj.lname ).append( " like '" ).append( name ).append( "%'");
        }
        sql.append(") and " ).append(  dbObj.active ).append( " ='1' ") ;
        return eQuery(sql.toString());
    }
    
    public boolean selectByPrefix(String prefix_id) throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.prefix_id
        ).append( " = '" ).append( prefix_id ).append( "'" ).append( " and " ).append(  dbObj.active ).append( " ='1'");
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return false;
        else
            return true;
    }

    public Vector selectByPID(String pid_dep) throws Exception {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pid ).append( " = '" ).append( pid_dep ).append( "'"
        ).append( " and " ).append(  dbObj.active ).append( " ='1'");
        return eQuery(sql.toString());
    }

    public int updatePidByPtid(String family_pid, String patient_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append(
                " set " ).append( dbObj.pid  ).append( "='" ).append( family_pid ).append( "'" ).append(
                " where " ).append( dbObj.pk_field ).append( "='" ).append( patient_id ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    /**
     *@deprecated henbe unused
     **/
    public Vector selectLikeHcis(String string) {
        return null;
    }

    public String selectMaxXN(String pattern) throws Exception {

        StringBuffer sql = new StringBuffer( "Select MAX(" ).append(dbObj.xn ).append( ") as max From " ).append( dbObj.table
                ).append( " where length(" ).append( dbObj.xn ).append( ") >=" ).append(pattern.length());
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        String ret = "0";
        if(rs.next())
           ret = rs.getString(1);
        rs.close();
        return ret;
    }
}
