package com.example.dwdw.mapper;

import com.example.dwdw.dto.BoardDto;
import com.example.dwdw.dto.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> BoardList(Criteria criteria); // 리스트

    BoardDto readBoard(String time); // 글 열람

    void updateBoard(String title, String content, String time); //업데이트

    void deleteBoard(String time); // 삭제

    int boardListCnt(); // 페이지 수
}
