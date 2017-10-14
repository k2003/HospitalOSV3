select distinctb_site.b_visit_office_id || substring(t_nhso_dental.t_nhso_dental_id,9)  as 	dentchild_id ,b_site.b_visit_office_id || substring(t_nhso_service_pp.t_nhso_service_pp_id,11)  as T_SERVICE_ID,case when (t_nhso_dental.dental_check_dent = '1')    then '1'    else '0'    end as 	CONSULT_DENT,case when (t_nhso_dental.dental_enamel = '1')    then '2'    else '1'    end as 	check_sealant,case when (t_nhso_dental.dental_enamel = '1' and t_nhso_dental.dental_goalsealant is not null and trim(t_nhso_dental.dental_goalsealant) <> '')    then cast(cast(trim(t_nhso_dental.dental_goalsealant) as numeric) as varchar)     else '0'     end as goal_sealant ,case when (t_nhso_dental.dental_enamel = '1' and t_nhso_dental.dental_enamel_tooth_amount is not null                     and trim(t_nhso_dental.dental_enamel_tooth_amount) <> '')     then  cast(cast(trim(t_nhso_dental.dental_enamel_tooth_amount) as numeric) as varchar)     else '0'     end as dent_no,case when t_nhso_dental.dental_enamel = '1'     then trim(t_nhso_dental.dental_enamel_tooth)       else ''    end as sealant ,case when (t_nhso_dental.dental_fluoride = '1')    then '1'    else '0'    end as 	fluolide,case when (trim(t_health_dental.dental_num_tooth) <> '')   then cast(cast(trim(t_health_dental.dental_num_tooth) as numeric) as varchar)   else '0'   end as permant,case when (trim(t_health_dental.dental_num_bad_tooth) <> '')   then cast(cast(trim(t_health_dental.dental_num_bad_tooth) as numeric) as varchar)   else '0'   end as permantcar ,case when (trim(t_health_dental.dental_num_milktooth) <> '')   then cast(cast(trim(t_health_dental.dental_num_milktooth) as numeric) as varchar)   else '0'   end as milktooth ,case when (trim(t_health_dental.dental_num_bad_milktooth) <> '')   then cast(cast(trim(t_health_dental.dental_num_bad_milktooth) as numeric) as varchar)   else '0'   end as milktoothcar,case when (t_nhso_dental.dental_periodontali = '1') 	then '1' 	else '0'    end as PERIODONTALL,case when (t_nhso_dental.dental_mouth_clean = '1') 	then '1' 	else '0'    end as dentclean,case when t_nhso_dental.dental_doctor_card_id is not null         then trim(t_nhso_dental.dental_doctor_card_id)        else ''  end as certificate_id_dentist ,t_nhso_service_pp.pp_totalpay as totalpay         ,visit_vn as vnfrom t_health_dental     inner join t_visit on t_health_dental.t_visit_id = t_visit.t_visit_id    inner join t_nhso_dental on t_nhso_dental.t_health_dental_id = t_health_dental.t_health_dental_id     inner join t_nhso_service_pp on t_nhso_dental.t_nhso_dental_id = t_nhso_service_pp.pp_id    ,b_sitewhere t_visit.f_visit_status_id <> '4'	and t_nhso_service_pp.pp_active = '1'    and t_health_dental.dental_active = '1'    and  substring(t_visit.visit_begin_visit_time,1,10 )  >= ?	and  substring(t_visit.visit_begin_visit_time,1,10 )  <= ?