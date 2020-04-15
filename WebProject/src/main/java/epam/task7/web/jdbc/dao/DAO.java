package epam.task7.web.jdbc.dao;

import epam.task7.web.model.Model;

public interface DAO<E extends Model, Key>
{
    void createRecord(final E e);
    void updateRecord(final Key key);
    void deleteRecord(final Key key);
    E readRecord(final Key key);
}
