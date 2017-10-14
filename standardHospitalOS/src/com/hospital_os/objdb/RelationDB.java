/*Source file: E:\\Job\\DrugReportSep\\code\\com\\hospital_os\\control\\PrescribeDB.java
*/
package com.hospital_os.objdb;
import com.hospital_os.usecase.connection.*;
import com.hospital_os.utility.*;
import com.hospital_os.object.*;
import java.util.*;
import java.sql.*;
public class RelationDB
{
    public ConnectionInf theConnectionInf;
    public Relation dbObj;
    final public String idtable = "227";/*"199";
*/
    /**
     * @param ConnectionInf db
     * @roseuid 3F65897F0326
     */
    public RelationDB(ConnectionInf db)
    {
        theConnectionInf=db;
        dbObj = new Relation();
        initConfig();
    }
    public boolean initConfig()
    {
        dbObj.table="f_patient_relation";
        dbObj.pk_field="f_patient_relation_id";
        dbObj.description="patient_relation_description";
        dbObj.max_relation_id= "max_relation_id";
        /*
        dbObj.table = "relation";
        dbObj.pk_field = "religion_id";
         
        dbObj.description = "description";
         */
        return true;
    }
    
    
    /**
     * @param cmd
     * @param o
     * @return int
     * @roseuid 3F6574DE0394
     */
    public int insert(Relation o) throws Exception
    {
        String sql="";
        Relation p=o;
        
        sql="insert into " + dbObj.table + " ("
        + dbObj.pk_field
        + " ,"	+ dbObj.description
        
        + " ) values ('"
        + p.getObjectId()
        
        + "','" + p.description
        
        + "')";
        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());
        
        return theConnectionInf.eUpdate(sql);
    }
    public int update(Relation o) throws Exception
    {
        String sql="update " + dbObj.table + " set ";
        Relation p=o;
        String field =""
        + "', " + dbObj.description + "='" + p.description
        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";
        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());
        
        return theConnectionInf.eUpdate(sql);
    }
    /*
*/
    public int delete(Relation o) throws Exception
    {
        String sql="delete from " + dbObj.table
        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";
        return theConnectionInf.eUpdate(sql);
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Relation selectByPK(String pk) throws Exception
    {
        String sql="select * from " + dbObj.table
        + " where " + dbObj.pk_field
        + " = '" + pk + "'";
        
        Vector v=eQuery(sql);
        if(v.size()==0)
            return null;
        else
            return (Relation)v.get(0);
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Relation selectByName(String name) throws Exception
    {
        String sql="select * from " + dbObj.table
        + " where " + dbObj.description
        + " like '" + name.trim() + "'";
        
        Vector v=eQuery(sql);
        
        if(v.size()==0)
            return null;
        else
            return (Relation)v.get(0);
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector selectAll() throws Exception
    {   Vector vc = new Vector();
        String sql ="select * from " + dbObj.table + " order by "+
        dbObj.description;
        vc = veQuery(sql);
        if(vc.size()==0)
            return null;
        else
            return vc;
        
    }
    
    /*////////////////////////////////////////////////////////////////////////////
*/
    
    /**
     *@deprecated henbe unused
     *
     */
    public Vector veQuery(String sql) throws Exception
    {
        ComboFix p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            p = new ComboFix();
            p.code = rs.getString(dbObj.pk_field);
            p.name = rs.getString(dbObj.description);
            list.add(p);
        }
        rs.close();
        return list;
    }
    
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector eQuery(String sql) throws Exception
    {
        Relation p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            p = new Relation();
            p.setObjectId(rs.getString(dbObj.pk_field));
            p.description = rs.getString(dbObj.description);
            list.add(p);
        }
        rs.close();
        return list;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/
    public String selectMaxCode() throws Exception
    {
        String sql ="select max(" + dbObj.pk_field + ") as max_relation_id from " + dbObj.table;
        
        Vector v = relationQuery(sql);
        if(v.size()==0)
            return null;
        else
            return ((Relation)v.get(0)).getObjectId();
    }
    
    /*////////////////////////////////////////////////////////////////////////////
*/
    public Vector relationQuery(String sql) throws Exception
    {
        Relation p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            p = new Relation();
            p.setObjectId(rs.getString(dbObj.max_relation_id));
            list.add(p);
        }
        rs.close();
        return list;
    }
    /*////////////////////////////////////////////////////////////////////////////
*/

}
