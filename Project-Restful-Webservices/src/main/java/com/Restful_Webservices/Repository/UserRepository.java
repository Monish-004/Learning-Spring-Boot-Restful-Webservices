package com.Restful_Webservices.Repository;

import com.Restful_Webservices.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
