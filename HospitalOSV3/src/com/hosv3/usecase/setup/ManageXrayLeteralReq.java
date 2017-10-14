/* * ListAllXrayLeteralReq.java * * Created on 25 ����Ҥ� 2547, 13:14 �. */package com.hosv3.usecase.setup;import java.util.*;import com.hospital_os.object.*;/** * * @author  tong */public interface ManageXrayLeteralReq {        /** Creates a new instance of ListAllXrayLeteralReq */    public Vector listAllXrayLeteral();    /** Creates a new instance of ListAllXrayLeteralReq  */    public Vector listAllXrayPosition();        /** Creates a new instance of listXrayLeteralReq   */    public XRayLeteral listXrayLeteralByCode(String code);            /** Creates a new instance of listXrayLeteralReq    */    public Vector listXrayLeteralBySearch(String search, String active);        /** Creates a new instance of listXrayLeteralReq      */    public XRayPosition listXrayPositionByCode(String code);        /** Creates a new instance of listXrayLeteralReq     */    public Vector listXrayPositionBySearch(String search, String active);        /** Creates a new instance of saveXrayLeteral       */    public int saveXrayLeteral(XRayLeteral xrayleteral);        /** Creates a new instance of saveXrayLeteral        */    public int saveXrayPosition(XRayPosition xrayPosition);        /** Creates a new instance of saveXrayLeteral   */    public int editXrayLeteral(XRayLeteral xrayleteral);        /** Creates a new instance of saveXrayLeteral  */    public int editXrayPosition(XRayPosition xrayPosition);        /** Creates a new instance of deleteXrayLetralReq  */    public int deleteXrayPosition(XRayPosition xrayPosition);        /** Creates a new instance of deleteXrayLetralReq  */    public int deleteXrayLeteral(XRayLeteral xrayleteral);    }