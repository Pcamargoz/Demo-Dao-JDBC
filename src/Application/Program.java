package Application;

import ModelDao.DaoFactory;
import ModelDao.SellerDao;
import ModelEntities.Department;
import ModelEntities.Seller;

import java.util.Date;

public class Program {
    static void main() {
        // puxando o factory que esconde o que esta sendo implementado
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
