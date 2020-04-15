package epam.task7.web.jdbc.repository;

import epam.task7.web.model.Model;

import java.util.List;

public interface CRUDRepository<E extends Model, Key>
{
    String createRecord(final E e);
    String updateRecord(final Key key, E updatedObject);
    String deleteRecord(final Key key);
    E readRecord(final Key key);
    List<E> readAllRecords();
}
