package com.fit.room.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.net.URL;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Photo {
    @Id
    private Long id;
    @NotNull
    private String imageURI;

    @ColumnDefault(value = "0")
    private Long like;

}
