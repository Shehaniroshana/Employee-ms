package icet.edu.com.service;

import icet.edu.com.dto.EmployeeDto;
import icet.edu.com.util.Department;

import java.util.List;

public interface EmployeeService {
    public Boolean saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    Boolean deleteEmployee(Long id);
    List<EmployeeDto> getAllEmployees();
    Boolean updateEmployee(Long id, EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeesByDepartment(Department department);
    List<EmployeeDto> getEmployeesByName(String name);
    List<EmployeeDto> getEmployeesBySalaryRange(Double minSalary, Double maxSalary);
    List<EmployeeDto> getEmployeesByPhoneNumber(String phoneNumber);
}
