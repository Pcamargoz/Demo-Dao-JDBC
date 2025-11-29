package ModelDao;

import ModelDaoImpl.SellerDaoJDBC;

public class DaoFactory {
    // Macete para nao expor a implementação e sim apenas a interface
    // (Esconder o que esta sendo feito).
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();

    }
}
