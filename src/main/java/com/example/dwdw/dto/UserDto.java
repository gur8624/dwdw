package com.example.dwdw.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String u_id;
    private String u_email;
    private String u_pwd;
    private String u_phone;
    private Date u_reg_dt;
}
