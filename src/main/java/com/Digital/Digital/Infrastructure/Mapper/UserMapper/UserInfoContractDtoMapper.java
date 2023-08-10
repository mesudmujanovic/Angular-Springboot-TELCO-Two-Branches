package com.Digital.Digital.Infrastructure.Mapper.UserMapper;

import com.Digital.Digital.Entity.User.UserInfoContact;
import com.Digital.Digital.Infrastructure.Dto.UserDto.UserInfoContactDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum UserInfoContractDtoMapper implements DtoMapper<UserInfoContactDto, UserInfoContact> {
    INSTANCE;

    @Override
    public UserInfoContactDto apply(UserInfoContact userInfoContact) {
        UserInfoContactDto userInfoContactDto = new UserInfoContactDto();
        userInfoContactDto.setId(userInfoContact.getId());
        userInfoContactDto.setName(userInfoContact.getName());
        userInfoContactDto.setLastName(userInfoContact.getLastName());
        userInfoContactDto.setPhone(userInfoContact.getPhone());
        userInfoContactDto.setEmail(userInfoContact.getEmail());
        return userInfoContactDto;
    }
}
