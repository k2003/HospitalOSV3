/*
 * RP115Group3_2549DB.java
 *
 * Created on 16 �չҤ� 2549, 18:28 �.
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.standardReport.objdb;

import com.standardReport.object.RP115Group3DentalProtect_2549;
import com.standardReport.object.RP115Group3Epi_2549;
import com.standardReport.object.RP115Group3Healthy_2549;
import com.standardReport.object.RP115Group3MMR_2549;
import com.standardReport.object.RP115Group3Nutrition_2549;
import com.standardReport.object.RP115Group3_2549;
import java.util.*;
import java.sql.*;
import java.io.*;

import com.hospital_os.usecase.connection.ConnectionInf;
import com.standardReport.object.checkDataObject;
import com.standardReport.subject.StandardDB;
import com.standardReport.utility.*;
/**
 *
 * @author Ojika
 */
public class RP115Group3_2549DB
{
    
    /** Creates a new instance of RP115Group3_2549DB */
    public ConnectionInf theConnectionInf;
    
    RP115Group3Healthy_2549 theRP115Group3Healthy_2549;
    RP115Group3Epi_2549 theRP115Group3Epi_2549;
    RP115Group3DentalProtect_2549 theRP115Group3DentalProtect_2549;
    RP115Group3MMR_2549 theRP115Group3MMR_2549;
    RP115Group3Nutrition_2549 theRP115Group3Nutrition_2549;
    
    // ����Ѻ��Ǩ�ͺ������ Map
    checkDataObject thecheckDataObject;
    
    RP115Group3_2549 theRP115Group3_2549;
            
    ResultSet rs = null;
    String sql = "";
    Vector vReport;
    
    public RP115Group3_2549DB(ConnectionInf c) 
    {        
        theConnectionInf = c;
      
        theRP115Group3Healthy_2549 = new RP115Group3Healthy_2549();  
        theRP115Group3Epi_2549 = new RP115Group3Epi_2549();
        theRP115Group3DentalProtect_2549 = new RP115Group3DentalProtect_2549();
        theRP115Group3MMR_2549 = new RP115Group3MMR_2549();
        theRP115Group3Nutrition_2549 = new RP115Group3Nutrition_2549();

        theRP115Group3_2549 = new RP115Group3_2549();
    }
    
    /**
     * �֧������ Healthy
     * @Author Ojika
     * @Date 17/03/2549
     * @update 25/10/2549
     **/
    public Vector selectGroup3HealthyByDate(String startDate, String endDate) throws Exception
     {
       /* StringBuffer strHealthy = new StringBuffer();
        strHealthy.append("SELECT ");
	strHealthy.append("r_uc_plan_group.uc_plan_group_description  	");
	strHealthy.append(", sum(case when ((wellBaby_space = 34) ");
	strHealthy.append("			AND (wellBaby_34_w01 + wellBaby_34_w02 + wellBaby_34_w03) >= 3)");
	strHealthy.append("	then 1 ");
	strHealthy.append("	when ((wellBaby_space = 3) ");
	strHealthy.append("			AND (wellBaby_3_w01 +  wellBaby_3_w02 +  wellBaby_3_w03 + wellBaby_3_w04) >= 4) ");
	strHealthy.append("	then 1 ");
	strHealthy.append("	when ((wellBaby_space = 45) ");
	strHealthy.append("			AND (wellBaby_45_w01+ wellBaby_45_w02 + wellBaby_45_w03 + wellBaby_45_w05) >= 4) ");
	strHealthy.append("	then 1 ");
	strHealthy.append("	else 0 ");
	strHealthy.append("end) AS wellBaby ");
	strHealthy.append(", sum(case when (wellBaby_space = 614) ");
	strHealthy.append("			AND ((healthy614_h01_614 + healthy614_h02_614 + healthy614_h03_614) >= 3 ) ");
	strHealthy.append("	then  1 ");
	strHealthy.append("	else 0 ");
	strHealthy.append("end) AS healthy614 ");
	strHealthy.append(", sum(case when (wellBaby_space = 15) ");
	strHealthy.append("	AND ((healthy15up_h01_15 + healthy15up_h02_15 + healthy15up_h03_15 + healthy15up_h04_15) >= 4) ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("end) AS healthy15up ");
        strHealthy.append("FROM  ");
	strHealthy.append("r_uc_plan_group LEFT JOIN   ");
        strHealthy.append("(SELECT ");
	strHealthy.append("t_health_family.t_health_family_id ");
	strHealthy.append(", t_health_family.patient_name ");
	strHealthy.append(", t_health_family.patient_last_name ");
        strHealthy.append(",CASE  WHEN ((r_plan_group.plan_group_number = '1' ) OR (r_plan_group.plan_group_number = '2' ) )  ");
        strHealthy.append("THEN  r_plan_group.plan_group_number ");
        strHealthy.append("WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strHealthy.append("		AND ((t_patient_payment.patient_payment_main_hospital IN (Select  hospital_incup_code ");
        strHealthy.append("		from r_hospital_incup))  OR (t_patient_payment.patient_payment_sub_hospital IN ");
        strHealthy.append("		(Select  hospital_incup_code from r_hospital_incup))) ) ");
        strHealthy.append("THEN '3' ");
        strHealthy.append("WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strHealthy.append("		AND ( ((t_patient_payment.patient_payment_main_hospital = '') ");
        strHealthy.append("		AND (t_patient_payment.patient_payment_sub_hospital = '')) ");
        strHealthy.append("		OR ((t_patient_payment.patient_payment_main_hospital NOT IN (Select  hospital_incup_code ");
        strHealthy.append("		from r_hospital_incup))  AND (t_patient_payment.patient_payment_sub_hospital NOT IN ");
        strHealthy.append("		(Select  hospital_incup_code from r_hospital_incup))) )) ");
        strHealthy.append("THEN '4' ");
        strHealthy.append("		WHEN ((r_plan_group.plan_group_number <> '1' ) AND (r_plan_group.plan_group_number <> '2' ) ");
        strHealthy.append("		AND (r_plan_group.plan_group_number <> '3' ) AND (r_plan_group.plan_group_number <> '4' ) ) ");
        strHealthy.append("THEN  '5' ");
        strHealthy.append("END AS plan_group_id	");
        strHealthy.append(", sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w01')) ");
        strHealthy.append("AND ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) = 3) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS wellBaby_34_w01 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("			from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w02')) ");
        strHealthy.append("AND ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) = 3) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS wellBaby_34_w02 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w03')) ");
        strHealthy.append("AND ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) = 3) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS wellBaby_34_w03 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w01')) ");
        strHealthy.append("AND ( ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) IS NULL) ");
        strHealthy.append("	OR ");
        strHealthy.append("	(( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 0) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) < 3)) ");
        strHealthy.append("     ) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS wellBaby_3_w01 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w02')) ");
        strHealthy.append("AND ( ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) IS NULL) ");
        strHealthy.append("	OR ");
        strHealthy.append("	(( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("   ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 0) ");
        strHealthy.append("AND  ");
        strHealthy.append("( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) < 3)) ");
        strHealthy.append("      ) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS wellBaby_3_w02 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w03')) ");
        strHealthy.append("AND ( ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) IS NULL) ");
        strHealthy.append("	OR ");
        strHealthy.append("	(( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 0) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) < 3)) ");
        strHealthy.append("      ) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS wellBaby_3_w03 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w04')) ");
        strHealthy.append("AND ( ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) IS NULL) ");
        strHealthy.append("	OR ");
        strHealthy.append("	(( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11)  ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 0) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) < 3)) ");
        strHealthy.append("      ) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS wellBaby_3_w04 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w01')) ");
        strHealthy.append("AND (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 4) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 5)) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end)  AS wellBaby_45_w01 ");
        strHealthy.append("	, sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w02')) ");
        strHealthy.append("AND (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("                      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 4) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 5)) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end)  AS wellBaby_45_w02 ");
        strHealthy.append(", sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w03')) ");
        strHealthy.append("AND (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 4) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 5)) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("end)  AS wellBaby_45_w03 ");
        strHealthy.append(", sum(case when ((r_healthy_group.healthy_group_number = 'WellBaby') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'w05')) ");
        strHealthy.append("AND (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 4) ");
        strHealthy.append("AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11)  ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 5)) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end)  AS wellBaby_45_w05 ");
        strHealthy.append("	, case when r_healthy_group.healthy_group_number = 'WellBaby' ");
        strHealthy.append("	and (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("   ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 4) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 5)) ");
        strHealthy.append("then  45 ");
        strHealthy.append("when r_healthy_group.healthy_group_number = 'WellBaby' ");
        strHealthy.append("	and ( ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(",'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) IS NULL) ");
        strHealthy.append("	OR ");
        strHealthy.append("	(( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 0) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) < 3)) ");
        strHealthy.append("      ) ");
        strHealthy.append("then 3 ");
        strHealthy.append("when r_healthy_group.healthy_group_number = 'WellBaby' ");
        strHealthy.append("	and ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) = 3) ");
        strHealthy.append("then 34 ");
        strHealthy.append("when r_healthy_group.healthy_group_number = 'Healthy(6-14)' ");
        strHealthy.append("then 614  ");
        strHealthy.append("when r_healthy_group.healthy_group_number = 'Healthy(15Up)' ");
        strHealthy.append("then 15 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end AS wellBaby_space ");
        strHealthy.append("	, sum(case when  ((r_healthy_group.healthy_group_number = 'Healthy(6-14)') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'h01_614')) ");
        strHealthy.append("AND (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 6) ");
        strHealthy.append("AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 14)) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("end) AS  healthy614_h01_614 ");
        strHealthy.append(", sum(case when  ((r_healthy_group.healthy_group_number = 'Healthy(6-14)') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'h02_614')) ");
        strHealthy.append("AND (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11)  ");
        strHealthy.append("   ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 6) ");
        strHealthy.append("		AND ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 14)) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS  healthy614_h02_614 ");
        strHealthy.append("	, sum(case when  ((r_healthy_group.healthy_group_number = 'Healthy(6-14)') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'h03_614')) ");
        strHealthy.append("AND (( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 6) ");
        strHealthy.append(" AND  ");
        strHealthy.append("	( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) <= 14)) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("end) AS  healthy614_h03_614 ");
        strHealthy.append(", sum(case when  ((r_healthy_group.healthy_group_number = 'Healthy(15Up)') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'h01_15')) ");
        strHealthy.append("AND ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 15) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("end) AS healthy15up_h01_15 ");
        strHealthy.append(", sum(case when  ((r_healthy_group.healthy_group_number = 'Healthy(15Up)') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'h02_15')) ");
        strHealthy.append("AND ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 15) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("	end) AS healthy15up_h02_15 ");
        strHealthy.append("	, sum(case when  ((r_healthy_group.healthy_group_number = 'Healthy(15Up)') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'h03_15')) ");
        strHealthy.append("AND ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 15) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("end) AS healthy15up_h03_15 ");
        strHealthy.append(", sum(case when  ((r_healthy_group.healthy_group_number = 'Healthy(15Up)') ");
        strHealthy.append("AND (r_healthy_group_survey.b_health_survey_id IN (select r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("	from r_healthy_group_survey inner join r_healthy_subgroup ");
        strHealthy.append("	on r_healthy_subgroup.r_healthy_subgroup_id = r_healthy_group_survey.r_healthy_subgroup_id ");
        strHealthy.append("	where r_healthy_subgroup.healthy_subgroup_number = 'h04_15')) ");
        strHealthy.append("AND ( (to_number((substring(' ' || age(to_date(substring(t_health_check_healthy.health_check_healthy_date,0,11) ");
        strHealthy.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999')) >= 15) ");
        strHealthy.append(") ");
        strHealthy.append("then 1 ");
        strHealthy.append("else 0 ");
        strHealthy.append("end) AS healthy15up_h04_15 ");
        strHealthy.append("FROM ");
        strHealthy.append("t_health_check_healthy INNER JOIN  t_health_family ");
        strHealthy.append("ON t_health_family.t_health_family_id = t_health_check_healthy.t_health_family_id ");
        strHealthy.append("INNER JOIN t_patient_payment ");
        strHealthy.append("ON t_health_family.t_health_family_id = t_patient_payment.t_health_family_id ");
        strHealthy.append("INNER JOIN b_contract_plans ");
        strHealthy.append("ON t_patient_payment.b_contact_plans_id = b_contract_plans.b_contract_plans_id ");
        strHealthy.append("INNER JOIN r_plan_group_map_pttype ");
        strHealthy.append("ON b_contract_plans.contract_plans_pttype = r_plan_group_map_pttype.plan_group_map_pttype_pttype ");
        strHealthy.append("INNER JOIN r_plan_group ");
        strHealthy.append("ON r_plan_group_map_pttype.r_plan_group_id = r_plan_group.r_plan_group_id ");
        strHealthy.append("INNER JOIN r_healthy_group_survey ");
        strHealthy.append("ON t_health_check_healthy.b_health_survey_id = r_healthy_group_survey.b_health_survey_id ");
        strHealthy.append("INNER JOIN r_healthy_subgroup ");
        strHealthy.append("ON r_healthy_group_survey.r_healthy_subgroup_id = r_healthy_subgroup.r_healthy_subgroup_id ");
        strHealthy.append("INNER JOIN r_healthy_group ");
        strHealthy.append("ON r_healthy_subgroup.r_healthy_group_id = r_healthy_group.r_healthy_group_id ");
        strHealthy.append("WHERE ");
        strHealthy.append("t_health_check_healthy.health_check_healthy_active = '1'  ");
        strHealthy.append("AND t_patient_payment.patient_payment_priority = '0' ");
        strHealthy.append("AND substring(t_health_check_healthy.health_check_healthy_date,0,11) Between '"+startDate+"' and '"+endDate+"' ");
        strHealthy.append("GROUP BY ");
        strHealthy.append("t_health_family.t_health_family_id ");
        strHealthy.append(", t_health_family.patient_name ");
        strHealthy.append(", t_health_family.patient_last_name ");
        strHealthy.append(", t_health_check_healthy.health_check_healthy_date ");
        strHealthy.append(", plan_group_id ");
    
        strHealthy.append(", wellBaby_space ");

        strHealthy.append(") AS query1 ");
        strHealthy.append("ON query1.plan_group_id = r_uc_plan_group.uc_plan_group_number ");
        strHealthy.append("GROUP BY ");
        strHealthy.append("r_uc_plan_group.uc_plan_group_description ");
        strHealthy.append(",r_uc_plan_group.uc_plan_group_number ");
        strHealthy.append("ORDER BY ");
        strHealthy.append("r_uc_plan_group.uc_plan_group_number ");

          System.out.println(" SQL Healthy : " + strHealthy.toString());
          eHealthyQuery(strHealthy.toString());
          strHealthy = null;
        **/
        String sql = IOStream.readInputDefault("config/rp_standard/standard_1105_part3_healthy.sql");
        PreparedStatement pm = theConnectionInf.getConnection().prepareStatement(sql);
        pm.setString(1,startDate);
        pm.setString(2,endDate);
        eHealthyQuery(pm.executeQuery());
 
          sql = null;     
          if(this.vReport.size()==0)
          {
              return null;
          }
          else
          {
              return this.vReport;
          }
     }
    
