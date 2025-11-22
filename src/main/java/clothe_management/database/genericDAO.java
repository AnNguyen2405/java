package clothe_management.database;
import java.util.List;

public abstract class genericDAO<T> {
    dbConnection connection = new dbConnection();
    abstract T findByID(String id);
    abstract List<T> getAll();
    abstract void save(T entity);      // Insert or Update
    abstract void delete(String id);
}