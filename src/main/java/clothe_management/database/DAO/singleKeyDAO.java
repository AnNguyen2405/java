package clothe_management.database.DAO;

public interface singleKeyDAO<T> {
    // Single key methods
    T findByID(String id);
    int delete(String id);
}
