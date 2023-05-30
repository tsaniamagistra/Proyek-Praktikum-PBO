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
public class DataItem {
    Connection connection;
    private int id;
    private String nama;
    private int stock;
    private int harga;
    PreparedStatement stmt = null;
    ResultSet rs;
    
    public DataItem(){
        connection = connector.connection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
}