    /**
     * �֧������ Epi
     * @Author Ojika
     * @Date 17/03/2549
     * @update 25/10/2549
     **/
 public Vector selectGroup3EpiByDate(String startDate, String endDate) throws Exception
     {
      /*  StringBuffer strEpi = new StringBuffer();
        strEpi.append(" SELECT ");
        strEpi.append("r_uc_plan_group.uc_plan_group_description ");
        strEpi.append(",sum(query1.DPT) as DPT  ");
        strEpi.append(",sum(query1.BCG) as BCG  ");
        strEpi.append(",sum(query1.MMR) as MMR  ");
        strEpi.append(",sum(query1.Hep) as Hep  ");
        strEpi.append("FROM   ");
        strEpi.append("r_uc_plan_group LEFT JOIN   ");
        strEpi.append(" (select  ");
        strEpi.append("distinct ");
        strEpi.append("t_health_family.patient_hn ");
        strEpi.append(", t_health_family.patient_name ");
        strEpi.append(", t_health_family.patient_last_name ");
        strEpi.append(",CASE  WHEN ((r_plan_group.plan_group_number = '1' ) OR (r_plan_group.plan_group_number = '2' ) )  ");
        strEpi.append("		THEN  r_plan_group.plan_group_number  ");
        strEpi.append("		WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strEpi.append("		AND ((t_patient_payment.patient_payment_main_hospital IN (Select  hospital_incup_code  ");
        strEpi.append("		from r_hospital_incup))  OR (t_patient_payment.patient_payment_sub_hospital IN  ");
        strEpi.append("		(Select  hospital_incup_code from r_hospital_incup))) ) ");
        strEpi.append("THEN '3'  ");
        strEpi.append("WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strEpi.append("		AND ( ((t_patient_payment.patient_payment_main_hospital = '')  ");
        strEpi.append("		AND (t_patient_payment.patient_payment_sub_hospital = ''))  ");
        strEpi.append("		OR ((t_patient_payment.patient_payment_main_hospital NOT IN (Select  hospital_incup_code  ");
        strEpi.append("		from r_hospital_incup))  AND (t_patient_payment.patient_payment_sub_hospital NOT IN  ");
        strEpi.append("		(Select  hospital_incup_code from r_hospital_incup))) )) ");
        strEpi.append("THEN '4'  ");
        strEpi.append("WHEN ((r_plan_group.plan_group_number <> '1' ) AND (r_plan_group.plan_group_number <> '2' )  ");
        strEpi.append("		AND (r_plan_group.plan_group_number <> '3' ) AND (r_plan_group.plan_group_number <> '4' ) ) ");
        strEpi.append("THEN  '5'  ");
        strEpi.append("END AS plan_group_id ");
        strEpi.append(", r_epi_group.epi_group_number ");
        strEpi.append(", case when r_epi_group.epi_group_number = 'DPT' ");
        strEpi.append("then 1 ");
        strEpi.append("else 0 ");
        strEpi.append("  end AS DPT ");
        strEpi.append(" , case when r_epi_group.epi_group_number = 'BCG' ");
        strEpi.append("then 1 ");
        strEpi.append("else 0 ");
        strEpi.append("  end AS BCG ");
        strEpi.append(" , case when r_epi_group.epi_group_number = 'MMR' ");
        strEpi.append("then 1 ");
        strEpi.append("else 0 ");
        strEpi.append("  end AS MMR ");
        strEpi.append(" , case when r_epi_group.epi_group_number = 'Hep.B' ");
        strEpi.append("then 1 ");
        strEpi.append("else 0 ");
        strEpi.append("  end AS Hep ");
        strEpi.append("from  ");
        strEpi.append("t_health_family INNER JOIN t_patient_payment  ");
        strEpi.append("ON t_health_family.t_health_family_id = t_patient_payment.t_health_family_id  ");
        strEpi.append("INNER JOIN b_contract_plans  ");
        strEpi.append("ON t_patient_payment.b_contact_plans_id = b_contract_plans.b_contract_plans_id ");
        strEpi.append("INNER JOIN t_health_epi  ");
        strEpi.append("ON t_health_family.t_health_family_id = t_health_epi.t_health_family_id ");
        strEpi.append("INNER JOIN t_health_epi_detail  ");
        strEpi.append("ON t_health_epi.t_health_epi_id = t_health_epi_detail.t_health_epi_id ");
        strEpi.append("INNER JOIN r_plan_group_map_pttype ");
        strEpi.append("ON b_contract_plans.contract_plans_pttype = r_plan_group_map_pttype.plan_group_map_pttype_pttype ");
        strEpi.append("INNER JOIN r_plan_group ");
        strEpi.append("ON r_plan_group_map_pttype.r_plan_group_id = r_plan_group.r_plan_group_id ");
        strEpi.append("INNER JOIN r_epi_group_item  ");
        strEpi.append("ON t_health_epi_detail.b_health_epi_set_id = r_epi_group_item.b_health_epi_group_id ");
        strEpi.append("INNER JOIN r_epi_group ");
        strEpi.append("ON r_epi_group_item.r_epi_group_id = r_epi_group.r_epi_group_id ");
        strEpi.append("where  ");
        strEpi.append("t_health_epi_detail.health_epi_detail_active = '1' ");
        strEpi.append("and t_health_epi.health_epi_active = '1' ");
        strEpi.append("and t_patient_payment.patient_payment_priority = '0'  ");
        strEpi.append("and substring(t_health_epi_detail.record_date_time,0,11) Between '"+startDate+"' and '"+endDate+"'  ");
        strEpi.append(") AS query1 ");
        strEpi.append("ON query1.plan_group_id = r_uc_plan_group.uc_plan_group_number ");
        strEpi.append("GROUP BY   ");
        strEpi.append("r_uc_plan_group.uc_plan_group_description  ");
        strEpi.append(",r_uc_plan_group.uc_plan_group_number  ");
        strEpi.append("ORDER BY   ");
        strEpi.append("r_uc_plan_group.uc_plan_group_number  ");

          System.out.println(" SQL Epi : " + strEpi.toString());
          eEpiQuery(strEpi.toString());
          strEpi = null;
       **/
        String sql = IOStream.readInputDefault("config/rp_standard/standard_1105_part3_epi.sql");
        PreparedStatement pm = theConnectionInf.getConnection().prepareStatement(sql);
        pm.setString(1,startDate);
        pm.setString(2,endDate);
        eEpiQuery(pm.executeQuery());
 
          sql = null;     
          if(this.vReport.size()==0)
          {
              return null;
          }
          else
          {
              return this.vReport;
          }
     }
    
