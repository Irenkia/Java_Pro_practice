package com.example.practice122.dao;

import java.util.List;
import java.util.Optional;
import java.io.Serializable;
import java.util.Collection;
public interface Dao<K, E> {
    List<E> findAll();
    Optional<E> findById(K id);

    E save(E entity);

    void update(E entity);

    boolean delete(K id);

}
