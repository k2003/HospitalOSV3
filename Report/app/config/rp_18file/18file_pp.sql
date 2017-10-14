--ทดสอบภาษาไทย

SELECT  b_site.b_visit_office_id AS PCUCODE
        , t_health_family.health_family_hn_hcis AS PID
        , mother.health_family_hn_hcis AS MPID
        , t_health_pp.pp_gravida AS GRAVIDA
, CASE			
    WHEN (t_health_delivery.health_delivery_born_date <> ''		
        AND t_health_delivery.health_delivery_born_date <> 'null')	
        THEN   (to_number(substring(t_health_delivery.health_delivery_born_date,1,4),'9999')-543)	
        ||  substring(t_health_delivery.health_delivery_born_date,6,2)	
        ||  substring(t_health_delivery.health_delivery_born_date,9,2)	
    ELSE ''   END as 		 BDATE
, t_health_delivery.f_health_postpartum_birth_place_id as 		 BPLACE
, t_health_delivery.b_visit_office_birth_place as 		 BHOSP
, CASE WHEN (t_health_delivery.f_health_birth_method_id='1'
        OR t_health_delivery.f_health_birth_method_id='2'
        OR t_health_delivery.f_health_birth_method_id='3'
        OR t_health_delivery.f_health_birth_method_id='4'
        OR t_health_delivery.f_health_birth_method_id='5')
    THEN t_health_delivery.f_health_birth_method_id 
        ELSE '' END AS 		 BTYPE
, t_health_delivery.f_health_pregnancy_birth_doctor_type_id as 		 BDOCTOR  
        , t_health_pp.pp_weight AS BWEIGTH
        , CASE
                WHEN (t_health_pp.pp_lost_oxygen= '0')	THEN '1'
                WHEN (t_health_pp.pp_lost_oxygen = '1')  THEN '0'
                ELSE t_health_pp.pp_lost_oxygen END AS ASPHYXIA
        , t_health_pp.pp_vit_k AS VITK
	, max(CASE WHEN (length(SUB1.pp_care_record_date_time)>=10 
            and SUB1.pp_care_number ='1')
        then to_char(to_date(to_number(
        substr(SUB1.pp_care_record_date_time,1,4),'9999')-543 || 
        substr(SUB1.pp_care_record_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd') 
                    ELSE ''   END) AS BCARE1
	, max(CASE WHEN (length(SUB1.pp_care_record_date_time)>=10 
            and SUB1.pp_care_number ='2')
        then to_char(to_date(to_number(
        substr(SUB1.pp_care_record_date_time,1,4),'9999')-543 || 
        substr(SUB1.pp_care_record_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd') 
                    ELSE ''   END) AS BCARE2
	, max(CASE WHEN (length(SUB1.pp_care_record_date_time)>=10
            and SUB1.pp_care_number ='3')
        then to_char(to_date(to_number(
        substr(SUB1.pp_care_record_date_time,1,4),'9999')-543 || 
        substr(SUB1.pp_care_record_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd') 
                    ELSE ''   END) AS BCARE3
        , case when SUB1.pp_care_result<>'2' then '1'
        else '2' end AS BCRES
	, max(CASE WHEN (length(SUB1.pp_care_record_date_time)>=10)
        then to_char(to_date(to_number(
        substr(SUB1.pp_care_record_date_time,1,4),'9999')-543 || 
        substr(SUB1.pp_care_record_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd') 
                    ELSE ''   END) AS update
        ,t_health_pp.pp_mother_pid

FROM t_health_pp_care AS SUB1
    INNER JOIN t_patient                ON SUB1.t_patient_id = t_patient.t_patient_id
    INNER JOIN t_health_family  AS mother  ON (mother.t_health_family_id = t_patient.t_health_family_id)
    INNER JOIN t_health_family ON t_health_family.t_health_family_id = SUB1.t_health_family_id
    LEFT JOIN  t_health_pp   ON (t_health_pp.t_health_family_id= SUB1.t_health_family_id
        and t_health_pp.pp_active  = '1')
    LEFT JOIN t_health_delivery   ON (mother.t_health_family_id = t_health_delivery.t_health_family_id
        and t_health_pp.pp_gravida = t_health_delivery.gravida_number
        and t_health_delivery.health_delivery_active = '1')
    ,b_site

WHERE SUB1.pp_care_active='1'
    AND mother.health_family_active = '1'
        AND substring(SUB1.pp_care_record_date_time,1,10) >= ?
        AND substring(SUB1.pp_care_record_date_time,1,10) <=?

group by pcucode,pid,mpid,gravida,bdate,bplace,bhosp,btype,bdoctor,bweigth,asphyxia,vitk,BCRES,t_health_pp.pp_mother_pid
 
