package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class ItemPriceDB{    public ConnectionInf theConnectionInf;    public ItemPrice dbObj;    final public String idtable = "175";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public ItemPriceDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new ItemPrice();        initConfig();    }    public boolean initConfig()    {        dbObj.table = "b_item_price";        dbObj.pk_field = "b_item_price_id";        dbObj.item_price_id = "item_price_number";        dbObj.item_id = "b_item_id";        dbObj.price = "item_price";        dbObj.price_cost = "item_price_cost";        dbObj.active_date = "item_price_active_date";        return true;    }     public static void updateField(ItemPrice obj)    {         obj.price = Constant.getSDouble(obj.price);           }               /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(ItemPrice p) throws Exception    {        updateField(p);        p.generateOID(idtable);        String sql="insert into " + dbObj.table + " ("        + dbObj.pk_field        + " ,"	+ dbObj.item_price_id        + " ,"	+ dbObj.item_id        + " ,"	+ dbObj.price                + " ,"	+ dbObj.price_cost        + " ,"	+ dbObj.active_date        + " ) values ('"        + p.getObjectId()        + "','" + p.item_price_id        + "','" + p.item_id        + "', " + p.price//�ٴմչ�����ѹ�� double  by  henbe                + ",'" + p.price_cost        + "','" + p.active_date        + "')";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int update(ItemPrice p) throws Exception    {        updateField(p);        String sql="update " + dbObj.table + " set ";        String field =""        + "', " + dbObj.item_price_id + "='" + p.item_price_id        + "', " + dbObj.item_id + "='" + p.item_id        + "', " + dbObj.price + "=" + p.price//�ٴմչ�����ѹ�� double  by  henbe        + ", " + dbObj.price_cost + "='" + p.price_cost        + "', " + dbObj.active_date + "='" + p.active_date        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }        public int delete(ItemPrice o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";        return theConnectionInf.eUpdate(sql);    }        public int delete(String pk) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.item_id + "='" + pk +"'";        return theConnectionInf.eUpdate(sql);    }        public ItemPrice selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.pk_field        + " = '" + pk + "'";                Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (ItemPrice)v.get(0);    }        public Vector selectByItem(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.item_id        + " = '" + pk + "'"                + " order by " + dbObj.active_date + " DESC";                return eQuery(sql);    }        public Vector selectAll() throws Exception    {        String sql="select * from " + dbObj.table;        Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return v;    }        public Vector eQuery(String sql) throws Exception    {        ItemPrice p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ItemPrice();            p.setObjectId(rs.getString(dbObj.pk_field));            p.item_price_id = rs.getString(dbObj.item_price_id);            p.item_id = rs.getString(dbObj.item_id);            p.price = rs.getString(dbObj.price);                        p.price_cost = rs.getString(dbObj.price_cost);            p.active_date = rs.getString(dbObj.active_date);            list.add(p);        }        rs.close();        return list;    }    }