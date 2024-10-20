package com.Restful_Webservices.Service.ServiceImplementation;

import com.Restful_Webservices.DTO.UserDto;
import com.Restful_Webservices.Entity.UserEntity;
import com.Restful_Webservices.Mapper.UserMapper;
import com.Restful_Webservices.Repository.UserRepository;
import com.Restful_Webservices.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService
{

    @Autowired
    private UserRepository repository;

    // REST-FUL API TO SAVE DATAS
    @Override
    public UserDto createUser(UserDto userDtoService)
    {
        // Converting From DTO to Entity
        UserEntity covertingFromDto = UserMapper.mapToUserEntity(userDtoService);

        // Saving the Entity to DataBase
        // NOTE :  WE CAN'T ABLE TO STORE DTO TO DATABASE
        UserEntity savedEntity = repository.save(covertingFromDto);

        // CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        UserDto convertingFromEntity = UserMapper.mapToUserDto(savedEntity);

        // NOW RETURNING THE RESPONSE AS DTO
        return convertingFromEntity;
    }

    // REST-FUL API TO SAVE LIST OF DATAS
    @Override
    public List<UserDto> createAllUser(List<UserDto> listOfUserEntity)
    {
        // Converting From DTO to Entity
        List<UserEntity> changingToEntity = listOfUserEntity.stream().map(UserMapper::mapToUserEntity).
                collect(Collectors.toList());

        // Saving the Entity to DataBase
        // NOTE :  WE CAN'T ABLE TO STORE DTO TO DATABASE
        List<UserEntity> listOfDatasSaving = repository.saveAll(changingToEntity);

        // CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        List<UserDto> changingToDto = listOfDatasSaving.stream().map(UserMapper::mapToUserDto).toList();

        // NOW RETURNING THE RESPONSE AS DTO
        return changingToDto;

    }

    // REST-FUL API TO FETCH DATAS BY ID
    @Override
    public UserDto getUserById(Integer id)
    {
        // FROM THE ENTITY, FETCHING OUR DATA BASED ON ID OR USER_ID FROM DATABASE
        UserEntity providingEntityToClient =  repository.findById(id).get();
        // CONVERTING FROM ENTITY TO DTO AND RETURNING THE RESPONSE AS DTO
        return UserMapper.mapToUserDto(providingEntityToClient);
    }

    // REST-FUL API TO FETCH LIST OF DATAS
    @Override
    public List<UserDto> getAllUsers()
    {
        // FROM THE ENTITY, FETCHING OUR ALL DATA FROM DATABASE
        List<UserEntity> providingAllDatasToClient = repository.findAll();
        // CONVERTING FROM ENTITY TO DTO AND RETURNING THE RESPONSE AS DTO
        return providingAllDatasToClient.stream().map(UserMapper::mapToUserDto).
                collect(Collectors.toList());
    }

    // REST-FUL API TO UPDATE DATAS BY ID
    @Override
    public UserDto updateUserById(UserDto updateTheUserEntity)
    {
        // Converting From DTO to Entity
        UserEntity updateTheRecordById = UserMapper.mapToUserEntity(updateTheUserEntity);

        // Saving the Entity to DataBase
        // NOTE :  WE CAN'T ABLE TO STORE DTO TO DATABASE
        UserEntity updatingDatas = repository.save(updateTheRecordById);

        // CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        UserDto updatedValues = UserMapper.mapToUserDto(updatingDatas);

        // NOW RETURNING THE RESPONSE AS DTO
        return updatedValues;
    }

    // REST-FUL API TO DELETE VALUES BY ID
    @Override
    public void deleteById(Integer id)
    {
        repository.deleteById(id);
    }
}
