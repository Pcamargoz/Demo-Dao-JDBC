package Application;

import ModelDao.DaoFactory;
import ModelDao.DepartmentDao;
import ModelDao.SellerDao;
import ModelEntities.Department;
import ModelEntities.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    static void main() {
         // aqui vamos trabalhar com o Department DAO
        System.out.println(" === Test 1: Seller findById ====");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Test 2: department findALL =====");
        List<Department> list = departmentDao.findALL();
        for(Department obj : list){
            System.out.println(obj);
        }

        // inserindo alguem no banco de Dados
        /*System.out.println("\n=== Test 3: Department Insert =====");
        Department newDepartment = new Department(null,"Ouvidoria");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id = " + newDepartment.getId());*/

        /*System.out.println("\n=== Test 4: Department Update =====");
        // vai achar alguem com o id que queremos
        dep = departmentDao.findById(1);
        dep.setName("Martha Waine");
        // e confirmando a alteração com o update
        departmentDao.update(dep);
        System.out.println("Update Completed");*/

        System.out.println("\n=== Test 5: Department Delete =====");
        System.out.println("Enter Id For Delete: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");
    }
}
