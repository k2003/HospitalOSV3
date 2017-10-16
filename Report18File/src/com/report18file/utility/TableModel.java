/*
 * TableModel.java
 *
 * Created on 29 �á�Ҥ� 2548, 10:44 �.
 *
 */

package com.report18file.utility;
import javax.swing.table.*;
/**
 *
 * @author Noom
 */
public class TableModel extends DefaultTableModel{
    
    /** Creates a new instance of HTableModel */
    int table =0;
    int coledit =9;
    int coledit1 =9;
    int coledit2 =9;
    public TableModel() {
    }
    public TableModel(String[] col, int row) {
        super(col,row);
        
    }
    
    public boolean isCellEditable(int row,int col){
        // System.out.println("GColumCount : " + super.getColumnCount());
        if(super.getColumnCount()>coledit && col==coledit)
            return true;
        if(super.getColumnCount()>coledit1 && col==coledit1)
            return true;
        if(super.getColumnCount()>coledit2 && col==coledit2)
            return true;
        return false;
    }
    
    public void setEditingCol(int col) {
        coledit = col;
    }
    public void setEditingCol(int col,int col1) {
        coledit = col;
        coledit1 = col1;
    }
    public void setEditingCol(int col,int col1,int col2) {
        coledit = col;
        coledit1 = col1;
        coledit2 = col2;
    }
    
    
}

  
