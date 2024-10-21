package com.Restful_Webservices.Repository;

import com.Restful_Webservices.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer>
{
    Optional<UserEntity> findByEmail(String email);
}
