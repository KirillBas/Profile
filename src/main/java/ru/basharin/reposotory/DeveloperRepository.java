package ru.basharin.reposotory;

import ru.basharin.model.Developer;

import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Long> {

    @Override
    void save(Developer developer);

    @Override
    Developer getByID(Long aLong);

    @Override
    void deleteByID(Long aLong);

    @Override
    List<Developer> readAll();
}
