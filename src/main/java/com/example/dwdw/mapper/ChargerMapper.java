package com.example.dwdw.mapper;

import com.example.dwdw.dto.ChargerDto;
import com.example.dwdw.dto.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChargerMapper {

    List<ChargerDto> ChargerList(Criteria criteria); // 리스트

    ChargerDto readCharger(String chg_id); // 글 열람

    void updateCharger(ChargerDto chargerDto); //업데이트

    void deleteCharger(ChargerDto chargerDto); // 삭제

    int chargerListCnt(); // 페이지 수
}
