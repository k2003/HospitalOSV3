package com.hosv3.gui.component.nan;import com.hospital_os.utility.XPersistent;import com.hospital_os.usecase.connection.CommonInf;public class PhysicalDetail extends XPersistent implements  CommonInf{    public String description="";    public String physical_part_id="";    public String employee_id="";        public String getCode() {        return this.getObjectId();    }        public String getName() {        return this.description;    }    public String toString(){        return getName();    }}