/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataBaju;
import java.sql.*;
import java.util.*;
import DAOImplement.AksiItem;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.connector;
import model.DataItem;
/**
 *
 * @author ASUS
 */
public class ItemDAO implements AksiItem{
    Connection connection;
    
    final String select = "select * from item;";

    public ItemDAO(){
        connection = connector.connection();
    }
    
    @Override
    public List<DataItem> getAll() {
        List<DataItem> dit = null;
        try {
            dit = new ArrayList<DataItem>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            
            while(rs.next()){
                DataItem i = new DataItem();
                i.setId(rs.getInt("id"));
                i.setNama(rs.getString("nama"));
                i.setHarga(rs.getInt("harga"));
                i.setStock(rs.getInt("stock"));
                dit.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dit;
    }
    
    
}