    /**
     * �֧������ DentalProtect
     * @Author Ojika
     * @Date 17/03/2549
     * @update 25/10/2549
     **/
    public Vector selectGroup3DentalProtectByDate(String startDate, String endDate) throws Exception
     {
       /* StringBuffer strDental = new StringBuffer();
        strDental.append(" SELECT ");
        strDental.append("r_uc_plan_group.uc_plan_group_description  ");
        strDental.append(",sum(query1.baby) as baby  ");
        strDental.append(",sum(query1.child) as child  ");
        strDental.append("FROM   ");
        strDental.append("r_uc_plan_group LEFT JOIN   ");        
        strDental.append(" (select  ");
        strDental.append("distinct ");
        strDental.append("t_patient.t_patient_id ");
        strDental.append(",t_visit.t_visit_id ");
        strDental.append(",CASE  WHEN ((r_plan_group.plan_group_number = '1' ) OR (r_plan_group.plan_group_number = '2' ) )  ");
        strDental.append("	THEN  r_plan_group.plan_group_number  ");
        strDental.append("	WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strDental.append("			AND ((t_patient_payment.patient_payment_main_hospital IN (Select  hospital_incup_code  ");
        strDental.append("			from r_hospital_incup))  OR (t_patient_payment.patient_payment_sub_hospital IN  ");
        strDental.append("			(Select  hospital_incup_code from r_hospital_incup))) ) ");
        strDental.append("	THEN '3'  ");
        strDental.append("	WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strDental.append("			AND ( ((t_patient_payment.patient_payment_main_hospital = '') ");
        strDental.append("			AND (t_patient_payment.patient_payment_sub_hospital = ''))  ");
        strDental.append("			OR ((t_patient_payment.patient_payment_main_hospital NOT IN (Select  hospital_incup_code  ");
        strDental.append("			from r_hospital_incup))  AND (t_patient_payment.patient_payment_sub_hospital NOT IN  ");
        strDental.append("			(Select  hospital_incup_code from r_hospital_incup))) )) ");
        strDental.append("	THEN '4'  ");
        strDental.append("	WHEN ((r_plan_group.plan_group_number <> '1' ) AND (r_plan_group.plan_group_number <> '2' )  ");
        strDental.append("			AND (r_plan_group.plan_group_number <> '3' ) AND (r_plan_group.plan_group_number <> '4' ) ) ");
        strDental.append("	THEN  '5'  ");
        strDental.append("END AS plan_group_id ");
        strDental.append(", case when ((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strDental.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') IS NULL) ");
        strDental.append("OR ((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strDental.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 0) ");
        strDental.append("      AND (to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strDental.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=5) ");
        strDental.append(")) ");
        strDental.append("then 1 ");
        strDental.append("else 0  ");
        strDental.append("end AS baby ");
        strDental.append(", case when ((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strDental.append("      ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 6) ");
        strDental.append("      AND (to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strDental.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=14) ");
        strDental.append(") ");
        strDental.append("then 1 ");
        strDental.append("else 0  ");
        strDental.append("end  AS child ");
        strDental.append("from  ");
        strDental.append("t_health_family INNER JOIN t_patient_payment  ");
        strDental.append("ON t_health_family.t_health_family_id = t_patient_payment.t_health_family_id  ");
        strDental.append("INNER JOIN b_contract_plans  ");
        strDental.append("ON t_patient_payment.b_contact_plans_id = b_contract_plans.b_contract_plans_id ");
        strDental.append("INNER JOIN r_plan_group_map_pttype ");
        strDental.append("ON b_contract_plans.contract_plans_pttype = r_plan_group_map_pttype.plan_group_map_pttype_pttype ");
        strDental.append("INNER JOIN r_plan_group ");
        strDental.append("ON r_plan_group_map_pttype.r_plan_group_id = r_plan_group.r_plan_group_id ");
        strDental.append("INNER JOIN t_patient  ");
        strDental.append("ON t_health_family.t_health_family_id = t_patient.t_health_family_id ");
        strDental.append("INNER JOIN  t_visit ");
        strDental.append("ON t_patient.t_patient_id = t_visit.t_patient_id ");
        strDental.append("INNER JOIN t_order  ");
        strDental.append("ON t_visit.t_visit_id = t_order.t_visit_id ");
        strDental.append("where  ");
        strDental.append("t_visit.f_visit_status_id <> '4' ");
        strDental.append("and t_order.f_order_status_id <> '0' ");
        strDental.append("and t_order.f_order_status_id <> '3' ");
        strDental.append("and t_patient_payment.patient_payment_priority = '0' ");
        strDental.append("and substring(t_visit.visit_financial_discharge_time,0,11) Between '"+startDate+"' and '"+endDate+"' ");
        strDental.append("and t_order.b_item_id IN (select  b_item_id from r_dental_protect_item) ");
        strDental.append("group by  ");
        strDental.append("t_patient.t_patient_id ");
        strDental.append(",t_visit.t_visit_id ");
        strDental.append(",plan_group_id ");
        strDental.append(",baby ");
        strDental.append(",child ");
        strDental.append(") AS query1 ");
        strDental.append("ON query1.plan_group_id = r_uc_plan_group.uc_plan_group_number ");
        strDental.append("GROUP BY   ");
        strDental.append("r_uc_plan_group.uc_plan_group_description  ");
        strDental.append(",r_uc_plan_group.uc_plan_group_number  ");
        strDental.append("ORDER BY   ");
        strDental.append("r_uc_plan_group.uc_plan_group_number  ");
                   
          System.out.println(" SQL Dental Protect : " + strDental.toString());
          eDentalProtectQuery(strDental.toString());
          strDental = null;
        */
        String sql = IOStream.readInputDefault("config/rp_standard/standard_1105_part3_dentalprotect.sql");
        PreparedStatement pm = theConnectionInf.getConnection().prepareStatement(sql);
        pm.setString(1,startDate);
        pm.setString(2,endDate);
        eDentalProtectQuery(pm.executeQuery());
 
          sql = null;     
          if(this.vReport.size()==0)
          {
              return null;
          }
          else
          {
              return this.vReport;
          }
     }
    
