package ru.basharin.reposotory;

import ru.basharin.model.Developer;

import java.util.List;


public interface DeveloperRepository extends GenericRepository<Developer, Long> {
    @Override
    void save(Developer developer);

    @Override
    Developer getByID(Long developerId);

    @Override
    void deleteByID(Long developerId);

    @Override
    List<Developer> readAll();

    @Override
    Long getByName(Developer developer);
}
