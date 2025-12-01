package ModelDao;

import ModelDaoImpl.DepartmentDaoJDBC;
import ModelDaoImpl.SellerDaoJDBC;
import db.DB;

public class DaoFactory {
    // Macete para nao expor a implementação e sim apenas a interface
    // (Esconder o que esta sendo feito).
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());

    }
    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