    /**
     * �֧������ MMR
     * @Author Ojika
     * @Date 17/03/2549
     * @update 25/10/2549
     **/
    public Vector selectGroup3MMRByDate(String startDate, String endDate) throws Exception
     {
      /*  StringBuffer strMMR = new StringBuffer();        
        strMMR.append(" SELECT ");
        strMMR.append(" r_uc_plan_group.uc_plan_group_description  ");
        strMMR.append(" ,sum(query1.measles) as measles ");
        strMMR.append("FROM ");
        strMMR.append(" r_uc_plan_group LEFT JOIN  ");
        strMMR.append(" (select  ");
        strMMR.append(" distinct ");
        strMMR.append(" t_health_family.t_health_family_id ");
        strMMR.append(" ,CASE  WHEN ((r_plan_group.plan_group_number = '1' ) OR (r_plan_group.plan_group_number = '2' ) )  ");
        strMMR.append(" THEN  r_plan_group.plan_group_number  ");
        strMMR.append(" WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strMMR.append(" 		AND ((t_patient_payment.patient_payment_main_hospital IN (Select  hospital_incup_code  ");
        strMMR.append(" 		from r_hospital_incup))  OR (t_patient_payment.patient_payment_sub_hospital IN  ");
        strMMR.append(" 		(Select  hospital_incup_code from r_hospital_incup))) ) ");
        strMMR.append(" THEN '3'  ");
        strMMR.append(" WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strMMR.append(" 		AND ( ((t_patient_payment.patient_payment_main_hospital = '')  ");
        strMMR.append(" 		AND (t_patient_payment.patient_payment_sub_hospital = ''))  ");
        strMMR.append(" 		OR ((t_patient_payment.patient_payment_main_hospital NOT IN (Select  hospital_incup_code  ");
        strMMR.append(" 		from r_hospital_incup))  AND (t_patient_payment.patient_payment_sub_hospital NOT IN  ");
        strMMR.append(" 		(Select  hospital_incup_code from r_hospital_incup))) )) ");
        strMMR.append(" THEN '4'  ");
        strMMR.append(" WHEN ((r_plan_group.plan_group_number <> '1' ) AND (r_plan_group.plan_group_number <> '2' )  ");
        strMMR.append(" 		AND (r_plan_group.plan_group_number <> '3' ) AND (r_plan_group.plan_group_number <> '4' ) ) ");
        strMMR.append(" THEN  '5'  ");
        strMMR.append(" END AS plan_group_id ");
        strMMR.append(" , 1 as measles ");
        strMMR.append(" from  ");
        strMMR.append(" t_health_family INNER JOIN t_patient_payment  ");
        strMMR.append(" 	ON t_health_family.t_health_family_id = t_patient_payment.t_health_family_id  ");
        strMMR.append(" INNER JOIN b_contract_plans ");
        strMMR.append(" 	ON t_patient_payment.b_contact_plans_id = b_contract_plans.b_contract_plans_id ");
        strMMR.append(" INNER JOIN t_health_epi  ");
        strMMR.append(" 	ON t_health_family.t_health_family_id = t_health_epi.t_health_family_id ");
        strMMR.append(" INNER JOIN t_health_epi_detail  ");
        strMMR.append(" 	ON t_health_epi.t_health_epi_id = t_health_epi_detail.t_health_epi_id ");
        strMMR.append(" INNER JOIN r_plan_group_map_pttype ");
        strMMR.append(" 	ON b_contract_plans.contract_plans_pttype = r_plan_group_map_pttype.plan_group_map_pttype_pttype ");
        strMMR.append(" INNER JOIN r_plan_group ");
        strMMR.append(" 	ON r_plan_group_map_pttype.r_plan_group_id = r_plan_group.r_plan_group_id ");
        strMMR.append(" INNER JOIN r_epi_group_item  ");
        strMMR.append(" 	ON t_health_epi_detail.b_health_epi_set_id = r_epi_group_item.b_health_epi_group_id ");
        strMMR.append(" INNER JOIN r_epi_group ");
        strMMR.append(" 	ON r_epi_group_item.r_epi_group_id = r_epi_group.r_epi_group_id ");
        strMMR.append(" where  ");
        strMMR.append(" t_health_epi_detail.health_epi_detail_active = '1' ");
        strMMR.append(" and t_health_epi.health_epi_active = '1' ");
        strMMR.append(" and t_patient_payment.patient_payment_priority = '0' ");
        strMMR.append(" and substring(t_visit.visit_begin_visit_time,0,11) Between '"+startDate+"' and '"+endDate+"'  ");
        strMMR.append(" and t_health_epi_detail.b_health_epi_set_id IN (select  r_epi_measles_item.b_health_epi_group_id from r_epi_measles_item) ");
        strMMR.append(" and ((to_number((substring(' ' || age(to_date(substring(t_health_epi_detail.record_date_time,0,11)  ");
        strMMR.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') IS NULL) ");
        strMMR.append(" 	OR ((to_number((substring(' ' || age(to_date(substring(t_health_epi_detail.record_date_time,0,11)  ");
        strMMR.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 0) ");
        strMMR.append(" 	      AND (to_number((substring(' ' || age(to_date(substring(t_health_epi_detail.record_date_time,0,11)  ");
        strMMR.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=5) ");
        strMMR.append(" 	)) ");
        strMMR.append(" group by  ");
        strMMR.append(" t_health_family.t_health_family_id ");
        strMMR.append(" ,plan_group_id ");
        strMMR.append(" ) AS query1 ");
        strMMR.append(" ON query1.plan_group_id = r_uc_plan_group.uc_plan_group_number ");
        strMMR.append(" GROUP BY   ");
        strMMR.append(" r_uc_plan_group.uc_plan_group_description  ");
        strMMR.append(" ,r_uc_plan_group.uc_plan_group_number  ");
        strMMR.append(" ORDER BY   ");
        strMMR.append(" r_uc_plan_group.uc_plan_group_number  ");
                   
          System.out.println(" SQL MMR : " + strMMR.toString());
          eMMRQuery(strMMR.toString());
          strMMR = null;
       */
        String sql = IOStream.readInputDefault("config/rp_standard/standard_1105_part3_MMR.sql");
        PreparedStatement pm = theConnectionInf.getConnection().prepareStatement(sql);
        pm.setString(1,startDate);
        pm.setString(2,endDate);
        eMMRQuery(pm.executeQuery());
 
          sql = null;     
          if(this.vReport.size()==0)
          {
              return null;
          }
          else
          {
              return this.vReport;
          }
     }
    
