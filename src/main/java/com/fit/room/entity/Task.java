package com.fit.room.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Photo>  photos;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Comment> comments;

}
