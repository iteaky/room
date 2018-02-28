package com.fit.room.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Task {
    @Id
    private Long id;

    @NotNull
    @OneToOne
    private Photo photoFirst;

    @NotNull
    @OneToOne
    private Photo photoSecond;

    List<String> comments;
}
