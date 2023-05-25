package github.oineh.common;

public interface Repository<K,T> {
    void create(T t);
    boolean update(K k,T t);
    boolean delete(K k);
    T select(K k);
}
