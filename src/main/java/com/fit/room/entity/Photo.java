package com.fit.room.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Photo {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String imageURI;

    @ColumnDefault("0")
    private Long likeCount;


}
