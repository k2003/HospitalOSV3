/* * DrugStickerDetailDB.java * * Created on 19 a??? 2547, 21:18 ?. */package com.hospital_os.objdb.setup;/** ** @author  tong *@deprecated henbe unused use  */public class DrugStickerDetailDB {    //    /** Creates a new instance of DrugStickerDetailDB *///    com.hospital_os.usecase.connection.ConnectionInf theConnectionInf;//    public DrugStickerDetailDB(com.hospital_os.usecase.connection.ConnectionInf con) {//        this.theConnectionInf = con;//    }//////    public Vector queryData() throws Exception//    {   Vector vc = new Vector();//        String SQLCmd = "Select * from t_print_drug_sticker";//        vc = selectDB(SQLCmd);//        if(vc !=null)//            return vc;//        else//            return null;////    }////    /**// *// * @author  tong// *@deprecated henbe unused use// *///    private java.util.Vector selectDB(String sql) throws Exception//    {   java.util.Vector vc = new java.util.Vector();//        java.sql.ResultSet rs = theConnectionInf.eQuery(sql);//        DrugStickerDetail drugStickerDetail =null;////        while(rs.next())//        {   drugStickerDetail = new DrugStickerDetail();//            drugStickerDetail.description = rs.getString(1);//            drugStickerDetail.pointx =   rs.getString(2);//            drugStickerDetail.pointy =   rs.getString(3);//            drugStickerDetail.show =   rs.getString(3);//            vc.add(drugStickerDetail);////        }//        rs = null;//        return vc;//    }                    /**     * @param args the command line arguments     */    public static void main(String[] args) {    }    }