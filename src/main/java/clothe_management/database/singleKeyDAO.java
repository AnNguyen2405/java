package clothe_management.database;

public interface singleKeyDAO<T> {
    T findByID(String id);
}
