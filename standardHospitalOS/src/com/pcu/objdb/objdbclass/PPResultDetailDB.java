package com.pcu.objdb.objdbclass;
import java.util.*;
import java.sql.*;
import com.hospital_os.usecase.connection.*;
import com.pcu.object.BDoctor;
import com.hospital_os.utility.*;

public class PPResultDetailDB
{
    public ConnectionInf theConnectionInf;
    public BDoctor dbObj, ObjectBDoctor;
    final private String idtable = "116";

    private String sql;
    private Vector vc;
    private ResultSet rs;
    private ComboFix theComboFix;
    public PPResultDetailDB(ConnectionInf db)
    {
        theConnectionInf=db;
        dbObj = new BDoctor();
        initConfig();
    }
    public boolean initConfig()
    {
        dbObj.table="f_pp_result_detail";
        dbObj.pk_field="f_pp_result_detail_id";
        dbObj.description="pp_result_detail_description";
        /*
        dbObj.table = "bdoctor";
        dbObj.pk_field = "bdoctor_id";
        dbObj.description = "description";
         */
        return true;
    }



    public int insert(BDoctor o) throws Exception
    {
        sql="";
        o.generateOID(idtable);
        sql="insert into " + dbObj.table + " ("
        + dbObj.pk_field
        + " ,"	+ dbObj.description
        + " ) values ('"
        + o.getObjectId()
        + "','" + o.description
        + "')";
        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());
        return theConnectionInf.eUpdate(sql);
    }
    public int update(BDoctor o) throws Exception
    {
        sql="update " + dbObj.table + " set ";

        String field =""
        + "', " + dbObj.description + "='" + o.description
        + "' where " + dbObj.pk_field + "='" + o.getObjectId() +"'";
        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());
        return theConnectionInf.eUpdate(sql);
    }

    public int delete(BDoctor o) throws Exception
    {
        sql="delete from " + dbObj.table
        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";
        return theConnectionInf.eUpdate(sql);
    }

    public BDoctor selectByPK(String pk) throws Exception
    {
        sql="select * from " + dbObj.table
        + " where " + dbObj.pk_field
        + " = '" + pk + "'";

        vc=eQuery(sql);
        if(vc.size()==0)
            return null;
        else
            return (BDoctor)vc.get(0);
    }

    public Vector selectAll() throws Exception
    {
        sql ="select * from " + dbObj.table + " order by "+
        dbObj.description;
        vc = veQuery(sql);
        if(vc.size()==0)
            return null;
        else
            return vc;

    }



    public Vector veQuery(String sql) throws Exception
    {

        vc = new Vector();
        rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            theComboFix = new ComboFix();
            theComboFix.code = rs.getString(dbObj.pk_field);
            theComboFix.name = rs.getString(dbObj.description);
            vc.add(theComboFix);
        }
        rs.close();
        return vc;
    }


    public Vector eQuery(String sql) throws Exception
    {

        vc = new Vector();
        rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            ObjectBDoctor = new BDoctor();
            ObjectBDoctor.setObjectId(rs.getString(dbObj.pk_field));
            ObjectBDoctor.description = rs.getString(dbObj.description);
            vc.add(ObjectBDoctor);
        }
        rs.close();
        return vc;
    }

}
