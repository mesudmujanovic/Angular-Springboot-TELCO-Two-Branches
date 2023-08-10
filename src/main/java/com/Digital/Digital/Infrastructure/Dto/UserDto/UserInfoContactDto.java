package com.Digital.Digital.Infrastructure.Dto.UserDto;

import com.Digital.Digital.Infrastructure.Request.UserRequest.UserInfoContact.UserInfoContactRequest;
import com.Digital.Digital.Infrastructure.Response.UserResponse.UserInfoContact.UserInfoContactResponse;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserInfoContactDto {

    private Long id;


    private String name;

    private String lastName;


    private String email;

    private String phone;

    public static UserInfoContactDto reqeustToDto(UserInfoContactRequest infoContactRequest){
        UserInfoContactDto userInfoContactDto = new UserInfoContactDto();
        userInfoContactDto.setEmail(infoContactRequest.getEmail());
        userInfoContactDto.setName(infoContactRequest.getName());
        userInfoContactDto.setPhone(infoContactRequest.getPhone());
        userInfoContactDto.setLastName(infoContactRequest.getLastName());
        return userInfoContactDto;
    };

    public static UserInfoContactResponse dtoToResponse(UserInfoContactDto userDto){
        UserInfoContactResponse response = new UserInfoContactResponse();
        response.setId(userDto.getId());
        response.setEmail(userDto.getEmail());
        response.setPhone(userDto.getPhone());
        response.setLastName(userDto.getLastName());
        response.setName(userDto.getName());
        return response;
    }
}
