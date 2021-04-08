package com.example.dwdw.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ChargerDto {
    private String chg_id;
    private String chg_type;
    private String chg_method;
    private String chg_st;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime chg_st_dt;
    private String chg_rsvt;
    private String agcy_id;
    private String stat_id;

}
