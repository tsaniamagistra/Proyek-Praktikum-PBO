/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class ModelTabelOrderan extends AbstractTableModel{
    
    List<DataOrderan> dor;
    public ModelTabelOrderan(List<DataOrderan>dor){
        this.dor = dor;
    }
    
    @Override
    public int getRowCount() {
        return dor.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Orderan";
            case 1:
                return "Nama Item ";
            case 2:
                return "Banyak";
            case 3:
                return "Total Harga";
            case 4:
                return "Info Pemesan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dor.get(row).getId();
            case 1:
                return dor.get(row).getNamaItem();
            case 2:
                return dor.get(row).getBanyak();
            case 3:
                return dor.get(row).getTotalHarga();
            case 4:
                return dor.get(row).getPemesan();
            default:
                return null;
        }
    }
    
}
