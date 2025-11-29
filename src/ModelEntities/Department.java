package ModelEntities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer id;

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    // para ser comparado com objetos e nao com ponteiro
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department(){

    }

}
