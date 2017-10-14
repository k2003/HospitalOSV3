/*Source file: E:\\Job\\DrugReportSep\\code\\com\\hospital_os\\control\\PrescribeDB.java
 */
package com.hospital_os.objdb;

import com.hospital_os.*;
import com.hospital_os.usecase.connection.*;
import com.hospital_os.utility.*;
import com.hospital_os.object.*;
import java.util.*;
import java.sql.*;

public class OrderItemDB
{
    public ConnectionInf theConnectionInf;
    public OrderItem dbObj;
    final public String idtable = "195";/*"178";*/
    OrderItemDrugDB theOrderItemDrugDB;

    /**
     * @param ConnectionInf db
     * @roseuid 3F65897F0326
     */
    public OrderItemDB(ConnectionInf db)
    {
        theConnectionInf=db;
        dbObj = new OrderItem();
        initConfig();
    }
    public void setDepDB(OrderItemDrugDB oiddb){
        theOrderItemDrugDB = oiddb;
    }
    public OrderItem initConfig()
    {
        dbObj.table="t_order";
        dbObj.pk_field="t_order_id";
        dbObj.visit_id   ="t_visit_id";
        dbObj.item_code   ="b_item_id";
        dbObj.vertifier   ="order_staff_verify";
        dbObj.vertify_time   ="order_verify_date_time";
        dbObj.executer   ="order_staff_execute";
        dbObj.executed_time   ="order_executed_date_time";
        dbObj.discontinue   ="order_staff_discontinue";
        dbObj.discontinue_time   ="order_discontinue_date_time";
        dbObj.dispense   ="order_staff_dispense";
        dbObj.dispense_time   ="order_dispense_date_time";
        dbObj.clinic_code   ="order_service_point";
        dbObj.item_group_code_category   ="b_item_subgroup_id";
        dbObj.charge_complete   ="order_charge_complete";
        dbObj.status   ="f_order_status_id";
        dbObj.secret   ="order_secret";
        dbObj.continue_order   ="order_continue";
        dbObj.price   ="order_price";
        dbObj.qty   ="order_qty";
        dbObj.item_group_code_billing   ="b_item_billing_subgroup_id";
        dbObj.hn   ="t_patient_id";
        dbObj.category_group   ="f_item_group_id";
        dbObj.common_name   ="order_common_name";
        dbObj.refer_out   ="order_refer_out";
        dbObj.request   ="order_request";
        dbObj.order_user   ="order_staff_order";
        dbObj.order_time   ="order_date_time";
        dbObj.order_complete ="order_complete";
        dbObj.order_cost = "order_cost";
        dbObj.note = "order_notice";

        dbObj.reporter = "order_staff_report";
        dbObj.reported_time = "order_report_date_time";

        //�����˵ء��¡��ԡ���Ż --sumo-- 13/3/2549
        dbObj.cause_cancel_resultlab = "order_cause_cancel_resultlab";

        //amp:30/03/2549 �红����š������ҷ���� �������ҷ���ջ�ԡ����Ҵ���
        dbObj.drug_allergy = "order_drug_allergy";
        //tong:01/06/49 ��¡�á�Ѻ��ҹ
        dbObj.order_home = "order_home";
        dbObj.item_16_group = "b_item_16_group_id";
        dbObj.specified = "order_specified";
        dbObj.specified_data = "order_specified_data";
        return dbObj;
    }

    /**
     * @param cmd
     * @param o
     * @return int
     * @roseuid 3F6574DE0394
     */
    public int insert(OrderItem p) throws Exception
    {
        updateField(p);
        p.generateOID(idtable);

        StringBuffer sql = new StringBuffer("insert into " ).append( dbObj.table ).append( " ("
        ).append( dbObj.pk_field
        ).append( " ,"	).append( dbObj.visit_id
        ).append( " ,"	).append( dbObj.item_code
        ).append( " ,"	).append( dbObj.vertifier
        ).append( " ,"	).append( dbObj.vertify_time
        ).append( " ,"	).append( dbObj.executer
        ).append( " ,"	).append( dbObj.executed_time
        ).append( " ,"	).append( dbObj.discontinue
        ).append( " ,"	).append( dbObj.discontinue_time
        ).append( " ,"	).append( dbObj.dispense
        ).append( " ,"	).append( dbObj.dispense_time
        ).append( " ,"	).append( dbObj.clinic_code
        ).append( " ,"	).append( dbObj.category_group
        ).append( " ,"	).append( dbObj.charge_complete
        ).append( " ,"	).append( dbObj.status
        ).append( " ,"	).append( dbObj.secret
        ).append( " ,"	).append( dbObj.continue_order
        ).append( " ,"	).append( dbObj.price
        ).append( " ,"	).append( dbObj.qty
        ).append( " ,"  ).append( dbObj.item_group_code_billing
        ).append( " ,"  ).append( dbObj.hn
        ).append( " ,"	).append( dbObj.item_group_code_category
        ).append( " ,"  ).append( dbObj.common_name
        ).append( " ,"  ).append( dbObj.refer_out
        ).append( " ,"  ).append( dbObj.request
        ).append( " ,"  ).append( dbObj.order_user
        ).append( " ,"  ).append( dbObj.order_time
        ).append( " ,"  ).append( dbObj.order_complete
        ).append( " ,"  ).append( dbObj.reporter
        ).append( " ,"  ).append( dbObj.reported_time
        ).append( " ,"  ).append( dbObj.order_cost
        ).append( " ,"  ).append( dbObj.note
        ).append( " ,"  ).append( dbObj.cause_cancel_resultlab
        ).append( " ,"  ).append( dbObj.drug_allergy
        ).append( " ,"  ).append( dbObj.order_home
        ).append( " ,"  ).append( dbObj.item_16_group
        ).append( " ,"  ).append( dbObj.specified
        ).append( " ,"  ).append( dbObj.specified_data
        ).append( " ) values ('"
        ).append( p.getObjectId()
        ).append( "','" ).append( p.visit_id
        ).append( "','" ).append( p.item_code
        ).append( "','" ).append( p.vertifier
        ).append( "','" ).append( p.vertify_time
        ).append( "','" ).append( p.executer
        ).append( "','" ).append( p.executed_time
        ).append( "','" ).append( p.discontinue
        ).append( "','" ).append( p.discontinue_time
        ).append( "','" ).append( p.dispense
        ).append( "','" ).append( p.dispense_time
        ).append( "','" ).append( p.clinic_code
        ).append( "','" ).append( p.category_group
        ).append( "','" ).append( p.charge_complete
        ).append( "','" ).append( p.status
        ).append( "','" ).append( p.secret
        ).append( "','" ).append( p.continue_order
        ).append( "'," ).append( p.price       //�ٴմչ�����ѹ�� double  by  henbe
        ).append( "," ).append( p.qty       //�ٴմչ�����ѹ�� double  by  henbe
        ).append( ",'" ).append( p.item_group_code_billing
        ).append( "','" ).append( p.hn
        ).append( "','" ).append( p.item_group_code_category
        ).append( "','" ).append( p.common_name
        ).append( "','" ).append( p.refer_out
        ).append( "','" ).append( p.request
        ).append( "','" ).append( p.order_user
        ).append( "','" ).append( p.order_time
        ).append( "','" ).append( p.order_complete
        ).append( "','" ).append( p.reporter
        ).append( "','" ).append( p.reported_time
        ).append( "','" ).append( p.order_cost
        ).append( "','" ).append( p.note
        ).append( "','" ).append( p.cause_cancel_resultlab
        ).append( "','" ).append( p.drug_allergy
        ).append( "','" ).append( p.order_home
        ).append( "','" ).append( p.item_16_group
        ).append( "','" ).append( p.specified
        ).append( "','" ).append( p.specified_data
        ).append( "')");
        return theConnectionInf.eUpdate(sql.toString().replace("\\\\\'", "\\\'"));
    }
    public static void updateField(OrderItem obj)
    {
         obj.common_name = Gutil.CheckReservedWords(obj.common_name);
         obj.price = Constant.getSDouble(obj.price);
         obj.qty = Constant.getSDouble(obj.qty);
         if( obj.order_cost.equals("0"))
             obj.order_cost = obj.price;
    }

