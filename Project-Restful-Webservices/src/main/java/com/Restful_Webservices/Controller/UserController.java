package com.Restful_Webservices.Controller;


import com.Restful_Webservices.DTO.UserDto;
import com.Restful_Webservices.Entity.UserEntity;
import com.Restful_Webservices.Service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("restful-webservice")
@RestController
public class UserController
{
    @Autowired
    private UserService service;

    // REST-FUL API TO SAVE DATAS
    // http://localhost:8080/restful-webservice/save-user
    @PostMapping("save-user")
    public ResponseEntity<String> saveUser(@RequestBody UserDto dtoSavedUser)
    {
        service.createUser(dtoSavedUser);
        return new ResponseEntity<>("Users are Successfully Added to database", HttpStatus.CREATED);
    }

    // REST-FUL API TO SAVE LIST OF DATAS
    // http://localhost:8080/restful-webservice/save-all-user
    @PostMapping("save-all-user")
    public ResponseEntity<String> saveListOfUser(@RequestBody List<UserDto> listOfUsersSaved)
    {
        service.createAllUser(listOfUsersSaved);
        return new ResponseEntity<>("List of Users are Saved Successfully",HttpStatus.CREATED);
    }

    // REST-FUL API TO FETCH DATAS BY ID
    // http://localhost:8080/restful-webservice/fetch/1
    @GetMapping("fetch/{id}")
    public ResponseEntity<UserDto> fetchingUser(@PathVariable("id") Integer user_id)
    {
        return new ResponseEntity<>(service.getUserById(user_id),HttpStatus.OK);
    }

    // REST-FUL API TO FETCH LIST OF DATAS
    // http://localhost:8080/restful-webservice/fetch-all
    @GetMapping("fetch-all")
    public ResponseEntity<List<UserDto>> fetchingAllUsers()
    {
        return new ResponseEntity<>(service.getAllUsers(),HttpStatus.ACCEPTED);
    }

    // REST-FUL API TO UPDATE DATAS BY ID
    // http://localhost:8080/restful-webservice/update-by/7
    @PutMapping("update-by/{id}")
    public ResponseEntity<UserDto> updateRecordsById(@PathVariable Integer id ,
                                                        @RequestBody UserDto updateRecordsById)
    {
        updateRecordsById.setId(id);
        return new ResponseEntity<>(service.updateUserById(updateRecordsById),HttpStatus.OK);
    }

    // REST-FUL API TO DELETE VALUES BY ID
    // http://localhost:8080/restful-webservice/delete-by/2
    @DeleteMapping("delete-by/{id}")
    public ResponseEntity<String> deleteTheRowById(@PathVariable Integer id)
    {
        service.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.ACCEPTED);
    }
}
