package com.Restful_Webservices.Service.ServiceImplementation;

import com.Restful_Webservices.DTO.UserDto;
import com.Restful_Webservices.Entity.UserEntity;
import com.Restful_Webservices.Mapper.UserMapper;
import com.Restful_Webservices.Repository.UserRepository;
import com.Restful_Webservices.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService
{

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    // REST-FUL API TO SAVE DATAS
    @Override
    public UserDto createUser(UserDto userDtoService)
    {

        // MANUAL CONVERTING FROM DTO TO ENTITY
        // UserEntity covertingFromDto = UserMapper.mapToUserEntity(userDtoService);

        // AUTOMATION CONVERTING FROM DTO TO ENTITY
        UserEntity covertingFromDto = modelMapper.map(userDtoService , UserEntity.class);



        // Saving the Entity to DataBase
        // NOTE :  WE CAN'T ABLE TO STORE DTO TO DATABASE
        UserEntity savedEntity = repository.save(covertingFromDto);



        // CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        // UserDto convertingFromEntity = UserMapper.mapToUserDto(savedEntity);

        // AUTOMATION CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        UserDto convertingFromEntity = modelMapper.map(savedEntity , UserDto.class);


        // NOW RETURNING THE RESPONSE AS DTO
        return convertingFromEntity;

    }

    // REST-FUL API TO SAVE LIST OF DATAS
    @Override
    public List<UserDto> createAllUser(List<UserDto> listOfUserEntity)
    {

        // CONVERTING FROM DTO TO ENTITY
        // List<UserEntity> changingToEntity = listOfUserEntity.stream().map(UserMapper::mapToUserEntity).
        //      collect(Collectors.toList());

        // AUTOMATION CONVERTING FROM DTO TO ENTITY
        List<UserEntity> changingToEntity = listOfUserEntity.stream().map((my_own_variable_for_Dto) -> // Lambda Expression Used here
                 modelMapper.map(my_own_variable_for_Dto , UserEntity.class)).collect(Collectors.toList());



        // Saving the Entity to DataBase
        // NOTE :  WE CAN'T ABLE TO STORE DTO TO DATABASE
        List<UserEntity> listOfDatasSaving = repository.saveAll(changingToEntity);



        // CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        // List<UserDto> changingToDto = listOfDatasSaving.stream().map(UserMapper::mapToUserDto)
        //      .toList();

        // AUTOMATION CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        List<UserDto> changingToDto = listOfDatasSaving.stream().map((myVariableEntity) ->
                modelMapper.map(myVariableEntity , UserDto.class)).toList();


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
        // return UserMapper.mapToUserDto(providingEntityToClient);


        // AUTOMATION CONVERTING FROM ENTITY TO DTO AND RETURNING THE RESPONSE AS DTO
        return modelMapper.map(providingEntityToClient,UserDto.class);

    }

    // REST-FUL API TO FETCH LIST OF DATAS
    @Override
    public List<UserDto> getAllUsers()
    {

        // FROM THE ENTITY, FETCHING OUR ALL DATA FROM DATABASE
        List<UserEntity> providingAllDatasToClient = repository.findAll();


        // CONVERTING FROM ENTITY TO DTO AND RETURNING THE RESPONSE AS DTO
        // return providingAllDatasToClient.stream().map(UserMapper::mapToUserDto).
                // collect(Collectors.toList());


        // AUTOMATION CONVERTING FROM ENTITY TO DTO AND RETURNING THE RESPONSE AS DTO
        return providingAllDatasToClient.stream().map((my_own_variable_for_Entity) -> modelMapper.map
                        (my_own_variable_for_Entity,UserDto.class) ).collect(Collectors.toList());

    }

    // REST-FUL API TO UPDATE DATAS BY ID
    @Override
    public UserDto updateUserById(UserDto updateTheUserEntity)
    {

        // CONVERTING FROM DTO TO ENTITY
        // UserEntity updateTheRecordById = UserMapper.mapToUserEntity(updateTheUserEntity);

        // AUTOMATION CONVERTING FROM DTO TO ENTITY
        UserEntity updateTheRecordById = modelMapper.map(updateTheUserEntity , UserEntity.class);


        // Saving the Entity to DataBase
        // NOTE :  WE CAN'T ABLE TO STORE DTO TO DATABASE
        UserEntity updatingDatas = repository.save(updateTheRecordById);


        // CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        // UserDto updatedValues = UserMapper.mapToUserDto(updatingDatas);

        // AUTOMATION CONVERTING FROM ENTITY TO DTO [ VICEVERSA ]
        UserDto updatedValues = modelMapper.map(updatingDatas , UserDto.class);


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
