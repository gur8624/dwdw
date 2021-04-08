package com.example.dwdw.mapper;

import com.example.dwdw.dto.Criteria;
import com.example.dwdw.dto.StationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StationMapper {

    List<StationDto> StationList(Criteria criteria); // 리스트

    StationDto readStation(String stat_id); // 글 열람

    void updateStation(StationDto stationDto); //업데이트

    void deleteStation(StationDto stationDto); // 삭제

    int stationListCnt(); // 페이지 수
}
