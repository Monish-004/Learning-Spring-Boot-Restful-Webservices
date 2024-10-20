package com.Restful_Webservices.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "My-first-Application",
        schema = "restful_webservices",
        uniqueConstraints = {
                @UniqueConstraint( columnNames = {"email"} )
        }
      )
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @Column(nullable = false,name = "firstName")
    private String firstName;
    @Column(nullable = false,name = "lastName")
    private String lastName;
    @Column(nullable = false)
    private String email;
}
