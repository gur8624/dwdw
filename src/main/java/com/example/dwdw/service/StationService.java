package com.example.dwdw.service;

import com.example.dwdw.dto.Criteria;
import com.example.dwdw.dto.StationDto;
import com.example.dwdw.mapper.StationMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class StationService {

    @Autowired(required = false)
    StationMapper stationMapper;

    public List<StationDto> StationList(Criteria criteria) {
        List<StationDto> stationList = stationMapper.StationList(criteria);
        return stationList;
    }

    public StationDto readStation(String stat_id) {
        return stationMapper.readStation(stat_id);
    }

    public void StationUpdate(StationDto stationDto) {
        log.info("sdjflsdjfkljsdlkf1123123" + stationDto);
        stationMapper.updateStation(stationDto);
    }

    public void StationDelete(StationDto stationDto) {
        stationMapper.deleteStation(stationDto);
    }

    public int stationListCnt(){
        return stationMapper.stationListCnt();
    }
}