    /**
     * �֧������ Nutrition
     * @Author Ojika
     * @Date 17/03/2549
     * @update 25/10/2549
     **/
    public Vector selectGroup3NutritionByDate(String startDate, String endDate, String startCheckDate, String endCheckDate, boolean isJan) throws Exception
     {
      /*  StringBuffer strNutriion = new StringBuffer();
        strNutriion.append(" SELECT ");
        strNutriion.append("r_uc_plan_group.uc_plan_group_description  ");
        strNutriion.append(", case when (sum(baby_fail) IS NOT NULL) ");
        strNutriion.append("	then sum(baby_fail)  ");
        strNutriion.append("	else 0  ");
        strNutriion.append("end as baby_fail  ");
        strNutriion.append(", case when (sum(baby_exceed) IS NOT NULL)  ");
        strNutriion.append("	then sum(baby_exceed)  ");
        strNutriion.append("	else 0  ");
        strNutriion.append("end as baby_exceed  ");
        strNutriion.append(", case when (sum(child_fail) IS NOT NULL)  ");
        strNutriion.append("	then sum(child_fail)  ");
        strNutriion.append("	else 0  ");
        strNutriion.append("end as child_fail ");
        strNutriion.append(", case when (sum(child_exceed) IS NOT NULL) ");
        strNutriion.append("	then sum(child_exceed)  ");
        strNutriion.append("	else 0  ");
        strNutriion.append("end as child_exceed ");
        strNutriion.append(", case when (sum(man_fail) IS NOT NULL)  ");
        strNutriion.append("	then sum(man_fail)  ");
        strNutriion.append("	else 0  ");
        strNutriion.append("end as man_fail ");
        strNutriion.append(", case when (sum(man_exceed) IS NOT NULL) ");
        strNutriion.append("	then sum(man_exceed)  ");
        strNutriion.append("	else 0  ");
        strNutriion.append("end as man_exceed ");
        strNutriion.append("FROM   ");
        strNutriion.append("r_uc_plan_group LEFT JOIN   ");        
        strNutriion.append(" (select  ");
        strNutriion.append("distinct ");
        strNutriion.append("t_health_family.t_health_family_id ");
        strNutriion.append(", t_health_family.patient_name ");
        strNutriion.append(", t_health_family.patient_last_name ");
        strNutriion.append(",CASE  WHEN ((r_plan_group.plan_group_number = '1' ) OR (r_plan_group.plan_group_number = '2' ) )  ");
        strNutriion.append("THEN  r_plan_group.plan_group_number  ");
        strNutriion.append("WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strNutriion.append("		AND ((t_patient_payment.patient_payment_main_hospital IN (Select  hospital_incup_code  ");
        strNutriion.append("		from r_hospital_incup))  OR (t_patient_payment.patient_payment_sub_hospital IN  ");
        strNutriion.append("		(Select  hospital_incup_code from r_hospital_incup))) ) ");
        strNutriion.append("THEN '3'  ");
        strNutriion.append("WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strNutriion.append("		AND ( ((t_patient_payment.patient_payment_main_hospital = '')  ");
        strNutriion.append("		AND (t_patient_payment.patient_payment_sub_hospital = ''))  ");
        strNutriion.append("		OR ((t_patient_payment.patient_payment_main_hospital NOT IN (Select  hospital_incup_code  ");
        strNutriion.append("		from r_hospital_incup))  AND (t_patient_payment.patient_payment_sub_hospital NOT IN  ");
        strNutriion.append("		(Select  hospital_incup_code from r_hospital_incup))) )) ");
        strNutriion.append("THEN '4'  ");
        strNutriion.append("WHEN ((r_plan_group.plan_group_number <> '1' ) AND (r_plan_group.plan_group_number <> '2' )  ");
        strNutriion.append("		AND (r_plan_group.plan_group_number <> '3' ) AND (r_plan_group.plan_group_number <> '4' ) ) ");
        strNutriion.append("THEN  '5'  ");
        strNutriion.append("END AS plan_group_id ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') IS NULL) ");
        strNutriion.append("OR ((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 0) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=5)))  ");
        strNutriion.append("    AND  ");
        strNutriion.append("     ( t_visit_vital_sign.f_visit_nutrition_level_id = '1'  ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '2'  ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '3'  ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '4' ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '11' ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '12' )  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end AS baby_fail  ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append("       ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') IS NULL) ");
        strNutriion.append("OR ((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 0) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=5) ");
        strNutriion.append(")) AND  ");
        strNutriion.append("     ( t_visit_vital_sign.f_visit_nutrition_level_id  = '5'  ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '6'  ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '7'  ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '08' ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '09')  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end AS baby_exceed  ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 6) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=14) ");
        strNutriion.append(") AND  ");
        strNutriion.append("     ( t_visit_vital_sign.f_visit_nutrition_level_id = '1'  ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '2'  ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '3'  ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '4' ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '11' ");
        strNutriion.append("	OR t_visit_vital_sign.f_visit_nutrition_level_id = '12' )  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS child_fail  ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 6) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=14) ");
        strNutriion.append(") AND  ");
        strNutriion.append("     ( t_visit_vital_sign.f_visit_nutrition_level_id  = '5'  ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '6'  ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '7'  ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '08' ");
        strNutriion.append("       OR  t_visit_vital_sign.f_visit_nutrition_level_id = '09') ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS child_exceed   ");
        strNutriion.append(", case when  ((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') > 15) ");
        strNutriion.append(" AND  ");
        strNutriion.append("    (to_number(t_visit_vital_sign.visit_vital_sign_bmi,'99.99') < 18.5) ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS man_fail   ");
        strNutriion.append(", case when  ((to_number((substring(' ' || age(to_date(substring(t_visit.visit_financial_discharge_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') > 15) ");
        strNutriion.append("  AND  ");
        strNutriion.append("    (to_number(t_visit_vital_sign.visit_vital_sign_bmi,'99.99') > 24.9)  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS man_exceed  ");
        strNutriion.append("from  ");
        strNutriion.append("t_visit INNER JOIN t_visit_vital_sign ");
        strNutriion.append("ON	 t_visit.t_visit_id = t_visit_vital_sign.t_visit_id ");
        strNutriion.append("INNER JOIN t_patient ");
        strNutriion.append("ON t_patient.t_patient_id  = t_visit.t_patient_id ");
        strNutriion.append("INNER JOIN t_health_family ");
        strNutriion.append("ON t_health_family.t_health_family_id = t_patient.t_health_family_id ");
        strNutriion.append("INNER JOIN t_patient_payment  ");
        strNutriion.append("	ON t_health_family.t_health_family_id = t_patient_payment.t_health_family_id  ");
        strNutriion.append("INNER JOIN b_contract_plans  ");
        strNutriion.append("	ON t_patient_payment.b_contact_plans_id = b_contract_plans.b_contract_plans_id	 ");
        strNutriion.append("INNER JOIN r_plan_group_map_pttype ");
        strNutriion.append("	ON b_contract_plans.contract_plans_pttype = r_plan_group_map_pttype.plan_group_map_pttype_pttype ");
        strNutriion.append("INNER JOIN r_plan_group ");
        strNutriion.append("	ON r_plan_group_map_pttype.r_plan_group_id = r_plan_group.r_plan_group_id ");
        strNutriion.append("where  ");
        strNutriion.append("t_visit.f_visit_status_id <> '4' ");
        strNutriion.append("AND t_visit.f_visit_type_id = '0'   ");
        strNutriion.append("AND t_visit_vital_sign.visit_vital_sign_height <> '' ");
        strNutriion.append("AND t_visit_vital_sign.visit_vital_sign_weight <> '' ");
        strNutriion.append("AND t_patient_payment.patient_payment_priority = '0' ");
        strNutriion.append("AND substring(t_visit.visit_financial_discharge_time,0,11) Between '"+startDate+"' and '"+endDate+"'  ");
        if(!isJan)
        {            
            strNutriion.append("AND t_health_family.t_health_family_id NOT IN (select  ");
            strNutriion.append("	t_health_family.t_health_family_id ");
            strNutriion.append("from  ");
            strNutriion.append("	t_health_nutrition INNER JOIN t_health_family ");
            strNutriion.append("	ON t_health_family.t_health_family_id = t_health_nutrition.t_health_family_id ");
            strNutriion.append("where  ");
            strNutriion.append("	t_health_nutrition.health_nutrition_active = '1'  ");
            strNutriion.append("	AND t_health_nutrition.health_nutrition_high <> '' ");
            strNutriion.append("	AND t_health_nutrition.health_nutrition_weight <> '' ");
            strNutriion.append("	AND (((to_number(t_health_nutrition.health_nutrition_bmi,'99.99') < 18.5) ");
            strNutriion.append("		and (to_number(t_health_nutrition.health_nutrition_bmi,'99.99') > 24.9)) ");
            strNutriion.append("		or (t_health_nutrition.f_health_nutrition_level_id <> '10'   ");
            strNutriion.append("		and t_health_nutrition.f_health_nutrition_level_id <> 'N' ) ");
            strNutriion.append("		) ");
            strNutriion.append("	AND (substring(t_health_nutrition.record_date_time,0,8) >= '"+startCheckDate+"'  ");
            strNutriion.append("		and substring(t_health_nutrition.record_date_time,0,8) < '"+endCheckDate+"' ) ");
            strNutriion.append("group by  ");
            strNutriion.append("	t_health_family.t_health_family_id ");
            strNutriion.append("UNION  ");
            strNutriion.append("select  ");
            strNutriion.append("	t_health_family.t_health_family_id ");
            strNutriion.append("from  ");
            strNutriion.append("	t_visit INNER JOIN t_visit_vital_sign ");
            strNutriion.append("	ON	 t_visit.t_visit_id = t_visit_vital_sign.t_visit_id ");
            strNutriion.append("	INNER JOIN t_patient ");
            strNutriion.append("	ON t_patient.t_patient_id  = t_visit.t_patient_id ");
            strNutriion.append("	INNER JOIN t_health_family ");
            strNutriion.append("	ON t_health_family.t_health_family_id = t_patient.t_health_family_id ");
            strNutriion.append("where ");
            strNutriion.append("	t_visit.f_visit_status_id <> '4' ");
            strNutriion.append("	AND t_visit.f_visit_type_id = '0'   ");
            strNutriion.append("	AND t_visit_vital_sign.visit_vital_sign_height <> '' ");
            strNutriion.append("	AND t_visit_vital_sign.visit_vital_sign_weight <> '' ");
            strNutriion.append("	AND (((to_number(t_visit_vital_sign.visit_vital_sign_bmi,'99.99') < 18.5) ");
            strNutriion.append("		and (to_number(t_visit_vital_sign.visit_vital_sign_bmi,'99.99') > 24.9)) ");
            strNutriion.append("		or (t_visit_vital_sign.f_visit_nutrition_level_id <> '10'  ");
            strNutriion.append("		and t_visit_vital_sign.f_visit_nutrition_level_id <> 'N' ) ");
            strNutriion.append("		) ");
            strNutriion.append("	AND (substring(t_visit.visit_financial_discharge_time,0,8) >= '"+startCheckDate+"'  ");
            strNutriion.append("		and substring(t_visit.visit_financial_discharge_time,0,8) < '"+endCheckDate+"')  ");
            strNutriion.append("group by  ");
            strNutriion.append("	t_health_family.t_health_family_id)  ");
        }
        strNutriion.append("group by  ");
        strNutriion.append("t_health_family.t_health_family_id ");
        strNutriion.append(", t_health_family.patient_name ");
        strNutriion.append(", t_health_family.patient_last_name ");
        strNutriion.append(", plan_group_id ");
        strNutriion.append(", baby_fail ");
        strNutriion.append(", baby_exceed ");
        strNutriion.append(", child_fail ");
        strNutriion.append(", child_exceed ");
        strNutriion.append(", man_fail ");
        strNutriion.append(", man_exceed ");        
        strNutriion.append("UNION  ");        
        strNutriion.append("select  ");
        strNutriion.append("distinct ");
        strNutriion.append("t_health_family.t_health_family_id ");
        strNutriion.append(", t_health_family.patient_name ");
        strNutriion.append(", t_health_family.patient_last_name ");
        strNutriion.append(",CASE  WHEN ((r_plan_group.plan_group_number = '1' ) OR (r_plan_group.plan_group_number = '2' ) )  ");
        strNutriion.append("THEN  r_plan_group.plan_group_number  ");
        strNutriion.append("WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strNutriion.append("		AND ((t_patient_payment.patient_payment_main_hospital IN (Select  hospital_incup_code  ");
        strNutriion.append("		from r_hospital_incup))  OR (t_patient_payment.patient_payment_sub_hospital IN  ");
        strNutriion.append("		(Select  hospital_incup_code from r_hospital_incup))) ) ");
        strNutriion.append("THEN '3'  ");
        strNutriion.append("WHEN (((r_plan_group.plan_group_number = '3' ) OR (r_plan_group.plan_group_number = '4' ) ) ");
        strNutriion.append("		AND ( ((t_patient_payment.patient_payment_main_hospital = '')  ");
        strNutriion.append("		AND (t_patient_payment.patient_payment_sub_hospital = ''))  ");
        strNutriion.append("		OR ((t_patient_payment.patient_payment_main_hospital NOT IN (Select  hospital_incup_code  ");
        strNutriion.append("		from r_hospital_incup))  AND (t_patient_payment.patient_payment_sub_hospital NOT IN  ");
        strNutriion.append("		(Select  hospital_incup_code from r_hospital_incup))) )) ");
        strNutriion.append("THEN '4'  ");
        strNutriion.append("WHEN ((r_plan_group.plan_group_number <> '1' ) AND (r_plan_group.plan_group_number <> '2' )  ");
        strNutriion.append("		AND (r_plan_group.plan_group_number <> '3' ) AND (r_plan_group.plan_group_number <> '4' ) ) ");
        strNutriion.append("THEN  '5'  ");
        strNutriion.append("END AS plan_group_id ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') IS NULL) ");
        strNutriion.append("OR ((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 0) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=5)))  ");
        strNutriion.append("    AND  ");
        strNutriion.append("     ( t_health_nutrition.f_health_nutrition_level_id = '1'  ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '2'  ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '3'  ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '4' ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '11' ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '12' ) ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end AS baby_fail   ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') IS NULL) ");
        strNutriion.append("OR ((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 0) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=5) ");
        strNutriion.append(")) AND  ");
        strNutriion.append("     ( t_health_nutrition.f_health_nutrition_level_id  = '5'  ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '6'  ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '7'  ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '08' ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '09')  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end AS baby_exceed  ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 6) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=14) ");
        strNutriion.append(") AND  ");
        strNutriion.append("     ( t_health_nutrition.f_health_nutrition_level_id = '1'  ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '2'  ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '3'  ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '4' ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '11' ");
        strNutriion.append("	OR t_health_nutrition.f_health_nutrition_level_id = '12' ) ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS child_fail  ");
        strNutriion.append(", case when (((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append("  ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') >= 6) ");
        strNutriion.append("      AND (to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') <=14) ");
        strNutriion.append(") AND  ");
        strNutriion.append("     ( t_health_nutrition.f_health_nutrition_level_id  = '5'  ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '6'  ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '7'  ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '08' ");
        strNutriion.append("       OR  t_health_nutrition.f_health_nutrition_level_id = '09')  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS child_exceed  ");
        strNutriion.append(", case when  ((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') > 15) ");
        strNutriion.append(" AND  ");
        strNutriion.append("    (to_number(t_health_nutrition.health_nutrition_bmi,'99.99') < 18.5)  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS man_fail   ");
        strNutriion.append(", case when  ((to_number((substring(' ' || age(to_date(substring(t_health_nutrition.record_date_time,0,11)  ");
        strNutriion.append(" ,'YYYY-MM-DD'), to_date(t_health_family.patient_birthday,'YYYY-MM-DD')) from '(...)year') ),'999') > 15) ");
        strNutriion.append("  AND  ");
        strNutriion.append("    (to_number(t_health_nutrition.health_nutrition_bmi,'99.99') > 24.9)  ");
        strNutriion.append("    ) ");
        strNutriion.append("then 1 ");
        strNutriion.append("else 0  ");
        strNutriion.append("end  AS man_exceed  ");
        strNutriion.append("from  ");
        strNutriion.append("t_health_nutrition INNER JOIN t_health_family ");
        strNutriion.append("ON t_health_family.t_health_family_id = t_health_nutrition.t_health_family_id ");
        strNutriion.append("INNER JOIN t_patient_payment  ");
        strNutriion.append("	ON t_health_family.t_health_family_id = t_patient_payment.t_health_family_id  ");
        strNutriion.append("INNER JOIN b_contract_plans  ");
        strNutriion.append("	ON t_patient_payment.b_contact_plans_id = b_contract_plans.b_contract_plans_id	 ");
        strNutriion.append("INNER JOIN r_plan_group_map_pttype ");
        strNutriion.append("	ON b_contract_plans.contract_plans_pttype = r_plan_group_map_pttype.plan_group_map_pttype_pttype ");
        strNutriion.append("INNER JOIN r_plan_group ");
        strNutriion.append("	ON r_plan_group_map_pttype.r_plan_group_id = r_plan_group.r_plan_group_id ");
        strNutriion.append("where  ");
        strNutriion.append("t_health_nutrition.health_nutrition_active = '1'  ");
        strNutriion.append("AND t_health_nutrition.health_nutrition_high <> '' ");
        strNutriion.append("AND t_health_nutrition.health_nutrition_weight <> '' ");
        strNutriion.append("AND t_patient_payment.patient_payment_priority = '0' ");
        strNutriion.append("AND (substring(t_health_nutrition.record_date_time,0,11) Between '"+startDate+"' and '"+startDate+"' ) ");
        if(!isJan)
        {
            strNutriion.append("AND t_health_family.t_health_family_id NOT IN (select  ");
            strNutriion.append("			t_health_family.t_health_family_id ");
            strNutriion.append("		from  ");
            strNutriion.append("			t_health_nutrition INNER JOIN t_health_family ");
            strNutriion.append("			ON t_health_family.t_health_family_id = t_health_nutrition.t_health_family_id ");
            strNutriion.append("		where  ");
            strNutriion.append("			t_health_nutrition.health_nutrition_active = '1'  ");
            strNutriion.append("			AND t_health_nutrition.health_nutrition_high <> '' ");
            strNutriion.append("			AND t_health_nutrition.health_nutrition_weight <> '' ");
            strNutriion.append("			AND (((to_number(t_health_nutrition.health_nutrition_bmi,'99.99') < 18.5) ");
            strNutriion.append("				and (to_number(t_health_nutrition.health_nutrition_bmi,'99.99') > 24.9)) ");
            strNutriion.append("				or (t_health_nutrition.f_health_nutrition_level_id <> '10'  ");
            strNutriion.append("				and t_health_nutrition.f_health_nutrition_level_id <> 'N' ) ");
            strNutriion.append("				) ");
            strNutriion.append("			AND (substring(t_health_nutrition.record_date_time,0,8) >= '"+startCheckDate+"'  ");
            strNutriion.append("				and substring(t_health_nutrition.record_date_time,0,8) < '"+endCheckDate+"' ) ");
            strNutriion.append("		group by  ");
            strNutriion.append("			t_health_family.t_health_family_id ");
            strNutriion.append("		UNION  ");
            strNutriion.append("		select  ");
            strNutriion.append("			t_health_family.t_health_family_id ");
            strNutriion.append("		from  ");
            strNutriion.append("			t_visit INNER JOIN t_visit_vital_sign ");
            strNutriion.append("			ON	 t_visit.t_visit_id = t_visit_vital_sign.t_visit_id ");
            strNutriion.append("			INNER JOIN t_patient ");
            strNutriion.append("			ON t_patient.t_patient_id  = t_visit.t_patient_id ");
            strNutriion.append("			INNER JOIN t_health_family ");
            strNutriion.append("			ON t_health_family.t_health_family_id = t_patient.t_health_family_id ");
            strNutriion.append("		where  ");
            strNutriion.append("			t_visit.f_visit_status_id <> '4' ");
            strNutriion.append("			AND t_visit.f_visit_type_id = '0' ");
            strNutriion.append("			AND t_visit_vital_sign.visit_vital_sign_height <> '' ");
            strNutriion.append("			AND t_visit_vital_sign.visit_vital_sign_weight <> '' ");
            strNutriion.append("			AND (((to_number(t_visit_vital_sign.visit_vital_sign_bmi,'99.99') < 18.5) ");
            strNutriion.append("				and (to_number(t_visit_vital_sign.visit_vital_sign_bmi,'99.99') > 24.9)) ");
            strNutriion.append("				or (t_visit_vital_sign.f_visit_nutrition_level_id <> '10'   ");
            strNutriion.append("				and t_visit_vital_sign.f_visit_nutrition_level_id <> 'N' ) ");
            strNutriion.append("				) ");
            strNutriion.append("			AND (substring(t_visit.visit_financial_discharge_time,0,8) >= '"+startCheckDate+"'  ");
            strNutriion.append("				and substring(t_visit.visit_financial_discharge_time,0,8) < '"+endCheckDate+"')  ");
            strNutriion.append("		group by  ");
            strNutriion.append("			t_health_family.t_health_family_id)  ");
        }
        strNutriion.append("group by  ");
        strNutriion.append("t_health_family.t_health_family_id ");
        strNutriion.append(", t_health_family.patient_name ");
        strNutriion.append(", t_health_family.patient_last_name ");
        strNutriion.append(", plan_group_id ");
        strNutriion.append(", baby_fail ");
        strNutriion.append(", baby_exceed ");
        strNutriion.append(", child_fail ");
        strNutriion.append(", child_exceed ");
        strNutriion.append(", man_fail ");
        strNutriion.append(", man_exceed ");        
        strNutriion.append(") AS query1 ");        
        strNutriion.append("ON query1.plan_group_id = r_uc_plan_group.uc_plan_group_number ");
        strNutriion.append("GROUP BY   ");
        strNutriion.append("r_uc_plan_group.uc_plan_group_description  ");
        strNutriion.append(",r_uc_plan_group.uc_plan_group_number  ");
        strNutriion.append("ORDER BY   ");
        strNutriion.append("r_uc_plan_group.uc_plan_group_number  "); 
                   
          System.out.println(" SQL Nutrition : " + strNutriion.toString());
          eNutritionQuery(strNutriion.toString());
          strNutriion = null;
       */
        
        
        
        if(isJan && false)
        {
            String sql = IOStream.readInputDefault("config/rp_standard/standard_1105_part3_nutrition_isjan.sql");
            PreparedStatement pm = theConnectionInf.getConnection().prepareStatement(sql);
            pm.setString(1,startCheckDate);
            pm.setString(2,endCheckDate);
            pm.setString(3,startCheckDate);
            pm.setString(4,endCheckDate);
            pm.setString(5,startDate);
            pm.setString(6,endDate);
            pm.setString(7,startCheckDate);
            pm.setString(8,endCheckDate);
            pm.setString(9,startCheckDate);
            pm.setString(10,endCheckDate);
            pm.setString(11,startDate);
            pm.setString(12,endDate);
            eNutritionQuery(pm.executeQuery());
        }
        else
        {
            String sql = IOStream.readInputDefault("config/rp_standard/standard_1105_part3_nutrition.sql");
            PreparedStatement pm = theConnectionInf.getConnection().prepareStatement(sql);
            System.err.println("startDate " + startDate);
            System.err.println("endDate " + endDate);
            pm.setString(1,startDate);
            pm.setString(2,endDate);
            eNutritionQuery(pm.executeQuery());
        }
        
        
        
 
          sql = null;
          if(this.vReport.size()==0)
          {
              return null;
          }
          else
          {
              return this.vReport;
          }
     }
    
