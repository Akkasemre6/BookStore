package Service.User;

import Entity.User.User;
import Payload.Mapper.User.UserMapper;
import Payload.Messages.ErrorMessages;
import Payload.Messages.SuccessMessages;
import Payload.Request.User.UserCreateRequest;
import Payload.Request.User.UserUpdateRequest;
import Payload.Response.Business.ResponseMessage;
import Payload.Response.User.UserResponse;
import Repository.User.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseMessage<UserResponse> createUser(UserCreateRequest userCreateRequest, HttpServletRequest servletRequest) {

        User newUser = new User();
        newUser.setName(userCreateRequest.getName());
        newUser.setPassword(userCreateRequest.getPassword());
        newUser.setEmail(userCreateRequest.getEmail());
        newUser.setCreatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(newUser);
        UserResponse response = userMapper.mapUserToUserResponse(savedUser);

        return ResponseMessage.<UserResponse>builder()
                .message(SuccessMessages.USER_CREATED_SUCCESSFULLY)
                .object(response).build();
    }


    public ResponseEntity<UserResponse> getUserById(long id) {

        if(userRepository.existsById(id) ) {
            User user = userRepository.getUserById(id);
            return ResponseEntity.ok(userMapper.mapUserToUserResponse(user));
        }
        return ResponseEntity.notFound().build();
    }


    public ResponseMessage<UserResponse> updateUser(UserUpdateRequest request, long id) {
        if (userRepository.existsById(id) ) {
            User user = userRepository.getUserById(id);
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());

            User savedUser = userRepository.save(user);
            UserResponse response = userMapper.mapUserToUserResponse(savedUser);
            return ResponseMessage.<UserResponse>builder()
                    .message(SuccessMessages.USER_UPDATED_SUCCESSFULLY)
                    .object(response).build();
        }
        return ResponseMessage.<UserResponse>builder()
                .message(ErrorMessages.USER_NOT_FOUND)
                .build();
    }


    public String deleteById(long id) {
        if(userRepository.existsById(id) ) {
            userRepository.deleteById(id);
            return SuccessMessages. USER_DELETED_SUCCESSFULLY;
        }
        return ErrorMessages. USER_NOT_FOUND;
    }

    public Boolean getAll(){
        if(userRepository.findAll().isEmpty()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void createFirstUser(User user){
        userRepository.save(user);
    }
}
