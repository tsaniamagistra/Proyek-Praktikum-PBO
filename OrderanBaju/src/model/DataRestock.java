/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.toedter.calendar.JDateChooser;
import java.sql.*;
import koneksi.connector;


/**
 *
 * @author ASUS
 */
public class DataRestock {
    Connection connection;
    private int id;
    private JDateChooser tgl;
    private int idItem;
    private String namaItem;
    private int jumlah;
    PreparedStatement stmt = null;
    ResultSet rs;
    
    String selectHargaItem = "SELECT harga from item WHERE id=?";
    String selectNamaItem = "SELECT nama from item WHERE id=?";
    
    public DataRestock(){
        connection = connector.connection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JDateChooser getTgl() {
        return tgl;
    }

    public void setTgl(JDateChooser tgl) {
        this.tgl = tgl;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(int idItem) throws SQLException {
        stmt = connection.prepareStatement(selectNamaItem, Statement.RETURN_GENERATED_KEYS);;
        stmt.setInt(1, idItem);
        rs = stmt.executeQuery();
        rs.next();
        this.namaItem = rs.getString(1);
        rs.close();
        stmt.close();
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
