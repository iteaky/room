package com.fit.room.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime creationDate;

    @NotNull
    private String text;

    public Comment() {
        this.creationDate = LocalDateTime.now();
    }

}
