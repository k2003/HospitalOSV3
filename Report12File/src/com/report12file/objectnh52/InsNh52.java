/* * Ins.java * * Created on 8 �ѹ��¹ 2548, 12:04 �. * * To change this template, choose Tools | Options and locate the template under * the Source Creation and Management node. Right-click the template and choose * Open. You can then make changes to the template in the Source Editor. */package com.report12file.objectnh52;import com.report12file.utility.Constant;import com.linuxense.javadbf.DBFField;import com.report12file.object.*;import com.report12file.utility.Report12FileData;import com.report12file.object.Rp12OI;import com.reportcenter.utility.IOStream;import java.io.BufferedReader;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;/** * * @author tong(Padungrat) */public class InsNh52 extends Ins implements Rp12OI{    public static String EMPTY = "";    public InsNh52() {    }    public Rp12OI initInstant() {        return new InsNh52();    }    public PreparedStatement getPreparedStatement(Connection con, String startDate, String endDate, int mode) throws Exception {        String sql = IOStream.readInputDefault("config/rp_12file/12file_ins.sql");        PreparedStatement pm = con.prepareStatement(sql);        pm.setString(1,startDate);        pm.setString(2,endDate);        pm.setString(3,startDate);        pm.setString(4,endDate);        return pm;    }}