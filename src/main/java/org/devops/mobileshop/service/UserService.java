package org.devops.mobileshop.service;


import lombok.RequiredArgsConstructor;
import org.devops.mobileshop.dto.UserDto;
import org.devops.mobileshop.model.User;
import org.devops.mobileshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    public UserDto createUser( UserDto request) {

var createdUser = new User();



createdUser.setName(request.name());

createdUser.setEmail(request.email());
createdUser.setRole(request.role());

createdUser.setPassword(passwordEncoder.encode(request.password()));
createdUser.setUsername(request.username());
createdUser.setPhoneNumber(request.phoneNumber());

userRepository.insert(createdUser);

  return new UserDto( createdUser.getUsername() ,createdUser.getRole() , createdUser.getEmail(), createdUser.getPhoneNumber(),createdUser.getName(), createdUser.getPassword())
;





    }



}
