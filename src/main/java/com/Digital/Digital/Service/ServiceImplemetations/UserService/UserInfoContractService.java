package com.Digital.Digital.Service.ServiceImplemetations.UserService;

import com.Digital.Digital.Infrastructure.Dto.UserDto.UserInfoContactDto;
import org.apache.catalina.User;

import java.util.List;

public interface UserInfoContractService {

    public UserInfoContactDto getUserInfo (UserInfoContactDto userInfoContactDto);

    public List<UserInfoContactDto> getAllUsersInfo();

    UserInfoContactDto getById (Long userInfoId);
}
