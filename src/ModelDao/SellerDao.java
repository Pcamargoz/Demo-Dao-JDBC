package ModelDao;

import ModelEntities.Department;
import ModelEntities.Seller;

import java.util.List;

public interface SellerDao {
    // inserir no banco de dados o objeto
    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findALL();
}
