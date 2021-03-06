package com.homerconsulting.hc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Skill implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "code")
    private Integer code;

    @Column(name = "description")
    private String description;

    private Skill() {

    }
}
