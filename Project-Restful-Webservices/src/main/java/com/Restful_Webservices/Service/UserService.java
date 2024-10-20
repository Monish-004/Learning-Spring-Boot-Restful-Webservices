package com.Restful_Webservices.Service;

import com.Restful_Webservices.DTO.UserDto;
import com.Restful_Webservices.Entity.UserEntity;

import java.util.List;

public interface UserService
{
    // REST-FUL API TO SAVE DATAS
    UserDto createUser(UserDto userDtoService);

    // REST-FUL API TO SAVE LIST OF DATAS
    List<UserDto> createAllUser(List<UserDto> listOfUserEntity);

    // REST-FUL API TO FETCH DATAS BY ID
    UserDto getUserById(Integer id);

    // REST-FUL API TO FETCH LIST OF DATAS
    List<UserDto> getAllUsers();

    // REST-FUL API TO UPDATE DATAS BY ID
    UserDto updateUserById(UserDto updateTheUserEntity);

    // REST-FUL API TO DELETE VALUES BY ID
    void deleteById(Integer id);

}
