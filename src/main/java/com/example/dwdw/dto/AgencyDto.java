package com.example.dwdw.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Blob;
import java.time.LocalDateTime;


@Data
public class AgencyDto {
    private char agcy_id;
    private String agcy_nm;
    private Long agcy_bs_r;
    private Long agcy_fee;
    private Long agcy_dc;
    private Blob agcy_logo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime agcy_up_dtt;
}
