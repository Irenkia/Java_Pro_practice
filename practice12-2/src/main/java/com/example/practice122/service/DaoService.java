package com.example.practice122.service;

import java.util.List;
import java.util.Optional;

public interface DaoService<K,E> {
    List<E> findAll();
    Optional<E> findById(K id);

    E save(E entity);

    void update(E entity);

    boolean delete(K id);
}
