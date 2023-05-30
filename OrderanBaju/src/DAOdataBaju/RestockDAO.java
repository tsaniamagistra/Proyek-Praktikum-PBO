/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataBaju;
import DAOImplement.AksiRestock;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.connector;
import model.DataRestock;
/**
 *
 * @author ASUS
 */
public class RestockDAO implements AksiRestock{
    Connection connection;
    
    final String select = "select * from restock;";
    final String insert = "INSERT INTO restock (tanggal, id_item, banyak) VALUES (?, ?, ?);";
    final String delete = "delete from restock where id=?";
    final String selectStock = "select stock from item where id=?";
    final String updateStock = "update item set stock=? where id=?";
    
    public RestockDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(DataRestock r) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            Date tgl = new java.sql.Date(r.getTgl().getDate().getTime());
            statement.setDate(1, tgl);
            statement.setInt(2, r.getIdItem());
            statement.setInt(3, r.getJumlah());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            r.setId(rs.getInt(1));
            
            PreparedStatement statement2 = null;
            statement2 = connection.prepareStatement(selectStock, Statement.RETURN_GENERATED_KEYS);;
            statement2.setInt(1, r.getIdItem());
            ResultSet rs2 = statement2.executeQuery();;
            rs2.next();
                                    
            PreparedStatement statement3 = null;
                statement3 = connection.prepareStatement(updateStock, Statement.RETURN_GENERATED_KEYS);
                statement3.setInt(1, (rs2.getInt(1) + r.getJumlah()));
                statement3.setInt(2, r.getIdItem());
                statement3.executeUpdate();
                
            statement3.close();
            rs2.close();
            statement2.close();
            rs.close();
            statement.close();            
        } catch (SQLException ex) {
            Logger.getLogger(RestockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(int id, int jumlah, int idItem) {
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
            statement3.setInt(1, rs2.getInt(1) - jumlah);
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
    public List<DataRestock> getAll() {
        List<DataRestock> dr = null;
        try{
            dr = new ArrayList<DataRestock>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
                                    
            while(rs.next()){
                DataRestock r = new DataRestock();
                r.setId(rs.getInt("id"));
                JDateChooser tgl = new JDateChooser();
                tgl.setDate(rs.getDate("tanggal"));
                r.setTgl(tgl);
                r.setNamaItem(rs.getInt("id_item"));
                r.setJumlah(rs.getInt("banyak"));
                dr.add(r);
            }
        }catch(SQLException ex){
            Logger.getLogger(OrderanDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dr;
    }
    
}
