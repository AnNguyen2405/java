package clothe_management.database;

import java.util.List;

public interface genericDAO<T> {
    List<T> getAll();
    int insert(T entity);
    int  update(T entity);
}
