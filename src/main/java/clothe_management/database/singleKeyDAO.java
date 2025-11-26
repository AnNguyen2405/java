package clothe_management.database;

public interface singleKeyDAO<T> {
    // Single key methods
    T findByID(String id);
    int delete(String id);
}
