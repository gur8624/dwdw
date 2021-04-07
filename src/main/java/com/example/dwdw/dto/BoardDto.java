package com.example.dwdw.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private char cat_cd;
    private String b_title;
    private String b_content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime b_dtt;
    private String u_id;
}
