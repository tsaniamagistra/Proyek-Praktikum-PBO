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
public class ModelTabelItem extends AbstractTableModel{

    List<DataItem> dit;
    public ModelTabelItem(List<DataItem>dit){
        this.dit = dit;
    }
    
    @Override
    public int getRowCount() {
        return dit.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Item";
            case 1:
                return "Nama";
            case 2:
                return "Harga";
            case 3:
                return "Stock";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dit.get(row).getId();
            case 1:
                return dit.get(row).getNama();
            case 2:
                return dit.get(row).getHarga();
            case 3:
                return dit.get(row).getStock();
            default:
                return null;
        }
    }
    
}
