/*ทดสอบภาษาไทย*/
SELECT 
	t_patient.patient_hn AS HN  
	, CASE WHEN (length(t_visit.visit_begin_visit_time)>=10)
then to_char(to_date(to_number(
substr(t_visit.visit_begin_visit_time,1,4),'9999')-543 || 
substr(t_visit.visit_begin_visit_time,5,6),'yyyy-mm-dd'),'yyyymmdd') 
                    ELSE ''   END AS DATEDX  
	, (t_visit.f_visit_type_id 
		|| b_report_12files_map_clinic.b_report_12files_std_clinic_id 
		|| '1') AS CLINIC  
	, (substring(t_diag_icd10.diag_icd10_number,0,4) 
		|| substr(t_diag_icd10.diag_icd10_number,5)) AS DIAG 
	, CASE WHEN t_diag_icd10.f_diag_icd10_type_id='5'
        THEN '4'
        ELSE t_diag_icd10.f_diag_icd10_type_id END AS DXTYPE  
	, b_employee.employee_number AS DRDX  
	,t_patient.patient_pid AS PERSON_ID
	,t_visit.visit_vn AS SEQ

FROM 	t_diag_icd10  
	INNER JOIN t_visit ON (t_diag_icd10.diag_icd10_vn = t_visit.t_visit_id) 
	INNER JOIN t_patient ON (t_patient.t_patient_id = t_visit.t_patient_id) 
	LEFT JOIN b_report_12files_map_clinic 
		ON (t_diag_icd10.b_visit_clinic_id = b_report_12files_map_clinic.b_visit_clinic_id) 
	LEFT JOIN b_employee ON (t_diag_icd10.diag_icd10_staff_doctor = b_employee.b_employee_id) 

WHERE   t_visit.f_visit_status_id <> '4' 
	AND t_diag_icd10.diag_icd10_active = '1' 
	AND t_visit.f_visit_type_id = '0'
	AND substring(t_visit.visit_begin_visit_time,1,10) >= ?
	AND substring(t_visit.visit_begin_visit_time,1,10) <= ?
ORDER BY HN