package clothe_management.database.DAO;

import java.util.ArrayList;

public interface genericDAO<T> {
    ArrayList<T> getAll();
    int insert(T entity);
    int  update(T entity);
}
