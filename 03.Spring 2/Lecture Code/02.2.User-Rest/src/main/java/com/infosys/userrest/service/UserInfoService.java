package com.infosys.userrest.service;

import com.infosys.userrest.model.ResponseDto;
import com.infosys.userrest.model.UserInfo;

public interface UserInfoService {
    UserInfo saveUser(UserInfo userInfo);
    UserInfo getDetail(Long id);
    ResponseDto getUser(Long userId);
}
