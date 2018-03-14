package com.fit.room.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    @Length(min = 5)
    @NotEmpty
    private String password;

    @NotEmpty
    private String role;

    private int active;

}
