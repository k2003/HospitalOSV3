package com.hospital_os.objdb;import com.hospital_os.usecase.connection.*;import com.hospital_os.utility.*;import com.hospital_os.object.*;import java.util.*;import java.sql.*;public class ContractAdjustDB{    public ConnectionInf theConnectionInf;    public ContractAdjust dbObj;    final private String idtable = "134";    /**     * @param ConnectionInf db     * @roseuid 3F65897F0326     */    public ContractAdjustDB(ConnectionInf db)    {        theConnectionInf=db;        dbObj = new ContractAdjust();        initConfig();    }    public ContractAdjustDB()    {        theConnectionInf=null;        dbObj = new ContractAdjust();        initConfig();    }    public boolean initConfig()    {        dbObj.table="b_contract_condition";        dbObj.pk_field="b_contract_condition_id";        dbObj.contract_id   ="b_contract_id";        dbObj.covered_id   ="b_item_subgroup_id";        dbObj.adjustment   ="contract_condition_adjustment";        dbObj.draw ="contract_condition_draw";        /*        dbObj.table = "contract_adjust";        dbObj.pk_field = "key_id";        dbObj.contract_id = "contract_id";        dbObj.covered_id = "covered_id";        dbObj.adjustment = "adjustment";        dbObj.draw = "draw";         */        return true;    }        /**     * @param cmd     * @param o     * @return int     * @roseuid 3F6574DE0394     */    public int insert(ContractAdjust o) throws Exception    {        String sql="";        ContractAdjust p=o;        p.generateOID(idtable);        sql="insert into " + dbObj.table + " ("        + dbObj.pk_field        + " ,"	+ dbObj.contract_id        + " ,"	+ dbObj.covered_id        + " ,"	+ dbObj.adjustment        + " ,"	+ dbObj.draw        + " ) values ('"        + p.getObjectId()        + "','" + p.contract_id        + "','" + p.covered_id        + "','" + p.adjustment        + "','" + p.draw        + "')";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int update(ContractAdjust o) throws Exception    {        String sql="update " + dbObj.table + " set ";        ContractAdjust p=o;        String field =""        + "', " + dbObj.contract_id + "='" + p.contract_id        + "', " + dbObj.covered_id + "='" + p.covered_id        + "', " + dbObj.adjustment + "='" + p.adjustment        + "', " + dbObj.draw + "='" + p.draw        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int updateAdjust(ContractAdjust p) throws Exception    {        String sql="update " + dbObj.table +                 " set " + dbObj.adjustment + "='" + p.adjustment + "'" +                " where " + dbObj.pk_field + "='" + p.getObjectId() +"'";        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());        return theConnectionInf.eUpdate(sql);    }    public int delete(ContractAdjust o) throws Exception    {        String sql="delete from " + dbObj.table        + " where " + dbObj.pk_field + "='" +o.getObjectId() +"'";        return theConnectionInf.eUpdate(sql);    }        public Contract selectByPK(String pk) throws Exception    {        String sql="select * from " + dbObj.table        +" where " + dbObj.pk_field        + " = '" + pk + "'";        Vector v=eQuery(sql);        if(v.size()==0)            return null;        else            return (Contract)v.get(0);    }        public Vector selectByContractId(String pk) throws Exception    {        String sql="select * from " + dbObj.table        + " where " + dbObj.contract_id        + " = '" + pk + "'";        return eQuery(sql);    }        public Vector selectAll() throws Exception    {   Vector vc = new Vector();        String sql ="select * from " + dbObj.table + " order by "+        dbObj.contract_id;        vc = eQuery(sql);        if(vc.size()==0)            return null;        else            return vc;    }    /** ����� ��ǹŴ�ͧ ��¡�� order �������� ��¡�� order ��� ����Է�ԡ���ѡ��     *  ���������  : id �ͧ category_group ��� id �ͧ contract     *  �������͡ : Object �ͧ ContractAdjust     */    public ContractAdjust queryByCGaContractID(String category_group_id,String contract_id) throws Exception    {   Vector vc = new Vector();        String sql = "SELECT * FROM " + dbObj.table        + " WHERE " + dbObj.contract_id + " = '" + contract_id        + "' AND " + dbObj.covered_id + " = '" + category_group_id        + "'";                vc = eQuery(sql);        if(vc.size()==0)            return null;        else            return (ContractAdjust)vc.get(0);            }        public Vector eQuery(String sql) throws Exception    {        ContractAdjust p;        Vector list = new Vector();        ResultSet rs = theConnectionInf.eQuery(sql);        while(rs.next())        {            p = new ContractAdjust();            p.setObjectId(rs.getString(dbObj.pk_field));            p.contract_id = rs.getString(dbObj.contract_id);            p.covered_id = rs.getString(dbObj.covered_id);            p.adjustment = rs.getString(dbObj.adjustment);            p.draw = rs.getString(dbObj.draw);            list.add(p);        }        rs.close();        return list;    }    }