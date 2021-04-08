package com.example.dwdw.controller;

import com.example.dwdw.dto.ChargerDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.service.ChargerService;
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
@RequestMapping("charger")
public class ChargerController {

    private final ChargerService chargerService;

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> showMain(Criteria criteria,
                                        @RequestParam(defaultValue = "1") int page){

        Map<String, Object> bbb = new HashMap<String, Object>();
        List<ChargerDto> charger = null;
        Pagination pagination = new Pagination(chargerService.chargerListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        charger = chargerService.ChargerList(criteria);
        bbb.put("page", page);
        bbb.put("pagination", pagination);
        bbb.put("critia", criteria);
        bbb.put("agency", charger);

        return bbb;
    }


    @GetMapping({"read", "modify"})
    @ResponseBody
    public Map<String, Object> read(@RequestBody ChargerDto chargerDto , Criteria criteria){
        Map<String, Object> a = new HashMap<String, Object>();
        ChargerDto dto = chargerService.readCharger(chargerDto.getChg_id());
        a.put("id", dto);
        a.put("criteria", criteria);


        return a;
    }

    @PostMapping("modify")
    @ResponseBody
    public void modify(@RequestBody ChargerDto chargerDto){
        chargerService.ChargerUpdate(chargerDto);
    }

    @PostMapping("remove")
    @ResponseBody
    public void remove(@RequestBody ChargerDto chargerDto){
        chargerService.ChargerDelete(chargerDto);
    }
}
