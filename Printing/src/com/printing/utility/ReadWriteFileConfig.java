/* * ReadFileConfig.java * * Created on 19 ����Ҥ� 2547, 18:00 �. */package com.printing.utility;import java.io.*;import java.util.*;//import com.hospital_os.utility.*;import com.printing.utility.IOStream;/** * * @author  tong */public class ReadWriteFileConfig {        /** Creates a new instance of ReadFileConfig */     public ReadWriteFileConfig() {    }    /**     *  ��㹡�� ��ҹ������ͧ��� �¡�˹�     *  ��������� �� �������     */    public static String ReadFile(String filename)    {        return IOStream.readInputDefault(filename);    }    /**     *  ��㹡�� ��¹������ͧ��� ������Ѻ�����ŷ���ͧ�����¹ �¡�˹�     *  ��������� �� ������� ��� ������     */    public static void WriteFile(String str, String filename)    {        IOStream.writeOutputDefault(str, filename);    }    /**     *  ��㹡�� ź������ͧ���     *  ��������� �� �������     */    public static void DeleteFile(String filename)    {        IOStream.writeOutputDefault("", filename);    }        /**     * @param args the command line arguments     */    public static void main(String[] args) {        // TODO code application logic here       new ReadWriteFileConfig().WriteFile("h:/printing/printing",".printpath.cfg");    }    }