    public int update(OrderItem p) throws Exception
    {

        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                ).append( dbObj.visit_id ).append( "='" ).append( p.visit_id
        ).append( "', " ).append( dbObj.item_code ).append( "='" ).append( p.item_code
        ).append( "', " ).append( dbObj.vertifier ).append( "='" ).append( p.vertifier
        ).append( "', " ).append( dbObj.vertify_time ).append( "='" ).append( p.vertify_time
        ).append( "', " ).append( dbObj.executer ).append( "='" ).append( p.executer
        ).append( "', " ).append( dbObj.executed_time ).append( "='" ).append( p.executed_time
        ).append( "', " ).append( dbObj.discontinue ).append( "='" ).append( p.discontinue
        ).append( "', " ).append( dbObj.discontinue_time ).append( "='" ).append( p.discontinue_time
        ).append( "', " ).append( dbObj.dispense ).append( "='" ).append( p.dispense
        ).append( "', " ).append( dbObj.dispense_time ).append( "='" ).append( p.dispense_time
        ).append( "', " ).append( dbObj.clinic_code ).append( "='" ).append( p.clinic_code
        ).append( "', " ).append( dbObj.category_group ).append( "='" ).append( p.category_group
        ).append( "', " ).append( dbObj.charge_complete ).append( "='" ).append( p.charge_complete
        ).append( "', " ).append( dbObj.status ).append( "='" ).append( p.status
        ).append( "', " ).append( dbObj.secret ).append( "='" ).append( p.secret
        ).append( "', " ).append( dbObj.continue_order ).append( "='" ).append( p.continue_order
        ).append( "', " ).append( dbObj.price ).append( "=" ).append( p.price       //�ٴմչ�����ѹ�� double  by  henbe
        ).append( ", " ).append( dbObj.qty ).append( "=" ).append( p.qty       //�ٴմչ�����ѹ�� double  by  henbe
        ).append( ", " ).append( dbObj.item_group_code_billing ).append( "='" ).append( p.item_group_code_billing
        ).append( "', " ).append( dbObj.hn ).append( "='" ).append( p.hn
        ).append( "', " ).append( dbObj.item_group_code_category ).append( "='" ).append( p.item_group_code_category
        ).append( "', " ).append( dbObj.common_name ).append( "='" ).append( p.common_name
        ).append( "', " ).append( dbObj.refer_out ).append( "='" ).append( p.refer_out
        ).append( "', " ).append( dbObj.request ).append( "='" ).append( p.request
        ).append( "', " ).append( dbObj.order_user ).append( "='" ).append( p.order_user
        ).append( "', " ).append( dbObj.order_time ).append( "='" ).append( p.order_time
        ).append( "', " ).append( dbObj.order_complete ).append( "='" ).append( p.order_complete
        ).append( "', " ).append( dbObj.reporter ).append( "='" ).append( p.reporter
        ).append( "', " ).append( dbObj.reported_time ).append( "='" ).append( p.reported_time
        ).append( "', " ).append( dbObj.order_cost ).append( "='" ).append( p.order_cost
        ).append( "', " ).append( dbObj.note ).append( "='" ).append( p.note
        ).append( "', " ).append( dbObj.cause_cancel_resultlab ).append( "='" ).append( p.cause_cancel_resultlab
        ).append( "', " ).append( dbObj.drug_allergy ).append( "='" ).append( p.drug_allergy
        ).append( "', " ).append( dbObj.order_home ).append( "='" ).append( p.order_home
        ).append( "', " ).append( dbObj.item_16_group ).append( "='" ).append( p.item_16_group
        ).append( "', " ).append( dbObj.specified ).append( "='" ).append( p.specified
        ).append( "', " ).append( dbObj.specified_data ).append( "='" ).append( p.specified_data
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    public int updateNS(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( dbObj.visit_id ).append( "='" ).append( p.visit_id
        ).append( "', " ).append( dbObj.item_code ).append( "='" ).append( p.item_code
        ).append( "', " ).append( dbObj.refer_out ).append( "='" ).append( p.refer_out
        ).append( "', " ).append( dbObj.request ).append( "='" ).append( p.request
        ).append( "', " ).append( dbObj.secret ).append( "='" ).append( p.secret
        ).append( "', " ).append( dbObj.clinic_code ).append( "='" ).append( p.clinic_code
        ).append( "', " ).append( dbObj.category_group ).append( "='" ).append( p.category_group
        ).append( "', " ).append( dbObj.charge_complete ).append( "='" ).append( p.charge_complete
        ).append( "', " ).append( dbObj.continue_order ).append( "='" ).append( p.continue_order
        ).append( "', " ).append( dbObj.price ).append( "=" ).append( p.price       //�ٴմչ�����ѹ�� double  by  henbe
        ).append( ", " ).append( dbObj.qty ).append( "=" ).append( p.qty       //�ٴմչ�����ѹ�� double  by  henbe
        ).append( ", " ).append( dbObj.item_group_code_billing ).append( "='" ).append( p.item_group_code_billing
        ).append( "', " ).append( dbObj.hn ).append( "='" ).append( p.hn
        ).append( "', " ).append( dbObj.item_group_code_category ).append( "='" ).append( p.item_group_code_category
        ).append( "', " ).append( dbObj.common_name ).append( "='" ).append( p.common_name
        ).append( "', " ).append( dbObj.order_user ).append( "='" ).append( p.order_user
        ).append( "', " ).append( dbObj.order_time ).append( "='" ).append( p.order_time
        ).append( "', " ).append( dbObj.order_complete ).append( "='" ).append( p.order_complete
        ).append( "', " ).append( dbObj.order_cost ).append( "='" ).append( p.order_cost
        ).append( "', " ).append( dbObj.note ).append( "='" ).append( p.note
        ).append( "', " ).append( dbObj.cause_cancel_resultlab ).append( "='" ).append( p.cause_cancel_resultlab
        ).append( "', " ).append( dbObj.drug_allergy ).append( "='" ).append( p.drug_allergy
        ).append( "', " ).append( dbObj.order_home ).append( "='" ).append( p.order_home
        ).append( "', " ).append( dbObj.item_16_group ).append( "='" ).append( p.item_16_group
        ).append( "', " ).append( dbObj.specified ).append( "='" ).append( p.specified
        ).append( "', " ).append( dbObj.specified_data ).append( "='" ).append( p.specified_data
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }


    public int updateVerify(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( dbObj.vertifier ).append( "='" ).append( p.vertifier
        ).append( "', " ).append( dbObj.vertify_time ).append( "='" ).append( p.vertify_time
        ).append( "', " ).append( dbObj.status ).append( "='" ).append( p.status
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    public int updateDisContinue(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( dbObj.discontinue ).append( "='" ).append( p.discontinue
        ).append( "', " ).append( dbObj.discontinue_time ).append( "='" ).append( p.discontinue_time
        ).append( "', " ).append( dbObj.status ).append( "='" ).append( p.status
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    public int updateExecute(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( dbObj.executer ).append( "='" ).append( p.executer
        ).append( "', " ).append( dbObj.executed_time ).append( "='" ).append( p.executed_time
        ).append( "', " ).append( dbObj.status ).append( "='" ).append( p.status
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    public int updateDispense(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( dbObj.dispense ).append( "='" ).append( p.dispense
        ).append( "', " ).append( dbObj.dispense_time ).append( "='" ).append( p.dispense_time
        ).append( "', " ).append( dbObj.status ).append( "='" ).append( p.status
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    public int updateReport(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( dbObj.reporter ).append( "='" ).append( p.reporter
        ).append( "', " ).append( dbObj.reported_time ).append( "='" ).append( p.reported_time
        ).append( "', " ).append( dbObj.status ).append( "='" ).append( p.status
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    public int updateComplete(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( " " ).append( dbObj.order_complete ).append( "='" ).append( p.order_complete
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    public int updateRefer(OrderItem p) throws Exception
    {
        updateField(p);
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
        ).append( " " ).append( dbObj.refer_out ).append( "='" ).append( p.refer_out
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    /**��㹡�� update ੾���Ҥ���ҹ�鹨���Ѻ Xray
     *@param o ��� Object �ͧ OrderItem ����բ����Ťú
     *@return int
     *@author padungrat(tong_
     */
    public int updatePrice(OrderItem p) throws Exception
    {
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
            ).append( dbObj.price ).append( "=" ).append( p.price
            ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

     public int updateOrderHome(OrderItem p) throws Exception
    {
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                ).append( dbObj.order_home ).append( "='" ).append( p.order_home
        ).append( "', " ).append( dbObj.item_16_group ).append( "='" ).append( p.item_16_group
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }
    public int updateRequest(OrderItem p) throws Exception
    {
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                ).append( dbObj.request ).append( "='" ).append( p.request
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( p.getObjectId() ).append("'");

        return theConnectionInf.eUpdate(sql.toString());
    }

        /////////////////////////////////////////////////////////////////////////////
//henbe_add
    public int updateCObyId(String charge,String order,String id) throws Exception
    {
        StringBuffer sql = new StringBuffer("update " ).append( dbObj.table ).append( " set "
                ).append( dbObj.charge_complete ).append( "='" ).append( charge
        ).append( "', " ).append( dbObj.order_complete ).append( "='" ).append( order
        ).append( "' where " ).append( dbObj.pk_field ).append( "='" ).append( id ).append("'");
        return theConnectionInf.eUpdate(sql.toString());
    }

    /**
     *@Author: amp
     *@date: 04/03/2549
     */
    public int updateDrugAllergyByItemIdAndVisitId(String item_id,String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer( "update " ).append( dbObj.table ).append( " set "
                ).append( dbObj.drug_allergy ).append( " = '1"
        ).append( "' where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "' and "
        ).append( dbObj.item_code ).append( " = '" ).append( item_id ).append( "'");

        return theConnectionInf.eUpdate(sql.toString());
    }

    /*////////////////////////////////////////////////////////////////////////////
*/
    public int delete(OrderItem o) throws Exception
    {
         StringBuffer sql = new StringBuffer("delete from " ).append( dbObj.table
         ).append( " where " ).append( dbObj.pk_field ).append( "='" ).append( o.getObjectId() ).append("'");
         return theConnectionInf.eUpdate(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public OrderItem selectByPK(String pk) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
         ).append( " where " ).append( dbObj.pk_field
         ).append( " = '" ).append( pk ).append( "'");

         Vector v=eQuery(sql.toString());
         if(v.isEmpty())
             return null;
         else
             return (OrderItem)v.get(0);
    }

    public Vector selectByDateTypeCancel(String dateFrom, String dateTo, String visit_id,String type,boolean show_cancel) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
             //   ).append( " left join " ).append( theOrderItemDrugDB.dbObj.table ).append( " on "
             //   ).append( theOrderItemDrugDB.dbObj.table ).append( "." ).append( theOrderItemDrugDB.dbObj.order_item_id
             //   ).append( " = " ).append( dbObj.table ).append( "." ).append( dbObj.pk_field
                ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'");
        if(!dateTo.equals("") && !dateFrom.equals("")){
            sql .append( " and substring(" ).append( dbObj.order_time ).append( ",0,11) <= '" ).append( dateTo ).append( "' " ).append(
                    "and substring(" ).append( dbObj.order_time ).append( ",0,11) >= '" ).append( dateFrom ).append( "'");
        }
        if(!type.equals(""))
            sql .append( " and " ).append( dbObj.category_group ).append( " = '" ).append( type ).append( "'");
        if(!show_cancel)
            sql .append( " and " ).append( dbObj.status ).append( " <> '" ).append( OrderStatus.DIS_CONTINUE ).append( "'");

         sql .append( " ORDER BY ").append( dbObj.order_time ).append( ", " ).append( dbObj.common_name);
        return eQuery(sql.toString(),true);
    }
    public Vector selectByDate(String dateFrom, String dateTo, String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where substring(" ).append( dbObj.order_time ).append( ",0,11) >= '" ).append( dateFrom ).append( "'"
        ).append( " and substring(" ).append( dbObj.order_time ).append( ",0,11) <= '" ).append( dateTo ).append( "'"
        ).append( " and " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " ORDER BY ").append( dbObj.order_time ).append( "  ");

        return eQuery(sql.toString());
    }

    public Vector selectByVidTypeCancel(String visit_id,String type,boolean show_cancel) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'");
        if(!type.equals(""))
            sql.append( " and " ).append( dbObj.category_group ).append( " = '" ).append( type ).append( "'");
        if(!show_cancel)
            sql.append( " and " ).append( dbObj.status ).append( " <> '" ).append( OrderStatus.DIS_CONTINUE ).append( "'");
        sql.append( " ORDER BY ").append( dbObj.order_time ).append( ", " ).append( dbObj.common_name);
        return eQuery(sql.toString());
    }


    public Vector selectByVisitId(String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " ORDER BY ").append( dbObj.order_time ).append( " ");

        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectByVisitIdOrderByItemGroup(String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " order by " ).append( dbObj.item_group_code_category);

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }

    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectByVisitIdOrderByBillingGroup(String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " order by " ).append( dbObj.item_group_code_billing);

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }

    public Vector selectOrderItemByVNCGForOption(String visit_id ,String category_group, boolean showreport, boolean useshowexecute) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'");


        sql.append( " and (" ).append( dbObj.status ).append( " = '1'");
        if(useshowexecute)
        {
            sql .append( " or " ).append( dbObj.status ).append( " = '2' ")     ;
        }

        if(showreport)
        {
            sql .append( " or " ).append( dbObj.status ).append( " = '4')");
        }
        else
        {   sql.append( ")");
        }

        sql.append( " Order by " ).append( dbObj.order_time);
        return eQuery(sql.toString());
    }



    /*////////////////////////////////////////////////////////////////////////////
*/
    /**���� Order Item ��� ����� Order �������͹���� ʶҹШе�ͧ�� status �׹�ѹ ���� ���Թ��� �¡�á�˹���Ҩ�����ʴ� �����§ҹ��
    �����������   ��Ǩ�ͺ charge_complete ��� ��ͧ����ʴ� Order Item ���Դ�Թ���� ����� true
     */
    public Vector selectOrderItemByVNCG(String visit_id ,String category_group, boolean showreport, boolean charge_complete) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'");


        sql .append( " and (" ).append( dbObj.status ).append( " = '1'"
        ).append( " or " ).append( dbObj.status ).append( " = '2' ")
        ;

        if(showreport)
        {
            sql  .append( " or " ).append( dbObj.status ).append( " = '4')");
        }
        else
        {   sql .append( ")");
        }

        sql .append( " Order by " ).append( dbObj.order_time);
        Vector v=eQuery(sql.toString());

        if(v.size()==0)
            return null;
        else
            return v;
    }

    public Vector selectOrderItemByVNCG(String visit_id ,String category_group
        , boolean showreport, boolean showremain ,boolean charge_complete) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'");

         sql .append( " and (" ).append( dbObj.status ).append( " = '1'"
        ).append( " or " ).append( dbObj.status ).append( " = '2' ");

        if(showreport){
            sql .append( " or " ).append( dbObj.status ).append( " = '4'");
        }
        if(showremain){
            sql .append( " or " ).append( dbObj.status ).append( " = '6'");
        }
        sql .append( ")");
        sql .append( " Order by " ).append( dbObj.order_time);
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
     }

    /*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemReportedByVNCG(String visit_id ,String category_group, boolean charge_complete) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'");

        /*      if(charge_complete)
*/
        /*          sql = sql).append( " and " ).append( dbObj.charge_complete ).append( " = '1' ";
*/
        /*      else
*/
        /*       sql = sql).append( " and " ).append( dbObj.charge_complete ).append( " = '0' ";
*/

        sql.append( " and " ).append( dbObj.status ).append( " = '4'");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }

    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByVisitID(String visit_id ) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "' and "
        ).append( dbObj.status ).append( " <> '3'" ).append(
        " ORDER BY ").append( dbObj.vertify_time ).append( ",").append(  dbObj.status ).append( " DESC ," ).append( dbObj.category_group);

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /**
     * @author Henbe
     * ��������੾����¡�÷���ա�������仹��
     */
    public Vector selectOrderItemByVidActive(String visit_id ) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table ).append(
            " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'" ).append(
            " and " ).append( dbObj.status ).append( " <> '").append( OrderStatus.DIS_CONTINUE ).append("'" ).append(
            " and " ).append( dbObj.status ).append( " <> '").append( OrderStatus.NOT_VERTIFY ).append("'" ).append(
            " and " ).append( dbObj.request ).append( " <> '1'" ).append(
            " ORDER BY ").append( dbObj.vertify_time ).append( ",").append(  dbObj.status ).append( " DESC ," ).append( dbObj.category_group);

        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByDay(String date, String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.vertify_time
        ).append( " like '" ).append( date ).append( "%' and "
        ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "' and "
        ).append( dbObj.status ).append( " <> '3'");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByNameDatePatientId(String name, String dateFrom, String dateTo, String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where UPPER(" ).append( dbObj.common_name
        ).append( ") like UPPER('%" ).append( name ).append( "%') and substring("
        ).append( dbObj.vertify_time ).append( ",0,11) >= '"
        ).append( dateFrom ).append( "' and substring("
        ).append( dbObj.vertify_time ).append( ",0,11) <= '"
        ).append( dateTo ).append( "' and "
        ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.status ).append( " <> '3' and "
        ).append( dbObj.status ).append( " <> '0' order by " ).append( dbObj.order_time ).append( " desc ");
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemDrugByVisitId(String visit_id )throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table ).append( "  where "
        ).append( dbObj.category_group ).append( "= '1' " ).append(
        " and " ).append( dbObj.visit_id ).append( " = '").append( visit_id ).append(
        "' and " ).append( dbObj.status ).append( "<> '3' " ).append(
        " and "	).append( dbObj.status ).append( " <> '5' " ).append(
        " and " ).append( dbObj.status ).append( "<> '0' ");

        return eQuery(sql.toString());
    }

    /*////////////////////////////////////////////////////////////////////////////
*/
    /* ojika
*/
    public Vector selectOrderItemDrugPrintByVisitId(String visit_id )throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table ).append(

        " where " ).append( dbObj.category_group ).append( "= '1' " ).append(
        " and " ).append( dbObj.visit_id ).append( " = '").append( visit_id ).append(
        "' and " ).append( dbObj.status ).append( "<> '3' " ).append(
        " and " ).append( dbObj.status ).append( "<> '0' ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    /* ojika
*/
    public Vector selectOrderItemServicePrintByVisitId(String visit_id )throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table ).append(

        " where " ).append( dbObj.category_group ).append( "= '5' " ).append(
        " and " ).append( dbObj.visit_id ).append( " = '").append( visit_id ).append(
        "' and " ).append( dbObj.status ).append( "<> '3' " ).append(
        " and " ).append( dbObj.status ).append( "<> '0' ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }

    public Vector selectDentByVid(String visit_id )throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table ).append(
        " where " ).append( dbObj.category_group ).append( "= '6' " ).append(
        " and " ).append( dbObj.visit_id ).append( " = '").append( visit_id ).append(
        "' and " ).append( dbObj.status ).append( "<> '3' " ).append(
        " and " ).append( dbObj.status ).append( "<> '0' ");
        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    /* ojika
*/
    public Vector selectOrderItemSupplyPrintByVisitId(String visit_id )throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table ).append(

        "  where " ).append( dbObj.category_group ).append( "= '4' " ).append(
        " and " ).append( dbObj.visit_id ).append( " = '").append( visit_id ).append(
        "' and " ).append( dbObj.status ).append( "<> '3' " ).append(
        " and " ).append( dbObj.status ).append( "<> '0' ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByDatePatientId(String dateFrom, String dateTo, String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where substring("
        ).append( dbObj.vertify_time ).append( ",0,11) >= '"
        ).append( dateFrom ).append( "' and substring("
        ).append( dbObj.vertify_time ).append( ",0,11) <= '"
        ).append( dateTo ).append( "' and "
        ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.status ).append( "<> '3' and "
        ).append( dbObj.status ).append( "<> '0' order by " ).append( dbObj.order_time ).append( " desc ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector listOrderHistoryByNamePatientId(String name,String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where UPPER(" ).append( dbObj.common_name
        ).append( ") like UPPER('%" ).append( name ).append( "%') and "
        ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.status ).append( "<> '3' and "
        ).append( dbObj.status ).append( "<> '0' order by " ).append( dbObj.order_time ).append( " desc ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector listOrderHistoryByPatientId(String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.status ).append( "<> '3' and "
        ).append( dbObj.status ).append( "<> '0' order by " ).append( dbObj.order_time ).append( " desc ");
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByNameGroupDatePatientId(String name, String group, String dateFrom, String dateTo, String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where UPPER(" ).append( dbObj.common_name
        ).append( ") like UPPER('%" ).append( name ).append( "%') and substring("
        ).append( dbObj.vertify_time ).append( ",0,11) >= '"
        ).append( dateFrom ).append( "' and substring("
        ).append( dbObj.vertify_time ).append( ",0,11) <= '"
        ).append( dateTo ).append( "' and "
        ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.category_group ).append( " = '" ).append( group ).append( "' and "
        ).append( dbObj.status ).append( "<> '3' and "
        ).append( dbObj.status ).append( "<> '0' order by " ).append( dbObj.order_time ).append( " desc ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByGroupDatePatientId(String group
            , String dateFrom, String dateTo, String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where substring("
        ).append( dbObj.vertify_time ).append( ",0,11) >= '"
        ).append( dateFrom ).append( "' and substring("
        ).append( dbObj.vertify_time ).append( ",0,11) <= '"
        ).append( dateTo ).append( "' and "
        ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.category_group ).append( " = '" ).append( group ).append( "' and "
        ).append( dbObj.status ).append( "<> '3' and "
        ).append( dbObj.status ).append( "<> '0' order by " ).append( dbObj.order_time ).append( " desc ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByNameGroupPatientId(String name, String group, String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where UPPER(" ).append( dbObj.common_name
        ).append( ") like UPPER('%" ).append( name ).append( "%') and "
        ).append( dbObj.category_group ).append( " = '" ).append( group ).append( "' and "
        ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.status ).append( "<> '3' and "
        ).append( dbObj.status ).append( "<> '0' order by " ).append( dbObj.order_time ).append( " desc ");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByGroupPatientId(String group, String patientId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.category_group ).append( " = '" ).append( group ).append( "' and "
        ).append( dbObj.hn ).append( " = '" ).append( patientId ).append( "' and "
        ).append( dbObj.status ).append( "<> '3' and "
        ).append( dbObj.status ).append( "<> '0' order by " ).append( dbObj.order_time ).append( " desc ");
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByRang(String dateFrom, String dateTo, String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where substring(" ).append( dbObj.order_time
        ).append( ",0,11) >= '" ).append( dateFrom ).append( "' and substring("
        ).append( dbObj.order_time ).append( ",0,11) <= '"
        ).append( dateTo ).append( "' and "
        ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'" ).append(
        " ORDER BY ").append( dbObj.vertify_time ).append( ",").append(  dbObj.status ).append( " DESC ," ).append( dbObj.category_group);
        /*    Constant.println(sql.toString());
*/
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectContinueOrderItem(String visitId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visitId ).append( "' and "
        ).append( dbObj.continue_order ).append( " = '1' and "
        ).append( dbObj.discontinue ).append( " = '' and "
        ).append( dbObj.discontinue_time ).append( " = ''");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    /**
     *
     * @deprecated
     */
    public Vector selectVnByHn(String hn ) throws Exception
    {
        return selectVidByHn(hn);
    }
    public Vector selectVidByHn(String hn ) throws Exception
    {
        StringBuffer sql = new StringBuffer("select visit_id from " ).append( dbObj.table
        ).append( " group by " ).append( dbObj.visit_id ).append( ","
        ).append( dbObj.hn
        ).append( " having (((" ).append( dbObj.hn ).append( ") = '" ).append( hn ).append( "'))"
        ).append( " order by " ).append( dbObj.visit_id);

        Vector v=e2Query(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectAll() throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table);

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectOrderItemByDate(String visit_id ) throws Exception
    {
        StringBuffer sql = new StringBuffer("SELECT SUBSTRING(" ).append( dbObj.vertify_time ).append( ",0,11) as "
        ).append( dbObj.vertify_time ).append( " FROM " ).append( dbObj.table
        ).append( " WHERE (((" ).append( dbObj.visit_id ).append( ")='"
        ).append( visit_id ).append( "') AND ((" ).append( dbObj.status ).append( ")<>'3'))"
        ).append( " GROUP BY SUBSTRING("
        ).append( dbObj.vertify_time ).append( ",0,11) order by SUBSTRING(" ).append( dbObj.vertify_time ).append( ",0,11)");

        Vector v=e1Query(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public OrderItem selectByItem(String pk,String vn) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.item_code
        ).append( " = '" ).append( pk ).append( "' and " ).append( dbObj.visit_id
        ).append( " = '" ).append( vn ).append( "'" ).append(
        " and " ).append( dbObj.status ).append( " <> '" ).append( OrderStatus.DIS_CONTINUE ).append( "' ");
        /*        Constant.println(sql.toString());
*/
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return (OrderItem)v.get(0);
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    /**
     *@Author: sumo
     *@date : 25/08/2549
     *@see: �֧��������¡�� Lab �����觵�Ǩ������(LabReferOut)
     *@parm: String �ͧ keyid Visit ������, String �Ӥ�
     *@ret: Vector ��������¡�� Lab �����觵�Ǩ������
     */
    public Vector selectLROByVId(String vId,String search) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table).append(
        " where " ).append( dbObj.visit_id ).append( " = '" ).append( vId ).append( "'" ).append(
        " and " ).append( dbObj.refer_out ).append( " = '1'" ).append(
        " and " ).append( dbObj.status ).append( " != '" ).append( OrderStatus.DIS_CONTINUE ).append( "'");

        if(search.trim().length() !=0)
        {
            sql.append( " and " ).append( dbObj.common_name
            ).append( " like '" ).append( search ).append( "'");
        }
        return eQuery(sql.toString());
    }
    public Vector selectLROByVId(String vId) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table).append(
        " where " ).append( dbObj.visit_id ).append( " = '" ).append( vId ).append( "'" ).append(
        " and " ).append( dbObj.category_group ).append( " = '2'" ).append(
        " and " ).append( dbObj.status ).append( " != '" ).append( OrderStatus.DIS_CONTINUE ).append( "'");

        return eQuery(sql.toString());
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public int countOrderIsNotCompleteByVisitID(String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer( "select count(").append( dbObj.order_complete).append(") from " ).append(
        dbObj.table ).append( " where " ).append(
        " " ).append( dbObj.visit_id ).append("='" ).append( visit_id ).append( "' " ).append(
        " and ").append( dbObj.charge_complete ).append( " = '").append( Active.isDisable() ).append("' " ).append(
        " and " ).append( dbObj.status ).append( " <> '3'" );
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        int i =0;
        while(rs.next())
        {
            i = rs.getInt(1);
        }
        sql = null;
        rs.close();
        rs = null;
        return i;
    }
    /**
     *@deprecated ��駪��ͼԴ�ٻẺ
     */
    public Vector selectOrderItemReportedNotCompletByVNCG(String visit_id ,String category_group) throws Exception
    {
        return selectExeByVidCat(visit_id,category_group);
    }
    public Vector selectExeByVidCat(String visit_id ,String category_group) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'");
        sql.append( " and " ).append( dbObj.status ).append( " = '2'");
        return eQuery(sql.toString());
    }
     public Vector selectOrderItemReportedCompletByVNCG(String visit_id ,String category_group) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'");
        sql.append( " and " ).append( dbObj.status ).append( " = '4' and ").append( dbObj.order_complete ).append(" = '1'") ;
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
    }
    public int countItem(String pk) throws Exception
    {
         StringBuffer sql = new StringBuffer("select count(*) as count from " ).append( dbObj.table
         ).append( " where " ).append( dbObj.item_code ).append( " = '" ).append( pk ).append( "'");
         ResultSet rs = theConnectionInf.eQuery(sql.toString());
         int count=0;
         if(rs.next()) count = rs.getInt("count");
         return count;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public int countOrderItemByVisitID(String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer( "select count(").append( dbObj.order_complete).append(") from " ).append(
        dbObj.table ).append( " where " ).append(
        " " ).append( dbObj.visit_id ).append("='" ).append( visit_id ).append( "' " ).append(
        " and " ).append( dbObj.status ).append( " <> '3'") ;
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        int i =0;
        while(rs.next())
        {
            i = rs.getInt(1);
        }
        sql = null;
        rs.close();
        rs = null;
        return i;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector eQuery(String sql) throws Exception
    {
        return eQuery(sql,false);
    }
    public Vector eQuery(String sql,boolean with_drug) throws Exception
    {
        OrderItem p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        int i =0;
        while(rs.next())
        {
            p = new OrderItem();
            p.setObjectId(rs.getString(dbObj.pk_field));
            p.visit_id = rs.getString(dbObj.visit_id);
            p.item_code = rs.getString(dbObj.item_code);
            p.vertifier = rs.getString(dbObj.vertifier);
            p.vertify_time = rs.getString(dbObj.vertify_time);
            p.executer = rs.getString(dbObj.executer);
            p.executed_time = rs.getString(dbObj.executed_time);
            p.discontinue = rs.getString(dbObj.discontinue);
            p.discontinue_time = rs.getString(dbObj.discontinue_time);
            p.dispense = rs.getString(dbObj.dispense);
            p.dispense_time = rs.getString(dbObj.dispense_time);
            p.clinic_code = rs.getString(dbObj.clinic_code);
            p.category_group = rs.getString(dbObj.category_group);
            p.charge_complete = rs.getString(dbObj.charge_complete);
            p.status = rs.getString(dbObj.status);
            p.secret = rs.getString(dbObj.secret);
            p.continue_order = rs.getString(dbObj.continue_order);
            p.price = rs.getString(dbObj.price);
            p.qty = rs.getString(dbObj.qty);
            p.item_group_code_billing = rs.getString(dbObj.item_group_code_billing);
            p.common_name = rs.getString(dbObj.common_name);
            p.refer_out = rs.getString(dbObj.refer_out);
            p.hn = rs.getString(dbObj.hn);
            p.request = rs.getString(dbObj.request);
            p.order_user = rs.getString(dbObj.order_user);
            p.order_time = rs.getString(dbObj.order_time);
            p.order_complete = rs.getString(dbObj.order_complete);
            p.order_cost = rs.getString(dbObj.order_cost);
            p.note = rs.getString(dbObj.note);
            p.reporter = rs.getString(dbObj.reporter);
            p.reported_time = rs.getString(dbObj.reported_time);
            p.cause_cancel_resultlab = rs.getString(dbObj.cause_cancel_resultlab);
            p.drug_allergy = rs.getString(dbObj.drug_allergy);
            p.order_home = rs.getString(dbObj.order_home);
            p.item_16_group = rs.getString(dbObj.item_16_group);
            p.item_group_code_category = rs.getString(dbObj.item_group_code_category);
            p.specified = rs.getString(dbObj.specified);
            p.specified_data = rs.getString(dbObj.specified_data);
            list.add(p);
            if(false && with_drug)
                p.theOrderItemDrug = theOrderItemDrugDB.rs2Object(rs);
            i = i+1;
        }
        rs.close();
        return list;
    }
//    public Vector eQuery(String sql,boolean with_drug) throws Exception
//    {
//        OrderItem p;
//        Vector list = new Vector();
//        ResultSet rs = theConnectionInf.eQuery(sql.toString());
//        int i =0;
//        while(rs.next())
//        {
//            p = new OrderItem();
//            p.setObjectId(rs.getString(dbObj.table ).append( "." ).append( dbObj.pk_field));
//            p.visit_id = rs.getString(dbObj.table ).append( "." ).append( dbObj.visit_id);
//            p.item_code = rs.getString(dbObj.table ).append( "." ).append( dbObj.item_code);
//            p.vertifier = rs.getString(dbObj.table ).append( "." ).append( dbObj.vertifier);
//            p.vertify_time = rs.getString(dbObj.table ).append( "." ).append( dbObj.vertify_time);
//            p.executer = rs.getString(dbObj.table ).append( "." ).append( dbObj.executer);
//            p.executed_time = rs.getString(dbObj.table ).append( "." ).append( dbObj.executed_time);
//            p.discontinue = rs.getString(dbObj.table ).append( "." ).append( dbObj.discontinue);
//            p.discontinue_time = rs.getString(dbObj.table ).append( "." ).append( dbObj.discontinue_time);
//            p.dispense = rs.getString(dbObj.table ).append( "." ).append( dbObj.dispense);
//            p.dispense_time = rs.getString(dbObj.table ).append( "." ).append( dbObj.dispense_time);
//            p.clinic_code = rs.getString(dbObj.table ).append( "." ).append( dbObj.clinic_code);
//            p.category_group = rs.getString(dbObj.table ).append( "." ).append( dbObj.category_group);
//            p.charge_complete = rs.getString(dbObj.table ).append( "." ).append( dbObj.charge_complete);
//            p.status = rs.getString(dbObj.table ).append( "." ).append( dbObj.status);
//            p.secret = rs.getString(dbObj.table ).append( "." ).append( dbObj.secret);
//            p.continue_order = rs.getString(dbObj.table ).append( "." ).append( dbObj.continue_order);
//            p.price = rs.getString(dbObj.table ).append( "." ).append( dbObj.price);
//            p.qty = rs.getString(dbObj.table ).append( "." ).append( dbObj.qty);
//            p.item_group_code_billing = rs.getString(dbObj.table ).append( "." ).append( dbObj.item_group_code_billing);
//            p.common_name = rs.getString(dbObj.table ).append( "." ).append( dbObj.common_name);
//            p.refer_out = rs.getString(dbObj.table ).append( "." ).append( dbObj.refer_out);
//            p.hn = rs.getString(dbObj.table ).append( "." ).append( dbObj.hn);
//            p.request = rs.getString(dbObj.table ).append( "." ).append( dbObj.request);
//            p.order_user = rs.getString(dbObj.table ).append( "." ).append( dbObj.order_user);
//            p.order_time = rs.getString(dbObj.table ).append( "." ).append( dbObj.order_time);
//            p.order_complete = rs.getString(dbObj.table ).append( "." ).append( dbObj.order_complete);
//            p.order_cost = rs.getString(dbObj.table ).append( "." ).append( dbObj.order_cost);
//            p.reporter = rs.getString(dbObj.table ).append( "." ).append( dbObj.reporter);
//            p.reported_time = rs.getString(dbObj.table ).append( "." ).append( dbObj.reported_time);
//            p.cause_cancel_resultlab = rs.getString(dbObj.table ).append( "." ).append( dbObj.cause_cancel_resultlab);
//            p.drug_allergy = rs.getString(dbObj.table ).append( "." ).append( dbObj.drug_allergy);
//            p.order_home = rs.getString(dbObj.table ).append( "." ).append( dbObj.order_home);
//            p.item_16_group = rs.getString(dbObj.table ).append( "." ).append( dbObj.item_16_group);
//            p.item_group_code_category = rs.getString(dbObj.table ).append( "." ).append( dbObj.item_group_code_category);
//            list.add(p);
//            if(with_drug)
//                p.theOrderItemDrug = theOrderItemDrugDB.rs2Object(rs);
//            i = i).append(1;
//        }
//        rs.close();
//        return list;
//    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector e1Query(String sql) throws Exception
    {
        OrderItem p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        while(rs.next())
        {
            p = new OrderItem();
            p.vertify_time = rs.getString(dbObj.vertify_time);
            if(!p.vertify_time.equalsIgnoreCase(""))
                list.add(p);
        }
        rs.close();
        return list;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector e2Query(String sql) throws Exception
    {
        OrderItem p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql.toString());
        while(rs.next())
        {
            p = new OrderItem();
            p.visit_id = rs.getString(dbObj.visit_id);
            list.add(p);
        }
        rs.close();
        return list;
    }
    public void checkIndex()
    {   StringBuffer sql = new StringBuffer();


        try{
            sql.append( "CREATE INDEX " ).append(this.dbObj.visit_id ).append( " ON " )
                    .append( dbObj.table  ).append( " USING btree (").append(this.dbObj.visit_id ).append(")");
            this.theConnectionInf.eUpdate(sql.toString());
        }
        catch(Exception ex)
        {

        }
        try
        {
            sql .append( "CREATE INDEX " ).append( dbObj.status  ).append( " ON " )
                    .append( dbObj.table  ).append( " USING btree (").append(dbObj.status).append(")");
            this.theConnectionInf.eUpdate(sql.toString());
        }
        catch(Exception ex)
        {
        }
        try
        {
            sql .append( "CREATE INDEX " ).append( dbObj.vertify_time  ).append( " ON " )
                    .append( dbObj.table  ).append( " USING btree (").append(dbObj.vertify_time).append(")");
            this.theConnectionInf.eUpdate(sql.toString());
        }
        catch(Exception ex)
        {
        }
    }

    /**
     *@Author: amp
     *@date : 07/03/2549
     *@see: ���͡ order �Ż
     */
     public Vector selectOrderItemByVNAndOrderNotSecret(String visit_id ,String category_group
        , boolean showreport, boolean showremain ,boolean charge_complete) throws Exception
     {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'");

        sql.append( " and (" ).append( dbObj.status ).append( " = '1'"
        ).append( " or " ).append( dbObj.status ).append( " = '2' ");

        if(showreport)
        {
            sql.append( " or " ).append( dbObj.status ).append( " = '4'");
        }
        if(showremain)
        {
            sql.append( " or " ).append( dbObj.status ).append( " = '6'");
        }
        sql.append( ")");
        sql.append( " and " ).append( dbObj.secret ).append( " <> '1'") ;
        sql.append( " Order by " ).append( dbObj.order_time ).append( "," ).append( dbObj.common_name);

        return eQuery(sql.toString());
     }

     /**
     *@Author: amp
     *@date : 07/03/2549
     *@see: ���͡ order �Ż
     */
     public Vector selectOrderItemByPk(String pk) throws Exception
     {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.pk_field
        ).append( " = '" ).append( pk ).append( "'");

        return eQuery(sql.toString());
     }

     public Vector selectOrderByType(String pk) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.category_group
        ).append( " = '" ).append( pk ).append( " ORDER BY ").append( dbObj.order_time ).append( " desc ");
        Vector v=eQuery(sql.toString());
        if(v.size()==0) return null;
        else            return v;
    }

     public Vector selectOrderByItemId(String pk) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.item_code
        ).append( " = '" ).append( pk ).append( "' ");
        Vector v=eQuery(sql.toString());
        if(v.size()==0)
        {
            return null;
        }
        else
        {
            return v;
        }
    }

    public Vector selectOrderItemAllVnCG(String visit_id,String category_group) throws Exception
    {
        // tuk@21/07/2549 �������ʴ������ŷ�����١¡��ԡ�����ʶҹз�����������׹�ѹ
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id
        ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( category_group ).append( "'"
        ).append( " and (" ).append( dbObj.status ).append( " <> '3' and " ).append( dbObj.status ).append( " <> '0')");
        return eQuery(sql.toString());
    }

     /**
     *@Author: amp
     *@date : 13/03/2549
     *@see: ���͡ order
     */
     public Vector selectOrderItemByItemId(String item_id) throws Exception
     {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.item_code
        ).append( " = '" ).append( item_id ).append( "'");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
     }

     /**
      * visit_id, category_group, order_status
      */
     public Vector selectLabExeRep(String visit_id) throws Exception
     {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( CategoryGroup.isLab() ).append( "'"
        ).append( " and (" ).append( dbObj.status ).append( " = '").append( OrderStatus.EXECUTE ).append( "'"
        ).append( " or " ).append( dbObj.status ).append( " = '").append( OrderStatus.REPORT ).append( "')"
        ).append( " Order by " ).append( dbObj.order_time ).append( "," ).append( dbObj.common_name);
        return eQuery(sql.toString());
     }
     public Vector selectByVidCatStatus(String visit_id,String cat
             ,String status1,String status2,String status3) throws Exception
     {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( cat ).append( "'"
        ).append( " and (" ).append( dbObj.status ).append( " = '").append( status1 ).append( "'"
        ).append( " or " ).append( dbObj.status ).append( " = '").append( status2 ).append( "' "
        ).append( " or " ).append( dbObj.status ).append( " = '").append( status3 ).append( "')"
        ).append( " Order by " ).append( dbObj.order_time ).append( "," ).append( dbObj.common_name);
        return eQuery(sql.toString());
     }
     /**���� Order Item ��� ����� Order �������͹���� ʶҹШе�ͧ�� status �׹�ѹ ���� ���Թ��� �¡�á�˹���Ҩ�����ʴ� �����§ҹ��
    �����������   ��Ǩ�ͺ charge_complete ��� ��ͧ����ʴ� Order Item ���Դ�Թ���� ����� true*/
    public Vector selectXrayByVid(String visit_id) throws Exception
    {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.visit_id ).append( " = '" ).append( visit_id ).append( "'"
        ).append( " and " ).append( dbObj.category_group ).append( " = '" ).append( CategoryGroup.isXray() ).append( "'"
        ).append( " and (" ).append( dbObj.status ).append( " = '" ).append( OrderStatus.VERTIFY ).append( "'"
        ).append( " or " ).append( dbObj.status ).append( " = '" ).append( OrderStatus.EXECUTE ).append( "'"
        ).append( " or " ).append( dbObj.status ).append( " = '" ).append( OrderStatus.REPORT ).append( "')"
        ).append( " Order by " ).append( dbObj.order_time);
        return eQuery(sql.toString());
    }

     /**
     *@Author: sumo
     *@date : 05/09/2549
     *@see: ���͡ order ������ʢͧ Item_Id �Ѻ Visit_Id ��е�ͧ��ʶҹз������� ����׹�ѹ���¡��ԡ
     *@return: Vector �ͧ��¡�� Order ��������
     */
     public Vector selectOrderItemByItemIdAndVid(String item_id,String vid) throws Exception
     {
        StringBuffer sql = new StringBuffer("select * from " ).append( dbObj.table
        ).append( " where " ).append( dbObj.item_code ).append( " = '" ).append( item_id
        ).append( "' and " ).append( dbObj.visit_id ).append( " = '" ).append( vid
        ).append( "' and (" ).append( dbObj.status ).append( " != '" ).append( OrderStatus.NOT_VERTIFY ).append( "'"
        ).append( " and " ).append( dbObj.status ).append( " != '" ).append( OrderStatus.DIS_CONTINUE ).append( "')");

        Vector v=eQuery(sql.toString());
        if(v.size()==0)
            return null;
        else
            return v;
     }
     /**
      *henbe add �����������ö�֧ item � category �������ҧ� ��
      */
     public Vector selectOtherByVid(String visit_id )throws Exception
    {
        StringBuffer sql = new StringBuffer( "select * from " ).append( dbObj.table ).append(
        " where " ).append( dbObj.category_group ).append( "<> '1' " ).append(
        " and " ).append( dbObj.category_group ).append( "<> '2' " ).append(
        " and " ).append( dbObj.category_group ).append( "<> '3' " ).append(
        " and " ).append( dbObj.category_group ).append( "<> '4' " ).append(
        " and " ).append( dbObj.category_group ).append( "<> '5' " ).append(
        " and " ).append( dbObj.visit_id ).append( " = '").append( visit_id ).append(
        "' and " ).append( dbObj.status ).append( "<> '3' " ).append(
        " and " ).append( dbObj.status ).append( "<> '0' ");

        return eQuery(sql.toString());
    }

}
