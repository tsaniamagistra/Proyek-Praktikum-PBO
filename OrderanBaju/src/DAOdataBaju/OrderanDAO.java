/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataBaju;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplement.AksiOrderan;
/**
 *
 * @author ASUS
 */
public class OrderanDAO implements AksiOrderan{
    Connection connection;
    
    final String select = "select * from orderan;";
    final String insert = "INSERT INTO orderan (id_item, banyak, total_harga, info_pemesan) VALUES (?, ?, ?, ?);";
    final String update = "update orderan set id_item=?, banyak=?, total_harga=?, info_pemesan=? where id=?";
    final String delete = "delete from orderan where id=?";
    final String selectStock = "select stock from item where id=?";
    final String updateStock = "update item set stock=? where id=?";
        
    public OrderanDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(DataOrderan o) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, o.getIdItem());
            statement.setInt(2, o.getBanyak());
            statement.setInt(3, o.getTotalHarga());
            statement.setString(4, o.getPemesan());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            o.setId(rs.getInt(1));
                        
            PreparedStatement statement2 = null;
            statement2 = connection.prepareStatement(selectStock, Statement.RETURN_GENERATED_KEYS);;
            statement2.setInt(1, o.getIdItem());
            ResultSet rs2 = statement2.executeQuery();;
            rs2.next();
                                    
            PreparedStatement statement3 = null;
                statement3 = connection.prepareStatement(updateStock, Statement.RETURN_GENERATED_KEYS);
                statement3.setInt(1, (rs2.getInt(1) - o.getBanyak()));
                statement3.setInt(2, o.getIdItem());
                statement3.executeUpdate();
                
            statement3.close();
            rs2.close();
            statement2.close();
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DataOrderan o) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, o.getIdItem());
            statement.setInt(2, o.getBanyak());
            statement.setInt(3, o.getTotalHarga());
            statement.setString(4, o.getPemesan());
            statement.setInt(5, o.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id, int banyak, int idItem) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
            
            PreparedStatement statement2 = null;
            statement2 = connection.prepareStatement(selectStock, Statement.RETURN_GENERATED_KEYS);;
            statement2.setInt(1, idItem);
            ResultSet rs2 = statement2.executeQuery();;
            rs2.next();
            
            PreparedStatement statement3 = null;
            statement3 = connection.prepareStatement(updateStock, Statement.RETURN_GENERATED_KEYS);
            statement3.setInt(1, rs2.getInt(1) + banyak);
            statement3.setInt(2, idItem);
            statement3.executeUpdate();
            
            statement3.close();
            rs2.close();
            statement2.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<DataOrderan> getAll() {
        List<DataOrderan> dor = null;
        try{
            dor = new ArrayList<DataOrderan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
                                    
            while(rs.next()){
                DataOrderan o = new DataOrderan();
                o.setId(rs.getInt("id"));
                o.setNamaItem(rs.getInt("id_item"));
                o.setBanyak(rs.getInt("banyak"));
                o.setTotalHarga(rs.getInt("total_harga"));
                o.setPemesan(rs.getString("info_pemesan"));
                dor.add(o);
            }
        }catch(SQLException ex){
            Logger.getLogger(OrderanDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dor;
    }
}
