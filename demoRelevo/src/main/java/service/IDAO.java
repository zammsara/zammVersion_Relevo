package service;

import java.util.List;

public interface IDAO<T> {

    List<T> findAll(String nameQuery);

    void insertar(T entity);

    void actualizar(T entity);

    void eliminarById(int id);

    T buscarById(int id);
}
