package com.example.dwdw.controller;

import com.example.dwdw.dto.Criteria;
import com.example.dwdw.dto.StationDto;
import com.example.dwdw.service.Pagination;
import com.example.dwdw.service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("station")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> showMain(Criteria criteria,
                                        @RequestParam(defaultValue = "1") int page){

        Map<String, Object> ccc = new HashMap<String, Object>();
        List<StationDto> station = null;
        Pagination pagination = new Pagination(stationService.stationListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        station = stationService.StationList(criteria);
        ccc.put("page", page);
        ccc.put("pagination", pagination);
        ccc.put("critia", criteria);
        ccc.put("staion", station);

        return ccc;
    }


    @GetMapping({"read", "modify"})
    @ResponseBody
    public Map<String, Object> read(@RequestBody StationDto stationDto , Criteria criteria){
        log.info("id===============" + stationDto);
        Map<String, Object> ba = new HashMap<String, Object>();
        StationDto staion = stationService.readStation(stationDto.getStat_id());
        log.info(staion);
        ba.put("id", staion);
        ba.put("criteria", criteria);

        return ba;
    }

    @PostMapping("modify")
    @ResponseBody
    public void modify(@RequestBody StationDto stationDto){
        log.info("shdkfjsdiljf==========" + stationDto);
        stationService.StationUpdate(stationDto);
    }

    @PostMapping("remove")
    @ResponseBody
    public void remove(@RequestBody StationDto stationDto){
        log.info("agencydto++++++++++++++++++++++++++=" + stationDto);
        stationService.StationDelete(stationDto);
    }
}
