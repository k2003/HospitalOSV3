/*s*/SELECT  	t_patient.patient_hn AS HN 	, CASE WHEN (length(t_visit.visit_begin_visit_time)>=10)then to_char(to_date(to_number(substr(t_visit.visit_begin_visit_time,1,4),'9999')-543 || substr(t_visit.visit_begin_visit_time,5,6),'yyyy-mm-dd'),'yyyymmdd')                     ELSE ''   END AS DATEOPD      , (t_visit.f_visit_type_id || b_report_12files_map_clinic.b_report_12files_std_clinic_id || '1') AS CLINIC      , visit_refer_in_out_refer_hospital as REFER      , CASE WHEN f_visit_refer_type_id ='1'            THEN '2'             ELSE '1' END AS REFERTYPE	,t_visit.visit_vn AS SEQ	,t_patient.patient_pid AS PERSON_IDFROM t_visit_refer_in_out	INNER JOIN t_visit  on (t_visit.t_visit_id = t_visit_refer_in_out.t_visit_id) 	LEFT JOIN t_patient ON (t_patient.t_patient_id = t_visit.t_patient_id)  	LEFT JOIN t_diag_icd10  ON (t_diag_icd10.diag_icd10_vn = t_visit.t_visit_id         AND t_diag_icd10.f_diag_icd10_type_id = '1'        AND t_diag_icd10.diag_icd10_active = '1' ) 	LEFT JOIN b_report_12files_map_clinic  ON (t_diag_icd10.b_visit_clinic_id = b_report_12files_map_clinic.b_visit_clinic_id)WHERE    t_visit.f_visit_status_id <> '4' 	AND visit_refer_in_out_active = '1'	AND t_visit.f_visit_type_id = '0'	AND substring(t_visit.visit_begin_visit_time,1,10) >= ?	AND substring(t_visit.visit_begin_visit_time,1,10) <= ?    and t_visit.f_visit_type_id <> 'S'ORDER BY HN