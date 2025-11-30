package Application;

import ModelDao.DaoFactory;
import ModelDao.SellerDao;
import ModelEntities.Department;
import ModelEntities.Seller;

import java.util.List;

public class Program {
    static void main() {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println(" === Test 1: Seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: seller findByDepartment =====");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findbyDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }
        System.out.println("\n=== Test 3: seller findALL =====");
        list = sellerDao.findALL();
        for(Seller obj : list){
            System.out.println(obj);
        }
    }
}
