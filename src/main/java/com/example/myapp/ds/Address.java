package com.example.myapp.ds;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String zipCode;
    private String streetName;
    private String phoneNumber;
    private String email;
}