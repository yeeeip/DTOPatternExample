package com.nuzhd.dtopatternexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class CustomerAddRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
