SELECT 
          r_uc_plan_group.uc_plan_group_description 
          ,CASE WHEN (sum(query1.childless_female) > 0) 
                   THEN sum(query1.childless_female) 
                   ELSE 0 
          END AS childless_female 
          ,CASE WHEN (sum(query1.childless_male) > 0) 
                   THEN sum(query1.childless_male) 
                   ELSE 0 
          END AS childless_male 
          ,CASE WHEN (sum(query1.childless_drug) > 0) 
                   THEN sum(query1.childless_drug) 
                   ELSE 0 
          END AS childless_drug 
          ,CASE WHEN (sum(query1.childless_other) > 0) 
                   THEN sum(query1.childless_other) 
                   ELSE 0 
          END AS childless_other 
FROM r_uc_plan_group 
        LEFT JOIN (SELECT 
              CASE  WHEN ((r_plan_group.plan_group_number = '1' ) 
                        OR (r_plan_group.plan_group_number = '2' ) ) 
                        THEN  r_plan_group.plan_group_number 
                      WHEN (((r_plan_group.plan_group_number = '3' ) 
                        OR (r_plan_group.plan_group_number = '4' ) ) 
                        AND ((visit_payment_main_hospital IN (Select  hospital_incup_code 
                        FROM r_hospital_incup))  OR (visit_payment_sub_hospital IN 
                        (Select  hospital_incup_code from r_hospital_incup))) ) 
                        THEN '3' 
                      WHEN (((r_plan_group.plan_group_number = '3' ) 
                        OR (r_plan_group.plan_group_number = '4' ) )
                        AND ( ((t_visit_payment.visit_payment_main_hospital = '') 
                        AND (t_visit_payment.visit_payment_sub_hospital = '')) 
                        OR ((t_visit_payment.visit_payment_main_hospital NOT IN 
                        (Select  hospital_incup_code 
                        FROM r_hospital_incup))  AND (visit_payment_sub_hospital NOT IN 
                        (Select  hospital_incup_code from r_hospital_incup))) ))
                        THEN '4' 
                      WHEN ((r_plan_group.plan_group_number <> '1' ) 
                        AND (r_plan_group.plan_group_number <> '2' ) 
                        AND (r_plan_group.plan_group_number <> '3' ) 
                        AND (r_plan_group.plan_group_number <> '4' ) )
                        THEN  '5' 
                        END AS plan_group_id
             
               , CASE WHEN (t_health_family_planing.f_health_family_planing_method_id = '7')
                      THEN 1 
                      ELSE 0 
                      END AS  childless_female
                 , CASE WHEN (t_health_family_planing.f_health_family_planing_method_id = '6') 
                      THEN 1 
                      ELSE 0 
                      END AS  childless_male 
                 , CASE WHEN (t_health_family_planing.f_health_family_planing_method_id = '4') 
                      THEN 1 
                      ELSE 0 
                      END AS  childless_drug 
                 , CASE WHEN t_health_family_planing.f_health_family_planing_method_id <> '7'
                      AND t_health_family_planing.f_health_family_planing_method_id <> '6' 
                      AND t_health_family_planing.f_health_family_planing_method_id <> '4' 
                      THEN 1 
                      ELSE 0 
                      END AS  childless_other 
               FROM t_visit 
                    INNER JOIN t_health_family_planing ON t_visit.t_visit_id = t_health_family_planing.t_visit_id
                    INNER JOIN t_visit_payment ON t_visit.t_visit_id = t_visit_payment.t_visit_id
                    INNER JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id
                    LEFT JOIN r_plan_group_map_pttype ON b_contract_plans.contract_plans_pttype = r_plan_group_map_pttype.plan_group_map_pttype_pttype
                    LEFT JOIN r_plan_group ON r_plan_group.r_plan_group_id = r_plan_group_map_pttype.r_plan_group_id 
                WHERE  t_visit.f_visit_status_id <>'4'
                   AND t_visit_payment.visit_payment_priority='0' 
                   AND t_visit_payment.visit_payment_active='1'
                   AND (SUBSTRING(visit_begin_visit_time,1,10)) Between ? AND ?
                   AND t_health_family_planing.health_family_planing_active='1'
        )  AS query1 ON query1.plan_group_id = r_uc_plan_group.uc_plan_group_number 

GROUP BY r_uc_plan_group.uc_plan_group_number 
       ,r_uc_plan_group.uc_plan_group_description 
ORDER BY r_uc_plan_group.uc_plan_group_number