    /**
     * ��Ǩ�ͺ��¡�÷ѹ�������ͧ�ѹ
     * Return Vector �ͧ��õ�Ǩ�ͺ
     * Author Ojika
     **/
    public Vector checkDataDentalProtect()
    {
        Vector vCheck = new Vector();
        String sqlCheck = " select r_dental_protect_item.r_dental_protect_item_id from r_dental_protect_item ";
        vCheck = eVCheck(sqlCheck);
        return vCheck;
    }
    
    /**
     * ��Ǩ�ͺ��¡���Ѥ�չ MMR
     * Return Vector �ͧ��õ�Ǩ�ͺ
     * Author Ojika
     **/
    public Vector checkDataMMR()
    {
        Vector vCheck = new Vector();
        String sqlCheck = " select r_epi_measles_item.r_epi_measles_item_id from r_epi_measles_item ";
        vCheck = eVCheck(sqlCheck);
        return vCheck;
    }
    
    /**
     * ��Ǩ�ͺ��¡���Ѥ�չ�����
     * Return Vector �ͧ��õ�Ǩ�ͺ
     * Author Ojika
     **/
    public Vector checkDataEpiGroup()
    {
        Vector vCheck = new Vector();
        String sqlCheck = " select r_epi_group.r_epi_group_id, count(r_epi_group_item.r_epi_group_item_id) " +
                " from r_epi_group left join r_epi_group_item on r_epi_group.r_epi_group_id = r_epi_group_item.r_epi_group_id " +
                " group by r_epi_group.r_epi_group_id ";
        vCheck = eVEpiGroup(sqlCheck);
        return vCheck;
    }
    
