package com.example.myapp.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class CustomerBookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderCode;
    private double totalAmount;
    @ManyToOne
    private Customer customer;



}
