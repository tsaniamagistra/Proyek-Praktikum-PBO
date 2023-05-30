/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdataBaju.OrderanDAO;
import model.*;
import view.ViewOrderan;
import DAOImplement.AksiOrderan;
import java.sql.SQLException;
/**
 *
 * @author ASUS
 */
public class ControllerOrderan {
    ViewOrderan frame;
    AksiOrderan impldata;
    List<DataOrderan> dor;
        
    public ControllerOrderan(ViewOrderan frame){
        this.frame = frame;
        impldata = new OrderanDAO();
        dor = impldata.getAll();
    }
    
    public void isitabel(){
        dor = impldata.getAll();
        ModelTabelOrderan mor = new ModelTabelOrderan(dor);
        frame.getTabelOrderan().setModel(mor);
    }
    
    public void insert() throws SQLException, CustomException{
        if(frame.getBanyakTf().getText().trim().isEmpty()){
            throw new CustomException("Input Banyak tidak boleh kosong!");
        }
        else if(frame.getPemesanTa().getText().trim().isEmpty()){
            throw new CustomException("Input Info Pemesan tidak boleh kosong!");
        }
        else{
            DataOrderan dor = new DataOrderan();
            dor.setIdItem(frame.getjComboBoxItem().getSelectedIndex() + 1);
            dor.setBanyak(Integer.parseInt(frame.getBanyakTf().getText()));
            dor.setTotalHarga(frame.getjComboBoxItem().getSelectedIndex() + 1, Integer.parseInt(frame.getBanyakTf().getText()));
            dor.setPemesan(frame.getPemesanTa().getText());
            impldata.insert(dor);
        }       
    }
    
    public void update() throws SQLException, CustomException{
        if(frame.getIdLabel().getText().trim().isEmpty()){
            throw new CustomException("Tidak ada orderan dipilih!");
        }
        else if(frame.getPemesanTa().getText().trim().isEmpty()){
            throw new CustomException("Input Info Pemesan tidak boleh kosong!");
        }
        else{
            DataOrderan dor = new DataOrderan();
            dor.setIdItem(frame.getjComboBoxItem().getSelectedIndex() + 1);
            dor.setBanyak(Integer.parseInt(frame.getBanyakTf().getText()));
            dor.setTotalHarga(frame.getjComboBoxItem().getSelectedIndex() + 1, Integer.parseInt(frame.getBanyakTf().getText()));
            dor.setPemesan(frame.getPemesanTa().getText());
            dor.setId(Integer.parseInt(frame.getIdLabel().getText()));
            impldata.update(dor);
        }       
    }
    
    public void delete() throws CustomException{
        if(frame.getIdLabel().getText().trim().isEmpty()){
            throw new CustomException("Tidak ada orderan dipilih!");
        }
        else{
            int id = Integer.parseInt(frame.getIdLabel().getText());
            int banyak = Integer.parseInt(frame.getBanyakTf().getText());
            int idItem = frame.getjComboBoxItem().getSelectedIndex() + 1;  
            impldata.delete(id, banyak, idItem);
        }
    }
}
