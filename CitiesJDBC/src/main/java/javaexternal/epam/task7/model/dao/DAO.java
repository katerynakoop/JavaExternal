package javaexternal.epam.task7.model.dao;

import javaexternal.epam.task7.model.entity.Entity;

import java.util.List;

public interface DAO<E extends Entity, Key>
{
    void createRecord(final E e);
    void updateRecord(final Key key);
    void deleteRecord(final Key key);
    E readRecord(final Key key);
}
