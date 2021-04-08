package com.example.dwdw.service;

import com.example.dwdw.dto.BoladDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.mapper.BoladMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoladService {

    @Autowired(required = false)
    BoladMapper boladMapper;

    public List<BoladDto> BoladList(Criteria criteria) {
        List<BoladDto> boladList = boladMapper.BoladList(criteria);
        return boladList;
    }

    public BoladDto readBolad(String bol_cd) {
        return boladMapper.readBolad(bol_cd);
    }

    public void BoladUpdate(BoladDto boladDto) {
        boladMapper.updateBolad(boladDto);
    }

    public void BoladDelete(BoladDto boladDto) {
        boladMapper.deleteBolad(boladDto);
    }

    public int BoladListCnt(){
        return boladMapper.boladListCnt();
    }
}
