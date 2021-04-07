package com.example.dwdw.controller;


import com.example.dwdw.dto.BoardDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.service.BoardService;
import com.example.dwdw.service.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    String modiB_dtt;

    @GetMapping("/list")
    public String showMain(Criteria criteria, Model model,
                           @RequestParam(defaultValue = "1") int page){
        List<BoardDto> boardDto = null;
        Pagination pagination = new Pagination(boardService.boardListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        boardDto = boardService.BoardList(criteria);
        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardDto);

        return "/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(String b_dtt, String page, Model model, Criteria criteria){
        modiB_dtt = b_dtt;
        BoardDto dto = boardService.readBoard(b_dtt);
        model.addAttribute("dto", dto);
        model.addAttribute("page", criteria);
    }

    @PostMapping("/modify")
    public String modify(BoardDto boardDto){
        boardService.BoardUpdate(boardDto.getB_content(), boardDto.getB_title(), modiB_dtt);
        return "redirect:/board/read?b_dtt=" + modiB_dtt;
    }

    @PostMapping("/remove")
    public String remove(String b_dtt, String page){
        boardService.BoardDelete(b_dtt);
        return "redirect:/board/list?page="+ page;
    }



}
