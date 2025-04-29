package icet.edu.com.dto;

import icet.edu.com.util.Department;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Department department;
    private String phoneNumber;
    private Double salary;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;
}
