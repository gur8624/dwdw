package com.example.dwdw.service;

import com.example.dwdw.dto.Criteria;
import com.example.dwdw.dto.UserDto;
import com.example.dwdw.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    public List<UserDto> UserList(Criteria criteria) {
        List<UserDto> UserList = userMapper.UserList(criteria);
        return UserList;
    }

    public UserDto readUser(String id) {
        return userMapper.readUser(id);
    }

    public void BoardUpdate(UserDto userDto) {
        userMapper.updateUser(userDto);
    }

    public void UserDelete(UserDto userDto) {
       userMapper.deleteUser(userDto);
    }

    public int boardListCnt(){
        return userMapper.userListCnt();
    }
}
