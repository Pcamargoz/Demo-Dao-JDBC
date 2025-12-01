package ModelDaoImpl;

import ModelDao.DepartmentDao;
import ModelEntities.Department;
import ModelEntities.Seller;
import db.DB;
import db.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO department "
                            + "(Name) "
                            +"VALUES "
                            +"(?) ",
                    // para gerar a chave aleatoria
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,obj.getName());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0 ){
                // ele esta pegando a chave que o proprio banco da , quando e inserido alguem
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    // e aqui ele pega o item gerado na primeira coluna que no caso sera o id
                    // ele esta pegando da coluna 1 que no caso seria o id do departamento
                    int id = rs.getInt(1);
                    // e adiciona a entidade id do department aqui
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else{
                throw new DbException("Erro inesperado , nenhumna linha afetada");
            }
        }catch (SQLException e){
            // passando a mensagem da exceção original
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE department "
                            +"SET Name = ? "
                            + "WHERE Id = ? ");

            st.setString(1,obj.getName());
            // vai pegar o id do objeto que estamos procurando
            st.setInt(2,obj.getId());
            st.executeUpdate();


        }
        catch (SQLException e){
            // passando a mensagem da exceção original
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            // Deletando com o comando do sql apenas
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");

            st.setInt(1,id);

            int rowsAffeceted = st.executeUpdate();
            if(rowsAffeceted == 0){
                throw new DbException("Este Usuario Não existe");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            // pula para proxima linha para armazenar tudo que precisa na entidade departamento
            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                return dep;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    // serve para criar o departamento para que a gente consiga ver
    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

    @Override
    public List<Department> findALL() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*, department.Name AS DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "ORDER BY seller.Name");
            // para executar a query, como se fosse clicar no raio
            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();

            while(rs.next()){
                Department dep = instantiateDepartment(rs);
                list.add(dep);

            }
            return list; // CORRETO

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
