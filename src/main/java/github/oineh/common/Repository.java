package github.oineh.common;

import java.util.Optional;

public interface Repository<K,T> {
    Optional<T> create(T t);
    Optional<T> update(K k,T t);
    void delete(K k);
    Optional<T> select(K k);
}
