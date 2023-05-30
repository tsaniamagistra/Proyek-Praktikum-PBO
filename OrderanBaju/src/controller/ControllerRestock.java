/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import view.ViewRiwayatRestock;
import DAOImplement.AksiRestock;
import DAOdataBaju.RestockDAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class ControllerRestock {
    ViewRiwayatRestock frame;
    AksiRestock impldata;
    List<DataRestock> dr;
    
    public ControllerRestock(ViewRiwayatRestock frame){
        this.frame = frame;
        impldata = new RestockDAO();
        dr = impldata.getAll();
    }
    
    public void isitabel(){
        dr = impldata.getAll();
        ModelTabelRestock mr = new ModelTabelRestock(dr);
        frame.getTabelRiwayat().setModel(mr);
    }
    
    public void insert() throws SQLException, CustomException{
        if(frame.getJumlahTf().getText().trim().isEmpty()){
            throw new CustomException("Input Jumlah tidak boleh kosong!");
        }
        else{
            DataRestock dr = new DataRestock();
            dr.setTgl(frame.getPilihTanggal());
            dr.setIdItem(frame.getjComboBoxItem().getSelectedIndex() + 1);
            dr.setJumlah(Integer.parseInt(frame.getJumlahTf().getText()));
            impldata.insert(dr); 
        }       
    }
    
    public void delete() throws CustomException{
        if(frame.getIdRiwayat().getText().trim().isEmpty()){
             throw new CustomException("Tidak ada riwayat restock dipilih!");
        }
        else{
            int id = Integer.parseInt(frame.getIdRiwayat().getText());
            int banyak = Integer.parseInt(frame.getJumlahTf().getText());
            int idItem = frame.getjComboBoxItem().getSelectedIndex() + 1;
            impldata.delete(id, banyak, idItem);
        }
    }
}
