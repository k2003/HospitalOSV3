package com.hospital_os.object;import com.hospital_os.usecase.connection.Persistent;public class VisitType extends Persistent {        public String description;               static public final String OPD = "0";       static public final String IPD = "1";       static public final String SURVEY = "S";   /**    * @roseuid 3F658BBB036E    */   public VisitType()    {   }}