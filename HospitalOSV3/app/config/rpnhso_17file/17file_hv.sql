SELECTb_site.b_visit_office_id || substring(t_nhso_home_visit.t_nhso_home_visit_id,11) as hv_id,b_site.b_visit_office_id ||  substr(t_nhso_service_pp_out.t_nhso_service_pp_out_id,11) as t_service_id,case when(t_nhso_home_visit.home_visit_consult_pp IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_pp	else '0'	end as consult_pp,case when (t_nhso_home_visit.home_visit_consult_fp IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_fp	else '0'	end as consult_fp,case when(t_nhso_home_visit.home_visit_consult_anc IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_anc	else '0'	end as consult_anc,case when(t_nhso_home_visit.home_visit_consult_npc IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_npc	else '0'	end as consult_npc,case when(t_nhso_home_visit.home_visit_consult_mum IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_mum	else '0'	end as consult_mum,case when(t_nhso_home_visit.home_visit_consult_epi IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_epi	else '0'	end as consult_epi,case when(t_nhso_home_visit.home_visit_consult_grow IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_grow	else '0'	end as consult_grow,case when(t_nhso_home_visit.home_visit_consult_old IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_old	else '0'	end as consult_old,case when(t_nhso_home_visit.home_visit_consult_cripple IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_cripple	else '0'	end as consult_cripple,case when(t_nhso_home_visit.home_visit_consult_other_desc IN ('0','1'))	then t_nhso_home_visit.home_visit_consult_other_desc	else '0'	end as consult_other,case when t_nhso_home_visit.home_visit_leader_job in ('1','2')    then t_nhso_home_visit.home_visit_leader_job    when trim(t_nhso_home_visit.home_visit_leader_job) <> ''    then '3'      else '' end as person_servey,case when t_nhso_home_visit.home_visit_leader_job = '7'     then t_nhso_home_visit.home_visit_person_other      else ''  end as person_other,case when t_nhso_home_visit.home_visit_health_follow='1'    then '2'    when t_nhso_home_visit.home_visit_miss_appointment='1'    then '0'    else ''end as followup,t_nhso_home_visit.home_visit_activity as followup_other,t_nhso_service_pp_out.pp_totalpay as totalpay        ,'' as vnfrom t_nhso_home_visit     inner join t_nhso_service_pp_out on t_nhso_home_visit.t_nhso_home_visit_id = t_nhso_service_pp_out.pp_id    inner join t_health_family on t_nhso_home_visit.t_health_family_id = t_health_family.t_health_family_id  ,b_sitewhere      t_nhso_service_pp_out.pp_active = '1'     and substring(t_nhso_service_pp_out.service_date,1,10 )  >= ?	 and substring(t_nhso_service_pp_out.service_date,1,10 )  <= ?