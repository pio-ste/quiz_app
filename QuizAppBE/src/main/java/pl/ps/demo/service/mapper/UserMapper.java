package pl.ps.demo.service.mapper;

import pl.ps.demo.model.entity.User;
import pl.ps.demo.service.dto.UserDTO;

public class UserMapper {

    public UserMapper() {
    }

    public static UserDTO mapFromEntityToDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public static User mapFromDtoToEntity(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .build();
    }
}
