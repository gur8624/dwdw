package com.example.dwdw.controller;

import com.example.dwdw.dto.BoardDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.dto.UserDto;
import com.example.dwdw.service.Pagination;
import com.example.dwdw.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> showMain(Criteria criteria,
                                    @RequestParam(defaultValue = "1") int page){

        Map<String, Object> aaa = new HashMap<String, Object>();
        List<UserDto> userDto = null;
        Pagination pagination = new Pagination(userService.boardListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        userDto = userService.UserList(criteria);
        aaa.put("page", page);
        aaa.put("pagination", pagination);
        aaa.put("critia", criteria);

        return aaa;
    }


    @GetMapping({"read", "modify"})
    @ResponseBody
    public Map<String, Object> read(@RequestBody UserDto userDto, Criteria criteria){
        log.info("id===============" + userDto);
        Map<String, Object> a = new HashMap<String, Object>();
        UserDto dto = userService.readUser(userDto.getU_id());
        a.put("id", dto);
        a.put("criteria", criteria);

        return a;
    }

    @PostMapping("modify")
    @ResponseBody
    public Map<String, Object> modify(@RequestBody UserDto userDto){
        userService.BoardUpdate(userDto);
        Map<String, Object> aa = new HashMap<String, Object>();
        aa.put("userdto", userDto);
        return aa;
    }

    @PostMapping("remove")
    @ResponseBody
    public Map<String, Object> remove(@RequestBody UserDto userDto){
        log.info("userdto++++++++++++++++++++++++++=" + userDto);
        userService.UserDelete(userDto);
        Map<String, Object> aaaa = new HashMap<String, Object>();
        aaaa.put("id", userDto);
        return aaaa;
    }
}
