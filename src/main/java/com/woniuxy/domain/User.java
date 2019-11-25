package com.woniuxy.domain;

import lombok.Data;

import java.io.Serializable;



@Data
public class User implements Serializable {
    private Integer uid;

    private String uname;


}