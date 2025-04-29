package icet.edu.com.service.impl;

import icet.edu.com.dto.LogInRequest;
import icet.edu.com.dto.UserDto;
import icet.edu.com.entity.UserEntity;
import icet.edu.com.repository.UserRepository;
import icet.edu.com.service.UserService;
import icet.edu.com.util.EmailCheck;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    final ModelMapper mapper;
    final BCryptPasswordEncoder encoder;
    final EmailCheck emailCheck;

    @Override
    public Boolean saveUser(UserDto userDto) {
        if (userDto == null || !emailCheck.isValid(userDto.getEmail()) || repository.findByEmail(userDto.getEmail()) != null) {
            return false;
        }
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        return repository.save(mapper.map(userDto, UserEntity.class)) != null;
    }

    @Override
    public UserDto getUser(Long id) {
        return mapper.map(repository.findById(id),UserDto.class);
    }

    @Override
    public Boolean deleteUser(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }

    @Override
    public Boolean authenticateUser(LogInRequest request) {
        UserEntity byEmail = repository.findByEmail(request.getEmail());
        return byEmail !=null && encoder.matches(request.getPassword(),byEmail.getPassword());
    }

}
