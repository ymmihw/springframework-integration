package com.ymmihw.springframework.cache.example;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private int id;
    private String name;
    private String address;

    public Customer() {
        super();
    }

    public Customer(final String name, final String address) {
        this.name = name;
        this.address = address;
    }

}
