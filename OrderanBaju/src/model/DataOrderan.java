/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import koneksi.connector;


/**
 *
 * @author ASUS
 */
public class DataOrderan {
    Connection connection;
    private int id;
    private int idItem;
    private String namaItem;
    private int hargaItem;
    private int banyak;
    private int totalHarga;
    private String pemesan;
    PreparedStatement stmt = null;
    ResultSet rs;
    
    String selectHargaItem = "SELECT harga from item WHERE id=?";
    String selectNamaItem = "SELECT nama from item WHERE id=?";
    
    public DataOrderan(){
        connection = connector.connection();
    }
                
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getHargaItem() {
        return hargaItem;
    }

    public void setHargaItem(int hargaItem) throws SQLException {
        stmt = connection.prepareStatement(selectHargaItem, Statement.RETURN_GENERATED_KEYS);;
        stmt.setInt(1, idItem);
        rs = stmt.executeQuery();
        rs.next();
        this.hargaItem = rs.getInt(1);
        rs.close();
        stmt.close();
    }
    
    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public int getTotalHarga() {
        return totalHarga;
    }
    
    //overloading utk setTotalHarga
    public void setTotalHarga(int idItem, int banyak) throws SQLException {
        stmt = connection.prepareStatement(selectHargaItem, Statement.RETURN_GENERATED_KEYS);;
        stmt.setInt(1, idItem);
        rs = stmt.executeQuery();
        rs.next();
        this.hargaItem = rs.getInt(1);
        rs.close();
        stmt.close();
        this.totalHarga = this.hargaItem*banyak;
    }
    
    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getPemesan() {
        return pemesan;
    }

    public void setPemesan(String pemesan) {
        this.pemesan = pemesan;
    }
    
}
