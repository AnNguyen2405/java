package clothe_management.database;

import java.util.List;

public interface genericDAO<T> {
    T findByID(String id);
    List<T> getAll();
    int insert(T entity);
    int  update(T entity);
    int delete(String id);
}
