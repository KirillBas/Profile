package ru.basharin.reposotory;

public interface AccRepository extends GenericRepository {

    @Override
    default void save(Object o) {

    }

    @Override
    default Object getByID(Object o) {
        return null;
    }

    @Override
    default void deleteByID(Object o) {

    }

    @Override
    default void create(Object o) {

    }
}
