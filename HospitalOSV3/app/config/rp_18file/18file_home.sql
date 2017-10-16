--ทดสอบภาษาไทย
select distinct
	b_site.b_visit_office_id as 			 PCUCODE
	, to_char(t_health_home.home_serial,'00000') AS HID
	, t_health_home.health_home_number as 			 HOUSE_ID
	, t_health_home.health_home_house as 			 HOUSE
	, t_health_village.village_moo as 			 VILLAGE
	, t_health_home.health_home_road as 			 ROAD
	, SUBSTRING(t_health_village.village_tambon,5,2) as 			 TAMBON
	, SUBSTRING(t_health_village.village_ampur,3,2) as 			 AMPUR
	, SUBSTRING(t_health_village.village_changwat,1,2) as 			 CHANGWAT
	, t_health_home.health_home_family as 			 NFAMILY
	, CASE 	when (t_health_home.health_home_responsible_zone = '0') then '2'          	
		when (t_health_home.health_home_responsible_zone = '1')         		
			then t_health_home.health_home_responsible_zone         	
		ELSE ''  END as 		 LOCATYPE
	, t_health_home.health_home_volunteer as 	 VHVID
	, t_health_home.health_home_owner_number as 		 HEADID
	, t_health_home_water_eradicate.health_home_toilet AS TOILET
	, t_health_home_water_eradicate.health_home_water AS WATER
	, t_health_home_water_eradicate.f_health_home_water_type_id AS WATTYPE
	, t_health_home_water_eradicate.f_health_home_garbage_method_id AS GARBAGE
	, t_health_home_house_standard.health_home_care AS HCARE
	, t_health_home_house_standard.health_home_durability AS DURABLE
	, t_health_home_house_standard.health_home_cleanness AS CLEAN
	, t_health_home_house_standard.health_home_ventilation AS VENTILA
	, t_health_home_house_standard.health_home_light AS LIGHT
	, t_health_home_water_eradicate.health_home_water_eradicate AS WATERTM
	, t_health_home_food_standard.health_home_mixture_food AS MFOOD
	, t_health_home_bug_control.health_home_bug_control AS BCTRL
	, t_health_home_bug_control.health_home_animal_control AS ACTRL
	, CASE when length(t_health_home.home_record_date_time) >= 10
            then (to_number(substring(t_health_home.home_record_date_time,1,4),'9999')-543)     
                    ||   substring(t_health_home.home_record_date_time,6,2)     
                    ||   substring(t_health_home.home_record_date_time,9,2)      
            ELSE ''  END as UPDATE
        ,village_number as VHID


from  t_health_home 
	LEFT JOIN t_health_village  ON t_health_home.t_health_village_id = t_health_village.t_health_village_id         
	LEFT JOIN ( SELECT t_health_home_id AS home,max(sub_home_record_date_time) AS d  
			from  t_health_sub_home  WHERE sub_home_active = '1' group by home
        ) AS q  ON (t_health_home.t_health_home_id = q.home   )
	left join t_health_sub_home  ON (t_health_sub_home.t_health_home_id = t_health_home.t_health_home_id 
            and t_health_sub_home.sub_home_record_date_time = q.d)        
	left join t_health_home_water_eradicate  ON (t_health_home_water_eradicate.t_health_sub_home_id = t_health_sub_home.t_health_sub_home_id)         
	left join t_health_home_house_standard  ON 	(t_health_home_house_standard.t_health_sub_home_id = t_health_sub_home.t_health_sub_home_id)          
	left join t_health_home_food_standard  ON (t_health_home_food_standard.t_health_sub_home_id = t_health_sub_home.t_health_sub_home_id)         
	left join t_health_home_bug_control  ON (t_health_home_bug_control.t_health_sub_home_id = t_health_sub_home.t_health_sub_home_id) 
	,b_site

where t_health_village.village_moo <> '0'
    AND t_health_home.home_active = '1'
