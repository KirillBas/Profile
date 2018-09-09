package ru.basharin.reposotory;

import java.util.List;

public interface GenericRepository<T, ID> {

    void save(T t);

    T getByID(ID id);

    void deleteByID(ID id);

    List<T> readAll();

    ID getByName(T t);

}
