package guru.springframework.repositories;

import guru.springframework.domain.Employee;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String> {
    @Query("{'name': ?0}")
    List<Optional<Employee>> findByName(String name);
}
