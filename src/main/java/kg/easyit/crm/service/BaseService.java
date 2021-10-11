package kg.easyit.crm.service;

import java.util.List;

public interface BaseService<T> {
    T getOne(Long index);
    List<T> getAll();
    void save(T t);
}
