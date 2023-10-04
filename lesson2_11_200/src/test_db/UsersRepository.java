package test_db;

import java.util.List;

public interface UsersRepository <T> {
    List<T> findAllByAge(Integer age);
    List<T> findAllByName(String name);
    List<T> findAll(int id);
}
