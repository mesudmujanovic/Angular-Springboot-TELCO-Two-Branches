package com.Digital.Digital.Service.ServiceImplemetations.UserImpl;

import com.Digital.Digital.Entity.User.UserInfoContact;
import com.Digital.Digital.Infrastructure.Dto.UserDto.UserInfoContactDto;
import com.Digital.Digital.Infrastructure.Mapper.UserMapper.UserInfoContractDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.UserMapper.UserInfoContractMapper;
import com.Digital.Digital.Repository.UserRepository.UserInfoContactRepository;
import com.Digital.Digital.Service.UserService.UserInfoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class UserInfoContractImpl implements UserInfoContractService {

    @Autowired
    UserInfoContactRepository userInfoContactRepository;

    @Override
    @Validated
    public UserInfoContactDto getUserInfo(UserInfoContactDto userInfoContactDto) {
        UserInfoContact userInfoContact = UserInfoContractMapper.INSTANCE.apply(userInfoContactDto);
        UserInfoContact saveUserInfo = userInfoContactRepository.save(userInfoContact);
        return UserInfoContractDtoMapper.INSTANCE.apply(saveUserInfo);
    }

    @Override
    public List<UserInfoContactDto> getAllUsersInfo() {
        List<UserInfoContact> listsUsersInfo = userInfoContactRepository.findAll();
        return listsUsersInfo.stream().map( users -> UserInfoContractDtoMapper.INSTANCE.apply(users)).collect(Collectors.toList());
    }
}
