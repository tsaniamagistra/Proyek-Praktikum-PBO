/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class ModelTabelRestock extends AbstractTableModel{
    
    List<DataRestock> dr;
    public ModelTabelRestock(List<DataRestock>dr){
        this.dr = dr;
    }
    
    @Override
    public int getRowCount() {
       return dr.size();
    }

    @Override
    public int getColumnCount() {
      return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Riwayat";
            case 1:
                return "Tanggal";
            case 2:
                return "Nama Item";
            case 3:
                return "Jumlah";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dr.get(row).getId();
            case 1:
                Date tgl = new java.sql.Date(dr.get(row).getTgl().getDate().getTime());
                return tgl;
            case 2:
                return dr.get(row).getNamaItem();
            case 3:
                return dr.get(row).getJumlah();
            default:
                return null;
        }
    }
    
}
