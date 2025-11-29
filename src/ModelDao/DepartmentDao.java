package ModelDao;

import ModelEntities.Department;

import java.util.List;

public interface DepartmentDao {
    // inserir no banco de dados o objeto
    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findALL();
}
