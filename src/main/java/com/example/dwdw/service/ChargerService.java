package com.example.dwdw.service;

import com.example.dwdw.dto.ChargerDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.mapper.ChargerMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ChargerService {

    @Autowired(required = false)
    ChargerMapper chargerMapper;

    public List<ChargerDto> ChargerList(Criteria criteria) {
        List<ChargerDto> chargerList = chargerMapper.ChargerList(criteria);
        return chargerList;
    }

    public ChargerDto readCharger(String chg_id) {
        return chargerMapper.readCharger(chg_id);
    }

    public void ChargerUpdate(ChargerDto chargerDto) {
        chargerMapper.updateCharger(chargerDto);
    }

    public void ChargerDelete(ChargerDto chargerDto) {
        chargerMapper.deleteCharger(chargerDto);
    }

    public int chargerListCnt(){
        return chargerMapper.chargerListCnt();
    }
}
