package com.infosys.userrest.service;

import com.infosys.userrest.model.DepartmentDto;
import com.infosys.userrest.model.ResponseDto;
import com.infosys.userrest.model.UserInfo;
import com.infosys.userrest.model.UserInfoDto;
import com.infosys.userrest.repository.UserInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInterfaceRepository userInterfaceRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserInfo saveUser(UserInfo userInfo) {

        return userInterfaceRepository.save(userInfo);
    }

    @Override
    public UserInfo getDetail(Long id) {
        UserInfo userInfo = userInterfaceRepository.findById(id).get();
        System.out.println(userInfo);
        return userInfo;
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();
        UserInfo userInfo = userInterfaceRepository.findById(userId).get();
        System.out.println(userInfo.getDepartmentId());
        UserInfoDto  userInfoDto=mapToUser(userInfo);
        ResponseEntity<DepartmentDto> responseEntity= restTemplate
                .getForEntity("http://localhost:8080/api/departments/"+userInfoDto.getDepartmentId(), DepartmentDto.class);
        DepartmentDto departmentDto=responseEntity.getBody();
        responseDto.setUserInfoDto(userInfoDto);
        responseDto.setDepartmentDto(departmentDto);
        return responseDto;
    }

    private UserInfoDto mapToUser(UserInfo userInfo) {
        UserInfoDto userInfoDto=new UserInfoDto();
        userInfoDto.setId(userInfo.getId());
        userInfoDto.setFirstName(userInfo.getFirstName());
        userInfoDto.setLastName(userInfo.getLastName());
        userInfoDto.setEmail(userInfo.getEmail());
        userInfoDto.setDepartmentId(userInfo.getDepartmentId());
        return userInfoDto;
    }
}
