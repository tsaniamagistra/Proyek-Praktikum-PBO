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
public interface AksiOrderan {
    
    public void insert(DataOrderan o);
    public void update(DataOrderan o);
    public void delete(int id, int banyak, int idItem);
    public List<DataOrderan> getAll();
    
}
