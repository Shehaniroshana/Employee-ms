package icet.edu.com.service;

import icet.edu.com.dto.LogInRequest;
import icet.edu.com.dto.UserDto;

public interface UserService {
    public Boolean saveUser(UserDto userDto);
    UserDto getUser(Long id);
    Boolean deleteUser(Long id);
    Boolean authenticateUser(LogInRequest request);
}
