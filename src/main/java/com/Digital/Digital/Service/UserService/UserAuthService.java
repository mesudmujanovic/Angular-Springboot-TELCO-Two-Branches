package com.Digital.Digital.Service.UserService;

import com.Digital.Digital.Infrastructure.Dto.UserDto.UserAuthDto;

public interface UserAuthService {
    public  void register(UserAuthDto userDTO) throws Exception;

}
