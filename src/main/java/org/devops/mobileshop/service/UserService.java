package org.devops.mobileshop.service;


import lombok.RequiredArgsConstructor;
import org.devops.mobileshop.dto.LoginRequest;
import org.devops.mobileshop.dto.UserDto;
import org.devops.mobileshop.exception.UserNotFoundException;
import org.devops.mobileshop.exception.UserNotRegistered;
import org.devops.mobileshop.model.User;
import org.devops.mobileshop.repository.DeliverRepository;
import org.devops.mobileshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final DeliverRepository deliverRepository;


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




    public UserDto loginUser(LoginRequest request) {



        // check if the user exists  if not throws the exception

        var user  = userRepository.findUserByEmail(request.email());









         if( user == null ) {
 throw   new UserNotFoundException(" user not registerd ");

         }

          if(  !passwordEncoder.matches(request.password(), user.getPassword())){


                throw new UserNotRegistered("  User not registed ") ;

          }


              return new UserDto( user.getUsername(), user.getRole() , user.getEmail() , user.getPhoneNumber() , user.getName() ,user.getPassword());











    }



}
