/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOImplement.AksiItem;
import DAOdataBaju.ItemDAO;
import java.util.List;
import model.*;
import view.ViewItem;

/**
 *
 * @author ASUS
 */
public class ControllerItem {
    ViewItem frame;
    AksiItem impldata;
    List<DataItem> dit;
    
    public ControllerItem(ViewItem frame){
        this.frame = frame;
        impldata = new ItemDAO();
        dit = impldata.getAll();
    }
    
    public void isitabel(){
        dit = impldata.getAll();
        ModelTabelItem mit = new ModelTabelItem(dit);
        frame.getTabelItem().setModel(mit);
    }
}
