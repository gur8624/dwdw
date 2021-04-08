package com.example.dwdw.controller;

import com.example.dwdw.dto.BoladDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.service.BoladService;
import com.example.dwdw.service.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("bolad")
public class BoladController {

    private final BoladService boladService;

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> showMain(Criteria criteria,
                                        @RequestParam(defaultValue = "1") int page){

        Map<String, Object> bbb = new HashMap<String, Object>();
        List<BoladDto> bolad = null;
        Pagination pagination = new Pagination(boladService.BoladListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        bolad = boladService.BoladList(criteria);
        bbb.put("page", page);
        bbb.put("pagination", pagination);
        bbb.put("criteria", criteria);
        bbb.put("bolad", bolad);

        return bbb;
    }


    @GetMapping({"read", "modify"})
    @ResponseBody
    public Map<String, Object> read(@RequestBody BoladDto boladDto , Criteria criteria){
        Map<String, Object> a = new HashMap<String, Object>();
        BoladDto dto = boladService.readBolad(boladDto.getBol_cd());
        a.put("id", dto);
        a.put("criteria", criteria);

        return a;
    }

    @PostMapping("modify")
    @ResponseBody
    public void modify(@RequestBody BoladDto boladDto){
        boladService.BoladUpdate(boladDto);
    }

    @PostMapping("remove")
    @ResponseBody
    public void remove(@RequestBody BoladDto boladDto){
        boladService.BoladDelete(boladDto);
    }
}
