/*
 * HealthControl.java
 *
 * Created on 17 �Զع�¹ 2548, 15:46 �.
 * Modified on 25 �ѹ��¹ 2551
 */

package com.pcu.control;

import com.hosv3.control.HosControl;
import com.hosv3.control.LookupControl;
import java.util.*;
import com.hospital_os.usecase.connection.*;
import com.hosv3.object.UseCase;
import com.hosv3.utility.Constant;
import com.hosv3.utility.connection.UpdateStatus;
import com.pcu.object.*;
import com.pcu.utility.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Noom
 * @modifier pu
 */
public class HealthServiceControl {
    ConnectionInf theConnectionInf;
    UpdateStatus theUS;
    HosDB thePcuDB;
    PCUObject thePO;
    private Vector vNutrition = null;
    
    private LookupControl theLookupControl;
    HosControl theHC;
    private HosManage theHosManage;
    
    /** Creates a new instance of HealthControl */
    public HealthServiceControl() {
    }
    
    
    public HealthServiceControl(ConnectionInf con,HosDB hdb,PCUObject po,HosControl hc,UpdateStatus us) {
        theConnectionInf = con;
        thePcuDB = hdb;
        theHC = hc;
        theUS = us;
        thePO = po;
        theLookupControl = theHC.theLookupControl;
    }
    public HealthServiceControl(ConnectionInf con,HosDB hdb,UpdateStatus us,PCUObject po) {
        theConnectionInf = con;
        thePcuDB = hdb;
        theUS = us;
        thePO = po;
    }
    public void setHosManage(HosManage hosManage)
    {
        theHosManage = hosManage;
    }
    /**@deprecated pu : �� LookupControl � constuctor ����*/
    public void setDepControl(LookupControl lc) {
        theLookupControl = lc;
    }
    public int saveNutrition(Nutrition nutrition) {
        Constant.println(UseCase.UCID_saveNutrition);
        String objectid =   null;
        int result = 0;
        String age;
        int current;
        current = 0;
        String errorMsg = "";
        if(this.theHC.theHO.theVisit==null)
        {
            this.theUS.setStatus("��سҹӼ������������кǹ���", UpdateStatus.WARNING);
            return 0;
        }
//        if(!this.theHC.theHO.theVisit.service_location.equals("2"))
//        {
//            this.theUS.setStatus("��س��кػ����� Visit ������ԡ�ù͡˹��º�ԡ��", UpdateStatus.WARNING);
//            return 0;
//        }
        if(!nutrition.survey_date.equals("")
            && nutrition.survey_date.length()==10
            && com.pcu.utility.DateUtil.countDay(nutrition.survey_date,theHosManage.theHosControl.theConnectionInf) == -1
            && com.pcu.utility.DateUtil.isToday(com.pcu.utility.DateUtil.getDateFromText(nutrition.survey_date),theHosManage.theHosControl.theConnectionInf)==false)
        {     // �������ö��͡�ѹ������ѹ�͹Ҥ���
                theUS.setStatus(GutilPCU.getTextBundle("NoDateFuture") , UpdateStatus.WARNING);
                return 3;

        }
        if(thePO.getFamily() == null)
        {
            theUS.setStatus("��س����͡��Ъҡ����ͺѹ�֡�����Ż�Ъҡá�͹",UpdateStatus.WARNING);
            return 4;
        }
        try
        {
            if((!nutrition.nutrition_newtooth.equals("") && Integer.parseInt(nutrition.nutrition_newtooth) > 32)
            || (!nutrition.nutrition_badtooth.equals("") && Integer.parseInt(nutrition.nutrition_badtooth) > 32))
            {
               errorMsg +=  GutilPCU.getTextBundle("WarningCheckRealTooth")+"\r\n";
            }
            if(!errorMsg.equals(""))
            {
                theUS.setStatus(errorMsg, UpdateStatus.WARNING);
                return 5;
            }
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            return 6;
        }
        if(thePO.theHO.thePatient!=null&&!thePO.getPatient().patient_birthday.equals(""))
        {
            age = DateUtil.calculateAge(thePO.getPatient().patient_birthday,thePO.getCurrentDateTime());
            current = Integer.parseInt(age);
        }
        else if(thePO.getFamily()!=null&&!thePO.getFamily().patient_birthday.equals(""))
        {
            age = DateUtil.calculateAge(thePO.getFamily().patient_birthday,thePO.getCurrentDateTime());
            current = Integer.parseInt(age);
        }
        if(nutrition.nutrition_age.equals(""))
        {
            theUS.setStatus(GutilPCU.getTextBundle("CheckAge"), UpdateStatus.WARNING);//��سҡ�͡���� (��͹) �ͧ�������Ѻ��ԡ��
            return 7;
        }
        else if(current > 6 && this.thePO.theHO.theVisit==null)
        {
            if(nutrition.nutrition_weight.equals("")
               && nutrition.nutrition_high.equals(""))
               {   theUS.setStatus(GutilPCU.getTextBundle("��سҡ�͡�����Ź��˹ѡ-��ǹ�٧"), UpdateStatus.WARNING);
                   return 8;
               }
        }
        //09/12/2010 ������͡�����������ӧҹ���¢��
//        if(nutrition != null && !"".equals(nutrition.getObjectId()) && nutrition.getObjectId() != null)
//        {   if(thePO.theHO.theVisit != null && !nutrition.visit_id.equals(thePO.theHO.theVisit.getObjectId()))
//            {   theUS.setStatus(GutilPCU.getTextBundle("NotSavePreviousVisit"), UpdateStatus.WARNING);//�������ö��䢢����Ţͧ����Ѻ��ԡ�ä��駡�͹��
//                return 9;
//            }
//            else if(thePO.theHO.theVisit == null && !"".equals(nutrition.visit_id))
//            {   theUS.setStatus(GutilPCU.getTextBundle("NotSavePreviousVisit"), UpdateStatus.WARNING);//�������ö��䢢����Ţͧ����Ѻ��ԡ�ä��駡�͹��
//                return 10;
//            }
//        }

//        if((!nutrition.nutrition_age.equals("")) && Integer.parseInt(nutrition.nutrition_age) > 73)
//        {
//            this.theUS.setStatus("���ص�ͧ����ҡ���� 73 ��͹", UpdateStatus.WARNING);
//            return 11;
//        }
        if(nutrition.modify_date_time.length()<10) {
            theUS.setStatus("��س��к��ѹ���ѹ�֡",UpdateStatus.WARNING);
            return 12;
        }
        if(theLookupControl.isDateFuture(nutrition.modify_date_time)) {
            theUS.setStatus("��س��к��ѹ���ѹ�֡���ѹ�͵յ",UpdateStatus.WARNING);
            return 13;
        }
//        if(thePO.getVisit()!=null && !nutrition.visit_id.equals("")){
//            if(!thePO.getVisit().visit_status.equals(VisitStatus.isInProcess())){
//                theUS.setStatus("�����Ź���繢ͧ����Ѻ��ԡ�÷�診��кǹ��������������ö�����",UpdateStatus.WARNING);
//                return 14;
//            }
//            if(!thePO.getVisit().getObjectId().equals(nutrition.visit_id)
//            && !nutrition.visit_id.equals("")){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//                return 15;
//            }
//        }
//        if(thePO.getVisit()==null && !nutrition.visit_id.equals("")){
//            theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//            return 16;
//        }
        if((!nutrition.nutrition_age.equals("")) && Integer.parseInt(nutrition.nutrition_age) > 73)
        {
            int choice = JOptionPane.showConfirmDialog(theUS.getJFrame(),
                    Constant.getTextBundle("�����Թ 73 ��͹�׹�ѹ��úѹ�֡������"),
                    Constant.getTextBundle("�����Թ 73 ��͹�׹�ѹ��úѹ�֡������"),
                    JOptionPane.OK_OPTION);
            if(choice == JOptionPane.NO_OPTION)
                return 17;
        }
        theConnectionInf.open();
        try {
            if(nutrition.getObjectId() == null) {
                if(thePO.getVisit() != null)
                {   
                    if(nutrition.getObjectId() == null)
                    {   
                        nutrition.nutrition_vn = thePO.getVisit().vn;
                        nutrition.visit_id = thePO.getVisit().getObjectId();
                    }
                }
                if(thePO.getPatient()!=null){
                    nutrition.patient_id = thePO.getPatient().getObjectId();        
                    nutrition.nutrition_hn = thePO.getPatient().hn;
                }
                if(thePO.getFamily()!=null)
                   nutrition.family_id = thePO.getFamily().getObjectId();

                result = thePcuDB.theNutritionDB.insert(nutrition);
            } else {
                result = thePcuDB.theNutritionDB.update(nutrition);
            }
            thePO.vNutrition = thePcuDB.theNutritionDB.selectByFamilyID(nutrition.family_id);
            theUS.setStatus(GutilPCU.getTextBundle("SaveComplete"), UpdateStatus.COMPLETE);//��úѹ�֡�������������
            if(nutrition != null)
                objectid = nutrition.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_saveNutrition,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_saveNutrition,objectid,null,UpdateStatus.COMPLETE);
        } catch(Exception ex) {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_saveNutrition,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_saveNutrition,objectid,ex,UpdateStatus.ERROR);
        } finally {
            theConnectionInf.close();
        }
        return result;
    }
    public int deleteNutrition(Nutrition nutrition) 
    {
        Constant.println(UseCase.UCID_deleteNutrition);
        String objectid =   null;
        int result = 0; 
        //�ҡ��¡�÷�����͡�繢ͧ visit ���
//        if(!nutrition.visit_id.equals("")){
//            //��ͧ��Ǩ�ͺ����������͡ visit ���������������
//            if(thePO.getVisit()==null || !thePO.getVisit().getObjectId().equals(nutrition.visit_id)){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//            if(!thePO.getVisit().visit_status.equals(VisitStatus.isInProcess())){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�÷�診��кǹ��������������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//        }
        if(!theUS.confirmBox(GutilPCU.getTextBundle("VerifyBeforeDelete"),UpdateStatus.WARNING)){
            return result;
        }
        theConnectionInf.open();
        try {
            nutrition.nutrition_staff_cancel = thePO.getEmployee().getObjectId();
            nutrition.cancel_date_time = thePO.getCurrentDateTime();
            nutrition.active = "0";
            result = thePcuDB.theNutritionDB.update(nutrition);
            thePO.vNutrition = thePcuDB.theNutritionDB.selectByFamilyID(nutrition.family_id);
            theUS.setStatus(GutilPCU.getTextBundle("���ź����������ҡ���������"), UpdateStatus.COMPLETE);//��úѹ�֡�������������\
            if(nutrition != null)
                objectid = nutrition.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_deleteNutrition,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_deleteNutrition,objectid,null,UpdateStatus.COMPLETE);
        } catch(Exception ex) 
        {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_deleteNutrition,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_deleteNutrition,objectid,ex,UpdateStatus.ERROR);
        }
        finally {
            theConnectionInf.close();
        }
        return result;
    }
    public Vector listNutritionByPatientID(String search) {
        vNutrition = new Vector();
        theConnectionInf.open();
        try {
            vNutrition = thePcuDB.theNutritionDB.selectByPatientID(search);
        } catch(Exception ex) {
            ex.printStackTrace();
            theConnectionInf.rollback();
        } finally {
            theConnectionInf.close();
        }
        return vNutrition;
    }
    
    public EpiSetGroup readEpiSetGroup(String epi_id) {
        EpiSetGroup ds = null;
        theConnectionInf.open();
        try {
            ds = thePcuDB.theEpiSetGroupDB.selectByPK(epi_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return ds;
    }
    
    public Vector listEpiByPatientID(String patient_id) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theEpiDB.selectByPatientID(patient_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
    public Vector listEpiByFamilyID() {
        return thePO.vEpi;
    }
    /**
     * jao
     * ���ҡ���Ѻ�Ѥ�չ�����ç��Һ��
     * Input FamilyID
     * Output Vector Epi
     * @not deprecated henbe �ѹ�֧�ҵ͹���͡��Ъҡ��������ǹ�
     * �������
     */
    public Vector listEpiByFamilyID(String family_id) {
        theConnectionInf.open();
        try {
            thePO.vEpi = thePcuDB.theEpiDB.selectByFamilyID(family_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return thePO.vEpi;
    }
    
    public Vector listEpiDetailByEpiID(String epi_id) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theEpiDetailDB.selectByEpiID(epi_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
    
    public int saveGrow(GrowPcu growPcu,GrowHistory growHistory) {
        Constant.println(UseCase.UCID_saveGrow);
        String objectid =   null;
        int result = 0;
        if(this.theHC.theHO.theVisit==null)
        {
            this.theUS.setStatus("��سҹӼ������������кǹ���", UpdateStatus.WARNING);
            return 0;
        }
//        if(!this.theHC.theHO.theVisit.service_location.equals("2"))
//        {
//            this.theUS.setStatus("��س��кػ����� Visit ������ԡ�ù͡˹��º�ԡ��", UpdateStatus.WARNING);
//            return 0;
//        }
        if(theLookupControl.isDateFuture(growHistory.modify_date_time) && growHistory.getObjectId()==null) {
            theUS.setStatus("��س��к��ѹ������Ǩ���ѹ����ʹյ", UpdateStatus.WARNING);
            return 0;
        }
        if(growHistory.modify_date_time.length()<10) {
            theUS.setStatus("��س��к��ѹ���ѹ�֡",UpdateStatus.WARNING);
            return 0;
        }
        if(theLookupControl.isDateFuture(growHistory.modify_date_time)) {
            theUS.setStatus("��س��к��ѹ����Ѻ�Ѥ�չ���ѹ�͵յ",UpdateStatus.WARNING);
            return 0;
        }
        if(thePO.getVisit()==null){
            if(growHistory.survey_date.equals("")){
                theUS.setStatus(GutilPCU.getTextBundle("WarningNotHaveSurVeyDate"), UpdateStatus.WARNING);     
                return 0;
            }
        }
        theConnectionInf.open();
        try{
            if(growPcu.getObjectId() == null && !growPcu.active.equals("0")) {   // ����ºѹ�֡
                //insert ������ŧ���ҧ EPI
                if (thePO.getPatient()!=null)
                {   
                    growPcu.patient_id = thePO.getPatient().getObjectId(); 
                    growPcu.grow_hn = thePO.getPatient().hn;      
                    growHistory.patient_id = thePO.getPatient().getObjectId();
                }
                if(thePO.getFamily()!=null)
                {
                    growPcu.family_id = thePO.getFamily().getObjectId();
                    growHistory.family_id = thePO.getFamily().getObjectId();
                }
                if(thePO.getVisit()!=null)
                {
                    growPcu.visit_id = thePO.getVisit().getObjectId();
                    growPcu.grow_vn = thePO.getVisit().vn;
                    growHistory.visit_id = thePO.getVisit().getObjectId();                 
                }

                growPcu.record_date_time = thePO.getCurrentDateTime();
                growPcu.staff_record = thePO.getEmployee().getObjectId();
                growPcu.active = "1";
                result+=thePcuDB.theGrowPcuDB.insert(growPcu);
            } else {   // �ºѹ�֡����
                //update ������ŧ���ҧ EPI
                result+=thePcuDB.theGrowPcuDB.update(growPcu);
            }
            growHistory.health_grow_id = growPcu.getObjectId();
            growHistory.staff_modify = thePO.getEmployee().getObjectId();

            //insert ������ŧ���ҧ EPIDETAIL
            if(growHistory.getObjectId() == null) {
                growHistory.staff_record = thePO.getEmployee().getObjectId();
                growHistory.record_date_time = thePO.getCurrentDateTime();
                growHistory.active = "1";
                result+=thePcuDB.theGrowHistoryDB.insert(growHistory);
            } else
                result+=thePcuDB.theGrowHistoryDB.update(growHistory);
                
            thePO.vGrowHistory = thePcuDB.theGrowHistoryDB.selectByFamilyID(thePO.getFamily().getObjectId());
            
            if(growPcu.active.equals("0"))
                theUS.setStatus(GutilPCU.getTextBundle("���ź�������������"), UpdateStatus.COMPLETE);//��úѹ�֡�������������
            else
                theUS.setStatus(GutilPCU.getTextBundle("SaveComplete"),UpdateStatus.COMPLETE);
            if(growPcu != null)
                objectid = growPcu.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_saveGrow,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_saveGrow,objectid,null,UpdateStatus.COMPLETE);
            return result;
        } 
        catch(Exception ex) {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_saveGrow,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_saveGrow,objectid,ex,UpdateStatus.ERROR);
            return result;
        } 
        finally{
            theConnectionInf.close();
        }
    }
    
    public int deleteGrow(GrowPcu growPcu, GrowHistory growHistory)
    {
        Constant.println(UseCase.UCID_deleteGrow);
        String objectid =   null;
        //�ҡ��¡�÷�����͡�繢ͧ visit ���
//        if(!growPcu.visit_id.equals("")){
//            //��ͧ��Ǩ�ͺ����������͡ visit ���������������
//            if(thePO.getVisit()==null || !thePO.getVisit().getObjectId().equals(growPcu.visit_id)){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//            if(!thePO.getVisit().visit_status.equals(VisitStatus.isInProcess())){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�÷�診��кǹ��������������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//        }
        if(!theUS.confirmBox(GutilPCU.getTextBundle("ConfirmDeleteGrow"),UpdateStatus.WARNING)){   
            return 0;
        }
        
        theConnectionInf.open();
        try{
            growHistory.staff_cancel = thePO.getEmployee().getObjectId();
            growHistory.cancel_date_time = thePO.getCurrentDateTime();
            growHistory.active = "0";
            growPcu.active = "0";
            thePcuDB.theGrowHistoryDB.update(growHistory);
            thePcuDB.theGrowPcuDB.update(growPcu);
            thePO.vGrowHistory = thePcuDB.theGrowHistoryDB.selectByFamilyID(thePO.getFamily().getObjectId());
            thePO.vGrowPcu = thePcuDB.theGrowPcuDB.selectByFamilyID(thePO.getFamily().getObjectId());
            theUS.setStatus(GutilPCU.getTextBundle("���ź�������������"), UpdateStatus.COMPLETE);//��úѹ�֡�������������
            if(growPcu != null)
                objectid = growPcu.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_deleteGrow,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_deleteGrow,objectid,null,UpdateStatus.COMPLETE);
            return 1;
        } 
        catch(Exception ex) {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_deleteGrow,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_deleteGrow,objectid,ex,UpdateStatus.ERROR);
            return 0;
        } 
        finally{
            theConnectionInf.close();
        }
    }
    /**
     *@deprecated henbe unused
     *
     */
       public int saveGrow(GrowPcu growPcu, Vector vGrowHistory) {
        int result = 0;
        for(int i=0;i<vGrowHistory.size();i++) {
            GrowHistory maim = (GrowHistory)vGrowHistory.get(i);
            if(theLookupControl.isDateFuture(maim.modify_date_time) && maim.getObjectId()==null) {
                theUS.setStatus("��س��к��ѹ������Ǩ���ѹ����ʹյ", UpdateStatus.WARNING);
                return 0;
            }
            if(maim.modify_date_time.length()<10) {
                theUS.setStatus("��س��к��ѹ���ѹ�֡",UpdateStatus.WARNING);
                return 0;
            }
            if(theLookupControl.isDateFuture(maim.modify_date_time)) {
                theUS.setStatus("��س��к��ѹ����Ѻ�Ѥ�չ���ѹ�͵յ",UpdateStatus.WARNING);
                return 0;
            }
        }
        theConnectionInf.open();
        try{
            if(growPcu.getObjectId() == null && !growPcu.active.equals("0")) {   // ����ºѹ�֡
                //insert ������ŧ���ҧ EPI
                growPcu.record_date_time = thePO.getCurrentDateTime();
                growPcu.staff_record = thePO.getEmployee().getObjectId();
                growPcu.active = "1";
                result+=thePcuDB.theGrowPcuDB.insert(growPcu);
            } else {   // �ºѹ�֡����
                //update ������ŧ���ҧ EPI
                result+=thePcuDB.theGrowPcuDB.update(growPcu);
            }
            for(int i = 0 ; i < vGrowHistory.size(); i++) {
                GrowHistory growHistory = (GrowHistory)vGrowHistory.get(i);
                growHistory.health_grow_id = growPcu.getObjectId();
                growHistory.staff_modify = thePO.getEmployee().getObjectId();
                
                //insert ������ŧ���ҧ EPIDETAIL
                if(growHistory.getObjectId() == null) {
                    growHistory.staff_record = thePO.getEmployee().getObjectId();
                    growHistory.record_date_time = thePO.getCurrentDateTime();
                    growHistory.active = "1";
                    result+=thePcuDB.theGrowHistoryDB.insert(growHistory);
                } else
                    result+=thePcuDB.theGrowHistoryDB.update(growHistory);
            }
            thePO.vGrowHistory = thePcuDB.theGrowHistoryDB.selectByFamilyID(thePO.getFamily().getObjectId());
            
            if(growPcu.active.equals("0"))
                theUS.setStatus(GutilPCU.getTextBundle("���ź�������������"), UpdateStatus.COMPLETE);//��úѹ�֡�������������
            else
                theUS.setStatus(GutilPCU.getTextBundle("SaveComplete"),UpdateStatus.COMPLETE);
            return result;
        } catch(Exception ex) {
            theUS.setStatus(GutilPCU.getTextBundle("SaveNotComplete"),UpdateStatus.ERROR);
            ex.printStackTrace();
            return result;
        } finally{
            theConnectionInf.close();
        }
    }
       
    public int deleteEpiDetail(EpiDetail epiDetail) {
        int result = 0;
        theConnectionInf.open();
        try {
            result = thePcuDB.theEpiDetailDB.delete(epiDetail);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return result;
    }
    
    
    public Vector listGrow(String month) {
        Vector vVector = new Vector();
        theConnectionInf.open();
        try {
            vVector = thePcuDB.theGrowDB.selectByCombo(month);
        } catch(Exception ex) {
            ex.printStackTrace();
            theConnectionInf.rollback();
        } finally {
            theConnectionInf.close();
        }
        return vVector;
    }
    
    public Vector listGrowByPatientID(String patient_id) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theGrowHistoryDB.selectByPatientID(patient_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
    
     /*
      * jao
      * ���Ң����š����ԭ�Ժⵢͧ�ؤ��
      * Input Family_id
      * Output Vector Grow
      * @deprecated henbe �ѹ�֧�ҵ͹���͡��Ъҡ��������ǹ�
      */
    public Vector listGrowByFamilyID() {
        return thePO.vGrowHistory;
    }
    public Vector listGrowByFamilyID(String family_id) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theGrowHistoryDB.selectByFamilyID(family_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
    
    public Vector listGrowPcuByPatientID(String patient_id) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theGrowPcuDB.selectByPatientID(patient_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
     /*
      *
      * jao
      * ���һ���ѵԡ����ԭ�Ժ�
      * Input Family_id
      * Output Vector GrowPcu
      * @deprecated henbe �ѹ�֧�ҵ͹���͡��Ъҡ��������ǹ�
      */
    public Vector listGrowPcuByFamilyID() {
        return this.thePO.vGrowPcu;
    }
    public Vector listGrowPcuByFamilyID(String family_id) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theGrowPcuDB.selectByFamilyID(family_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
    
    /**
     *�ѹ�֡��õ�駤�ö�
     *@param pregnancy = �����š�õ�駤�ö�
     *@return int
     *@author kinglang
     *@date 28/08/2549
     */
    public int savePregnancy(Pregnancy pregnancy) {
        Constant.println(UseCase.UCID_savePregnancy);
        String objectid =   null;
        int result = 0;
        if(this.theHC.theHO.theVisit==null)
        {
            this.theUS.setStatus("��سҹӼ������������кǹ���", UpdateStatus.WARNING);
            return 0;
        }
//        if(!this.theHC.theHO.theVisit.service_location.equals("2"))
//        {
//            this.theUS.setStatus("��س��кػ����� Visit ������ԡ�ù͡˹��º�ԡ��", UpdateStatus.WARNING);
//            return 0;
//        }
        if(pregnancy==null){
            System.out.println("if(pregnancy==null){");
            return 0;
        }
        if(pregnancy.pregnancy_menses_issue_date.equals("")) {
            theUS.setStatus("��س��к��ѹ����Ш���͹�Ҥ����ش����",UpdateStatus.WARNING);
            return 0;
        }
        if(pregnancy.pregnancy_menses_issue_date.startsWith("20")) {
            theUS.setStatus(Constant.getTextBundle("�ѹ����Ш���͹�Ҥ����ش����") + " " +
                    Constant.getTextBundle("�դ�����١��ͧ") +
                    " "+ pregnancy.pregnancy_menses_issue_date +" " +
                    Constant.getTextBundle("��سҵ�Ǩ�ͺ�к�"),UpdateStatus.WARNING);
            return 0;
        }
        if(pregnancy.pregnancy_menses_expire_date.equals("")) {
            theUS.setStatus("��س��к��ѹ��˹���ʹ",UpdateStatus.WARNING);
            return 0;
        }
        if(pregnancy.pregnancy_menses_expire_date.startsWith("20")) {
            theUS.setStatus(Constant.getTextBundle("�ѹ��˹���ʹ") + " " +
                    Constant.getTextBundle("�դ�����١��ͧ") +
                    " "+ pregnancy.pregnancy_menses_expire_date +" " +
                    Constant.getTextBundle("��سҵ�Ǩ�ͺ�к�"),UpdateStatus.WARNING);
            return 0;
        }
//        if(thePO.getVisit()!=null && !pregnancy.visit_id.equals("")){
////            if(!thePO.getVisit().visit_status.equals(VisitStatus.isInProcess())){
////                theUS.setStatus("�����Ź���繢ͧ����Ѻ��ԡ�÷�診��кǹ��������������ö�����",UpdateStatus.WARNING);
////                return 0;
////            }
//            if(!thePO.getVisit().getObjectId().equals(pregnancy.visit_id)
//            && !pregnancy.visit_id.equals("")){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//        }
//        if(thePO.getVisit()==null && !pregnancy.visit_id.equals("")){
//            theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//            return 0;
//        }
        theConnectionInf.open();
        try {
//            if(pregnancy.getObjectId()!=null){
//                Vector v = thePcuDB.theAncPcuDB.selectByPregnantID(pregnancy.getObjectId());
//                if(v!=null && !v.isEmpty()){
//                    theUS.setStatus(Constant.getTextBundle("�������š���麺�ԡ�ýҡ�����ͧ��õ�駤����������") +
//                            " " +
//                            Constant.getTextBundle("��س�¡��ԡ����Ѻ��ԡ�ýҡ������͹"),UpdateStatus.WARNING);
//                    return 0;
//                }
//            }
            if(pregnancy.getObjectId() == null){
                if(thePO.getVisit()!=null)
                    pregnancy.visit_id = thePO.getVisit().getObjectId();    
                result = thePcuDB.thePregnancyDB.insert(pregnancy);
            }
            else
                result = thePcuDB.thePregnancyDB.update(pregnancy);
            
            thePO.vPregnancy = thePcuDB.thePregnancyDB.selectByFamilyID(pregnancy.family_id);
            theUS.setStatus(GutilPCU.getTextBundle("SavePregnancyComplete"),UpdateStatus.COMPLETE);
            if(pregnancy != null)
                objectid = pregnancy.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_savePregnancy,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_savePregnancy,objectid,null,UpdateStatus.COMPLETE);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_savePregnancy,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_savePregnancy,objectid,ex,UpdateStatus.ERROR);
        }
        finally {
            theConnectionInf.close();
        }
        return result;
    }
    public int savePregnancyN(Pregnancy pregnancy) {
        Constant.println(UseCase.UCID_savePregnancy);
        String objectid =   null;
        int result = 0;
        if(this.theHC.theHO.theVisit==null)
        {
            this.theUS.setStatus("��سҹӼ������������кǹ���", UpdateStatus.WARNING);
            return 0;
        }
//        if(!this.theHC.theHO.theVisit.service_location.equals("2"))
//        {
//            this.theUS.setStatus("��س��кػ����� Visit ������ԡ�ù͡˹��º�ԡ��", UpdateStatus.WARNING);
//            return 0;
//        }
        if(pregnancy==null){
            System.out.println("if(pregnancy==null){");
            return 0;
        }
        if(pregnancy.pregnancy_menses_issue_date.equals("")) {
            theUS.setStatus("��س��к��ѹ����Ш���͹�Ҥ����ش����",UpdateStatus.WARNING);
            return 0;
        }
        if(pregnancy.pregnancy_menses_issue_date.startsWith("20")) {
            theUS.setStatus(Constant.getTextBundle("�ѹ����Ш���͹�Ҥ����ش����") + " " +
                    Constant.getTextBundle("�դ�����١��ͧ") +
                    " "+ pregnancy.pregnancy_menses_issue_date +" " +
                    Constant.getTextBundle("��سҵ�Ǩ�ͺ�к�"),UpdateStatus.WARNING);
            return 0;
        }
        if(pregnancy.pregnancy_menses_expire_date.equals("")) {
            theUS.setStatus("��س��к��ѹ��˹���ʹ",UpdateStatus.WARNING);
            return 0;
        }
        if(pregnancy.pregnancy_menses_expire_date.startsWith("20")) {
            theUS.setStatus(Constant.getTextBundle("�ѹ��˹���ʹ") + " " +
                    Constant.getTextBundle("�դ�����١��ͧ") +
                    " "+ pregnancy.pregnancy_menses_expire_date +" " +
                    Constant.getTextBundle("��سҵ�Ǩ�ͺ�к�"),UpdateStatus.WARNING);
            return 0;
        }
//        if(thePO.getVisit()!=null && !pregnancy.visit_id.equals("")){
////            if(!thePO.getVisit().visit_status.equals(VisitStatus.isInProcess())){
////                theUS.setStatus("�����Ź���繢ͧ����Ѻ��ԡ�÷�診��кǹ��������������ö�����",UpdateStatus.WARNING);
////                return 0;
////            }
//            if(!thePO.getVisit().getObjectId().equals(pregnancy.visit_id)
//            && !pregnancy.visit_id.equals("")){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//        }
//        if(thePO.getVisit()==null && !pregnancy.visit_id.equals("")){
//            theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//            return 0;
//        }
        theConnectionInf.open();
        try {
//            if(pregnancy.getObjectId()!=null){
//                Vector v = thePcuDB.theAncPcuDB.selectByPregnantID(pregnancy.getObjectId());
//                if(v!=null && !v.isEmpty()){
//                    theUS.setStatus(Constant.getTextBundle("�������š���麺�ԡ�ýҡ�����ͧ��õ�駤����������") +
//                            " " +
//                            Constant.getTextBundle("��س�¡��ԡ����Ѻ��ԡ�ýҡ������͹"),UpdateStatus.WARNING);
//                    return 0;
//                }
//            }
            if(pregnancy.getObjectId() == null){
                if(thePO.getVisit()!=null)
                    pregnancy.visit_id = thePO.getVisit().getObjectId();
                result = thePcuDB.thePregnancyDB.insertN(pregnancy);
            }
            else
                result = thePcuDB.thePregnancyDB.updateN(pregnancy);

            thePO.vPregnancy = thePcuDB.thePregnancyDB.selectByFamilyID(pregnancy.family_id);
            theUS.setStatus(GutilPCU.getTextBundle("SavePregnancyComplete"),UpdateStatus.COMPLETE);
            if(pregnancy != null)
                objectid = pregnancy.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_savePregnancy,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_savePregnancy,objectid,null,UpdateStatus.COMPLETE);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_savePregnancy,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_savePregnancy,objectid,ex,UpdateStatus.ERROR);
        }
        finally {
            theConnectionInf.close();
        }
        return result;
    }
    
    public int deletePregnancy(Pregnancy pregnancy) 
    {
        Constant.println(UseCase.UCID_deletePregnancy);
        String objectid =   null;
        int result = 0;
        if(pregnancy==null){
            theUS.setStatus("��س����͡��¡�÷���ͧ���¡��ԡ",UpdateStatus.WARNING);
            return 0;
        }
        //�ҡ��¡�÷�����͡�繢ͧ visit ���
//        if(!pregnancy.visit_id.equals("")){
//            //��ͧ��Ǩ�ͺ����������͡ visit ���������������
//            if(thePO.getVisit()==null || !thePO.getVisit().getObjectId().equals(pregnancy.visit_id)){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//            System.out.println("thePO.getVisit().visit_status" + thePO.getVisit().visit_status);
//            if(!thePO.getVisit().visit_status.equals(VisitStatus.isInProcess())){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�÷�診��кǹ��������������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//        }

        if(thePO.getVisit()!=null && !theHC.theVisitControl.updateVisitPregnant(false))
            return 0;
        if(!theUS.confirmBox("�س��ͧ���ź�����ŷ�����͡�������",UpdateStatus.WARNING))
            return 0;
        theConnectionInf.open();
        try {
            pregnancy.pregnancy_staff_cancel = thePO.getEmployee().getObjectId();//theSystemControl.pcuobject.getEmployee().getObjectId();
            pregnancy.cancel_date_time = thePO.getCurrentDateTime();
            pregnancy.active = "0";
            result = thePcuDB.thePregnancyDB.update(pregnancy);
            thePO.vPregnancy = thePcuDB.thePregnancyDB.selectByFamilyID(pregnancy.family_id);
            theUS.setStatus(GutilPCU.getTextBundle("���ź�����š�õ�駤�����������"),UpdateStatus.COMPLETE);
            if(pregnancy != null)
                objectid = pregnancy.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_deletePregnancy,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_deletePregnancy,objectid,null,UpdateStatus.COMPLETE);
        }
        catch(Exception ex) 
        {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_deletePregnancy,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_deletePregnancy,objectid,ex,UpdateStatus.ERROR);
        } 
        finally {
            theConnectionInf.close();
        }
        return result;
    }  
    /**
     *@deprecated henbe unused
     */
    public AncPcu saveAnc(AncPcu anc)
    {
        theConnectionInf.open();
        try{
            if(anc.getObjectId() == null)
            {
                 anc.staff_record = thePO.getEmployee().getObjectId();
                anc.record_date_time = thePO.getCurrentDateTime();
                anc.staff_modify = thePO.getEmployee().getObjectId();
                anc.modify_date_time = thePO.getCurrentDateTime();
                thePcuDB.theAncPcuDB.insert(anc);
            }
            else
            {
                anc.staff_modify = thePO.getEmployee().getObjectId();
                anc.modify_date_time = thePO.getCurrentDateTime();
                thePcuDB.theAncPcuDB.update(anc);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            theConnectionInf.close();
        }
        return anc;
    }
    /**
     *�ѹ�֡��ýҡ�����
     *@modifier pu
     *@date 19/09/08
     *
     */
    public int saveAnc(AncPcu anc,AncDetailPcu ancdetail) 
    {
        if(this.theHC.theHO.theVisit==null)
        {
            this.theUS.setStatus("��سҹӼ������������кǹ���", UpdateStatus.WARNING);
            return 0;
        }
//        if(!this.theHC.theHO.theVisit.service_location.equals("2"))
//        {
//            this.theUS.setStatus("��س��кػ����� Visit ������ԡ�ù͡˹��º�ԡ��", UpdateStatus.WARNING);
//            return 0;
//        }
        Constant.println(UseCase.UCID_saveAnc);
        String objectid =   null;
        if(!anc.anc_hct_date.equals("")){
            if(DateUtil.isAfterDate(anc.anc_hct_date,thePO.getCurrentDateTime())){
                theUS.setStatus("�ѹ����Ǩ HCT ��ͧ������ѹ�͹Ҥ�",UpdateStatus.WARNING);
                return 0;
            }
        }
        if(anc.survey_date.equals("") && anc.getObjectId()==null && thePO.getVisit()==null){
            theUS.setStatus("��س��к��ѹ������Ǩ",UpdateStatus.WARNING);
            return 0;
        }
        theConnectionInf.open();
        int result = 0;
        try {
            ancdetail.family_id = thePO.getFamily().getObjectId();
            anc.family_id = thePO.getFamily().getObjectId();
            anc.staff_modify = thePO.getEmployee().getObjectId();
            anc.modify_date_time = thePO.getCurrentDateTime();
            
            if(anc.getObjectId() == null)  {
            //૵ Visit
                if(thePO.getVisit() != null) {
                    ancdetail.visit_id = thePO.getVisit().getObjectId();
                    anc.visit_id = thePO.getVisit().getObjectId();
                }       
                if(thePO.getPatient() != null) {
                    ancdetail.patient_id = thePO.getPatient().getObjectId();
                    anc.anc_hn = thePO.getPatient().hn ;
                    anc.patient_id = thePO.getPatient().getObjectId();
                }
                anc.staff_record = thePO.getEmployee().getObjectId();
                anc.record_date_time = thePO.getCurrentDateTime();
                result +=thePcuDB.theAncPcuDB.insert(anc);
            } 
            else {
                result +=thePcuDB.theAncPcuDB.update(anc);
            }
            ancdetail.anc_id = anc.getObjectId();
            ancdetail.staff_modify = thePO.getEmployee().getObjectId();
            ancdetail.modify_date_time = thePO.getCurrentDateTime();
            
            if(ancdetail.getObjectId() == null) {
                ancdetail.staff_record = thePO.getEmployee().getObjectId();
                ancdetail.record_date_time = thePO.getCurrentDateTime();
                result += thePcuDB.theAncDetailPcuDB.insert(ancdetail);
            } 
            else
                result += thePcuDB.theAncDetailPcuDB.update(ancdetail);
            
            theUS.setStatus("��úѹ�֡����Ѻ��ԡ�ýҡ������������",UpdateStatus.COMPLETE);
            if(anc != null)
                objectid = anc.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_saveAnc,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_saveAnc,objectid,null,UpdateStatus.COMPLETE);
            return result;
        } 
        catch(Exception ex) {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_saveAnc,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_saveAnc,objectid,ex,UpdateStatus.ERROR);
            return result;
        } 
        finally {
            theConnectionInf.close();
        }
    }
    public int deleteAnc(AncPcu anc,AncDetailPcu ancdetail) 
    {
        Constant.println(UseCase.UCID_deleteAnc);
        String objectid =   null;
        //�ҡ��¡�÷�����͡�繢ͧ visit ���
//        if(!anc.visit_id.equals("")){
//            //��ͧ��Ǩ�ͺ����������͡ visit ���������������
//            if(thePO.getVisit()==null || !thePO.getVisit().getObjectId().equals(anc.visit_id)){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�ä��駡�͹�������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//            System.out.println("thePO.getVisit().visit_status" + thePO.getVisit().visit_status);
//            if(!thePO.getVisit().visit_status.equals(VisitStatus.isInProcess())){
//                theUS.setStatus("�����Ź���繢����Ţͧ����Ѻ��ԡ�÷�診��кǹ��������������ö�����",UpdateStatus.WARNING);
//                return 0;
//            }
//        }
        if(!theUS.confirmBox(GutilPCU.getTextBundle("VerifyBeforeDelete"),UpdateStatus.WARNING)) {
            return 0;
        }
        theConnectionInf.open();
        int result = 0;
        try {
            anc.staff_cancel = thePO.getEmployee().getObjectId();//theSystemControl.thePO.getEmployee().getObjectId();
            anc.cancel_date_time = thePO.getCurrentDateTime();
            anc.active = "0";
            result +=thePcuDB.theAncPcuDB.update(anc);
            
            ancdetail.staff_cancel = thePO.getEmployee().getObjectId();//theSystemControl.thePO.getEmployee().getObjectId();
            ancdetail.cancel_date_time = thePO.getCurrentDateTime();
            ancdetail.active = "0";
            result += thePcuDB.theAncDetailPcuDB.update(ancdetail);
            theUS.setStatus("���¡��ԡ����Ѻ��ԡ�ýҡ������������",UpdateStatus.COMPLETE);
            if(anc != null)
                objectid = anc.getObjectId();
            theHC.theSystemControl.setStatus(UseCase.TH_deleteAnc,UpdateStatus.COMPLETE,null);
            theHC.theSystemControl.saveLog(UseCase.UCID_deleteAnc,objectid,null,UpdateStatus.COMPLETE);
            return result;
        } 
        catch(Exception ex) {
            ex.printStackTrace();
            theHC.theSystemControl.setStatus(UseCase.TH_deleteAnc,UpdateStatus.ERROR,ex);
            theHC.theSystemControl.saveLog(UseCase.UCID_deleteAnc,objectid,ex,UpdateStatus.ERROR);
            return result;
        } 
        finally {
            theConnectionInf.close();
        }
    }
    
    /**
     *@deprecated henbe unused
     */
    public int saveAncDetail(AncDetailPcu ancdetail) {
        int result = 0;
        theConnectionInf.open();
        try {
            ancdetail.staff_modify = thePO.getEmployee().getObjectId();
            ancdetail.modify_date_time = thePO.getCurrentDateTime();
            if(ancdetail.getObjectId() == null) {
                ancdetail.staff_record = thePO.getEmployee().getObjectId();
                ancdetail.record_date_time = thePO.getCurrentDateTime();
                
                result = thePcuDB.theAncDetailPcuDB.insert(ancdetail);
            } else {
                result = thePcuDB.theAncDetailPcuDB.update(ancdetail);
            }
            theUS.setStatus(GutilPCU.getTextBundle("SaveAncComplete"),UpdateStatus.COMPLETE);
        } catch(Exception ex) {
            theUS.setStatus(GutilPCU.getTextBundle("SaveNotComplete"),UpdateStatus.ERROR);
            ex.printStackTrace();
        } finally {
            theConnectionInf.close();
        }
        return result;
    }
    
    public Vector listPregnancyByPatientID(String patient_id) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.thePregnancyDB.selectByPatientID(patient_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
    
    public Vector listPregnancyByFamilyID() {
        return thePO.vPregnancy;
    }
    /**
     * @not deprecated henbe �ѹ�֧�ҵ͹���͡��Ъҡ��������ǹ�
     * ��������
     */
    public Vector listPregnancyByFamilyID(String family_id) {
        theConnectionInf.open();
        try {
            if(!family_id.equalsIgnoreCase("")) {
                thePO.vPregnancy = thePcuDB.thePregnancyDB.selectByFamilyID(family_id);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return thePO.vPregnancy;
    }
    public Pregnancy readPregnancyByFamilyIDAndGravida(String family_id,String gravida) {
        theConnectionInf.open();
        Pregnancy pregnancy = null;
        try {
            if(!family_id.equalsIgnoreCase("")) {
                pregnancy = thePcuDB.thePregnancyDB.readByFamilyIDAndGravida(family_id,gravida);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return pregnancy;
    }
    
    public Vector listAncByPregnantID(String pregnancy_id) {
        Vector v = null;
        if(pregnancy_id==null)
            return new Vector();
        theConnectionInf.open();
        try {
            v = thePcuDB.theAncPcuDB.selectByPregnantID(pregnancy_id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return v;
    }
    /**
     *@deprecated henbe unused
     */
    public Vector listAncDetailByPregnantID(String pregnancy_id) {
        theConnectionInf.open();
        try {
            return thePcuDB.theAncDetailPcuDB.selectByAncId(pregnancy_id);
        } 
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        finally{
            theConnectionInf.close();
        }
    }
        
    public AncDetailPcu readAncDetailByAncId(String anc_id) 
    {
        theConnectionInf.open();
        try {
            Vector ret = thePcuDB.theAncDetailPcuDB.selectByAncId(anc_id);
            if(ret.size()>0)
                return (AncDetailPcu)ret.get(0);
            return null;
        } 
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        finally{
            theConnectionInf.close();
        }
    }
    
    public void saveItemtoStock(DrugStock drugStock) {
        theConnectionInf.open();
        try {
            if(drugStock.getObjectId() == null) {
                thePcuDB.theDrugStockDB.insert(drugStock);
            } else {
                thePcuDB.theDrugStockDB.update(drugStock);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            theConnectionInf.close();
        }
    }
    public Vector listDrugStock(String pk) {
        Vector vc = new Vector();
        theConnectionInf.open();
        try {
            if(pk.equals("")) {
                vc = thePcuDB.theDrugStockDB.selectAll();
            } else {
                vc = thePcuDB.theDrugStockDB.selectByName(pk);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return vc;
    }
    
    public Vector listDrugStockHistory(String pk) {
        Vector vc = new Vector();
        theConnectionInf.open();
        try {
            vc = thePcuDB.theDrugHistoryDB.selectByPk(pk);
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return vc;
    }
    
    public void saveDrughistory(DrugHistory drughistory) {
        theConnectionInf.open();
        try {
            thePcuDB.theDrugHistoryDB.insert(drughistory);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            theConnectionInf.close();
        }
    }
    public Vector listVitalSign(String vid) {
        Vector result = new Vector();
        theConnectionInf.open();
        try {
            result = thePcuDB.theVitalSignDB.selectByVisitId(vid);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        theConnectionInf.close();
        return result;
    }
    
    public boolean saveEpiOutSite(EpiOutSite epioutsite) 
    {
        if(epioutsite.active.equals("1"))
        {
            Constant.println(UseCase.UCID_SaveEpiOutSite);
        }
        else
        {
            Constant.println(UseCase.UCID_deleteEpiOutSite);
        }
        String objectid =   null;
        if(epioutsite.epi_outsite_date.equals("")) {
            theUS.setStatus("��س��к��ѹ����Ѻ�Ѥ�չ",UpdateStatus.WARNING);
            return false;
        }
        if(theLookupControl.isDateFuture(epioutsite.epi_outsite_date)) {
            theUS.setStatus("��س��к��ѹ����Ѻ�Ѥ�չ���ѹ�͵յ",UpdateStatus.WARNING);
            return false;
        }
        theConnectionInf.open();
        try {
            epioutsite.staff_modify = thePO.getEmployee().getObjectId();
            epioutsite.modify_date = thePO.getCurrentDateTime();
            if(epioutsite.getObjectId() == null) {
                epioutsite.staff_record = thePO.getEmployee().getObjectId();
                epioutsite.record_date = thePO.getCurrentDateTime();
                thePcuDB.theEpiOutSiteDB.insert(epioutsite);
            } else {
                thePcuDB.theEpiOutSiteDB.update(epioutsite);
            }
            thePO.vEpiOutSite = thePcuDB.theEpiOutSiteDB.selectByFamilyID(epioutsite.family_id);
            if(epioutsite.active.equals("0"))
                theUS.setStatus(GutilPCU.getTextBundle("���ź�������������"), UpdateStatus.COMPLETE);//��úѹ�֡�������������
            else
                theUS.setStatus(GutilPCU.getTextBundle("SaveComplete"),UpdateStatus.COMPLETE);
            if(epioutsite != null)
                objectid = epioutsite.getObjectId();
            if(epioutsite.active.equals("1"))
            {
                theHC.theSystemControl.setStatus(UseCase.TH_SaveEpiOutSite,UpdateStatus.COMPLETE,null);
                theHC.theSystemControl.saveLog(UseCase.UCID_SaveEpiOutSite,objectid,null,UpdateStatus.COMPLETE);
            }
            else
            {
                theHC.theSystemControl.setStatus(UseCase.TH_deleteEpiOutSite,UpdateStatus.COMPLETE,null);
                theHC.theSystemControl.saveLog(UseCase.UCID_deleteEpiOutSite,objectid,null,UpdateStatus.COMPLETE);
            }
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            if(epioutsite != null)
                objectid = epioutsite.getObjectId();
            if(epioutsite.active.equals("1"))
            {
                theHC.theSystemControl.setStatus(UseCase.TH_SaveEpiOutSite,UpdateStatus.ERROR,ex);
                theHC.theSystemControl.saveLog(UseCase.UCID_SaveEpiOutSite,objectid,ex,UpdateStatus.ERROR);
            }
            else
            {
                theHC.theSystemControl.setStatus(UseCase.TH_deleteEpiOutSite,UpdateStatus.ERROR,ex);
                theHC.theSystemControl.saveLog(UseCase.UCID_deleteEpiOutSite,objectid,ex,UpdateStatus.ERROR);
            }
            return false;
        } finally {
            theConnectionInf.close();
        }
    }
    
    public Vector lisEpiOutSiteByPatientID(String search) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theEpiOutSiteDB.selectByPatientID(search);
        } catch(Exception ex) {
            ex.printStackTrace();
            theConnectionInf.rollback();
        } finally {
            theConnectionInf.close();
        }
        return v;
    }
    public Vector lisEpiOutSiteByFamilyID() {
        return thePO.vEpiOutSite;
    }
    /**
     * jao
     * ���ҡ���Ѻ�Ѥ�չ�ҡ������
     * Input FamilyID
     * Output Vector �ͧ EpiOutsite
     * @not deprecated henbe �ѹ�֧�ҵ͹���͡��Ъҡ��������ǹ�
     * ������� ����������
     */
    public Vector lisEpiOutSiteByFamilyID(String search) {
        Vector v = null;
        theConnectionInf.open();
        try {
            thePO.vEpiOutSite = thePcuDB.theEpiOutSiteDB.selectByFamilyID(search);
        } catch(Exception ex) {
            ex.printStackTrace();
            theConnectionInf.rollback();
        } finally {
            theConnectionInf.close();
        }
        return thePO.vEpiOutSite;
    }
    
     /*
      * amp
      * ���һ���ѵԡ���Ѻ�Ѥ�չ�ͧ������
      * Input : PatientID
      * Output: Vector �ͧ EpiInSite
      */
    public Vector lisEpiHistoryInSiteByPatientID(String search) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theEpiDetailDB.selectByPatientID(search);
        } catch(Exception ex) {
            ex.printStackTrace();
            theConnectionInf.rollback();
        } finally {
            theConnectionInf.close();
        }
        return v;
    }
    public Vector lisEpiHistoryInSiteByFamilyID() {
        return thePO.vEpiDetail;
    }
    /**
     * jao
     * ���һ���ѵԡ���Ѻ�Ѥ�չ�ͧ������
     * Input : FamilyID
     * Output: Vector �ͧ EpiInSite
     * @not deprecated henbe �ѹ�֧�ҵ͹���͡��Ъҡ��������ǹ� ������ refresh ���ǡѹ
     */
    public Vector lisEpiHistoryInSiteByFamilyID(String search) {
        Vector v = null;
        theConnectionInf.open();
        try {
            v = thePcuDB.theEpiDetailDB.selectByFamilyID(search);
        } catch(Exception ex) {
            ex.printStackTrace();
            theConnectionInf.rollback();
        } finally {
            theConnectionInf.close();
        }
        return v;
    }
    public Vector listNutritionByFamilyID() {
        return thePO.vNutrition;
    }
    /**
     * Jao
     * �鹻���ѵ�����ҡ��
     * Input : Family_id
     * Output : Vector
     * @deprecated henbe �ѹ�֧�ҵ͹���͡��Ъҡ��������ǹ�
     */
    public Vector listNutritionByFamilyID(String search) {
        vNutrition = new Vector();
        theConnectionInf.open();
        try {
            vNutrition = thePcuDB.theNutritionDB.selectByFamilyID(search);
        } catch(Exception ex) {
            ex.printStackTrace();
            theConnectionInf.rollback();
        } finally {
            theConnectionInf.close();
        }
        return vNutrition;
    }
}
