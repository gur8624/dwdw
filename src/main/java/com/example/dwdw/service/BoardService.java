package com.example.dwdw.service;

import com.example.dwdw.dto.BoardDto;
import com.example.dwdw.dto.Criteria;
import com.example.dwdw.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BoardService {

    @Autowired(required = false)
    BoardMapper boardMapper;

    public List<BoardDto> BoardList(Criteria criteria) {
        List<BoardDto> boardlist = boardMapper.BoardList(criteria);
        return boardlist;
    }

    public BoardDto readBoard(String time) {
        return boardMapper.readBoard(time);
    }

    public void BoardUpdate(String title, String content, String time) {
        boardMapper.updateBoard(title, content,time);
    }

    public void BoardDelete(String time) {
        boardMapper.deleteBoard(time);
    }

    public int boardListCnt(){
        return boardMapper.boardListCnt();
    }
}

