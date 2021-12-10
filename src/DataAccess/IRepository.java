package DataAccess;

import java.util.ArrayList;

public interface IRepository<T> {
    int Create(T entity);

    T Read(int id);

    ArrayList<T> ReadAll();

    void Update(T entity);

    void Delete(T entity);
}