    private Vector eVEpiGroup(String sql)
    {
        Vector vCheck = new Vector();
        try
        {
            rs = theConnectionInf.eQuery(sql);
            
            if(rs!= null)
            {
                thecheckDataObject = new checkDataObject();
                while(rs.next())
                {
                    thecheckDataObject.code = rs.getString(1);
                    thecheckDataObject.code_item = rs.getString(2);
                    
                    vCheck.add(thecheckDataObject);
                }
                thecheckDataObject = null;
                rs.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        } 
        
        return vCheck;
    }
    
    private Vector eVCheck(String sql)
    {
        Vector vCheck = new Vector();
        try
        {
            rs = theConnectionInf.eQuery(sql);
            
            if(rs!= null)
            {
                while(rs.next())
                {
                    vCheck.add(rs.getString(1));
                }
                rs.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }   
        
        return vCheck;
    }
    /**
     * Healthy
     */
    public void eHealthyQuery(ResultSet rs)
    {
    
        try{
           // rs = theConnectionInf.eQuery(sql);
            this.vReport= new Vector();
            theRP115Group3Healthy_2549 = new RP115Group3Healthy_2549();
            if(rs!= null)
            {
                while(rs.next())
                {
                    theRP115Group3Healthy_2549 = new RP115Group3Healthy_2549();
                    
                    theRP115Group3Healthy_2549.plan_type = rs.getString(1);
                    theRP115Group3Healthy_2549.wellbaby = rs.getString(2);
                    if(theRP115Group3Healthy_2549.wellbaby == null
                            || theRP115Group3Healthy_2549.wellbaby.equalsIgnoreCase("")
                            || theRP115Group3Healthy_2549.wellbaby.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Healthy_2549.wellbaby  = "0";
                    }
                    
                    theRP115Group3Healthy_2549.healthy614 = rs.getString(3);
                    if(theRP115Group3Healthy_2549.healthy614 == null
                            || theRP115Group3Healthy_2549.healthy614.equalsIgnoreCase("")
                            || theRP115Group3Healthy_2549.healthy614.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Healthy_2549.healthy614  = "0";
                    }
                    
                    theRP115Group3Healthy_2549.healthy15Up = rs.getString(4);
                    if(theRP115Group3Healthy_2549.healthy15Up == null
                            || theRP115Group3Healthy_2549.healthy15Up.equalsIgnoreCase("")
                            || theRP115Group3Healthy_2549.healthy15Up.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Healthy_2549.healthy15Up  = "0";
                    }
                    
                    this.vReport.add(theRP115Group3Healthy_2549);
                    theRP115Group3Healthy_2549 = null;
                }
                rs.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
    } 
    
    /**
     * Epi
     */
    public void eEpiQuery(ResultSet rs)
    {
    
        try{
    //    rs = theConnectionInf.eQuery(sql);
        this.vReport= new Vector();
        theRP115Group3Epi_2549 = new RP115Group3Epi_2549();
            if(rs!= null)
            {
                while(rs.next())
                {
                    theRP115Group3Epi_2549 = new RP115Group3Epi_2549();
                    
                    theRP115Group3Epi_2549.plan_type = rs.getString(1);
                    theRP115Group3Epi_2549.DPT = rs.getString(2);
                    if(theRP115Group3Epi_2549.DPT == null
                            || theRP115Group3Epi_2549.DPT.equalsIgnoreCase("")
                            || theRP115Group3Epi_2549.DPT.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Epi_2549.DPT  = "0";
                    }
                    
                    theRP115Group3Epi_2549.BCG = rs.getString(3);
                    if(theRP115Group3Epi_2549.BCG == null
                            || theRP115Group3Epi_2549.BCG.equalsIgnoreCase("")
                            || theRP115Group3Epi_2549.BCG.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Epi_2549.BCG = "0";
                    }
                    
                    theRP115Group3Epi_2549.MMR = rs.getString(4);
                    if(theRP115Group3Epi_2549.MMR == null
                            || theRP115Group3Epi_2549.MMR.equalsIgnoreCase("")
                            || theRP115Group3Epi_2549.MMR.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Epi_2549.MMR  = "0";
                    }
                    
                    theRP115Group3Epi_2549.Hep = rs.getString(5);
                    if(theRP115Group3Epi_2549.Hep == null
                            || theRP115Group3Epi_2549.Hep.equalsIgnoreCase("")
                            || theRP115Group3Epi_2549.Hep.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Epi_2549.Hep  = "0";
                    }
                    
                    this.vReport.add(theRP115Group3Epi_2549);
                    theRP115Group3Epi_2549 = null;
                }
                rs.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
    } 
    
    /**
     * Dental Protect
     */
    public void eDentalProtectQuery(ResultSet rs)
    {
    
        try{
      //  rs = theConnectionInf.eQuery(sql);
        this.vReport= new Vector();
        theRP115Group3DentalProtect_2549 = new RP115Group3DentalProtect_2549();
            if(rs != null)
            {
                while(rs.next())
                {
                    theRP115Group3DentalProtect_2549 = new RP115Group3DentalProtect_2549();
                    
                    theRP115Group3DentalProtect_2549.plan_type = rs.getString(1);
                    theRP115Group3DentalProtect_2549.dentalProtect_baby = rs.getString(2);
                    if(theRP115Group3DentalProtect_2549.dentalProtect_baby == null
                            || theRP115Group3DentalProtect_2549.dentalProtect_baby.equalsIgnoreCase("")
                            || theRP115Group3DentalProtect_2549.dentalProtect_baby.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3DentalProtect_2549.dentalProtect_baby  = "0";
                    }
                    
                    theRP115Group3DentalProtect_2549.dentalProtect_child = rs.getString(3);
                    if(theRP115Group3DentalProtect_2549.dentalProtect_child == null
                            || theRP115Group3DentalProtect_2549.dentalProtect_child.equalsIgnoreCase("")
                            || theRP115Group3DentalProtect_2549.dentalProtect_child.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3DentalProtect_2549.dentalProtect_child  = "0";
                    }
                    
                    this.vReport.add(theRP115Group3DentalProtect_2549);
                    theRP115Group3DentalProtect_2549 = null;
                }
                rs.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
    }
    
    /**
     * MMR
     */
    public void eMMRQuery(ResultSet rs)
    {
    
        try{
        //rs = theConnectionInf.eQuery(sql);
        this.vReport= new Vector();
        theRP115Group3MMR_2549 = new RP115Group3MMR_2549();
            if(rs!=null)
            {
                while(rs.next())
                {
                    theRP115Group3MMR_2549 = new RP115Group3MMR_2549();
                    
                    theRP115Group3MMR_2549.plan_type = rs.getString(1);
                    theRP115Group3MMR_2549.MMR614 = rs.getString(2);
                    if(theRP115Group3MMR_2549.MMR614 == null
                            || theRP115Group3MMR_2549.MMR614.equalsIgnoreCase("")
                            || theRP115Group3MMR_2549.MMR614.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3MMR_2549.MMR614  = "0";
                    }
                    
                    this.vReport.add(theRP115Group3MMR_2549);
                    theRP115Group3MMR_2549 = null;
                }
                rs.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
    }
    
    /**
     * Nutrition
     */
    public void eNutritionQuery(ResultSet rs)
    {
    
        try{
        //rs = theConnectionInf.eQuery(sql);
        this.vReport= new Vector();
        theRP115Group3Nutrition_2549 = new RP115Group3Nutrition_2549();
            if(rs != null)
            {
                while(rs.next())
                {
                    theRP115Group3Nutrition_2549 = new RP115Group3Nutrition_2549();
                    
                    theRP115Group3Nutrition_2549.plan_type = rs.getString(1);
                    theRP115Group3Nutrition_2549.baby_fail = rs.getString(2);
                    if(theRP115Group3Nutrition_2549.baby_fail == null
                            || theRP115Group3Nutrition_2549.baby_fail.equalsIgnoreCase("")
                            || theRP115Group3Nutrition_2549.baby_fail.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Nutrition_2549.baby_fail  = "0";
                    }
                    
                    theRP115Group3Nutrition_2549.baby_exceed = rs.getString(3);
                    if(theRP115Group3Nutrition_2549.baby_exceed == null
                            || theRP115Group3Nutrition_2549.baby_exceed.equalsIgnoreCase("")
                            || theRP115Group3Nutrition_2549.baby_exceed.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Nutrition_2549.baby_exceed = "0";
                    }
                    
                    theRP115Group3Nutrition_2549.child_fail = rs.getString(4);
                    if(theRP115Group3Nutrition_2549.child_fail == null
                            || theRP115Group3Nutrition_2549.child_fail.equalsIgnoreCase("")
                            || theRP115Group3Nutrition_2549.child_fail.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Nutrition_2549.child_fail  = "0";
                    }
                    
                    theRP115Group3Nutrition_2549.child_exceed = rs.getString(5);
                    if(theRP115Group3Nutrition_2549.child_exceed == null
                            || theRP115Group3Nutrition_2549.child_exceed.equalsIgnoreCase("")
                            || theRP115Group3Nutrition_2549.child_exceed.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Nutrition_2549.child_exceed  = "0";
                    }
                    
                    theRP115Group3Nutrition_2549.man_fail = rs.getString(6);
                    if(theRP115Group3Nutrition_2549.man_fail == null
                            || theRP115Group3Nutrition_2549.man_fail.equalsIgnoreCase("")
                            || theRP115Group3Nutrition_2549.man_fail.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Nutrition_2549.man_fail  = "0";
                    }
                    
                    theRP115Group3Nutrition_2549.man_exceed = rs.getString(7);
                    if(theRP115Group3Nutrition_2549.man_exceed == null
                            || theRP115Group3Nutrition_2549.man_exceed.equalsIgnoreCase("")
                            || theRP115Group3Nutrition_2549.man_exceed.equalsIgnoreCase("NULL"))
                    {
                        theRP115Group3Nutrition_2549.man_exceed  = "0";
                    }
                    
                    this.vReport.add(theRP115Group3Nutrition_2549);
                    theRP115Group3Nutrition_2549 = null;
                }
                rs.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
    }
    
    /**
     *  ��㹡�� Convert Object �� String �·���Ѻ ��� true ���� false �������ҧ��Ǥ�������������
     *  ����� true ������ʴ���Ǥ������ ����� Tab �繵�Ǥ�� 
     *  ����� false ������ʴ������Ǥ������ ����� Pipe �繵�Ǥ��
     *  @param vObject �� Vector �ͧ Obeject ��� RP115Group3_2549
     *  @param isGetColumnName �� Boolean ����� true ������ʴ���Ǥ������ ����� false ������ʴ������Ǥ������ 
     *  @param obj �� String ��������͵�Ǩ�ͺ��� Object � ���١������� Vector 
     *  @return �� String �ͧ Sql ����ա���ŧ������º��������
     */
    public String convertToString(Vector vObject,boolean isGetColumnName)
    {
        StringBuffer sql = new StringBuffer();
        String separator = Constant.PIPE;
        System.out.println("------------- SIZE DATA ------------ " + vObject.size());
        if(vObject != null)
        {
                RP115Group3_2549 p = null;
                if(isGetColumnName)
                {
                    separator = Constant.TAB;
                    sql.append(Gutil.getTextBundle("TypePlan")+separator
                            +Gutil.getTextBundle("WellBaby")+separator
                            +Gutil.getTextBundle("DPT")+separator
                            +Gutil.getTextBundle("BCG")+separator
                            +Gutil.getTextBundle("MMR")+separator
                            +Gutil.getTextBundle("Hep")+separator
                            +Gutil.getTextBundle("baby_fail")+separator
                            +Gutil.getTextBundle("baby_exceed")+separator
                            +Gutil.getTextBundle("dentalProtect_baby")+separator
                            +Gutil.getTextBundle("Healthy614")+separator
                            +Gutil.getTextBundle("MMR614")+separator
                            +Gutil.getTextBundle("child_fail")+separator
                            +Gutil.getTextBundle("child_exceed")+separator
                            +Gutil.getTextBundle("dentalProtect_child")+separator
                            +Gutil.getTextBundle("Healthy15Up")+separator
                            +Gutil.getTextBundle("man_fail")+separator
                            +Gutil.getTextBundle("man_exceed")
                            +Constant.NEWLINE);
                }
                for(int i=0;i<vObject.size();i++)
                {                    
                    p = (RP115Group3_2549)vObject.elementAt(i);
                    sql.append(p.plan_type + separator      
                            + p.wellbaby + separator
                            + p.DPT + separator
                            + p.BCG + separator
                            + p.MMR + separator
                            + p.Hep + separator
                            + p.baby_fail + separator
                            + p.baby_exceed + separator
                            + p.dentalProtect_baby + separator
                            + p.healthy614 + separator
                            + p.MMR614 + separator
                            + p.child_fail + separator
                            + p.child_exceed + separator
                            + p.dentalProtect_child + separator
                            + p.healthy15Up + separator
                            + p.man_fail + separator
                            + p.man_exceed 
                            + Constant.NEWLINE);
                    System.out.println("------------- DATA ------------ " + p.plan_type);
                }
           
        }
        return sql.toString();
    }
    
    
    
    
    
}
