//Source file: F:\\HospitalOSUsecase\\com\\hospitalos\\usecase\\saveDxTemplateReq.javapackage com.hosv3.usecase.setup;import com.hospital_os.object.*;import java.util.*;/**UC-Ad043 �ѹ�֡��¡�� DX ��辺���� */public interface ManageDxTemplateReq {      /**   @roseuid 3F803022008F    */   public int saveDxTemplate(DxTemplate dxtemplate);   /** Creates a new instance of createPatientAllergy        */   public boolean checkDxTemplate(String dx);      /** @roseuid 3F802FE701CA    *    *    *    *    */   public int deleteDxTemplate(DxTemplate dxtemplate);      /**    @roseuid 3F802D950311    *    *    *    *    */   public int editDxTemplate(DxTemplate dxtemplate);      /**    *    *    @roseuid 3F8030600020    *    *    *    *    */   public Vector listDxTemplateByName(String pk);      /**    *    @roseuid 3F8030600020    *    *    *    *    */   //henbe_not_used public void notifylistDxTemplateAll(DxTemplate dx);      /**    *    *    *    @roseuid 3F8030600020    *    *    *    *    */   //henbe_not_used  public void notifylistDxTemplateByName(DxTemplate dx);      /**    *    *    *    *    @roseuid 3F8030600020    *    *    *    *    */   public DxTemplate selectDxTemplateByPk(String pk);   }