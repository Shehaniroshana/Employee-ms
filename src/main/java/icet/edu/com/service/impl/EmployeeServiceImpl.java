package icet.edu.com.service.impl;

import icet.edu.com.dto.EmployeeDto;
import icet.edu.com.entity.EmployeeEntity;
import icet.edu.com.repository.EmployeeRepository;
import icet.edu.com.service.EmployeeService;
import icet.edu.com.util.EmailCheck;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper mapper;
    private final EmailCheck check;

    @Override
    public Boolean saveEmployee(EmployeeDto employeeDto) {
         if(repository.findByEmail(employeeDto.getEmail()) != null && check.isValid(employeeDto.getEmail())) return false;
         repository.save(mapper.map(employeeDto, EmployeeEntity.class));
         return true;
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        if(id == null) return null;
        Optional<EmployeeEntity> byId = repository.findById(id);
        if (byId.isPresent()) {
            return mapper.map(byId.get(), EmployeeDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        return false;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return List.of();
    }

    @Override
    public Boolean updateEmployee(Long id, EmployeeDto employeeDto) {
        return false;
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartment(String department) {
        return List.of();
    }

    @Override
    public List<EmployeeDto> getEmployeesByName(String name) {
        return List.of();
    }

    @Override
    public List<EmployeeDto> getEmployeesBySalaryRange(Double minSalary, Double maxSalary) {
        return List.of();
    }

    @Override
    public List<EmployeeDto> getEmployeesByPhoneNumber(String phoneNumber) {
        return List.of();
    }
}
