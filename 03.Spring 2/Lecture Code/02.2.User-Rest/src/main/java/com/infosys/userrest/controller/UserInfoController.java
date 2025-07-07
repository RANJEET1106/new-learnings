package com.infosys.userrest.controller;

import com.infosys.userrest.model.ResponseDto;
import com.infosys.userrest.model.UserInfo;
import com.infosys.userrest.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/adduser")
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo userInfo) {
        UserInfo savedUser = userInfoService.saveUser(userInfo);
        return new  ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUserDetails(@PathVariable("id") Long id) {
        ResponseDto responseDto = userInfoService.getUser(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/user/{id}")
    public UserInfo getUserDetails1(@PathVariable("id") Long userid){
        return userInfoService.getDetail(userid);
    }
}
