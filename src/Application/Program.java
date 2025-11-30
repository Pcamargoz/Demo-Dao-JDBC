package Application;

import ModelDao.DaoFactory;
import ModelDao.SellerDao;
import ModelEntities.Department;
import ModelEntities.Seller;

import java.util.Date;
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
        // inserindo alguem no banco de Dados
        System.out.println("\n=== Test 4: seller Insert =====");
        Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id = " + newSeller.getId());

        System.out.println("\n=== Test 5: Seller Update =====");
        // vai achar alguem com o id que queremos
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        // e confirmando a alteração com o update
        sellerDao.update(seller);
        System.out.println("Update Completed");

    }
}
