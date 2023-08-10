package com.Digital.Digital.Infrastructure.Mapper.UserMapper;

import com.Digital.Digital.Entity.User.UserInfoContact;
import com.Digital.Digital.Infrastructure.Dto.UserDto.UserInfoContactDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum UserInfoContractMapper implements DtoMapper<UserInfoContact, UserInfoContactDto > {
    INSTANCE;

    @Override
    public UserInfoContact apply(UserInfoContactDto userInfoContactDto) {
        UserInfoContact userInfoContact = new UserInfoContact();
        userInfoContact.setId(userInfoContactDto.getId());
        userInfoContact.setName(userInfoContactDto.getName());
        userInfoContact.setPhone(userInfoContactDto.getPhone());
        userInfoContact.setEmail(userInfoContactDto.getEmail());
        userInfoContact.setLastName(userInfoContactDto.getLastName());
        return userInfoContact;
    }
}
