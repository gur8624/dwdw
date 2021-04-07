package com.example.dwdw.service;

import com.example.dwdw.dto.AgencyDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.dto.UserDto;
import com.example.dwdw.mapper.AgencyMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class AgencyService {

    @Autowired(required = false)
    AgencyMapper agencyMapper;

    public List<AgencyDto> AgencyList(Criteria criteria) {
        List<AgencyDto> agencyList = agencyMapper.AgencyList(criteria);
        return agencyList;
    }

    public AgencyDto readAgency(String agcy_id) {
        return agencyMapper.readAgency(agcy_id);
    }

    public void AgencyUpdate(AgencyDto agencyDto) {
        agencyMapper.updateAgency(agencyDto);
    }

    public void AgencyDelete(AgencyDto agencyDto) {
        agencyMapper.deleteAgency(agencyDto);
    }

    public int agencyListCnt(){
        return agencyMapper.agencyListCnt();
    }

}
