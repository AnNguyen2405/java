package clothe_management.database;

import java.util.ArrayList;

public interface compositeKeyDAO<T> {
    ArrayList<T> findByLeftID(String id);
    ArrayList<T> findByProductID(String productId);
    T findByKey(String id, String productId);
    int deleteByLeftID(String id);
    int deleteByKey(String id, String productId);
}
