package com.fit.room.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Photo>  photos;

    @OneToMany
    private List<Comment> comments;
}
