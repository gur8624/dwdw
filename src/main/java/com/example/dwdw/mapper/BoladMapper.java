package com.example.dwdw.mapper;

import com.example.dwdw.dto.BoladDto;
import com.example.dwdw.dto.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoladMapper {

    List<BoladDto> BoladList(Criteria criteria); // 리스트

    BoladDto readBolad(String bol_cd); // 글 열람

    void updateBolad(BoladDto boladDto); //업데이트

    void deleteBolad(BoladDto boladDto); // 삭제

    int boladListCnt(); // 페이지 수
}
