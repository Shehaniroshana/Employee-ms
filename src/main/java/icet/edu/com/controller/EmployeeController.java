package icet.edu.com.controller;

import icet.edu.com.dto.EmployeeDto;
import icet.edu.com.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<Boolean> saveEmployee(@RequestBody EmployeeDto dto){
         return ResponseEntity.ok(service.saveEmployee(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(service.getEmployee(id));
    }

}
