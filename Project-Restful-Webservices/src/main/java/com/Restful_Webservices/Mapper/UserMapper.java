package com.Restful_Webservices.Mapper;

import com.Restful_Webservices.DTO.UserDto;
import com.Restful_Webservices.Entity.UserEntity;

public class UserMapper
{
    // Convert From User JPA Entity to User DTO
    // Map to UserDto [ That means converting from Entity to DTO ]
    public static UserDto mapToUserDto(UserEntity userEntity)
    {
        UserDto userDto = new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail()
        );
        return userDto;
    }

    // Convert From User DTO to User JPA Entity
    // Map to UserEntity [ That means Converting from DTO to Entity ]
    public static UserEntity mapToUserEntity(UserDto dto)
    {
        UserEntity entity = new UserEntity(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail()
        );

        return entity;
    }
}
