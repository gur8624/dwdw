package com.example.dwdw.mapper;

import com.example.dwdw.dto.AgencyDto;
import com.example.dwdw.dto.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AgencyMapper {
    List<AgencyDto> AgencyList(Criteria criteria); // 리스트

    AgencyDto readAgency(char agcy_id); // 글 열람

    void updateAgency(String title, String content, String time); //업데이트

    void deleteAgency(String time); // 삭제

    int AgencyListCnt(); // 페이지 수
}
