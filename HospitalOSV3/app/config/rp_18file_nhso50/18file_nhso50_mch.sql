/*test*/
SELECT
	b_site.b_visit_office_id AS PCUCODE
	, t_health_family.health_family_hn_hcis AS PID
	, t_health_pregnancy.health_pregnancy_gravida_number AS GRAVIDA
	, CASE WHEN (length(t_health_pregnancy.health_pregnancy_menses_issue_date)>=10)
        then to_char(to_date(to_number(
        substr(t_health_pregnancy.health_pregnancy_menses_issue_date,1,4),'9999')-543 ||
        substr(t_health_pregnancy.health_pregnancy_menses_issue_date,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END AS LMP
	, CASE WHEN (length(t_health_pregnancy.health_pregnancy_menses_expire_date)>=10)
        then to_char(to_date(to_number(
        substr(t_health_pregnancy.health_pregnancy_menses_expire_date,1,4),'9999')-543 ||
        substr(t_health_pregnancy.health_pregnancy_menses_expire_date,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END AS EDC

	, CASE WHEN (t_health_anc.health_anc_vdrl ='0'
                OR t_health_anc.health_anc_vdrl ='3') then '1'
               else t_health_anc.health_anc_vdrl END AS VDRL_RS
	, CASE WHEN (t_health_anc.health_anc_hb ='0'
                OR t_health_anc.health_anc_hb ='3') then '1'
               else t_health_anc.health_anc_hb END AS HB_RS
	, CASE WHEN (t_health_anc.health_anc_hiv ='0'
                 OR t_health_anc.health_anc_hiv ='3') then '1'
               else t_health_anc.health_anc_hiv END AS  HIV_RS
	,  CASE WHEN (length(t_health_anc.health_anc_hct_date)>=10)
        then to_char(to_date(to_number(
        substr(t_health_anc.health_anc_hct_date,1,4),'9999')-543 ||
        substr(t_health_anc.health_anc_hct_date,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END AS DATEHCT
	, CASE WHEN t_health_anc.health_anc_hct_result  is not null
		THEN t_health_anc.health_anc_hct_result
		ELSE '0' END  AS HCT_RS
	, CASE WHEN (t_health_anc.health_anc_thalassemia ='0'
                OR t_health_anc.health_anc_thalassemia ='3') then '1'
               else t_health_anc.health_anc_thalassemia END AS THALASS
	, t_health_anc.health_anc_dental_exam  as DENTAL
	,t_health_anc.health_anc_dental_caries  AS TCARIES
        , CASE WHEN (t_health_anc.health_anc_dental_tartar='0'
                OR t_health_anc.health_anc_dental_tartar='1')
                THEN t_health_anc.health_anc_dental_tartar
                ELSE '0' END AS TARTAR
        , CASE WHEN (t_health_anc.health_anc_dental_gum ='0'
                OR t_health_anc.health_anc_dental_gum ='1')
                THEN t_health_anc.health_anc_dental_gum
                ELSE '0' END AS GUMINF
	, CASE WHEN (length(t_health_delivery.health_delivery_born_date)>=10)
        then to_char(to_date(to_number(
        substr(t_health_delivery.health_delivery_born_date,1,4),'9999')-543 ||
        substr(t_health_delivery.health_delivery_born_date,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END AS BDATE
	, b_icd10.icd10_number AS BRESULT
	, t_health_delivery.f_health_postpartum_birth_place_id AS BPLACE
	, t_health_delivery.b_visit_office_birth_place AS BHOSP
	, CASE
		WHEN (t_health_delivery.f_health_birth_method_id = '1'
			OR  t_health_delivery.f_health_birth_method_id = '2'
			OR  t_health_delivery.f_health_birth_method_id = '3'
			OR  t_health_delivery.f_health_birth_method_id = '4'
			OR  t_health_delivery.f_health_birth_method_id = '5'
			OR  t_health_delivery.f_health_birth_method_id = '6')
			THEN t_health_delivery.f_health_birth_method_id
		ELSE '1' END AS BTYPE
	, t_health_delivery.f_health_pregnancy_birth_doctor_type_id AS BDOCTOR
	, t_health_delivery.health_delivery_parity AS LBORN
	, t_health_delivery.health_delivery_stillborn AS SBORN
	, max(CASE WHEN (length(SUB0.update_date_time)>=10 and health_postpartum_visit='1')
        then to_char(to_date(to_number(
        substr(SUB0.update_date_time,1,4),'9999')-543 ||
        substr(SUB0.update_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END) AS PPCARE1
	, max(CASE WHEN (length(SUB0.update_date_time)>=10 and health_postpartum_visit='2')
        then to_char(to_date(to_number(
        substr(SUB0.update_date_time,1,4),'9999')-543 ||
        substr(SUB0.update_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END) AS PPCARE2
	, max(CASE WHEN (length(SUB0.update_date_time)>=10 and health_postpartum_visit='3')
        then to_char(to_date(to_number(
        substr(SUB0.update_date_time,1,4),'9999')-543 ||
        substr(SUB0.update_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END) AS PPCARE3
	, case when SUB0.health_postpartum_summary_verify='0' then '2'
        else SUB0.health_postpartum_summary_verify end AS PPRES
	, max(CASE WHEN (length(SUB0.record_date_time)>=10)
        then to_char(to_date(to_number(
        substr(SUB0.record_date_time,1,4),'9999')-543 ||
        substr(SUB0.record_date_time,5,6),'yyyy-mm-dd'),'yyyymmdd')
                    ELSE ''   END) AS  UPDATE

/*,SUB0.t_health_postpartum_id
,health_postpartum_visit
,health_pregnancy_gravida_number
,health_postpartum_pregnant_number
,t_health_pregnancy.t_health_pregnancy_id*/
FROM t_health_pregnancy
    INNER JOIN t_health_family ON t_health_pregnancy.t_health_family_id = t_health_family.t_health_family_id
    LEFT JOIN t_health_delivery ON (t_health_pregnancy.t_health_family_id = t_health_delivery.t_health_family_id
        and t_health_delivery.gravida_number = t_health_pregnancy.health_pregnancy_gravida_number
        and t_health_delivery.health_delivery_active = '1')
    LEFT JOIN (select t_health_pregnancy_id,max(record_date_time) as record
                    from t_health_anc where health_anc_active = '1' group by t_health_pregnancy_id
        ) as anc1 ON (anc1.t_health_pregnancy_id = t_health_pregnancy.t_health_pregnancy_id )

    LEFT JOIN t_health_postpartum as SUB0  ON (t_health_pregnancy.t_health_family_id = SUB0.t_health_family_id
        and t_health_pregnancy.health_pregnancy_gravida_number = SUB0.health_postpartum_pregnant_number
        and SUB0.health_postpartum_active = '1')
    LEFT JOIN t_health_anc ON (t_health_anc.t_health_pregnancy_id = t_health_pregnancy.t_health_pregnancy_id
        and t_health_anc.record_date_time = anc1.record
        and t_health_anc.health_anc_active = '1')
    LEFT JOIN b_icd10   ON (t_health_delivery.b_icd10_id = b_icd10.b_icd10_id )
	,b_site

WHERE  health_family_active = '1'
    and t_health_pregnancy.health_pregnancy_active = '1'
    AND substring(SUB0.record_date_time,1,10) >= ?
    AND substring(SUB0.record_date_time,1,10) <= ?

group by pcucode,pid,gravida,lmp,  edc,  vdrl_rs,hb_rs,hiv_rs,datehct,hct_rs
,thalass,dental,tcaries,tartar,guminf,bdate,bresult,bplace,bhosp,btype
,bdoctor,lborn,sborn,ppres
 order by pid
