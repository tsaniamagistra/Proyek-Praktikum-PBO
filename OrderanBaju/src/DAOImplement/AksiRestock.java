/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;

import java.util.List;
import model.*;

/**
 *
 * @author ASUS
 */
public interface AksiRestock {
    
    public void insert(DataRestock r);
    public void delete(int id, int jumlah, int idItem);
    public List<DataRestock> getAll();
    
}
