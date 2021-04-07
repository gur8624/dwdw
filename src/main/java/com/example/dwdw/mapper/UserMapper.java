package com.example.dwdw.mapper;

import com.example.dwdw.dto.Criteria;
import com.example.dwdw.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDto> UserList(Criteria criteria); // 리스트

    UserDto readUser(String id); // 글 열람

    void updateUser(UserDto userDto); //업데이트

    void deleteUser(UserDto userDto); // 삭제

    int userListCnt(); // 페이지 수
}
