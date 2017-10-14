SELECT distinct b_site.b_visit_office_id ||  substr(t_nhso_service_pp.t_nhso_service_pp_id,11)  as T_SERVICE_ID,t_patient.patient_hn AS HN,b_site.b_visit_office_id  as PCUCODE, case when length(t_visit.visit_begin_visit_time)>=10         then to_char(to_date(to_number(            substr(t_visit.visit_begin_visit_time,1,4),'9999')-543 ||             substr(t_visit.visit_begin_visit_time,5,6),'yyyy-mm-dd'),'yyyymmdd')  else ''     		 end  as DATE_SERV, case when  (t_health_family.patient_pid IS NOT NULL and trim(t_health_family.patient_pid) <> '')                then t_health_family.patient_pid                when (t_patient.patient_pid IS NOT NULL and trim(t_patient.patient_pid) <> '')                then t_patient.patient_pid                else ''end  as PID,t_patient.patient_house AS ADDNO      ,t_patient.patient_moo AS MOO,t_nhso_patient.nhso_patient_addreg_village AS MOONAME,'' AS COMMUNITY,t_nhso_patient.nhso_patient_soi AS SOI,t_patient.patient_road AS ROAD,substring(t_patient.patient_tambon,5,2) AS TAMBON,substring(t_patient.patient_amphur,3,2) AS AMPHUR,substring(t_patient.patient_changwat,1,4) AS PROVINCE,t_patient.patient_phone_number AS PHONE_HOME,t_nhso_patient.nhso_patient_etc_office_tel AS PHONE_WORK,t_nhso_patient.nhso_patient_etc_mobile AS HAND_PHONE, case when (t_nhso_home.incup is not null and trim(t_nhso_home.incup) <> '')            then t_nhso_home.incup             else '' end as RESPONSIBLE,case when(t_nhso_service_pp.service_new IN ('1','2'))	then t_nhso_service_pp.service_new	else ''	end AS PTTYPE,'V2' AS STATUS_INSERT,t_nhso_service_pp.pp_recompen AS RECOMPEN        ,visit_vn as vnFROM t_visitINNER JOIN t_nhso_service_pp ON t_nhso_service_pp.t_visit_id = t_visit.t_visit_idINNER JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id  INNER JOIN t_nhso_patient ON t_nhso_patient.t_patient_id = t_patient.t_patient_idINNER JOIN t_health_family ON t_health_family.t_health_family_id = t_patient.t_health_family_idLEFT JOIN  t_nhso_home ON t_health_family.t_health_home_id = t_nhso_home.t_health_home_id,b_sitewhere t_visit.f_visit_status_id <> '4'and t_nhso_service_pp.pp_active ='1'    and  substr(t_visit.visit_begin_visit_time,1,10 )  >= ?	and  substr(t_visit.visit_begin_visit_time,1,10 )  <= ?UNIONSELECT distinct b_site.b_visit_office_id ||  substring(t_nhso_service_pp_out.t_nhso_service_pp_out_id,11)  as T_SERVICE_ID,case when t_patient.patient_hn is not null         then t_patient.patient_hn        else '' end AS HN,b_site.b_visit_office_id  as PCUCODE, case when length(t_nhso_service_pp_out.service_date)>=10         then to_char(to_date(to_number(        substr(t_nhso_service_pp_out.service_date,1,4),'9999')-543 ||         substr(t_nhso_service_pp_out.service_date,5,6),'yyyy-mm-dd'),'yyyymmdd')  else ''     		 end  as 	DATE_SERV, case when  (t_health_family.patient_pid IS NOT NULL and trim(t_health_family.patient_pid) <> '')                then t_health_family.patient_pid                when (t_patient.patient_pid IS NOT NULL and trim(t_patient.patient_pid) <> '')                then t_patient.patient_pid                else ''end  as PID,case when (t_patient.patient_house is not null and trim(t_patient.patient_house) <> '')        then t_patient.patient_house         when (t_nhso_family_address.family_address_house_no is not null and trim(t_nhso_family_address.family_address_house_no) <> '')        then t_nhso_family_address.family_address_house_no        else ''end  AS ADDNO,case when (t_patient.patient_moo is not null and trim(t_patient.patient_moo) <> '')         then t_patient.patient_moo        else ''end AS MOO, case when (t_nhso_patient.nhso_patient_addreg_village is not null and trim(t_nhso_patient.nhso_patient_addreg_village) <> '')        then t_nhso_patient.nhso_patient_addreg_village         when (t_nhso_family_address.family_address_village is not null and trim(t_nhso_family_address.family_address_village) <> '')        then t_nhso_family_address.family_address_village        else ''end AS MOONAME,case when (t_nhso_family_address.family_address_community is not null and trim(t_nhso_family_address.family_address_community) <> '')        then (select t_nhso_community.community_name from t_nhso_community where t_nhso_community_id = t_nhso_family_address.family_address_community)        else ''end AS COMMUNITY,case when (t_nhso_patient.nhso_patient_soi is not null and trim(t_nhso_patient.nhso_patient_soi) <> '')        then t_nhso_patient.nhso_patient_soi        when (t_nhso_family_address.family_address_soi is not null and trim(t_nhso_family_address.family_address_soi) <> '')         then t_nhso_family_address.family_address_soi        else '' end  AS SOI,case when (t_patient.patient_road is not null and trim(t_patient.patient_road) <> '')        then t_patient.patient_road         when (t_nhso_family_address.family_address_road is not null and trim(t_nhso_family_address.family_address_road) <> '')        then t_nhso_family_address.family_address_road        else ''end  AS ROAD,case when (t_patient.patient_tambon is not null and trim(t_patient.patient_tambon) <> '' )         then substring(t_patient.patient_tambon,5,2)         when (t_nhso_family_address.family_address_district is not null and trim(t_nhso_family_address.family_address_district) <> '')        then substring(t_nhso_family_address.family_address_district,5,2)        else '' end AS TAMBON,case when (t_patient.patient_amphur is not null and trim(t_patient.patient_amphur) <> '' )        then substring(t_patient.patient_amphur,3,2)         when (t_nhso_family_address.family_address_area is not null and trim(t_nhso_family_address.family_address_area) <> '')        then substring(t_nhso_family_address.family_address_area,3,2)        else '' end AS AMPHUR,case when (t_patient.patient_changwat is not null and trim(t_patient.patient_changwat) <> '')        then substring(t_patient.patient_changwat,1,4)         when (t_nhso_family_address.family_address_province is not null and trim(t_nhso_family_address.family_address_province) <> '')         then substring(t_nhso_family_address.family_address_province,1,4)        else '' end AS PROVINCE,case when (t_patient.patient_phone_number is not null and trim(t_patient.patient_phone_number) <> '')        then t_patient.patient_phone_number        else ''end AS PHONE_HOME,case when (t_patient.patient_phone_number is not null and trim(t_patient.patient_phone_number) <> '')         then t_patient.patient_phone_number         else '' end AS PHONE_WORK,case when (t_nhso_patient.nhso_patient_addreg_mobile is not null and trim(t_nhso_patient.nhso_patient_addreg_mobile) <> '')        then t_nhso_patient.nhso_patient_addreg_mobile         else ''end AS HAND_PHONE, case when t_nhso_service_pp_out.pp_name = 'HHC'             then t_nhso_visit_home.visit_home_respon_area            else (case when (t_nhso_home.incup is not null and trim(t_nhso_home.incup) <> '')                        then t_nhso_home.incup                         else ''                    end)end as RESPONSIBLE,case when(t_nhso_service_pp_out.service_new IN ('1','2'))	then t_nhso_service_pp_out.service_new	else ''	end AS PTTYPE,'V2' AS STATUS_INSERT,t_nhso_service_pp_out.pp_recompen AS RECOMPEN         ,'' as vnFROM t_nhso_service_pp_out INNER JOIN t_health_family ON t_health_family.t_health_family_id = t_nhso_service_pp_out.t_health_family_id LEFT JOIN t_nhso_visit_home ON t_nhso_service_pp_out.pp_id = t_nhso_visit_home.t_nhso_visit_home_idLEFT JOIN t_health_home ON t_health_family.t_health_home_id = t_health_home.t_health_home_idLEFT JOIN  t_nhso_home ON t_health_home.t_health_home_id = t_nhso_home.t_health_home_idLEFT JOIN t_patient ON t_health_family.t_health_family_id = t_patient.t_health_family_id LEFT JOIN t_nhso_patient ON t_nhso_patient.t_patient_id = t_patient.t_patient_idLEFT JOIN t_nhso_family_address ON t_nhso_family_address.t_health_family_id = t_health_family.t_health_family_id,b_siteWHERE t_nhso_service_pp_out.pp_active ='1'    and  substring(t_nhso_service_pp_out.service_date,1,10 )  >= ?	and  substring(t_nhso_service_pp_out.service_date,1,10 )  <= ?