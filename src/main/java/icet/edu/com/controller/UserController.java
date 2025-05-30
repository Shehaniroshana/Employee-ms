package icet.edu.com.controller;

import icet.edu.com.dto.LogInRequest;
import icet.edu.com.dto.UserDto;
import icet.edu.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService service;
    @PostMapping
    public ResponseEntity<Boolean> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.saveUser(userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteUser(id));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticateUser(@RequestBody  LogInRequest request) {
        return ResponseEntity.ok(service.authenticateUser(request));
    }


}
