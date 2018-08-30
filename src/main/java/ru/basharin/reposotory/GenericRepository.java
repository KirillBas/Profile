package ru.basharin.reposotory;

public interface GenericRepository<T, ID> {

    void save(T t);

    T getByID(ID id);

    void deleteByID(T t);

    void create(T t);

}
