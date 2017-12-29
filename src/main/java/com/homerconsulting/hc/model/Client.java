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
public class Client implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private Integer clientID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip_code", nullable = false, length = 5)
    private String zipCode;

    @Column(name = "industry", nullable = false)
    private String industry;

    @Column(name = "web_address", nullable = false)
    private String webAddress;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "contact_name", nullable = false)
    private String contactName;

    private Client() {
    }
}
