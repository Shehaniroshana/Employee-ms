package icet.edu.com.controller;

import icet.edu.com.dto.EmployeeDto;
import icet.edu.com.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteEmployee(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto dto){
        return ResponseEntity.ok(service.updateEmployee(id,dto));
    }




}
