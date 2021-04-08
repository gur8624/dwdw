package com.example.dwdw.controller;

import com.example.dwdw.dto.AgencyDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.service.AgencyService;
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
@RequestMapping("agency")
public class AgencyController {

    private final AgencyService agencyService;

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> showMain(Criteria criteria,
                                        @RequestParam(defaultValue = "1") int page){

        Map<String, Object> bbb = new HashMap<String, Object>();
        List<AgencyDto> agency = null;
        Pagination pagination = new Pagination(agencyService.agencyListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        agency = agencyService.AgencyList(criteria);
        bbb.put("page", page);
        bbb.put("pagination", pagination);
        bbb.put("critia", criteria);
        bbb.put("agency", agency);

        return bbb;
    }


    @GetMapping({"read", "modify"})
    @ResponseBody
    public Map<String, Object> read(@RequestBody AgencyDto agencyDto , Criteria criteria){
        log.info("id===============" + agencyDto);
        Map<String, Object> a = new HashMap<String, Object>();
        AgencyDto dto = agencyService.readAgency(agencyDto.getAgcy_id());
        a.put("id", dto);
        a.put("criteria", criteria);


        return a;
    }

    @PostMapping("modify")
    @ResponseBody
    public void modify(@RequestBody AgencyDto agencyDto){
        agencyService.AgencyUpdate(agencyDto);
    }

    @PostMapping("remove")
    @ResponseBody
    public void remove(@RequestBody AgencyDto agencyDto){
        log.info("agencydto++++++++++++++++++++++++++=" + agencyDto);
        agencyService.AgencyDelete(agencyDto);
    }
}
