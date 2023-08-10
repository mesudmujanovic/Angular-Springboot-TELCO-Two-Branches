package com.Digital.Digital.Controllers.UserController;

import com.Digital.Digital.Infrastructure.Dto.UserDto.UserInfoContactDto;
import com.Digital.Digital.Infrastructure.Request.UserRequest.UserInfoContact.UserInfoContactRequest;
import com.Digital.Digital.Infrastructure.Response.UserResponse.UserInfoContact.UserInfoContactResponse;
import com.Digital.Digital.Service.UserService.UserInfoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class UserInfoController {

    @Autowired
    UserInfoContractService userInfoContractService;

    @PostMapping("/usersInfo")
    public ResponseEntity<UserInfoContactResponse> saveInfo(@Valid @RequestBody UserInfoContactRequest userInfoContactRequest){
        UserInfoContactDto userInfoContactDto = UserInfoContactDto.reqeustToDto(userInfoContactRequest);
        UserInfoContactDto userInfoContactDtoSave = userInfoContractService.getUserInfo(userInfoContactDto);
        return ResponseEntity.ok(UserInfoContactDto.dtoToResponse(userInfoContactDtoSave));
    }

    @GetMapping("/getAllInfo")
    public ResponseEntity<List<UserInfoContactResponse>> getAllInfo(){
        List<UserInfoContactDto> userInfoContactList = userInfoContractService.getAllUsersInfo();
        return ResponseEntity.ok( userInfoContactList.stream().map(UserInfoContactDto::dtoToResponse).collect(Collectors.toList()));
    }
}

