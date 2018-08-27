package ru.basharin.reposotory;

public interface GenericRepository<T, ID> {

    public void save(T t);

    public T getByID(ID id);

    public void deleteByID(ID id);

    public void create(T t);

}
