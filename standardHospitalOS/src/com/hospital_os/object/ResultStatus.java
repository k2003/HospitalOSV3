package com.hospital_os.object;import com.hospital_os.usecase.connection.Persistent;public class ResultStatus extends Persistent {        public String description;   /**    * @roseuid 3F658BBB036E    */   public ResultStatus()    {   }   /**    * �á��    */   public static String isNormal()   {    return "1";   }   /**    * ���á�Իá��    */   public static String isAbNormal()   {    return "2";           }   /**    * ������Ѻ��õ�Ǩ    */   public static String isNotVerify()   {    return "0";   }}
