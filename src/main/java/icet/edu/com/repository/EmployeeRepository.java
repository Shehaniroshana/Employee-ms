package icet.edu.com.repository;

import icet.edu.com.entity.EmployeeEntity;
import icet.edu.com.util.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
    EmployeeEntity findByEmail(String email);
    List<EmployeeEntity> findByDepartment(Department department);
    List<EmployeeEntity> findByNameContaining(String name);
    List<EmployeeEntity> findBySalaryBetween(Double minSalary, Double maxSalary);
    List<EmployeeEntity> findByPhoneNumber(String phoneNumber);
}
