package ru.basharin.reposotory;

import java.io.FileNotFoundException;
import java.util.List;

public interface GenericRepository<T, ID> {

    void save(T t);

    T getByID(ID id);

    void deleteByID(ID id) throws FileNotFoundException;

    List<T> readAll();

    ID getByName(T t);

}
